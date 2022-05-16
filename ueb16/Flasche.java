
/**
 * Beschreiben Sie hier die Klasse Flasche.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Flasche<T extends Getraenk>
{
    private T inhalt;
    public void fuellen(T object) { this.inhalt = object; }
    public T leeren() { return inhalt; }
  
    @Override 
    public String toString(){
        return inhalt.toString();
    }
}
