
/**
 * Beschreiben Sie hier die Klasse Flasche.
 * 
 * @author Girndt, Germain; Krier, Katharina 
 * @version 1.0
 */
public class Flasche<T extends Getraenk>
{
    private T inhalt;
    private String inhaltName;

    public void fuellen(T inhalt) {
        if (inhalt == null)  {
            throw new IllegalArgumentException("Flasche kann nicht ohne Inhalt gefuellt werden");
        }

        this.inhalt = inhalt; 
        this.inhaltName = inhalt.getClass().getName();
    }
    
    public void setInhalt(T inhalt) {

    }

    public boolean isVoll() {
        return this.inhalt != null;
    }

    public void leeren() { 
        this.inhalt = null;
    }
  
    @Override 
    public String toString(){
        if (inhalt == null) {
            return "Leere Flasche von " + this.inhaltName;
        }

        return "Flasche Inhalt: " + this.inhalt.toString();
    }
}
