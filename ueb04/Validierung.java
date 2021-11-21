/**
 * Die Klasse Validierung prueft die Parameter, die den Funktionen der Klasse MathFunctions uebergeben wird
 * 
 * @author Girndt & Krier 
 * @version 1.0
 */

public class Validierung {
    private static final byte  KLEINSTE_ISBN        = 0;
    private static final long  GROESSTE_ISBN        = 999999999;
    private static final int   ISBN_ZEICHEN_ANZAHL  = 9;

    /**
    * Der Konstruktor wurde als "private" geklariert, sodass
    * die Klasse nicht instantiiert werden kann.
    */
    private Validierung() {}
    
    /**
    * Die Methode prueft ob die Zahl, deren TeilerSumme gebildet wird, ob diese eine natürliche Zahl ist
    * @param zahlTeilersumme ist die Zahl die validiert wird
    */
    public static void validiereZahlTeilersumme(long zahlTeilersumme){
        if(!Validierung.checkeObNatuerlicheZahl(zahlTeilersumme)){
             throw new IllegalArgumentException("Teilersummen können nur für natürliche Zahlen gebildet werden");    
        }
    }
    
    /**
    * Die Methode prueft, ob die ISBN positiv ist und nicht zu viele Ziffern hat
    * @param isbn die ueberprueft werden soll
    */    
    public static void validiereIsbn(long isbn){
        if(isbn < KLEINSTE_ISBN ){
             throw new IllegalArgumentException("Die ISBN darf nicht negativ sein");      
        }
        else if(isbn > GROESSTE_ISBN) {
             throw new IllegalArgumentException("Die ISBN, deren Checksumme berechnet werden soll, darf nicht mehr als 9 Ziffern haben");               
            }
        }
        
        public static void validiereZeichenAnzahl(String string) {
            if (string.length() != ISBN_ZEICHEN_ANZAHL) {
                throw new IllegalArgumentException(String.format("Die ISBN muss genau %s Ziffern haben", ISBN_ZEICHEN_ANZAHL));
        } 
    }

    /**
    * Die Methode prueft, ob die Fakultaet von der eigegebenen Zahl mit 'long' berechnet werden kann.
    * @param zahl die ueberprueft werden soll
    * @param obereGrenze ist die Zahl in der oberen Grenze. Sie legt fest, bis welche Zahlen hat der Rechner genügenden Speicherplatz, um die Fakultaet zu berechnen.
    */    
    public static void validiereZahlZurFakultaetberechnung(int zahl, int obereGrenze){
        boolean sollNullErlaubtWerden = true;

        if (zahl > obereGrenze) {
            throw new IllegalArgumentException("Für die korrekte Fakultätbildung darf die Zahl nicht größer als " + obereGrenze + " sein");      
        }

        if(!Validierung.checkeObNatuerlicheZahl(zahl, sollNullErlaubtWerden)){
             throw new IllegalArgumentException("Für die Fakultätbildung muss die Zahl natürlich sein. Eingegebene Zahl: " + zahl);      
            }
        }
        
        
    /**
    * Die Methode prueft, ob der Index Element der natürlichen Zahlen ist
    * Wenn nicht, wird ein Fehler geworfen
    * @param zuCheckenderIndex ist der Index, der ueberprueft werden soll
    */    
    public static void validiereIndex(int zuCheckenderIndex) {
        if (!Validierung.checkeObNatuerlicheZahl(zuCheckenderIndex)) {
            throw new IllegalArgumentException("Der Indexzahl muss eine natürliche Zahl sein. Eingegebene Zahl: " + zuCheckenderIndex);      
        }
    }

    /**
    * Die Methode prueft, ob ein Double-Wert ein Divisor sein kann
    * Wenn nicht, wird ein Fehler geworfen
    * @param zuCheckenderDouble ist der Double-Wert, der ueberprueft werden soll
    */    
    public static void validiereDivisor(double zuCheckenderDouble) {
        if (zuCheckenderDouble == 0.0) {
            throw new ArithmeticException("Fehler! Man darf nicht durch Null dividieren");      
        }
    }

    /**
    * Die Methode prueft, ob die eigegebene Zahl Element der Menge der natürlichen Zahl ist.
    * @param zuCheckendeZahl die ueberprueft werden soll
    * @param sollNullErlaubtWerden muss true sein, wenn die Null erlaubt werden soll
    */
    private static boolean checkeObNatuerlicheZahl(long zuCheckendeZahl, boolean sollNullErlaubtWerden) {

        if (sollNullErlaubtWerden) {
            return zuCheckendeZahl >= 0;
        }

        return zuCheckendeZahl > 0;
    }

    /**
    * Die Methode prueft, ob die eigegebene Zahl Element der Menge der natürlichen Zahl ist.
    * @param zuCheckendeZahl die ueberprueft werden soll
    */    
    private static boolean checkeObNatuerlicheZahl(long zuCheckendeZahl) {
        return zuCheckendeZahl > 0;
    }
}
