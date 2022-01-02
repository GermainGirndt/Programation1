
/**
 * Beschreiben Sie hier die Klasse Mittelwert.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Mittelwert
{
    double mittelwert;
    double nahesterwert;
    double entferntesterwert;
    
    /**
     * Konstruktor für Objekte der Klasse Mittelwert
     */
    public Mittelwert(double mittelwert, double nahesterwert, double entferntesterwert)
    {
        this.mittelwert        = mittelwert;
        this.nahesterwert      = nahesterwert;
        this.entferntesterwert = entferntesterwert;
    }
    
    public double getMittelwert(){
        return mittelwert;    
    }
    
    public double getNahesterwert(){
        return nahesterwert;    
    }
    
    public double getEntferntesterwert(){
        return entferntesterwert;    
    }
}
