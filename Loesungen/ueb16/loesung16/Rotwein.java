/**
 * Klasse Rotwein
 *
 * @author W. Pauly
 * @version -1.0 Beta
 */
 

public class Rotwein 
       extends Wein
{
    public Rotwein() 
    {
        super();
    }
    
    public Rotwein(float alkoholgehalt, String weingut) 
    {
        super(alkoholgehalt, weingut);
    }
    
    public String toString() 
    {
        return super.toString() + " : Typ --> Rotwein";
    }
}
