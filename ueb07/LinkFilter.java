import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Beschreiben Sie hier die Klasse LinkFilter.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class LinkFilter {
    private BufferedReader reader;

    private int anzahlZeilen = 0;

    // "<a\s*(\w*=".*")*\s*href="((https?:\/\/)?(www\.)?[\w()@:%.\+~#=]{1,256}\.[\w\d]{1,6}\b([-\w()@:%\+.~#?&\/=]*))"\s*(\w*=".*")*\s*>.*<\/a>";

    private String regexAnchorTagStart = "<a\\s*(\\w*=\".*\")*\\s*";
    private String regexLink = "((https?:\\/\\/)?(www\\.)?[\\w()@:%.\\+~#=]{1,256}\\.[\\w\\d]{1,6}\\b([-\\w()@:%\\+.~#?&\\/=]*))";
    private String href = "href=\"" + regexLink + "\"";
    private String regexNachHref = "\\s*(\\w*=\".*\")*\\s*>";

    private String regexAnchorTagOeffnung = regexAnchorTagStart + href + regexNachHref;
    private String regexLinkDescription = ".*";
    private String regexAnchorTagSchluss = "<\\/a>";

    private String regex = regexAnchorTagOeffnung + regexLinkDescription + regexAnchorTagSchluss;

    /**
     * Konstruktor für Objekte der Klasse LinkFilter
     */
    public LinkFilter() {
        reader = new BufferedReader(new InputStreamReader(System.in));

    }

    public void pruefeHtmlZeile(String htmlLine) {

        Pattern regexPattern = Pattern.compile(regex);
        Matcher matcher = regexPattern.matcher(htmlLine);
        boolean matchFound = matcher.find();
        if (matchFound) {
            // nur zum testen
            System.out.println("Match found");
        } else {
            // nur zum testen
            System.out.println("Match not found");
        }
    }

    public void leseDateiEin() {
        try {
            String htmlLine = reader.readLine();
            while (htmlLine != null) {
                System.out.println(htmlLine);

                pruefeHtmlZeile(htmlLine);

                htmlLine = reader.readLine();
            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        LinkFilter r = new LinkFilter();
        r.leseDateiEin();
    }
}
