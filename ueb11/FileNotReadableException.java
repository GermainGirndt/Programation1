
/**
 * Beschreiben Sie hier die Klasse FileNotReadableException.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
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
