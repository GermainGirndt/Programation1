import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Filtert Dateien in HTML-Syntax für Links in Anchor-Tags
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class LinkFilter {
    private BufferedReader reader;
    
    private int geleseneZeilen;
    private int gefundeneLinks;

    private Pattern regexPattern;

    /**
     * Konstruktor für Objekte der Klasse LinkFilter
     */
    public LinkFilter() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));

        this.regexPattern = LinkFilterBuilder.bildeRegexPatternFuerAnchorTag(); 
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

        } catch (IOException error) {
            System.err.println(error);
        }
    }
    
    /**
     * Diese Methode benutzt den PatternMatcher, um AnchorTags mit Links zu finden
     * Sollte es match vorkommen, wird die entsprechende Message gebildet
     */
    public String extrahiereLinkMessageVonDerHtmlZeile(String htmlZeile) {
        String message = "";
        Matcher matcher = this.regexPattern.matcher(htmlZeile);
        boolean matchFound = matcher.find();

        if (matchFound) {
            message = LinkFilterBuilder.bildeLinkMessage(matcher);

            gefundeneLinks++;
        }

        return message;
    }
    

}
