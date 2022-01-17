public class Utils {

    private static final String     ERROR_TYP_NICHT_UNTERSTUETZ = "Fehler. Typ nicht unterstuezt.";
    
    private Utils() {};

    public static int generateHashCode(Object... seeds) {
        
        final int primZahl = 31;
        int ergebnis = 29;
        
        for (Object seed : seeds) {
            if (seed instanceof String) {
                ergebnis = primZahl * ergebnis + ((seed == null ? 0 : seed.hashCode()));
                
            } else if (seed instanceof Integer) {
                ergebnis = primZahl * ergebnis + (int) seed;

            } else if (seed instanceof Long) {
                Long longWert = (Long) seed;
                ergebnis = primZahl * ergebnis + longWert.intValue();

            } else if (seed instanceof Double) {
                ergebnis = primZahl * ergebnis + Double.hashCode((double) seed);

            } else {
                throw new IllegalArgumentException(ERROR_TYP_NICHT_UNTERSTUETZ);

            }
        }

        return ergebnis;

    }
    
}
