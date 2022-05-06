
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
	
            }
        };
    
        CrunchOperation swirl = new CrunchOperation() {
            public void crunch(float[] values){
		    
            }
        };
    
        CrunchOperation divide = new CrunchOperation() {
            public void crunch(float[] values){
		    
            }
        };
    
        CrunchOperation subtract = new CrunchOperation() {
            public void crunch(float[] values){
		    
            }
        };
        CrunchOperation average = new CrunchOperation() {
            public void crunch(float[] values){
		    
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
