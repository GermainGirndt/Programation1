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

    public static void main(String[] args[]) {

         for (String arg : args) {
            LOCAuswertung.auswerteDatei(arg);
         }

    }

    private static void auswerteDatei(String dateiname) {

        try {
            int zaehler = 0;
            // checke ob Datei existiert (wenn nicht, eigene Ausnahme werfen)
            // checke ob Datei kein Ordner ist (wenn nicht, eigene Ausnahme werfen)
            // checke ob Datei richtiges format hat (wenn nicht, eigene Ausnahme werfen)
            // checke ob Datei kann gelesen werden (wenn nicht, eigene Ausnahme werfen)

            
            // Zeilen durchlaufen (mit Buffer?)
            // ueberprufen, ob Zeile ein Kommentar ist (mit // anfaengt)
            // wenn ja, uebersprigen
            // wenn nein, zaehler++

            // auswerten
        } catch (IOException error) {
            // eigene Ausnahmeklassen definineren und behandeln
            // ausgeben, was das Problem war

        }
    }
}