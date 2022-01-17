/**
 * Die Klasse VideoArtikelDummyFactory bietet ein gutes Werkzeug,
 * um Artikel-Objekte (Typ Video) fuer automatisierte Tests zu generieren
 * 
 * @author Girndt & Krier 
 * @version 1.0
 */
public class VideoArtikelDummyFactory extends AbstractArtikelDummyFactory {

    private final       int                        INDEX_ARTIKEL_NUMMER = 0;
    private final       int                        INDEX_ARTIKEL_BESTAND = 1;
    private final       int                        INDEX_ARTIKEL_PREIS = 2;
    private final       int                        INDEX_TITEL = 3;
    private final       int                        INDEX_SPIELDAUER = 4;
    private final       int                        INDEX_JAHR = 5;
    
    private Object[][] seed = {
        new Object[] { 1111, 500, 750.00, "erstes Video", 6,  2011  },
        new Object[] { 1234,  10, 500.00, "zweites Video", 5, 2012  },

    };
    
    private             Artikel[]                  artikelArray;

    public VideoArtikelDummyFactory() {
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
            int bestand              =   (int)    this.seed[index][INDEX_ARTIKEL_BESTAND];
            double artikelpreis      =   (double) this.seed[index][INDEX_ARTIKEL_PREIS];
            String titel             =   (String) this.seed[index][INDEX_TITEL];
            int spieldauer        =      (int) this.seed[index][INDEX_SPIELDAUER];
            int jahr              =      (int) this.seed[index][INDEX_JAHR];

            this.artikelArray[index] = new Video(artikelnummer, bestand, artikelpreis, titel, spieldauer, jahr);
        }

        this.setArtikelArray(artikelArray);
    }
}
