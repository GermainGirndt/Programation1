/**
 * Überprüft mittels Rekursion, ob zwei Wörter Palindrome sind.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class PalindromRekursiv extends AbstractPalindrom {
    
    /**
    * Konstruktor für Objekte der Klasse AbstractPalindrom
    */
    public PalindromRekursiv() {}

    public PalindromRekursiv(String[] eingabeString) {
        super(eingabeString);
    }

    /**
     * Konstruktor für Objekte der Klasse AbstractPalindrom
     */
    public PalindromRekursiv(String mode, String[] eingabeStrings) {
        super(mode, eingabeStrings);
    }
    
        @Override 
    public boolean istPalindrom(String string) {

        PalindromRekursiv palindrom = new PalindromRekursiv(new String[] { string });
        
        return palindrom.pruefePalindrom();
    }

    @Override 
    public boolean[] sindPalindrome(String[] strings) {

        PalindromRekursiv palindrom = new PalindromRekursiv(strings);
        
        return palindrom.pruefePalindrome();
    }


    protected boolean pruefe(String string) {

        return pruefeRekursiv(string);
    }
    
    private boolean pruefeRekursiv(String string) {

        string = string.toLowerCase();

        String u;
        
        if (string.charAt(0) == string.charAt(string.length() -1)) {
             if (string.length() <= 2) {
                 return true;
             }
             u = string.substring(1, string.length() -1);
             return pruefeRekursiv(u);    
        } else {
            return false;
        }    
    }
    
    @Override
    public String toString() {
        return "PalindromRekursiv";
    }
}
