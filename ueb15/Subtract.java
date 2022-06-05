
/**
 * Beschreiben Sie hier die Klasse Subtract.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class Subtract implements CrunchOperation
{

    /**
     * Konstruktor für Objekte der Klasse Subtract
     */
    public Subtract()
    {
       
    }
    
    public void crunch(float[] values) {
        for(int i = 1; i < values.length; i++) {
            values[i] = values[i-1] - values[i];
        }
    }
}
