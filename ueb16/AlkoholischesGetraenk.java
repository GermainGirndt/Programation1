
/**
 * Beschreiben Sie hier die Klasse AlkoholischesGetraenk.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public  abstract class AlkoholischesGetraenk extends Getraenk
{

    private float alkoholgehalt;
    
    /**
     * Konstruktor für Objekte der Klasse AlkoholischesGetraenk
     */
    public AlkoholischesGetraenk()
    {
       
    }

    
    /**
     * Konstruktor für Objekte der Klasse AlkoholischesGetraenk
     */
    public AlkoholischesGetraenk(String bezeichnung, float alkoholgehalt)
    {
        super(bezeichnung);
        this.alkoholgehalt = alkoholgehalt;
    }
  
    public void setAlkoholGehalt(float alkoholgehalt){
        this.alkoholgehalt = alkoholgehalt;
    }
    
    public float getAlkoholGehalt(){
        return alkoholgehalt;    
    }
    
    @Override 
    public String toString(){
        return super.toString() + "Alkoholgehalt: " + alkoholgehalt + "\n";
    }
}
