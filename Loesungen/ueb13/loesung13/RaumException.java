/**
 *    ----> RaumException              
 *          --> Realisiert eine einfache RaumException
 *
 * @version    -1.0 beta 2022-04-11
 * @author    Wolfgang Pauly
 *
 */ 

class RaumException 
       extends RuntimeException
{

 public static final String INDEX_FEHLER_1 = "Der eingegebene Index muss zwischen 0 und ";
 public static final String INDEX_FEHLER_2 = " liegen";

 // der geforderte Standard-Konstruktor
 //
 public RaumException()
  {
   super();
  }

 // der geforderte Konstruktor mit String-Uebergabeparameter
 //
 public RaumException( String meldung )
  {
   super( meldung );
  }
  
 /**
  *    wirft eine RaumException wenn 
  *    0 < index && index > anzahlReservierungen -1
  *    
  *    
  *    @param index der zu ueberpruefende Index
  *    @param anzahlReservierungen Anzahl der aktuellen Raumreservierungen
  *    @throws RaumException
  *
  */
  public static void istIndexGueltig( int index, int anzahlReservierungen )
         throws RaumException
  {
    if  ( (index < 0) && (index > anzahlReservierungen ) )
      {
        throw new RaumException( 
                        "\n\t" + INDEX_FEHLER_1 +
                        anzahlReservierungen +
                        INDEX_FEHLER_2 + " !!!!\n\n"
                       );
      }
  }

}
