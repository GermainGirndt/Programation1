 

/**
* Die Klasse Validierung ist eine Werkzeugklasse für die Artikel- und ArtikelDialogklassen
*
* @author Girndt & Krier
* @version 1.0
*/
public final class Validierung {

    private static final int ARTIKELMINDESTNUMMER = 1;
    private static final int BESTANDMINDESTNUMMER = 0;
    private static final int MINDESTMENGEANDERUNGSANZAHL = 0;

    /**
    * Die Werkzeugklasse soll statisch sein bzw. darf nicht instantiert werden
    */
    private Validierung() {}

    /**
    * Die Methode prüft ob die Menge fürs Buchen positiv ist, falls nicht, wirft sie eine Exception
    * @param menge ist die Menge 
    */
    public static void validiereMengeanderung(int mengeArtikelaenderung) {
        if (mengeArtikelaenderung <= MINDESTMENGEANDERUNGSANZAHL) {
            throw new IllegalArgumentException("Die Menge muss eine natürliche positive Zahl sein");
        }
    }

    /**
    * Die Methode prüft, ob die Menge positiv und kleiner als der Bestand ist, falls nicht wirft sie eine Exception
    * @param mengeArtikelabgang ist die Menge 
    */
    public static void validiereAbgangsMenge(int bestand, int mengeArtikelabgang) {
        validiereMengeanderung(mengeArtikelabgang);
        
        if (bestand < mengeArtikelabgang) {
            throw new IllegalArgumentException("Die abgebuchte Menge darf nicht groesser als der Bestand sein");
        }
    }

    /**
    * Die Methode prüft ob die Artikelart nicht leer ist, falls doch wirft sie eine Exception
    * @param art ist die ArtikelArt
    */
    public static void validiereArtikelArt(String art) {
        boolean sollLeertasteErlauben = true;

        if (checkeFuerNurLeertasten(art)) {
            throw new IllegalArgumentException("Artikelart darf nicht leer sein");
        }

        if (!checkeFuerNurAlphabetischeCharaktere(art, sollLeertasteErlauben)) {
            throw new IllegalArgumentException("Artikelart darf keine speziellen Charakteren außer Leertaste enthalten");
        }
    }

    /**
    * Die Methode prüft ob der String ist Leer oder ob der nur Leertasten enthält
    * @param string ist der zu überprüfende String
    * @return ist das Ergebnis: true (enthält nur Leertasten/nichts) oder false (enthält auch andere Charaktere)
    */
    private static boolean checkeFuerNurLeertasten(String string) {
        String stringOhneLeertasten = string.strip();

        boolean istLeer = stringOhneLeertasten.isEmpty();

        return istLeer;
    }

    /**
    * Die Methode prüft ob der eingegebene String nur alphabestische Zeichen enthält
    * @param string ist der zu überprüfende String
    * @param sollLeertasteErlauben steuert, ob Leertasten auch erlaubt werden sollen
    * @return ist das Ergebnis: true (nur alphabestische Zeichen) oder false (enthält auch andere Charaktere)
    */
    private static boolean checkeFuerNurAlphabetischeCharaktere(String string, boolean sollLeertasteErlauben) {

        if (sollLeertasteErlauben) {
            string = string.replaceAll("\\s+","");
        } 

        String regex = "^[a-zA-ZäöüÄÖÜßa]+$";
        
        boolean hatNurAlphabetischeCharaktere = string.matches(regex);

        return hatNurAlphabetischeCharaktere;
    }

    /**
    * Die Methode prüft ob der Artikelnummer größer als 0 ist, falls nicht gibt es eine Exception
    * @param artikelNr ist die Artikelnummer
    */
    public static void validiereArtikelNr(int artikelNr) {
        if (artikelNr < ARTIKELMINDESTNUMMER) {
            throw new IllegalArgumentException("Ungültige Artikelnummer");
        }
    }

    /**
    * Die Methode prüft ob der Bestand größer als 0 ist, falls nicht gibt es eine Exception
    * @param bestand ist der Bestand
    */
    public static void validiereBestand(int bestand) {
        if (bestand < BESTANDMINDESTNUMMER) {
            throw new IllegalArgumentException("Bestand darf nicht negativ sein");
        }
    }
    
}
