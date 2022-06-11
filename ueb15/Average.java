
/**
 * Beschreiben Sie hier die Klasse Average.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class Average implements CrunchOperation
{
    
    /**
     * Konstruktor für Objekte der Klasse Average
     */
    public Average() {}
    
    public void crunch(float[] values) {
        int maxIndex = 0;
        float sum = 0;
            for(int i = 0; i < values.length; i++) {
                if(values[maxIndex] < values[i]) {
                    maxIndex = i;
                }
                sum += values[i];
            }    
        values[maxIndex] = sum / values.length;
    }
}
