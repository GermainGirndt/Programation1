/**
 * Die Klasse ArtikelDummyFactory bietet ein gutes Werkzeug,
 * um Artikel-Objekte fuer automatisierte Tests zu generieren
 * 
 * @author Girndt & Krier 
 * @version 1.0
 */
public class ArtikelDummyFactoryFacade {

    public final        String                     FEHLER_TYP_NICHT_UNTERSTUEZT = "Dieser Typ wird für Artikel nicht unterstützt.";

    private AbstractArtikelDummyFactory[] factories;
    private AbstractArtikelDummyFactory aktivesArtikelFactory;

    public ArtikelDummyFactoryFacade() {

        this.factories = new AbstractArtikelDummyFactory[ArtikelTypen.values().length];
        
        this.factories[ArtikelTypen.STANDARD.getIndex()] = new StandardArtikelDummyFactory();
        this.factories[ArtikelTypen.VIDEO.getIndex()] = new VideoArtikelDummyFactory();
        this.factories[ArtikelTypen.CD.getIndex()] = new CDArtikelDummyFactory();
        this.factories[ArtikelTypen.BUCH.getIndex()] = new BuchArtikelDummyFactory();
        
        this.aktivesArtikelFactory = this.factories[ArtikelTypen.STANDARD.getIndex()];

    }

    public void setArtikelTyp(ArtikelTypen artikelTyp) {
        this.aktivesArtikelFactory = this.factories[artikelTyp.getIndex()];
    }

    /**
     * Gibt ein Artikel-Objekt zurueck je nach Instanznummer
     * @param artikelInstanznummer ist die Artikelnummer nach dem Seed (s. erstelleArtikelArray-Methode)
     * @return den wählten Artikel
     * 
     * Das dient zur Code-Organisation.
     */
    public Artikel macheEinenArtikel (int artikelInstanznummer) {

        Artikel artikel = this.aktivesArtikelFactory.macheEinenArtikel(artikelInstanznummer);

        return artikel;

    }
    
     /**
     * Gibt die eingegebene Anzahl an Artikel zurueck.
     * Die Artikel befolgen die Reihenfolgen im Seed
     * @param artikelAnzahl die zurueckgegeben werden soll
     * @return eine Artikel-Array
     */
    public Artikel[] macheVieleArtikel (int artikelAnzahl) {

        Artikel[] vieleArtikel = this.aktivesArtikelFactory.macheVieleArtikel(artikelAnzahl);

        return vieleArtikel;
    }
}
