
/**
 * Beschreiben Sie hier die Klasse Person.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Person
{
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
