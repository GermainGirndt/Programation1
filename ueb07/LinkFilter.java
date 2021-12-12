import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Beschreiben Sie hier die Klasse LinkFilter.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class LinkFilter {
    private BufferedReader reader;
    
    private int geleseneZeilen;
    private int gefundeneLinks;

    private int URL_REGEX_GROUP_NUMMER = 2;
    private int INHALT_REGEX_GROUP_NUMMER = 7;

    private String anchorTagRegex;

    private String KEIN_INHALT_MESSAGE = "KEIN INHALT";

    private Pattern regexPattern;

    /**
     * Konstruktor für Objekte der Klasse LinkFilter
     */
    public LinkFilter() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.bildeRegexFuerAnchorTag();
        this.regexPattern = Pattern.compile(anchorTagRegex);
    }

    /**
     * Bildet den Regex String, der als Filter für den Anchortag verwendet wird
     */
    public static void main(String[] args) {
        LinkFilter linkFilter = new LinkFilter();
        linkFilter.zeigeAngabenAn();
    }

    /**
     * Sucht in einer HTML-Datei nach gueltige Links in Anchor-Tags
     * Die Vorkommnisse werden dann angezeigt
     */
    public void zeigeAngabenAn() {
        try {
            String htmlZeile = this.reader.readLine();

            while (htmlZeile != null) {
                String message = extrahiereLinkMessageVonDerHtmlZeile(htmlZeile);

                LinkFilterOutput.gibAusZeilemessage(message);

                geleseneZeilen++;
                htmlZeile = this.reader.readLine();
            }

            LinkFilterOutput.gibAusEndmessage(gefundeneLinks, geleseneZeilen);

        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    public String extrahiereLinkMessageVonDerHtmlZeile(String htmlZeile) {
        String message = "";
        Matcher matcher = this.regexPattern.matcher(htmlZeile);
        boolean matchFound = matcher.find();

        if (matchFound) {
            message = this.bildeLinkMessage(matcher);

            gefundeneLinks++;
        }

        return message;
    }

    private String bildeLinkMessage(Matcher matcher) {
        String inhalt = matcher.group(INHALT_REGEX_GROUP_NUMMER);
        inhalt = inhalt != LinkFilterKonstante.LEER_STRING ? inhalt : this.KEIN_INHALT_MESSAGE; 

        String url = matcher.group(URL_REGEX_GROUP_NUMMER);
        int anzahlZeichen = url.length();

        String message = String.format("%s:\t%s, Anzahl Zeichen: %d", inhalt, url, anzahlZeichen);

        return message;
    }



    /**
     * Bildet den Regex String, der als Filter für den Anchortag verwendet wird
     */
    private void bildeRegexFuerAnchorTag() {
        /**
         * folgende optionale Bedindung werden akzeptiert:
         * beliebige Anzahl an Leertasten geben
         * andere Attribute (es wird nicht nach Gueltigkeit geprueft, denn ungultige
         * Attribute können gültige Anchor-Tags generieren)
         * beliebige Anzahl an Leertasten geben [2]
         */
        String leerTastenMitAttributen = "\\s*(\\w*=\".*\")*\\s*";

        /**
         * Der URL darf mit/ohne http(s) anfangen
         * Darf www. haben
         * der Second-Level-Domain und die Subdomains müssen von 1 bis 256 Zeichen
         * enthalten (ink. einige Sonderzeichen)
         * der Top-Level-Domain muss von 1 bis 6 Zeichen enthalten
         * Es werden auch Subdirectories mit verschiedene Sonderzeichen akzeptiert
         * Inspiriert von:
         * https://blog.hubspot.com/marketing/parts-url
         * https://stackoverflow.com/questions/3809401/what-is-a-good-regular-expression-to-match-a-url
         */
        String sonderzeichen = "\\w()\\-@:%.\\+~#=";
        String regexURL = "((https?:\\/\\/)?(www\\.)?[" + sonderzeichen + "]{1,256}\\.[\\w\\d]{1,6}\\b(["
                + sonderzeichen + "?&\\/]*))";

        /**
         * Der URL wird zwischen die href Attribute gestellt
         */
        String regexAnchorTagOeffnung = "<a" + leerTastenMitAttributen + "href=\"" + regexURL + "\""
                + leerTastenMitAttributen + ">";
        String regexURLInhalt = "(.*)";
        String regexAnchorTagSchluss = "<\\/a>";

        this.anchorTagRegex = regexAnchorTagOeffnung + regexURLInhalt + regexAnchorTagSchluss;
    }
}
