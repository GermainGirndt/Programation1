
/**
 * Beschreiben Sie hier die Klasse Fakultaet.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Fakultaet implements MyFunction
{
    
    /**
     * Konstruktor für Objekte der Klasse Fakultaet
     */
    public Fakultaet()
    {
       
    }

    @Override
    public int apply(int x){
        int erg = 1;
        for(int i = 1; i<=x; i++)
            erg *= i;
        return erg;
    }
}
