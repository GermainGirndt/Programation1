/**
 * FileNotFileException wird geworfen, wenn die eingegebene Datei keine Datei ist
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
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
