
/**
 * Beschreiben Sie hier die Klasse Array.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Array<E>
{
    private Object[] array;
    public int size = 0;

    /**
     * Konstruktor für Objekte der Klasse Array
     */
    public Array(int size)
    {
        this.size = size;   
        array = new Object[this.size];
    }
    
    public E get(int i) {
      
        E e = (E)array[i];
        return e;
    }
    
    public void set(int i, E e) {
        array[i] = e;
    }

}
