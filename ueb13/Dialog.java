import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Beschreiben Sie hier die Klasse Dialog.
 * 
 * @author Girndt, Germain; Krier, Katharina 
 * @version 1.0
 */
public class Dialog
{
    private int funktion;
    private Scanner input;
    private Raum[] raeume;
    private Mitarbeiter[] mitarbeiter;
    private int anzahlMitarbeiter = 0;
    private int anzahlRaeume = 0;

    private static final int MAX_ANZAHL               = 10;
    private static final int FUNKTION_NICHT_DEFINIERT = -2;
    private static final int FUNKTION_ENDE            = -1;
    private static final int FUNKTION_MITARBEITER     = 1;
    private static final int FUNKTION_RAUM            = 2; 
    private static final int FUNKTION_RESERVIERUNG    = 3; 
    
    public Dialog() {
         this.raeume = new Raum[MAX_ANZAHL];
         this.mitarbeiter = new Mitarbeiter[MAX_ANZAHL];
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
            FUNKTION_RESERVIERUNG           + ": Reservierung anlegen;\n"  + 
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
        switch(this.funktion) {
            case FUNKTION_MITARBEITER:
                legeMitarbeiterAn();
                break;
            case FUNKTION_RAUM:
                legeRaumAn();
                break;
            case FUNKTION_RESERVIERUNG:
                legeReservierungAn();
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
    * Diese Funktion erfragt Daten zu einem Mitarbeiter und legt dann einen Mitarbeiter an
    */
    private void legeMitarbeiterAn() {
        System.out.println("Vorname des Mitarbeiters?");
        String vorname = input.nextLine();
        System.out.println("Nachname des Mitarbeiters?");
        String nachname = input.nextLine();
        System.out.println("Email des Mitarbeiters?");
        String email    = input.nextLine();
        Mitarbeiter mitarbeiter = new Mitarbeiter(vorname, nachname, email);  
        if (anzahlMitarbeiter < this.mitarbeiter.length ) {
            this.mitarbeiter[anzahlMitarbeiter] = mitarbeiter;
            this.anzahlMitarbeiter++;
        }
        else {
            System.out.println("Mitarbeiterliste ist voll");
        }
    }
    
    /**
    * Diese Funktion erfragt Daten zu einem Raum und legt dann einen Raum an
    */
    private void legeRaumAn() {

        System.out.println("Gebaeude des Raums?");
        int geb = input.nextInt();
        System.out.println("Etage des Raums?");
        int etage = input.nextInt();
        System.out.println("Raumnummer des Raums?");
        int raumnummer    = input.nextInt();
        Raum raum = new Raum(geb, etage, raumnummer);
        if (anzahlRaeume < this.raeume.length ) {
            this.raeume[anzahlRaeume] = raum;
            this.anzahlRaeume++;
        }
        else {
            System.out.println("Raumliste ist voll");
        }
        
    }
    
    /**
    * Diese Funktion erfragt Daten zu einer Reservierung und legt dann eine Reservierung an
    */
    private void legeReservierungAn() {
        int m   = auswaehlen(anzahlMitarbeiter, true);     
        if (m > -1) {
           int r = auswaehlen(anzahlRaeume, false);
           if ( r > -1) {
               Mitarbeiter mita = mitarbeiter[m];
               Raum raum = raeume[r];
               System.out.println("Stunde Anfang?");
               int stundeAn = input.nextInt();
               input.nextLine();
               System.out.println("Minute Anfang?");
               int minuteAn = input.nextInt();
               input.nextLine();
               System.out.println("Stunde Ende?");
               int stundeEn = input.nextInt();
               input.nextLine();
               System.out.println("Minute Ende?");
               int minuteEn = input.nextInt();
               input.nextLine();
               System.out.println("Bemerkung?");
               String bemerkung = input.nextLine();
               
               Uhrzeit anfang = new Uhrzeit(stundeAn, minuteAn);
               Uhrzeit ende = new Uhrzeit(stundeEn, minuteEn);
               mita.reserviere(raum, anfang, ende, bemerkung);
               System.out.println(raum.toString());
           }
        }
    }
    
    /**
    * Diese Funktion lässt einen einen Mitarbeiter oder einen Raum aus der Liste auswählen
    * @param anzahl ist die Anzahl von Mitarbeitern oder Raeumen
    * @param istmitarbeiter ist ob die Mitarbeiterliste oder die Raumliste benutzt wird
    * @return ist der Index des ausgewaehlten Mitarbeiters oder Raumes
    */
    private int auswaehlen(int anzahl, boolean istmitarbeiter) {
        int funktion =  FUNKTION_NICHT_DEFINIERT;
        while(funktion != FUNKTION_ENDE) {
        try {
                if (istmitarbeiter) {
                    for (int i = 0; i < anzahl; i++) {
                        System.out.println("--------------" );
                        System.out.println("Welcher Mitarbeiter moechte den Raum buchen?" );
                        System.out.println(mitarbeiter[i].toString() + "\t" + i + "\n" );
                    }
                }
                else {
                    for (int i = 0; i < anzahl; i++) {
                        System.out.println("--------------" );
                        System.out.println("Welcher Raum soll gebucht werden?" );
                        System.out.println(raeume[i].toString() + "\t" + i + "\n" );
                    }
                }
                System.out.println("Auswahl beenden: \t-1");
                
                System.out.println("Ausgewählte Funktion: ");
                funktion = input.nextInt();
                input.nextLine();
                System.out.println();
                
                if (funktion > -1 && funktion < anzahl) {
                    return funktion;
                } else if (funktion == -1) {
                     System.out.println("Auswahl wird abgebrochen");    
                } else {
                    System.out.println("Keine gueltige Eingabe");  
                }
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
        return -1;
    }
    
  
}
