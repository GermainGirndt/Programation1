public abstract class AbstractQueue implements Queue {

    private Object[] queue;
    private int anzahl = 0;

    protected void setQueue(Object[] queue) {
        this.queue = queue;
    }

    @Override
    public void addLast(Object o) {

        Class<?> objectTyp = o.getClass();
        Class<?> arrayKomponentTyp = this.queue.getClass().getComponentType();

        if (!(objectTyp == arrayKomponentTyp)) {
            throw new Error(
                String.format("Object muss eine Instanz von der Klasse %s sein. Erhalten: %s", arrayKomponentTyp, objectTyp)
            );
        }
        
    
        if (this.full()) {
            throw new IllegalArgumentException("Schlange schon voll");
        }

        queue[this.anzahl] = o;
        this.anzahl++; 
    
        
    }
    
    @Override 
    public Object removeFirst() {
        
        if (this.empty()) {
            throw new IllegalArgumentException("Schlange leer");    
        }
        
        Object o = queue[0];
        this.entferne(0);   
        return o;
    }
    
    @Override 
    public Object get(int i) {
        if (this.empty()) {
            throw new IllegalArgumentException("Schlange leer");    
        }
        if (i >= queue.length || i < 0) {
            throw new IllegalArgumentException("Index Außerhalb der Schlange"); 
        }
        
        if (i >= this.anzahl) {
            throw new IllegalArgumentException("An der Stelle der Schlang ist nichts"); 
        }
        return queue[i];
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
        if (this.anzahl < queue.length) {
            return false;
        }
        else{
            return true;
        }
    }
    
    @Override
    public int size() {
        return queue.length;   
    }
    
    private void entferne(int index) {
         for (int i = index; i < this.anzahl; i++) {
             if (i < queue.length) {
                 queue[i] = queue[i + 1];
                 queue[this.anzahl] = null;
             }
         }
         this.anzahl--;
        
    }

}