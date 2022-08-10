


import java.io.*;
import java.util.Scanner;

    
/**
 *    Die Klasse:  TestMyMath.java
 *    Realisiert eine allgemeine Test-Klasse fuer
 *    die MathFunctions-Klasse
 *
 * @version 1.0 Beta 12.11.2019
 * @author  Wolfgang Pauly
 *
 */

public class MathDialog {

   //------------------Konstanten----------------------------------
   private static final int IST_TRIPEL                     = 10;    
   private static final int IST_TRIPEL_TABELLE             = 11;    
   private static final int GGT                            = 15;    
   private static final int FAKULTAET                      = 16;    
   private static final int RSUMME                         = 20;
   private static final int RSUMMETABELLE                  = 21;
   private static final int RSUMME_V2                      = 30;
   private static final int RSUMMETABELLE_V2               = 31;
   private static final int ENDE                           = 99; 

  //--------- Eingabe Attribut --------------------------------
   private Scanner in;


  //------------------Konstruktoren-------------------------------
  /**
   * Standard-Konstruktor fuer TestMyMath
   */
  public MathDialog()
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
  public void run()
    {
         int    auswahl;
         double xWert;
         long   grenze;
     int    zahl1, zahl2;
         
                         
      auswahl = 0;

      while ( auswahl != ENDE )
        {
         try
           {
            auswahl = auswahlFunktion();   
            switch (auswahl)
              {
               case IST_TRIPEL :
                   grenze = MyInputFunctions.readlnLong( in,
                                     "\n\tGeben Sie die Obergrenze des Tripeltestes  " +
                                     "ein ( z.B. 100) : "
                                    );
     
                   System.out.println("\n\t" + grenze + " ist Summe von Potenzen : " +
                              MathFunctions.istSummeVonPotenzen(grenze)
                     );
                   break;
               case IST_TRIPEL_TABELLE :
                   grenze = MyInputFunctions.readlnLong( in,
                                     "\n\tGeben Sie die Obergrenze des Tripeltestes  " +
                                     "ein ( z.B. 100) : "
                                    );
     
                   for (int i = 3; i < grenze; i++ )
                    {
                     if ( MathFunctions.istSummeVonPotenzen(i) )
                       {
                         System.out.println("\n\t" + i + " ist Summe von Potenzen " );
                       }    
                    }
                   break;
               case GGT :
                   zahl1 = MyInputFunctions.readlnInt( in,
                                     "\n\tGeben Sie die 1. Zahl zur GGT-Berechnung ein : "
                                    );
     
                   zahl2 = MyInputFunctions.readlnInt( in,
                                     "\n\tGeben Sie die 2. Zahl zur GGT-Berechnung ein : "
                                    );
     
                   System.out.println("\n\t ggt( " + zahl1 + "," + zahl2 + " ist : " +
                              MathFunctions.berechneGgt(zahl1, zahl2)
                     );
                   break;
               case FAKULTAET :
                   zahl1 = MyInputFunctions.readlnInt( in,
                                     "\n\tGeben Sie die Zahl ein zu der die Fakultaet bestimmet werden soll ein : "
                                    );
     
                   System.out.println("\n\t  " + zahl1 + "! = "  +
                              MathFunctions.berechneFakultaet(zahl1)
                     );
                   break;
              case RSUMME :
                   grenze = MyInputFunctions.readlnLong( in,
                                     "\n\tGeben Sie die Interations-Obergrenze " +
                                     "ein ( z.B. 24) : "
                                    );
                   xWert = MyInputFunctions.readlnDouble( in,
                                     "\n\tGeben Sie den x-Wert fuer den die Reihe  " +
                                     "berechnet werden soll z.B. 1 ein  : "
                                    );
                   System.out.println("\n\tDie Summe s( " +
                                       xWert + ")\t [fuer n = " + grenze + "]  = " + 
                                       MathFunctions.berechneReihensumme( grenze, xWert ) +
                                       "\n"
                                     );    
                   break;    
              case RSUMMETABELLE :
                    grenze = MyInputFunctions.readlnLong( in,
                                     "\n\tGeben Sie die Interations-Obergrenze " +
                                     "ein ( z.B. 24) : "
                                    );
                    xWert = MyInputFunctions.readlnDouble( in,
                                     "\n\tGeben Sie den x-Wert fuer den die Reihe  " +
                                     "berechnet werden soll z.B. 1 ein  : "
                                    );
                    System.out.println("\n");  
                    for ( int i = 1; i <= grenze ; i++ )
                      {
                        System.out.println("\tDie Summe s( " +
                                       xWert + ")\t [fuer n = " + i + "]  = " + 
                                       MathFunctions.berechneReihensumme( grenze, xWert ) 
                                     );    
                      };
                   break;    
              case RSUMME_V2 :
                   grenze = MyInputFunctions.readlnLong( in,
                                     "\n\tGeben Sie die Interations-Obergrenze " +
                                     "ein ( z.B. 24) : "
                                    );
                   xWert = MyInputFunctions.readlnDouble( in,
                                     "\n\tGeben Sie den x-Wert fuer den die Reihe  " +
                                     "berechnet werden soll z.B. 1 ein  : "
                                    );
                   System.out.println("\n\tDie Summe s( " +
                                       xWert + ")\t [fuer n = " + grenze + "]  = " + 
                                       MathFunctions.berechneReihensummeV2( grenze, xWert ) +
                                       "\n"
                                     );    
                   break;    
              case RSUMMETABELLE_V2 :
                    grenze = MyInputFunctions.readlnLong( in,
                                     "\n\tGeben Sie die Interations-Obergrenze " +
                                     "ein ( z.B. 24) : "
                                    );
                    xWert = MyInputFunctions.readlnDouble( in,
                                     "\n\tGeben Sie den x-Wert fuer den die Reihe  " +
                                     "berechnet werden soll z.B. 1 ein  : "
                                    );
                    System.out.println("\n");                
                    for ( int i = 1; i <= grenze ; i++ )
                      {
                        System.out.println("\tDie Summe s( " +
                                       xWert + ")\t [fuer n = " + i + "]  = " + 
                                       MathFunctions.berechneReihensummeV2( grenze, xWert ) 
                                     );    
                      };
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
         catch ( Exception fehler )
           {
            System.err.println("Folgender Fehler ist aufgetreten : \n\t" +
                               fehler + "\n\n"
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
             "\nBerechne zahl ist Tripel von a**4 + b**3 + c**2                ---> " + 
              IST_TRIPEL +                           
             "\nBerechne Tabelle zahl ist Tripel von a**4 + b**3 + c**2        ---> " + 
              IST_TRIPEL_TABELLE +                           
             "\nBerechne zum einzugebenden Zahlenpaar den GGT                  ---> " + 
              GGT +                           
             "\nBerechne zur einzugebenden Zahl die Fakultaet                  ---> " + 
              FAKULTAET +                           
             "\nBerechne einen Funktionswert t(x) nur End-Ergebnisausgabe      ---> " + 
              RSUMME +                           
             "\nBerechne einen Funktionswert t(x) mit Zwischenwert-Tabelle     ---> " + 
              RSUMMETABELLE +                            
             "\nBerechne einen Funktionswert t(x) V2 nur End-Ergebnisausgabe   ---> " + 
              RSUMME_V2 +                           
             "\nBerechne einen Funktionswert t(x) V2 mit Zwischenwert-Tabelle  ---> " + 
              RSUMMETABELLE_V2 +                            
             "\n---------------------------------------" +
             "\nBeende Tests                gib ---> " + 
             ENDE
            );
       return MyInputFunctions.readlnInt( in,"\t\t\t    gib --->");
    }
  
  
  /**
   *  main
   */     
  public static void main( String[] args )
    {
      MathDialog tester = new MathDialog();
      tester.run();
    }
}
