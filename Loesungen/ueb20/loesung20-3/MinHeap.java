/*
 *
 * Musterloesung 
 * Prof. Dr. M. Esch
 *
 *
 */ 
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

import java.lang.UnsupportedOperationException;

public class MinHeap<T extends Comparable<T>> 
                       implements Queue<T> 
{

    private T[] a;
    private int anzahl;
 
    @SuppressWarnings("unchecked")
    public MinHeap(Class<T> c, int capacity)
      {
        this.a = (T[])Array.newInstance(c, capacity);

        for (int j=0;j<a.length;j++)
           {
            a[j] = null;
           }
        anzahl=0;
      }
 
    @Override
    public int size() 
      {
        return anzahl;
      }

    @Override
    public boolean isEmpty() 
      {
        return anzahl==0 ? true:false;
      }

     @Override
    public boolean contains(Object o)
      {
        for (int j=0;j<anzahl;j++)
           {
            if (a[j].equals(o)) 
          return true;
           }
        return false;
      }
   
    @Override
    public Iterator<T> iterator()
      {
        return new IteratorImpl();
      }
  
  
    @Override
    public Object[] toArray()
      {
        return (Object[])a;
      }
   
    @Override
    public <T> T[] toArray(T[] a)
      {
        return a;
      }
   
    @Override
    public boolean remove(Object o)
      {
        throw new java.lang.UnsupportedOperationException(" Methode remove ");
      }
   
    @Override
    public boolean containsAll(Collection<?> c)
      {
        for (Object o: c)
           {
             if (!contains(o))
               return false;
           }
        return true;
      }
   
    @Override
    public boolean addAll(Collection<? extends T> c)
      {
        for (T o : c)
           {
             offer(o);
           }
        return true;
      }
   
    @Override
    public boolean removeAll(Collection<?> c)
      {
        throw new java.lang.UnsupportedOperationException(" Methode removeAll ");
      }
   
    @Override
    public boolean retainAll(Collection<?> c)
      {
        throw new java.lang.UnsupportedOperationException(" Methode retainAll ");
      }
   
   
    @Override
    public void clear()
      {
        anzahl=0;
        a[anzahl]=null;
      }
   
    @Override
    public boolean add(T e)
      {
        if (anzahl>=a.length)
           throw new IllegalStateException();

        return offer(e);
      }
   
    @Override
    public boolean offer(T e)
      {
        if (anzahl>=a.length)
           return false;
    
        // Blattknoten einfuegen
        a[anzahl] = e;
        anzahl++;

        // Wandere vom Blattknoten zur Wurzel
        int j = anzahl-1; 
        while (j > 0)
          {
            // Elternknoten bestimmen
            int p = (j -1)/2;
            // Heap-Eigenschaft verletzt?
            if (a[j].compareTo(a[p]) < 0)
              {
                // Werte vertauschen
                swap(j, p);
                j = p;
              }
            else 
              {
                break; 
              }
           }
        return true;
      }
    

    private void swap(int j, int p)
      {
        T tmp = a[j];
        a[j] = a[p];
        a[p] = tmp;
      }

    @Override
    public T remove()
      {
        if(anzahl==0)
         throw new IllegalStateException();

        return poll();
      }

  
    @Override
    public T poll()
      {
        if(anzahl==0)
           return null;
          // Minimum merken
        T min = a[0];

        // Letzter Blattknoten wird neue Wurzel
        a[0] = a[anzahl-1]; 
        anzahl--;

        // Wandere von Wurzel zu Blattebene
        int j = 0;
        while (2*j + 2 < anzahl)
          {
            // Linker Kindknoten
            int l = 2*j + 1;
            // Rechter Kindknoten
            int r = 2*j + 2;
            // Kleinerer Kindknoten?
            int c = l;
            if (a[r].compareTo(a[l]) < 0)
              {
                c = r;
              }
            // Heap-Eigenschaft verletzt?
            if (a[c].compareTo(a[j]) < 0)
              {
                swap(c, j);
                j = c;
              }
            else 
              {
                break;
              }
          }
        return min;
      }
   
    @Override
    public T element()
      {
        if (anzahl==0)
           throw new IllegalStateException();
        return peek();
      }
   
    @Override
    public T peek()
      {
        if (anzahl==0)
           return null;
           
        return a[0];
      }
   

    
    @Override
    public String toString()
      {
   
        String ausgabe = new String ("\nDer Inhalt des MinHeap :" +
                                     "\n------------------------------\n"
                                    );
   
        for ( int i = 0; i < anzahl; i++ )
           {
             ausgabe +=  " | " + a[i];
           }
        ausgabe += " |";
        return ausgabe; 
      }
   
    public String toStringIter()
      {
  
        String ausgabe = new String ("\nDer Inhalt des MinHeap :" +
                                     "\n------------------------------\n"
                                    );
        Iterator it = this.iterator();
 
        while ( it.hasNext() )
          {
            ausgabe +=  " | " + it.next();
          }
        ausgabe += " |";
        return ausgabe; 
      }
   
 
 
 private class IteratorImpl implements Iterator<T>
   {
     int j;


     public IteratorImpl()
       {
         this.j = 0;
       }



     @Override
     public boolean hasNext()
       {
         return j < anzahl ? true:false;
       }
   
     @Override
     public T next()
       {
        return a[j++];
       }
  
   }

}
