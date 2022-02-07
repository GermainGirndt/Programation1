
/**
 * Beschreiben Sie hier die Klasse FileNotFileException.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class FileNotFileException  extends Exception
{
    private static String exceptionMessageMuster = "Die Datei %s ist gar keine Datei!";
    /**
     * Konstruktor für Objekte der Klasse FileNotFileException
     */
    public FileNotFileException(String dateiname)
    {
       super(String.format(FileNotFileException.exceptionMessageMuster, dateiname));
    }

}
