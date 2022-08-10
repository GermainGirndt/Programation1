
/*
 * Die Klasse Mitarbeiter repraesentiert einen Mitarbeiter
 *                    mit Vorname, Nachname und E-Mail-Adresse
 *
 * @author Wolfgang Pauly
 * @version -1.0 beta 2022-04-11
 */

public class Mitarbeiter 
       extends Person
{
    // Attribute (Instanzvariablen)
    private String email;

    /**
     * Konstruktor für Objekte der Klasse Mitarbeiter
     * 
     * @param initVorname Der Vorname des zu erzeugenden Mitarbeiters
     * @param initNachname Der Nachname des zu erzeugenden Mitarbeiters
     * @param initEmail Die E-Mail-Adresse des zu erzeugenden Mitarbeiters
     */
    public Mitarbeiter( String initVorname, String initNachname, String initEmail)
           throws PersonException, MitarbeiterException
    {
        super( initVorname, initNachname );
        MitarbeiterException.emailAdresseKorrekt( initEmail );
        email = initEmail;
    }

    /**
     * reserviere - reserviert einen Raum fuer eine gegebenen Zeitraum
     * 
     * @param  raum der zu reservierende Raum
     * @param  beginn der Beginn-Zeitpunkt der Reservierung
     * @param  ende der Ende-Zeitpunkt der Reservierung
     * @param  bemerkung Beschreibung der Veranstaltung
     */
    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bemerkung)
           throws RaumException
    {
      Reservierung neueReservierung = new Reservierung( beginn, ende, bemerkung, raum, this );
      raum.addReservierung( neueReservierung );
    }

    /**
    * Die getEmail-Methode
    * 
    */
    public String getEmail()
    {
        return email;
    }

    /**
    * Die equals-Methode
    * 
    * Compares this object to the specified object. 
    * The result is true if and only if the argument is not null and is an Mitarbeiter-Object 
    * that contains the same values for vorname, nachname, email as this object
    */
    public boolean equals(Object vergleichsMitarbeiter)
    {
        return  ( vergleichsMitarbeiter != null ) &&
                ( vergleichsMitarbeiter instanceof Mitarbeiter) &&
                ((Mitarbeiter)vergleichsMitarbeiter).getVorname().equals(this.getVorname()) &&
                ((Mitarbeiter)vergleichsMitarbeiter).getNachname().equals(this.getNachname()) &&
                ((Mitarbeiter)vergleichsMitarbeiter).getEmail().equals(email);
    }

    /**
     * Die toString-Methode
     *
     */
    public String toString()
    {
        return super.toString() + " (" + email + ")";
    }

}
