
/**
* Die Klasse Validierung ist eine Werkzeugklasse fuer die Patienten-, Patientenwarteschange- und PatientenwarteschangeDialogklassen
*
* @author Girndt & Krier
* @version 1.0
*/
public final class Validierung {

    private static final int            MINDESTPATIENTENNUMMER                      = 1000;
    private static final int            HOECHSTPATIENTENNUMMER                      = 9999;
    private static final int            MINDESTWARTESCHLANGEGROESSE                 =    1;
    private static final int            HOESCHSTWARTESCHLANGEGROESSE                 =    10;

    private static final String         ERROR_UNGUELTIGE_PATIENTENNUMMER            = "Ungueltige Patientennummer. Die Patientennummer muss zwischen 1 und 9999 sein.";
    private static final String         ERROR_NULLREFERENZSTRING            = "der zu validierende String zeigt auf Nullreferenz";
    private static final String         ERROR_UNGUELTIGER_NAME            = "Vor- und Nachnamen duerfen nur alphabetische Charaktere enthalten";
    private static final String         ERROR_UNGUELTIGE_WARTESCHLANGEGROESSE            = "Warteschlangegroesse muss zwischen 1 und 10 sein";
    
    
    /**
    * Die Werkzeugklasse soll statisch sein bzw. darf nicht instantiert werden
    */
    private Validierung() {}

    /**
    * Die Methode validiert, ob der Name eingegeben wurde und nur aus alphabetischen Charakteren besteht.
    * @param name ist die zu validierende Groesse
    */
    public static void validiereName(String name) {

        if (name == null) {
            throw new IllegalArgumentException(ERROR_NULLREFERENZSTRING);
        }
        
        if (!Validierung.checkeObNurAlphabetischeCharaktere(name)) {
            throw new IllegalArgumentException(ERROR_UNGUELTIGER_NAME);
        }

    }

    /**
    * Die Methode prueft ob der eingegebene String nur alphabestische Charaktere enthaelt
    * leere Strings werden nicht akzeptiert
    * @param string ist der zu ueberpruefende String
    * @return ist das Ergebnis: true (nur alphabestische Charaktere) oder false (enthaelt auch andere Charaktere)
    */
    private static boolean checkeObNurAlphabetischeCharaktere(String string) {

        if (string == null) {
            throw new IllegalArgumentException(ERROR_NULLREFERENZSTRING);
        }

        string = string.replaceAll("\\s+","");

        String regex = "^[a-zA-Z\\-äöüÄÖÜßa]+$";
        
        boolean hatNurAlphabetischeCharaktere = string.matches(regex);

        return hatNurAlphabetischeCharaktere;
    }

    /**
    * Die Methode prueft ob der Patientennummer groeßer als 0 ist, falls nicht gibt es eine Exception
    * @param patientenNummer ist die Patientennummer
    */
    public static void validierePatientenNummer(int patientenNummer) {
        if (patientenNummer < MINDESTPATIENTENNUMMER || patientenNummer > HOECHSTPATIENTENNUMMER) {
            throw new IllegalArgumentException(ERROR_UNGUELTIGE_PATIENTENNUMMER);
        }
    }

    /**
    * Die Methode validiert, ob die Warteschlangegroesse sich zwischen den Midenst- und Hoechstgroessen befindet.
    * @param groesse ist die zu validierende Groesse
    */
    public static void validiereWarteschlangegroesse(int groesse){
        if (groesse < MINDESTWARTESCHLANGEGROESSE || groesse > HOESCHSTWARTESCHLANGEGROESSE){
            throw new IllegalArgumentException(ERROR_UNGUELTIGE_WARTESCHLANGEGROESSE);
        }
    }
}
