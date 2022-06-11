import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Einlesen.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class Einlesen
{
    public static void validiereFile(File file) {

        if (!file.isFile()) {
            throw new IllegalArgumentException(file.getName());
        }

        if (!file.canRead()) {
            throw new  IllegalArgumentException(file.getName());
        }

        if (!file.exists()) {
            throw new IllegalArgumentException(file.getName());
        }    
    }
    
    public static List<String> readLines(String dateiname) {
        ArrayList<String> list = new ArrayList<>();
        File file         = new File(dateiname);
        String zeile;
        validiereFile(file);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while((zeile = reader.readLine()) != null) { 
                list.add(zeile);
            }
             
            reader.close();
          
            } catch (Exception error) {
            throw new PalindromError("Dateilesung hat fehlgeschlagen");
            }    
        return list;
    }
}
