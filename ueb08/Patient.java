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

  /**
   * Konstruktor fuer Patient
   * @param nummer die Patientennummer mit 4 Ziffern
   * @param vorname die Patientenvorname (nur alphabetische Charaktere)
   * @param nachname die Patientennachname (nur alphabetische Charaktere)
   */
    public Patient(int nummer, String vorname, String nachname) {
        Validierung.validierePatientenNummer(nummer);
        Validierung.validiereName(vorname);
        Validierung.validiereName(nachname);
        
        this.nummer = nummer;

        this.vorname = vorname;

        this.nachname = nachname;
    }

        
    /** Getter für Patientennummer */
    public int getNummer() {
        return this.nummer;
    }
    
    /** Getter für Patientenvornamen */
    public String getVorname() {
        return this.vorname;
    }
    
    /** Getter für Patientennachnamen */
    public String getNachname() {
        return this.nachname;
    }
    
    /** Getter für Patientenvor- und nachnamen */
    public String getVollname() {
        return String.format("%s %s",this.getVorname(), this.getNachname());
    }

    /** Gibt einen String mit den Patientenattributen zurueck mit dem Format
     * NUMMER, VORNAME NACHNAME
     */
    public String toString() {
        return String.format("%s, %s", this.getNummer(), this.getVollname());
    }
    
}
