import java.util.ListIterator;

/**
 * Beschreiben Sie hier die Klasse DoppeltVerketteteListeIterator.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class DoppeltVerketteteListeIterator<T> implements ListIterator<T> {

    DoppeltVerketteteListe<T> list;
    private int index;
    private Node<T> previous;
    private int indexOfLastElementReturned;

    public DoppeltVerketteteListeIterator(DoppeltVerketteteListe<T> doppeltVerketteteListe) {
        this.initialize(doppeltVerketteteListe);
    }

    public DoppeltVerketteteListeIterator(DoppeltVerketteteListe<T> doppeltVerketteteListe, int index) {
        if (!this.list.checkElementExists(index)) {
            throw new IllegalArgumentException("Es gibt kein Element im gewuenschten Index");
        }

        if (this.isFirst(index)) {
           this.initialize(doppeltVerketteteListe);
        } else {
            this.previous = this.list.getNodeAtIndex(index - 1);
            this.index = index;
        }
    }

    private void initialize(DoppeltVerketteteListe<T> doppeltVerketteteListe) {
        this.list = doppeltVerketteteListe;
        this.previous = null;
        this.index = 0;
        this.indexOfLastElementReturned = -1;
    }

    private boolean isFirst() {
        return this.index == 0;
    }

    private boolean isFirst(int index) {
        return index == 0;
    }
    
    @Override
    public boolean hasNext() {

        if (this.isFirst()) return this.list.size() > 0;

        return previous.hasNext();
    }

    @Override
    public T next() {
        if (!this.hasNext()) {
            throw new IllegalStateException("Das naechste Element gibt es nicht");
        }
        
        Node<T> next = this.isFirst() ? this.list.getNodeAtIndex(0) : this.previous.getNext();
        T nextItem = next.getItem();
        this.indexOfLastElementReturned = this.index;

        this.index++;
        this.previous = next;

        return nextItem;
    }

    // ListIteratorMethoden

    @Override
    public void set(T e) {
        this.list.set(this.indexOfLastElementReturned, e);
    }

    @Override
    public int previousIndex() {
        return this.index - 1;
    }

    @Override
    public T previous() {

        if (!this.hasPrevious()) {
            throw new IllegalStateException("Das letzte Element gibt es nicht");
        }
        
        T previousItem = this.previous.getItem();
        
        this.previous = this.previous.getPrevious();
        this.index--;
        this.indexOfLastElementReturned = index;

        return previousItem;
    }

    @Override
    public boolean hasPrevious() {
        return previous != null;
    }

    @Override
    public int nextIndex() {
        return this.index;
    }

    @Override
    public void remove() {
        this.list.remove(this.indexOfLastElementReturned);
        
    }

    @Override
    public void add(T e) {
        this.list.add(e);
    }
}
