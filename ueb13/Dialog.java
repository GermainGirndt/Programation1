import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Beschreiben Sie hier die Klasse Dialog.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Dialog
{
    private int funktion;
    private Scanner input;
    private Raum[] raeume;
    private Mitarbeiter[] mitarbeiter;
    private int anzahlMitarbeiter = 0;
    
    private static final int FUNKTION_NICHT_DEFINIERT = -1;
    private static final int FUNKTION_ENDE            = 0;
    private static final int FUNKTION_MITARBEITER     = 1;
    private static final int FUNKTION_RAUM            = 2; 
    
    public Dialog(){
         this.raeume = new Raum[10];
         this.mitarbeiter = new Mitarbeiter[10];
         this.input = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
        Dialog dialog = new Dialog();
        dialog.start();
        
    }

    /**
    * Hauptschleife der Artikeldialog Klasse
    */
    public void start() {
 
        this.funktion        = FUNKTION_NICHT_DEFINIERT;
        
        while(this.funktion != FUNKTION_ENDE) {
            try {
                einlesenFunktion();
                ausfuehrenFunktion();
                
            } catch(IllegalArgumentException error) {
                System.err.println(error);

            } catch(InputMismatchException error) {
                System.err.println(error);
                input.next();

            } catch(Exception error) {
                System.err.println(error);
                error.printStackTrace(System.out); 

            }
        }
    }
    
    /**
    * Diese Funktion liest ein welche Funktion ausgefuehrt werden soll
    * @return funktion die ausgewaehlt wurde
    */
    private void einlesenFunktion() {
        
        System.out.print(
            "\n\n" +
            FUNKTION_MITARBEITER            + ": Mitarbeiter anlegen;\n"  +
            FUNKTION_RAUM                   + ": Raum anlegen;\n"  + 
            FUNKTION_ENDE                   + ": beenden -> \n\n"
        );
        
        System.out.println("Ausgewählte Funktion: ");
        this.funktion = input.nextInt();
        input.nextLine();
        System.out.println();
    }
    
    /**
    * Diese Funktion fuehrt je nach Parameter die dazugehoerige Funktion aus
    * @param funktion die ausgefuehrt werden soll
    */
    private void ausfuehrenFunktion() {
        boolean sollNachBestandFragen;

        switch(this.funktion) {
            case FUNKTION_MITARBEITER:
                legeMitarbeiterAn();
                break;
            case FUNKTION_RAUM:
                legeRaumAn();
                break;
            case FUNKTION_ENDE:  
                System.out.println("Das Programm ist zu Ende");
                break;
            default:
                System.out.println("Keine gueltige Eingabe");
                break;
        }

    }
    
    private void legeMitarbeiterAn(){
        System.out.println("Vorname des Mitarbeiters?");
        String vorname = input.nextLine();
        System.out.println("Nachname des Mitarbeiters?");
        String nachname = input.nextLine();
        System.out.println("Email des Mitarbeiters?");
        String email    = input.nextLine();
        Mitarbeiter mitarbeiter = new Mitarbeiter(vorname, nachname, email);  
        if(anzahlMitarbeiter < this.mitarbeiter.length ){
            this.mitarbeiter[anzahlMitarbeiter] = mitarbeiter;
            this.anzahlMitarbeiter++;
        }
        else{
            System.out.println("Mitarbeiterliste ist voll");
        }
    }
    
    private void legeRaumAn(){

        System.out.println("Gebaeude des Raums?");
        int geb = input.nextInt();
        System.out.println("Etage des Raums?");
        int etage = input.nextInt();
        System.out.println("Raumnummer des Raums?");
        int raumnummer    = input.nextInt();
        Raum raum = new Raum(geb, etage, raumnummer);
        
        
    }
}
