
/**
 * Beschreiben Sie hier die Klasse Average.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Average implements CrunchOperation
{
    
    /**
     * Konstruktor für Objekte der Klasse Average
     */
    public Average()
    {
          
    }
    
    public void crunch(float[] values){
        int maxIndex =0;
        float sum = 0;
            for(int i = 0; i < values.length; i++){
                if(values[maxIndex] < values[i]){
                    maxIndex = i;
                }
                sum += values[i];
            }    
        values[maxIndex] = sum / values.length;
    }
}
