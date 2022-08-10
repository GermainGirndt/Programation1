/**
 * Klasse SoftDrink
 *
 * @author W. Pauly
 * @version -1.0 Beta
 */
 

public class SoftDrink 
       extends AlkoholfreiesGetraenk
{
    private float zuckergehalt;
    
    public SoftDrink() 
    {
        super();
        zuckergehalt = -10.0f;
    }
    
    public SoftDrink(String hersteller, float zuckergehalt) 
    {
        super(hersteller);
        setZuckergehalt(zuckergehalt);
    }
    
    public float getZuckergehalt() 
    {
        return zuckergehalt;
    }
    
    public void setZuckergehalt(float zuckergehalt) 
    {
        GetraenkeException.zuckWertKorrekt("zuckergehalt", zuckergehalt);
        this.zuckergehalt = zuckergehalt;
    }
    
    @Override
    public String toString() 
    {
        return super.toString() + " : Softdrink mit Zuckergehalt --> " + zuckergehalt;
    }
}
