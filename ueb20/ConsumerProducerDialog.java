import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Collection;


/**
 * Beschreiben Sie hier die Klasse ConsumerProducerDialog.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class ConsumerProducerDialog
{
    private Scanner input;
    private int funktion;
    private Consumer consumer;
    private Producer producer;
    
    private static final int FUNKTION_NICHT_DEFINIERT        = -1;
    private static final int FUNKTION_ENDE                   = 0;
    private static final int FUNKTION_PRODUCE                = 1;
    private static final int FUNKTION_PRODUCE_100            = 2;
    private static final int FUNKTION_CONSUME_FIRST          = 3;
    private static final int FUNKTION_CONSUME_ALL            = 4;
    private static final int FUNKTION_PRODUCE_CONSUME_RANDOM = 5;
    private static final int FUNKTION_NUMBER_RESULTS         = 6;
    private static final int FUNKTION_GET_QUERSUMME_ASC      = 7;
    private static final int FUNKTION_GET_QUERSUMME_DESC     = 8;
    private static final int FUNKTION_OCCURENCES             = 9;
    private static final int FUNKTION_TIMESTAMPS             = 10;
    
    /**
     * Konstruktor für Objekte der Klasse ConsumerProducerDialog
     */
    public ConsumerProducerDialog()
    {
         this.input = new Scanner(System.in);   
         consumer   = new Consumer();
         producer   = new Producer();
    }

     public static void main(String[] args) {
        ConsumerProducerDialog dialog = new ConsumerProducerDialog();
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
    
        private void einlesenFunktion() {
        
        System.out.print(
            "\n\n" +
            FUNKTION_PRODUCE                + ": Produce Integer (1 mal);;\n" +
            FUNKTION_PRODUCE_100            + ": Produce Integer (100 mal);;\n" +
            FUNKTION_CONSUME_FIRST          + ": Consume den ersten Integer in der Queue;;\n" +
            FUNKTION_CONSUME_ALL            + ": Consume alles;;\n" +
            FUNKTION_PRODUCE_CONSUME_RANDOM + ": Produce und Consume random;;\n" +
            FUNKTION_NUMBER_RESULTS         + ": Anzahl verschiedener Ergebnisse;;\n" +
            FUNKTION_GET_QUERSUMME_ASC      + ": Quersummen aufsteigend sortiert ausgeben;;\n" +
            FUNKTION_GET_QUERSUMME_DESC     + ": Quersummen absteigend sortiert ausgeben;;\n" +
            FUNKTION_OCCURENCES             + ": Haeufigkeit einer Quersumme;;\n" + 
            FUNKTION_TIMESTAMPS             + ": Timestamps einer Quersumme;;\n" + 
            FUNKTION_ENDE                   + ": beenden -> \n\n" 
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
        Integer zahl;
        switch(this.funktion) {
            case FUNKTION_PRODUCE:
                System.out.println("Producer hat die Zahl " + producer.produce() + " produziert");
                break;
            case FUNKTION_PRODUCE_100:
                for(int i=0;i<100;i++){
                    System.out.println("Producer hat die Zahl " + producer.produce() + " produziert");    
                }
                break;
            case FUNKTION_CONSUME_FIRST:
                zahl = producer.getFirstInteger();
                if(zahl != null){
                    System.out.println("Consumer konsumiert: " + zahl + " Quersumme: " + consumer.consume(zahl) );    
                }
                break;  
            case FUNKTION_CONSUME_ALL:
                zahl = producer.getFirstInteger();
                while(zahl!=null){
                     System.out.println("Consumer konsumiert: " + zahl + " Quersumme: " + consumer.consume(zahl) );    
                     zahl = producer.getFirstInteger();
                }
                break; 
            case  FUNKTION_PRODUCE_CONSUME_RANDOM:
                Random ran = new Random();
                for(int i = 0; i<10000; i++)
                {
                if(ran.nextInt(2) > 0 ){
                     System.out.println("Producer hat die Zahl " + producer.produce() + " produziert");        
                }
                else{
                    zahl = producer.getFirstInteger();
                    if(zahl != null){
                        System.out.println("Consumer konsumiert: " + zahl + " Quersumme: " + consumer.consume(zahl) );    
                    }    
                }
                }
                break;
            case  FUNKTION_NUMBER_RESULTS:
                System.out.println("Anzahl verschiedener Ergebnisse: " + consumer.numberOfDifferentResults());
                break;
            case FUNKTION_GET_QUERSUMME_ASC:
                System.out.println(consumer.getCrossTotalsAscending());
                break;
            case FUNKTION_GET_QUERSUMME_DESC:
                System.out.println(consumer.getCrossTotalsDescending());
                break;
            case FUNKTION_OCCURENCES:
                System.out.println("Welche Quersumme soll ueberprueft werden?");
                int qocc = input.nextInt();
                input.nextLine();
                System.out.println("Die Quersumme " + qocc + " wurde " + consumer.numberOfOccurrences(qocc) + " berechnet");
                break;
            case FUNKTION_TIMESTAMPS:
                System.out.println("Welche Quersumme soll ueberprueft werden?");
                int qtimestamps = input.nextInt();
                input.nextLine();
                Collection<Quersumme> quersummen = consumer.getTimestampsForResult(qtimestamps);
                for(Quersumme q : quersummen){
                    System.out.println(q);
                }
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
