
/**
 * Produkt, das im Rahmen eines Projektes erzeugt wird
 * 
 * @author Folz 
 * @version 2013
 *
 * von wpy ergaenzt um weiteren Konstruktor
 */
public class Produkt extends Projektbestandteil {
    public static String MSG_PRODKOSTEN = "Produktionskosten duerfen nicht negativ sein!";

    public static double STANDARD_PRODKOSTEN = 0.0;
    private double prodKosten;
    
    public Produkt(String name, String beschreibung) {
        super(name, beschreibung);
        this.prodKosten = STANDARD_PRODKOSTEN;
    }

    public Produkt(String name, String beschreibung, double prodKosten) {
        super(name, beschreibung);
        assert prodKosten >= 0.0 : MSG_PRODKOSTEN;
        this.prodKosten = prodKosten;
    }
    
    public double getKosten() {
        return prodKosten;
    }
    
    public void setKosten( double prodKosten ) {
        assert prodKosten >= 0.0 : MSG_PRODKOSTEN;
        this.prodKosten = prodKosten;
    }

    public String toString() {
        return String.format("%s\tProduktionskosten: %8.2f ", super.toString(), prodKosten); 
    }

}
