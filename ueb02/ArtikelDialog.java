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
    private Artikel     artikel;
    private Scanner     input;
    
    private static final int    ANLEGEN_MIT_BESTAND    = 1;
    private static final int    ANLEGEN_OHNE_BESTAND   = 2;
    private static final int    BESTAND_ZUBUCHEN       = 3;
    private static final int    BESTAND_ABBUCHEN       = 4;
    private static final int    ARTIKELART_AENDERN     = 5;
    private static final int    ARTIKEL_AUSGEBEN       = 6;
    private static final int    ENDE                   = 0;
    
    
     /**
    * Konstruktor
    */
    public ArtikelDialog(){
        input = new Scanner(System.in);
    }
    
    /**
    * Hauptschleife der Artikeldialog Klasse
    */
    public void start(){
        artikel      = null;
        int funktion = -1;
        
        while(funktion != 0){
            try {
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            } catch(IllegalArgumentException error){
                System.out.println(error);
                input.nextLine(); 
            } catch(InputMismatchException error){
                System.out.println(error);
                input.nextLine();   
            } catch(Exception error){
                System.out.println(error);
                error.printStackTrace(System.out);   
            }
        }
    }
    
    /**
    * Diese Funktion liest ein welche Funktion ausgefuehrt werden soll
    * @return funktion die ausgewaehlt wurde
    */
    public int einlesenFunktion(){
        int funktion;
        
        System.out.print(
            ANLEGEN_MIT_BESTAND    + ": Artikel mit Bestand anlegen;\n"  + 
            ANLEGEN_OHNE_BESTAND   + ": Artikel ohne Bestand anlegen;\n" + 
            BESTAND_ZUBUCHEN       + ": Menge zum Bestand dazubuchen;\n" +
            BESTAND_ABBUCHEN       + ": Menge vom Bestand abbuchen;\n"   + 
            ARTIKELART_AENDERN     + ": Artikelart aendern;\n"           +
            ARTIKEL_AUSGEBEN       + ": Artikel ausgeben;\n"             + 
            ENDE                   + ": beenden -> "
        );
        
        funktion = input.nextInt();
        input.nextLine();
        
        return funktion;
    }
    
    /**
    * Diese Funktion führt je nach Parameter die dazugehoerige Funktion aus
    * @param funktion die ausgeführt werden soll
    */
    public void ausfuehrenFunktion(int funktion){
        switch(funktion){
            case ANLEGEN_MIT_BESTAND:    
                artikelMitBestandAnlegen();
                break;
            case ANLEGEN_OHNE_BESTAND:
                artikelOhneBestandAnlegen();
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
        if(artikel!=null){
            System.out.println(artikel);
        }
    }
    
    /**
    * Legt einen Artikel mit Bestand an und erfragt alle nötigen Parameter
    */
    public void artikelMitBestandAnlegen(){
        if(artikel != null) {
            System.out.println("Der Artikel existiert schon.");
        } else {
            System.out.print("Artikelnummer: ");
            int artikelNr = input.nextInt();
            input.nextLine();
            
            System.out.print("Artikelart: ");
            String art = input.nextLine();
            
            System.out.print("Bestand: ");
            int bestand = input.nextInt();
            
            artikel = new Artikel(artikelNr , art , bestand);
        }
    }
    
    /**
    * Legt einen Artikel ohne Bestand an und erfragt alle nötigen Parameter
    */
    public void artikelOhneBestandAnlegen(){
        if(artikel != null) {
            System.out.println("Der Artikel existiert schon.");
        } else {
            System.out.print("Artikelnummer: ");
            int artikelNr = input.nextInt();
            input.nextLine();
            
            System.out.print("Artikelart: ");
            String art = input.nextLine();
            
            artikel = new Artikel(artikelNr , art);
        }
    }
    
    /**
    * Fragt nach einer Menge und bucht diese dann dem Bestand des Artikels zu
    */
    public void bestandZubuchen(){
        if(artikel == null) {
            System.out.println("Noch existiert kein Artikel");
        }else{
            System.out.println("Welche Menge soll dazugebucht werden? ");
            int menge = input.nextInt();
            artikel.bucheZugang(menge);
            System.out.println("Der neue Bestand des Artikels: " + artikel.getBestand());
        }    
    }
    
     /**
    * Fragt nach einer Menge und bucht diese dann dem Bestand des Artikels ab
    */
     public void bestandAbbuchen(){
        if(artikel == null) {
            System.out.println("Noch existiert kein Artikel");
        }else{
            System.out.println("Welche Menge soll abgebucht werden? ");
            int menge = input.nextInt();
            artikel.bucheAbgang(menge);
            System.out.println("Der neue Bestand des Artikels: " + artikel.getBestand());
        }    
    }
    
    /**
    * Fragt nach der neuen Artikelart und überschreibt damit die alte Artikelart
    */
    public void artikelartAendern(){
        if(artikel == null) {
            System.out.println("Noch existiert kein Artikel");
        }else{
            System.out.println("Neue Artikelart? ");
            String art = input.nextLine();
            artikel.setArt(art);
            System.out.println("Die neue Artikelart ist: " + artikel.getArt());
        }        
        
    }
    
    /**
    * Gibt den Artikel aus
    */
    public void artikelAusgeben(){
        if(artikel == null) {
            System.out.println("Noch existiert kein Artikel");
        }else{
            System.out.println(artikel);
        }          
    }

     
    public static void main(String[] args){
        ArtikelDialog artikeldialog = new ArtikelDialog();
        artikeldialog.start();
        
    }
}
