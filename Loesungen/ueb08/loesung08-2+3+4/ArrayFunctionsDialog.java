import java.io.*;
import java.util.Scanner;
    
/**
 *    Die Klasse:  ArrayFunctionsDialog.java
 *    Realisiert eine allgemeine Dialog-Klasse fuer
 *    die MyUeb6Methods-Werkzeug-Klasse
 *
 * @version -1.0 Beta 2021
 * @author  Wolfgang Pauly
 *
 */

public class ArrayFunctionsDialog 
{
//------------------Konstanten----------------------------------
   private static final int TESTE_MESSWERT_AUSWERTUNG     = 10;       
   private static final int TESTE_NURBUCHSTABEN_STRING    = 20; 
   
   private static final int ENDE                          = 99;

//--------- Eingabe Attribut --------------------------------
  private Scanner in;

//------------------Konstruktoren-------------------------------
  /**
    * Standard-Konstruktor fuer ArrayFunctionsDialog
    */
   public ArrayFunctionsDialog()
   {
     System.out.println(
            "\n\n\t Diese Anwendung liefert einen Dialog-Test-Rahmen fuer die " +
            "\n\t Methoden in der ArrayFunctions-Werkzeug-Klasse " +
            "\n\n"
           );
     in = new Scanner( System.in );
   }


   /**
    * run --> laesst die MyUeb6Methods-Test's ablaufen
    * 
    */
   public void start()
   {
         int     auswahl = 0; 
         long    eineZahl, zuTesten;
         double a, b, c, epsilon;
                         


     while ( auswahl != ENDE )
     {
      try
        {
         auswahl = auswahlFunktion();
         switch (auswahl)
           {
            case TESTE_MESSWERT_AUSWERTUNG :
                 testeMesswertAuswertung();
                 break;
            case TESTE_NURBUCHSTABEN_STRING :
                 testeNurBuchstabenStrings();
                 break;
            case ENDE :
                 System.out.println("\n\nWeiterhin viel Spass bei der Arbeit !!!\n\n");
                 break;
            default :
                 System.out.println("\n\n Falsche Auswahl-Eingabe !!!\n");
                 break;
           }   
        }
      catch ( NumberFormatException ex )
        {  
         System.err.println("Folgende Ausnahme ist aufgetreten : \n\t" +
                            ex + "\n\n"
                           );
        }      
      catch ( RuntimeException ex )
        {
         System.err.println("Folgender Fehler ist aufgetreten : \n\t" +
                            ex + "\n\n"
                           );
        } 
      catch ( Exception ex )
        {
         System.err.println("Folgender Fehler ist aufgetreten : \n\t" +
                            ex + "\n\n"
                           );
        } 
    
     }
    }
   
   
   /**
    *  Erfragt vom Benutzer die als naechstes auszufuehrende Aktion
    *  
    *  @return das Aktionskennzeichen
    */
    private int auswahlFunktion()
    {
      System.out.println (
             "\nFuehre Test der Messwertauswertungs-Methode durch   ---> " + 
              TESTE_MESSWERT_AUSWERTUNG +       
             "\nFuehre Test der NurBuchstabeStrings-Methode durch   ---> " + 
              TESTE_NURBUCHSTABEN_STRING +      
             "\n-----------------------------------------------------------" +
             "\nBeende Tests                                    gib ---> " + 
             ENDE +
             "\n-----------------------------------------------------------" 
            );
       return MyInputFunctions.readlnInt(in,"\t\t\t\t  gib --->");
   }
  
  

   /**
    *  testeMesswertAuswertung - tut genau das 
    *
    */
    private void testeMesswertAuswertung()
    {
      Mittelwert auswertErgebnis;
      final int ANZAHL_TEST_ARRAYS = 3;

      double tab[][] = 
             {
                     { -0.1, 0.2, -0.3, 0.27, -0.2, 0.11,  0.31,   0.91,  0.5,  0.7,  0.8,  0.4 },
                     { -0.1, 0.2, -0.3, 0.29, -0.2, 0.11,  13.0,  2.0,  4.0,  3.0,  6.0,  2.0,  100.0 },
                     { -0.1, 0.2, -0.3, 0.29, -0.2, 0.11, -13.0, -2.0, -4.0, -3.0, -6.0, -2.0, -100.0 }
             };

      for (int i = 0; i < ANZAHL_TEST_ARRAYS; i++ )
         {
       auswertErgebnis = ArrayFunctions.berechneMittelwert( tab[i] );
           System.out.println( "Das " + (i+1) + "'te Messwertarray : \n\t" + 
                               java.util.Arrays.toString( tab[i] ) +
                               "\ndie Ergebnisswerte : min, mittel, max : \n\t" + 
                                auswertErgebnis +
                               "\n--------------------------------------------------------\n" 
                        );
         }
    }
  
  
   /**
    *  testeMesswertAuswertung - tut genau das 
    *
    */
    private void testeNurBuchstabenStrings()
    {
      final int ANZAHL_TEST_ARRAYS = 5;
      
      String[][] stab = 
                 {
                     { "hallo", "abxyz", "HTW", "jooojo", "GI!" },
                     { "hallo", "abxyz", "HTW", "joooj4", "GiS" },
                     { "hallo", "abxyz", "HTw", "jooo$o", "G7S" },
                     { "Hallo", "ABxyz", "HTw ", "joo jo", "gis"},
                     { "Hallo", "12 xyz", "H T W ", "!\247$", " GIS" }
                 };

      for ( int i = 0; i < ANZAHL_TEST_ARRAYS; i++ )
         {
          System.out.println("strings = [" + (i+1) + "] " +
                             java.util.Arrays.toString(stab[i]) +
                             "Ergebnis = " +
                             ArrayFunctions.stringsAuswerten(stab[i]) + 
                             "\n--------------------------------------------------------\n" 
                            );
         }
    }
  
  
    /**
     *  main
     */     
    public static void main( String[] args )
    {
      ArrayFunctionsDialog tester = new ArrayFunctionsDialog();
      tester.start();
    }
}
