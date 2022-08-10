/**
 *    ----> PalindromException              
 *          --> Realisiert eine einfache PalindromException
 *
* @version    -1.0 beta 2022-04-27
 * @author    Wolfgang Pauly
 *
 */ 

class PalindromException 
       extends RuntimeException
{
    // Konstanten
    public static final String PALINDROM_FEHLER =
                               "Bei der Palindorm-Testung muss ein String uebergeben werden; keine null !";


 // der geforderte Standard-Konstruktor
 //
 public PalindromException()
  {
   super();
  }

 // der geforderte Konstruktor mit String-Uebergabeparameter
 //
 public PalindromException( String meldung )
  {
   super( meldung );
  }
  
 /**
   *    ueberprueft, ob der Übergaberparameter != null ist
   *    
   *    wirft falls nicht  eine PalindromException 
   *    
   *    @param zuTesten --> der uebergebene String
   *
   */
  public static void stringTest( String zuTesten )
  {
    if  ( zuTesten == null )
      {
        throw new PalindromException( 
                        "\n\t" +
                        PALINDROM_FEHLER +
                        " !!!!\n\n"
                       );
      }
  }
  
}
