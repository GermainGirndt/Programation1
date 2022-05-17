
/**
 * Beschreiben Sie hier die Klasse Bier.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Bier extends AlkoholischesGetraenk
{
    private String brauerei;

    /**
     * Konstruktor für Objekte der Klasse Bier
     */
    public Bier()
    {
     
    }
    
    /**
     * Konstruktor für Objekte der Klasse Bier
     */
    public Bier(String bezeichnung, float alkoholgehalt, String brauerei)
    {
        super(bezeichnung, alkoholgehalt);
        this.brauerei = brauerei; 
    }
    
    public void setBrauerei(String brauerei){
        this.brauerei = brauerei;
    }

    public String getBrauerei(){
        return brauerei;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Brauerei: " + brauerei + "\n";
    }
}
