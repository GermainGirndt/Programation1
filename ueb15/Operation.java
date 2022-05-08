public enum Operation {
    
    SUM(),
    SWIRL(),
    DIVIDE(),
    SUBTRACT(),
    AVERAGE();

    String operationName;

    Operation() {}

    public static Operation[] toOperations(String[] operations) {
        Operation[] umgewandelteOperations = new Operation[operations.length];

        for ( int i = 0; i < operations.length; i++) {

            String operation = operations[i];
            if (operation == null || operation.trim().isEmpty()) {
                throw new IllegalArgumentException("Operation String darf nicht leer sein");
            }

            try {
                umgewandelteOperations[i] = Operation.valueOf(operation.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Operation nicht unterstuetzt: " + operation.toLowerCase());

            }
        }

        return umgewandelteOperations;
    }

}
