import java.util.InputMismatchException;

/**
 * Die Klasse MathFunctionsDialog ist eine Dialogklasse zum Testen der Klasse MathFunctions
 * 
 * @author Girndt & Krier 
 * @version 1.0
 */
public class MathFunctionsDialog
{
    private              UserInput      userInput;
    private              int            funktion;
    
    private static final int            FUNKTION_NICHT_DEFINIERT   = -1;
    private static final int            FUNKTION_ENDE              =  0;
    private static final int            BERECHNE_TEILER_SUMME      =  1;
    private static final int            BERECHNE_CHECKSUMME_ISBN   =  2;
    private static final int            BERECHNE_NULLSTELLEN       =  3;
    private static final int            PRUEFE_OB_POTENZSUMME      =  4;
    private static final int            BERECHNE_GGT               =  5;
    private static final int            BERECHNE_REIHENSUMME       =  6;
    private static final int            BERECHNE_FAKULTAET         =  7;
    
    
    /**
    * Konstruktor
    */
    public MathFunctionsDialog() {
        userInput = new UserInput();
    }
    
    public static void main(String[] args) {
        MathFunctionsDialog mathfunctionDialog = new MathFunctionsDialog();
        mathfunctionDialog.start();   
    }

    /**
    * Hauptschleife der MathFunctionsDialog Klasse
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
                userInput.next();

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
    public void einlesenFunktion() {
        
        System.out.print(
            "\n\n" +
            BERECHNE_TEILER_SUMME      + ": Berechne die Teilersumme einer Zahl;\n"  + 
            BERECHNE_CHECKSUMME_ISBN   + ": Berechne die Checksumme einer ISBN-Nummer;\n" + 
            BERECHNE_NULLSTELLEN       + ": Berechne die Nullstellen einer quadratischen funktion;\n" +
            PRUEFE_OB_POTENZSUMME      + ": Prueft ob eine Zahl als Summe von Potenzen geschrieben werden kann;\n" +
            BERECHNE_GGT               + ": Berechne den groessten gemeinsamen Teiler zweier Zahlen;\n" +
            BERECHNE_REIHENSUMME       + ": Berechne die Reihensumme von der Funktion Sn(anzahl, x), Σ von i=1 bis n = anzahl von ((x - 1)^i)/i*x^i;\n" +
            BERECHNE_FAKULTAET         + ": Berechne die Fakultaet von einer beliebigen ganzen Zahl von 0 bis 20;\n" +
            FUNKTION_ENDE              + ": beenden -> \n\n"
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
            case BERECHNE_TEILER_SUMME:
                berechneTeilersumme();
                break;
            case  BERECHNE_CHECKSUMME_ISBN:
                berechneChecksummeIsbn();
                break;
            case BERECHNE_NULLSTELLEN:      
                berechneNullstellen();
                break;
            case PRUEFE_OB_POTENZSUMME:      
                pruefeObPotenzsumme();
                break;
            case BERECHNE_GGT:
                berechneGgt();
                break;
            case BERECHNE_REIHENSUMME:
                berechneReihensumme();
                break;
            case BERECHNE_FAKULTAET:
                berechneFakultaet();
                break;
            case FUNKTION_ENDE:  
                System.out.println("Das Programm ist zu Ende");
                break;
            default:
                throw new IllegalArgumentException("Keine gueltige Eingabe");
        }
    }

    /**
    *  Erfragt eine Zahl und bildet dann deren Teilersumme
    */
    public void berechneTeilersumme() {
            long zahl = userInput.getLong("Zahl: ");
            System.out.println("Teilersumme: " + MathFunctions.berechneTeilersumme(zahl));
        }
    
    /**
    *  Erfragt eine ISBN und bildet dann die Checksumme
    */    
    public void berechneChecksummeIsbn() {
            String isbn = userInput.getString("ISBN: ");
            Validierung.validiereZeichenAnzahl(isbn);
            System.out.println("Checksumme: " + MathFunctions.berechneChecksummeIsbn(Long.parseLong(isbn)));
    }
    
    /**
    * Berechnet die Nullstellen einer quadratischen Funktion in der Form x^2 + p*x + q
    */
       public void berechneNullstellen() {
            double p = userInput.getDouble("p: ");
            double q = userInput.getDouble("q: ");
            System.out.println(MathFunctions.berechneNullstellen(p , q));
    }
    
    /**
    * Prueft ob eine Zahl als Summe von Potenzen geschrieben werden kann
    */
    public void pruefeObPotenzsumme() {
            long zahl = userInput.getLong("Zahl zum Testen: ");
            if (MathFunctions.istSummeVonPotenzen(zahl)) {
                System.out.println(zahl + " ist eine Summe von Potenzen");
            }
            else{
                System.out.println(zahl + " ist keine Summer von Potenzen");
            }
    }
    
    /**
    * Berechnet den groessten gemeinsamen Teiler zweier Zahlen
    */
    public void berechneGgt() {
        int zahl1 = userInput.getInt("Erste Zahl: ");
        int zahl2 = userInput.getInt("Zweite Zahl: ");
        System.out.println("Groesster gemeinsamer Teiler: " + MathFunctions.berechneGgt(zahl1 , zahl2));
    }
    
    /**
    * Berechnet die Reihensumme mit den von den Benutzer eingegebenen Werten
    */
    public void berechneReihensumme() {
        int anzahl = userInput.getInt("Anzahl an Teilsummen: ");
        double x = userInput.getDouble("X-Wert: ");
        System.out.println("Ergebnis der Reihensumme: " + MathFunctions.berechneReihensumme(anzahl , x));
    }
    
    /**
    * Berechnet die Fakultaet von dem von Benutzer eingegebenen Werten
    */
    public void berechneFakultaet() {
            int zahl1 = userInput.getInt("Zahl zur Fakultaetsberechnung: ");
            System.out.println("Fakultaet der gewaehlten Zahl: " + MathFunctions.berechneFakultaet(zahl1));
    }
}