
/**
 *    ----> PersonQueue
 *          --> Implementierung einer PersonQueue
 *              mittels der allgemeinen ObjectQueue
 *
 * @author      Wolfgang Pauly
 *
 */

import java.util.*;

public class PersonQueue 
       extends ObjectQueue
{
   private static final String  KEIN_PERSON_OBJEKT = "Das einzufuegende Objekt ist KEIN Person-Objekt !!";


   /** die Konstruktoren
    *
    */
   public PersonQueue(int laenge) {
       super(laenge);
   }

   public PersonQueue() {
       super();
   }



   /** Ein Person-Element an Queue anfuegen
    *
    *  Vorbedingung: !full() 
    */
   @Override
   public void addLast (Object o) 
   {
     if ( o instanceof Person )
       {
        super.addLast( o );
       }
     else
       {
         throw new PersonQueueException(KEIN_PERSON_OBJEKT);
       }
   }


   /** Erstes Element aus Queue entfernen
    *
    *  Vorbedingung: !empty() 
    *
    *  @return das Person-Element an der Spitze der Queue
    */
   @Override
   public Person removeFirst () 
   {
     return (Person)super.removeFirst();
   }


   /** i'tes Element der Queue zurueckgeben
    *
    *  Vorbedingung: !empty() 
    *
    *  @return das i'te Element der Queue
    */
   @Override
   public Person get ( int i ) 
   {
     return (Person)super.get(i);
   }


   /* vvvvvvvvvvvvvvvvvvvvv Erweiterungen fuer Aufgabe 16 */

   interface PersonIterator extends java.util.Iterator<Person> {};

   public class PersonItr implements PersonIterator 
     {

       private int nextIndex;
       
       public PersonItr()
         {
           nextIndex = 1;
         }

       public boolean hasNext() 
         {
           return (nextIndex  <= size() );
         }
   
       public Person next() throws NoSuchElementException
         {
           Person nextPerson = get( nextIndex );
           
           nextIndex++;
           return  nextPerson;
         }
     }


   /** Die Queue auf dem Bildschirm ausgeben
    *
    *
    *  @return String-Representation der Personwn-Queue
    */
   @Override
   public String toString()
     {
       StringBuffer sb = new StringBuffer();

       PersonIterator pIterator = new PersonItr();

       sb.append("\nDer Inhalt der PersonenQueue :");
       sb.append("\n------------------------------\n");
       
       while ( pIterator.hasNext() )
         {
           sb.append("\t" + pIterator.next() + "\n");
         }
       return sb.toString();     
     }


   /** Liefert den lexikalisch kleinsten Vornamen
    *
    *
    *  @return void
    */
   public String smallest()
     {
       String kleinsterVorname, helfer;

       PersonIterator pIterator = new PersonItr();
       
       if  ( pIterator.hasNext() )
         {
          kleinsterVorname =  pIterator.next().getVorname();
          while ( pIterator.hasNext() )
            {
             helfer = pIterator.next().getVorname();
             // hier waer auch compareToIgnoreCase() moeglich 
             if ( helfer.compareTo( kleinsterVorname ) < 0 )
               {
                 kleinsterVorname = helfer;
               }
               // zu Testzwecken: System.out.println( "Kleinster = " + kleinsterVorname + "\thelfer = " + helfer );
            }
         }
       else
         {
          kleinsterVorname = new String("Queue noch leer !!!");
         }
      return kleinsterVorname;
     }

}
