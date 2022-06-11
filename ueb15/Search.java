
/**
 * Beschreiben Sie hier die Klasse Search.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class Search
{


    public static int[] search(float value, float[] values ) {  
        float epsilon = Float.MIN_VALUE;
        int[] vorkommen = new int[values.length];
        for(int i = 0; i < values.length; i++) {
            if(Math.abs(values[i] - value) < epsilon) {
                vorkommen[i] = 1;
            }
        }
        return vorkommen;
    }
}
