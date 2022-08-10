// DoppeltVerketteteListe.java
//
// auf Grundlage der Java-Beispiele von
// Prof. Dr. H.G.Folz aus Programmiersprachen 1
//
// Bsp-Loesung --> A. Pick
//
// Doppelt-verkettete lineare Liste

 
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.lang.NullPointerException;


/** Implementierung einer doppelt-verketteten linearen Liste */

public class DoppeltVerketteteListe<E> implements List<E> 
{
    private long size;
    private DoppeltVerketteteListeElement<E> first;
    private DoppeltVerketteteListeElement<E> last;

    /** Leere Liste erzeugen */

    public DoppeltVerketteteListe()
    {
      first = last = null;
      size  = 0;
    }

// -------- nicht realisierte Methoden ------------------

    public boolean  addAll( int index, Collection<? extends E> c )
    {
      throw new java.lang.UnsupportedOperationException( "Methode addAll" );
    }
    
    public boolean  containsAll( Collection<?> c )
    {
      throw new java.lang.UnsupportedOperationException( "Methode containsAll" );
    }
    
    public boolean  equals( Object o )
    {
      throw new java.lang.UnsupportedOperationException( "Methode equals" );
    }
    
    public int  hashCode()
    {
      throw new java.lang.UnsupportedOperationException( "Methode hashCode" );
    }

    public int  lastIndexOf( Object o )
    {
      throw new java.lang.UnsupportedOperationException( "Methode lastIndexOf" );
    }
    
    public ListIterator<E> listIterator( int index )
    {
      throw new java.lang.UnsupportedOperationException( "Methode listIterator" );
    }
    
    public boolean  removeAll( Collection<?> c )
    {
      throw new java.lang.UnsupportedOperationException( "Methode removeAll" );
    }
    
    public boolean  retainAll( Collection<?> c )
    {
      throw new java.lang.UnsupportedOperationException( "Methode retainAll" );
    }

    public List<E>  subList( int fromIndex, int toIndex )
    {
      throw new java.lang.UnsupportedOperationException( "Methode subList" );
    }
    
    public Object[]  toArray()
    {
      throw new java.lang.UnsupportedOperationException( "Methode toArray" );
    }


// -------- realisierte Methoden ------------------

    /**  Element am Listenende anfuegen
     *
     *   @param  neu  neues Element
     *
     *   @return true, falls Anfuegen erfolgreich, sonst false
     */
    public boolean  add( E neu )
    {

      if ( neu == null )
        {
          throw new NullPointerException("Uebergabeparameter: E neu == null");
        }

      DoppeltVerketteteListeElement<E> leNeu =
          new DoppeltVerketteteListeElement<E> ( neu, null, null );

      boolean eingefuegt = false;

      if ( first == null )
      {
          first = last = leNeu;
          size  = 1;
      }
      else 
      {
          last.next      = leNeu;
          leNeu.previous = last;
          last           = leNeu;
          size++;
      }
      return true ;
    }


    /**  Element an einer bestimmten Position in der Liste einfuegen
     *
     *   @param index  Einfuegeposition fuer neues Element
     *   @param neu    neues Element
     */
    public void add( int index, E element )
    {
      if ( index < 0  ||  index > size )

         throw new IndexOutOfBoundsException( "index:" + index + " size:" + size );

      if ( index == size )

         add( element );
      else 
         addBefore( element, entry( index ) );
    }


    /**  alle Elemente einer Sammlung an die Liste anhaengen
     *
     *   @param  c     Sammlung von Elementen
     *
     *   @return true, falls Anhaengen erfolgreich, sonst false
     */

    //  Variante mit for ...

    public boolean  addAll( Collection<? extends E> c )
    {
      if ( c.isEmpty() )

          throw new NullPointerException( "Die Collection ist leer !!!" );
      else
          for ( E element : c )

              if ( ! add( element ) )

                  return false ;
      return true ;
    }


    /**  alle Elemente einer Sammlung an die Liste anhaengen
     *
     *   @param  c     Sammlung von Elementen
     *
     *   @return true, falls Anhaengen erfolgreich, sonst false
     */

    //  Variante mit Iterator

    public boolean  addAll2( Collection<? extends E> c )
    {
      Iterator cIt = c.iterator();
  
      if ( cIt.hasNext() )
      {
          while ( cIt.hasNext() )

              if ( ! add( (E)cIt.next() ) )

                  return false ;
      }
      else
          throw new NullPointerException( "Die Collection ist leer !!!" );

      return true ;
    }


    /**  Liste leeren  */

    public void  clear()
    {
      first = last = null;
      size  = 0;
    }


    /**  Suche, ob ein Element in der Liste ist
     *
     *   @param  o   gesuchtes Element
     *
     *   @return true, falls vorhanden, sonst false
     */
    public boolean  contains( Object o )
    {
      return ( indexOf(o) > -1 ) ;
    }


    /**  Referenz des Elements an einer bestimmten Position ermitteln
     *
     *   @param  index   vorgegebene Position
     *
     *   @return Referenz des Elements an der vorgegebenen Position
     */
    public E  get( int index )
    {
      return entry( index ).data;
    }


    /**  Position eines bestimmten Elements ermitteln
     *
     *   @param  o    vorgegebenes Element
     *
     *   @return Position des vorgegebenen Elements, falls vorhanden, sonst -1
     */
    public int  indexOf( Object o )
    {
      int  index = -1;

      if ( o == null )
        {
          throw new NullPointerException("Uebergabeparameter: Object o == null");
        }

      DoppeltVerketteteListeElement<E> le = first;

      while ( le != null )
      {
          index++;

          if  ( le.data.equals( o ) )    return index;

          le = le.next;
      }
      return -1;
    }


    /**  Kontrolle, ob die Liste leer ist
     *
     *   @return  true, falls Liste leer, sonst false
     */
    public boolean  isEmpty()
    {
      return size == 0;
    }


    public Iterator<E> iterator()
    {
      return new MyIterator( first );
    }
    

    public ListIterator<E> listIterator()
    {
      return new MyListIterator( first, size );
    }

    
    /**  Element an einer bestimmten Position entfernen
     *
     *   @param  index    vorgegebene Position
     *
     *   @return Referenz auf das entfernte Element
     */
    public E  remove( int index )
    {
      DoppeltVerketteteListeElement<E> le = entry( index ) ;
     
      remove( le );

      return le.data;
    }


    /**  ein bestimmtes Element entfernen
     *
     *   @param  o   vorgegebenes Element
     *
     *   @return true, falls Element vorhanden, sonst false
     */
    public boolean  remove( Object o )
    {
      if ( o == null )
        {
          throw new NullPointerException("Uebergabeparameter: Object o == null");
        }

      DoppeltVerketteteListeElement<E> le = entry( o ) ;

      if ( le != null )

          remove( le );

      return ( le == null ) ? false : true ;
    }


    /** private Methode, um ein Listenelement zu entfernen
     *
     *   @param  le   Referenz auf zu entfernendes Element
     */

    private void remove( DoppeltVerketteteListeElement<E> le )
    {
      if  ( le.previous == null )  first            = le.next;
      else                         le.previous.next = le.next;

      if  ( le.next     == null )  last             = le.previous;
      else                         le.next.previous = le.previous;

      size--;
    }


    /**  Element an einer bestimmten Position in der Liste ersetzen
     *
     *   @param  index    Ersetzungsposition fuer neues Element
     *   @param  element  neues Element
     *
     *   @return Referenz auf ersetztes Element 
     */
    public E  set( int index, E element )
    {
      if ( element == null )
        {
          throw new NullPointerException("Uebergabeparameter: E element == null");
        }

      DoppeltVerketteteListeElement<E> le = entry( index );

      E oldElement = le.data;
      le.data = element;

      return oldElement;
    }

 
    /**  Anzahl der Elemente in der Liste ermitteln
     *
     *   @return  Anzahl der Listenelemente
     */
    public int  size()
    {
      int rSize;
      if ( size > Integer.MAX_VALUE)
        {
          rSize = Integer.MAX_VALUE;
        }
      else
        {
          rSize = (int) size;
        }

      return rSize;
    }


    /**  alle Listenelemente in ein Array eintragen
     *
     *   @param  a   Array zur Aufnahme der Listenelemente
     *
     *   @return true, falls Anhaengen erfolgreich, sonst false
     */
    public <T> T[]  toArray( T[] a )
    {
      int index  = 0;

      if ( isEmpty() )
          throw new RuntimeException( "Das Lager ist leer !!!" );

      Object[] listArray = new Object[size()];

      DoppeltVerketteteListeElement<E> le = first ;

      while ( le != null )
      {
          listArray[index++] = (T)le.data ;
          le         = le.next;
      }

      if (a.length < size())
        {   
            return (T[]) Arrays.copyOf(listArray, size(), a.getClass());
        }   
      else 
        {   
            System.arraycopy(listArray, 0, a, 0, size());
            if (a.length > size())
                a[size()] = null;
            return a;
        }   
          
    }


    /**  Listeninhalt als String ausgeben
     *
     *   @return Listeninhalt
     */
    public String  toString()
    {
      StringBuffer sb = new StringBuffer();

      if ( isEmpty() )

          sb.append( "\t ist leer.\n" );
      else
      {
          DoppeltVerketteteListeElement<E> leNext = first ;
          DoppeltVerketteteListeElement<E> lePrev = last ;

          while ( leNext != null )
          {
              sb.append( " v " + leNext.data + "\t  ^ " + lePrev.data + "\n" );
              leNext = leNext.next;
              lePrev = lePrev.previous;
          }
      }
      return sb.toString();
    }


    /**  Listeninhalt als String mittels Iterator ausgeben
     *
     *   @return Listeninhalt
     */
    public String  toStringIterator()
    {
      Iterator     it = this.iterator();
      StringBuffer sb = new StringBuffer();

      if ( isEmpty() )

          sb.append( "\t ist leer.\n" );
      else
          while ( it.hasNext() )

              sb.append( " v  " + it.next() + "\n" );

      return sb.toString();
    }


    /**  Listeninhalt als String mittels ListIterator ausgeben
     *
     *   @return Listeninhalt
     */
    public String  toStringListIterator()
    {
      ListIterator li = this.listIterator();
      StringBuffer sb = new StringBuffer();

      if ( isEmpty() )

        sb.append( "\t ist leer.\n" );

      else
      {
        while ( li.hasNext() )

          sb.append( " v  [" + li.nextIndex() + "] " + li.next() + "\n" );

        while ( li.hasPrevious() )

          sb.append( " ^  [" + li.previousIndex()  + "] " + li.previous() + "\n" );
      }
      return sb.toString();
    }



// -------- Hilfsmethoden -------------------------

    /**  gibt die Referenz auf das Element an einer Position zurueck
     *
     *   @param  index  Position in der Liste
     *
     *   @return Referenz auf das Element an der vorgegebenen Position
     */
    private DoppeltVerketteteListeElement<E> entry( int index )
    {
      if ( index < 0  ||  index >= size )

        throw new IndexOutOfBoundsException( "index:" + index + " size:" + size );

      DoppeltVerketteteListeElement<E> le = first;

      while ( 0 < index-- )   le = le.next;

      return le;
    }


    /** gib die Referenz auf ein bestimmtes Element zurueck
     *
     *   @param  o  gesuchtes Element
     *
     *   @return Referenz auf gesuchtes Element oder null, falls nicht vorhanden
     */
    private DoppeltVerketteteListeElement<E> entry( Object o )
    {
      if ( o == null )

          throw new RuntimeException( "NULL-Referenz unzulaessig !!!" );

      DoppeltVerketteteListeElement<E> le = first;

      while ( le != null )
      {
          if  ( le.data.equals( o ) )    return le;

          le = le.next;
      }
      return null;
    }


    /**  private Methode, um ein neues Element vor einem anderen einzufuegen
     *
     *   @param  element  neues Element
     *   @param  le       Referenz auf Listenelement, vor dem eingefuegt wird
     */
    private void addBefore( E element, DoppeltVerketteteListeElement<E> le )
    {
      DoppeltVerketteteListeElement<E> leNeu ;

      if ( le == null )

        throw new RuntimeException( "kein Element, VOR dem eingefuegt werden kann !!!" );

      if ( isEmpty() )    // Liste noch leer?

          add( element );
      else
      {
          leNeu = new DoppeltVerketteteListeElement<E>( element, le.previous, le );

          le.previous.next = leNeu;
          le.previous      = leNeu;
          last             = leNeu;
          size++;
      }
    }


// -------- Listenelement -------------------------

    /**   Listenelement, zeigt auf ein Inhaltsobjekt sowie
     *    das naechste und auf das vorherige Listenelement.
     */
    public class DoppeltVerketteteListeElement<E> 
    {
      protected E                       data;
      protected DoppeltVerketteteListeElement<E> next;
      protected DoppeltVerketteteListeElement<E> previous;
    
      DoppeltVerketteteListeElement( E neu, DoppeltVerketteteListeElement<E> vor, DoppeltVerketteteListeElement<E> nach )
      {
          data     = neu;
          previous = nach;
          next     = vor;
      }
    }


// -------- Iterator ------------------------------

//  /**   Iteratorklasse fuer Liste   */

    public class MyIterator<E> implements Iterator<E>
    {
      private DoppeltVerketteteListeElement<E> le;


      public MyIterator( DoppeltVerketteteListeElement<E> start )
      {
          le = start;
      }

      public boolean  hasNext()
      {
          return le != null;
      }

      public E  next()
          throws NoSuchElementException
      {
          if  ( le == null )

              throw new NoSuchElementException( "Kein next-Listenelement !!!" );

          E wert = le.data;

          le = le.next;
          return wert ;
      }

      public void  remove() throws UnsupportedOperationException
      {
          throw new UnsupportedOperationException();
      }
    }


// -------- ListIterator --------------------------

    /**   ListIteratorklasse fuer Liste   */

    public class MyListIterator<E> implements ListIterator<E>
    {
      private DoppeltVerketteteListeElement<E> le;
      private double                  cursor;
      private double                  laenge;
  
      public MyListIterator( DoppeltVerketteteListeElement<E> start, long size )
      {
          le     = start ;
          cursor = -0.5  ;
          laenge = size  ;
      }
  
      public void  add( E neu )
      {
          throw new java.lang.UnsupportedOperationException( "Methode add" );
      }
  
      public boolean  hasNext()
      {
          return  ( laenge > 0.0  &&  Math.ceil( cursor ) < laenge );
      }
  
      public boolean  hasPrevious()
      {
          return  ( laenge > 0.0  &&  Math.ceil( cursor ) > 0.0 );
      }
  
      public E  next()
          throws NoSuchElementException
      {
          if  ( le == null )

            throw new NoSuchElementException( "Kein next-Listenelement !!!" );

          E wert = le.data;

          cursor = cursor + 1.0;

          if  ( Math.ceil( cursor ) < laenge )

              le = le.next ;

          return wert ;
      }
  
      public int  nextIndex()
      {
          return  (int)Math.ceil( cursor ) ;
      }
  
      public E  previous()
          throws NoSuchElementException
      {
          if  ( le == null )

            throw new NoSuchElementException( "Kein previous-Listenelement !!!" );

          E wert = le.data;

          cursor = cursor - 1.0;

          if  ( Math.ceil( cursor ) > 0.0 )

              le = le.previous;

          return wert ;
      }
  
      public int  previousIndex()
      {
          return  (int)Math.floor( cursor ) ;
      }
  
      public void  remove()
      {
          throw new java.lang.UnsupportedOperationException( "Methode remove" );
      }
  
      public void  set( E neu )
      {
          throw new java.lang.UnsupportedOperationException( "Methode set" );
      }
    }

}
