import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Beschreiben Sie hier die Klasse DoppeltVerkettetListeDialog.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class DoppeltVerkettetListeDialog
{
    private Scanner input;
    private int funktion;
    
    private static final int FUNKTION_NICHT_DEFINIERT        = -1;
    private static final int FUNKTION_ENDE                   = 0;
    private static final int FUNKTION_LISTE_ANLEGEN          = 1;
    private static final int FUNKTION_GROESSE                = 2;
    private static final int FUNKTION_LEER                   = 3;
    private static final int FUNKTION_CONTAINS               = 4;
    private static final int FUNKTION_TOARRAY                = 5;
    private static final int FUNKTION_ADD                    = 6;
    private static final int FUNKTION_REMOVE_OBJECT          = 7;
    private static final int FUNKTION_ADDALL                 = 8;
    private static final int FUNKTION_CLEAR                  = 9;
    private static final int FUNKTION_GET                    = 10;
    private static final int FUNKTION_SET                    = 11;
    private static final int FUNKTION_ADD_AT_INDEX           = 12;
    private static final int FUNKTION_REMOVE_AT_INDEX        = 13;
    private static final int FUNKTION_INDEXOFF               = 14;
    
    /**
     * Konstruktor für Objekte der Klasse DoppeltVerkettetListeDialog
     */
    public DoppeltVerkettetListeDialog()
    {
        this.input = new Scanner(System.in);       
    }

      public static void main(String[] args) {
        DoppeltVerkettetListeDialog dialog = new DoppeltVerkettetListeDialog();
        dialog.start();
        
    }
    
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
                input.next();

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
    private void einlesenFunktion() {
     
    
        System.out.print(
            "\n\n" +
            FUNKTION_LISTE_ANLEGEN         + ": Liste anlegen;\n"  + 
            FUNKTION_GROESSE               + ": Groesse ausgeben;\n" +
            FUNKTION_LEER                  + ": Auf Leer pruefen;\n"  + 
            FUNKTION_CONTAINS              + ": Pruefen ob Element enthalten ist;\n" +
            FUNKTION_TOARRAY               + ": Liste als Array ausgeben;\n" +
            FUNKTION_ADD                   + ": Object hinzufuegen;\n" +
            FUNKTION_REMOVE_OBJECT         + ": Object entfernen;\n"  + 
            FUNKTION_ADDALL                + ": Add all Objects;\n" +
            FUNKTION_CLEAR                 + ": Clear List;\n" +
            FUNKTION_GET                   + ": Object an Listenindex holen;\n"  + 
            FUNKTION_SET                   + ": Object an Listenindex setzen;\n" +
            FUNKTION_ADD_AT_INDEX          + ": Object an Listenindex hinzufuegen;\n" +
            FUNKTION_REMOVE_AT_INDEX       + ": Object an Listenindex entfernen;\n" +
            FUNKTION_INDEXOFF              + ": Listenindex von Object finden;\n" +
            FUNKTION_ENDE                  + ": beenden -> \n\n" 
        );
        
        System.out.println("Ausgewählte Funktion: ");
        this.funktion = input.nextInt();
        input.nextLine();
        System.out.println();
    }
    
    /**
    * Diese Funktion fuehrt je nach Parameter die dazugehoerige Funktion aus
    * @param funktion die ausgefuehrt werden soll
    */
    private void ausfuehrenFunktion() {
        switch(this.funktion) {
            case  FUNKTION_LISTE_ANLEGEN:
                
                break;  
            case FUNKTION_GROESSE:
                
                break;  
            case FUNKTION_LEER:
                ;
                break;  
            case FUNKTION_CONTAINS:
            
                break;
            case FUNKTION_TOARRAY:
            
                break;
            case FUNKTION_ADD:
            
                break;   
            case FUNKTION_REMOVE_OBJECT:
            
                break; 
            case FUNKTION_ADDALL:
            
                break;  
            case FUNKTION_CLEAR:
            
                break; 
            case FUNKTION_GET:
            
                break;  
            case FUNKTION_SET:
            
                break;  
            case FUNKTION_ADD_AT_INDEX:
            
                break;  
            case FUNKTION_REMOVE_AT_INDEX:
            
                break; 
            case FUNKTION_INDEXOFF:
            
                break;  
            case FUNKTION_ENDE:  
                System.out.println("Das Programm ist zu Ende");
                break;
            default:
                System.out.println("Keine gueltige Eingabe");
                break;
            }
            
        }
}
