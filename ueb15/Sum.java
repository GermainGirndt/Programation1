
/**
 * Beschreiben Sie hier die Klasse Sum.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class Sum implements CrunchOperation
{
    /**
     * Konstruktor für Objekte der Klasse Sum
     */
    public Sum()
    {
       
    }

    public void crunch(float[] values) {
        for(int i = 1; i < values.length; i++) {
                values[i] = values[i-1] + values[i];
        }
    }
}
