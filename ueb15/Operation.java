public enum Operation {
    
    SUM("sum"),
    SWIRL("swirl"),
    DIVIDE("divide"),
    SUBTRACT("subtract"),
    AVERAGE("average");

    String operationName;

    Operation(String operation) {
        this.operationName = operation;
    }

    public String getOperationName() {
        return this.operationName;
    }

    public static Operation[] toOperations(String[] operations) {
        Operation[] umgewandelteOperations = new Operation[operations.length];

        for ( int i = 0; i < operations.length; i++) {

            String operation = operations[i];
            if (operation == null || operation.trim().isEmpty()) {
                throw new IllegalArgumentException("Operation String darf nicht leer sein");
            }

            try {
                umgewandelteOperations[i] = Operation.valueOf(operation.toLowerCase());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Operation nicht unterstuetzt");

            }
        }

        return umgewandelteOperations;
    }

}
