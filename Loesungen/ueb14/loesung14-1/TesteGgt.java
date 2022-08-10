import java.io.*;
import java.util.Scanner;
    
/**
 *    Die Klasse:  TesteGgt.java
 *    Realisiert eine allgemeine Test-Klasse fuer
 *    die ggt-Klassen GgTRekursiv und GgTIterativ
 *
 * @version -1.0 Beta 2022-04-27
 * @author  Wolfgang Pauly
 *
 */


public class TesteGgt
{
//------------------Konstanten----------------------------------
   private static final int TESTE_GGT_ITERATIV     = 10;       
   private static final int SCHNELLTEST_ITERATIV   = 11;
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
            "\n\t ggt-Klassen GgTRekursiv und GgTIterativ " +
            "\n\n"
           );
     in = new Scanner( System.in );
   }


   /**
    * run --> laesst die GgT-Test's ablaufen
    * 
    */
   public void start()
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
            case TESTE_GGT_ITERATIV :
                 a = MyInputFunctions.readlnLong(in,"\t  gib 1. Zahl (a) ein --->");
                 b = MyInputFunctions.readlnLong(in,"\t  gib 2. Zahl (b) ein --->");
                 System.out.println( "ggt(" + a + "," + b + ") == " + new GgtIterativ().berechneGgt(a,b) );
                 break;
            case SCHNELLTEST_ITERATIV :
                 schnellTestGgtIterativ();
                 break;
            case TESTE_GGT_REKURSIV :
                 a = MyInputFunctions.readlnLong(in,"\t  gib 1. Zahl (a) ein --->");
                 b = MyInputFunctions.readlnLong(in,"\t  gib 2. Zahl (b) ein --->");
                 System.out.println( "ggt(" + a + "," + b + ") == " + new GgtRekursiv().berechneGgt(a,b) );
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
      catch ( GgTException ex )
        {  
         System.err.println("Folgende GgT-Exception ist aufgetreten : \n\t" +
                            ex + "\n\n"
                           );
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
             "\nHaendischer Test für die Methode ggtIterativ(a,b)   ---> " + 
              TESTE_GGT_ITERATIV +       
             "\nAutomatischer Test für die Methode ggtIterativ(a,b) ---> " + 
              SCHNELLTEST_ITERATIV +      
             "\nHaendischer Test für die Methode ggtRekursiv(a,b)   ---> " + 
              TESTE_GGT_REKURSIV +
             "\nAutomatischer Test für die Methode ggtRekursiv(a,b) ---> " + 
              SCHNELLTEST_REKURSIV +
             "\n-----------------------------------------------------------" +
             "\nBeende Tests                                    gib ---> " + 
             ENDE +
             "\n-----------------------------------------------------------" 
            );
       return MyInputFunctions.readlnInt(in,"\t\t\t\t  gib --->");
   }
  
  

   /**
    *  schnellTestGgtIterativ - tut genau das 
    *
    */
    private void schnellTestGgtIterativ()
    {
        GgtIterativ ggtI = new GgtIterativ();
        
     System.out.println( "12, 18 == " + ggtI.berechneGgt( 12,18) );
     System.out.println( "18, 12 == " + ggtI.berechneGgt( 18,12) );
     System.out.println( "90, 105 == " + ggtI.berechneGgt( 90, 105) );
     System.out.println( "105, 90 == " + ggtI.berechneGgt( 105, 90) );
     System.out.println( "3528, 3780 == " + ggtI.berechneGgt( 3528, 3780) );
     System.out.println( "3780, 3528 == " + ggtI.berechneGgt( 3780, 3528) );
    }
  
  
   /**
    *  schnellTestGgtRekursiv - tut genau das 
    *
    */
    private void schnellTestGgtRekursiv()
    {
           GgtRekursiv ggtR = new GgtRekursiv();
      
     System.out.println( "12, 18 == " + ggtR.berechneGgt( 12,18) );
     System.out.println( "18, 12 == " + ggtR.berechneGgt( 18,12) );
     System.out.println( "90, 105 == " + ggtR.berechneGgt( 90, 105) );
     System.out.println( "105, 90 == " + ggtR.berechneGgt( 105, 90) );
     System.out.println( "3528, 3780 == " + ggtR.berechneGgt( 3528, 3780) );
     System.out.println( "3780, 3528 == " + ggtR.berechneGgt( 3780, 3528) );
    }
  
    /**
     *  main
     */     
    public static void main( String[] args )
    {
      TesteGgt tester = new TesteGgt();
      tester.start();
    }
}
