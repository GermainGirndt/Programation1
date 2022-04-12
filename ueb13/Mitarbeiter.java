
/**
 * Beschreiben Sie hier die Klasse Mitarbeiter.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Mitarbeiter extends Person
{
    private String email;

    /**
     * Konstruktor für Objekte der Klasse Mitarbeiter
     * @param vorname ist der Vorname der Person, darf nicht leer sein
     * @param nachname ist der Nachname der Person, darf nicht leer sein
     * @param email ist die email-Adresse der person, darf nicht leer sein und muss ein @ enthalten
     */
    public Mitarbeiter(String vorname, String nachname, String email)
    {
        super(vorname, nachname);
        
        if(email == null || email.trim().isEmpty()){
            throw new IllegalArgumentException("Die Email darf nicht leer sein");
        }
        if(!email.matches("^\\S+@\\S+$")){
             throw new IllegalArgumentException("Das ist keine valide email-Adresse");  
        }
        this.email = email;
    }

    @Override
    public String toString(){
        return  super.toString() 
               + " (" + email + ")";
   }
}
