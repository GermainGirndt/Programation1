
/**
 * Beschreiben Sie hier die Klasse AlkoholischesGetraenk.
 * 
 * @author Girndt, Germain; Krier, Katharina 
 * @version 1.0
 */
public  abstract class AlkoholischesGetraenk extends Getraenk
{

    private float alkoholgehalt;
    
    /**
     * Konstruktor für Objekte der Klasse AlkoholischesGetraenk
     */
    public AlkoholischesGetraenk() {}

    
    /**
     * Konstruktor für Objekte der Klasse AlkoholischesGetraenk
     */
    public AlkoholischesGetraenk(String bezeichnung, float alkoholgehalt)
    {
        super(bezeichnung);
        this.setAlkoholGehalt(alkoholgehalt);
    }
  
    public void setAlkoholGehalt(float alkoholgehalt){
        if (alkoholgehalt <= 0) {
            throw new IllegalArgumentException("Alkoholgehalt muss groesser null sein");
        }

        this.alkoholgehalt = alkoholgehalt;
    }
    
    public float getAlkoholGehalt(){
        return alkoholgehalt;    
    }
    
    @Override 
    public String toString(){
        if (!this.istVollkommen()) {
            throw new IllegalArgumentException("Getraenke mit fehlenden Informationen kann nicht ausgegeben werden");
        }
        
        return super.toString() + " Alkoholgehalt: " + alkoholgehalt;
    }

    @Override
    public boolean istVollkommen() {
        return super.istVollkommen() && this.alkoholgehalt != 0.0f;
    }
}
