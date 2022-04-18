import java.lang.StringBuilder;

/**
 * Die Klasse Patientenwarteschlange nimmt Patienten auf und steuert die Warteschlange.
 * 
 * @author Girndt, Germain & Krier, Katharina  
 * @version 1.0
 * 
 */
public class Patientenwarteschlange
{
   private Patient[] patientenwarteschlange;
   private int anzahlPatienten                                                        =  0;
   private int INDEX_PATIENT_NOT_FOUND                                                = -1;

   public static final String ERROR_PATIENTENWARTESCHLANGE_IST_LEER                             =  "Behl konnte nicht ausgefuehrt werden, denn die Warteschlange ist leer.";
   public static final String ERROR_ZU_ENTFERNENDER_PATIENT_IST_NICHT_IN_DER_WARTESCHLANGE   =  "Nur Patienten in der Warteschlange koennen entfernt werden.";
   public static final String ERROR_WARTESCHLANGE_IST_VOLL                                 =  "Der Patienten passt nicht in der Warteschlange. Entferne einen Patienten, um einen neuen anzulegen.";
   public static final String ERROR_NULL_PATIENTEN                                         =  "Der Patienten ist null";
   public static final String ERROR_WIEDERHOLTE_PATIENTENNUMMER                       =  "Die eingegebene Patientennummer ist bereits in der Warteschlange!";
   
   public static final String STRING_OUTPUT_LEERE_WARTESCHLANGE = "Die Warteschlange ist leer.";
   public static final String STRING_OUTPUT_KOPFZEILE = "Warteliste\nPatientennummer\tVorname\tNachname\n";
   public static final String STRING_OUTPUTMUSTER_PATIENT = "%s\t%s\t%s\n";

   /**
   * Konstruktor fuer Patientenwarteschlange mit Auskunft ueber die Warteschlangegroesse
   * @param warteschlangegroesse ist die hoechste Anzahl an verfuegbaren Plaetzen in der Patientenwarteschlange
   */
   public Patientenwarteschlange(int warteschlangegroesse) {
       Validierung.validiereWarteschlangegroesse(warteschlangegroesse);
       this.patientenwarteschlange = new Patient[warteschlangegroesse];   
    }

    /**
    * Stellt einen Patienten in die Warteschlange
    * @param nummer die Patientennummer
    * @param vorname die Patientenvorname
    * @param nachname die Patientennachname
    */
    public void neuerPatient(int nummer, String vorname, String nachname) {

        if (!this.istPatientenwarteschlangeLeer()) {
            if (!this.istWarteschlangeVoll()) {
                throw new IllegalArgumentException(ERROR_WARTESCHLANGE_IST_VOLL);
             }
     
             if (this.getPatientenIndexNachNummer(nummer) != INDEX_PATIENT_NOT_FOUND) {
                 throw new IllegalArgumentException(ERROR_WIEDERHOLTE_PATIENTENNUMMER);
             }
        }

        Patient neuerPatient = new Patient(nummer, vorname, nachname);

        this.patientenwarteschlange[anzahlPatienten] = neuerPatient;
        this.anzahlPatienten++;
        
    }
    
    /**
    * Entfernt einen Patienten ueber seine Nummer
    * @param patientenNummer von dem zu entfernenden Patient
    */
    public Patient entfernePatient(int patientenNummer) {
        if (this.istPatientenwarteschlangeLeer()) {
            throw new IllegalArgumentException(ERROR_PATIENTENWARTESCHLANGE_IST_LEER);
        }
        
        int patientIndex = this.getPatientenIndexNachNummer(patientenNummer);
        
        if (patientIndex == INDEX_PATIENT_NOT_FOUND) { 
            throw new IllegalArgumentException(ERROR_ZU_ENTFERNENDER_PATIENT_IST_NICHT_IN_DER_WARTESCHLANGE);
        }

        Patient patient = this.patientenwarteschlange[patientIndex];
        
        loeschePatientenNachIndex(patientIndex);

        return patient;
    }

    /**
    * Ruft den naechsten Patienten auf und entfernt ihn von der Warteschlange
    */
    public Patient derNaechsteBitte() {
        if (this.istPatientenwarteschlangeLeer()) {
            throw new IllegalArgumentException(ERROR_PATIENTENWARTESCHLANGE_IST_LEER);
        }
        
        Patient naechsterPatient = this.patientenwarteschlange[0];
        loeschePatientenNachIndex(0);
        
        return naechsterPatient;
    }
    
    /**
    * Die Methode checkt, ob ein neuer Patient angelegt werden kann
    * dh. ob das Lager ueber genuegenden Platz verfuegt
    * @return true, wenn ja; false, wenn nein
    */
    private boolean istWarteschlangeVoll() {
        return this.anzahlPatienten <= this.patientenwarteschlange.length;
    }
    
    /**
     * Die Methode checkt, ob das Lager leer ist
     * dh. kein Patient da ist
     * @return true, wenn ja; false, wenn nein
    */
    private boolean istPatientenwarteschlangeLeer() {
        return this.anzahlPatienten == 0;
    }

    /**
    * Die Methode setzt die gewuenschte Indexstelle als Null
    * und verschiebt jeden Wert danach eine Stelle nach hinten, 
    * sodass es keine Luecke im Array gibt
    * @param indexZuLoeschen ist der Arrayindex, der entfernt werden soll
    */
    private void loeschePatientenNachIndex(int indexZuLoeschen) {
        
        if (indexZuLoeschen < 0) {
            throw new IllegalArgumentException("Der gewaehlte Index muss positiv sein.");
        }

        if (indexZuLoeschen >= this.anzahlPatienten) {
            throw new IllegalArgumentException("Der gewaehlte Index uebertrifft die Anzahl an Patientn.");
        }
        
        
        for (int neuerIndex = indexZuLoeschen; neuerIndex < this.anzahlPatienten; neuerIndex++) {
            int indexZuVerschieben = neuerIndex + 1;
            patientenwarteschlange[neuerIndex] = patientenwarteschlange[indexZuVerschieben];
        }
        
        patientenwarteschlange[this.anzahlPatienten] = null;
        this.anzahlPatienten--;
    }

    /**
    * Die Methode gibt den Index der gewunschten Patientennummer zurueck 
    * @param patientenNummer ist die Patientennummer vom gewuenschten Patient
    * @return der Index des Patients in der Warteschlange oder INDEX_PATIENT_NOT_FOUND, falls dieser Patient nicht in der Warteschlange ist
    */    
    public int getPatientenIndexNachNummer(int patientenNummer) {

        for (int index = 0; index < this.anzahlPatienten; index++) {
            Patient patientZuChecken = this.patientenwarteschlange[index];

            if (patientZuChecken == null) {
                break;
            }

            if (patientZuChecken.getNummer() == patientenNummer) {
                return index;
            }
        }    
        
        return INDEX_PATIENT_NOT_FOUND;
    }

    /**
    * Die Methode gibt das Objekt aufbereitet als String zurueck
    * @return gibt die Attribute des Patients als String zurueck
    */
    public String toString() {

        if (this.istPatientenwarteschlangeLeer()) {
            return STRING_OUTPUT_LEERE_WARTESCHLANGE;
        }
        
        StringBuilder builder = new StringBuilder(STRING_OUTPUT_KOPFZEILE);
        
        for (Patient patient: this.patientenwarteschlange) {

            if (patient == null) {
                break;
            }

            builder.append(String.format(STRING_OUTPUTMUSTER_PATIENT, patient.getNummer(), patient.getVorname(), patient.getNachname()));
        }    
        
        return builder.toString();
   }

    /**
    * Die Methode gibt die Anzahl an Patient im Lager zurueck 
    * @return die Anzahl an Patient im Lager
    */ 
    public int getPatientAnzahl() {
      return this.anzahlPatienten;
    }
    
    /**
    * Die Methode gibt die Gesamtanzahl an verfuegbaren Platzen im Lager zurueck 
    * @return die Gesamtanzahl an verfuegbaren Platzen im Lager
    */ 
    public int getLagerGroesse() {
        return this.patientenwarteschlange.length;
    }
}
