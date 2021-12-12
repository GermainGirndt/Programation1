import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Beschreiben Sie hier die Klasse LinkFilterDialog.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class LinkFilterDialog
{
    private              LinkFilter     linkFilter;
    private              int            funktion;
    private              UserInput      userInput;
    
    private static final int            FUNKTION_NICHT_DEFINIERT       = -1;
    private static final int            FUNKTION_ENDE                  =  0;
    private static final int            FUNKTION_HTML_PRUEFEN          =  1;
    
    public LinkFilterDialog(){
        userInput  = new UserInput();
        linkFilter = new LinkFilter();
    }
    
     public static void main(String[] args) {
        LinkFilterDialog linkFinderDialog = new LinkFilterDialog();
        linkFinderDialog.start();
        
    }

    /**
    * Hauptschleife der LinkFilterDialog Klasse
    */
    public void start() {
        this.funktion        = FUNKTION_NICHT_DEFINIERT;
        
        while(this.funktion != FUNKTION_ENDE) {
            try {
                einlesenFunktion();
                ausfuehrenFunktion();
                
            } catch(IllegalArgumentException error) {
                System.err.println(error);

            } catch(InputMismatchException error) {
                System.err.println(error);
                userInput.next();

            } catch(Exception error) {
                System.err.println(error);
                error.printStackTrace(System.out); 

            }
        }
    }
    
    /**
    * Diese Funktion liest ein welche Funktion ausgefuehrt werden soll
    * @return funktion die ausgewaehlt wurde
    */
    public void einlesenFunktion() {
        
        System.out.print(
            "\n\n" +
            FUNKTION_HTML_PRUEFEN           + ": html-Text vom Link-Filter ueberpruefen lassen;\n"  + 
            FUNKTION_ENDE                   + ": beenden -> \n\n"
        );
        
        this.funktion = userInput.getInt("Ausgewählte Funktion: ");
        System.out.println();
    }
    
    /**
    * Diese Funktion führt je nach Parameter die dazugehoerige Funktion aus
    * @param funktion die ausgeführt werden soll
    */
    public void ausfuehrenFunktion() {
        switch(this.funktion) {
            case FUNKTION_HTML_PRUEFEN:
                ausHtmlLinksFiltern();
                break;
            case FUNKTION_ENDE:  
                System.out.println("Das Programm ist zu Ende");
                break;
            default:
                System.out.println("Keine gueltige Eingabe");
                break;
        }

    }
    
    public void  ausHtmlLinksFiltern(){
        String html ="";
        while(!html.equals("0")){
            //0 fuer abbruch
            html = this.userInput.nextLine(); 
            if(!html.equals("0")){
                linkFilter.pruefeHtmlZeile(html);    
            }
            
        }
        
    }
}
