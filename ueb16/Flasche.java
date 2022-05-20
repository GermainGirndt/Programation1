
/**
 * Beschreiben Sie hier die Klasse Flasche.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Flasche<T extends Getraenk>
{
    private T inhalt;
    public void fuellen(T inhalt) {
         this.inhalt = inhalt; 
    }

    public void leeren() { 
        this.inhalt = null;
    }
  
    @Override 
    public String toString(){
        return "Flasche Inhalt: " + this.inhalt.toString();
    }
}
