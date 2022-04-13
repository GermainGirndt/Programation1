
/**
 * Beschreiben Sie hier die Klasse Mitarbeiter.
 * Die Klasse Mitarbeiter erbt von Person, zusätzlich hat ein Mitarbeiter eine email Adresse
 * 
 * @author Girndt & Krier
 * @version 1.0
 */
public class Mitarbeiter extends Person
{
    private String email;
    
    private String emailRegex = "^\\S+@\\S+$";
    
    private static String FEHLER_EMAIL_LEER = "Die Email darf nicht leer sein";
    private static String FEHLER_KEINE_EMAIL = "Das ist keine valide email-Adresse";
    
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
            throw new IllegalArgumentException(FEHLER_EMAIL_LEER);
        }
        if(!email.matches(emailRegex)){
             throw new IllegalArgumentException(FEHLER_KEINE_EMAIL);  
        }
        this.email = email;
    }

    @Override
    public String toString(){
        return  super.toString() 
               + " (" + email + ")";
   }
}
