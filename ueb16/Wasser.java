
/**
 * Beschreiben Sie hier die Klasse Wasser.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Wasser extends AlkoholfreiesGetraenk
{
    private String quelle;

    /**
     * Konstruktor für Objekte der Klasse Wasser
     */
    public Wasser()
    {
        
    }
    
    /**
     * Konstruktor für Objekte der Klasse Wasser
     */
    public Wasser(String bezeichnung, String hersteller, String quelle)
    {
        super(bezeichnung, hersteller);
        this.quelle = quelle;
        
    }
  
    public void setQuelle(String quelle){
        this.quelle = quelle;
    }
    
    public String getQuelle(){
        return quelle;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Quelle: " + quelle + "\n";
    }
}
