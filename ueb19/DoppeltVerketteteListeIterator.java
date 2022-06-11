import java.util.Iterator;
import java.util.ListIterator;

public class DoppeltVerketteteListeIterator<T> implements ListIterator<T> {

    DoppeltVerketteteListe<T> list;
    private boolean isFirst;
    private Node<T> lastDelivered;

    public DoppeltVerketteteListeIterator(DoppeltVerketteteListe<T> doppeltVerketteteListe) {
        this.initialize(doppeltVerketteteListe);
    }

    public DoppeltVerketteteListeIterator(DoppeltVerketteteListe<T> doppeltVerketteteListe, int index) {
        if (!this.list.hasElement(index)) {
            throw new IllegalArgumentException("Es gibt kein Element im gewuenschten Index");
        }

        if (index == 0) {
           this.initialize(doppeltVerketteteListe);
        } else {
            this.lastDelivered = this.list.getNodeAtIndex(index).getPrevious();
        }
    }

    private void initialize(DoppeltVerketteteListe<T> doppeltVerketteteListe) {
        this.list = doppeltVerketteteListe;
        this.lastDelivered = null;
        this.isFirst = true;
    } 
    

    @Override
    public boolean hasNext() {

        if (this.isFirst) return this.list.hasHead();

        return lastDelivered.hasNext();
    }
    
    @Override
    public T next() {
        if (!this.hasNext()) {
            throw new IllegalStateException("Das naechste Element gibt es nicht");
        }
        
        if (this.isFirst) {            
            this.lastDelivered = this.list.getNodeAtIndex(0);
            
        } else {

            this.lastDelivered = this.lastDelivered.getNext();
        }

        return this.lastDelivered.getItem();
    }

    // ListIteratorMethoden

    @Override
    public void set(T e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int previousIndex() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public T previous() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasPrevious() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int nextIndex() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void add(T e) {
        // TODO Auto-generated method stub
        
    }
}
