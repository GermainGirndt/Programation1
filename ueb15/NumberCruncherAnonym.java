import java.util.Random;
import java.util.Arrays;

/**
 * Beschreiben Sie hier die Klasse NumberCruncherAnonym.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class NumberCruncherAnonym extends AbstractNumberCruncher {
    
    /**
     * Konstruktor für Objekte der Klasse NumberCruncherAnonym
     * @param numbers ist ein Array mit float Werten
     */
    public NumberCruncherAnonym(float[] numbers) {
        super(numbers);
        this.anonymeKlassenDefinieren();
    }

    private void anonymeKlassenDefinieren() {
        CrunchOperation sum = new CrunchOperation() {
            
            public void crunch(float[] values) {
                for(int i = 1; i < values.length; i++) {
                    values[i] = values[i-1] + values[i];
                }
            }
        };

        CrunchOperation swirl = new CrunchOperation() {
            public void crunch(float[] values) {
                Random r = new Random();
                int index1;
                int index2;
                float temp;
                for(int i = 0; i < values.length; i++) {
                    index1  = r.nextInt(values.length);   
                    index2 = r.nextInt(values.length);
                    temp = values[index1];
                    values[index1] = values[index2];
                    values[index2] = temp;
                }
            }
        };
    
        CrunchOperation divide = new CrunchOperation() {

             public void crunch(float[] values) {
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
                    
                    for(int k = 0; k < vorkommenMin.length; k++) {
                        if(vorkommenMin[k] == 1) {
                            if( besucht[k] == 0) {
                                minIndex = k;
                            }
                        }
                    }
                    
                    for(int k = 0; k < vorkommenMax.length; k++) {
                        if(vorkommenMax[k] == 1) {
                            if( besucht[k] == 0) {
                                maxIndex = k;
                            }
                        }
                    }
                               
                    if (values[minIndex] == 0.0f) {
                        throw new NumberCruncherException("Kann nicht durch 0 teilen");
                    }
                    
                    values[maxIndex] =  values[maxIndex] / values[minIndex];
                    besucht[minIndex] = 1;
                    besucht[maxIndex] = 1;
                }
             
            }
        };
    
        CrunchOperation subtract = new CrunchOperation() {
            public void crunch(float[] values) {
                for(int i = 1; i < values.length; i++) {
                    values[i] = values[i-1] - values[i];
                }
            }
        };
        
        CrunchOperation average = new CrunchOperation() {
            
            public void crunch(float[] values) {
                int maxIndex =0;
                float sum = 0;
                for(int i = 0; i < values.length; i++) {
                    if(values[maxIndex] < values[i]) {
                        maxIndex = i;
                    }
                    sum += values[i];
                }    
                values[maxIndex] = sum / values.length;
            }
        };

        this.setOperation(Operation.SUM, sum);
        this.setOperation(Operation.SWIRL, swirl);
        this.setOperation(Operation.DIVIDE, divide);
        this.setOperation(Operation.SUBTRACT, subtract);
        this.setOperation(Operation.AVERAGE, average);
    }
}
