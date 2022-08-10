import java.io.*;
import java.util.*;


/**
 *    ----> NumberCruncherTopLevelTest.java    --> Realisiert ein einfaches Dialogprogramm
 *                 zum testen der NumberCruncherTopLevel-Klasse
 *
 * @version     1.0 2022-05-05
 * @author      Wolfgang Pauly
 *
 */


 
public class NumberCruncherTopLevelTest
{
//------------------Konstanten----------------------------------
   private static final int TEST_MIT_ZUFALLS_ZAHLEN      = 10;
   private static final int TEST_MIT_FESTEN_ZAHLEN       = 11;
   private static final int TEST_MIT_EINGEGEBENEN_ZAHLEN = 12;

   private static final int ZUSAMMEN_STELLEN_DES_TESTS   = 20;
   private static final int TEST_LAUFEN_LASSEN           = 21;

   private static final int ENDE = 99;

   private static final int  SUM       = 1;
   private static final int  SWIRL     = 2;
   private static final int  DIVIDE    = 3;
   private static final int  SUBTRACT  = 4;
   private static final int  AVERAGE   = 5;


   //--------- Eingabe Attribut --------------------------------
   private Scanner in;

   //---------------- attribute --------------------
   private  NumberCruncherTopLevel  nCr;


 /**
  *    Der Konstruktor
  */
  public NumberCruncherTopLevelTest()
         throws Exception
  {
   in = new Scanner( System.in );
  
   int wahl  = MyInputFunctions.readlnInt( in,
                                           "Waehle Array-Art : \n" +
                                           "\tMit Zufalls-Zahlen arbeiten  == " + TEST_MIT_ZUFALLS_ZAHLEN +
                                           "\n" +
                                           "\tMit Festen-Zahlen arbeiten   == " + TEST_MIT_FESTEN_ZAHLEN +
                                           "\n"  +
                                           "\tMit Eingegebenen-Zahlen arbeiten   == " + TEST_MIT_EINGEGEBENEN_ZAHLEN +
                                           "\n"  +
                                           "\t gib : "
                                         );

   int dimension = MyInputFunctions.readlnInt( in,
                                               "Gebe die Anzahl der Zahlen an : "
                                         );
    if ( wahl == TEST_MIT_ZUFALLS_ZAHLEN )
      {
       nCr = new NumberCruncherTopLevel( dimension );
       System.out.println ("\n\tEin Zufalls-Zahlen basierender Test wurde initialisiert !\n\n");
      }
    else
      {
       if ( wahl == TEST_MIT_FESTEN_ZAHLEN )
         {
          nCr = new NumberCruncherTopLevel( dimension, 2 );
          System.out.println ("\n\tEin auf Festen-Zahlen basierender Test wurde initialisiert !\n\n");
         }
       else
         {
          if ( wahl == TEST_MIT_EINGEGEBENEN_ZAHLEN )
            {
             float[] values = new float[dimension];
             for (int i = 0; i < dimension; i++ )
                {
                  values[i] = MyInputFunctions.readlnFloat( in,
                                "Gebe die " + i+1 + "'te Array-Zahl ein : "
                              );
                }

             nCr = new NumberCruncherTopLevel( values );
             System.out.println ("\n\tEin auf Eingaben-Zahlen basierender Test wurde initialisiert !\n\n");
            }
          else
            {
             throw new Exception( "\n\nMan kann mit Zufalls-Zahlen (" + TEST_MIT_ZUFALLS_ZAHLEN +
                                  ") oder Festen-Zahlen-(" + TEST_MIT_FESTEN_ZAHLEN +
                                  ") oder Eingegebenen-Zahlen-(" + TEST_MIT_EINGEGEBENEN_ZAHLEN +
                                  ") arbeiten !!!!!"
                                );
            }
         }
      }


  }



 /**
  *    Die start-Methode
  *    
  */
  public void start()
  {
          int         wastun;
          String[]    operationsListe = null;
               

    while ( (wastun = wasTun()) != ENDE )
      {
        try
          {
           switch ( wastun )
             {
              case ZUSAMMEN_STELLEN_DES_TESTS : 
                         operationsListe = erstelleOperationsListe();
                         break;
              case TEST_LAUFEN_LASSEN : 
                         if ( operationsListe != null )
                           {
                            System.out.println( "\n Die Basis     :\n" + nCr );
                            nCr.crunch( operationsListe );
                            System.out.println( "\n Das Ergebniss :\n" + nCr );
                           }
                         else
                           {
                            System.out.println( "\n\t NICHTs zu Tun --> Operations-Liste leer !!!\n");
                           }
                         break;
              default  : 
                         System.out.println(  "\n Wohl vertippt !!!!! :-((  !!!!" );
                         break;
             }
          }
        catch ( RuntimeException re )
          {
           System.out.println( "\n\nRuntimeException :" +
                               "\n\nHier die Fehlermeldung : " + re +
                               "\n\nHier der Fehlerort : "
                             );
           re.printStackTrace();
          }
        catch ( Exception e )
          {
           System.out.println( "\n\nFataler Fehler :" +
                               "\n\nHier die Fehlermeldung : " + e +
                               "\n\nHier der Fehlerort : "
                             );
           e.printStackTrace();
          }
      }
  }




  /**
   * erstelleOperationsListe -> tut genau das !!!
   */
  private String[] erstelleOperationsListe()
  {
    int anzahlOperationen;
    
    anzahlOperationen = MyInputFunctions.readlnInt(in, 
                               "\n\tGeben Sie die Anzahl der durchzufuehrenden Operationen ein : "
                               ); 

    String[] operationsListe = new String[anzahlOperationen];

    for ( int i=0; i < anzahlOperationen; i++ )
      {
        switch ( welcheOperation() )
          {
           case SUM :
                     operationsListe[i] = "sum";
                     break;
           case SWIRL :
                     operationsListe[i] = "swirl";
                     break;
           case DIVIDE :
                     operationsListe[i] = "divide";
                     break;
           case SUBTRACT :
                     operationsListe[i] = "subtract";
                     break;
           case AVERAGE :
                     operationsListe[i] = "average";
                     break;
          }
        }
    return operationsListe;
  }


  /**
   * welcheOperation -> Bietet die moglichen Operationen zue Eingabe an 
   *                    und liest Benutzerwunsch ein.
   */
  private int welcheOperation()
  {
   return ( MyInputFunctions.readlnInt(in, 
                  "\n\tWaehlen Sie die nächste Operation aus :\n\n" +
                  "\n\tSum       -> " + SUM +
                  "\n\tSwirl     -> " + SWIRL +
                  "\n\tDivide    -> " + DIVIDE +
                  "\n\tSubtract -> " + SUBTRACT +
                  "\n\tAverage   -> " + AVERAGE +
                  "\n\n\tGib Operation ein :"
                  )
          );
  }
 



  /**
   * wasTun -> Zeigt die moeglichen Funktionen, die im HP
   *           aufgerufen werden koennen an und 
   *           liest Benutzerwunsch ein.
   */
  private int wasTun()
  {
   return ( MyInputFunctions.readlnInt(in, 
                  "\n\tWas wollen sie tun ????\n\n" +
                  "\n\tNeuer Test zusammenstellen  -> " +
                  ZUSAMMEN_STELLEN_DES_TESTS +
                  "\n\tTest ablaufen lassen  -> " +
                  TEST_LAUFEN_LASSEN +
                  "\n\tBearbeitung B E E N D E N             -> " +
                  ENDE +
                  "\n\n\tGib Aktion ein :"
                  )
          );
  }
 

  /**
   *    Das Test-Programm
   *
   *    Erzeugt ein NumberCruncherTopLevelTest-Objekt
   *    und
   *    ruft dessen Start-Methode auf
   */
   public static void main ( String[] args )
   {
     NumberCruncherTopLevelTest test;

     try
       {
        test = new NumberCruncherTopLevelTest();
        test.start();
       }
     catch ( Exception e )
       {
        System.out.println( "\n\nFataler Fehler :" +
                            "\n\nHier die Fehlermeldung : " + e +
                            "\n\nHier der Fehlerort : "
                          );
        e.printStackTrace();
        System.exit( 1 );
       }
     System.exit( 0 );
   }
}
