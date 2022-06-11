import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class DoppeltVerketteteListe<E> implements List<E> {
    
    Node<E> head;
    Node<E> tail = null;
    int size;

    public DoppeltVerketteteListe() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(Object o) {

    }

    public <T> T[] toArray(T[] a) {

        int size = this.size();

    }

    public boolean add(E e) {

        if (e == null) {
            return false;
        }

        Node<E> nodeToAdd = new Node<E>(e);

        if (this.isEmpty()) {
            this.head = nodeToAdd;
            this.tail = nodeToAdd;
        } else {
            this.tail.setNext(nodeToAdd);
            nodeToAdd.setPrevious(this.tail);
            this.tail = nodeToAdd;
        }

        return true;
    }

    public boolean remove(Object o) {

    }

    public boolean addAll(Collection<? extends E> c) {

    }

    public void clear() {

    }

    public E get(int index) {

        Node<E> node = this.getNodeAtIndex(index);

        return node.getItem();
    }

    private Node<E> getNodeAtIndex(int index) {

        if (index < 0) {
            throw new IllegalArgumentException("Der Index muss groesser gleich null sein.");
        }

        if (index >= this.size()) {
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

    public E set(int index, E element) {

        Node<E> oldNode = this.getNodeAtIndex(index);
        Node<E> newNode = new Node<E>(element);
        
        if (oldNode.hasPrevious()) {
            Node<E> previousNode = oldNode.getPrevious();

            newNode.setPrevious(previousNode);
            previousNode.setNext(newNode);
        }

        if (oldNode.hasNext()) {
            Node<E> nextNode = oldNode.getNext();

            newNode.setNext(nextNode);
            nextNode.setPrevious(newNode);
        }

        oldNode.setNext(null);
        oldNode.setPrevious(null);

        return oldNode.getItem();
    }

    public void add(int index, E element) {

    }

    public E remove(int index) {

    }

    public int indexOf(Object o) {

    }

    public ListIterator<E> listIterator(int index) {

    }

    public Iterator<E> iterator() {
        Iterator<E> iterator = new DoppeltVerketteteListeIterator<E>(this);
        return iterator;
    }

    public boolean hasHead() {
        return this.head != null;
    }

    public Node<E> getHead() {
        return this.head;
    }


}