import java.util.Collection;
import java.util.Iterator;

/**
 * Beschreiben Sie hier die Klasse MinHeap.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class MinHeap<E extends java.lang.Comparable<E>> implements java.util.Queue<E>
{
    private Array<E> heap;
    private int size;
    private int maxsize;
    
    /**
     * Konstruktor für Objekte der Klasse MinHeap
     */
    public MinHeap(int maxsize)
    {
        this.size = 0;
        this.maxsize = maxsize;
        this.heap = new Array(this.maxsize);
        
    }

    private int parent(int pos) { return pos / 2; }
    
    private int leftChild(int pos) { return (2 * pos); }
    
    private int rightChild(int pos) {  return (2 * pos) + 1;}
    
    private boolean isLeaf(int pos)
    {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
    
    private void swap(int pos1, int pos2)
    {
 
        E tmp;
        tmp = heap.get(pos1);
 
        heap.set(pos1, heap.get(pos2));
        heap.set(pos2, tmp);
       
    }
    
     private void minHeapify(int pos)
    {
        if (heap.get(rightChild(pos))!=null && heap.get(leftChild(pos)) != null){
            if(heap.get(rightChild(pos)) == null){
                if(heap.get(pos).compareTo(heap.get(leftChild(pos))) < 0){
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));      
                }
                      
            }
            else if (heap.get(leftChild(pos)) == null){
                if(heap.get(pos).compareTo(heap.get(rightChild(pos))) > 0){
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));       
                }
                     
            }
            else {
                if(heap.get(pos).compareTo(heap.get(leftChild(pos))) < 0 ||heap.get(pos).compareTo(heap.get(rightChild(pos))) > 0) {
 
                if (heap.get(leftChild(pos)).compareTo(heap.get(rightChild(pos))) < 0) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }    
            }
        }
    }
    
    public boolean offer(E e){
        if (size >= maxsize) {
            return false;
        }    
        if(size==0){
            heap.set(size, e); 
            size++;
            return true;
        }
       
        heap.set(size, e);
        int current = size;
 
        while (heap.get(current).compareTo(heap.get(parent(current))) < 0) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
        
        return true;
    }
    
    public E poll(){
        if(size <1){
            return null;
        }
        E first = heap.get(0);
        heap.set(0, heap.get(--size));
        heap.set(size, null);
        minHeapify(0);
      
        
        return first;    
    }
    
    public E peek(){
         if(size <1){
            return null;
        }    
        E first = heap.get(0);
        return first;
    }
    
  
    
    public E element(){
         throw new UnsupportedOperationException("Wird nicht unterstuetzt");         
    }
    
    public E remove(){
         throw new UnsupportedOperationException("Wird nicht unterstuetzt");         
    }
    
    public boolean remove(Object o){
         throw new UnsupportedOperationException("Wird nicht unterstuetzt");         
    }
    
    public boolean add(E e){
         throw new UnsupportedOperationException("Wird nicht unterstuetzt");     
    }
    
    public void clear(){
         throw new UnsupportedOperationException("Wird nicht unterstuetzt");         
    }
    
    public boolean retainAll(Collection<?> c){
         throw new UnsupportedOperationException("Wird nicht unterstuetzt");         
    }
    
    public boolean removeAll(Collection<?> c){
         throw new UnsupportedOperationException("Wird nicht unterstuetzt");         
    }
    
    public boolean addAll(Collection<? extends E> c){
         throw new UnsupportedOperationException("Wird nicht unterstuetzt");         
    }
    
    public boolean containsAll(Collection<?> c){
         throw new UnsupportedOperationException("Wird nicht unterstuetzt");         
    }
    
    public Object[] toArray(){
         throw new UnsupportedOperationException("Wird nicht unterstuetzt");         
    }
    
    public <T> T[] toArray(T[] a){
         throw new UnsupportedOperationException("Wird nicht unterstuetzt");         
    }
    
    public Iterator<E> 	iterator(){
         throw new UnsupportedOperationException("Wird nicht unterstuetzt");         
    }
    
    public boolean contains(Object o){
         throw new UnsupportedOperationException("Wird nicht unterstuetzt");         
    }
    
    public boolean isEmpty(){
         throw new UnsupportedOperationException("Wird nicht unterstuetzt");         
    }
    
    public int size(){
       throw new UnsupportedOperationException("Wird nicht unterstuetzt");     
    }
}
