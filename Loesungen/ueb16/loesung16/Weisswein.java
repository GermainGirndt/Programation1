/**
 * Klasse Weisswein
 *
 * @author W. Pauly
 * @version -1.0 Beta
 */
 

public class Weisswein 
       extends Wein
{
    public Weisswein() 
    {
        super();
    }
    
    public Weisswein(float alkoholgehalt, String weingut) 
    {
        super(alkoholgehalt, weingut);
    }
    
    public String toString() 
    {
        return super.toString() + " : Typ --> Weisswein";
    }
}
