
/**
 * Überprüft mittels Iteraktion, ob zwei Wörter Palindrome sind.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class PalindromIterativ implements Palindrom
{
   
    /**
     * Konstruktor für Objekte der Klasse PalindromIterativ
     */
    public PalindromIterativ() {}

    @Override 
    public boolean istPalindrom(String string) {

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
    public boolean[] sindPalindrome(String[] string) {
        return new boolean[] { true };
    }
 
    
    @Override
    public void start(String[] args){
        
    }
}
