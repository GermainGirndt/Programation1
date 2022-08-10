
/**
 * Die Klasse Raum repraesentiert einen Raum
 *                    mit Gebaeude-, Etagen-Angaben  und Raum-Nummer
 *
 * @author Wolfgang Pauly
 * @version -1.0 beta 2022-04-11
 */

public class Raum
{
    // Konstanten
    public static final int MAX_RESERVIERUNGEN = 24;
    public static final String GEBAEUDE_ANGABE_FEHLERHAFT = 
                        "Die Gebaeude-Nummer muss >= 0 sein !!!!";
    public static final String ETAGEN_ANGABE_FEHLERHAFT = 
                        "Die Etagen-Nummer muss >= 0 sein !!!!";
    public static final String RAUM_ANGABE_FEHLERHAFT = 
                        "Die Raum-Nummer muss >= 0 sein !!!!";
    public static final String KEINE_RESERVIERUNG_MOEGLICH = 
                        "Die Raumreservierungsliste ist belegt, keine Reservierung mehr moeglich ";
    public static final String KEINE_RESERVIERUNG_UEBERGEBEN = 
                        "Die uebergebene Raumreservierung ist leer !!";
                        
    // Attribute (Instanzvariablen)
    private int geb;
    private int etage;
    private int raum;

    private Reservierung[] reservierungsListe;
    private int anzahlReservierungen;



    /**
     * Konstruktor für Objekte der Klasse Person
     * 
     * @param initGebaeude Gebaeude-Nummer  
     * @param initEtage Etagen-Nummer
     * @param initRaumNr Raum-Nummer
     */
    public Raum(int initGebaeude, int initEtage, int initRaumNr)
    {
      if ( initGebaeude >= 0 )
        {
          geb    = initGebaeude;
        }
        else
          throw new RaumException( GEBAEUDE_ANGABE_FEHLERHAFT );

      if ( initEtage >= 0 )
        {
          etage  = initEtage;
        }
        else
          throw new RaumException( ETAGEN_ANGABE_FEHLERHAFT );

      if ( initRaumNr >= 0 )
        {
          raum   = initRaumNr;
        }
        else
          throw new RaumException( RAUM_ANGABE_FEHLERHAFT );


      reservierungsListe = new Reservierung[MAX_RESERVIERUNGEN];
      anzahlReservierungen = 0;
    }


    /**
     * addReservierung - fuegt einem Raum eine Revervierung hinzu
     *
     * @param  neuneReservierung die neue Reservierung
     */
    public void addReservierung( Reservierung neueReservierung )
           throws RaumException
    {
      if ( neueReservierung == null )
        {
           throw new RaumException( KEINE_RESERVIERUNG_UEBERGEBEN ); 
        }
        
      if ( anzahlReservierungen < MAX_RESERVIERUNGEN )
        {
          reservierungsListe[anzahlReservierungen] = neueReservierung;
          anzahlReservierungen++;
        }
        else
          throw new RaumException( KEINE_RESERVIERUNG_MOEGLICH );
    }

    /**
     * Die getGeb-Methode
     * 
     */
    public int getGeb()
    {
        return geb;
    }

    /**
     * Die getEtage-Methode
     * 
     */
    public int getEtage()
    {
        return etage;
    }

    /**
     * Die getRaum-Methode
     * 
     */
    public int getRaum()
    {
        return raum;
    }


    /**
     * Die getAnzahlReservierungen-Methode
     * 
     */
    public int getAnzahlReservierungen()
    {
        return anzahlReservierungen;
    }

    /**
     * Die getReservierung-Methode
     * 
     */
    public Reservierung getReservierung(int index)
           throws RaumException
    {
        RaumException.istIndexGueltig( index, anzahlReservierungen )   ;
        return reservierungsListe[index];
    }

    /**
     * Die equals-Methode
     * 
     * Compares this object to the specified object. 
     * The result is true if and only if the argument is not null and is an Raum-Object 
     * that contains the same values for geb, etage, raum as this object
     */
    public boolean equals(Object vergleichsRaum)
    {
        return  ( vergleichsRaum != null ) &&
                ( vergleichsRaum instanceof Raum) &&
                ( ( (Raum)vergleichsRaum).getGeb() == geb ) &&
                ( ( (Raum)vergleichsRaum).getEtage() == etage ) &&
                ( ( (Raum)vergleichsRaum).getRaum() == raum);
    }


    /**
     * Die toString-Methode
     *
     */
    public String toString()
    {
        String ausgabe = new String ( "Raum " + geb + "-" + etage + "." + raum);
        for ( int i = 0; i < anzahlReservierungen; i++ )
           {
             ausgabe += "\n" + reservierungsListe[i];
           }
        return ausgabe;
    }

}
