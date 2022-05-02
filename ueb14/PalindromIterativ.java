
/**
 * Überprüft mittels Iteraktion, ob zwei Wörter Palindrome sind.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class PalindromIterativ extends AbstractPalindrom implements Palindrom {

     /**
    * Konstruktor für Objekte der Klasse AbstractPalindrom
    */
    public PalindromIterativ() {
        super();
    }

    public PalindromIterativ(String[] eingabeString) {
        super(eingabeString);
    }

    /**
     * Konstruktor für Objekte der Klasse AbstractPalindrom
     */
    public PalindromIterativ(String mode, String[] eingabeStrings) {
        super(mode, eingabeStrings);
    }
    
    public static void main(String[] args) {
        PalindromIterativ instance = PalindromIterativ.instantieerePalindrom(args);
        instance.start();
    }
    
    public static PalindromIterativ instantieerePalindrom(String[] args) {
        if (args.length <= 1){
            throw new PalindromError("Geben Sie den Mode und die zu bewertenden Strings ein");            
        }

        String mode = args[PalindromIterativ.getModeArgumentIndex()];
        String[] eingabeStrings = PalindromIterativ.extrahireEingabeStrings(args);

        PalindromIterativ instance = new PalindromIterativ(mode, eingabeStrings);

        return instance;

    }

    @Override 
    public boolean istPalindrom(String string) {

        PalindromIterativ palindrom = new PalindromIterativ(new String[] { string });
        
        return palindrom.pruefePalindrom();
    }

    @Override 
    public boolean[] sindPalindrome(String[] strings) {

        PalindromIterativ palindrom = new PalindromIterativ(strings);
        
        return palindrom.pruefePalindrome();
    }


    protected boolean pruefe(String string){

        return pruefeIteraktiv(string);
    }
    
    private boolean pruefeIteraktiv(String string){

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
    public String toString(){
        return "PalindromIterativ";
    }

}
