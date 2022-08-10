/**
 * Abstrakte Klasse AlkoholischesGetraenk
 *
 * @author W. Pauly
 * @version -1.0 Beta
 */



public abstract class AlkoholischesGetraenk 
       extends Getraenk
{
    private float alkoholgehalt;
    
    public AlkoholischesGetraenk() 
    {
        this.alkoholgehalt = -1.0f;
    }
    
    public AlkoholischesGetraenk(float alkoholgehalt) 
    {
        this.setAlkoholgehalt(alkoholgehalt);
    }
    
    public float getAlkoholgehalt() 
    {
        return this.alkoholgehalt;
    }
    
    public void setAlkoholgehalt(float alkoholgehalt) 
    {
        GetraenkeException.alkWertKorrekt("alkoholgehalt", alkoholgehalt);
        this.alkoholgehalt = alkoholgehalt;
    }
    
    public String toString() 
    {
        return super.toString() + " alkoholgehalt: " + alkoholgehalt;
    }
}
