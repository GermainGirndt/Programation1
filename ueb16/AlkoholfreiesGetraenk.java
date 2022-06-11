
/**
 * Beschreiben Sie hier die Klasse AlkoholfreiesGetraenk.
 * 
 * @author Girndt, Germain; Krier, Katharina 
 * @version 1.0
 */
public abstract class AlkoholfreiesGetraenk extends Getraenk
{
    private String hersteller;

    /**
     * Konstruktor für Objekte der Klasse AlkoholfreiesGetraenk
     */
    public AlkoholfreiesGetraenk() {}
    
    public AlkoholfreiesGetraenk(String bezeichnung, String hersteller) {
        super(bezeichnung);
        this.setHersteller(hersteller);
       
    }

    public void setHersteller(String hersteller) {
        this.validiereGetraenkeProperty(hersteller, "Hersteller");
        this.hersteller = hersteller;
    }
    
    public String getHersteller() {
        return hersteller;
    }
    
    @Override
    public String toString() {
        if (!this.istVollkommen()) {
            throw new IllegalArgumentException("Getraenke mit fehlenden Informationen kann nicht ausgegeben werden");
        }
        
        return super.toString() + "Hersteller: " + hersteller;
    }

    @Override
    public boolean istVollkommen() {
        return super.istVollkommen() && this.hersteller != null;
    }
}
