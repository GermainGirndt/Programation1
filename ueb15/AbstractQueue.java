import java.lang.reflect.Array;

/**
 * Eine Abstrakte Klasse mit den für Queue typische Methoden 
 * 
 * @author Germain, Girndt; Krier, Katharina
 * @version 1.0
 * 
 */
public abstract class AbstractQueue<Type> implements Queue<Type> {

    private Type[] queue;
    private int anzahl = 0;
    private Class<?> arrayKomponentTyp;
    private Iterator iterator;

    private final String FEHLER_FALSCHER_OBJECT_TYP = "Type muss eine Instanz von der Klasse %s sein. Erhalten: %s";
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
    public AbstractQueue(Class<?> arrayKomponentTyp, int size) {

        Validierungsutils.validiereNatuerlicheZahl(size, false);

        this.queue = (Type[]) Array.newInstance(arrayKomponentTyp, size);
        this.arrayKomponentTyp = this.queue.getClass().getComponentType();
        
    }

    public Iterator<Type> getIterator() {
        return new AbstractIterator();
    }

    private class AbstractIterator implements Iterator<Type> {
        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            System.out.println("" + nextIndex + " " + anzahl);
            return nextIndex < AbstractQueue.this.anzahl;
        }

        @Override
        public Type next() {
            if (!this.hasNext()) {
                throw new IllegalStateException("Das naechste Element gibt es nicht");
            }

            Type o = AbstractQueue.this.queue[nextIndex];
            nextIndex++;

            return o;
        }
    }

    public void print() {
        Iterator<Type> iterator = new AbstractIterator();

        if (!iterator.hasNext()) {
            System.err.println("Queue ist leer");
        }
        
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    
    /**
    * Stellt ein uebergebenes Objekt hinten an der Queue an
    * @param o Element was an letzt möglicher Stelle hinten in die Queue gestellt wird
    */
    @Override
    public void addLast(Type o) {

        if (o == null) {
            throw new IllegalArgumentException(FEHLER_NULL_REFERENZ);
        }

        if (this.full()) {
            throw new IllegalArgumentException(FEHLER_QUEUE_VOLL);
        }

        Class<?> objectTyp = o.getClass();

        if (!(objectTyp == this.arrayKomponentTyp)) {
            throw new IllegalArgumentException(
                String.format(FEHLER_FALSCHER_OBJECT_TYP, arrayKomponentTyp, objectTyp)
            );
        }

        this.queue[this.anzahl] = o;
        this.anzahl++; 
        
    }
    
    /**
    * Holt das Element an erster Stelle in der Queue heraus und loescht es und alle Elemente dahinter ruecken vor
    * @return das Element an erster Stelle
    */
    @Override 
    public Type removeFirst() {
        
        if (this.empty()) {
            throw new IllegalArgumentException(FEHLER_QUEUE_LEER);    
        }
        
        Type o = this.queue[0];
        this.entferne(0);   
        return o;
    }
    
    /**
    * Schaut was für ein Objekt an einer Stelle i ist und gibt dieses zurueck
    * @param i die Stelle in der Queue
    * @return das Element an der Stelle i
    */
    @Override 
    public Type get(int i) {
        if (this.empty()) {
            throw new IllegalArgumentException(FEHLER_QUEUE_LEER);    
        }
        if (!this.checkeObIndexInDerQueueExistiert(i)) {
            throw new IllegalArgumentException(FEHLER_INDEX_UEBERTROFFEN); 
        }
        
        if (this.checkeObIndexLeerIst(i)) {
            throw new IllegalArgumentException(FEHLER_STELLE_LEER); 
        }

        return this.queue[i];
    }

    private boolean checkeObIndexInDerQueueExistiert(int zuUeberpruefenderIndex) {
        boolean existiert = zuUeberpruefenderIndex >= 0 && zuUeberpruefenderIndex < this.queue.length;

        return existiert;

    }
    
    private boolean checkeObIndexLeerIst(int index) {
        boolean istLeer = index >= this.anzahl;

        return istLeer;

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
        Validierungsutils.validiereNatuerlicheZahl(index, true);

        if (!this.checkeObIndexInDerQueueExistiert(index)) {
           throw new IllegalArgumentException(FEHLER_INDEX_UEBERTROFFEN);
        }

        if (this.checkeObIndexLeerIst(index)) {
            throw new IllegalArgumentException(FEHLER_STELLE_LEER); 
        }
       
         this.shiftUmEinsNachIndex(index);

         this.anzahl--;
    }
        
    private void shiftUmEinsNachIndex(int index) {
        for (int i = index; i < this.anzahl - 1; i++) {
            this.queue[i] = this.queue[i + 1];
        }
        
        this.queue[this.anzahl - 1] = null;
    }

}