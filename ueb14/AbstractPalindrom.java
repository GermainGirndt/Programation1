import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
/**
 * Abstrakte Klasse für Palindrome-Überprüft
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */

public abstract class AbstractPalindrom implements Palindrom {

    private BufferedReader reader;

    private String[] eingabe;

    private Mode mode;

    private final static int MODE_ARGUMENT_INDEX = 0;
    private final static int EINGABE_STRINGS_ARGUMENT_START_INDEX = 1;

    private final static int EINZEL_STRING_ARGUMENT_EINGABE_INDEX = 0;

    private final static String WORT_MODE = "-s";
    private final static String TEXT_DATEI_MODE = "-f";

    protected enum Mode { 
        WORT(WORT_MODE),
        TEXT_DATEI(TEXT_DATEI_MODE);
    
        String modeName;
    
        Mode(String modeName) {
            this.modeName = modeName;
        }
    
        public String getModeName() {
            return this.modeName;
        }
    
    };

    @Override 
    public abstract boolean istPalindrom(String string);

    @Override 
    public abstract boolean[] sindPalindrome(String[] strings);

    protected abstract boolean pruefe(String string);

    protected void start() {

        StringBuffer sb = new StringBuffer();

        System.out.println();
        
        
        sb.append(String.format("Ausgewählter Mode: %s \n\n", this.mode.getModeName()));
        boolean[] ergebnis = this.pruefePalindrome();
        
        for (int i = 0; i < this.eingabe.length; i++) {
            sb.append(String.format("%s) Geprüfter String: '%s' || Ergebnis: %s\n", i+1, this.eingabe[i], ergebnis[i]) );
        }

        System.out.println(sb);

    }

    protected static String[] extrahireEingabeStrings( String[] args ) {

        int eingabeStringLaenge = args.length - AbstractPalindrom.EINGABE_STRINGS_ARGUMENT_START_INDEX;
        String[] eingabeStrings = new String[eingabeStringLaenge];

        for (int i = 0; i < eingabeStringLaenge; i++) {
            eingabeStrings[i] = args[AbstractPalindrom.EINGABE_STRINGS_ARGUMENT_START_INDEX + i];
        }

        return eingabeStrings;
    }

    /**
     * Konstruktor für Objekte der Klasse AbstractPalindrom
     */
    public AbstractPalindrom() {
        this.mode = Mode.WORT;
    }
    
    public AbstractPalindrom(String[] eingabeString) {
        this.mode = Mode.WORT;
        this.setEingabe(eingabeString);
    }

    /**
     * Konstruktor für Objekte der Klasse AbstractPalindrom
     */
    public AbstractPalindrom(String mode, String[] eingabeStrings) {
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


    protected boolean pruefePalindrom() {

        switch (this.mode) {
            case WORT:
                return pruefePalindromInString(this.eingabe[EINZEL_STRING_ARGUMENT_EINGABE_INDEX]);
            case TEXT_DATEI:
                return pruefePalindromInDatei(this.eingabe[EINZEL_STRING_ARGUMENT_EINGABE_INDEX]);
            default:
                throw new PalindromError("Eingabetyp nicht unterstuetzt");
        }
    }

    protected boolean[] pruefePalindrome() {

        switch (this.mode) {
            case WORT:
                return pruefePalindromeInStrings(this.eingabe);
            case TEXT_DATEI:
                return pruefePalindromeInDatei(this.eingabe[EINZEL_STRING_ARGUMENT_EINGABE_INDEX]);
            default:
                throw new PalindromError("Eingabetyp nicht unterstuetzt");
        }
    }


    private boolean pruefePalindromInString(String string) {
        return this.pruefe(string);
    }


    private boolean[] pruefePalindromeInStrings(String[] string) {
        
        boolean[] ergebnisse = new boolean[string.length];

        for (int i = 0; i < string.length; i++) {

            ergebnisse[i] = this.pruefe(string[i]);
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

            return pruefe(zeile);
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
        return "AbstractPalindrom";
    }

    protected static int getModeArgumentIndex() {
        return AbstractPalindrom.MODE_ARGUMENT_INDEX;
    }
    
    

}