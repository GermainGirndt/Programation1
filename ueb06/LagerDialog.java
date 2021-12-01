import java.util.InputMismatchException;

/**
 * Die Klasse ArtikelDialog ist eine Dialogklasse zum Testen der Klasse Artikel
 * 
 * @author Girndt & Krier 
 * @version 1.0
 */
public class LagerDialog
{
    private              Lager          lager;
    private              UserInput      userInput;
    private              int            funktion;
    
    private static final int            FUNKTION_NICHT_DEFINIERT                =  -1;
    private static final int            FUNKTION_ENDE                           =  0;
    private static final int            LAGER_ERSTELLEN                         =  1;
    private static final int            LAGER_ERSTELLEN_INITIAL                 =  2;
    private static final int            ARTIKEL_ANLEGEN                         =  3;
    private static final int            ARTIKEL_ENTFERNEN                       =  4;
    private static final int            FUNKTION_ZUBUCHEN                       =  5;
    private static final int            FUNKTION_ABBUCHEN                       =  6;
    private static final int            FUNKTION_PREIS_AENDERN_EINZELN          =  7;
    private static final int            FUNKTION_PREIS_AENDERN_ALLE             =  8;
    private static final int            LAGER_AUSGEBEN                          =  9;
    private static final int            LAGER_GROESSE_AUSGEBEN                  =  10;
    private static final int            ARTIKEL_ANZAHL_AUSGEBEN                 =  11;
    private static final int            LAGERPLATZ_ANSCHAUEN                    =  12;
    private static final int            ARTIKELSTANDORT_BEKOMMEN                =  13;
    
    
    private static final String         LAGER_NULL                              = "Der Befehl setzt voraus, dass ein Lager angelegt ist!";
    private static final String         LAGER_EXISTIERT                         = "Ein Lager existiert schon!";
    private static final String         ARTIKELNUMMER_FRAGE                     = "Zu welcher Artikelnummer? ";
    private static final String         PROZENTANTEIL_FRAGE                     = "Um wie viel Prozent handelt es sich? ";
    private static final String         LAGER_VOLL                              = "Der Artikel passt nicht im Lager. Entferne einen Artikel, um einen neuen anzulegen.";
    
    /**
    * Konstruktor
    */
    public LagerDialog() {
        userInput = new UserInput();
    }
    
    public static void main(String[] args) {
        LagerDialog lagerDialog = new LagerDialog();
        lagerDialog.start();  
    }

    /**
    * Hauptschleife der Lagerdialog Klasse
    */
    public void start() {
        this.lager           = null;
        this.funktion        = FUNKTION_NICHT_DEFINIERT;
        
        while(this.funktion != FUNKTION_ENDE) {
            try {
                einlesenFunktion();
                ausfuehrenFunktion();
                
            } catch (IllegalArgumentException error) {
                System.err.println(error);

            } catch (InputMismatchException error) {
                System.err.println(error);
                userInput.next();

            } catch (Exception error) {
                System.err.println(error);
                error.printStackTrace(System.out); 

            }
        }
    }
    
    /**
    * Diese Funktion liest ein welche Funktion ausgefuehrt werden soll
    * @return funktion die ausgewaehlt wurde
    */
    public void einlesenFunktion() {
        
        System.out.print(
            "\n\n" +
            LAGER_ERSTELLEN                 + ": Lager erstellen mit bestimmter Groesse;\n"      +
            LAGER_ERSTELLEN_INITIAL         + ": Lager erstellen mit Initialgroesse 10;\n"       +
            ARTIKEL_ANLEGEN                 + ": Artikel im Lager anlegen;\n"                    + 
            ARTIKEL_ENTFERNEN               + ": Artikel aus dem Lager entfernen;\n"             + 
            FUNKTION_ZUBUCHEN               + ": Menge zum Bestand eines Artikels dazubuchen;\n" +
            FUNKTION_ABBUCHEN               + ": Menge vom Bestand eines Artikels abbuchen;\n"   + 
            FUNKTION_PREIS_AENDERN_EINZELN  + ": Preis eines Artikels aendern;\n"                +
            FUNKTION_PREIS_AENDERN_ALLE     + ": Preis aller Artikel aendern;\n"                 + 
            LAGER_AUSGEBEN                  + ": Lager ausgeben;\n"                              +
            LAGER_GROESSE_AUSGEBEN          + ": Lagergroesse ausgeben;\n"                       +
            ARTIKEL_ANZAHL_AUSGEBEN         + ": Artikelanzahl im Lager ausgeben;\n"             +
            LAGERPLATZ_ANSCHAUEN            + ": Lagerplatz anschauen;\n"                        +
            ARTIKELSTANDORT_BEKOMMEN        + ": Artikelstandort bekommen;\n"                    +
            FUNKTION_ENDE                   + ": beenden -> \n\n"   
        );
        
        this.funktion = userInput.getInt("Ausgewählte Funktion: ");
        System.out.println();
    }
    
    /**
    * Diese Funktion führt je nach Parameter die dazugehoerige Funktion aus
    * @param funktion die ausgeführt werden soll
    */
    public void ausfuehrenFunktion() {

        switch(this.funktion) {
            case LAGER_ERSTELLEN:
                lagerErstellen();
                break;
            case LAGER_ERSTELLEN_INITIAL:
                this.lager = new Lager();
                System.out.println("Lager wurde erstellt. ");
                break;
            case ARTIKEL_ANLEGEN:
                artikelAnLegen();
                break;
            case ARTIKEL_ENTFERNEN: 
                artikelEntfernen();
                break;
            case FUNKTION_ZUBUCHEN:      
                bestandZubuchen();
                break;
            case FUNKTION_ABBUCHEN:
                bestandAbbuchen();
                break;
            case FUNKTION_PREIS_AENDERN_EINZELN:
                einzelnpreisAendern();
                break;
            case FUNKTION_PREIS_AENDERN_ALLE:  
                allePreiseAendern();
                break;
            case LAGER_AUSGEBEN:
                lagerAusgeben();
                break;
            case LAGER_GROESSE_AUSGEBEN:
                System.out.println("Lagergroesse: " + lager.getLagerGroesse());
                break;
            case ARTIKEL_ANZAHL_AUSGEBEN:
                System.out.println("Artikelanzahl: " + lager.getArtikelAnzahl());
                break;
            case LAGERPLATZ_ANSCHAUEN:
                lagerPlatzAnschauen();
                break;
            case ARTIKELSTANDORT_BEKOMMEN:
                arikelstandortBekommen();
                break;
            case FUNKTION_ENDE:  
                System.out.println("Das Programm ist zu Ende");
                break;
            default:
                System.out.println("Keine gueltige Eingabe");
                break;
        }
    }
    
    /**
    * Diese Funktion fragt nach einer Lagergroesse und erzeugt dann ein Lager
    */
    public void lagerErstellen(){
        if (this.lager != null) throw new IllegalArgumentException("LAGER_EXISTIERT");    
        
        int lagergroesse = this.userInput.getInt("Welche Lagergroesse?: ");
        
        this.lager = new Lager(lagergroesse);
        System.out.println("Lager wurde erstellt. ");
    }
    
    /**
    * Diese Funktion fragt nach Artikeldaten, legt einen Artikel an und macht diesen dann ins Lager
    */
    public void artikelAnLegen(){
        if (this.lager == null) throw new IllegalArgumentException("LAGER_NULL");
         
        if( lager.getArtikelAnzahl() <= lager.getLagerGroesse()) throw new IllegalArgumentException(LAGER_VOLL);
        
        int artikelNr     = this.userInput.getInt("Artikelnummer?: ");
        Validierung.validiereArtikelNr(artikelNr);
        if (lager.getArtikelNachNummer(artikelNr) != -1) {
            throw new IllegalArgumentException("Die eingegebene Artikelnummer ist bereits im Lager!");
        }
        
        
        String artikelArt = this.userInput.getString("Artikelart?: ");
        Validierung.validiereArtikelArt(artikelArt);
        int bestand       = this.userInput.getInt("Bestand? 0 falls Initialbestand: ");
        Validierung.validiereBestand(bestand);
        double preis      = this.userInput.getDouble("Preis? 0 falls Initialpreis: ");
        Validierung.validierePreis(preis);

        Artikel artikel   = new Artikel(artikelNr, artikelArt, bestand, preis);
        lager.legeAnArtikel(artikel);
        
        System.out.println("Artikel wurde angelegt. ");
    }
    
    /**
    * Diese Funktion fragt nach dem zu entfernenden Artikel und entfernt diesen dann
    */
    public void artikelEntfernen() {
        if (this.lager == null) throw new IllegalArgumentException("LAGER_NULL");
         
        int artikelNr = this.userInput.getInt("Geben Sie die Artikelnummer des zu entfernenden Artikels ein: ");
        Validierung.validiereArtikelNr(artikelNr);
        
        this.lager.entferneArtikel(artikelNr);
        
        System.out.println("Artikel wurde entfernt. ");
    }


    public void bestandZubuchen() {

        if (this.lager == null) throw new IllegalArgumentException("LAGER_NULL");
        
        int artikelNr = this.userInput.getInt(ARTIKELNUMMER_FRAGE);
        Validierung.validiereArtikelNr(artikelNr);
        
        int zugang = this.userInput.getInt("Welche Menge soll dazugebucht werden? ");
        Validierung.validiereMengeanderung(zugang);
        
        this.lager.bucheZugang(artikelNr, zugang);

        System.out.println("Zugang wurde gebucht. ");
    }
    
    public void bestandAbbuchen() {
        if (this.lager == null) throw new IllegalArgumentException("LAGER_NULL");
        
        int artikelNr = this.userInput.getInt(ARTIKELNUMMER_FRAGE);
        Validierung.validiereArtikelNr(artikelNr);
        
        int abgang = this.userInput.getInt("Welche Menge soll abgebucht werden? ");
        Validierung.validiereMengeanderung(abgang);
        
        this.lager.bucheAbgang(artikelNr, abgang);
        System.out.println("Abgang wurde gebucht. ");
    }
    
    public void einzelnpreisAendern(){
        if (this.lager == null) throw new IllegalArgumentException("LAGER_NULL");
        
        int artikelNr = this.userInput.getInt(ARTIKELNUMMER_FRAGE);
        Validierung.validiereArtikelNr(artikelNr);
        
        int prozent = this.userInput.getInt(PROZENTANTEIL_FRAGE);
        Validierung.validierePreisaenderung(prozent);
        
        this.lager.aenderePreisEinesArtikels(artikelNr, prozent);
        
        System.out.println("Der Preis des Artikels wurde geändert! ");
    }
    
    public void allePreiseAendern(){
        if (this.lager == null) throw new IllegalArgumentException("LAGER_NULL");

        int prozent = this.userInput.getInt( PROZENTANTEIL_FRAGE);
        Validierung.validierePreisaenderung(prozent);

        this.lager.aenderePreisAllerArtikel(prozent);
        
        System.out.println("Alle Preise sind geändert worden! ");
    }
  
    public void lagerAusgeben(){
        if (this.lager == null) throw new IllegalArgumentException("LAGER_NULL");

        System.out.println(lager.toString());
    }
    
    public void lagerPlatzAnschauen(){
        if (this.lager == null) throw new IllegalArgumentException("LAGER_NULL");
        
        int lagerplatz = this.userInput.getInt("Welcher Lagerplatz? ");
        
        if(lager.getArtikel(lagerplatz)==null){
            System.out.println("leer");
        }
        else{
            System.out.println(lager.getArtikel(lagerplatz).toString()) ;
        }
    }
    
    public void arikelstandortBekommen(){
        if (this.lager == null) throw new IllegalArgumentException("LAGER_NULL");
        
        int artikelNr = this.userInput.getInt(ARTIKELNUMMER_FRAGE);
        Validierung.validiereArtikelNr(artikelNr);
        
        int platz = lager.getArtikelNachNummer(artikelNr);       
        
        if(platz == -1){
            System.out.println("Es gibt diesen Artikel nicht im Lager. ");
        }
        else{
            System.out.println("Der Artikel ist am Lagerplatz: " + platz);
        }
    }
}
