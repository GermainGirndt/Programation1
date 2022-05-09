
/**
 * Beschreiben Sie hier die Klasse NumberCruncherTopLevel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class NumberCruncherTopLevel extends AbstractNumberCruncher {
    
    /**
     * Konstruktor für Objekte der Klasse NumberCruncherTopLevel
     * @param numbers ist ein Array mit float Werten
     */
    public NumberCruncherTopLevel(float[] numbers) {
        super(numbers);
        this.topLevelKlassenDefinieren();
    }
    
    private void topLevelKlassenDefinieren() {
        CrunchOperation sum = new Sum();
        CrunchOperation swirl = new Swirl();
        CrunchOperation divide = new Divide();
        CrunchOperation subtract = new Subtract();
        CrunchOperation average = new Average();

        this.setOperation(Operation.SUM, sum);
        this.setOperation(Operation.SWIRL, swirl);
        this.setOperation(Operation.DIVIDE, divide);
        this.setOperation(Operation.SUBTRACT, subtract);
        this.setOperation(Operation.AVERAGE, average);
    }
}
