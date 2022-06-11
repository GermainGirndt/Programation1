import java.util.Iterator;

public class DoppeltVerketteteListeIterator<T> implements Iterator<T> {

    DoppeltVerketteteListe<T> list;
    private boolean isFirst;
    private Node<T> lastDelivered;

    public DoppeltVerketteteListeIterator(DoppeltVerketteteListe<T> doppeltVerketteteListe) {
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
            
            this.lastDelivered = this.list.getHead();
            
        } else {

            this.lastDelivered = this.lastDelivered.getNext();
        }

        return this.lastDelivered.getItem();
    }
}
