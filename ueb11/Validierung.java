import java.io.File;

/**
 * Beschreiben Sie hier die Klasse Validierung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Validierung
{
    /**
     * Konstruktor für Objekte der Klasse Validierung
     */
    private Validierung() {}

    private static String FEHLER_KEINE_DATEIEN = "Ungueltige Eingabe. Bitte geben Sie die auszuwertenden " +
                                                 "Dateinamen als Argumente ein\n" +
                                                 "Benutzung: java LOCAuswertung Dateiname(n)";

    public static void validiereArgsLaenge(String[] args){
        if (args.length == 0 ) {
            throw new IllegalArgumentException(FEHLER_KEINE_DATEIEN);
        }
    }
    
    public static void validiereNichtLeer(String text){
        text = text.trim();
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Dateiname ist leer");
        }
    }

    // Validierung (wenn nicht gültig, eigene Ausnahme werfen!):
    // checke ob Datei existiert
    // checke ob Datei kein Ordner ist
    // checke ob Datei das richtige Format hat
    // checke ob Datei gelesen werden kann
    public static void validiereFile(String dateiname) throws FileNotFileException, 
                                                       FileNotExistsException,  FileNotReadableException {
        File file         = new File(dateiname);

        Validierung.validiereFileExistiert(file);
        Validierung.validiereFileLesbar(file);
        Validierung.validiereFileIstFile(file);
    }
    
    private static void validiereFileExistiert(File file) throws FileNotExistsException {
        
        if (!file.exists()) {
            throw new FileNotExistsException(file.getName());
        }
    }
    
    private static void validiereFileLesbar(File file) throws FileNotReadableException{

        if (!file.canRead()) {
            throw new  FileNotReadableException(file.getName());
        }
    }
    
     private static void validiereFileIstFile(File file) throws FileNotFileException {

        if (!file.isFile()) {
            throw new FileNotFileException(file.getName());
        }
    }
}
