import java.util.Arrays;
import java.util.HashMap;
/**
 * Die Klasse ArtikelDummyFactory bietet ein gutes Werkzeug,
 * um Artikel-Objekte fuer automatisierte Tests zu generieren
 * 
 * @author Girndt & Krier 
 * @version 1.0
 */
public class ArtikelDummyFactory {

    private             HashMap<String, Object>[]  artikelWerte;
    private             Artikel[]                  artikelArray;

    private             int                        MAX_ARTIKEL_ANZAHL;


    private final       int                        INDEX_ARTIKEL_NUMMER = 0;
    private final       int                        INDEX_ARTIKEL_ART = 1;
    private final       int                        INDEX_ARTIKEL_BESTAND = 2;
    private final       int                        INDEX_ARTIKEL_PREIS = 3;

    private Object[][] seed = {
        new Object[] { 1111, "Playstation", 500,        750.00     },
        new Object[] { 1234, "Nintendo Wii", 10,        500.00     },
        new Object[] { 9999, "X-Box",         0,        600.00     },
        new Object[] { 9998, "iPhone 12",     5,       1000.00     },
        new Object[] { 5682, "Galaxy Note 8", 8,        888.88     },
        new Object[] { 4567, "Redmi Note 7", 50,        300.25     },
        new Object[] { 1000, "Tesla",         1,      99999.99     },
        new Object[] { 9979, "Raumschiff",    0, 1250015498.3674   },
        new Object[] { 7698, "Kaugummi",      1,          0.999999 },
        new Object[] { 4000, "Hantel",       20,          42.99    },
        new Object[] { 3000, "Fitness Raum",  1,       42000.99    },
    };
    
    public void ArtikelDummyFactory() {
        this.erstelleArtikelarray();
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
        this.erstelleArtikelarray(); // warum brauche ich das hier? habe ich die Methode vorher nicht aufgerufen?

        int artikelInstanzindex = artikelInstanznummer - 1;

        Artikel artikel = this.artikelArray[artikelInstanzindex];

        return artikel;
    }
    
     /**
     * Gibt die eingegebene Anzahl an Artikel zurueck.
     * Die Artikel befolgen die Reihenfolgen im Seed
     * @param artikelAnzahl die zurueckgegeben werden soll
     * @return eine Artikel-Array
     */
    public Artikel[] macheVieleArtikel (int artikelAnzahl) {
        this.erstelleArtikelarray(); // warum brauche ich das hier? habe ich die Methode vorher nicht aufgerufen?

        if (artikelAnzahl > MAX_ARTIKEL_ANZAHL) {
            throw new IndexOutOfBoundsException(String.format(
                "Es werden bis %s Artikel unterstuezt. Angefragt: %s",
                MAX_ARTIKEL_ANZAHL,
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
    private void erstelleArtikelarray() {

        MAX_ARTIKEL_ANZAHL = this.seed.length;
        
        this.artikelWerte = (HashMap<String, Object>[]) new HashMap[MAX_ARTIKEL_ANZAHL];

        this.artikelArray = new Artikel[MAX_ARTIKEL_ANZAHL];
        
        for (int index = 0; index < MAX_ARTIKEL_ANZAHL; index++) {
            
            int artikelnummer        =   (int)    this.seed[index][INDEX_ARTIKEL_NUMMER];
            String artikelart        =   (String) this.seed[index][INDEX_ARTIKEL_ART];
            int bestand              =   (int)    this.seed[index][INDEX_ARTIKEL_BESTAND];
            double artikelpreis      =   (double) this.seed[index][INDEX_ARTIKEL_PREIS];

            this.artikelArray[index] = new Artikel(artikelnummer, artikelart, bestand, artikelpreis);
        }

    }
}
