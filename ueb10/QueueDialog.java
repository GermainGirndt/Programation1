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


    private static final String         FEHLER_NULL_QUEUE              = "Es existiert noch keine Queue!";
    private static final String         FEHLER_EXIST_QUEUE             = "Es existiert schon eine Queue!";
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
            FUNKTION_GET_NACH_POSITION       + ": GetElement nach Position in Queue;\n" +
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
            case FUNKTION_STRING_QUEUE_ANLEGEN:
                legeStringQueueAn();
                break;
            case FUNKTION_PERSON_QUEUE_ANLEGEN:
                legePersonQueueAn();
                break;
            case FUNKTION_ELEMENT_HINZUFUEGEN:
                elementHinzufuegen();
                break;
            case FUNKTION_ERSTES_ELEMENT_HOLEN:
                elementHolen();
                break;
            case FUNKTION_GROESSE:
                gibGroesseaus();
                break;
            case  FUNKTION_LEER:
                pruefeLeer();
                break;
            case FUNKTION_VOLL:
                pruefeVoll();
                break;
            case FUNKTION_GET_NACH_POSITION:
                getElementNachPosition();
                break;
            case FUNKTION_ENDE:  
                System.out.println("Das Programm ist zu Ende");
                break;
            default:
                System.out.println("Keine gueltige Eingabe");
                break;
        }

       
    }
    
    private void elementHolen(){
        if(queue == null){
            throw new IllegalArgumentException(FEHLER_NULL_QUEUE);   
        }  
        System.out.println("Entfernt: " + queue.removeFirst());
        
    }
    
    private void elementHinzufuegen(){
        if(queue == null){
            throw new IllegalArgumentException(FEHLER_NULL_QUEUE);   
        }  
        if(queue instanceof StringQueue){
            String s = userInput.getString("String: ");    
            
            queue.addLast(s);
        }
        
        if(queue instanceof PersonQueue){
            String vorname  = userInput.getString("Vorname: ");    
            String nachname = userInput.getString("Nachname: ");   
            Person p = new Person(vorname, nachname);
            queue.addLast(p);
        }
        
        System.out.println("Element hinzugefuegt.");
    }
    
    
    private void gibGroesseaus(){
        if(queue == null){
          throw new IllegalArgumentException(FEHLER_NULL_QUEUE);   
        }
        System.out.println("Groesse: " + queue.size());
    }
    
     private void pruefeLeer(){
        if(queue == null){
          throw new IllegalArgumentException(FEHLER_NULL_QUEUE);   
        }
        System.out.println("istLeer: " + queue.empty());
    }
    
    private void pruefeVoll(){
        if(queue == null){
          throw new IllegalArgumentException(FEHLER_NULL_QUEUE);   
        }
        System.out.println("istVoll: " + queue.full());
    }
    
    private void getElementNachPosition(){
        if(queue == null){
          throw new IllegalArgumentException(FEHLER_NULL_QUEUE);   
        }
        
        int platz = userInput.getInt("Ausgewaehlter Platz: ");
        System.out.println(queue.get(platz));
    }
    
    private void legeStringQueueAn(){
        if(queue != null){
          throw new IllegalArgumentException(FEHLER_EXIST_QUEUE);   
        } 
        int size = userInput.getInt("Groesse: ");
        this.queue = new StringQueue(size);
        System.out.println("StringQueue wurde angelegt.");
    }
    
    private void legePersonQueueAn(){
        if(queue != null){
          throw new IllegalArgumentException(FEHLER_EXIST_QUEUE);   
        } 
        int size = userInput.getInt("Groesse: ");
        this.queue = new PersonQueue(size);
        System.out.println("PersonQueue wurde angelegt.");
    }
}


