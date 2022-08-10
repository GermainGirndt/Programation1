/**
 *    ----> MitarbeiterException              
 *          --> Realisiert eine einfache MitarbeiterException
 *
 * @version    -1.0 beta 2022-04-11
 * @author    Wolfgang Pauly
 *
 */ 


class MitarbeiterException 
       extends RuntimeException
{
    public static final String E_MAIL_ADRESSEN_FEHLER =
                               "Eine E-Mail muss dem Format : name@domainname entsprechen";

 // das E-Mail-Format einfachst als Muster
    public static final String E_MAIL_FORMAT = "^..*@..*$";


 // der geforderte Standard-Konstruktor
 //
 public MitarbeiterException()
  {
   super();
  }

 // der geforderte Konstruktor mit String-Uebergabeparameter
 //
 public MitarbeiterException( String meldung )
  {
   super( meldung );
  }
  
 /**
   *    ueberprueft, ob der eingegebene E-Mail-Adressen-String
   *    dem Format : name@domainname entspricht
   *    
   *    wirft falls nicht  eine MitarbeiterException 
   *    
   *    @param der uebergebene namensString
   *    @throws MitarbeiterException
   *
   */
  public static void emailAdresseKorrekt( String email )
         throws MitarbeiterException
  {
    if  (  ! email.matches(E_MAIL_FORMAT) )
      {
        throw new MitarbeiterException( 
                        "\n\t" +
                        E_MAIL_ADRESSEN_FEHLER +
                        " !!!!\n\n"
                       );
      }
  }
  
}
