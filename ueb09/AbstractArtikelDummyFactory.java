import java.util.Arrays;
/**
 * Die Klasse AbstractArtikelDummyFactory bietet ein abstraktes Klassen-Muster,
 * um Artikel-Objekte fuer automatisierte Tests zu generieren
 * 
 * @author Girndt & Krier 
 * @version 1.0
 */
public abstract class AbstractArtikelDummyFactory {

    private             Artikel[]                  artikelArray;

    private             int                        maximaleArtikelanzahl;

    protected void setArtikelArray(Artikel[] artikelArray) {
        this.artikelArray = artikelArray;
        this.maximaleArtikelanzahl = artikelArray.length;
    }

    /**
     * Gibt ein Artikel-Objekt zurueck je nach Instanznummer
     * @param artikelInstanznummer ist die Artikelnummer nach dem Seed (s. erstelleArtikelArray-Methode)
     * @return den wählten Artikel
     * 
     * Das dient zur Code-Organisation.
     */
    public Artikel macheEinenArtikel (int artikelInstanznummer) {

        Validierung.checkeObNatuerlicheZahl(artikelInstanznummer);
        
        if (artikelInstanznummer > this.artikelArray.length) {
            throw new IndexOutOfBoundsException(String.format(
                "Es werden bis %s Artikel unterstuezt. Angefragt: %s",
                this.maximaleArtikelanzahl,
                artikelInstanznummer
                ));  
            }
            
            int artikelInstanzIndex = artikelInstanznummer - 1;
            
            Artikel artikel = this.artikelArray[artikelInstanzIndex];
            
            return artikel;
        }
        
        /**
         * Gibt die eingegebene Anzahl an Artikel zurueck.
         * Die Artikel befolgen die Reihenfolgen im Seed
         * @param artikelAnzahl die zurueckgegeben werden soll
         * @return eine Artikel-Array
         */
        public Artikel[] macheVieleArtikel (int artikelAnzahl) {
            
            if (artikelAnzahl > this.maximaleArtikelanzahl) {
                throw new IndexOutOfBoundsException(String.format(
                    "Es werden bis %s Artikel unterstuezt. Angefragt: %s",
                    this.maximaleArtikelanzahl,
                    artikelAnzahl
                    ));  
        }
        
        Validierung.checkeObNatuerlicheZahl(artikelAnzahl);

        int startIndex = 0;
        int endIndex = artikelAnzahl;

        return Arrays.copyOfRange(this.artikelArray, startIndex, endIndex);
    }

    /**
    * Erstellt einen Artikel-Array gueltiger Artikel durch das Seed
    */
    protected abstract void erstelleArtikelarray();
}
