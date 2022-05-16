
/**
 * Beschreiben Sie hier die Klasse AlkoholfreiesGetraenk.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public abstract class AlkoholfreiesGetraenk extends Getraenk
{
    private String hersteller;

    /**
     * Konstruktor für Objekte der Klasse AlkoholfreiesGetraenk
     */
    public AlkoholfreiesGetraenk()
    {
       
    }
    
    public AlkoholfreiesGetraenk(String bezeichnung, String hersteller){
        super(bezeichnung);
        this.hersteller = hersteller;   
       
    }

    public void setHersteller(String hersteller){
        this.hersteller = hersteller;
    }
    
    public String getHersteller(){
        return hersteller;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Hersteller: " + hersteller + "\n";
    }
}
