/**
 * Klasse GetraenkeautomatException
 *
 * @author W. Pauly
 * @version -1.0 Beta
 */
 

class GetraenkeautomatException 
      extends RuntimeException
{
    public static final String FEHLER_M = "Die Flasche darf nicht leer sein";
    
    public GetraenkeautomatException() 
    {
        super();
    }
    
    public GetraenkeautomatException(String message) 
    {
        super(message);
    }
    
    public static void flascheGefuellt(Flasche testFlasche)
    {
        if (!testFlasche.gefuellt()) 
    {
            throw new GetraenkeautomatException(
                                  "\n\t" + 
                      FEHLER_M + 
                      " !!!!\n\n"
                      );
        }
    }
}
