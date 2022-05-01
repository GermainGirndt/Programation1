import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
/**
 * Überprüft mittels Rekursion, ob zwei Wörter Palindrome sind.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class PalindromRekursiv2 implements Palindrom {
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
        PalindromRekursiv2 instance = new PalindromRekursiv2(args);
        instance.start();
        
        
    }
    
    private void start() {
        System.out.println(this.prüefePalindrom(this.eingabe));

    }
    
    
    /**
     * Konstruktor für Objekte der Klasse PalindromRekursiv
     */
    public PalindromRekursiv2(String[] args) {

        if (args.length != 1 && args.length != 2){
            throw new PalindromError("Benutzung java PalindromRekursiv <String|Dateiname>");            
        }

        this.eingabe = args[0];
                
        if (args.length == 2) {
            this.ausgewaehlterEingabeTyp = this.toEingabeTyp(args[1]);
        } else {
            this.ausgewaehlterEingabeTyp = EingabeTyp.WORT;
        }

    }


    @Override 
    public boolean istPalindrom(String string) {
        if (string == null){
            throw new IllegalArgumentException("keine Datei übergeben");
        }
        if (string.trim().isEmpty()){
            return false;
        }

        return this.prüefePalindrom(string);
    }

    private boolean prüefePalindrom(String string) {

        switch (this.ausgewaehlterEingabeTyp) {
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
        File file         = new File(dateiName);
        
        validiereFile(file);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            this.reader = reader;      
            String zeile = this.reader.readLine();
            zeile = zeile.trim(); 
            reader.close();
            return pruefeRekursiv(zeile);
        } catch (Exception error) {
            throw new PalindromError("Dateilesung hat fehlgeschlagen");
        }        

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
        }
        else {
            return false;
        }    
    }
    
    private void validiereFile(File file){
     

        if (!file.isFile()) {
            throw new IllegalArgumentException(file.getName());
        }

        if (!file.canRead()) {
            throw new  IllegalArgumentException(file.getName());
        }

        if (!file.exists()) {
            throw new IllegalArgumentException(file.getName());
        }    
    }
}
