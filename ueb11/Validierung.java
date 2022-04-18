import java.io.File;

/**
 * Beschreiben Sie hier die Klasse Validierung.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class Validierung
{
    /**
     * Konstruktor für Objekte der Klasse Validierung
     * (Nicht instanzierbar)
     */
    private Validierung() {}
    
    private static String FEHLER_KEINE_DATEIEN = "Ungueltige Eingabe. Bitte geben Sie die auszuwertenden " +
    "Dateinamen als Argumente ein\n" +
    "Benutzung: java LOCAuswertung Dateiname(n)";
    
    /**
     * Validiert, ob die Datei existiert, ist lesbar und ist kein Ordner
     * @params dateiname, der validiert werden soll
     */
    public static void validiereFile(String dateiname) throws FileNotFileException, 
                                                       FileDoesNotExistException,  FileNotReadableException {
        File file         = new File(dateiname);
    
        Validierung.validiereFileExistiert(file);
        Validierung.validiereFileLesbar(file);
        Validierung.validiereFileIstFile(file);
    }

    /**
                                                  * Validiert, ob Argumente da sind
     * @params args ein String-Array mit den Argumenten
     */
    public static void validiereArgsLaenge(String[] args) {
        if (args.length == 0 ) {
            throw new IllegalArgumentException(FEHLER_KEINE_DATEIEN);
        }
    }
    
    /**
     * Validiert, ob der String nicht leer ist
     * @params string, der validiert werden soll
     */
    public static void validiereNichtLeer(String string) throws IllegalArgumentException {
        string = string.trim();
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("Dateiname ist leer");
        }
    }


    /**
     * Validiert, ob die Datei existiert
     * @params file ist die Datei, die validiert werden soll
     */
    private static void validiereFileExistiert(File file) throws FileDoesNotExistException {
        
        if (!file.exists()) {
            throw new FileDoesNotExistException(file.getName());
        }
    }
    
    /**
     * Validiert, ob die Datei lesbar ist
     * @params file ist die Datei, die validiert werden soll
     */
    private static void validiereFileLesbar(File file) throws FileNotReadableException{

        if (!file.canRead()) {
            throw new  FileNotReadableException(file.getName());
        }
    }
    
     /**
     * Validiert, ob die Datei eine normale Datei und kein Ordner ist
     * @params file ist die Datei, die validiert werden soll
     */
     private static void validiereFileIstFile(File file) throws FileNotFileException {

        if (!file.isFile()) {
            throw new FileNotFileException(file.getName());
        }
    }
}
