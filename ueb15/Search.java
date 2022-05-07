
/**
 * Beschreiben Sie hier die Klasse Search.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Search
{


    public static int search(float value, float[] values ) {  
        float epsilon = Float.MIN_VALUE;
        
        for(int i = 0; i < values.length; i++){
            if(Math.abs(values[i] - value) < epsilon){
                return i;
            }
        }
        return -1;
    }
}
