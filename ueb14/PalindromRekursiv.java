import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;
/**
 * Überprüft mittels Rekursion, ob zwei Wörter Palindrome sind.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class PalindromRekursiv implements Palindrom {
    ArrayList<String> zeilen;

    private BufferedReader reader;

    private String eingabe;

    private Mode mode;

    public enum Mode { 
        WORT("-s"),
        TEXT_DATEI("-f");
    
        String modeName;
    
        Mode(String modeName) {
            this.modeName = modeName;
        }
    
        public String getModeName() {
            return this.modeName;
        }
    
    };

    public static void main(String[] args) {
        PalindromRekursiv instance = PalindromRekursiv.instantieerePalindrom(args);
        instance.start();
    }

    private void start() {
        System.out.println(this.pruefePalindrom());

    }
    

    public static PalindromRekursiv instantieerePalindrom(String[] args) {
        if (args.length != 1 && args.length != 2){
            throw new PalindromError("Benutzung java PalindromRekursiv <String|Dateiname>");            
        }

        PalindromRekursiv instance;
        if (args.length == 2) {
            System.out.println(args[0]);
            System.out.println(args[1]);
            instance = new PalindromRekursiv(args[0], args[1]);
        } else {
            System.out.println(args[0]);
            instance = new PalindromRekursiv(args[0]);
        }

        return instance;

    }

    /**
     * Konstruktor für Objekte der Klasse PalindromRekursiv
     */
    public PalindromRekursiv() {
    }

    /**
     * Konstruktor für Objekte der Klasse PalindromRekursiv
     */
    public PalindromRekursiv(String eingabe) {
        this.setEingabe(eingabe);
        this.mode = Mode.WORT;
    }

    /**
     * Konstruktor für Objekte der Klasse PalindromRekursiv
     */
    public PalindromRekursiv(String mode, String string) {
        this(string);
        this.setMode(mode);
    }

    public void setEingabe(String eingabestring) {
        if (eingabestring == null){
            throw new PalindromError("kein Argument übergeben");
        }
        if (eingabestring.trim().isEmpty()){
            throw new PalindromError("eingabestring darf nicht leer sein");
        }
        
        this.eingabe = eingabestring;
    }

    public void setMode(String ausgewählterMode) {

        if (ausgewählterMode == null || ausgewählterMode.trim().isEmpty()) {
            throw new PalindromError("Bitte geben Sie einen Mode ein");
        }

        for ( Mode mode : Mode.values() ) {
            if (mode.getModeName().equals(ausgewählterMode)) {
                System.out.println("Ausgewählter Mode: " + mode.getModeName());
                this.mode = mode;
                return;
            }
        }
        
        throw new PalindromError("Nur Modes '-f' und '-s' werden unterstützt. Auswahl:" + ausgewählterMode);

    }

    @Override 
    public boolean istPalindrom(String string) {

        PalindromRekursiv palindrom = new PalindromRekursiv(string);
        
        return palindrom.pruefePalindrom();
    }

    private boolean pruefePalindrom() {

        switch (this.mode) {
            case WORT:
                return pruefePalindromInString(this.eingabe);
            case TEXT_DATEI:
                return pruefePalindromInDatei(this.eingabe);
            default:
                throw new PalindromError("Eingabetyp nicht unterstuetzt");
        }
    }


    private boolean pruefePalindromInString(String string) {
        return this.pruefeRekursiv(string);
    }


    private boolean pruefePalindromInDatei(String dateiName) {
        File file         = new File(dateiName);
        
        this.validiereFile(file);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            this.reader = reader;
            String zeile = this.reader.readLine();
            zeile = zeile.trim(); 
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
        } else {
            return false;
        }    
    }
    
    private void validiereFile(File file){
        
        if (!file.exists()) {
            throw new PalindromError(String.format("Die Datei '%s' existiert nicht" , file.getName()));
        }    

        if (!file.isFile()) {
            throw new PalindromError(String.format("%s ist keine Datei" , file.getName()));
        }

        if (!file.canRead()) {
            throw new  PalindromError(String.format("%s ist nicht lesbar" , file.getName()));
        }

    }
    
    private void readLines(String s){
        File file         = new File(s);
        String zeile;
        validiereFile(file);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while((zeile = reader.readLine()) != null) {
                
                 this.zeilen.add(zeile);
               
            }
             
            reader.close();
          
            } catch (Exception error) {
            throw new PalindromError("Dateilesung hat fehlgeschlagen");
            }    
    }
}
