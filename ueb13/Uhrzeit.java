
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
    
    private static int STUNDE_MIN         = 1;
    private static int STUNDE_MAX         = 24;
    private static int MINUTE_MIN         = 0;
    private static int MINUTE_ZWEISTELLIG = 10;
    private static int MINUTE_MAX         = 59;
    
    private static String FEHLER_KEINE_STUNDE = "Die Stunde muss zwischen 1 und 24 sein";
    private static String FEHLER_KEINE_MINUTE = "Die Minuten müssen zwischen 0 und 59 sein";
    
    /**
     * Konstruktor für Objekte der Klasse Uhrzeit
     * @param stunde ist die Stunde muss zwischen 1 und 24 sein
     * @param minute ist die Minute muss zwischen 0 und 59 sein
     */
    public Uhrzeit(int stunde, int minute)
    {
        if(stunde < STUNDE_MIN || stunde > STUNDE_MAX){
             throw new IllegalArgumentException(FEHLER_KEINE_STUNDE);
        }
        if(stunde < MINUTE_MIN || stunde > MINUTE_MAX){
             throw new IllegalArgumentException(FEHLER_KEINE_MINUTE);
        }
        this.stunde = stunde;
        this.minute = minute;
      
    }

    @Override
    public String toString(){
        if(minute < MINUTE_ZWEISTELLIG){
            return  stunde + ":0" + minute + " Uhr";    
        }
        else{
            return  stunde + ":"  + minute + " Uhr";    
        }  
    }
    
}
