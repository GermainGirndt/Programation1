import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
/**
 * Überprüft mittels Rekursion, ob zwei Wörter Palindrome sind.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class PalindromRekursiv implements Palindrom {
    private String textDateiRegex = "([a-zA-Z0-9\\s_\\.\\-\\(\\):])+(.txt)";
    private BufferedReader reader;

    private String eingabe;

    private EingabeTyp ausgewaehlterEingabeTyp;

    public enum EingabeTyp { 
        WORT(0),
        TEXT_DATEI(1);
    
        private int index;
    
        EingabeTyp(int index) {
            this.index = index;
        }
    
        public int getIndex() {
            return this.index;
        }
    
    };


    public static void main(String[] args) {
        PalindromRekursiv instance = new PalindromRekursiv();
        instance.start(args);
        
        
    }
    
    private void start(String[] args) {

        if (args.length != 1 && args.length != 2){
            throw new PalindromError("Benutzung java PalindromRekursiv <String|Dateiname>");            
        }

        this.eingabe = args[0];
                
        if (args.length == 2) {
            this.ausgewaehlterEingabeTyp = this.toEingabeTyp(args[1]);
        } else {
            this.ausgewaehlterEingabeTyp = EingabeTyp.WORT;
        }

        System.out.println(this.prüefePalindrom(this.eingabe, this.ausgewaehlterEingabeTyp));

    }
    
    
    /**
     * Konstruktor für Objekte der Klasse PalindromRekursiv
     */
    public PalindromRekursiv() {}

    @Override 
    public boolean istPalindrom(String string) {
        if (string == null){
            throw new IllegalArgumentException("keine Datei übergeben");
        }
        if (string.isEmpty()){
            return false;
        }

        return this.prüefePalindrom(string);
    }

    private boolean prüefePalindrom(String string) {

        return this.prüefePalindrom(string, EingabeTyp.WORT);
    }

    private boolean prüefePalindrom(String string, EingabeTyp eingabeTyp) {

        switch (eingabeTyp) {
            case WORT:
                return pruefePalindromInString(string);
            case TEXT_DATEI:
                return pruefePalindromInDatei(string);
            default:
                throw new PalindromError("Eingabetyp nicht unterstuetzt");
        }
    }


    private EingabeTyp toEingabeTyp(String string) {
        try {
            int enumIndex = Integer.parseInt(string);

            int maxIndex = EingabeTyp.values().length - 1;
            if (enumIndex < 0 || enumIndex > maxIndex) {
                throw new PalindromError(String.format("Eingabetyp muss zwischen 0 und %s sein", maxIndex  ));
            }
            return EingabeTyp.values()[enumIndex];
        } catch (NumberFormatException e) {
            throw new PalindromError("Das zweite Argument muss ein Integer sein");
        }
    }


    private boolean pruefePalindromInString(String string) {

        return pruefeRekursiv(string);

    }

    private boolean pruefePalindromInDatei(String dateiName) {

        // s.matches(textDateiRegex) das brauchen wir nicht, oder?
        File file         = new File(dateiName);

        if (!file.isFile()) {
            throw new IllegalArgumentException(file.getName());
        }

        if (!file.canRead()) {
            throw new  IllegalArgumentException(file.getName());
        }

        if (!file.exists()) {
            throw new IllegalArgumentException(file.getName());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            this.reader = reader;
            
            String zeile = this.reader.readLine();
    
            zeile = zeile.trim(); // warum ???
            
            reader.close();
            return pruefeRekursiv(zeile);
    
        } catch (Exception error) {
            throw new PalindromError("Dateilesung hat fehlgeschlagen");
        }        

    }
    
    private boolean pruefeRekursiv(String string){

        string = string.trim().toLowerCase();

        String u;
        
        if (string.charAt(0) == string.charAt(string.length() -1)){
             if (string.length() <= 2){
                 return true;
             }
             u = string.substring(1, string.length() -1);
             return pruefeRekursiv(u);    
        }
        else {
            return false;
        }    
    }
    
}
