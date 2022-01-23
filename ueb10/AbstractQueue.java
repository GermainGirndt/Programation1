import java.lang.reflect.Array;

/**
 * Eine Abstrakte Klasse mit den für Queue typische Methoden 
 * 
 * @author Germain, Girndt; Krier, Katharina
 * @version 1.0
 * 
 */
public abstract class AbstractQueue implements Queue {

    private Object[] queue;
    private int anzahl = 0;
    Class<?> arrayKomponentTyp;

    private final String FEHLER_FALSCHER_OBJECT_TYP = "Object muss eine Instanz von der Klasse %s sein. Erhalten: %s";
    private final String FEHLER_QUEUE_VOLL = "Schlange schon voll";
    private final String FEHLER_QUEUE_LEER = "Schlange leer";
    private final String FEHLER_INDEX_UEBERTROFFEN = "Index außerhalb der Schlange";
    private final String FEHLER_STELLE_LEER = "Die eingegebene Stelle ist leer";
    private final String FEHLER_NULL_REFERENZ = "Das neue Objekt darf nicht null sein";

    AbstractQueue(Class<?> arrayKomponentTyp, int size) {

        Validierung.validiereNatuerlicheZahl(size, false);

        this.queue = (Object[]) Array.newInstance(arrayKomponentTyp, size);
        this.arrayKomponentTyp = this.queue.getClass().getComponentType();
    }

    @Override
    public void addLast(Object o) {

        if (o == null) {
            throw new IllegalArgumentException(FEHLER_NULL_REFERENZ);
        }

        Class<?> objectTyp = o.getClass();

        if (!(objectTyp == this.arrayKomponentTyp)) {
            throw new IllegalArgumentException(
                String.format(FEHLER_FALSCHER_OBJECT_TYP, arrayKomponentTyp, objectTyp)
            );
        }
        
    
        if (this.full()) {
            throw new IllegalArgumentException(FEHLER_QUEUE_VOLL);
        }

        this.queue[this.anzahl] = o;
        this.anzahl++; 
    
        
    }
    
    @Override 
    public Object removeFirst() {
        
        if (this.empty()) {
            throw new IllegalArgumentException(FEHLER_QUEUE_LEER);    
        }
        
        Object o = this.queue[0];
        this.entferne(0);   
        return o;
    }
    
    @Override 
    public Object get(int i) {
        if (this.empty()) {
            throw new IllegalArgumentException(FEHLER_QUEUE_LEER);    
        }
        if (i >= this.queue.length || i < 0) {
            throw new IllegalArgumentException(FEHLER_INDEX_UEBERTROFFEN); 
        }
        
        if (i >= this.anzahl) {
            throw new IllegalArgumentException(FEHLER_STELLE_LEER); 
        }

        return this.queue[i];
    }
    
    @Override
    public boolean empty() {

        boolean istLeer = this.anzahl == 0;

        return istLeer;
    }
    
    @Override
    public boolean full() {

        boolean istVoll = this.anzahl >= this.queue.length;

        return istVoll;
    }
    
    @Override
    public int size() {
        return this.queue.length;   
    }
    
    private void entferne(int index) {
        Validierung.validiereNatuerlicheZahl(index, true);

        if (index >= this.anzahl) {
           throw new IllegalArgumentException(FEHLER_INDEX_UEBERTROFFEN);
        }
       
         for (int i = index; i < this.anzahl; i++) {
            this.queue[i] = this.queue[i + 1];
         }

         this.queue[this.anzahl] = null;
         this.anzahl--;
    }

}