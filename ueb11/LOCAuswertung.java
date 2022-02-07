import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * LOCAuswertung wertet die LOC von Dateien aus
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class LOCAuswertung {

    private static StringBuilder auswertungsmessage;
    private static StringBuilder auswertungsfehler;
    
    private static Pattern patternKommentar = Pattern.compile("^//*");

    private static String START_MESSAGE = "Auswertung Lines Of Code (LOC)\n";
    private static String TEMPLATE_DATEI_MESSAGE = "%s \t\t %s LOC\n";
    
    private static String FEHLER_MESSAGE = "Die Datei %s könnte nicht ausgewertet werden, denn:\n %s\n\n";    
    private static boolean isSetUp = false;

    /**
    * Konstrutkor - Klasse nicht instanzierbar
    */
    private LOCAuswertung() {};

    /**
     * Koordiniert die LOC-Auswertung der eingegebenen Dateiennamen und
     * gibt die Auswertungsergebnisse und Auswertungsfehler aus
     * @params args die Namen der Dateien, die ausgewertet werden soll
     */
    public static void main(String[] args) {

        Validierung.validiereArgsLaenge(args);

        LOCAuswertung.setUp();

        LOCAuswertung.auswertungsmessage.append(START_MESSAGE);
       
        for (String dateiname : args) {
            
            try {
                Validierung.validiereNichtLeer(dateiname);
                
                int zeilenAnzahl = LOCAuswertung.auswerteDatei(dateiname);
                LOCAuswertung.auswertungsmessage.append(String.format(TEMPLATE_DATEI_MESSAGE, dateiname, zeilenAnzahl));
                
            } catch (IOException error) {
                LOCAuswertung.auswertungsfehler.append(String.format(FEHLER_MESSAGE, dateiname, error.getMessage()));
            } catch (IllegalArgumentException error) {
                LOCAuswertung.auswertungsfehler.append(String.format(FEHLER_MESSAGE, dateiname, error.getMessage()));
            } catch (FileDoesNotExistException error) {
                LOCAuswertung.auswertungsfehler.append(String.format(FEHLER_MESSAGE, dateiname, error.getMessage()));
            }  catch (FileNotFileException error) {
                LOCAuswertung.auswertungsfehler.append(String.format(FEHLER_MESSAGE, dateiname, error.getMessage()));
            } catch (FileNotReadableException error) {
                LOCAuswertung.auswertungsfehler.append(String.format(FEHLER_MESSAGE, dateiname, error.getMessage()));
            }
        }
         

         System.out.println(LOCAuswertung.auswertungsmessage);
         System.out.println(LOCAuswertung.auswertungsfehler);
    }

    /**
     * Wertet die LOC der eingegebenen Datei aus
     * leere Zeilen, Zeilen nur mit Leertasten und Kommentarenzeilen "//" werden nicht gezählt
     * @params dateiname der Datei, die ausgewertet werden soll
     */
    private static int auswerteDatei(String dateiname) throws IOException, FileDoesNotExistException,
                                                       FileNotFileException,  FileNotReadableException {            

        
        Validierung.validiereFile(dateiname);

        String zeile;
        BufferedReader reader       = new BufferedReader(new FileReader(dateiname));
    
        
        int zaehler = 0;
        while ((zeile = reader.readLine()) != null) {
            zeile = zeile.trim();
            Matcher kommentarMatcher = patternKommentar.matcher(zeile);   

            if (!zeile.isEmpty() && !kommentarMatcher.find() ) {
                zaehler++;  
            }
        }
        
        reader.close();

        return zaehler;
    }

    /**
    * Initialisiert Klassen-Variablen bei der ersten Ausführung
    */
    private static void setUp() {

        if (LOCAuswertung.isSetUp) {
            return;
        }

        LOCAuswertung.auswertungsmessage = new StringBuilder();
        LOCAuswertung.auswertungsfehler = new StringBuilder();
        LOCAuswertung.isSetUp = true;
    }


}