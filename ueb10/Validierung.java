 

/**
* Die Klasse Validierung ist eine Werkzeugklasse fuer Person und Queue Implementierung
*
* @author Girndt & Krier
* @version 1.0
*/
public final class Validierung {

    /**
    * Die Werkzeugklasse soll statisch sein bzw. darf nicht instantiert werden
    */
    private Validierung() {}
    
    /**
    * Die Methode prueft ob die PersonName nicht leer ist, falls doch wirft sie eine Exception
    * @param personName ist die PersonName
    */
    public static void validiereAlphabetischenString(String personName, String attributeName) {
        boolean sollLeertasteErlauben = false;

        if (personName == null) {
            throw new IllegalArgumentException(attributeName + " darf nicht null sein");
        }

        if (checkeFuerNurLeertasten(personName)) {
            throw new IllegalArgumentException(attributeName + " darf nicht leer sein");
        }

        if (!checkeFuerNurAlphabetischeCharaktere(personName, sollLeertasteErlauben)) {
            throw new IllegalArgumentException(attributeName + " darf keine speziellen Charakteren außer Leertaste enthalten. Erhalten: " + art);
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
    private static boolean checkeFuerNurAlphabetischeCharaktere(String string, boolean sollLeertasteErlauben) {

        if (sollLeertasteErlauben) {
            string = string.replaceAll("\\s+","");
        } 

        String regex = "^[a-zA-Z0-9äoeueÄoeueßa-]+$";
        
        boolean hatNurAlphabetischeCharaktere = string.matches(regex);

        return hatNurAlphabetischeCharaktere;
    }
}
