import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Beschreiben Sie hier die Klasse LinkFilter.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class LinkFilter
{
    private  BufferedReader reader;

    private int anzahlZeilen = 0;
    

    //private String regex = "<a\s*(\w*=".*")*\s*href="((https?:\/\/)?(www\.)?[\w()@:%.\+~#=]{1,256}\.[\w\d]{1,6}\b([-\w()@:%\+.~#?&\/=]*))"\s*(\w*=".*")*\s*>.*<\/a>";

    private String regexAnchorTagStart = "<a\\s*(\\w*=\".*\")*\\s*";

    private String regexLink = "((https?:\\/\\/)?(www\\.)?[\\w()@:%.\\+~#=]{1,256}\\.[\\w\\d]{1,6}\\b([-\\w()@:%\\+.~#?&\\/=]*))";

    private String href = "href=\"" + regexLink + "\"";

    private String regexAfterHref = "\\s*(\\w*=\".*\")*\\s*>";

    private String regexLinkDescription = ".*";

    private String regexAnchorTagEnd = "<\\/a>";

    //private String regex = regexAnchorTagStart + href + regexAfterHref + regexLinkDescription + regexAnchorTagEnd;
    private String regex = regexAnchorTagStart;

    
    /**
     * Konstruktor für Objekte der Klasse LinkFilter
     */
    public LinkFilter()
    {
        reader = new BufferedReader(new InputStreamReader(System.in));   
    
    
    }

    public void pruefeHtmlZeile(String html){
    
        boolean matchFound = Pattern.matches(href, html);
        if(matchFound) {
                     //nur zum testen
            System.out.println("Match found");
        } else {
                    //nur zum testen
            System.out.println("Match not found");
         }
    }
    
    
    public void leseDateiEin(){
        String htmlLine = null;
        try{
             while( (htmlLine = reader.readLine()) != null )
             {

                System.out.println(regex);
                System.out.println(htmlLine);
                boolean matchFound = htmlLine.matches(regex);

                 if(matchFound) {
                     //nur zum testen
                      System.out.println("Match found");
                } else {
                    //nur zum testen
                      System.out.println("Match not found");
                }
                  anzahlZeilen++;
             }
           }
    
        catch (IOException e) {
            System.err.println(e);
        }
    }
    
    public static void main(String[] args) {
       LinkFilter r = new LinkFilter();
       r.leseDateiEin();
    }
}
