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
    private              Scanner        input;
    private              int            funktion;
    
    private static final int            ANLEGEN_MIT_BESTAND    = 1;
    private static final int            ANLEGEN_OHNE_BESTAND   = 2;
    private static final int            BESTAND_ZUBUCHEN       = 3;
    private static final int            BESTAND_ABBUCHEN       = 4;
    private static final int            ARTIKELART_AENDERN     = 5;
    private static final int            ARTIKEL_AUSGEBEN       = 6;
    private static final int            ENDE                   = 0;
    
    
     /**
    * Konstruktor
    */
    public ArtikelDialog() {
        input = new Scanner(System.in);
    }
    
    /**
    * Hauptschleife der Artikeldialog Klasse
    */
    public void start() {
        this.artikel         = null;
        this.funktion        = -1;
        
        while(this.funktion != ENDE) {
            try {
                einlesenFunktion();
                ausfuehrenFunktion();

            } catch(IllegalArgumentException | InputMismatchException error) {
                System.out.println(error);
                input.nextLine(); // warum?

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
            ANLEGEN_MIT_BESTAND    + ": Artikel mit Bestand anlegen;\n"  + 
            ANLEGEN_OHNE_BESTAND   + ": Artikel ohne Bestand anlegen;\n" + 
            BESTAND_ZUBUCHEN       + ": Menge zum Bestand dazubuchen;\n" +
            BESTAND_ABBUCHEN       + ": Menge vom Bestand abbuchen;\n"   + 
            ARTIKELART_AENDERN     + ": Artikelart aendern;\n"           +
            ARTIKEL_AUSGEBEN       + ": Artikel ausgeben;\n"             + 
            ENDE                   + ": beenden -> "
        );
        
        this.funktion = input.nextInt();
        input.nextLine();
    }
    
    /**
    * Diese Funktion führt je nach Parameter die dazugehoerige Funktion aus
    * @param funktion die ausgeführt werden soll
    */
    public void ausfuehrenFunktion() {
        boolean sollNachBestandFragen;

        switch(this.funktion) {
            case ANLEGEN_MIT_BESTAND:
                sollNachBestandFragen = true; 
                artikelAnlegen(true);
                break;
            case ANLEGEN_OHNE_BESTAND:
                sollNachBestandFragen = false; 
                artikelAnlegen(false);
                break;
            case BESTAND_ZUBUCHEN:      
                bestandZubuchen();
                break;
            case BESTAND_ABBUCHEN:
                bestandAbbuchen();
                break;
            case ARTIKELART_AENDERN:
                artikelartAendern();
                break;
            case ARTIKEL_AUSGEBEN:  
                artikelAusgeben();
                break;
            case ENDE:  
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

    private boolean checkeObArtikelExistiert() {
        return this.artikel != null;

    }
    
    /**
    * Legt einen Artikel mit Bestand an und erfragt alle nötigen Parameter
    */
    public void artikelAnlegen(boolean sollNachBestandFragen) {
        int bestand;

        if (checkeObArtikelExistiert()) {
            System.out.println("Der Artikel existiert schon.");

        } else {
            System.out.print("Artikelnummer: ");
            int artikelNr = input.nextInt();
            input.nextLine();  // warum?
            
            System.out.print("Artikelart: ");
            String art = input.nextLine();

            if (sollNachBestandFragen) {
                System.out.print("Bestand: ");
                bestand = input.nextInt();
            } else {
                bestand = 0;
            }
            
            artikel = new Artikel(artikelNr , art , bestand);
        }
    }

    /**
    * Fragt nach einer Menge und bucht diese dann dem Bestand des Artikels zu
    */
    public void bestandZubuchen() {
        if (!checkeObArtikelExistiert()) {
            System.out.println("Noch existiert kein Artikel");

        } else {
            System.out.println("Welche Menge soll dazugebucht werden? ");
            int menge = input.nextInt();
            artikel.bucheZugang(menge);
            System.out.println("Der neue Bestand des Artikels: " + artikel.getBestand());
        }    
    }
    
     /**
    * Fragt nach einer Menge und bucht diese dann dem Bestand des Artikels ab
    */
     public void bestandAbbuchen() {
        if (!checkeObArtikelExistiert()) {
            System.out.println("Noch existiert kein Artikel");

        } else {
            System.out.println("Welche Menge soll abgebucht werden? ");
            int menge = input.nextInt();
            artikel.bucheAbgang(menge);
            System.out.println("Der neue Bestand des Artikels: " + artikel.getBestand());

        }    
    }
    
    /**
    * Fragt nach der neuen Artikelart und überschreibt damit die alte Artikelart
    */
    public void artikelartAendern() {
        if (!checkeObArtikelExistiert()) {
            System.out.println("Noch existiert kein Artikel");

        } else {
            System.out.println("Neue Artikelart? ");
            String art = input.nextLine();
            artikel.setArt(art);
            System.out.println("Die neue Artikelart ist: " + artikel.getArt());

        }        
        
    }
    
    /**
    * Gibt den Artikel aus
    */
    public void artikelAusgeben() {
        if (!checkeObArtikelExistiert()) {
            System.out.println("Noch existiert kein Artikel");

        } else {
            System.out.println(artikel);

        }          
    }

     
    public static void main(String[] args) {
        ArtikelDialog artikeldialog = new ArtikelDialog();
        artikeldialog.start();
        
    }
}
