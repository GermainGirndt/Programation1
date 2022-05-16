
/**
 * Beschreiben Sie hier die Klasse Getraenk.
 * 
 * @author Girndt, Krier
 * @version 1.0
 */
public abstract class Getraenk
{
    private String bezeichnung;

    /**
     * Konstruktor für Objekte der Klasse Getraenk
     */
    public Getraenk()
    {
    }
    
    /**
     * Konstruktor für Objekte der Klasse Getraenk
     */
    public Getraenk(String bezeichnung)
    {
        
        this.bezeichnung = bezeichnung;    
       
    }
    
    public void setBezeichnung(String bezeichnung){
      
        this.bezeichnung = bezeichnung;    
         
    }
    
    public String getBezeichnung(){
        return bezeichnung;
    }
    
    @Override
    public String toString(){
        return "Bezeichnung: " + this.bezeichnung + "\n";
    }
}
