/**
 *    ----> PersonException              
 *          --> Realisiert eine einfache PersonException
 *
 * @version    -1.0 beta 2022-04-11
 * @author    Wolfgang Pauly
 *
 */ 

class PersonException 
       extends RuntimeException
{
    public static final String NAMENS_FEHLER =
                               "Ein Name darf nicht nur aus Whitespaces bestehen";


 // der geforderte Standard-Konstruktor
 //
 public PersonException()
  {
   super();
  }

 // der geforderte Konstruktor mit String-Uebergabeparameter
 //
 public PersonException( String meldung )
  {
   super( meldung );
  }
  
 /**
   *    ueberprueft, ob der eingegebene namensString
   *    nicht nur aus Whitespaces besteht
   *    
   *    wirft falls nicht  eine PersonException 
   *    
   *    @param der uebergebene namensString
   *    @throws PersonException
   *
   */
  public static void nameKorrekt( String name )
         throws PersonException
  {
    if  ( ( name == null) || (name.trim().length() == 0)  )
      {
        throw new PersonException( 
                        "\n\t" +
                        NAMENS_FEHLER +
                        " !!!!\n\n"
                       );
      }
  }
  
}
