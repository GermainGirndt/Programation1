
/**
 * Überprüft mittels Iteraktion, ob zwei Wörter Palindrome sind.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class PalindromIterativ extends AbstractPalindrom {

    /**
     * Konstruktor für Objekte der Klasse AbstractPalindrom
     */
    public PalindromIterativ(String mode, String[] eingabeStrings) {
        super(mode, eingabeStrings);
    }

    @Override 
    public boolean istPalindrom(String string) {

        return pruefeIteraktiv(string);
    }

    private boolean pruefeIteraktiv(String string) {

        if (string == null || string.trim().isEmpty()) {
            throw new PalindromError("String darf nicht leer sein");
        }
        String kleinerString = string.toLowerCase();

        int letzterIndex = kleinerString.length() -1;
        
        for (int i = 0; i <= letzterIndex / 2 ; i++) {
            char leftChar = kleinerString.charAt(i);
            char rightChar = kleinerString.charAt( letzterIndex - i);

            if (leftChar != rightChar) return false;
        }

        return true;
    }
    
    
    @Override
    public String toString() {
        return "PalindromIterativ";
    }

}
