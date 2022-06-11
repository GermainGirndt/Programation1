public class Node<E> {

    E item;
    private Node<E> previous;
    private Node<E> next;

    public Node(E item) {
        this.item = item;
        this.previous = null;
        this.next = null;
    }

    public void setPrevious(Node<E> item) {
        this.previous = item;
    }

    public Node<E> getPrevious() {
        return this.previous;
    }

    public void setNext(Node<E> item) {
        this.next = item;
    }

    public Node<E> getNext() {
        return this.next;
    }


}
