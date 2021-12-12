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

    // private String regex =
    // "<a\s*(\w*=".*")*\s*href="((https?:\/\/)?(www\.)?[\w()@:%.\+~#=]{1,256}\.[\w\d]{1,6}\b([-\w()@:%\+.~#?&\/=]*))"\s*(\w*=".*")*\s*>.*<\/a>";
    private String regexAnchorTagStart = "<a\\s*(\\w*=\".*\")*\s*";

    private String regexLink = "((https?:\\/\\/)?(www\\.)?[\\w()@:%.\\+~#=]{1,256}\\.[\\w\\d]{1,6}\\b([-\\w()@:%\\+.~#?&\\/=]*))";

    private String href = "href=\"" + regexLink + "\"";

    private String regexAfterHref = "\\s*(\\w*=\".*\")*\\s*>";

    private String regexLinkDescription = ".*";

    private String regexAnchorTagEnd = "<\\/a>";

    // private String regex = regexAnchorTagStart + href + regexAfterHref +
    // regexLinkDescription + regexAnchorTagEnd;
    private String regex = regexAnchorTagStart;

    /**
     * Konstruktor für Objekte der Klasse LinkFilter
     */
    public LinkFilter() {
        reader = new BufferedReader(new InputStreamReader(System.in));

    }

    public void leseDateiEin() {
        try {
            Pattern regexPattern = Pattern.compile(regex);

            String htmlLine = reader.readLine();
            while (htmlLine != null) {
                System.out.println(htmlLine);
                Matcher matcher = regexPattern.matcher(htmlLine);
                boolean matchFound = matcher.find();

                if (matchFound) {
                    System.out.println("Match found");
                } else {
                    System.out.println("Match not found");
                }
                anzahlZeilen++;
                
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
