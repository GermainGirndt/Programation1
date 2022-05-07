
/**
 * Beschreiben Sie hier die Klasse Subtract.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Subtract
{

    /**
     * Konstruktor für Objekte der Klasse Subtract
     */
    public Subtract()
    {
       
    }
    
    public void crunch(float[] values){
        for(int i = 1; i < values.length; i++){
            values[i] = values[i-1] - values[i];
        }
    }
}
