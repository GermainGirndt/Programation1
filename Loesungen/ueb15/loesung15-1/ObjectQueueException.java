import java.io.*;
    
/**
 *    ----> ObjectQueueException               
 *          --> Realisiert eine einfache ObjectQueueException
 *
 * @version    1.1 Beta 2022-05-05
 * @author    Wolfgang Pauly
 *
 */
  
  
class ObjectQueueException
       extends RuntimeException
{
 public ObjectQueueException()
  {
   super();
  }

 public ObjectQueueException( String meldung )
  {
   super( meldung );
  }
}
