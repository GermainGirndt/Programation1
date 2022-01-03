/**
 * Ein Patient, der auf seine Behandlung wartet
 * 
 * @author Girndt, Germain & Krier, Katharina  
 * @version 1.0
 */
public class Patient {

    /** die Patientennummer */
    private int nummer;
    
    /** Der Patientenvorname */
    private String vorname;
    
    /** Der Patientenachname */
    private String nachname;

    public Patient(int nummer, String vorname, String nachname) {
        Validierung.validierePatientenNummer(nummer);
        Validierung.validiereName(vorname);
        Validierung.validiereName(nachname);
        
        this.nummer = nummer;

        this.vorname = vorname;

        this.nachname = nachname;
    }

    public int getNummer() {
        return this.nummer;
    }

    public String getVorname() {
        return this.vorname;
    }

    public String getNachname() {
        return this.nachname;
    }
    
    public String getVollname() {
        return String.format("%s %s",this.getVorname(), this.getNachname());
    }

    public String toString() {

        return String.format("%s, %s", this.getNummer(), this.getVollname());
    }
    
}
