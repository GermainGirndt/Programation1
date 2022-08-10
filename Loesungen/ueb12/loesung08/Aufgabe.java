
/**
 * Aufgabe innerhalb eines Projektes
 * 
 * @author Folz
 * @version 2013
 *
 * von wpy ergaenzt um weiteren Konstruktor
 */
public class Aufgabe extends Projektbestandteil {
    public static String MSG_AUFWAND = "Aufwand darf nicht negativ sein!";

    public static int STANDARD_AUFWAND = 0;
    private int aufwand; // Aufwand in Stunden
    
    public Aufgabe(String name, String beschreibung) {
        super(name, beschreibung);
        this.aufwand = STANDARD_AUFWAND;
    }

    public Aufgabe(String name, String beschreibung, int aufwand) {
        super(name, beschreibung);
        assert aufwand >= 0 : MSG_AUFWAND;
        this.aufwand = aufwand;
    }
    
    /**
     * Kosten ermitteln aus Aufwand in Stunden und Stundensatz
     * Dazu muss ein Projekt zugeordnet sein.
     *
     * @return ermittelte Kosten in Euro
     */
    public double getKosten() {
        assert projekt != null : MSG_PROJEKT;
        return aufwand * projekt.getStundensatz();
    }

    public int getAufwand() {
        return aufwand;
    }

    public void setAufwand( int aufwand ) {
        assert aufwand >= 0 : MSG_AUFWAND;
        this.aufwand = aufwand;
    }
    
    public String toString() {
        return String.format("%s\tAufwand: %4d h", super.toString(), aufwand); 
    }
}
