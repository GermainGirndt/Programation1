
/**
 * Beschreiben Sie hier die Klasse Person.
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
        Validierung.validiereAlphabetischenString(vorname, VORNAME);
        this.vorname = vorname;
    }
    
    public void setNachname(String nachname){
        Validierung.validiereAlphabetischenString(vorname, NACHNAME);
        this.nachname = nachname;
    }
}
