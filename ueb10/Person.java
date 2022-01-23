
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
        this.vorname = vorname;
    }
    
    public void setNachname(String nachname){
        this.nachname = nachname;
    }
}
