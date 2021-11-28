 

/**
* Die Klasse Validierung ist eine Werkzeugklasse für die Artikel- und ArtikelDialogklassen
*
* @author Girndt & Krier
* @version 1.0
*/
public final class Validierung {

    private static final int            MINDESTARTIKELNUMMER                        = 1;
    private static final int            HOECHSTARTIKELNUMMER                        = 9999;
    private static final int            MINDESTBESTANDNUMMER                        = 0;
    private static final int            MINDEST_ANZAHL_AN_MENGEANDERUNG             = 0;
    private static final double         MINDESTPREIS                                = 0.0;
    private static final double         GROESSTE_NEGATIVE_PREISAENDERUNG            = -100.0;

    /**
    * Die Werkzeugklasse soll statisch sein bzw. darf nicht instantiert werden
    */
    private Validierung() {}

    /**
    * Die Methode prüft ob die Menge fürs Buchen positiv ist, falls nicht, wirft sie eine Exception
    * @param menge ist die Menge 
    */
    public static void validiereMengeanderung(int mengeArtikelaenderung) {
        if (mengeArtikelaenderung <= MINDEST_ANZAHL_AN_MENGEANDERUNG) {
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
        if (artikelNr < MINDESTARTIKELNUMMER || artikelNr > HOECHSTARTIKELNUMMER) {
            throw new IllegalArgumentException("Ungültige Artikelnummer. Die Artikelnummer muss zwischen 1 und 9999 sein.");
        }
    }

    /**
    * Die Methode prüft ob der Bestand größer als 0 ist, falls nicht gibt es eine Exception
    * @param bestand ist der Bestand
    */
    public static void validiereBestand(int bestand) {
        if (bestand < MINDESTBESTANDNUMMER) {
            throw new IllegalArgumentException("Bestand darf nicht negativ sein");
        }
    }
    
    

    /**
    * Die Methode prüft, ob der Preis gleich/größer der Mindestpreis ist, falls nicht, gibt es eine Exception
    * @param preis ist der zu überprüfende Preis
    */
    public static void validierePreis(double preis) {
        if (preis < MINDESTPREIS){
            throw new IllegalArgumentException("Preis darf nicht negativ sein");
        }
    }
    
    
    /**
    * Die Methode prüft, ob der Prozentsatz an Preisänderung die groesste negative Preisaenderung nicht uebersteigt, falls doch, gibt es eine Exception
    * @param preis ist der zu überprüfende Preis
    */
    public static void validierePreisaenderung(double prozent) {
        if (prozent < GROESSTE_NEGATIVE_PREISAENDERUNG) {
            throw new IllegalArgumentException("Negative Preisabweichung kann nicht groesser als -100% sein");

        }
    }
}
