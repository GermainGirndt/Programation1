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
    private boolean istFile;
    ArrayList<String> zeilen;
    private String filemode = "-f";
    private String wordmode = "-s";

    private BufferedReader reader;

    private String eingabe;

    private EingabeTyp eingabeTyp;

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
        PalindromRekursiv instance = PalindromRekursiv.instantieerePalindrom(args);
        instance.start();
    }

    private void start() {
        System.out.println(this.prüefePalindrom());

    }
    
    
    public void start(String[] args) {
        if (args.length < 2){
            throw new PalindromError("Benutzung java PalindromRekursiv <-s|-f> <String|Dateiname>");            
        }  

        // if (args[0].equals(this.filemode)) {
        //    this.istFile = true;
        //    this.readLines(args[1]);
        // } else if ((args[0].equals(this.wordmode))) {
        //    this.istFile = false;
        // }
        // else {
        //     throw new PalindromError("Benutzung java PalindromRekursiv <-s|-f> <String|Dateiname>");      
        // }
        // if(this.istFile){
        //     if(this.zeilen.size() > 0){
        //     for(String z: this.zeilen){
        //         System.out.println(z);
        //         System.out.println(this.istPalindrom(z));   
        //     }
        // }
        // }
        // else{
        //     for(int i = 1; i < args.length ; i++){
        //         System.out.println(args[i]);
        //         System.out.println(this.istPalindrom(args[i]));    
        //     }
        // }
    }
    

    public static PalindromRekursiv instantieerePalindrom(String[] args) {
        if (args.length != 1 && args.length != 2){
            throw new PalindromError("Benutzung java PalindromRekursiv <String|Dateiname>");            
        }

        PalindromRekursiv instance;
        if (args.length == 2) {
            instance = new PalindromRekursiv(args[0], args[1]);
        } else {
            instance = new PalindromRekursiv(args[0]);
        }
        return instance;

    }

    /**
     * Konstruktor für Objekte der Klasse PalindromRekursiv
     * notwendig für die automatisiertenTests
     */
    public PalindromRekursiv() {
        this.zeilen = new ArrayList<>(); 
    }

    /**
     * Konstruktor für Objekte der Klasse PalindromRekursiv
     */
    public PalindromRekursiv(String string) {
        this.setEingabe(string);
        this.eingabeTyp = EingabeTyp.WORT;
    }

    /**
     * Konstruktor für Objekte der Klasse PalindromRekursiv
     */
    public PalindromRekursiv(String string, String stringInt) {
        this(string);

        try {
            int enumIndex = Integer.parseInt(stringInt);

            this.setEingabeTyp(enumIndex);
        } catch (NumberFormatException e) {
            throw new PalindromError("Das zweite Argument muss ein Integer sein");
        }

    }

    public void setEingabe(String eingabeString) {
        if (eingabeString == null){
            throw new PalindromError("kein Argument übergeben");
        }
        if (eingabeString.trim().isEmpty()){
            throw new PalindromError("erstes Argument darf nicht leer sein");
        }

        this.eingabe = eingabeString;
    }

    public void setEingabeTyp(int eingabeTypIndex) {
        this.eingabeTyp = this.toEingabeTyp(eingabeTypIndex);
    }

    @Override 
    public boolean istPalindrom(String string) {

        PalindromRekursiv palindrom = new PalindromRekursiv(string);
        
        return palindrom.prüefePalindrom();
    }

    private boolean prüefePalindrom() {

        switch (this.eingabeTyp) {
            case WORT:
                return pruefePalindromInString(this.eingabe);
            case TEXT_DATEI:
                return pruefePalindromInDatei(this.eingabe);
            default:
                throw new PalindromError("Eingabetyp nicht unterstuetzt");
        }
    }

    private EingabeTyp toEingabeTyp(int enumIndex) {

        int maxIndex = EingabeTyp.values().length - 1;
        if (enumIndex < 0 || enumIndex > maxIndex) {
            throw new PalindromError(String.format("Eingabetyp muss zwischen 0 und %s sein", maxIndex  ));
        }
        return EingabeTyp.values()[enumIndex];

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
    
    private void readLines(String s){
        File file         = new File(s);
        String zeile;
        validiereFile(file);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while((zeile = reader.readLine()) != null)
            {
                
                 this.zeilen.add(zeile);
               
            }
             
            reader.close();
          
            } catch (Exception error) {
            throw new PalindromError("Dateilesung hat fehlgeschlagen");
            }    
    }
}
