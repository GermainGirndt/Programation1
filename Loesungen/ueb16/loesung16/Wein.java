/**
 * Klasse Wein
 *
 * @author W. Pauly
 * @version -1.0 Beta
 */
 

public class Wein 
       extends AlkoholischesGetraenk
{
    private String weingut;
    
    public Wein() 
    {
        super();
        weingut = "Noch nicht bekannt ";
    }
    
    public Wein(float alkoholgehalt, String weingut) 
    {
        super(alkoholgehalt);
        setWeingut(weingut);
    }
    
    public String getWeingut() 
    {
        return weingut;
    }
    
    public void setWeingut(String weingut) 
    {
        GetraenkeException.nameKorrekt("weingut", weingut);
        this.weingut = weingut;
    }
    
    @Override
    public String toString() 
    {
        return super.toString() + " : Wein aus dem Weingut --> " +  weingut;
    }
}
