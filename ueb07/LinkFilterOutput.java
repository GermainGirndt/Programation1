/**
 * Die Klasse LinkFilterOutput zeigt dem Nutzer die Messages an
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class LinkFilterOutput {

    private static String TEMPLATE_END_MESSAGE = "%d Links wurden in %d Zeilen gefunden.";

    /**
     * Wenn die Message nicht leer ist, druckt sie in den Terminal aus
     * 
     * @param message die angezeigt werden soll
     */
    public static void gibAusZeilemessage(String message) {
        if (message != LinkFilterKonstante.LEER_STRING) {
            System.out.println(message);
        }
    }

    /**
     * Druckt die letzte Message aus, die die Zusammenfassung von dem Programmablauf
     * enthaelt
     * 
     * @param gefundeneLinks die Anzahl an gefundenen Links
     * @param geleseneZeile  die Anzahl an gelesenen Zeilen
     */
    public static void gibAusEndmessage(int gefundeneLinks, int geleseneZeilen) {

        System.out.println(String.format(TEMPLATE_END_MESSAGE, gefundeneLinks, geleseneZeilen));
    }
}
