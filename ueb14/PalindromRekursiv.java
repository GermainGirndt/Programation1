import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

/**
 * Überprüft mittels Rekursion, ob zwei Wörter Palindrome sind.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class PalindromRekursiv implements Palindrom {


    private BufferedReader reader;

    private String[] eingabe;

    private Mode mode;

    private final static int MODE_INDEX = 0;
    private final static int EINGABE_STRINGS_START_INDEX = 1;

    private final static int EINZEL_STRING_EINGABE_INDEX = 0;

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

        StringBuffer sb = new StringBuffer();

        System.out.println();
        
        
        sb.append(String.format("Ausgewählter Mode: %s \n\n", this.mode.getModeName()));
        boolean[] ergebnis = this.pruefePalindrome();
        
        for (int i = 0; i < this.eingabe.length; i++) {
            sb.append(String.format("%s Geprüfter String: %s || Ergebnis: %s\n", i+1, this.eingabe[i], ergebnis[i]) );
        }

        System.out.println(sb);

    }
    

    public static PalindromRekursiv instantieerePalindrom(String[] args) {
        if (args.length <= 1){
            throw new PalindromError("Geben Sie den Mode und die zu bewertenden Strings ein");            
        }

        String mode = args[MODE_INDEX];
        String[] eingabeStrings = PalindromRekursiv.extrahireEingabeStrings(args);

        PalindromRekursiv instance = new PalindromRekursiv(mode, eingabeStrings);


        return instance;

    }

    private static String[] extrahireEingabeStrings( String[] args ) {

        String[] eingabeStrings = new String[args.length - PalindromRekursiv.EINGABE_STRINGS_START_INDEX];

        for (int i = 0; i < args.length; i++) {
            eingabeStrings[0] = args[PalindromRekursiv.EINGABE_STRINGS_START_INDEX];
        }

        return eingabeStrings;
    }

    /**
     * Konstruktor für Objekte der Klasse PalindromRekursiv
     */
    public PalindromRekursiv() {

    }

    public PalindromRekursiv(String[] eingabeString) {

        this.setEingabe(eingabeString );
    }

    /**
     * Konstruktor für Objekte der Klasse PalindromRekursiv
     */
    public PalindromRekursiv(String mode, String[] eingabeStrings) {
        this.setMode(mode);
        this.setEingabe(eingabeStrings);
    }

    public void setEingabe(String[] eingabestring) {

        if (eingabestring.length == 0) {
            throw new PalindromError("Eingabestring darf nicht leer sein");
        }

        if (this.mode == Mode.TEXT_DATEI && eingabestring.length != 1 ) {
            throw new PalindromError("Mode 'Textdatei' unterstuetzt nur eine Stringeingabe");
        }


        for (int i = 0; i < eingabestring.length; i++) {

            if (eingabestring[i] == null){
                throw new PalindromError(String.format("Keine Referenz für den String an der Stelle %s", i));
            }
            if (eingabestring[i].trim().isEmpty()){
                throw new PalindromError(String.format("Eingabestring an der Stelle %s darf nicht leer sein", i));
            }
        }

        
        this.eingabe = eingabestring;
    }

    public void setMode(String ausgewählterMode) {

        if (ausgewählterMode == null || ausgewählterMode.trim().isEmpty()) {
            throw new PalindromError("Bitte geben Sie einen Mode ein");
        }

        for ( Mode mode : Mode.values() ) {
            if (mode.getModeName().equals(ausgewählterMode)) {
                this.mode = mode;
                return;
            }
        }
        
        throw new PalindromError("Nur Modes '-f' und '-s' werden unterstützt. Auswahl:" + ausgewählterMode);

    }

    @Override 
    public boolean istPalindrom(String string) {

        PalindromRekursiv palindrom = new PalindromRekursiv(new String[] { string });
        
        return palindrom.pruefePalindrom();
    }

    @Override 
    public boolean[] sindPalindrome(String[] string) {

        PalindromRekursiv palindrom = new PalindromRekursiv(string);
        
        return palindrom.pruefePalindrome();
    }


    private boolean pruefePalindrom() {

        switch (this.mode) {
            case WORT:
                return pruefePalindromInString(this.eingabe[EINZEL_STRING_EINGABE_INDEX]);
            case TEXT_DATEI:
                return pruefePalindromInDatei(this.eingabe[EINZEL_STRING_EINGABE_INDEX]);
            default:
                throw new PalindromError("Eingabetyp nicht unterstuetzt");
        }
    }

    private boolean[] pruefePalindrome() {

        switch (this.mode) {
            case WORT:
                return pruefePalindromeInStrings(this.eingabe);
            case TEXT_DATEI:
                return pruefePalindromeInDatei(this.eingabe[EINZEL_STRING_EINGABE_INDEX]);
            default:
                throw new PalindromError("Eingabetyp nicht unterstuetzt");
        }
    }


    private boolean pruefePalindromInString(String string) {
        return this.pruefeRekursiv(string);
    }

    private boolean[] pruefePalindromeInStrings(String[] string) {
        
        boolean[] ergebnisse = new boolean[string.length];

        for (int i = 0; i < string.length; i++) {

            ergebnisse[i] = this.pruefeRekursiv(string[i]);
        }

        return ergebnisse;
    }


    private boolean pruefePalindromInDatei(String dateiName) {
        File file         = new File(dateiName);
        
        this.validiereFile(file);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            this.reader = reader;
            String zeile = this.reader.readLine();
            this.eingabe = new String[] { zeile };
            
            return pruefeRekursiv(zeile);
        } catch (IOException error) {
            throw new PalindromError("Dateilesung hat fehlgeschlagen");
        }
    }

    private boolean[] pruefePalindromeInDatei(String dateiName) {
        String zeile;
        File file         = new File(dateiName);
        
        this.validiereFile(file);

        int zeilenAnzahl = this.zaehleZeilen(dateiName);
        this.eingabe = new String[zeilenAnzahl];


        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            int zaehler = 0;
            while((zeile = reader.readLine()) != null) {
                
                this.eingabe[zaehler] = zeile;
                zaehler++;
           }

           return this.pruefePalindromeInStrings(this.eingabe);
        } catch (IOException error) {
            throw new PalindromError("Dateilesung hat fehlgeschlagen");
        }
    }

    private int zaehleZeilen(String dateiName) {

        File file         = new File(dateiName);
        
        this.validiereFile(file);

        int zaehler = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while( reader.readLine() != null) {
                zaehler++;
           }

           return zaehler;
        } catch (IOException error) {
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
    
    @Override 
    public String toString(){
        return "PalindromRekursiv";
    }
    
    @Override
    public void start(String[] args){
        
    }
}
