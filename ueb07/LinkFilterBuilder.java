import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Builder-Klasse fuer Regex-Patterns und Messages, die angezeigt werden koennen
 * In der Zukunuft sollten diese beiden Verantwortungen weiter aufgeteilt werden
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class LinkFilterBuilder {

    public static String TEMPLATE_LINK_MESSAGE = "%s:\t%s, Anzahl Zeichen: %d";
    
    private static int URL_REGEX_GROUP_NUMMER = 2;
    private static int INHALT_REGEX_GROUP_NUMMER = 7;
    private static String KEIN_INHALT_MESSAGE = "KEIN INHALT";

    /**
     * Bildet die LinkMessage, die angezeigt wird
     */
    public static String bildeLinkMessage(Matcher matcher) {
        String inhalt = matcher.group(LinkFilterBuilder.INHALT_REGEX_GROUP_NUMMER);
        inhalt = inhalt != LinkFilterKonstante.LEER_STRING ? inhalt : LinkFilterBuilder.KEIN_INHALT_MESSAGE; 

        String url = matcher.group(LinkFilterBuilder.URL_REGEX_GROUP_NUMMER);
        int anzahlZeichen = url.length();

        String message = String.format(TEMPLATE_LINK_MESSAGE, inhalt, url, anzahlZeichen);

        return message;
    }

    /**
     * Bildet den Regex Pattern, der als Filter für den Anchortag verwendet wird
     */
    public static Pattern bildeRegexPatternFuerAnchorTag() {
        String anchorTagRegex = bildeRegexPatternStringFuerAnchorTag();

        Pattern anchorTagRegexPattern = Pattern.compile(anchorTagRegex);

        return anchorTagRegexPattern;

    }

    /**
     * Bildet den Regex String, der als Filter für den Anchortag verwendet wird
     */
    private static String bildeRegexPatternStringFuerAnchorTag() {
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

        String anchorTagRegex = regexAnchorTagOeffnung + regexURLInhalt + regexAnchorTagSchluss;

        return anchorTagRegex;
    
    }


}
