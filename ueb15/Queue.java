
/**
 * Interface für Queue mit einigen der fuer Queue typischen Methoden
 * 
 * @author Germain, Girndt; Krier, Katharina
 * @version 1.0
 * 
 */

public interface Queue<Type> {
    public void addLast(Type o);
    public Type removeFirst();
    public Type get(int i);
    public boolean empty();
    public boolean full();
    public int size();
    public int anzahlElemente();
}
