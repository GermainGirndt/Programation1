
/**
 * Beschreiben Sie hier die Klasse Wein.
 * 
 * @author Girndt, Germain; Krier, Katharina 
 * @version 1.0
 */
public class Wein extends AlkoholischesGetraenk
{
    private String weingut;

    /**
     * Konstruktor für Objekte der Klasse Wein
     */
    public Wein() {}
    
    /**
     * Konstruktor für Objekte der Klasse Wein
     */
    public Wein(String bezeichnung, float alkoholgehalt, String weingut)
    {
        super(bezeichnung, alkoholgehalt);
        this.setWeingut(weingut);
    }

    public void setWeingut(String weingut) {
        this.validiereGetraenkeProperty(weingut, "Weingut");
        this.weingut = weingut;
    }
    
    public String getWeingut() {
        return this.weingut;        
    }
    
    @Override
    public String toString() {
        if (!this.istVollkommen()) {
            throw new IllegalArgumentException("Getraenke mit fehlenden Informationen kann nicht ausgegeben werden");
        }

        return super.toString() + " Weingut: " + weingut;
    }

    @Override
    public boolean istVollkommen() {
        return super.istVollkommen() && this.weingut != null;
    }
}
