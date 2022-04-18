/**
 * Die Klasse Mittelwert ist ein einfacher Datencontainer
 * 
 * @author Girndt, Germain & Krier, Katharina  
 * @version 1.0
 */
public class Mittelwert {

    double mittelwert;
    double nahesterWert;
    double entferntesterWert;

    /**
     * Klassenkonstrutor
     * 
     * @param mittelwert der Mittelwert
     * @param nahesterWert der Wert im Array, dass dem Mittelwert am nächsten liegt
     * @param entferntesterWert der Wert im Array, dass dem Mittelwert am fernsten liegt
     * 
     * @author Girndt, Germain & Krier, Katharina  
     * @version 1.0
     */
    public Mittelwert(double mittelwert, double nahesterWert, double entferntesterWert) {

        this.mittelwert = mittelwert;
        this.nahesterWert = nahesterWert;
        this.entferntesterWert = entferntesterWert;

    }

    
    public double getMittelwert() {
        return mittelwert;    
    }
    
    public double getNahesterwert() {
        return nahesterWert;    
    }
    
    public double getEntferntesterwert() {
        return entferntesterWert;    
    }
}
