import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
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
        // Todo


        int size = this.size();

    }

    public E remove(int index) {

        Node<E> nodeToBeRemoved = this.getNodeAtIndex(index);

        // Knoten ist weder head noch tailnoten
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

        return nodeToBeRemoved.getItem();
    }

    
    public boolean remove(Object o) {

        int indexToBeRemoved = this.indexOf(o);

        if (indexToBeRemoved == -1) return false;

        this.remove(indexToBeRemoved);

        return true;

    }

    public boolean addAll(Collection<? extends E> c) {
        // todo

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

        if (this.hasElement(index)) {
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

    public boolean hasElement(int index) {

        if (index >= 0) {
            throw new IllegalArgumentException("Der Index muss groesser null sein.");
        }

        return index < this.size();

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

    public int indexOf(Object o) {

        if (this.isEmpty()) {
            return -1;    
        }
        
        // Validiert, ob die Klassen übereinstimmen
        if (!this.head.getItem().getClass().equals(o.getClass())) {
            return -1;
        }

        ListIterator<E> iterator = this.listIterator();

        while (iterator.hasNext()) {

            if (iterator.next() == o) {
                return iterator.previousIndex();
            }
        }

        return -1;
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

    // Implementieren nicht nötig

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    public ListIterator<E> listIterator() {
        
        return this.listIterator(0);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean addAll(int arg0, Collection<? extends E> arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<E> subList(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

}