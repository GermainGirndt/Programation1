
/**
 * Beschreiben Sie hier die Klasse Softdrink.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Softdrink extends AlkoholfreiesGetraenk
{
    private String zuckergehalt;

    /**
     * Konstruktor für Objekte der Klasse Softdrink
     */
    public Softdrink()
    {
    }
    
    /**
     * Konstruktor für Objekte der Klasse Softdrink
     */
    public Softdrink(String bezeichnung, String hersteller, String zuckergehalt)
    {
        super(bezeichnung, hersteller);
        this.zuckergehalt = zuckergehalt;
    }

    public void setZuckergehalt(String zuckergehalt){
        this.zuckergehalt = zuckergehalt;   
    }
    
    public String getZuckergehalt(){
        return zuckergehalt;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Zuckergehalt: " + zuckergehalt + "\n";
    }
}
