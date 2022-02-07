
/**
 * Beschreiben Sie hier die Klasse Validierung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Validierung
{


    /**
     * Konstruktor für Objekte der Klasse Validierung
     */
    private Validierung()
    {  }

    public static void validiereArgsLaenge(String[] args){
        if (args.length == 0) {
            throw new IllegalArgumentException("Proper Usage is: java LOCAuswertung filename(s)");
        }
    }
    
     public static void validiereNichtLeer(String text){
        text = text.trim();
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Dateiname ist leer");
        }
    }
}
