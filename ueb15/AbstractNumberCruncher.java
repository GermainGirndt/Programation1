public abstract class AbstractNumberCruncher {

    private float[] numbers;

    CrunchOperation sum;
    CrunchOperation swirl;
    CrunchOperation divide;
    CrunchOperation subtract;
    CrunchOperation average;

    private static String MESSAGE_OPERATION_NICHT_UNTERSTUETZT = "Operation nicht unterstuetzt";

    public AbstractNumberCruncher(float[] numbers) {
        this.numbers = numbers;
        this.initialisiereOperationen();
    }

    private void initialisiereOperationen() {
        this.sum = new NotImplemented();
        this.swirl = new NotImplemented();
        this.divide = new NotImplemented();
        this.subtract = new NotImplemented();
        this.average = new NotImplemented();
    }

    /**
     * Funktion crunch
     * @param operations
     */
    public void crunch(String[] operations) {
        
        Operation[] validierteOperations;
        try {
            validierteOperations = Operation.toOperations(operations);
        } catch (IllegalArgumentException exception) {
            throw new NumberCruncherException(exception.getMessage());
        }

        for( Operation operation : validierteOperations) {
           
            switch( operation ) {
                case SUM:
                    sum.crunch(this.numbers);
                    break;
                case SWIRL:
                    swirl.crunch(this.numbers);
                    break;
                case DIVIDE:
                    divide.crunch(this.numbers);
                    break;
                case SUBTRACT:
                    subtract.crunch(this.numbers);
                    break;
                case AVERAGE:
                    average.crunch(this.numbers);
                    break;
                default:
                    throw new NumberCruncherException(MESSAGE_OPERATION_NICHT_UNTERSTUETZT);
            }
        }
    }
    
    public float[] getNumbers(){
        return this.numbers;
    }

    public void setNumbers(float[] numbers){
        this.numbers = numbers;
    }

    public void setOperation(Operation operation, CrunchOperation crunchOperation) {
        switch( operation ) {
            case SUM:
                this.sum = crunchOperation;
                break;
            case SWIRL:
                this.swirl = crunchOperation;
                break;
            case DIVIDE:
                this.divide = crunchOperation;
                break;
            case SUBTRACT:
                this.subtract = crunchOperation;
                break;
            case AVERAGE:
                this.average = crunchOperation;
                break;
            default:
                throw new NumberCruncherException(MESSAGE_OPERATION_NICHT_UNTERSTUETZT);
        }
    }
}
