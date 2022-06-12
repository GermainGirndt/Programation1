import java.util.Scanner;
import java.util.List;
import java.util.InputMismatchException;

/**
 * Beschreiben Sie hier die Klasse DoppeltVerkettetListeDialog.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class DoppeltVerkettetListeDialog
{
    private Scanner input;
    private int funktion;
    private int art;
    private List<String> stringList;
    private List<Integer> integerList;
    
    private static final int FUNKTION_NICHT_DEFINIERT        = -1;
    private static final int FUNKTION_ENDE                   = 0;
    private static final int FUNKTION_LISTE_ANLEGEN          = 1;
    private static final int FUNKTION_GROESSE                = 2;
    private static final int FUNKTION_LEER                   = 3;
    private static final int FUNKTION_CONTAINS               = 4;
    private static final int FUNKTION_TOARRAY                = 5;
    private static final int FUNKTION_ADD                    = 6;
    private static final int FUNKTION_REMOVE_OBJECT          = 7;
    private static final int FUNKTION_ADDALL                 = 8;
    private static final int FUNKTION_CLEAR                  = 9;
    private static final int FUNKTION_GET                    = 10;
    private static final int FUNKTION_SET                    = 11;
    private static final int FUNKTION_ADD_AT_INDEX           = 12;
    private static final int FUNKTION_REMOVE_AT_INDEX        = 13;
    private static final int FUNKTION_INDEXOFF               = 14;
    
    /**
     * Konstruktor für Objekte der Klasse DoppeltVerkettetListeDialog
     */
    public DoppeltVerkettetListeDialog()
    {
        this.input = new Scanner(System.in);       
    }

      public static void main(String[] args) {
        DoppeltVerkettetListeDialog dialog = new DoppeltVerkettetListeDialog();
        dialog.start();
        
    }
    
      public void start() {
 
        this.funktion        = FUNKTION_NICHT_DEFINIERT;
        this.art             = FUNKTION_NICHT_DEFINIERT;
        
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
            FUNKTION_LISTE_ANLEGEN         + ": Liste anlegen;\n"  + 
            FUNKTION_GROESSE               + ": Groesse ausgeben;\n" +
            FUNKTION_LEER                  + ": Auf Leer pruefen;\n"  + 
            FUNKTION_CONTAINS              + ": Pruefen ob Element enthalten ist;\n" +
            FUNKTION_TOARRAY               + ": Liste als Array ausgeben;\n" +
            FUNKTION_ADD                   + ": Object hinzufuegen;\n" +
            FUNKTION_REMOVE_OBJECT         + ": Object entfernen;\n"  + 
            FUNKTION_ADDALL                + ": Add all Objects;\n" +
            FUNKTION_CLEAR                 + ": Clear List;\n" +
            FUNKTION_GET                   + ": Object an Listenindex holen;\n"  + 
            FUNKTION_SET                   + ": Object an Listenindex setzen;\n" +
            FUNKTION_ADD_AT_INDEX          + ": Object an Listenindex hinzufuegen;\n" +
            FUNKTION_REMOVE_AT_INDEX       + ": Object an Listenindex entfernen;\n" +
            FUNKTION_INDEXOFF              + ": Listenindex von Object finden;\n" +
            FUNKTION_ENDE                  + ": beenden -> \n\n" 
        );
        
        System.out.println("Ausgewählte Funktion: ");
        this.funktion = input.nextInt();
        input.nextLine();
        System.out.println();
        switch(this.art){
            case 1:
                System.out.println(stringList);
                break;
            case 2:
                System.out.println(integerList);
                break;
        }
    }
    
    /**
    * Diese Funktion fuehrt je nach Parameter die dazugehoerige Funktion aus
    * @param funktion die ausgefuehrt werden soll
    */
    private void ausfuehrenFunktion() {
        switch(this.funktion) {
            case  FUNKTION_LISTE_ANLEGEN:
                listeAnlegen(); 
                break;  
            case FUNKTION_GROESSE:
                groesseAusgeben();
                break;  
            case FUNKTION_LEER:
                obLeerAusgeben();
                break;  
            case FUNKTION_CONTAINS:
                pruefeObObjectInListeIst();
                break;
            case FUNKTION_TOARRAY:
            
                break;
            case FUNKTION_ADD:
                elementHinzufuegen();
                break;   
            case FUNKTION_REMOVE_OBJECT:
                elementEntfernen();
                break; 
            case FUNKTION_ADDALL:
            
                break;  
            case FUNKTION_CLEAR:
                clearList();
                break; 
            case FUNKTION_GET:
                get();
                break;  
            case FUNKTION_SET:
                set();
                break;  
            case FUNKTION_ADD_AT_INDEX:
                anIndexEinfuegen();
                break;  
            case FUNKTION_REMOVE_AT_INDEX:
                entferneAnIndex();
                break; 
            case FUNKTION_INDEXOFF:
                getObjectNachIndex();
                break;  
            case FUNKTION_ENDE:  
                System.out.println("Das Programm ist zu Ende");
                break;
            default:
                System.out.println("Keine gueltige Eingabe");
                break;
            }
        }
    
    private void listeAnlegen(){
        
        
         System.out.print(
            "\n\n" +
            1                              + ": String Liste anlegen;\n"  + 
            2                              + ": Int Liste anlegen;\n" +
            FUNKTION_ENDE                  + ": beenden -> \n\n" 
        );
        
        System.out.println("Ausgewählte Funktion: ");
        this.art = input.nextInt();
        input.nextLine();
        System.out.println();    
        
        switch(this.art) {
            case 1:
                this.stringList = new DoppeltVerketteteListe<String>();
                System.out.println("Liste angelegt");
                break;
            case 2:
                this.integerList = new DoppeltVerketteteListe<Integer>();
                System.out.println("Liste angelegt");
                break;
            case FUNKTION_ENDE:
                System.out.println("Die Listenauswahl ist zu Ende");
                break;
            default:
                System.out.println("Keine gueltige Eingabe");
                break;    
        }
    }
    
     private void groesseAusgeben(){
            switch(this.art){
             case 1:
                System.out.println("Groesse: " + stringList.size());
                break;
            case 2:
                System.out.println("Groesse: " + integerList.size());
                break;
            default:
                System.out.println("Liste ist noch nicht angelegt");
                break;    
            }
        }
    
    private void obLeerAusgeben(){
         switch(this.art){
             case 1:
                System.out.println("Ist die Liste leer?: " + stringList.isEmpty());
                break;
            case 2:
                System.out.println("Ist die Liste leer?: " + integerList.isEmpty());
                break;
            default:
                System.out.println("Liste ist noch nicht angelegt");
                break;    
            }   
    }
    
    private void pruefeObObjectInListeIst(){
         switch(this.art){
             case 1:
                System.out.println("Geben Sie den Stringwert ein der geprueft werden soll:");
                String zuPruefenString = input.nextLine();
                System.out.println("Enthaelt die Liste dieses Object?: " + stringList.contains(zuPruefenString));
                break;
            case 2:
                System.out.println("Geben Sie den Integerwert ein der geprueft werden soll:");
                Integer zuPruefenInteger  = input.nextInt();
                System.out.println("Enthaelt die Liste dieses Object?: " + integerList.contains(zuPruefenInteger));
                break;
            default:
                System.out.println("Liste ist noch nicht angelegt");
                break;    
            }     
    }
    
    private void elementHinzufuegen(){
        switch(this.art){
             case 1:
                System.out.println("Geben Sie den Stringwert ein der hinzugefuegt werden soll:");
                String stringElement = input.nextLine();
                stringList.add(stringElement);
                System.out.println("Element wurde hinzugefuegt.");
                break;
            case 2:
                System.out.println("Geben Sie den Integerwert ein der hinzugefuegt werden soll:");
                Integer integerElement  = input.nextInt();
                integerList.add(integerElement);
                System.out.println("Element wurde hinzugefuegt.");
                break;
            default:
                System.out.println("Liste ist noch nicht angelegt");
                break;    
            }     
    }
    
    private void elementEntfernen(){
          switch(this.art){
             case 1:
                System.out.println("Geben Sie den Stringwert ein der entfernt werden soll:");
                String stringElement = input.nextLine();
                stringList.remove(stringElement);
                System.out.println("Element entfernt.");
                break;
            case 2:
                System.out.println("Geben Sie den Integerwert ein der entfernt werden soll:");
                Integer integerElement  = input.nextInt();
                integerList.remove(integerElement);
                System.out.println("Element entfernt.");
                break;
            default:
                System.out.println("Liste ist noch nicht angelegt");
                break;    
            }    
    }
    
    private void  clearList(){
        switch(this.art){
             case 1:
                stringList.clear();
                System.out.println("Clear ausgefuehrt.");
                break;
            case 2:
                integerList.clear();
                System.out.println("Clear ausgefuehrt.");
                break;
            default:
                System.out.println("Liste ist noch nicht angelegt");
                break;    
            }       
    }
    
    private void getObjectNachIndex(){
        switch(this.art){
             case 1:
                System.out.println("Geben Sie den Stringwert ein der ueberprueft werden soll:");
                String stringElement = input.nextLine();
                System.out.println("Element ist an der Stelle: "+ stringList.indexOf(stringElement));
                break;
            case 2:
                System.out.println("Geben Sie den Integerwert ein der ueberprueft werden soll:");
                Integer integerElement = input.nextInt();
                System.out.println("Element ist an der Stelle: "+ integerList.indexOf(integerElement));
                break;
            default:
                System.out.println("Liste ist noch nicht angelegt");
                break;    
            }     
    }
    
    private void entferneAnIndex(){
        switch(this.art){
             case 1:
                System.out.println("Geben Sie die Stelle an, an der Entfernt werden soll:");
                int indexString = input.nextInt();
                String entferntString = stringList.remove(indexString);
                System.out.println("Element: " + entferntString + " an Stelle " + indexString + " wurde entfernt");
                break;
            case 2:
                System.out.println("Geben Sie die Stelle an, an der Entfernt werden soll:");
                int indexInteger = input.nextInt();
                int entferntInteger = integerList.remove(indexInteger);
                System.out.println("Element: " + entferntInteger + " an Stelle " + indexInteger + " wurde entfernt");
                break;
            default:
                System.out.println("Liste ist noch nicht angelegt");
                break;        
        }
    }
    
    private void anIndexEinfuegen(){
        switch(this.art){
             case 1:
                System.out.println("Geben Sie den Stringwert ein der hinzugefuegt werden soll:");
                String stringElement = input.nextLine();
                System.out.println("Geben Sie die Stelle an, an der hinzugefuegt werden soll:");
                int indexString = input.nextInt();
                stringList.add(indexString, stringElement);
                System.out.println("Element wurde hinzugefuegt.");
                break;
            case 2:
                System.out.println("Geben Sie den Integerwert ein der hinzugefuegt werden soll:");
                Integer integerElement  = input.nextInt();
                System.out.println("Geben Sie die Stelle an, an der hinzugefuegt werden soll:");
                int indexInteger = input.nextInt();
                integerList.add(indexInteger, integerElement);
                System.out.println("Element wurde hinzugefuegt.");
                break;
            default:
                System.out.println("Liste ist noch nicht angelegt");
                break;    
            }     
    }
    
    private void get(){
        switch(this.art){
             case 1:
                System.out.println("Geben Sie die Stelle an, an der ausgegeben werden soll:");
                int indexString = input.nextInt();
                String gegetteterString = stringList.get(indexString);
                System.out.println("Element: " + gegetteterString + " an Stelle " + indexString );
                break;
            case 2:
                System.out.println("Geben Sie die Stelle an, an der ausgegeben werden soll:");
                int indexInteger = input.nextInt();
                int gegetteterInteger = integerList.get(indexInteger);
                System.out.println("Element: " + gegetteterInteger  + " an Stelle " + indexInteger);
                break;
            default:
                System.out.println("Liste ist noch nicht angelegt");
                break;        
        }    
    }
    
    private void set(){
        switch(this.art){
             case 1:
                System.out.println("Geben Sie den Stringwert ein der geaendert werden soll:");
                String stringElement = input.nextLine();
                System.out.println("Geben Sie die Stelle an, an der geaendert werden soll:");
                int indexString = input.nextInt();
                stringList.set(indexString, stringElement);
                System.out.println("Element wurde ersetzt.");
                break;
            case 2:
                System.out.println("Geben Sie den Integerwert ein der geaendert werden soll:");
                Integer integerElement  = input.nextInt();
                System.out.println("Geben Sie die Stelle an, an der geaendert werden soll:");
                int indexInteger = input.nextInt();
                integerList.set(indexInteger, integerElement);
                System.out.println("Element wurde ersetzt.");
                break;
            default:
                System.out.println("Liste ist noch nicht angelegt");
                break;    
            }         
    }
}
