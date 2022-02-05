import java.io.IOException;

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

    private static String START_MESSAGE = "Auswertung Lines Of Code (LOC)\n";
    private static String TEMPLATE_DATEI_MESSAGE = "%s \t %s LOC";

    private static String FEHLER_MESSAGE = "Die Datei %s könnte nicht ausgewertet werden, denn (mit spezifischer Fehlerbeschreibung ergaenzen)";
    
    public static void main(String[] args[]) {

        LOCAuswertung.auswertungsmessage = new StringBuilder();
        LOCAuswertung.auswertungsfehler = new StringBuilder();

        
        LOCAuswertung.auswertungsmessage.append(START_MESSAGE);

        for (String dateiname : args) {
             // validierung arg nicht null und String nicht leer

            try {
                int zeilenAnzahl = LOCAuswertung.auswerteDatei(dateiname);
                LOCAuswertung.auswertungsmessage.append(String.format(TEMPLATE_DATEI_MESSAGE, dateiname, zeilenAnzahl));
                
            } catch (IOException error) {
                // eigene Ausnahmeklassen definineren und behandeln
                // ausgeben, was das Problem war
                LOCAuswertung.auswertungsfehler.append(String.format(FEHLER_MESSAGE, dateiname));
    
            }
         }

         System.out.println(LOCAuswertung.auswertungsmessage);
         System.out.println(LOCAuswertung.auswertungsfehler);

    }

    // zaelt Zeilenanzahlt
    private static int auswerteDatei(String dateiname) {

     
            int zaehler = 0;
            // Validierung (wenn nicht gültig, eigene Ausnahme werfen!):
            // checke ob Datei existiert
            // checke ob Datei kein Ordner ist
            // checke ob Datei richtiges format hat
            // checke ob Datei kann gelesen werden


            
            // Zeilen durchlaufen bis zum Dateienende (??mit Buffer + while-loop?? )
            // ueberprufen, ob Zeile gezahelt werden soll
            // wenn Zeile ein Kommentar ist (mit // anfaengt), nichts tun
            // sonst, zaehler++

            return zaehler;

    }
}