import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Beschreiben Sie hier die Klasse LinkFilter.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class LinkFilter
{
    private  BufferedReader reader;

    private int anzahlZeilen = 0;
    
    private String regex = ".*http://.*";
    
    /**
     * Konstruktor für Objekte der Klasse LinkFilter
     */
    public LinkFilter()
    {
        reader = new BufferedReader(new InputStreamReader(System.in));   
    
    
    }

    public void leseDateiEin() {
        String x = null;
        try{
             while( (x = reader.readLine()) != null )
             {
                System.out.println(x);
                boolean matchFound = Pattern.matches(regex, x);
                 if (matchFound) {
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
