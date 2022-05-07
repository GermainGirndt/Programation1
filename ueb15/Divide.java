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
                //ersetze durch mergesort
                Sort.bubbleSort(valuesCopy);
                for(int i= 0 ; i < values.length / 2; i++){
                    int minIndex = Search.search(valuesCopy[i], values);
                    int maxIndex = Search.search(valuesCopy[values.length - i -1], values);
                    values[maxIndex] =  values[maxIndex] / values[minIndex];
                }
            }
}
