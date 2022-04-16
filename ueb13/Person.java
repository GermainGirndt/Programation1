
/**
 * Beschreiben Sie hier die Klasse Person.
 * Die Klasse Person soll einen Menschen mit Vor- und Nachname abbilden
 * 
 * @author Girndt & Krier 
 * @version 1.0
 */
public class Person
{
    private String vorname;
    private String nachname;

    private static final String FEHLER_VORNAME_LEER  = "Der Vorname darf nicht leer sein";
    private static final String FEHLER_NACHNAME_LEER = "Der Nachname darf nicht leer sein";
    /**
     * Konstruktor für Objekte der Klasse Person
     * @param vorname ist der Vorname der Person, darf nicht leer sein
     * @param nachname ist der Nachname der Person, darf nicht leer sein
     */
    public Person(String vorname, String nachname)
    {
        if(vorname == null || vorname.trim().isEmpty()){
            throw new IllegalArgumentException(FEHLER_VORNAME_LEER);
        }
        if(nachname == null || nachname.trim().isEmpty()){
            throw new IllegalArgumentException(FEHLER_NACHNAME_LEER);
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
