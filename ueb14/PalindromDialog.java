public class PalindromDialog {
    
    private BufferedReader reader;
    
    private final static int PALINDROM_NAME_INDEX = 0;
    private final static int MODE_ARGUMENT_INDEX = 1;
    private final static int EINGABE_STRINGS_ARGUMENT_START_INDEX = 2;

    private Mode mode;
    private Palindrom palindrom;
    
    AbstractPalindrom[] palindrome;
    private AbstractPalindrom ausgewaehltesPalindrom;

    private List<String> eingabe;

    private StringBuffer sb;
    
    protected enum Mode { 
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


    protected enum Palindrom { 
        ITERATIV("ITERATIV", 0),
        REKURSIV("REKURSIV", 1);
    
        String palindromName;
    
        Mode(String palindromName, int index) {
            this.palindromName = palindromName;
            this.index = index;
        }
    
        public String getPalindromName() {
            return this.palindromName;
        }
    
    };

    public static void main(String[] args) {
        instance.start(args);
    }

    private void start(String[] args) {

        this.palindrome = new AbstractPalindrome[] { new PalindromIterativ(), new PalindromRekursiv() };
        this.sb = new StringBuffer();

        if (args.length < EINGABE_STRINGS_ARGUMENT_START_INDEX) {
            throw new IllegalArgumentException("Geben Sie den PalindromName, die Mode und die zu bewertenden Strings ein");            
        }
        
        this.setPalindrom(args[PalindromDialog.PALINDROM_NAME_INDEX]);
        this.setMode(args[PalindromDialog.MODE_ARGUMENT_INDEX]);
        String[] eingabeStrings = this.extrahiereEingabeStrings(args);

        System.out.println();
        
        sb.append(String.format("Ausgewählter Mode: %s \n\n", this.mode.getModeName()));
        
        boolean[] ergebnis = this.ausgewaehltesPalindrom.pruefePalindromeInStrings();
        for (int i = 0; i < this.eingabe.size(); i++) {
            sb.append(String.format("%s) Geprüfter String: '%s' || Ergebnis: %s\n", i+1, this.eingabe[i], ergebnis[i]) );
        }

        System.out.println(sb);
    }



    protected boolean[] pruefePalindrome(String[] palindrome) {

        switch (this.mode) {
            case WORT:
                return pruefePalindromeInStrings(this.eingabe);
            case TEXT_DATEI:
                return pruefePalindromeInDatei(this.eingabe[EINZEL_STRING_ARGUMENT_EINGABE_INDEX]);
            default:
                throw new PalindromError("Eingabetyp nicht unterstuetzt");
        }
    }

    protected String[] extrahiereEingabeStrings( String[] args ) {

        int eingabeStringLaenge = args.length - PalindromDialog.EINGABE_STRINGS_ARGUMENT_START_INDEX;
        String[] eingabeStrings = new String[eingabeStringLaenge];

        for (int i = 0; i < eingabeStringLaenge; i++) {
            eingabeStrings[i] = args[AbstractPalindrom.EINGABE_STRINGS_ARGUMENT_START_INDEX + i];
        }

        return eingabeStrings;
    }



    public boolean[] pruefePalindromeInDatei(String dateiName) {
        String zeile;
        
        this.eingabe = Einlesen.readLines(dateiName);
        this.ausgewaehltesPalindrom.pruefePalindromeInStrings(this.eingabe)
    }

    public void setPalindrom(String ausgewaehltesPalindrom) {

        if (ausgewaehltesPalindrom == null || ausgewaehltesPalindrom.trim().isEmpty()) {
            throw new PalindromError("Bitte geben Sie ein Palindrom ein");
        }

        for ( Palindrom palindrom : Palindrom.values() ) {
            if (palindrom.getPalindromName().equals(ausgewaehltesPalindrom)) {
                this.palindrom = palindrom;
                return;
            }
        }
        
        throw new IllegalArgumentException("Nur Palindrome Rekursiv und Iterativ werden unterstützt. Auswahl:" + ausgewaehltesPalindrom);
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
        
        throw new IllegalArgumentException("Nur Modes '-f' und '-s' werden unterstützt. Auswahl:" + ausgewählterMode);

    }

    public void setEingabe(String[] eingabestring) {

        if (eingabestring.length == 0) {
            throw new PalindromError("Eingabestring darf nicht leer sein");
        }

        if (this.mode == Mode.TEXT_DATEI && eingabestring.length != 1 ) {
            throw new PalindromError("Mode 'Textdatei' unterstuetzt nur eine Stringeingabe");
        }

        this.eingabe = new ArrayList();
        for (int i = 0; i < eingabestring.length; i++) {

            if (eingabestring[i] == null) {
                throw new PalindromError(String.format("Keine Referenz für den String an der Stelle %s", i));
            }
            if (eingabestring[i].trim().isEmpty()) {
                throw new PalindromError(String.format("Eingabestring an der Stelle %s darf nicht leer sein", i));
            }

            this.eingabe.add(eingabestring[i]);
        }
    }
       
}
