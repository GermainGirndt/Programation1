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
    private int getraenkArt;
    private Scanner input;
    private GetraenkeAutomat automat;

    private static final int FUNKTION_NICHT_DEFINIERT        = -1;
    private static final int FUNKTION_ENDE                   = 0;
    private static final int FUNKTION_AUTOMAT_ANLEGEN        = 1;
    private static final int FUNKTION_FLASCHE_EINGEBEN       = 2;
    private static final int FUNKTION_FLASCHE_AUSGEBEN       = 3;
    private static final int FUNKTION_AUTOMAT_AUSGEBEN       = 4;
    
    private static final int AUTOMAT_GETRAENK                = 1;
    private static final int AUTOMAT_ALKOHOLFREIESGETRAENK   = 2;
    private static final int AUTOMAT_SOFTDRINK               = 3;
    private static final int AUTOMAT_WASSER                  = 4;
    private static final int AUTOMAT_ALKOHOLISCH             = 5;
    private static final int AUTOMAT_BIER                    = 6;
    private static final int AUTOMAT_WEIN                    = 7;
    private static final int AUTOMAT_WEISSWEIN               = 8;
    private static final int AUTOMAT_ROTWEIN                 = 9;
  

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
            FUNKTION_AUTOMAT_AUSGEBEN       + ": Getraenkeautomatausgeben;\n" +
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
             case FUNKTION_AUTOMAT_AUSGEBEN:
                 if(automat!= null){
                     System.out.println(automat.toString());    
                 }
                
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
            AUTOMAT_WEISSWEIN                + ": Getraenkeautomat fuer Weisswein anlegen;\n"  + 
            AUTOMAT_ROTWEIN                  + ": Getraenkeautomat fuer Rotwein anlegen;\n"  + 
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
            case AUTOMAT_WEISSWEIN:
                automat = new GetraenkeAutomat<Weisswein>(kapazitaet);
                break;
            case AUTOMAT_ROTWEIN:
                automat = new GetraenkeAutomat<Rotwein>(kapazitaet);
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
        Getraenk getraenk = new Wasser();
        
        String bezeichnung;
        String hersteller;
        float alkoholgehalt;
        if(automat != null){
            
            switch(this.art) {
            case AUTOMAT_GETRAENK:         
                    System.out.print(
                    "\n\n" +
                    "1: "    + "Softdrink" + "\n" +
                    "2: "    + "Wasser" + "\n" +
                    "3: "    + "Bier" + "\n" +
                    "4: "    + "Wein" + "\n" +
                    "5: "    + "Weisswein" + "\n" +
                    "6: "    + "Rotwein" + "\n" 
                    );
        
                    System.out.println("Ausgewählte Funktion: ");
                    this.getraenkArt = input.nextInt();
                    input.nextLine();
                    System.out.println();  
                    
                    
                    switch(this.getraenkArt){
                        case 1:
                            getraenk = erstelleSoftDrink();
                            break;
                        case 2:
                            getraenk = erstelleWasser();
                            break;
                        case 3:
                            getraenk = erstelleBier();
                            break;
                        case 4:
                            getraenk = erstelleWein(); 
                            break;
                        case 5:
                            getraenk = erstelleWeissWein();
                            break;
                        case 6:
                            getraenk = erstelleRotWein();
                            break;
                            }
                       
                        Flasche<Getraenk>  fgetraenk = new Flasche<Getraenk>();
                        fgetraenk.fuellen(getraenk);
                        automat.flascheEinlegen(fgetraenk);
                        break;  
            case AUTOMAT_ALKOHOLFREIESGETRAENK:
                    System.out.print(
                    "\n\n" +
                    "1: "    + "Softdrink" + "\n" +
                    "2: "    + "Wasser" + "\n" 
                    );
        
                    System.out.println("Ausgewählte Funktion: ");
                    this.getraenkArt = input.nextInt();
                    input.nextLine();
                    System.out.println();  
                    
                    switch(this.getraenkArt){
                        case 1:
                            getraenk = erstelleSoftDrink();
                            break;
                        case 2:
                            getraenk = erstelleWasser();
                            break;
                        
                    }
                    
                     Flasche<AlkoholfreiesGetraenk>  falkfrei = new Flasche<AlkoholfreiesGetraenk>();
                     falkfrei.fuellen((AlkoholfreiesGetraenk)getraenk);
                     automat.flascheEinlegen(falkfrei);
                    break; 
            case AUTOMAT_SOFTDRINK:
                    getraenk = erstelleSoftDrink();
                    Flasche<Softdrink>  fsoft = new Flasche<Softdrink>();
                    fsoft.fuellen((Softdrink)getraenk);
                    automat.flascheEinlegen( fsoft);
                    break; 
              
            case AUTOMAT_WASSER:
                    getraenk = erstelleWasser();
                    Flasche<Wasser>  fwasser = new Flasche<Wasser>();
                    fwasser.fuellen((Wasser)getraenk);
                    automat.flascheEinlegen( fwasser); 
                    break; 
            case AUTOMAT_ALKOHOLISCH:
                System.out.print(
                    "\n\n" +
                    "1: "    + "Bier" + "\n" +
                    "2: "    + "Wein" + "\n" +
                    "3: "    + "Weisswein" + "\n" +
                    "4: "    + "Rotwein"   
                    );
        
                    System.out.println("Ausgewählte Funktion: ");
                    this.getraenkArt = input.nextInt();
                    input.nextLine();
                    System.out.println();  
                    switch(this.getraenkArt){
                        case 1:
                            getraenk = erstelleBier();
                            break;
                        case 2:
                            getraenk = erstelleWein();   
                            break;
                        case 3:
                            getraenk = erstelleWeissWein();
                            break;
                        case 4:
                            getraenk = erstelleRotWein();
                            break;
                         
                    }
                    Flasche<AlkoholischesGetraenk>  falk = new Flasche<AlkoholischesGetraenk>();
                    falk.fuellen((AlkoholischesGetraenk)getraenk);
                    automat.flascheEinlegen(falk);
                    break; 
             
            case AUTOMAT_BIER:
                    getraenk = erstelleBier();
                    Flasche<Bier>  fbier = new Flasche<Bier>();
                    fbier.fuellen((Bier)getraenk);
                    automat.flascheEinlegen(fbier);
                    break; 
              
            case AUTOMAT_WEIN:
                    System.out.print(
                    "\n\n" +
                    "1: "    + "Wein" + "\n" +
                    "2: "    + "Weisswein" + "\n" +
                    "3: "    + "Rotwein"   
                    );
        
                    System.out.println("Ausgewählte Funktion: ");
                    this.getraenkArt = input.nextInt();
                    input.nextLine();
                    System.out.println();  
                    switch(this.getraenkArt){
                        case 1:
                            getraenk = erstelleWein();   
                            break;
                        case 2:
                            getraenk = erstelleWeissWein();
                            break;
                        case 3:
                            getraenk = erstelleRotWein();
                            break;
                         
                    }
                    Flasche<Wein>  fwein = new Flasche<Wein>();
                    fwein.fuellen((Wein)getraenk);
                    automat.flascheEinlegen(fwein);
                    break; 
            case AUTOMAT_WEISSWEIN:
                    getraenk = erstelleWeissWein();
                    Flasche<Weisswein>  fwwein = new Flasche<Weisswein>();
                    fwwein.fuellen((Weisswein)getraenk);
                    automat.flascheEinlegen(fwwein);
                    break;
             case AUTOMAT_ROTWEIN:
                    getraenk = erstelleRotWein();
                    Flasche<Rotwein>  frwein = new Flasche<Rotwein>();
                    frwein.fuellen((Rotwein)getraenk);
                    automat.flascheEinlegen(frwein);
                    break;
            }   
            
        }
    }
    
   private Softdrink erstelleSoftDrink(){
        
            System.out.println("Geben Sie die Bezeichnung an:");
            String bezeichnung = input.nextLine();    
            System.out.println("Geben Sie den Hersteller an:");
            String hersteller = input.nextLine();  
            System.out.println("Geben Sie den Zuckergehalt an:");
            String zuckergehalt = input.nextLine();    
            return new Softdrink(bezeichnung, hersteller, zuckergehalt);
   }
   
   private Wasser erstelleWasser(){
        
            System.out.println("Geben Sie die Bezeichnung an:");
            String bezeichnung = input.nextLine();    
            System.out.println("Geben Sie den Hersteller an:");
            String hersteller = input.nextLine();  
            System.out.println("Geben Sie die Quelle an:");
            String quelle = input.nextLine();    
            return new Wasser(bezeichnung, hersteller, quelle);
   }
   
   private Bier erstelleBier(){
        
            System.out.println("Geben Sie die Bezeichnung an:");
            String bezeichnung = input.nextLine();    
            System.out.println("Geben Sie den Alkoholgehalt an:");
            float alkoholgehalt = input.nextFloat();  
            input.nextLine();
            System.out.println("Geben Sie die Brauerei an:");
            String brauerei = input.nextLine();    
            return new Bier(bezeichnung, alkoholgehalt, brauerei);
   }
   
   private Wein erstelleWein(){
        
            System.out.println("Geben Sie die Bezeichnung an:");
            String bezeichnung = input.nextLine();    
            System.out.println("Geben Sie den Alkoholgehalt an:");
            float alkoholgehalt = input.nextFloat();  
            input.nextLine();
            System.out.println("Geben Sie das Weingut an:");
            String weingut = input.nextLine();    
            return new Wein(bezeichnung, alkoholgehalt, weingut);
   }
   
   private Weisswein erstelleWeissWein(){
        
            System.out.println("Geben Sie die Bezeichnung an:");
            String bezeichnung = input.nextLine();    
            System.out.println("Geben Sie den Alkoholgehalt an:");
            float alkoholgehalt = input.nextFloat();  
             input.nextLine();
            System.out.println("Geben Sie das Weingut an:");
            String weingut = input.nextLine();    
            return new Weisswein(bezeichnung, alkoholgehalt, weingut);
   }
   
   private Rotwein erstelleRotWein(){
        
            System.out.println("Geben Sie die Bezeichnung an:");
            String bezeichnung = input.nextLine();    
            System.out.println("Geben Sie den Alkoholgehalt an:");
            float alkoholgehalt = input.nextFloat();  
            input.nextLine();
            System.out.println("Geben Sie das Weingut an:");
            String weingut = input.nextLine();    
            return new Rotwein(bezeichnung, alkoholgehalt, weingut);
   }
}
