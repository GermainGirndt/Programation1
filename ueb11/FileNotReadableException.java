
/**
 * FileNotReadableException wird geworfen, wenn die eingegebene Datei nicht lesbar ist
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class FileNotReadableException extends Exception
{
    private static String exceptionMessageMuster = "Die Datei %s ist gar keine Datei!";
    

    /**
     * Konstruktor für Objekte der Klasse FileNotReadableException
     */
    public FileNotReadableException(String dateiname)
    {
          super(String.format(FileNotReadableException.exceptionMessageMuster, dateiname));
    }

}
