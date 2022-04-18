
/**
 * Beschreiben Sie hier die Klasse Uhrzeit.
 * Die Klasse Uhrzeit ist zum Erstellen gängiger Uhrzeiten da
 * 
 * @author Girndt & Krier
 * @version 1.0
 */
public class Uhrzeit
{
    private int stunde;
    private int minute;
    
    private static final int STUNDE_MIN         = 0;
    private static final int STUNDE_MAX         = 23;
    private static final int MINUTE_MIN         = 0;
    private static final int MINUTE_MAX         = 59;
    
    private static final String FEHLER_KEINE_STUNDE = "Die Stunde muss zwischen 0 und 23 sein";
    private static final String FEHLER_KEINE_MINUTE = "Die Minuten müssen zwischen 0 und 59 sein";
    
    /**
     * Konstruktor für Objekte der Klasse Uhrzeit
     * @param stunde ist die Stunde muss zwischen 0 und 23 sein
     * @param minute ist die Minute muss zwischen 0 und 59 sein
     */
    public Uhrzeit(int stunde, int minute)
    {
        if (stunde < STUNDE_MIN || stunde > STUNDE_MAX) {
             throw new IllegalArgumentException(FEHLER_KEINE_STUNDE);
        }
        if (stunde < MINUTE_MIN || stunde > MINUTE_MAX) {
             throw new IllegalArgumentException(FEHLER_KEINE_MINUTE);
        }
        this.stunde = stunde;
        this.minute = minute;
      
    }

    public int getStunde() {
        return this.stunde;
    }
    
    public int getMinute() {
        return this.minute;
    }

    /**
     * Gibt die Uhrzeit in der Format hh:mm
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d", this.stunde, this.minute);  
    }
    
}
