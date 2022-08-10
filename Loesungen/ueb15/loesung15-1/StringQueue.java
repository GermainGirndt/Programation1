/**
 *    ----> StringQueue
 *          --> Implementierung einer StringQueue
 *              mittels der allgemeinen ObjectQueue
 *
 * @author      Wolfgang Pauly
 *
 */

public class StringQueue 
       extends ObjectQueue

{
   private static final String  KEIN_STRING_OBJEKT = "Das einzufuegende Objekt ist KEIN String-Objekt !!";

   /** die Konstruktoren
    *
    */
   public StringQueue(int laenge) {
       super(laenge);
   }

   public StringQueue() {
       super();
   }

   /** Ein String-Element an Queue anfuegen
    *
    *  Vorbedingung: !full() 
    */
   @Override
   public void addLast (Object o) 
   {
     if ( o instanceof String )
       {
        super.addLast( o );
       }
     else
       {
         throw new RuntimeException(KEIN_STRING_OBJEKT);
       }
   }


   /** Erstes Element aus Queue entfernen
    *
    *  Vorbedingung: !empty() 
    *
    *  @return das String-Element an der Spitze der Queue
    */
   @Override
   public String removeFirst () 
   {
     return (String)super.removeFirst();
   }


   /** i'tes Element der Queue zurueckgeben
    *
    *  Vorbedingung: !empty() 
    *
    *  @return das i'te Element der Queue
    */
   @Override
   public String get ( int i ) 
   {
     return (String)super.get(i);
   }

}
