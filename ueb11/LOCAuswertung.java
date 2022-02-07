import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * java LOCAuswertung datei1.java datei2.java datei3.java
 * 
 * • Es ist mindestens eine Datei zu übergeben. Die Gesamtanzahl an übergebenen Dateien ist beliebig.
 *
 *
 * • Die zu verarbeitenden Dateien sind auf die Eigenschaften „normale Datei“ und „Lesbarkeit“
 * zu prüfen. Natürlich müssen die zu verarbeitenden Dateien auch existieren, bevor eine Verarbeitung starten kann.
 * 
 * 
 * • Mögliche Ausnahmen sind zu behandeln. Definieren Sie dazu eigene Ausnahmeklassen.
 * 
 * 
 * • Bei Lesefehlern in einer Datei soll mit der nächsten Datei fortgefahren werden.
 * 
 * 
 * • Zu zählen sind dabei alle nichtleeren Zeilen, die keine Kommentarzeilen sind.
 * 
 * – Dabei können leere Zeilen durchaus eine Länge größer als 0 haben.
 * 
 * – Als Kommentarzeilen betrachten wir der Einfachheit halber nur die Zeilen, die mit dem
 * String „//“ beginnen
 * 
 */
public class LOCAuswertung {

    private LOCAuswertung() {};

    private static StringBuilder auswertungsmessage;
    private static StringBuilder auswertungsfehler;
    
    private static Pattern patternKommentar = Pattern.compile("^//*");

    private static String START_MESSAGE = "Auswertung Lines Of Code (LOC)\n";
    private static String TEMPLATE_DATEI_MESSAGE = "%s \t %s LOC\n";

    private static String FEHLER_MESSAGE = "Die Datei %s könnte nicht ausgewertet werden, denn: ";    
    private static boolean isSetUp = false;
    public static void main(String[] args) {

        Validierung.validiereArgsLaenge(args);

        LOCAuswertung.setUp();

        LOCAuswertung.auswertungsmessage.append(START_MESSAGE);
       
        for (String dateiname : args) {
            
            try {
                Validierung.validiereNichtLeer(dateiname);
                
                int zeilenAnzahl = LOCAuswertung.auswerteDatei(dateiname);
                LOCAuswertung.auswertungsmessage.append(String.format(TEMPLATE_DATEI_MESSAGE, dateiname, zeilenAnzahl));
                
            } catch (IOException IOError) {
                LOCAuswertung.auswertungsfehler.append(String.format(FEHLER_MESSAGE + IOError.getMessage(), dateiname));
            
            } catch (IllegalArgumentException IlError) {
                LOCAuswertung.auswertungsfehler.append(String.format(FEHLER_MESSAGE + IlError.getMessage(), dateiname));
            }
        }
         

         System.out.println(LOCAuswertung.auswertungsmessage);
         System.out.println(LOCAuswertung.auswertungsfehler);

    }

   
    private static int auswerteDatei(String dateiname) throws IOException {            

        
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

    private static void setUp() {

        if (LOCAuswertung.isSetUp) {
            return;
        }

        LOCAuswertung.auswertungsmessage = new StringBuilder();
        LOCAuswertung.auswertungsfehler = new StringBuilder();
        LOCAuswertung.isSetUp = true;
    }


}