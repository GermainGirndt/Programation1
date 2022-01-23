
/**
 * Beschreiben Sie hier die Klasse PersonQueue.
 * 
 * @author Germain, Girndt; Krier, Katharina
 * @version 1.0
 * 
 */
public class PersonQueue extends AbstractQueue implements Queue {

    public StringQueue(int size) {

        Person[] queue = new Person[size];
        
        super.setQueue(queue);
    
    }
    
}
