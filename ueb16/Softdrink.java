
/**
 * Beschreiben Sie hier die Klasse Softdrink.
 * 
 * @author Girndt, Germain; Krier, Katharina 
 * @version 1.0
 */
public class Softdrink extends AlkoholfreiesGetraenk
{
    private String zuckergehalt;

    /**
     * Konstruktor für Objekte der Klasse Softdrink
     */
    public Softdrink() {}
    
    /**
     * Konstruktor für Objekte der Klasse Softdrink
     */
    public Softdrink(String bezeichnung, String hersteller, String zuckergehalt)
    {
        super(bezeichnung, hersteller);
        this.setZuckergehalt(zuckergehalt);
    }

    public void setZuckergehalt(String zuckergehalt) {
        this.validiereGetraenkeProperty(zuckergehalt, "Zuckergehalt");
        this.zuckergehalt = zuckergehalt;   
    }
    
    public String getZuckergehalt(){
        return this.zuckergehalt;
    }
    
    @Override
    public String toString(){
        if (!this.istVollkommen()) {
            throw new IllegalArgumentException("Getraenke mit fehlenden Informationen kann nicht ausgegeben werden");
        }
        
        return super.toString() + " Zuckergehalt: " + zuckergehalt;
    }

    @Override
    public boolean istVollkommen() {
        return super.istVollkommen() && this.zuckergehalt != null;
    }
}
