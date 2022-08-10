import java.io.*;
    
/**
 *    ----> PersonQueueException               
 *          --> Realisiert eine einfache PersonQueueException
 *
 * @version    1.1 Beta 2022-05-05
 * @author    Wolfgang Pauly
 *
 */
  
  
class PersonQueueException
       extends ObjectQueueException
{
 public PersonQueueException()
  {
   super();
  }

 public PersonQueueException( String meldung )
  {
   super( meldung );
  }
}

