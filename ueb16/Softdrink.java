
/**
 * Beschreiben Sie hier die Klasse Softdrink.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Softdrink extends AlkoholfreiesGetraenk
{
    private int zuckergehalt;

    /**
     * Konstruktor für Objekte der Klasse Softdrink
     */
    public Softdrink()
    {
    }
    
    /**
     * Konstruktor für Objekte der Klasse Softdrink
     */
    public Softdrink(String bezeichnung, String hersteller, int zuckergehalt)
    {
        super(bezeichnung, hersteller);
        //Validierung hinzufuegen!!!
        this.zuckergehalt = zuckergehalt;
    }

    public void setZuckergehalt(int zuckergehalt){
        this.zuckergehalt = zuckergehalt;   
    }
    
    public int getZuckergehalt(){
        return zuckergehalt;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Zuckergehalt: " + zuckergehalt + "\n";
    }
}
