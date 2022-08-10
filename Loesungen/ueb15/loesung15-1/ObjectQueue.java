/**
 *    ----> ObjectQueue
 *          --> Implementierung einer ObjectQueue
 *              mittels Object-Array
 *
 * @author      Wolfgang Pauly
 *
 */


public class ObjectQueue 
       implements Queue
{


   public static final int QUEUE_STANDARD_LAENGE = 10;

   private static final String  QUEUE_IST_VOLL = "Die Queue ist vollstaendig belegt !!!";
   private static final String  QUEUE_IST_LEER = "Die Queue ist vollstaendig leer !!!";
   private static final String  INDEX_OUT_OFF_RANGE = "Der angegebene Index ist groesser als die laenge der Queue !";
   private static final String  QUEUE_LAENGE_FEHLERHAFT = "Die Queue-Laenge muss > 0 sein !!!";
   private static final String  OBJECT_IST_NULL = "Das uebergebene Object ist LEER/null!!";
   // das Queue-Array
   private Object[] queue;
   private int size;


   /** der Konstruktor
    *
    */
   public ObjectQueue(int laenge) {
       if ( laenge <= 0 )
         {
           throw new ObjectQueueException(QUEUE_LAENGE_FEHLERHAFT);
         }
       queue = new Object[laenge];
       size = 0;
   }


   /** der Standard-Konstruktor
    *
    */
   public ObjectQueue() {
       this(QUEUE_STANDARD_LAENGE);
   }

   /** Ein Element an Queue anfuegen
    *
    *  Vorbedingung: !full() 
    */
   public void addLast (Object o) 
   {
     if ( o == null )
       {
         throw new ObjectQueueException(OBJECT_IST_NULL);
       }
    
     if ( full() )
       {
         throw new ObjectQueueException(QUEUE_IST_VOLL);
       }
    
     queue[size] = o;
     size++;
   }


   /** Erstes Element aus Queue entfernen
    *
    *  Vorbedingung: !empty() 
    *
    *  @return das Element an der Spitze der Queue
    */
   public Object removeFirst () 
   {
     if ( empty() )
       {
         throw new ObjectQueueException(QUEUE_IST_LEER);
       }
    
     int i;
     Object helfer = queue[0];
     size--;
     for ( i = 0; i < size; i++ )
       {
        queue[i] = queue[i+1];
       }
     queue[i] = null;  
     return helfer;
   }


   /** i'tes Element der Queue zurueckgeben
    *
    *  Vorbedingung: !empty() 
    *
    *  @return das i'te Element der Queue
    */
   public Object get ( int i ) 
   {
     if ( empty() )
       {
         throw new ObjectQueueException(QUEUE_IST_LEER);
       }
    
     if ( (i < 0 ) || (i > size) )
       {
         throw new ObjectQueueException(INDEX_OUT_OFF_RANGE);
       }
    
     return queue[i];
   }


   /** Ist die Queue VOLL?      
    *
    * @return true wenn Queue VOLL, sonst false
    */
   public boolean full  () 
   {
     return ( size == queue.length );
   }


   /** Ist die Queue LEER?      
    *
    * @return true wenn Queue LEER, sonst false
    */
   public boolean empty  () 
   {
     return ( size == 0 );
   }


   /** Wieviel Elemente enthaelt die Queue?
    *
    * @return Anzahl der Elementen in der Queue
    */
   public int size  () 
   {
     return size;
   }


   /** die Std-Methode toString
    *
    */
   public String toString() 
   {
     StringBuffer sb = new StringBuffer();

     for ( int index = 0; index < size; index++)
        {
           sb.append(queue[index] + " - ");
        }
     return sb.toString();
   }
}
