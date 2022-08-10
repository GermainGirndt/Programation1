/**
 * Abstrakte Klasse AlkoholfreiesGetraenk
 *
 * @author W. Pauly
 * @version -1.0 Beta
 */



public abstract class AlkoholfreiesGetraenk 
       extends Getraenk
{
    private String hersteller;
    
    public AlkoholfreiesGetraenk() 
    {
        hersteller = "Noch nicht bekannt ";
    }
    
    public AlkoholfreiesGetraenk(String hersteller) 
    {
        setHersteller(hersteller);
    }
    
    public String getHersteller() 
    {
        return hersteller;
    }
    
    public void setHersteller(String hersteller) 
    {
        GetraenkeException.nameKorrekt("hersteller", hersteller);
        this.hersteller = hersteller;
    }
    
    public String toString() 
    {
        return super.toString() + "alkoholfrei von " +  hersteller;
    }
}
