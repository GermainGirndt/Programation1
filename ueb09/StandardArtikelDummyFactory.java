/**
 * Die Klasse ArtikelDummyFactory bietet ein gutes Werkzeug,
 * um Artikel-Objekte fuer automatisierte Tests zu generieren
 * 
 * @author Girndt & Krier 
 * @version 1.0
 */
public class StandardArtikelDummyFactory extends AbstractArtikelDummyFactory {

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
    
    private             Artikel[]                  artikelArray;

    public StandardArtikelDummyFactory() {
        this.erstelleArtikelarray();
    }

    /**
    * Erstellt einen Artikel-Array gueltiger Artikel durch das Seed
    */
    @Override
    protected void erstelleArtikelarray() {
        int maximaleArtikelanzahl = this.seed.length;
        
        this.artikelArray = new Artikel[maximaleArtikelanzahl];
        
        for (int index = 0; index < maximaleArtikelanzahl; index++) {
            
            int artikelnummer        =   (int)    this.seed[index][INDEX_ARTIKEL_NUMMER];
            String artikelart        =   (String) this.seed[index][INDEX_ARTIKEL_ART];
            int bestand              =   (int)    this.seed[index][INDEX_ARTIKEL_BESTAND];
            double artikelpreis      =   (double) this.seed[index][INDEX_ARTIKEL_PREIS];

            this.artikelArray[index] = new Artikel(artikelnummer, artikelart, bestand, artikelpreis);
        }

        this.setArtikelArray(artikelArray);
    }
}
