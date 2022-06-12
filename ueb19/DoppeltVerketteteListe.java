import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Beschreiben Sie hier die Klasse DoppeltVerketteteListe.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class DoppeltVerketteteListe<E> implements List<E> {
    
    Node<E> head;
    Node<E> tail;
    int size;

    public DoppeltVerketteteListe() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean add(E e) {

        this.add(this.size(), e);

        return true;
    }
    
    public void add(int index, E element) {
        
        Node<E> newNode = new Node<E>(element);
        
        if (index > this.size()) {
            throw new IllegalArgumentException("Index zu hoch. Es duerfen keine Luecken entstehen");
        }

        // Liste ist leer
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.size++;

            return;
        }

        // Das neue Element schafft eine neue Stelle am Listenende
        if (index == this.size()) {
            this.tail.setNext(newNode);
            newNode.setPrevious(this.tail);
            this.tail = newNode;
            this.size++;

            return;
        }

        Node<E> nodeInIndex = this.getNodeAtIndex(index);
        Node<E> previousNode = nodeInIndex.getPrevious();

        // Das neue Element geht auf die Stelle 0
        if (nodeInIndex == this.head) {
            this.head = newNode;
        } else {
            previousNode.setNext(newNode);
            newNode.setPrevious(previousNode);
        }
        newNode.setNext(nodeInIndex);
        nodeInIndex.setPrevious(newNode);
        

        this.size++;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(Object o) {

        int objectIndex = this.indexOf(o);

        boolean constains = objectIndex != -1;

        return constains;

    }

    @Override
    public <T> T[] toArray(T[] a) {

        if (a == null) {
            throw new IllegalArgumentException("Nullreferenz wird nicht unterstuetzt");
        }

        if (a.length < this.size()) {
            return (T[]) this.toArray();
        }

        Node<E> node = head;
        for (int i = 0; i < this.size(); i++) {
            a[i] = (T) node.getItem();
            node = node.getNext();
        }

        return a;
    }

    public E remove(int index) {

        Node<E> nodeToBeRemoved = this.getNodeAtIndex(index);

        // Knoten ist weder Head- noch Tailknoten
        if (nodeToBeRemoved.hasPrevious() && nodeToBeRemoved.hasNext()) {
            Node<E> previous = nodeToBeRemoved.getPrevious();
            Node<E> next = nodeToBeRemoved.getNext();

            previous.setNext(next);
            next.setPrevious(previous);
        }

        // Die Liste hat nur einen Knoten
        if (!nodeToBeRemoved.hasPrevious() && !nodeToBeRemoved.hasNext()) {
            this.head = null;
            this.tail = null;
        }

        // Knoten ist der Tailknoten
        if (nodeToBeRemoved.hasPrevious() && !nodeToBeRemoved.hasNext()) {
            Node<E> previous = nodeToBeRemoved.getPrevious();
           
            previous.setNext(null);
        }

        // Knoten ist der Headknoten
        if (!nodeToBeRemoved.hasPrevious() && nodeToBeRemoved.hasNext()) {
            Node<E> next = nodeToBeRemoved.getNext();

            next.setPrevious(null);
        }

        nodeToBeRemoved.setPrevious(null);
        nodeToBeRemoved.setNext(null);
        this.size--;

        return nodeToBeRemoved.getItem();
    }

    
    public boolean remove(Object o) {

        int indexToBeRemoved = this.indexOf(o);

        if (indexToBeRemoved == -1) return false;

        this.remove(indexToBeRemoved);

        return true;

    }

    public boolean addAll(Collection<? extends E> c) {
        for (E element : c) {
            this.add(element);
        }

        return true;
    }

    public void clear() {
        
        Node<E> node = this.getHead();

        while(node.hasNext()) {
            Node<E> next = node.getNext();

            node.setPrevious(null);
            node.setNext(null);

            node = next;
        }
        node.setPrevious(null);

        this.head = null;
        this.tail = null;
    }

    public E get(int index) {

        Node<E> node = this.getNodeAtIndex(index);

        return node.getItem();
    }

    public Node<E> getNodeAtIndex(int index) {

        if (this.checkElementExists(index)) {
            throw new IllegalArgumentException("Das gewuenschte Element gibt es nicht");
        }

        int zaehler = 0;
        Node<E> node = this.getHead();
        while(zaehler != index) {
            node.getNext();
            zaehler++;
        }

        return node;
    }

    public boolean checkElementExists(int index) {

        if (index >= 0) {
            throw new IllegalArgumentException("Der Index muss groesser null sein.");
        }

        return index < this.size();

    }

    public E set(int index, E element) {

        Node<E> newNode = new Node<E>(element);
        Node<E> oldNode = this.getNodeAtIndex(index);

        if (oldNode == this.head) {
            this.head = newNode;
        }

        if (oldNode == this.tail) {
            this.tail = newNode;
        }
        
        if (oldNode.hasPrevious()) {
            Node<E> previousNode = oldNode.getPrevious();

            newNode.setPrevious(previousNode);
            previousNode.setNext(newNode);
            oldNode.setPrevious(null);
        }

        if (oldNode.hasNext()) {
            Node<E> nextNode = oldNode.getNext();

            newNode.setNext(nextNode);
            nextNode.setPrevious(newNode);
            oldNode.setNext(null);
        }

        return oldNode.getItem();
    }

    public int indexOf(Object o) {

        if (o == null) {
            throw new IllegalArgumentException("Nullreferenz wird nicht unterstuetzt");
        }

        if (this.isEmpty()) {
            return -1;    
        }
        
        // Validiert, ob die Klassen übereinstimmen
        if (!this.head.getItem().getClass().equals(o.getClass())) {
            return -1;
        }

        ListIterator<E> iterator = this.listIterator();

        while (iterator.hasNext()) {

            if (iterator.next().equals(o)) {
                return iterator.previousIndex();
            }
        }

        return -1;
    }

    @Override
    public Object[] toArray() {

        E[] array = (E[]) new Object[this.size()];
        
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            array[i] = node.getItem();
            node = node.getNext();
        }

        return array;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        ListIterator<E> listIterator = new DoppeltVerketteteListeIterator<E>(this, index);
        
        return listIterator;
        
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new DoppeltVerketteteListeIterator<E>(this);
        return iterator;
    }

    public boolean hasHead() {
        return this.head != null;
    }

    private Node<E> getHead() {
        return this.head;
    }
    
    public ListIterator<E> listIterator() {
        return this.listIterator(0);
    }

    // Implementierung nicht nötig

    @Override
    public boolean retainAll(Collection<?> c) {

        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    
    
    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
        
    }
    
    @Override
    public boolean addAll(int arg0, Collection<? extends E> arg1) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public List<E> subList(int arg0, int arg1) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }
    
}