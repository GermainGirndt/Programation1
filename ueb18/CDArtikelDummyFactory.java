/**
 * Die Klasse CDArtikelDummyFactory bietet ein gutes Werkzeug,
 * um Artikel-Objekte (Typ CD) fuer automatisierte Tests zu generieren
 * 
 * @author Girndt & Krier 
 * @version 1.0
 */
public class CDArtikelDummyFactory extends AbstractArtikelDummyFactory {

    private final       int                        INDEX_ARTIKEL_NUMMER = 0;
    private final       int                        INDEX_ARTIKEL_BESTAND = 1;
    private final       int                        INDEX_ARTIKEL_PREIS = 2;
    private final       int                        INDEX_INTERPRET = 3;
    private final       int                        INDEX_TITEL = 4;
    private final       int                        INDEX_TITELANZAHL = 5;
    
    private Object[][] seed = {
        new Object[] { 1111, 500, 750.00, "Radiohead", "erstes CD", 6},
        new Object[] { 1234,  10, 500.00, "Linkin Park", "zweites CD", 5},

    };
    
    private             Artikel[]                  artikelArray;

    public CDArtikelDummyFactory() {
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
            
            int    artikelnummer     =   (int)    this.seed[index][INDEX_ARTIKEL_NUMMER];
            int    bestand           =   (int)    this.seed[index][INDEX_ARTIKEL_BESTAND];
            double artikelpreis      =   (double) this.seed[index][INDEX_ARTIKEL_PREIS];
            String interpret         =   (String) this.seed[index][INDEX_INTERPRET];
            String titel             =   (String) this.seed[index][INDEX_TITEL];
            int    titelanzahl       =   (int) this.seed[index][INDEX_TITELANZAHL];

            this.artikelArray[index] = new CD(artikelnummer, bestand, artikelpreis, interpret, titel, titelanzahl);
        }

        this.setArtikelArray(artikelArray);
    }
}
