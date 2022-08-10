/**
 * Klasse Bier
 *
 * @author W. Pauly
 * @version -1.0 Beta
 */
 

public class Bier 
       extends AlkoholischesGetraenk
{
    private String brauerei;
    
    public Bier() 
    {
        super();
        brauerei = "Noch nicht bekannt ";
    }
    
    public Bier(float alkoholgehalt, String brauerei) 
    {
        super(alkoholgehalt);
        setBrauerei(brauerei);
    }
    
    public String getBrauerei() 
    {
        return brauerei;
    }
    
    public void setBrauerei(String brauerei) 
    {
        GetraenkeException.nameKorrekt("brauerei", brauerei);
        this.brauerei = brauerei;
    }
    
    public String toString() 
    {
        return super.toString() + " : Bier von der Brauerei --> " + brauerei;
    }
}
