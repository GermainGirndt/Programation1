import java.util.InputMismatchException;

/**
 * Beschreiben Sie hier die Klasse QueueDialog.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class QueueDialog
{

    private              Queue          queue;
    private              UserInput      userInput;
    private              int            funktion;
    
    private static final int            FUNKTION_NICHT_DEFINIERT       = -1;
    private static final int            FUNKTION_ENDE                  =  0;
    private static final int            FUNKTION_STRING_QUEUE_ANLEGEN  =  1;
    private static final int            FUNKTION_PERSON_QUEUE_ANLEGEN  =  2;
    private static final int            FUNKTION_ELEMENT_HINZUFUEGEN   =  3;
    private static final int            FUNKTION_ERSTES_ELEMENT_HOLEN  =  4;
    private static final int            FUNKTION_GROESSE               =  5;
    private static final int            FUNKTION_LEER                  =  6;
    private static final int            FUNKTION_VOLL                  =  7;
    private static final int            FUNKTION_GET_NACH_POSITION     =  8;


    
    
    /**
    * Konstruktor
    */
    public QueueDialog() {
        userInput = new UserInput();
    }
    
    public static void main(String[] args) {
        QueueDialog queuedialog = new QueueDialog();
        queuedialog.start();
        
    }

    /**
    * Hauptschleife der Queuedialog Klasse
    */
    public void start() {
        this.queue         = null;
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
            FUNKTION_STRING_QUEUE_ANLEGEN    + ": Stringqueue anlegen;\n"               + 
            FUNKTION_PERSON_QUEUE_ANLEGEN    + ": Personqueue anlegen;\n"               + 
            FUNKTION_ELEMENT_HINZUFUEGEN     + ": Elemenent an Queue anhaengen;\n"      +
            FUNKTION_ERSTES_ELEMENT_HOLEN    + ": Erstes Element rausholen;\n"          + 
            FUNKTION_GROESSE                 + ": Groesse der Queue;\n"                 +
            FUNKTION_LEER                    + ": Pruefen ob Queue leer;\n"             + 
            FUNKTION_VOLL                    + ": Pruefen ob Queue voll;\n"             +
            FUNKTION_GET_NACH_POSITION       + ": GetElement nach Position in Queue\n;" +
            FUNKTION_ENDE                    + ": beenden -> \n\n"
        );
        
        this.funktion = userInput.getInt("Ausgewaehlte Funktion: ");
        System.out.println();
    }
    
    /**
    * Diese Funktion fuehrt je nach Parameter die dazugehoerige Funktion aus
    * @param funktion die ausgefuehrt werden soll
    */
    public void ausfuehrenFunktion() {
        boolean sollNachBestandFragen;

        switch(this.funktion) {
           
            case FUNKTION_ENDE:  
                System.out.println("Das Programm ist zu Ende");
                break;
            default:
                System.out.println("Keine gueltige Eingabe");
                break;
        }

       
    }
    
    
}


