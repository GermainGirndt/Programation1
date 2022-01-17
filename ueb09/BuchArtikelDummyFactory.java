/**
 * Die Klasse BuchArtikelDummyFactory bietet ein gutes Werkzeug,
 * um Artikel-Objekte (Typ Buch) fuer automatisierte Tests zu generieren
 * 
 * @author Girndt & Krier 
 * @version 1.0
 */
public class BuchArtikelDummyFactory extends AbstractArtikelDummyFactory {

    private final       int                        INDEX_ARTIKEL_NUMMER = 0;
    private final       int                        INDEX_ARTIKEL_BESTAND = 1;
    private final       int                        INDEX_ARTIKEL_PREIS = 2;
    private final       int                        INDEX_AUTOR = 3;
    private final       int                        INDEX_TITEL = 4;
    private final       int                        INDEX_VERLAG = 5;
    
    private Object[][] seed = {
        new Object[] { 1111, 500, 750.00, "George Orwell", "Revolution der Tieere", "Reclam"},
        new Object[] { 1234,  10, 500.00, "Karl Marx", "Manifest der komunistischen Partei", "Reclam auch"},

    };
    
    private             Artikel[]                  artikelArray;

    public BuchArtikelDummyFactory() {
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
            String autor             =   (String) this.seed[index][INDEX_AUTOR];
            String titel             =   (String) this.seed[index][INDEX_TITEL];
            String verlag            =   (String) this.seed[index][INDEX_VERLAG];

            this.artikelArray[index] = new Buch(artikelnummer, bestand, artikelpreis, autor, titel, verlag);
        }

        this.setArtikelArray(artikelArray);
    }
}
