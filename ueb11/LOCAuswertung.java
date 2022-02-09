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

    private StringBuilder auswertungsmessage;
    private StringBuilder auswertungsfehler;
    
    private static String START_MESSAGE = "Auswertung Lines Of Code (LOC)\n";
    private static String END_MESSAGE = "\nGesamt:\n%s Dateien \t\t %s\n";
    private static String TEMPLATE_DATEI_MESSAGE = "%s \t\t %s LOC\n";
    private static String KOMMENTAR_REGEX = "^//*";
    
    private static String FEHLER_MESSAGE = "Die Datei %s könnte nicht ausgewertet werden, denn:\n %s\n\n";    

    private BufferedReader reader;

    private int gesamtzeilenanzahl; 
    private int erfolgreichgeleseneDateien; 

    /**
    * Konstrutkor - Klasse nicht instanzierbar
    */
    private LOCAuswertung() {
        this.auswertungsmessage = new StringBuilder();
        this.auswertungsfehler = new StringBuilder();
    };

    /**
     * Koordiniert die LOC-Auswertung der eingegebenen Dateiennamen und
     * gibt die Auswertungsergebnisse und Auswertungsfehler aus
     * @params args die Namen der Dateien, die ausgewertet werden soll
     */
    public static void main(String[] args) {
        LOCAuswertung instance = new LOCAuswertung();
        instance.start(args);
    }

    private void start(String[] args) {
        Validierung.validiereArgsLaenge(args);

        this.auswertungsmessage.append(START_MESSAGE);

        for (String dateiname : args) {
            try (BufferedReader reader = new BufferedReader(new FileReader(dateiname))) {
                this.reader = reader;

                Validierung.validiereNichtLeer(dateiname);
                
                int zeilenAnzahl = this.auswerteDatei(dateiname);
                this.auswertungsmessage.append(String.format(TEMPLATE_DATEI_MESSAGE, dateiname, zeilenAnzahl));
                
                this.erfolgreichgeleseneDateien++;
                this.gesamtzeilenanzahl += zeilenAnzahl;
            } catch (Exception error) {
                this.auswertungsfehler.append(String.format(FEHLER_MESSAGE, dateiname, error.getMessage()));
            }
        }
         
        this.auswertungsmessage.append(String.format(END_MESSAGE, this.erfolgreichgeleseneDateien, this.gesamtzeilenanzahl));
        System.out.println(this.auswertungsmessage);
        System.out.println(this.auswertungsfehler);
    }

    /**
     * Wertet die LOC der eingegebenen Datei aus
     * leere Zeilen, Zeilen nur mit Leertasten und Kommentarenzeilen "//" werden nicht gezählt
     * @params dateiname der Datei, die ausgewertet werden soll
     */
    private int auswerteDatei(String dateiname) throws IOException, FileDoesNotExistException,
                                                       FileNotFileException,  FileNotReadableException {            
                                             
        Validierung.validiereFile(dateiname);

        String zeile;
        
        int zaehler = 0;
        while ((zeile = this.reader.readLine()) != null) {
            zeile = zeile.trim();
            Pattern patternkommentar = Pattern.compile(KOMMENTAR_REGEX);
            Matcher kommentarMatcher = patternkommentar.matcher(zeile);   

            if (!zeile.isEmpty() && !kommentarMatcher.matches()) {
                zaehler++;
            }
        }

        return zaehler;
    }


}