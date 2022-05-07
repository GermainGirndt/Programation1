
/**
 * Beschreiben Sie hier die Klasse NumberCruncherTopLevel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class NumberCruncherTopLevel
{
    float[] numbers;
    Sum sum;
    Swirl swirl;
    Divide divide;
    Subtract subtract;
    Average average;
    
    
    /**
     * Konstruktor für Objekte der Klasse NumberCruncherTopLevel
     * @param numbers ist ein Array mit float Werten
     */
    public NumberCruncherTopLevel(float[] numbers)
    {
        this.numbers = numbers;  
        sum = new Sum();
        swirl = new Swirl();
        divide = new Divide();
        subtract = new Subtract();
        average = new Average();
    }

    
    /**
     * Funktion crunch
     * @param operations
     */
    public void crunch(String[] operations){
        
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
