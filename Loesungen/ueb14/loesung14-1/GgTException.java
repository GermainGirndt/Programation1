/**
 *    ----> GgTException              
 *          --> Realisiert eine einfache GgTException
 *
 * @version    -1.0 beta 2022-04-27
 * @author    Wolfgang Pauly
 *
 */ 

class GgTException 
       extends RuntimeException
{
    // Konstanten
    public static final String GGT_FEHLER =
                               "Bei der GGT-Berechnung sind negative Zahlen nicht erlaubt !";


 // der geforderte Standard-Konstruktor
 //
 public GgTException()
  {
   super();
  }

 // der geforderte Konstruktor mit String-Uebergabeparameter
 //
 public GgTException( String meldung )
  {
   super( meldung );
  }
  
 /**
   *    ueberprueft, ob die Eingegebene Zahl >= 0
   *    
   *    wirft falls nicht  eine GgTException 
   *    
   *    @param die uebergebene Zahl
   *
   */
  public static void zahlKorrekt( long zahl )
  {
    if  ( zahl < 0 )
      {
        throw new GgTException( 
                        "\n\t" +
                        GGT_FEHLER +
                        " !!!!\n\n"
                       );
      }
  }
  
}
