 

public class Validierung {
        /**
    * Die Methode prüft ob die Menge fürs Buchen positiv ist, falls nicht gibt es eine Exception
    * @param menge ist die Menge 
    */
    public static void validiereMenge(int menge) {
        if (menge <= 0) {
            throw new IllegalArgumentException("Die Menge muss eine natürliche positive Zahl sein");
        }
    }

    /**
    * Die Methode prüft, ob die Menge positiv und kleiner als der Bestand ist, falls nicht gibt es eine Exception
    * @param menge ist die Menge 
    */
    public static void validiereAbgangsMenge(int bestand, int menge) {
        validiereMenge(menge);
        
        if (bestand < menge) {
            throw new IllegalArgumentException("Die abgebuchte Menge darf nicht groesser als der Bestand sein");
        }
    }

    /**
    * Die Methode prüft ob die Artikelart nicht leer ist, falls doch gibt es eine Exception
    * @param art ist die ArtikelArt
    */
    public static void validiereArtikelArt(String art) {
        boolean sollLeertasteErlauben = true;

        if (checkeFuerNurLeertasten(art)) {
            throw new IllegalArgumentException("Artikelart darf nicht leer sein");
        }

        if (checkeFuerSpezielleCharaktere(art, sollLeertasteErlauben)) {
            throw new IllegalArgumentException("Artikelart darf keine speziellen Charakteren außer Leertaste enthalten");
        }
    }

    private static boolean checkeFuerNurLeertasten(String string) {
        String stringOhneLeertasten = string.strip();

        boolean istLeer = stringOhneLeertasten.isEmpty();

        return istLeer;
    }

    private static boolean checkeFuerSpezielleCharaktere(String string, boolean sollLeertasteErlauben) {

        if (sollLeertasteErlauben) {
            string = string.replaceAll("\\s+","");
        } 

        String regex = "^[a-zA-ZäöüÄÖÜßa]+$";
        
        boolean hasSpezielleCharaktere = !string.matches(regex);

        return hasSpezielleCharaktere;
    }

    /**
    * Die Methode prüft ob der Artikelnummer größer als 0 ist, falls nicht gibt es eine Exception
    * @param artikelNr ist die Artikelnummer
    */
    public static void validiereArtikelNr(int artikelNr) {
        if (artikelNr <= 0) {
            throw new IllegalArgumentException("Ungültige Artikelnummer");
        }
    }

    /**
    * Die Methode prüft ob der Bestand größer als 0 ist, falls nicht gibt es eine Exception
    * @param bestand ist der Bestand
    */
    public static void validiereBestand(int bestand) {
        if (bestand < 0) {
            throw new IllegalArgumentException("Bestand darf nicht negativ sein");
        }
    }
    
}
