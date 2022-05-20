import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Beschreiben Sie hier die Klasse GetraenkeAutomatDialog.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class GetraenkeAutomatDialog
{
    private int funktion;
    private int art;
    private Scanner input;
    private GetraenkeAutomat automat;

   

    private static final int FUNKTION_NICHT_DEFINIERT        = -1;
    private static final int FUNKTION_ENDE                   = 0;
    private static final int FUNKTION_AUTOMAT_ANLEGEN        = 1;
    private static final int FUNKTION_FLASCHE_EINGEBEN       = 2;
    private static final int FUNKTION_FLASCHE_AUSGEBEN       = 3;
    
    private static final int AUTOMAT_GETRAENK                = 1;
    private static final int AUTOMAT_ALKOHOLFREIESGETRAENK   = 2;
    private static final int AUTOMAT_SOFTDRINK               = 3;
    private static final int AUTOMAT_WASSER                  = 4;
    private static final int AUTOMAT_ALKOHOLISCH             = 5;
    private static final int AUTOMAT_BIER                    = 6;
    private static final int AUTOMAT_WEIN                    = 7;
  

    /**
     * Konstruktor für Objekte der Klasse GetraenkeAutomatDialog
     */
    public GetraenkeAutomatDialog()
    {
         this.input = new Scanner(System.in);    
    }
    
     public static void main(String[] args) {
        GetraenkeAutomatDialog dialog = new GetraenkeAutomatDialog();
        dialog.start();
        
    }
    
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
            FUNKTION_AUTOMAT_ANLEGEN        + ": Getraenkeautomat anlegen;\n"  + 
            FUNKTION_FLASCHE_EINGEBEN       + ": Flasche eingeben;\n" +
            FUNKTION_FLASCHE_AUSGEBEN       + ": Flasche ausgeben;\n"  + 
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
            case FUNKTION_AUTOMAT_ANLEGEN:
                automatAnlegen();
                break;  
            case FUNKTION_FLASCHE_EINGEBEN:
                flascheEingeben();
                break;  
            case FUNKTION_FLASCHE_AUSGEBEN:
                flascheAusgeben();
                break;  
            case FUNKTION_ENDE:  
                System.out.println("Das Programm ist zu Ende");
                break;
            default:
                System.out.println("Keine gueltige Eingabe");
                break;
            }
            
        }
        
    private void automatAnlegen(){
        this.art = -1;
          
            try {
                getraenkeAutomatArtEinlesen();
                anlegenAutomatArt();
                
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
    
    private void getraenkeAutomatArtEinlesen(){
        System.out.print(
            "\n\n" +
            AUTOMAT_GETRAENK                 + ": Getraenkeautomat fuer alle Getraenke anlegen;\n"  + 
            AUTOMAT_ALKOHOLFREIESGETRAENK    + ": Getraenkeautomat fuer alkoholfreie Getraenke anlegen;\n"  + 
            AUTOMAT_SOFTDRINK                + ": Getraenkeautomat fuer Sofdrinks anlegen;\n"  + 
            AUTOMAT_WASSER                   + ": Getraenkeautomat fuer alle Wasser anlegen;\n"  + 
            AUTOMAT_ALKOHOLISCH              + ": Getraenkeautomat fuer alkoholische Getraenke anlegen;\n"  + 
            AUTOMAT_BIER                     + ": Getraenkeautomat fuer Bier anlegen;\n"  + 
            AUTOMAT_WEIN                     + ": Getraenkeautomat fuer Wein anlegen;\n"  + 
            FUNKTION_ENDE                    + ": beenden -> \n\n"
        );
        
        System.out.println("Ausgewählte Funktion: ");
        this.art = input.nextInt();
        input.nextLine();
        System.out.println();    
    }
    
    private void anlegenAutomatArt(){
        int kapazitaet = 0;
        
        if(this.art != 0){
            System.out.println("Geben Sie die max. Kapazitaet des Automaten an:");
            kapazitaet = input.nextInt();    
        }
        
        switch(this.art) {
            case AUTOMAT_GETRAENK:
                automat = new GetraenkeAutomat<Getraenk>(kapazitaet);
                break;  
            case AUTOMAT_ALKOHOLFREIESGETRAENK:
                automat = new GetraenkeAutomat<AlkoholfreiesGetraenk>(kapazitaet);
                break; 
            case AUTOMAT_SOFTDRINK:
                automat = new GetraenkeAutomat<Softdrink>(kapazitaet);
                break; 
            case AUTOMAT_WASSER:
                automat = new GetraenkeAutomat<Wasser>(kapazitaet);
                break; 
            case AUTOMAT_ALKOHOLISCH:
                automat = new GetraenkeAutomat<AlkoholischesGetraenk>(kapazitaet);
                break; 
            case AUTOMAT_BIER:
                automat = new GetraenkeAutomat<Bier>(kapazitaet);
                break;   
            case AUTOMAT_WEIN:
                automat = new GetraenkeAutomat<Wein>(kapazitaet);
                break; 
            case FUNKTION_ENDE:  
                System.out.println("Die Schleife ist zu Ende");
                break;
            default:
                System.out.println("Keine gueltige Eingabe");
                break;
            }    
    }
    
    private void flascheAusgeben(){
        if(automat != null){
            Flasche flasche = automat.flascheAusgeben();
         
            System.out.println(flasche.toString());    
           
        }
    }
    
     private void flascheEingeben(){
        if(automat != null){
            switch(this.art) {
            case AUTOMAT_GETRAENK:
                
                break;  
            case AUTOMAT_ALKOHOLFREIESGETRAENK:
               
                break; 
            case AUTOMAT_SOFTDRINK:
               
                break; 
            case AUTOMAT_WASSER:
                
                break; 
            case AUTOMAT_ALKOHOLISCH:
               
                break; 
            case AUTOMAT_BIER:
               
                break;   
            case AUTOMAT_WEIN:
          
                break; 
         
            }       
           
        }
    }
}
