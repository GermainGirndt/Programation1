public class Utils {

    private static final String     ERROR_TYP_NICHT_UNTERSTUETZ = "Fehler. Typ nicht unterstuezt.";
    
    private Utils() {};

    public static int generateHashCode(Object... seeds) {
        
        int baseHash = 29;
        int hashCode = Utils.generateHashCodeMitBaseHash(baseHash, seeds);

        return hashCode;
    }

    public static int generateHashCodeMitBaseHash(int baseHash, Object... seeds) {
        
        final int primZahl = 31;
        int hashCode = baseHash;
        
        for (Object seed : seeds) {
            if (seed instanceof String) {
                hashCode = primZahl * hashCode + ((seed == null ? 0 : seed.hashCode()));
                
            } else if (seed instanceof Integer) {
                hashCode = primZahl * hashCode + (int) seed;

            } else if (seed instanceof Long) {
                Long longWert = (Long) seed;
                hashCode = primZahl * hashCode + longWert.intValue();

            } else if (seed instanceof Double) {
                hashCode = primZahl * hashCode + Double.hashCode((double) seed);

            } else {
                throw new IllegalArgumentException(ERROR_TYP_NICHT_UNTERSTUETZ);

            }
        }

        return hashCode;

    }
    
}
