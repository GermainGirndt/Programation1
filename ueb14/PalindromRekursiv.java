/**
 * Überprüft mittels Rekursion, ob zwei Wörter Palindrome sind.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class PalindromRekursiv extends AbstractPalindrom implements Palindrom {

    
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
    
    public static void main(String[] args) {
        PalindromRekursiv instance = PalindromRekursiv.instantieerePalindrom(args);
        instance.start();
    }
    
    public static PalindromRekursiv instantieerePalindrom(String[] args) {
        if (args.length <= 1){
            throw new PalindromError("Geben Sie den Mode und die zu bewertenden Strings ein");            
        }

        String mode = args[PalindromRekursiv.getModeArgumentIndex()];
        String[] eingabeStrings = PalindromRekursiv.extrahireEingabeStrings(args);

        PalindromRekursiv instance = new PalindromRekursiv(mode, eingabeStrings);

        return instance;

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


    protected boolean pruefe(String string){

        return pruefeRekursiv(string);
    }
    
    private boolean pruefeRekursiv(String string){

        string = string.toLowerCase();

        String u;
        
        if (string.charAt(0) == string.charAt(string.length() -1)){
             if (string.length() <= 2){
                 return true;
             }
             u = string.substring(1, string.length() -1);
             return pruefeRekursiv(u);    
        } else {
            return false;
        }    
    }
}
