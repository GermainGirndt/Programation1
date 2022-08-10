public class Person 
{
    public static final String NACHNAMENS_MELDUNG = "Es wurde kein Nachname übergeben oder er ist LEER !!!";
    public static final String VORNAMENS_MELDUNG = "Es wurde kein Vorname übergeben oder er ist LEER !!!";

    private  String vorname;
    private  String nachname;

    /**
     * Konstruktor
     * 
     * @param nachname : der Nach-/Familienname der anzulegenden Person
     * @param vorname : der Vorname der anzulegenden Person
     */
    public Person( String nachname, String vorname) 
    {
        setNachname( nachname);
        setVorname( vorname);
    }

    public void setNachname(String nachname) 
    {
        checkArgument( ( (nachname == null) || (nachname.trim().length() <= 0) ), 
                       NACHNAMENS_MELDUNG  
                     );
        this.nachname = nachname;
    }

    public void setVorname(String vorname) 
    {
        checkArgument( ( (vorname == null) || (vorname.trim().length() <= 0) ), 
                       VORNAMENS_MELDUNG  
                     );
        this.vorname = vorname;
    }

    public String getNachname() 
    {
        return nachname;
    }

    public String getVorname() 
    {
        return vorname;
    }

    @Override
    public String toString() 
    {
        return nachname + ", " + vorname;
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
