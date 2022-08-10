/**
 * Klasse Wasser
 *
 * @author W. Pauly
 * @version -1.0 Beta
 */
 

public class Wasser 
       extends AlkoholfreiesGetraenk
{
    private String quelle;
    
    public Wasser() 
    {
        super();
        quelle = "Noch nicht bekannt ";
    }
    
    public Wasser(String hersteller, String quelle) 
    {
        super(hersteller);
        setQuelle(quelle);
    }
    
    public String getQuelle() 
    {
        return quelle;
    }
    
    public void setQuelle(String quelle) 
    {
        GetraenkeException.nameKorrekt("quelle", quelle);
        this.quelle = quelle;
    }
    
    @Override
    public String toString() 
    {
        return super.toString() + " : Wasser aus der Quelle --> " + quelle;
    }
}
