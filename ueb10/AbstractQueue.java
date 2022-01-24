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

    /**
    * Konstruktor AbstractQueue
    * @param arrayKomponentTyp Klasse der Objekte in der Queue
    * @param size die Groesse
    */
    AbstractQueue(Class<?> arrayKomponentTyp, int size) {

        Validierung.validiereNatuerlicheZahl(size, false);

        this.queue = (Object[]) Array.newInstance(arrayKomponentTyp, size);
        this.arrayKomponentTyp = this.queue.getClass().getComponentType();
    }

    
    /**
    * Stellt ein uebergebenes Objekt hinten an der Queue an
    * @param o Element was an letzt möglicher Stelle hinten in die Queue gestellt wird
    */
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
    
    /**
    * Holt das Element an erster Stelle in der Queue heraus und loescht es und alle Elemente dahinter ruecken vor
    * @return das Element an erster Stelle
    */
    @Override 
    public Object removeFirst() {
        
        if (this.empty()) {
            throw new IllegalArgumentException(FEHLER_QUEUE_LEER);    
        }
        
        Object o = this.queue[0];
        this.entferne(0);   
        return o;
    }
    
    /**
    * Schaut was für ein Objekt an einer Stelle i ist und gibt dieses zurueck
    * @param i die Stelle in der Queue
    * @return das Element an der Stelle i
    */
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
    
    /**
    * Prueft ob die Queue leer ist
    * @return Wert ob istLeer
    */
    @Override
    public boolean empty() {

        boolean istLeer = this.anzahl == 0;

        return istLeer;
    }
    
    
    /**
    * Prueft ob die Queue voll ist
    * @return Wert ob istVoll
    */
    @Override
    public boolean full() {

        boolean istVoll = this.anzahl >= this.queue.length;

        return istVoll;
    }
    
    /**
    * Gibt die Groesse der Queue zurueck
    * @return Groesse der Queue
    */
    @Override
    public int size() {
        return this.queue.length;   
    }
    
    /**
    * Gibt die Anzahl der Elemente in der Queue zurueck
    * @return Anzahl der Elemente
    */
    @Override
    public int anzahlElemente() {
        return this.anzahl;   
    }
    
    /**
    * Entfernt ein Element an der Stelle des Index
    * @param index die Stelle des zu entfernenden Elements
    */
    private void entferne(int index) {
        Validierung.validiereNatuerlicheZahl(index, true);

        if (index >= this.anzahl) {
           throw new IllegalArgumentException(FEHLER_INDEX_UEBERTROFFEN);
        }
       
         for (int i = index; i < this.anzahl - 1; i++) {
            this.queue[i] = this.queue[i + 1];
         }

         this.queue[this.anzahl - 1] = null;
         this.anzahl--;
    }

}