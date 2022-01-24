
/**
 * Beschreiben Sie hier die Klasse StringQueue.
 * 
 * @author Germain, Girndt; Krier, Katharina
 * @version 1.0
 * 
 */
public class StringQueue extends AbstractQueue implements Queue {
   
    
    /**
    * Konstruktor StringQueue
    * @param size die Groesse
    */
   public StringQueue(int size) {
    super(String.class, size);
   }
}