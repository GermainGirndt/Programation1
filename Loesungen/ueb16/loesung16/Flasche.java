/**
 * Parametrierbare Klasse Flasche
 *
 * @author W. Pauly
 * @version -1.0 Beta
 */
 

public class Flasche<T extends Getraenk>
{
    private T inhalt;
    private boolean gefuellt;
    
    public Flasche() 
    {
        inhalt = null;
        gefuellt = false;
    }
    
    public void fuellen(final T inhalt) 
    {
        this.inhalt = inhalt;
        gefuellt = true;
    }
    
    public void leeren() 
    {
        inhalt = null;
        gefuellt = false;
    }
    
    public boolean gefuellt() 
    {
        return gefuellt;
    }
    
    @Override
    public String toString() 
    {
        if (gefuellt) 
    {
            return inhalt.toString();
        }
        return "Die Flasche ist leer 111";
    }
}
