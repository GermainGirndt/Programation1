import java.io.*;
    
/**   ----> DateiKeineNormaleDateiException              
 *          --> Realisiert eine einfache DateiKeineNormaleDateiException
 *
 * @version	1.1 Beta 2022-01-28
 * @author	Wolfgang Pauly
 */ 


class DateiKeineNormaleDateiException 
      extends RuntimeException
{
  // der geforderte Standard-Konstruktor

  public DateiKeineNormaleDateiException() { super(); }

  // der geforderte Konstruktor mit String-Uebergabeparameter

  public DateiKeineNormaleDateiException( String meldung )
  {
    super( meldung );
  }
  
  /**   ueberprueft, ob das uebergebene File 
   *    eine normale Date ist, also z.B. kein Directory
   *    
   *    wirft falls nicht  eine DateiKeineNormaleDateiException 
   *    
   *    @param datei zu ueberpruefendes File
   *    @throws DateiKeineNormaleDateiException
   */
  public static void istNormaleDatei( File datei )
  {
    if  ( datei.exists() )
    {
      if  ( ! datei.isFile() )

        throw new DateiKeineNormaleDateiException( 
                    "Die Datei mit dem Namen --> " + datei.getName() + 
                    "<-- existiert ist aber keine normale Datei !!!\n\n" );
    }
    else
        throw new DateiNichtLesbarException( 
                    "Eine Datei mit dem Namen --> " + datei.getName() + 
                    "<-- existiert nicht !!!\n\n" );
  }
}
