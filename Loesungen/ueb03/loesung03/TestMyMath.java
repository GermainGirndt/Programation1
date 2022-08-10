
import java.io.*;
import java.util.Scanner;
    
/**
 *    Die Klasse:  TestMyMath.java
 *    Realisiert eine allgemeine Test-Klasse fuer
 *    die MathFunctions-Klasse
 *
 * @version 1.0 Beta 2021.11.08
 * @author  Wolfgang Pauly
 *
 */

public class TestMyMath
{
//------------------Konstanten----------------------------------
   private static final int TEILERSUMME_INT               = 10;       
   private static final int TEILERSUMME_INT_SCHNELLER     = 11; 
   private static final int TEILERSUMME_STRING            = 12;
   private static final int TEILERSUMME_SCHNELLER_STRING  = 13;
   
   private static final int ISBN_TEST                     = 20;
   
   private static final int QUADRATISCHE_GL_KONST_EPSILON = 30;                            
   private static final int QUADRATISCHE_GL_VAR_EPSILON   = 31;                           

   private static final int ENDE                          = 99;
   
//--------- Eingabg Attribut --------------------------------
   private Scanner in;
//------------------Konstruktoren-------------------------------

  /**
    * Standard-Konstruktor fuer TestMyMath
    */
   public TestMyMath()
   {
     System.out.println(
            "\n\n\t Diese Anwendung liefert einen Test-Rahmen fuer die " +
            "\n\t mathematischen Funktionen in der MathFunction-Klasse " +
            "\n\n"
           );
     in = new Scanner( System.in );
   }

   /**
    * run --> laesst die benutzergesteuerte Bedienung 
    *         der MathFunction-Test's ablaufen
    * 
    */
   public void start()
   {
         int     auswahl = 0; 
         long    eineZahl, zuTesten;
         double  p, q, epsilon;
                         









     while ( auswahl != ENDE )
     {
      try
        {
         auswahl = auswahlFunktion();
         switch (auswahl)
           {
            case TEILERSUMME_INT :
                 eineZahl = MyInputFunctions.readlnInt( in, 
                                  "\n\tGeben Sie eine Zahl ein," +
                                  " deren Teilsersumme berechnet werden soll : "
                                 );
                 System.out.println(
                            "\n\t Die Teilersumme der Zahl --> " + eineZahl +
                            " ist --> " +
                            MathFunctions.berechneTeilersumme( eineZahl )
                           );
                 break;
            case TEILERSUMME_INT_SCHNELLER :
                 eineZahl = MyInputFunctions.readlnInt( in,
                                  "\n\tGeben Sie eine Zahl ein," +
                                  " deren Teilsersumme berechnet werden soll : "
                                 );
                 System.out.println(
                            "\n\t Die Teilersumme der Zahl --> " + eineZahl +
                            " ist --> " +
                            MathFunctions.berechneTeilersummeSchneller( eineZahl )
                           );
                 break;
            case TEILERSUMME_STRING :
                 eineZahl = MyInputFunctions.readlnInt( in,
                                  "\n\tGeben Sie eine Zahl ein," +
                                  " deren Teilsersumme berechnet werden soll : "
                                 );
                 System.out.println(
                            "\n\t Die Teilersumme der Zahl --> " + eineZahl +
                            " ist --> " + 
                            MathFunctions.berechneTeilersummeString( eineZahl )
                           );
                 break;

            case TEILERSUMME_SCHNELLER_STRING :
                 eineZahl = MyInputFunctions.readlnInt( in,
                                  "\n\tGeben Sie eine Zahl ein," +
                                  " deren Teilsersumme berechnet werden soll : "
                                 );
                 System.out.println(
                            "\n\t Die Teilersumme der Zahl --> " + eineZahl +
                            " ist --> " + 
                            MathFunctions.berechneTeilersummeSchnellerString( eineZahl )
                           );
                 break;
















            case ISBN_TEST :
                 System.out.println(
                            "\n\tSie wollen zu einer 9-stelligen ISBN-Nummer " +
                            "die Pruelzahl == 10'te Stelle berechnen !!" 
                           );
                 zuTesten = MyInputFunctions.readlnLong( in,
                             "\n\tGeben Sie die zu analysierende ISBN-Nummer ein : "
                            );

                 System.out.print( "\n\tDie Zahl  ---> " + zuTesten + " hat die Pruefziffer : " +
                                   MathFunctions.berechneChecksummeIsbn( zuTesten ) + "\n\n"
                                 );
                 break;
                 
            case QUADRATISCHE_GL_KONST_EPSILON :
                 System.out.println(
                            "\n\tSie wollen eine quadratische Gleichung der Form : " +
                            " x*x + p*x + q = 0  mit einem EPSILON von " +
                            MathFunctions.EPSILON + " loesen !!!" 
                           );
                 p = MyInputFunctions.readlnDouble(in, "\n\tGeben sie den Zahlenwert fuer p ein : ");
                 q = MyInputFunctions.readlnDouble(in, "\n\tGeben sie den Zahlenwert fuer q ein : ");
                 System.out.println(
                            "\n\tDie quadratische Gleichung \n\t ---> " + 
                            "x*x + " + p + " *x + " + q + " = 0 \n\t" +
                            "hat unter Beruecksichtigung der Fehlergrenze Epsilon = " +
                            MathFunctions.EPSILON + "\n\t,die Loesung(en) : " +
                            MathFunctions.berechneNullstellen( p, q )
                           );
                 break;            
            case QUADRATISCHE_GL_VAR_EPSILON :
                 System.out.println(
                            "\n\tSie wollen eine quadratische Gleichung der Form : " +
                            " x*x + p*x + q = 0  mit einem frei waehlbaren EPSILON " +
                            "loesen !!!" 
                           );
                 p = MyInputFunctions.readlnDouble(in,"\n\tGeben sie den Zahlenwert fuer p ein : ");
                 q = MyInputFunctions.readlnDouble(in,"\n\tGeben sie den Zahlenwert fuer q ein : ");
                 epsilon = MyInputFunctions.readlnDouble(in,
                                 "\n\tGeben sie die Fehlergrenze Epsilon ein  : "
                                );
                 System.out.println(
                            "\n\tDie quadratische Gleichung \n\t ---> " + 
                            "x*x + " + p + " *x + " + q + " = 0 \n\t" +
                            "hat unter Beruecksichtigung der Fehlergrenze Epsilon = " +
                            epsilon + "\n\t,die Loesung(en) : " +
                            MathFunctions.berechneNullstellen( p, q,epsilon )
                           );
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
      catch ( IllegalArgumentException ex )
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
             "\nBerechne Teilersumme einer Zahl (Zahl)              ---> " + 
              TEILERSUMME_INT +       
             "\nBerechne Teilersumme einer Zahl schneller (Zahl)    ---> " + 
              TEILERSUMME_INT_SCHNELLER +      
             "\nBerechne Teilersumme einer Zahl (String)            ---> " + 
             TEILERSUMME_STRING+
             "\nBerechne Teilersumme einer Zahl schneller (String)  ---> " + 
             TEILERSUMME_SCHNELLER_STRING+             
             "\n-----------------------------------------------------------" +
             "\nISBN-Test                                           ---> " + 
             ISBN_TEST +  
            
             "\n-----------------------------------------------------------" +
             "\nLoese Quadratische Gleichung mit Epsilon konstant   ---> " + 
             QUADRATISCHE_GL_KONST_EPSILON +
             "\nLoese Quadratische Gleichung mit Epsilon variabel   ---> " + 
             QUADRATISCHE_GL_VAR_EPSILON +
             "\n-----------------------------------------------------------" +
             "\nBeende Tests                                 gib ---> " + 
             ENDE
            );
       return MyInputFunctions.readlnInt( in,"\t\t\t\t  gib --->");
   }
  
  
    /**
     *  main
     */	 
	public static void main( String[] args )
	{
	  TestMyMath tester = new TestMyMath();
	  tester.start();
    }
}
