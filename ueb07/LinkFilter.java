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

    // "<a\s*(\w*=".*")*\s*href="((https?:\/\/)?(www\.)?[\w()@:%.\+~#=]{1,256}\.[\w\d]{1,6}\b([-\w()@:%\+.~#?&\/=]*))"\s*(\w*=".*")*\s*>.*<\/a>";

    private String regexAnchorTagStart = "<a\\s*(\\w*=\".*\")*\\s*";
    private String regexLink = "((https?:\\/\\/)?(www\\.)?[\\w()@:%.\\+~#=]{1,256}\\.[\\w\\d]{1,6}\\b([-\\w()@:%\\+.~#?&\\/=]*))";
    private String href = "href=\"" + regexLink + "\"";
    private String regexNachHref = "\\s*(\\w*=\".*\")*\\s*>";

    private String regexAnchorTagOeffnung = regexAnchorTagStart + href + regexNachHref;
    private String regexLinkDescription = "(.*)";
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

            String inhalt = matcher.group(INHALT_REGEX_GROUP_NUMMER);
            String url = matcher.group(URL_REGEX_GROUP_NUMMER);
            int anzahlZeichen = url.length();

            System.out.println(String.format("%s:\t%s, Anzahl Zeichen: %d", inhalt, url, anzahlZeichen));
            gefundeneLinks++;
        } 
    }

    public void leseDateiEin() {
        try {
            String htmlLine = reader.readLine();
            while (htmlLine != null) {
                pruefeHtmlZeile(htmlLine);

                htmlLine = reader.readLine();
                geleseneZeilen++;
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
