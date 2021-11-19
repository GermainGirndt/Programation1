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
    */    
    public static void validiereZahlZurFakultaetberechnung(int zahl){
        if(!Validierung.checkeObNatuerlicheZahl(zahl)){
             throw new IllegalArgumentException("Für die Fakultätbildung muss die Zahl natürlich sein.");      
        }
    }

    /**
    * Die Methode prueft, ob die eigegebene Zahl Element der Menge der natürlichen Zahl ist.
    * @param zuCheckendeZahl die ueberprueft werden soll
    */    
    private static boolean checkeObNatuerlicheZahl(long zuCheckendeZahl) {
        return zuCheckendeZahl > 0;
    }
}
