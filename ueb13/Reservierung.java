
/**
 * Beschreiben Sie hier die Klasse Reservierung.
 * 
 * @author Girndt & Krier
 * @version 1.0
 */
public class Reservierung
{
    private String bemerkung = "";
    private Uhrzeit beginn;
    private Uhrzeit ende;
    private Mitarbeiter mitarbeiter;
    
    private static final String FEHLER_BEGINN        = "Die Anfangsuhrzeit ist null";
    private static final String FEHLER_ENDE          = "Die Enduhrzeit ist null";
    private static final String FEHLER_BEMERKUNG     = "Die Bemerkung ist leer";
    private static final String FEHLER_MITARBEITER   = "Der Mitarbeiter ist null";
    private static final String FEHLER_RAUM          = "Der Raum ist null";
    private static final String FEHLER_ZEIT          = "Das Ende muss in der Zukunft vom Beginn liegen";
    
    /**
     * Konstruktor für Objekte der Klasse Reservierung
     * @param beginn ist der Anfangszeitpunkt der Reservierung
     * @param ende ist der Endzeitpunkt der Reservierung
     * Der Endzeitpunkt muss in der Zukunft vom Anfangszeitpunkt liegen
     */
    public Reservierung(Uhrzeit beginn, Uhrzeit ende)
    {
        if (beginn == null) {
            throw new IllegalArgumentException(FEHLER_BEGINN);   
        }
        if (ende == null) {
            throw new IllegalArgumentException(FEHLER_ENDE);   
        }
        if (beginn.getStunde() > ende.getStunde()
            || (beginn.getStunde() == ende.getStunde()
            && beginn.getMinute() >= ende.getMinute())) {
              
            throw new IllegalArgumentException(FEHLER_ZEIT); 
        }
        this.beginn = beginn;
        this.ende   = ende;  
    }

    public void setBemerkung(String bemerkung) {
        if (bemerkung == null || bemerkung.strip().isEmpty()) {
             throw new IllegalArgumentException(FEHLER_BEMERKUNG);       
        }
        this.bemerkung = bemerkung;
    }
    
    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        if (mitarbeiter == null) {
            throw new IllegalArgumentException(FEHLER_MITARBEITER);       
        }
        this.mitarbeiter = mitarbeiter;
    }
    
    /**
     * setRaum gibt dem Uebergebenen Raum sich selbst mit 
     * @param raum ist der Raum, dem diese Reservierung uebergeben werden soll
     */
    public void setRaum(Raum raum) {
        if (raum == null) {
            throw new IllegalArgumentException(FEHLER_RAUM);       
        } 
        raum.addReservierung(this);   
    }
    
    @Override
    public String toString() {

        if (mitarbeiter == null) {

            return String.format("gebucht von %s bis %s fuer %s", 
                                    beginn.toString(),
                                    ende.toString(),
                                    bemerkung);
        } 
        
        return String.format("gebucht von %s von %s bis %s fuer %s",
                                mitarbeiter.toString(), 
                                beginn.toString(),
                                ende.toString(),
                                bemerkung);

    }
}
