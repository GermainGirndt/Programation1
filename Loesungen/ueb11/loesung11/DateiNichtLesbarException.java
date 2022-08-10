import java.io.*;
    
/**   ----> DateiNichtLesbarException              
 *          --> Realisiert eine einfache DateiNichtLesbarException
 *
 * @version	1.1 Beta 2022-01-28
 * @author	Wolfgang Pauly
 */ 


class DateiNichtLesbarException 
       extends RuntimeException
{
  // der geforderte Standard-Konstruktor

  public DateiNichtLesbarException() { super(); }

  // der geforderte Konstruktor mit String-Uebergabeparameter

  public DateiNichtLesbarException( String meldung )
  {
    super( meldung );
  }
  
  /**   ueberprueft, ob das uebergebene File lesbar ist
   *    
   *    wirft falls nicht  eine DateiNichtLesbarException 
   *    
   *    @param datei zu ueberpruefendes File
   *    @throws DateiNichtLesbarException
   */
  public static void istLesbar( File datei )
  {
    if  ( datei.exists() )
    {
       if  ( ! datei.canRead() )

         throw new DateiNichtLesbarException( 
                     "Die Datei mit dem Namen --> " + datei.getName() + 
                     "<-- existiert ist aber nicht lesbar !!!\n\n" );
      }
      else
          throw new DateiNichtLesbarException( 
                      "Die Datei mit dem Namen --> " + datei.getName() + 
                      "<-- existiert nicht !!!\n\n" );
  }
}
