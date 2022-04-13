
/**
 * Beschreiben Sie hier die Klasse Reservierung.
 * 
 * @author Girndt & Krier
 * @version 1.0
 */
public class Reservierung
{
    private String bemerkung;
    private Uhrzeit beginn;
    private Uhrzeit ende;
    private Mitarbeiter mitarbeiter;
    
    private static String FEHLER_BEGINN        = "Die Anfangsuhrzeit ist null";
    private static String FEHLER_ENDE          = "Die Enduhrzeit ist null";
    private static String FEHLER_BEMERKUNG     = "Die Bemerkung ist leer";
    private static String FEHLER_MITARBEITER   = "Der Mitarbeiter ist null";
    private static String FEHLER_RAUM          = "Der Raum ist null";
    
    /**
     * Konstruktor für Objekte der Klasse Reservierung
     */
    public Reservierung(Uhrzeit beginn, Uhrzeit ende)
    {
        //toDo pruefen ob beginn vor ende liegt
        if(beginn == null){
            throw new IllegalArgumentException(FEHLER_BEGINN);   
        }
        if(ende == null){
            throw new IllegalArgumentException(FEHLER_ENDE);   
        }
        this.beginn = beginn;
        this.ende   = ende;  
    }

    public void setBemerkung(String bemerkung){
        if(bemerkung == null || bemerkung.strip().isEmpty()){
             throw new IllegalArgumentException(FEHLER_BEMERKUNG);       
        }
        this.bemerkung = bemerkung;
    }
    
    public void setMitarbeiter(Mitarbeiter mitarbeiter){
        if(mitarbeiter == null){
            throw new IllegalArgumentException(FEHLER_MITARBEITER);       
        }
        this.mitarbeiter = mitarbeiter;
    }
    
    public void setRaum(Raum raum){
        if(raum == null){
            throw new IllegalArgumentException(FEHLER_RAUM);       
        } 
        raum.addReservierung(this);   
    }
    
    @Override
    public String toString(){
        return "gebucht von " + mitarbeiter.toString() + 
               " von "        + beginn.toString() + 
               " bis "        + ende.toString() +
               " fuer "       + bemerkung;
    }
}
