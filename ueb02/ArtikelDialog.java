import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Die Klasse ArtikelDialog ist eine Dialogklasse zum Testen der Klasse Artikel
 * 
 * @author Girndt & Krier 
 * @version 1.0
 */
public class ArtikelDialog
{
    private              Artikel        artikel;
    private              UserInput      userInput;
    private              int            funktion;
    
    private static final int            FUNKTION_ANLEGEN_MIT_BESTAND    = 1;
    private static final int            FUNKTION_ANLEGEN_OHNE_BESTAND   = 2;
    private static final int            FUNKTION_BESTAND_ZUBUCHEN       = 3;
    private static final int            FUNKTION_BESTAND_ABBUCHEN       = 4;
    private static final int            FUNKTION_ARTIKELART_AENDERN     = 5;
    private static final int            FUNKTION_ARTIKEL_AUSGEBEN       = 6;
    private static final int            FUNKTION_ENDE                   = 0;

    private static final int            BESTAND_AKTION_ABBUCHEN         = 0;
    private static final int            BESTAND_AKTION_ZUBUCHEN         = 1;
    
    
     /**
    * Konstruktor
    */
    public ArtikelDialog() {
        userInput = new UserInput();
    }
    
    public static void main(String[] args) {
        ArtikelDialog artikeldialog = new ArtikelDialog();
        artikeldialog.start();
        
    }

    /**
    * Hauptschleife der Artikeldialog Klasse
    */
    public void start() {
        this.artikel         = null;
        this.funktion        = -1;
        
        while(this.funktion != FUNKTION_ENDE) {
            try {
                einlesenFunktion();
                ausfuehrenFunktion();
                
            } catch(IllegalArgumentException error) {
                System.out.println(error);

            } catch(InputMismatchException error) {
                System.out.println(error);
                userInput.next();
                
            } catch(Exception error) {
                System.out.println(error);
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
            FUNKTION_ANLEGEN_MIT_BESTAND    + ": Artikel mit Bestand anlegen;\n"  + 
            FUNKTION_ANLEGEN_OHNE_BESTAND   + ": Artikel ohne Bestand anlegen;\n" + 
            FUNKTION_BESTAND_ZUBUCHEN       + ": Menge zum Bestand dazubuchen;\n" +
            FUNKTION_BESTAND_ABBUCHEN       + ": Menge vom Bestand abbuchen;\n"   + 
            FUNKTION_ARTIKELART_AENDERN     + ": Artikelart aendern;\n"           +
            FUNKTION_ARTIKEL_AUSGEBEN       + ": Artikel ausgeben;\n"             + 
            FUNKTION_ENDE                   + ": beenden -> \n"
        );
        
        this.funktion = userInput.getInt("Ausgewählte Funktion: ");
    }
    
    /**
    * Diese Funktion führt je nach Parameter die dazugehoerige Funktion aus
    * @param funktion die ausgeführt werden soll
    */
    public void ausfuehrenFunktion() {
        boolean sollNachBestandFragen;

        switch(this.funktion) {
            case FUNKTION_ANLEGEN_MIT_BESTAND:
                sollNachBestandFragen = true; 
                artikelAnlegen(sollNachBestandFragen);
                break;
            case FUNKTION_ANLEGEN_OHNE_BESTAND:
                sollNachBestandFragen = false; 
                artikelAnlegen(sollNachBestandFragen);
                break;
            case FUNKTION_BESTAND_ZUBUCHEN:      
                bestandZubuchen();
                break;
            case FUNKTION_BESTAND_ABBUCHEN:
                bestandAbbuchen();
                break;
            case FUNKTION_ARTIKELART_AENDERN:
                artikelartAendern();
                break;
            case FUNKTION_ARTIKEL_AUSGEBEN:  
                artikelAusgeben();
                break;
            case FUNKTION_ENDE:  
                System.out.println("Das Programm ist zu Ende");
                break;
            default:
                System.out.println("Keine gueltige Eingabe");
                break;
        }

        if (checkeObArtikelExistiert()) {
            System.out.println(artikel);
        }
    }

    /**
    * Legt einen Artikel mit Bestand an und erfragt alle nötigen Parameter
    */
    public void artikelAnlegen(boolean sollNachBestandFragen) {
        
        if (checkeObArtikelExistiert()) {
            System.out.println("Der Artikel existiert schon.");
            
        } else {
            int artikelNr = userInput.getInt("Artikelnummer: ");
            Validierung.validiereArtikelNr(artikelNr);

            String art = userInput.getString("Artikelart: ");
            Validierung.validiereArtikelArt(art);

            int bestand = beabeiteBestand(sollNachBestandFragen);
            Validierung.validiereBestand(bestand);

            artikel = new Artikel(artikelNr , art , bestand);
        }
    }

    private int beabeiteBestand(boolean sollNachBestandFragen) {
        int bestand;

        if (sollNachBestandFragen) {
            bestand = this.userInput.getInt("Bestand: ");
        } else {
            bestand = 0;
        }

        return bestand;
    }

    /**
    * Fragt nach einer Menge und bucht diese dann dem Bestand des Artikels zu
    */
    public void bestandZubuchen() {
        bestandAendern(BESTAND_AKTION_ZUBUCHEN);
    }
    
    /**
     * Fragt nach einer Menge und bucht diese dann dem Bestand des Artikels ab
     */
    public void bestandAbbuchen() {
        bestandAendern(BESTAND_AKTION_ABBUCHEN);
    }

    private void bestandAendern(int BESTAND_AKTION) {

        int menge;

        if (!checkeObArtikelExistiert()) {
            System.out.println("Es existiert noch kein Artikel");
            return;
        }

        switch (BESTAND_AKTION) {

            case BESTAND_AKTION_ZUBUCHEN:
                menge = this.userInput.getInt("Welche Menge soll dazugebucht werden? ");
                artikel.bucheZugang(menge);
                break;
            case BESTAND_AKTION_ABBUCHEN:
                menge = this.userInput.getInt("Welche Menge soll abgebucht werden? ");
                artikel.bucheAbgang(menge);
                break;

        } 

        System.out.println("Der neue Bestand des Artikels: " + artikel.getBestand());
    }

    /**
    * Fragt nach der neuen Artikelart und überschreibt damit die alte Artikelart
    */
    public void artikelartAendern() {
        if (!checkeObArtikelExistiert()) {
            System.out.println("Es existiert noch kein Artikel");

        } else {
            String art = this.userInput.getString("Neue Artikelart? ");
            artikel.setArt(art);
            System.out.println("Die neue Artikelart ist: " + artikel.getArt());

        }        
        
    }
    
    /**
    * Gibt den Artikel aus
    */
    public void artikelAusgeben() {
        if (!checkeObArtikelExistiert()) {
            System.out.println("Es existiert noch kein Artikel");

        } else {
            System.out.println(artikel);

        }          
    }

    private boolean checkeObArtikelExistiert() {
        return this.artikel != null;
    }
}
