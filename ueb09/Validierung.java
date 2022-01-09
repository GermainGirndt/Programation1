 

/**
* Die Klasse Validierung ist eine Werkzeugklasse fuer die Artikel- und ArtikelDialogklassen
*
* @author Girndt & Krier
* @version 1.0
*/
public final class Validierung {

    private static final int            MINDESTARTIKELNUMMER                        = 1000;
    private static final int            HOECHSTARTIKELNUMMER                        = 9999;
    private static final int            MINDESTBESTANDNUMMER                        =    0;
    private static final int            MINDEST_ANZAHL_AN_MENGEANDERUNG             =    0;
    private static final double         MINDESTPREIS                                =    0.0;
    private static final double         GROESSTE_NEGATIVE_PREISAENDERUNG            = -100.0;
    
    private static final String         FEHLERMELDUNGINTERPRETNULL                  = "Interpret darf nicht null sein";    
    private static final String         FEHLERMELDUNGINTERPRETLEER                  = "Interpret darf nicht leer sein";   
    private static final String         FEHLERMELDUNGTITELNULL                      = "Titel darf nicht null sein";   
    private static final String         FEHLERMELDUNGTITELLEER                      = "Titel darf nicht leer sein";   
    private static final String         FEHLERMELDUNGANZAHLTITEL                    = "Die Anzahl der Titel muss groesser als 0 sein";
    /**
    * Die Werkzeugklasse soll statisch sein bzw. darf nicht instantiert werden
    */
    private Validierung() {}


    
    public static void validiereInterpret(String interpret){
        if (interpret == null) {
            throw new IllegalArgumentException(FEHLERMELDUNGINTERPRETNULL);
        }

        if (checkeFuerNurLeertasten(interpret)) {
            throw new IllegalArgumentException(FEHLERMELDUNGINTERPRETLEER);
        }        
    }
    
    public static void validiereTitel(String titel){
        if (titel == null) {
            throw new IllegalArgumentException(FEHLERMELDUNGTITELNULL);
        }

        if (checkeFuerNurLeertasten(titel)) {
            throw new IllegalArgumentException(FEHLERMELDUNGTITELLEER);
        }        
    }
    
    public static void validiereAnzahlTitel(int anzahlTitel){
        if(anzahlTitel <= 0){
            throw new IllegalArgumentException( FEHLERMELDUNGANZAHLTITEL);    
        }
    }
    
    /**
    * Die Methode prueft ob die Menge fuers Buchen positiv ist, falls nicht, wirft sie eine Exception
    * @param menge ist die Menge 
    */
    public static void validiereMengeanderung(int mengeArtikelaenderung) {
        if (mengeArtikelaenderung <= MINDEST_ANZAHL_AN_MENGEANDERUNG) {
            throw new IllegalArgumentException("Die Menge muss eine natuerliche positive Zahl sein");
        }
    }

    /**
    * Die Methode prueft, ob die eigegebene Zahl Element der Menge der natuerlichen Zahl ist.
    * @param zuCheckendeZahl die ueberprueft werden soll
    * @return true fuer ja; false fuer nein
    */    
    public static boolean checkeObNatuerlicheZahl(long zuCheckendeZahl) {
        return zuCheckendeZahl > 0;
    }

    /**
    * Die Methode prueft, ob die eigegebene Zahl Element der Menge der natuerlichen Zahl ist.
    * @param zuCheckendeZahl die ueberprueft werden soll
    * @param istNullErlaubt bestimmt, ob die Zahl null akzeptiert werden soll
    * @return true fuer ja; false fuer nein
    */    
    public static boolean checkeObNatuerlicheZahl(long zuCheckendeZahl, boolean istNullErlaubt) {

        if (istNullErlaubt) {
            return zuCheckendeZahl >= 0;
        }
        
        return zuCheckendeZahl > 0;
    }

    /**
    * Die Methode prueft, ob die Menge positiv ist und den hoechsten Wert von dem Datentyp Long nicht uebersteigt.
    * Falls diese Bedingungen nicht eingehalten werden, wird eine eine Exception geworfen
    * @param mengeArtikelabgang ist die Menge 
    */
    public static void validiereZugangsmenge(long bestand, int mengeArtikelzugang) {
        validiereMengeanderung(mengeArtikelzugang);
        
        if (bestand + mengeArtikelzugang < 0) {
            throw new IllegalArgumentException("Der Bestand darf " + Long.MAX_VALUE + " Stueck nicht uebersteigen");
        }
    }


    /**
    * Die Methode prueft, ob die Menge positiv und kleiner als der Bestand ist, falls nicht wirft sie eine Exception
    * @param mengeArtikelabgang ist die Menge 
    */
    public static void validiereAbgangsmenge(long bestand, int mengeArtikelabgang) {
        validiereMengeanderung(mengeArtikelabgang);
        
        if (bestand < mengeArtikelabgang) {
            throw new IllegalArgumentException("Die abgebuchte Menge darf nicht groesser als der Bestand sein");
        }
    }

    /**
    * Die Methode prueft ob die Artikelart nicht leer ist, falls doch wirft sie eine Exception
    * @param art ist die ArtikelArt
    */
    public static void validiereArtikelArt(String art) {
        boolean sollLeertasteErlauben = true;

        if (art == null) {
            throw new IllegalArgumentException("Artikelart darf nicht null sein");
        }

        if (checkeFuerNurLeertasten(art)) {
            throw new IllegalArgumentException("Artikelart darf nicht leer sein");
        }

        if (!checkeFuerNurAlphabetischeCharaktere(art, sollLeertasteErlauben)) {
            throw new IllegalArgumentException("Artikelart darf keine speziellen Charakteren außer Leertaste enthalten. Erhalten: " + art);
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

        String regex = "^[a-zA-Z0-9\\-äoeueÄoeueßa]+$";
        
        boolean hatNurAlphabetischeCharaktere = string.matches(regex);

        return hatNurAlphabetischeCharaktere;
    }

    /**
    * Die Methode prueft ob der Artikelnummer groeßer als 0 ist, falls nicht gibt es eine Exception
    * @param artikelNr ist die Artikelnummer
    */
    public static void validiereArtikelNr(int artikelNr) {
        if (artikelNr < MINDESTARTIKELNUMMER || artikelNr > HOECHSTARTIKELNUMMER) {
            throw new IllegalArgumentException("Ungueltige Artikelnummer. Die Artikelnummer muss zwischen 1 und 9999 sein.");
        }
    }

    /**
    * Die Methode prueft ob der Bestand groeßer als 0 ist, falls nicht gibt es eine Exception
    * @param bestand ist der Bestand
    */
    public static void validiereBestand(int bestand) {
        if (bestand < MINDESTBESTANDNUMMER) {
            throw new IllegalArgumentException("Bestand darf nicht negativ sein");
        }
    }
    
    

    /**
    * Die Methode prueft, ob der Preis gleich/groeßer der Mindestpreis ist, falls nicht, gibt es eine Exception
    * @param preis ist der zu ueberpruefende Preis
    */
    public static void validierePreis(double preis) {
        if (preis < MINDESTPREIS){
            throw new IllegalArgumentException("Preis darf nicht negativ sein");
        }
    }
    
    
    /**
    * Die Methode prueft, ob der Prozentsatz an Preisaenderung die groesste negative Preisaenderung nicht uebersteigt, falls doch, gibt es eine Exception
    * @param preis ist der zu ueberpruefende Preis
    */
    public static void validierePreisaenderung(double prozent) {
        if (prozent < GROESSTE_NEGATIVE_PREISAENDERUNG) {
            throw new IllegalArgumentException("Negative Preisabweichung kann nur groesser als -100% sein");

        }
    }
    
    public static void validiereLagergroesse(int groesse){
        if(groesse < 1){
            throw new IllegalArgumentException("Lagergroessen die kleiner sind als 1 sind nicht erlaubt");
        }
    }
}
