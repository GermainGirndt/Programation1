/**
 *    ----> PersonQueue
 *          --> Implementierung einer PersonQueue
 *              mittels der allgemeinen ObjectQueue
 *
 * @author      Wolfgang Pauly
 *
 */

public class PersonQueue 
       extends ObjectQueue
{
   private static final String  KEIN_PERSON_OBJEKT = "Das einzufuegende Objekt ist KEIN Person-Objekt !!";

   /** der Konstruktor
    *
    */
   public PersonQueue(int laenge) {
       super(laenge);
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
         throw new RuntimeException(KEIN_PERSON_OBJEKT);
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

}
