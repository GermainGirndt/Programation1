/**
 * 
 * Beispielloesung fuer die 8. Programmieruebung, so wie
 * sie in der Klausur als Loesung akzeptiert wuerde
 * 
 * die Javadoc-Kommentare koennten weggelassen werden  !!!
 */


/**
 * 
 * Realisierung einer einfachen Patienten-Klasse
 * @author folz, von pauly erweitert
 *
 */
public class Patient 
{

    private int pnr;                  //muss > 0 sein
    private String vorName, famName; //duerfen nicht leer sein


    /**
     * Patient mit Nummer und  Name
     *
     * @param pnr Patientennummer
     * @param vorName Patienten-Vorname
     * @param famName Patienten.Familienname
     */
    public Patient(int pnr, String vorName, String famName) 
    {
    checkArgument( pnr < 0 , "Patientennummer falsch, denn < 0 !! " );
        checkArgument( ((vorName == null) || (vorName.trim().length() <= 0) ||
                        (famName == null) || (famName.trim().length() <= 0)
                   ),
                       "Fehlerhafter Patientenname"
             );

        this.pnr = pnr;
        this.vorName = vorName;
        this.famName = famName;
    }
    

    /**
     *
     * Patientennummer zurueckgeben
     *
     * @return die Patientennummer
     *
     */
    public int getPnr() {
        return pnr;
    }
    
    /**
     *
     * was der Name sagt !!
     *
     */
    public String toString() {
        return pnr + "\t" + vorName + " " + famName;
    }

  /**
   *    wirft bei Fehlersituation eine IllegalArgumentException
   *    
   *    
   *    @param  fehler  -> true  == Fehlersituation
   *                    -> false == KEINE Fehlersituation
   *    @param  meldung -> Fehlermeldungstext zur Fehlersituation
   */
    private void   checkArgument( boolean fehler, String meldung )
      {
       if ( fehler )
         {
           throw new IllegalArgumentException( meldung );
         }
      }

}
