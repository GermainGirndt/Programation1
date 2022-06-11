
/**
 * Beschreiben Sie hier die Klasse Bier.
 * 
 * @author Girndt, Germain; Krier, Katharina 
 * @version 1.0
 */
public class Bier extends AlkoholischesGetraenk
{
    private String brauerei;

    /**
     * Konstruktor für Objekte der Klasse Bier
     */
    public Bier() {}
    
    /**
     * Konstruktor für Objekte der Klasse Bier
     */
    public Bier(String bezeichnung, float alkoholgehalt, String brauerei)
    {
        super(bezeichnung, alkoholgehalt);
        this.setBrauerei(brauerei);
    }
    
    public void setBrauerei(String brauerei) {
        this.validiereGetraenkeProperty(brauerei, "Brauerrei");
        this.brauerei = brauerei;
    }

    public String getBrauerei() {
        return this.brauerei;
    }
    
    @Override
    public String toString() {
        if (!this.istVollkommen()) {
            throw new IllegalArgumentException("Getraenke mit fehlenden Informationen kann nicht ausgegeben werden");
        }

        return super.toString() + " Brauerei: " + this.brauerei;
    }

    @Override
    public boolean istVollkommen() {
        return super.istVollkommen() && this.brauerei != null;
    }
}
