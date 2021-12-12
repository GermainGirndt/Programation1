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
    private String href = "href=\"((https?:\/\/)?(www\.)?[\w()@:%.\+~#=]{1,256}\.[\w\d]{1,6}\b([-\w()@:%\+.~#?&\/=]*))";
    
    /**
     * Konstruktor für Objekte der Klasse LinkFilter
     */
    public LinkFilter()
    {
        reader = new BufferedReader(new InputStreamReader(System.in));   
    
    
    }

    public void leseDateiEin(){
        String x = null;
        try{
             while( (x = reader.readLine()) != null )
             {
                System.out.println(x);
                boolean matchFound = Pattern.matches(regex, x);
                 if(matchFound) {
                      System.out.println("Match found");
                } else {
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
