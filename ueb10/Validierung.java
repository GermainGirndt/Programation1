 

/**
* Die Klasse Validierung ist eine Werkzeugklasse fuer Person und Queue Implementierung
*
* @author Girndt & Krier
* @version 1.0
*/
public final class Validierung {

    private final static String FEHLER_KEINE_NATUERLICHE_ZAHL = "Die Zahl muss groesser gleich null sein. Eingegebene Zahl: %s.";
    private final static String FEHLER_ATTRIBUTE_NAME_IST_LEER = " darf nicht leer sein.";
    private final static String FEHLER_ATTRIBUTE_NAME_IST_NULL = " darf nicht null sein.";
    private final static String FEHLER_ATTRIBUTE_ENTHAELT_SPEZIELLE_CHARAKTERE = " darf keine speziellen Charakteren außer Leertaste enthalten.";
    
    private final static String REGEX_NUR_ALPHABETISCHE_CHARAKTERE = "^[a-zA-ZäoeueÄoeueßa-]+$";
    private final static String REGEX_LEERZEICHEN = "^\\s+$";
    /**
    * Die Werkzeugklasse soll statisch sein bzw. darf nicht instantiert werden
    */
    private Validierung() {}
    
    /**
    * Die Methode prueft ob die PersonName nicht leer ist, falls doch wirft sie eine Exception
    * @param personName ist die PersonName
    */
    public static void validiereNamenString(String personName, String attributeName) {
        boolean sollLeertasteErlauben = false;

        if (personName == null) {
            throw new IllegalArgumentException(attributeName + FEHLER_ATTRIBUTE_NAME_IST_NULL);
        }

        if (Validierung.checkeFuerNurLeertasten(personName)) {
            throw new IllegalArgumentException(attributeName + FEHLER_ATTRIBUTE_NAME_IST_LEER);
        }

        if (!Validierung.checkeFuerNurCharaktereVonNamen(personName, sollLeertasteErlauben)) {
            throw new IllegalArgumentException(attributeName + FEHLER_ATTRIBUTE_ENTHAELT_SPEZIELLE_CHARAKTERE);
        }
    }

    /**
    * Die Methode prueft ob der String ist Leer oder ob der nur Leertasten enthält
    * @param string ist der zu ueberpruefende String
    * @return ist das Ergebnis: true (enthält nur Leertasten/nichts) oder false (enthält auch andere Charaktere)
    */
    private static boolean checkeFuerNurLeertasten(String string) {
        String stringOhneLeertasten = string.strip();

        boolean istLeer = stringOhneLeertasten.isEmpty();

        return istLeer;
    }

    /**
    * Die Methode prueft ob der eingegebene String nur alphabestische Zeichen enthält
    * @param string ist der zu ueberpruefende String
    * @param sollLeertasteErlauben steuert, ob Leertasten auch erlaubt werden sollen
    * @return ist das Ergebnis: true (nur alphabestische Zeichen) oder false (enthält auch andere Charaktere)
    */
    private static boolean checkeFuerNurCharaktereVonNamen(String string, boolean sollLeertasteErlauben) {

        if (sollLeertasteErlauben) {
            string = string.replaceAll(REGEX_LEERZEICHEN, "");
        } 

        String regex = REGEX_NUR_ALPHABETISCHE_CHARAKTERE;
        
        boolean hatNurAlphabetischeCharaktere = string.matches(regex);

        return hatNurAlphabetischeCharaktere;
    }

    /**
    * Die Methode prueft, ob die eigegebene Zahl Element der Menge der natuerlichen Zahl ist.
    * @param zuCheckendeZahl die ueberprueft werden soll
    * @return true fuer ja; false fuer nein
    */    
    public static void validiereNatuerlicheZahl(int zuCheckendeZahl, boolean erlaubeNull) {
        int grenze = 0;

        if (zuCheckendeZahl < grenze) {
            throw new IllegalArgumentException(String.format(FEHLER_KEINE_NATUERLICHE_ZAHL, zuCheckendeZahl));
        }
    }
}
