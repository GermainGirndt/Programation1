import java.util.ArrayList;

/**
 * Parametreirbare Klasse Getraenkeautomat
 *
 * @author W. Pauly
 * @version -1.0 Beta
 */
 

public class Getraenkeautomat<T extends Getraenk>

{
    public static final String AUTOMAT_VOLL = " Der Automat kann KEINE Flaschen mehr aufnehmen !!!";
    public static final String AUTOMAT_LEER = " Der Automat ist LEER !!!";


    private  ArrayList<Flasche<? extends T>> flaschenlager;
    private int kapazitaet;
    
    public Getraenkeautomat(int kapazitaet) 
    {
        this.kapazitaet = kapazitaet;
        flaschenlager = new ArrayList<>(kapazitaet);
    }
    
    public void flascheEinlegen(Flasche<? extends T> flasche) 
    {
        GetraenkeautomatException.flascheGefuellt(flasche);
        if (flaschenlager.size() >= kapazitaet) 
    {
            throw new GetraenkeautomatException( AUTOMAT_VOLL );
        }
        flaschenlager.add(flasche);
    }
    
    public Flasche<? extends T> flascheAusgeben() 
    {
        if (flaschenlager.size() == 0) 
        {
            throw new GetraenkeautomatException( AUTOMAT_LEER );
        }
        return flaschenlager.remove(0);
    }
    
    @Override
    public String toString() 
    {
        String flaschenlagerInhalt = new String();
        for (int i = 0; i < flaschenlager.size(); ++i) 
    {
            flaschenlagerInhalt += "\n " +  flaschenlager.get(i);
        }
        return flaschenlagerInhalt;
    }
}
