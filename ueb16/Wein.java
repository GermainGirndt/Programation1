
/**
 * Beschreiben Sie hier die Klasse Wein.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Wein extends AlkoholischesGetraenk
{
    private String weingut;

    /**
     * Konstruktor für Objekte der Klasse Wein
     */
    public Wein()
    {
        
    }
    
    /**
     * Konstruktor für Objekte der Klasse Wein
     */
    public Wein(String bezeichnung, float alkoholgehalt, String weingut)
    {
        super(bezeichnung, alkoholgehalt);
        this.weingut = weingut;
    }

    public void setWeingut(String weingut){
        this.weingut = weingut;
    }
    
    public String getWeingut(){
        return weingut;        
    }
    
    @Override
    public String toString(){
        return super.toString() + "Weingut: " + weingut + "\n";
    }
}
