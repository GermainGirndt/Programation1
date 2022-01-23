
/**
 * Beschreiben Sie hier die Klasse StringQueue.
 * 
 * @author Germain, Girndt; Krier, Katharina
 * @version 1.0
 * 
 */
public class StringQueue extends AbstractQueue implements Queue {
   
   public StringQueue(int size) {

    String[] queue = new String[size];
    
    super.setQueue(queue);

   }
}