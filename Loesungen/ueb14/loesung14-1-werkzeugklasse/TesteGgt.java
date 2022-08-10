import java.io.*;
import java.util.Scanner;
    
/**
 *    Die Klasse:  TesteGgt.java
 *    Realisiert eine allgemeine Test-Klasse fuer
 *    die GgTRekrusiv-Klasse
 *
 * @version -1.0 Beta 2022-04-27
 * @author  Wolfgang Pauly
 *
 */

public class TesteGgt
{
//------------------Konstanten----------------------------------
   private static final int TESTE_GGT_REKURSIV     = 20; 
   private static final int SCHNELLTEST_REKURSIV   = 22;
   
   private static final int ENDE                   = 99;

//--------- Eingabe Attribut --------------------------------
  private Scanner in;

//------------------Konstruktoren-------------------------------
  /**
    * Standard-Konstruktor fuer TesteGgt
    */
   public TesteGgt()
   {
     System.out.println(
            "\n\n\t Diese Anwendung liefert einen Test-Rahmen fuer die " +
            "\n\t Werkzeugklassen-Funktion : long berechneGgt(long a,long b)" +
            "\n\n"
           );
     in = new Scanner( System.in );
   }


   /**
    * run --> laesst die GgTRekursiv ablaufen
    * 
    */
   public void run()
   {
         int     auswahl = 0; 
         long    a,b;
                         

     while ( auswahl != ENDE )
     {
      try
        {
         auswahl = auswahlFunktion();
         switch (auswahl)
           {
            case TESTE_GGT_REKURSIV :
                 a = MyInputFunctions.readlnLong(in,"\t  gib 1. Zahl (a) ein --->");
                 b = MyInputFunctions.readlnLong(in,"\t  gib 2. Zahl (b) ein --->");
                 System.out.println( "ggt(" + a + "," + b + ") == " + MathFunctions.berechneGgt(a,b) );
                 break;
            case SCHNELLTEST_REKURSIV :
                 schnellTestGgtRekursiv();
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
             "\nHaendischer Test für die Methode berechneGgt(a,b)   ---> " + 
              TESTE_GGT_REKURSIV +
             "\nAutomatischer Test für die Methode berechneGgt(a,b) ---> " + 
              SCHNELLTEST_REKURSIV +
             "\n-----------------------------------------------------------" +
             "\nBeende Tests                                    gib ---> " + 
             ENDE +
             "\n-----------------------------------------------------------" 
            );
       return MyInputFunctions.readlnInt(in,"\t\t\t\t  gib --->");
   }
  
  

   /**
    *  schnellTestGgtRekursiv - tut genau das 
    *
    */
    private void schnellTestGgtRekursiv()
    {
      
     System.out.println( "12, 18 == " + MathFunctions.berechneGgt( 12,18) );
     System.out.println( "18, 12 == " + MathFunctions.berechneGgt( 18,12) );
     System.out.println( "90, 105 == " + MathFunctions.berechneGgt( 90,105) );
     System.out.println( "105, 90 == " + MathFunctions.berechneGgt( 105,90) );
     System.out.println( "3528, 3780 == " + MathFunctions.berechneGgt( 3528,3780) );
     System.out.println( "3780, 3528 == " + MathFunctions.berechneGgt( 3780,3528) );
    }
  
    /**
     *  main
     */	 
    public static void main( String[] args )
    {
      TesteGgt tester = new TesteGgt();
      tester.run();
    }
}
