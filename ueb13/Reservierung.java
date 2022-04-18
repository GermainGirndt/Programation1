
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
        if (!ende.istDanach(beginn)) {              
            throw new IllegalArgumentException(FEHLER_ZEIT); 
        }

        this.beginn = beginn;
        this.ende   = ende;  
    }

    public boolean hatUerberschneidung(Reservierung reservierung) {
        Uhrzeit beginn = reservierung.getBeginn();
        Uhrzeit ende = reservierung.getEnde();

        if (this.beginn.istGleich(beginn)
            || this.ende.istGleich(ende)) {
            return true;
        }

        // Überschneidungen auf der linken Seite 
        if (this.beginn.istDanach(beginn)
            && this.beginn.istDavor(ende)) {
                return true;
        }

        // Überschneidungen auf der rechten Seite
        if (this.ende.istDanach(beginn)
        && this.ende.istDavor(ende) 
        ) {
            return true;
        }
        
        // Enthält Uhrzeit 
        if (this.beginn.istDavor(beginn)
            && this.ende.istDanach(ende))  {
                return true;
            }
        
        return false;
    }


    public Uhrzeit getBeginn() {
        return this.beginn;
    }

    public Uhrzeit getEnde() {
        return this.ende;
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
