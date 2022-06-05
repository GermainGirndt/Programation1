
/**
 * Beschreiben Sie hier die Klasse Getraenk.
 * 
 * @author Girndt, Krier
 * @version 1.0
 */
public abstract class Getraenk
{
    private String bezeichnung;

    /**
     * Konstruktor für Objekte der Klasse Getraenk
     */
    public Getraenk() {}
    
    /**
     * Konstruktor für Objekte der Klasse Getraenk
     */
    public Getraenk(String bezeichnung)
    {
        this.setBezeichnung(bezeichnung);
    }
    
    public void setBezeichnung(String bezeichnung) {
        this.validiereGetraenkeProperty(bezeichnung, "Bezeichnung");
        this.bezeichnung = bezeichnung;    
         
    }
    
    public String getBezeichnung() {
        return this.bezeichnung;
    }
    
    protected void validiereGetraenkeProperty( String string, String variableName) {
        if (string == null || string.trim().equals("")) {
            throw new IllegalArgumentException(variableName + " darf nicht null sein");
        }
    }

    @Override
    public String toString() {
        if (!this.istVollkommen()) {
            throw new IllegalArgumentException("Getraenke mit fehlenden Informationen kann nicht ausgegeben werden");
        }
        
        return "Bezeichnung: " + this.bezeichnung;
    }

    public boolean istVollkommen() {
        return this.bezeichnung != null;
    }
}
