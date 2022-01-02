
/**
 * Beschreiben Sie hier die Klasse Patient.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Patient
{
    private int nummer;
    private String vorname;
    private String nachname;
    
    private static final int INITIALNUMBER    = 1;
    private static final String INITIALTEXT   = "INITIAL";

    
    /**
     * Konstruktor für Objekte der Klasse Patient
     */
    public Patient(int nummer, String vorname, String nachname)
    {
         Validierung.validiereNummer(nummer);
         Validierung.validiereName(vorname);
         Validierung.validiereName(nachname);
         
         this.nummer   = nummer;
         this.vorname  = vorname;
         this.nachname = nachname;
    }
    
    public Patient()
    {
         this.nummer   = INITIALNUMBER;
         this.vorname  = INITIALTEXT;
         this.nachname = INITIALTEXT;
    }

    public String toString(){
        return   this.nummer+  ", " +
                 this.vorname+ ", " +
                 this.nachname;
    }
    
    public int getNummer(){
        return nummer;
    }
    
    public String getVorname(){
        return vorname;
    }
    
    public String getNachname(){
        return nachname;
    }
}
