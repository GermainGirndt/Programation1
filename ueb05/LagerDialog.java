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
    
    private static final int            FUNKTION_NICHT_DEFINIERT                = -1;
    private static final int            FUNKTION_ENDE                           =  0;
    private static final int            LAGER_ERSTELLEN                         =  1;
    private static final int            ARTIKEL_ANLEGEN                         =  2;
    private static final int            ARTIKEL_ENTFERNEN                       =  3;
    private static final int            FUNKTION_ZUBUCHEN                       =  4;
    private static final int            FUNKTION_ABBUCHEN                       =  5;
    private static final int            FUNKTION_PREIS_AENDERN_EINZELN          =  6;
    private static final int            FUNKTION_PREIS_AENDERN_ALLE             =  7;
    private static final int            ARTIKEL_ANLEGEN_MIT_BESTAND_OHNE_PREIS  =  8;
    private static final int            ARTIKEL_ANLEGEN_OHNE_BESTAND_OHNE_PREIS =  9;
    private static final int            ARTIKEL_ANLEGEN_OHNE_BESTAND_MIT_PREIS  = 10;
    private static final int            ARTIKEL_ANLEGEN_MIT_BESTAND_MIT_PREIS   = 11;
    
    
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
            LAGER_ERSTELLEN                 + ": Lager erstellen;\n"                             +
            ARTIKEL_ANLEGEN                 + ": Artikel im Lager anlegen;\n"                    + 
            ARTIKEL_ENTFERNEN               + ": Artikel aus dem Lager entfernen;\n"             + 
            FUNKTION_ZUBUCHEN               + ": Menge zum Bestand eines Artikels dazubuchen;\n" +
            FUNKTION_ABBUCHEN               + ": Menge vom Bestand eines Artikels abbuchen;\n"   + 
            FUNKTION_PREIS_AENDERN_EINZELN  + ": Preis eines Artikels aendern;\n"                +
            FUNKTION_PREIS_AENDERN_ALLE     + ": Preis aller Artikel aendern;\n"                 + 
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
            case FUNKTION_ENDE:  
                System.out.println("Das Programm ist zu Ende");
                break;
            default:
                System.out.println("Keine gueltige Eingabe");
                break;
        }
    }
    
    public void lagerErstellen(){
        
    }
    
    public void artikelAnLegen(){
        
    }
    
    public void artikelEntfernen() {
    
    }


    public void bestandZubuchen() {

        if (this.lager == null) throw new IllegalArgumentException("Der Befehlt setzt voraus, dass ein Lager angelegt ist!");
        
        int artikelNr = this.userInput.getInt("Zu welcher Artikelnummer? ");
        Validierung.validiereArtikelNr(artikelNr);
        
        int zugang = this.userInput.getInt("Welche Menge soll dazugebucht werden? ");
        Validierung.validiereMengeanderung(zugang);
        
        this.lager.bucheZugang(artikelNr, zugang);

    }
    
    public void bestandAbbuchen() {
        if (this.lager == null) throw new IllegalArgumentException("Der Befehlt setzt voraus, dass ein Lager angelegt ist!");
        
        int artikelNr = this.userInput.getInt("Zu welcher Artikelnummer? ");
        Validierung.validiereArtikelNr(artikelNr);
        
        int abgang = this.userInput.getInt("Welche Menge soll abgebucht werden? ");
        Validierung.validiereMengeanderung(abgang);
        
        this.lager.bucheAbgang(artikelNr, abgang);
    }
    
    public void einzelnpreisAendern(){
        if (this.lager == null) throw new IllegalArgumentException("Der Befehlt setzt voraus, dass ein Lager angelegt ist!");
        
        int artikelNr = this.userInput.getInt("Zu welcher Artikelnummer? ");
        Validierung.validiereArtikelNr(artikelNr);
        
        int prozent = this.userInput.getInt("Um wie viel Prozent handelt es sich? ");
        Validierung.validierePreisaenderung(prozent);
        
        this.lager.aenderePreisEinesArtikels(artikelNr, prozent);
    }
    
    public void allePreiseAendern(){
        if (this.lager == null) throw new IllegalArgumentException("Der Befehlt setzt voraus, dass ein Lager angelegt ist!");

        int prozent = this.userInput.getInt("Um wie viel Prozent handelt es sich? ");
        Validierung.validierePreisaenderung(prozent);

        this.lager.aenderePreisAllerArtikel(prozent);
    }
  
    
}
