
/**
 * Beschreiben Sie hier die Klasse Wasser.
 * 
 * @author Girndt, Germain; Krier, Katharina 
 * @version 1.0
 */
public class Wasser extends AlkoholfreiesGetraenk
{
    private String quelle;

    /**
     * Konstruktor für Objekte der Klasse Wasser
     */
    public Wasser() {}
    
    /**
     * Konstruktor für Objekte der Klasse Wasser
     */
    public Wasser(String bezeichnung, String hersteller, String quelle)
    {
        super(bezeichnung, hersteller);
        this.setQuelle(quelle);
        
    }
  
    public void setQuelle(String quelle) {
        if (quelle == null) {
            throw new IllegalArgumentException("Quelle darf nicht leer sein.");
        }
        this.quelle = quelle;
    }
    
    public String getQuelle() {
        return this.quelle;
    }
    
    @Override
    public String toString() {
        if (!this.istVollkommen()) {
            throw new IllegalArgumentException("Getraenke mit fehlenden Informationen kann nicht ausgegeben werden");
        }
        
        return super.toString() + " Quelle: " + quelle;
    }

    @Override
    public boolean istVollkommen() {
        return super.istVollkommen() && this.quelle != null;
    }
}
