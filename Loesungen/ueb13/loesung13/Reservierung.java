
/**
 * Die Klasse Reservierung repraesentiert eine Reservierung
 *                    mit Raum, Reservierungszeitraum ( Beginn & Ende )
 *                    sowie dem Reservierungsgrund
 *
 * @author Wolfgang Pauly
 * @version -1.0 beta 2022-04-11
 */

public class Reservierung
{
    // Attribute (Instanzvariablen)
    private Uhrzeit beginn;
    private Uhrzeit ende;
    private String bemerkung;
    private Raum raum;
    private Mitarbeiter mitarbeiter;

    /**
     * Konstruktor für Objekte der Klasse Reservierung
     *
     * @param  initBeginn    Beginn-Zeitpunkt der Reservierung
     * @param  initEnde      Ende-Zeitpunkt der Reservierung
     * @param  initBemerkung    Bemerkung zum Reservierungsgrund
     * @param  initRaum   der zu reservierende Raum
     */
    public Reservierung( Uhrzeit initBeginn, Uhrzeit initEnde, String initBemerkung,
                         Raum initRaum, Mitarbeiter initMitarbeiter )
    {
      beginn    = initBeginn;
      ende      = initEnde;
      bemerkung = initBemerkung;
      raum      = initRaum;
      mitarbeiter = initMitarbeiter;
    }

    /**
     * Konstruktor für Objekte der Klasse Reservierung
     *
     * @param  initBeginn    Beginn-Zeitpunkt der Reservierung
     * @param  initEnde      Ende-Zeitpunkt der Reservierung
     */
    public Reservierung( Uhrzeit initBeginn, Uhrzeit initEnde )
    {
      this( initBeginn, initEnde, null, null, null);
    }


    /**
     * setBemerkung - setzt den Reservierungsgrund
     * 
     * @param  initBemerkung    Bemerkung zum Reservierungsgrund
     */
    public void setBemerkung( String neueBemerkung)
    {
        bemerkung = neueBemerkung;
    }


    /**
     * setMitarbeiter - setzt den reservierenden Mitarbeiter
     * 
     * @param  initMitarbeiter   der reservierende Mitarbeiter
     */
    public void setMitarbeiter( Mitarbeiter initMitarbeiter)
    {
        mitarbeiter = initMitarbeiter;
    }


    /**
     * setRaum - setzt den reservierenden Raum
     * 
     * @param  initRaum   der zu reservierende Raum
     */
    public void setRaum( Raum neuerRaum)
    {
        raum = neuerRaum;
    }

    /**
     * Die getBemerkung-Methode
     * 
     */
    public String getBemerkung()
    {
        return bemerkung;
    }

    /**
     * Die getBeginn-Methode
     * 
     */
    public Uhrzeit getBeginn()
    {
        return beginn;
    }

    /**
     * Die getEnde-Methode
     * 
     */
    public Uhrzeit getEnde()
    {
        return ende;
    }

    /**
     * Die getRaum-Methode
     * 
     */
    public Raum getRaum()
    {
        return raum;
    }

    /**
     * Die getMitarbeiter-Methode
     * 
     */
    public Mitarbeiter getMitarbeiter()
    {
        return mitarbeiter;
    }

    /**
     * Die equals-Methode
     * 
     * Compares this object to the specified object. 
     * The result is true if and only if the argument is not null and is an Reservierung-Object 
     * that contains the same values for bemerkung, beginn, ende, mitarbeiter, raum as this object
     */
    public boolean equals(Object vergleichsReservierung)
    {
        return  ( vergleichsReservierung != null ) &&
                ( vergleichsReservierung instanceof Reservierung) &&
                ( ( (Reservierung)vergleichsReservierung).getBemerkung() == bemerkung ) &&
                ( ( (Reservierung)vergleichsReservierung).getBeginn() == beginn ) &&
                ( ( (Reservierung)vergleichsReservierung).getEnde() == ende) &&
                ( ( (Raum)((Reservierung)vergleichsReservierung).getRaum()).equals(this.getRaum())) &&
                ( ( (Mitarbeiter)((Reservierung)vergleichsReservierung).getMitarbeiter()).equals(this.getMitarbeiter()));
    }


    /**
     * Die toString-Methode
     *
     */
    public String toString()
    {
        return "gebucht von " + mitarbeiter + " von " + beginn + " bis " + ende + " fuer " + bemerkung;
    }

}
