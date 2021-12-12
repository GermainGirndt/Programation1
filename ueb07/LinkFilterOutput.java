public class LinkFilterOutput {
    
    public static void gibAusZeilemessage(String message) {
        if (message != LinkFilterKonstante.LEER_STRING) {
            System.out.println(message);
        }
    }

    public static void gibAusEndmessage(int gefundeneLinks, int geleseneZeilen) {

        System.out.println(String.format("%d Links wurden in %d Zeilen gefunden.", gefundeneLinks, geleseneZeilen));
    }
}
