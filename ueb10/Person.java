
/**
 * Eine Person
 * 
 * @author Germain, Girndt; Krier, Katharina
 * @version 1.0
 * 
 */
public class Person {
    private String vorname;
    private String nachname;
    
    private final String VORNAME = "Vorname";
    private final String NACHNAME = "Nachname";

    /**
    * Konstruktor Person
    * @param vorname, der Vorname
    * @param nachname, der Nachname
    */
    public Person(String vorname, String nachname){
        this.vorname  = vorname;
        this.nachname = nachname;
    }
    
    public String getVorname(){
        return this.vorname;
    }
    
    public String getNachname(){
        return this.nachname;
    }
    
    public void setVorname(String vorname){
        Validierungsutils.validiereNamenString(vorname, VORNAME);
        this.vorname = vorname;
    }
    
    public void setNachname(String nachname){
        Validierungsutils.validiereNamenString(vorname, NACHNAME);
        this.nachname = nachname;
    }
    
    @Override
    public String toString(){
        return getVorname() + ", " + getNachname();
    }
}
