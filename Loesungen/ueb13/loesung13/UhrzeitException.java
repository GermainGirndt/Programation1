/**
 *    ----> UhrzeitException              
 *          --> Realisiert eine einfache UhrzeitException
 *
 * @version    -1.0 beta 2022-04-11
 * @author    Wolfgang Pauly
 *
 */ 

class UhrzeitException 
       extends RuntimeException
{
    // Konstanten
    public static final int MAX_STUNDE = 23;
    public static final int MIN_STUNDE =  0;
    public static final String STUNDEN_FEHLER =
                               "Die Stundenangaben muessen zwischen " +
                               MIN_STUNDE + " und " + MAX_STUNDE + "liegen";

    public static final int MAX_MINUTE = 59;
    public static final int MIN_MINUTE =  0;
    public static final String MINUTEN_FEHLER =
                               "Die Minutenangaben muessen zwischen " +
                               MIN_MINUTE + " und " + MAX_MINUTE + "liegen";


 // der geforderte Standard-Konstruktor
 //
 public UhrzeitException()
  {
   super();
  }

 // der geforderte Konstruktor mit String-Uebergabeparameter
 //
 public UhrzeitException( String meldung )
  {
   super( meldung );
  }
  
 /**
   *    ueberprueft, ob die Eingegebene StundenAngabe
   *    korrekt ist
   *    
   *    wirft falls nicht  eine UhrzeitException 
   *    
   *    @param die uebergebene StundenAngabe
   *    @throws UhrzeitException
   *
   */
  public static void stundeKorrekt( int stundenAngabe )
         throws UhrzeitException
  {
    if  ( (stundenAngabe < MIN_STUNDE) || (stundenAngabe > MAX_STUNDE) )
      {
        throw new UhrzeitException( 
                        "\n\t" +
                        STUNDEN_FEHLER +
                        " !!!!\n\n"
                       );
      }
  }
  
 /**
   *    ueberprueft, ob die Eingegebene MinutenAngabe
   *    korrekt ist
   *    
   *    wirft falls nicht  eine UhrzeitException 
   *    
   *    @param die uebergebene MinutenAngabe
   *    @throws UhrzeitException
   *
   */
  public static void minuteKorrekt( int minutenAngabe )
         throws UhrzeitException
  {
    if  ( (minutenAngabe < MIN_MINUTE) || (minutenAngabe > MAX_MINUTE) )
      {
        throw new UhrzeitException( 
                        "\n\t" +
                        MINUTEN_FEHLER +
                        " !!!!\n\n"
                       );
      }
  }
}
