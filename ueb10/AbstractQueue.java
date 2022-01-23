public abstract class AbstractQueue implements Queue {

    private Object[] queue;
    private int anzahl = 0;
    Class<?> arrayKomponentTyp;

    private final String FEHLER_FALSCHER_OBJECT_TYP = "Object muss eine Instanz von der Klasse %s sein. Erhalten: %s";
    private final String FEHLER_QUEUE_VOLL = "Schlange schon voll";
    private final String FEHLER_QUEUE_LEER = "Schlange leer";
    private final String FEHLER_INDEX_UEBERTROFFEN = "Index außerhalb der Schlange";
    private final String FEHLER_STELLE_LEER = "Die eingegebene Stelle ist leer";

    protected void setQueue(Object[] queue) {
        this.queue = queue;
        this.arrayKomponentTyp = this.queue.getClass().getComponentType();
    }

    @Override
    public void addLast(Object o) {

        Class<?> objectTyp = o.getClass();

        if (!(objectTyp == this.arrayKomponentTyp)) {
            throw new Error(
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
        if (this.anzahl == 0) {
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public boolean full() {
        if (this.anzahl < this.queue.length) {
            return false;
        }
        else{
            return true;
        }
    }
    
    @Override
    public int size() {
        return this.queue.length;   
    }
    
    private void entferne(int index) {
         for (int i = index; i < this.anzahl; i++) {
             if (i < this.queue.length) {
                 this.queue[i] = this.queue[i + 1];
                 this.queue[this.anzahl] = null;
             }
         }
         this.anzahl--;
        
    }

}