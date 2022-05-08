import java.util.Arrays;


/**
 * Beschreiben Sie hier die Klasse Divide.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Divide implements CrunchOperation
{
 
    /**
     * Konstruktor für Objekte der Klasse Divide
     */
    public Divide()
    {
      
    }

    public void crunch(float[] values){
                float[] valuesCopy = Arrays.copyOf(values, values.length);
                int[] besucht = new int[values.length];
                int[] vorkommenMin = new int[values.length];
                int[] vorkommenMax = new int[values.length];
                
                int minIndex = 1;
                int maxIndex = 0;
                //ersetze durch mergesort
                Sort.bubbleSort(valuesCopy);
                for(int i= 0 ; i < values.length / 2; i++) {
                    vorkommenMin = Search.search(valuesCopy[i], values);
                    vorkommenMax = Search.search(valuesCopy[values.length - i -1], values); 
                    
                    for(int k = 0; k < vorkommenMin.length; k++){
                        if(vorkommenMin[k] == 1){
                            if( besucht[k] == 0){
                                minIndex = k;
                            }
                        }
                    }
                    
                    for(int k = 0; k < vorkommenMax.length; k++){
                        if(vorkommenMax[k] == 1){
                            if( besucht[k] == 0){
                                maxIndex = k;
                            }
                        }
                    }
                                        
                    values[maxIndex] =  values[maxIndex] / values[minIndex];
                    besucht[minIndex] = 1;
                    besucht[maxIndex] = 1;
                }
             
            }
}
