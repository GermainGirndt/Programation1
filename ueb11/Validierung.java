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
    private Validierung()
    {  }

    public static void validiereArgsLaenge(String[] args){
        if (args.length == 0 ) {
            throw new IllegalArgumentException("Benutzung: java LOCAuswertung Dateiname(n)");
        }
    }
    
     public static void validiereNichtLeer(String text){
        text = text.trim();
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Dateiname ist leer");
        }
    }
    
    public static void validiereFileExistiert(File file){

        if (!file.exists()) {
            throw new IllegalArgumentException("Datei existiert nicht");
        }
    }
    
    public static void validiereFileLesbar(File file){

        if (!file.canRead()) {
            throw new IllegalArgumentException("Datei nicht lesbar");
        }
    }
    
     public static void validiereFileIstFile(File file){

        if (!file.isFile()) {
            throw new IllegalArgumentException("Die angegebene Datei ist gar keine Datei");
        }
    }
}
