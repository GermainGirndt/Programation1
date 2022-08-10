/**
 * Klasse GetraenkeException
 *
 * @author W. Pauly
 * @version -1.0 Beta
 */
 


public class GetraenkeException 
       extends RuntimeException
{
    public static final String FEHLER_M1 = "Ein ";
    public static final String FEHLER_M2 = "-String darf nicht leer sein";

    public static final float MIN_ALK = 0.0f;
    public static final float MAX_ALK = 99.0f;
    public static final String FEHLER_M3 = "-Wert darf nicht < 0.0% und groesser 99.0% betragen";

    public static final float MIN_ZUCK = 0.0f;
    public static final float MAX_ZUCK = 200.0f;
    public static final String FEHLER_M4 = "-Wert darf nicht < 0.0g und groesser 200.0g betragen";
    

    public GetraenkeException() 
    {
      super();
    }
    
    public GetraenkeException(String meldung) 
    {
        super(meldung);
    }
    

    public static void nameKorrekt(String testAttribut, String testAttributInhalt) 
    {
        if (testAttributInhalt == null || testAttributInhalt.trim().length() == 0) 
    {
            throw new GetraenkeException(
                                     "\n\t" +
                     FEHLER_M1 + testAttribut + FEHLER_M2 +
                     " !!!!\n\n"
                    );
        }
    }
    
    public static void alkWertKorrekt(String testAttribut, float testAttributWert) 
    {
        if (testAttributWert < MIN_ALK || testAttributWert > MAX_ALK) 
    {
            throw new GetraenkeException(
                                     "\n\t" +
                     FEHLER_M1 + testAttribut + FEHLER_M3 +
                     " !!!!\n\n"
                    );
        }
    }
    
    public static void zuckWertKorrekt(String testAttribut, float testAttributWert) 
    {
        if (testAttributWert < MIN_ZUCK || testAttributWert > MAX_ZUCK) 
    {
            throw new GetraenkeException(
                                     "\n\t" +
                     FEHLER_M1 + testAttribut + FEHLER_M4 +
                     " !!!!\n\n"
                    );
        }
    }
}
