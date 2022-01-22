
/**
 * Tragen Sie hier eine Beschreibung des Interface Queue ein.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

public interface Queue
{
    public void addLast(Object o);
    public Object removeFirst();
    public Object get(int i);
    public boolean empty();
    public boolean full();
    public int size();
}
