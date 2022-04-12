
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

    /**
     * Konstruktor für Objekte der Klasse Person
     * @param vorname ist der Vorname der Person, darf nicht leer sein
     * @param nachname ist der Nachname der Person, darf nicht leer sein
     */
    public Person(String vorname, String nachname)
    {
        if(vorname == null || vorname.trim().isEmpty()){
            throw new IllegalArgumentException("Der Vorname darf nicht leer sein");
        }
        if(nachname == null || nachname.trim().isEmpty()){
            throw new IllegalArgumentException("Der Nachname darf nicht leer sein");
        }
        this.vorname  = vorname;
        this.nachname = nachname;
    }

    public String getVorname(){
        return vorname;
    }
    
    public String getNachname(){
        return nachname;
    }
    
    @Override
    public String toString(){
        return   vorname 
               + " " 
               + nachname;
                
    }

}
