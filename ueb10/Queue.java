
/**
 * Tragen Sie hier eine Beschreibung des Interface Queue ein.
 * 
 * @author Germain, Girndt; Krier, Katharina
 * @version 1.0
 * 
 */

public interface Queue {
    public void addLast(Object o);
    public Object removeFirst();
    public Object get(int i);
    public boolean empty();
    public boolean full();
    public int size();
    public int anzahlElemente();
}
