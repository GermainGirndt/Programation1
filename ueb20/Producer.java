import java.util.Random;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Beschreiben Sie hier die Klasse Producer.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Producer
{
    Random ran;
    Queue<Integer> queue;
    
    /**
     * Konstruktor für Objekte der Klasse Producer
     */
    public Producer()
    {
        ran = new Random(); 
        queue = new LinkedList<>();
    }

    public Integer produce(){
        int zahl = ran.nextInt(1000);
        queue.add(zahl);
        return zahl;
    }
    
    public Integer getFirstInteger(){
        return queue.poll();
    }
   
}
