import java.util.Random;
import java.util.Arrays;

/**
 * Beschreiben Sie hier die Klasse NumberCruncherAnonym.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class NumberCruncherAnonym
{
    private float[] numbers;
    
    /**
     * Konstruktor für Objekte der Klasse NumberCruncherAnonym
     * @param numbers ist ein Array mit float Werten
     */
    public NumberCruncherAnonym(float[] numbers)
    {
        this.numbers = numbers;
    }

      /**
     * Funktion crunch
     * @param operations
     */
    public void crunch(String[] operations){
        CrunchOperation sum = new CrunchOperation() {
            
            public void crunch(float[] values){
                for(int i = 1; i <values.length; i++){
                    values[i] = values[i-1] + values[i];
                }
            }
        };
    
        CrunchOperation swirl = new CrunchOperation() {
            public void crunch(float[] values){
                Random r = new Random();
                int index1;
                int index2;
                float temp;
                for(int i = 0; i < values.length; i++){
                    index1  = r.nextInt(values.length);   
                    index2 = r.nextInt(values.length);
                    temp = values[index1];
                    values[index1] = values[index2];
                    values[index2] = temp;
                }
            }
        };
    
        CrunchOperation divide = new CrunchOperation() {

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
        };
    
        CrunchOperation subtract = new CrunchOperation() {
            public void crunch(float[] values){
                for(int i = 1; i < values.length; i++){
                    values[i] = values[i-1] - values[i];
                }
            }
        };
        
        CrunchOperation average = new CrunchOperation() {
            
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
        };
        
        for(int i=0; i < operations.length; i++){
            switch(operations[i].toLowerCase()){
                case "sum":
                    sum.crunch(numbers);
                    break;
                case "swirl":
                    swirl.crunch(numbers);
                    break;
                case "divide":
                    divide.crunch(numbers);
                    break;
                case "subtract":
                    subtract.crunch(numbers);
                    break;
                case "average":
                    average.crunch(numbers);
                    break;
            }
        }
    
    }
    

    
    public float[] getNumbers(){
        return numbers;
    }
}
