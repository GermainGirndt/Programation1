
/**
 * Beschreiben Sie hier die Klasse Softdrink.
 * 
 * @author Girndt, Germain; Krier, Katharina 
 * @version 1.0
 */
public class Softdrink extends AlkoholfreiesGetraenk
{
    private float zuckergehalt;

    /**
     * Konstruktor für Objekte der Klasse Softdrink
     */
    public Softdrink() {}
    
    /**
     * Konstruktor für Objekte der Klasse Softdrink
     */
    public Softdrink(String bezeichnung, String hersteller, float zuckergehalt)
    {
        super(bezeichnung, hersteller);
        this.setZuckergehalt(zuckergehalt);
    }

    public void setZuckergehalt(float zuckergehalt) {
        if(zuckergehalt <0){
            throw new IllegalArgumentException("Zuckergehalt muss positiv sein");
        }
        this.zuckergehalt = zuckergehalt;   
    }
    
    public float getZuckergehalt(){
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
        return super.istVollkommen() ;
    }
}
