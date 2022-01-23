
/**
 * Beschreiben Sie hier die Klasse PersonQueue.
 * 
 * @author Germain, Girndt; Krier, Katharina
 * @version 1.0
 * 
 */
public class PersonQueue extends AbstractQueue implements Queue {

    public PersonQueue(int size) {
        super(Person.class, size);   
    }
    
}
