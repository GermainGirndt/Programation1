import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Beschreiben Sie hier die Klasse Dialog.
 * 
 * @author Girndt, Germain; Krier, Katharina 
 * @version 1.0
 */
public class TestDialog {
    private int funktion;
    private Scanner input;
    private float[] numbers;

    AbstractNumberCruncher numberCruncherTopLevel;
    AbstractNumberCruncher numberCruncherAnonym;

    private static final int FUNKTION_NICHT_DEFINIERT        = -2;
    private static final int FUNKTION_ENDE                   = -1;
    private static final int FUNKTION_MANUELL_EINGEBEN       = 1;
    private static final int FUNKTION_AUTOMATISCH_BEFUELLEN  = 2; 
    
    public TestDialog() {
         this.input = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
        TestDialog dialog = new TestDialog();
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
            FUNKTION_MANUELL_EINGEBEN              + ": Manuell eingeben;\n"  +
            FUNKTION_AUTOMATISCH_BEFUELLEN         + ": Automatisch befuellen;\n"  + 
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
            case FUNKTION_MANUELL_EINGEBEN:
                gebeeinManuell();
                break;  
            case FUNKTION_AUTOMATISCH_BEFUELLEN:
                befuelleAutomatisch();
                break;
            case FUNKTION_ENDE:  
                System.out.println("Das Programm ist zu Ende");
                break;
            default:
                System.out.println("Keine gueltige Eingabe");
                break;
            }

            this.numberCruncherTopLevel = new NumberCruncherTopLevel(this.numbers);
            this.numberCruncherAnonym = new NumberCruncherAnonym(this.numbers);

            
            while(this.funktion != FUNKTION_ENDE) {

                try {
                    System.out.println("Geben Sie die gewuenschten mit Komma getrennten Operations ein: (-1 = Ende)");
                    
                    String[] operations = input.nextLine().split(",");
                    System.out.println("Angegebene Operations: ");

                    for (String operation : operations) {

                        System.out.println(operation);
                    }
                    numberCruncherTopLevel.crunch(operations);

                    float[] numbersTopLevel = numberCruncherTopLevel.getNumbers();

                    System.out.println("TopLevel: ");
                    for (float number : numbersTopLevel) {
                        System.out.print("" + number + " ");
                    }
                    
                    System.out.println();
                    numberCruncherAnonym.crunch(operations);
                    System.out.println("Anonym: ");
                    float[] numbersAnonym = numberCruncherAnonym.getNumbers();
                    for (float number : numbersAnonym) {
                        System.out.print("" + number + " ");
                    }
                    System.out.println();

                } catch (NumberCruncherException e) {
                    System.err.println(e);
                    
                }
            }

        

    }
    
    /**
    * Diese Funktion erfragt Daten zu einem Mitarbeiter und legt dann einen Mitarbeiter an
    */
    private void gebeeinManuell() {
        System.out.println("Geben Sie die Zahlen wie in Format im Beispiel: 1.25, 133.0, 5.489");
        String zahlen = input.nextLine();
        String[] zahlenArray = zahlen.split(",");
        this.numbers = new float[zahlenArray.length];

        try {
            for (int i = 0; i < zahlenArray.length; i++) {
                this.numbers[i] = Float.parseFloat(zahlenArray[i]);
            } 
        } catch (NumberFormatException e) {
            throw new DialogException("Geben Sie die Zahlen wie in Format im Beispiel: 1.25, 133.0, 5.489");
        }
        
    }
    
    /**
    * Diese Funktion erfragt Daten zu einem Raum und legt dann einen Raum an
    */
    private void befuelleAutomatisch() {

        Random r = new Random();

        System.out.println("Geben Sie ein, wie viele Zahlen gewuenscht sind: ");
        
        int zahlen = Integer.parseInt(input.nextLine());
        
        this.numbers = new float[zahlen];
        for (int i = 0; i < zahlen; i++) {
            float number = (float) r.nextInt(100) + r.nextFloat();
            this.numbers[i] = number;
        }
    }
  
}
