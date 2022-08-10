import java.io.*;
import java.util.Scanner;
    
/**
 *    Die Klasse:  PalindromTester.java
 *    Realisiert eine allgemeine Test-Klasse fuer
 *    die Palindrom-Klassen 
 *                  PalindromIterativ()
 *                  PalintromRekursiv()
 *
 * @version -1.0 Beta 2022-04-27
 * @author  Wolfgang Pauly
 *
 */

public class PalindromTester
{
//------------------Konstanten----------------------------------
  private static final String STRING = new String( "-s");       
  private static final String DATEI  = new String( "-d");       
  private static final String ITERATIV  = new String( "interativ" );      
  private static final String REKURSIV  = new String( "rekursiv" );      
  private static final String SONSTWIE  = new String( "sonstwie" );      

// Attribute
  PalindromIterativ palinI;
  PalindromRekursiv palinR;
  PalindromSonstWie palinS;

//------------------Konstruktoren-------------------------------
  /**
    * Standard-Konstruktor fuer PalindromTester
    */
   public PalindromTester()
   {
     palinI = new PalindromIterativ();
     palinR = new PalindromRekursiv();
     palinS = new PalindromSonstWie();
   }


   /**
    * start --> laesst die MyUeb15Methods-Test's ablaufen
    * 
    */

   public int start( String steuerParameter, String parameter )
          throws Exception
   {
      String testString, testDateiName;
      long startZeit, laufZeit;
      boolean testErgebnis;

      if ( steuerParameter.equals( STRING ) )
        {
          testString = parameter;


          System.out.println( "\n\n\t Iterative Bearbeitung \n" );
          for ( int i = 0; i < 4; i++ )
            {
              startZeit = System.nanoTime();
              testErgebnis = palinI.istPalindrom( testString);
              laufZeit = System.nanoTime() - startZeit;
              System.out.println( "\t " + testString + " == " +
                                  testErgebnis + " \tbt(" + laufZeit + ")" 
                                );
            }
  
  
          System.out.println( "\n\n\t Rekursive Bearbeitung \n" );
          for ( int i = 0; i < 4; i++ )
            {
              startZeit = System.nanoTime();
              testErgebnis = palinR.istPalindrom( testString);
              laufZeit = System.nanoTime() - startZeit;
              System.out.println( "\t " + testString + " == " +
                                  testErgebnis + " \tbt(" + laufZeit + ")"
                                );
            }
  
  
          System.out.println( "\n\n\t SonstWie Bearbeitung \n" );
          for ( int i = 0; i < 4; i++ )
            {
              startZeit = System.nanoTime();
              testErgebnis = palinS.istPalindrom( testString);
              laufZeit = System.nanoTime() - startZeit;
              System.out.println( "\t " + testString + " == " +
                                  testErgebnis + " \tbt(" + laufZeit + ")"
                                );
            }

          System.out.println( "\n\n\t Ende \n" );
        }
      else
        {
          if ( steuerParameter.equals( DATEI ) )
            {
              testDateiName = parameter;
              verarbeiteDatei( testDateiName );
              System.out.println( "\n\n\t Ende \n" );
            }
          else
            {
              System.out.println(
                "\n\t Aufruf : java PalindromTester [-s STRING]" +
                "\n\t          oder " +
                "\n\t Aufruf : java PalindromTester [-d DATEINAME]" +
                "\n\n"
                );
              return( 1 );
            }
        }
      return( 0 );
    }
   

   /**
    * verarbeiteDatei --> der Name ist Programm 
    * 
    */
   public void verarbeiteDatei( String testDateiName )
         throws DateiExistiertNichtException, DateiNichtBearbeitbarException,
                IOException
   {
      long verarbBeginn = System.nanoTime();

      long startZeit, laufZeit;
      boolean testErgebnis;
      String messReihe = new String (" Berechnungszeiten = " );
 
      // die Eingabe-Datei
      File dieDatei = new File( testDateiName );

      DateiExistiertNichtException.existiertDatei( dieDatei );
      DateiExistiertNichtException.istDatei( dieDatei );
      DateiNichtBearbeitbarException.istLesbar( dieDatei );

      BufferedReader  zuLesen  = new BufferedReader(
                                     new FileReader( dieDatei )
                                 );
      // die Ausgabe-Datei
      File dieAusgabe = new File( testDateiName + ".csv" );

      PrintStream  zuSchreiben  = new PrintStream( dieAusgabe );

      StringBuffer stringLaengenZeile = new StringBuffer( "Länge" );
      StringBuffer zeitIterativZeile = new StringBuffer( "Interativ Zeit" );
      StringBuffer zeitRekursivZeile = new StringBuffer( "Rekursiv Zeit" );
      StringBuffer zeitSonstwieZeile = new StringBuffer( "Sonstwie Zeit" );

      String testString;

      zuLesen.mark( 10000 );

      while((testString = zuLesen.readLine()) != null)
       {
        startZeit = System.nanoTime();
        testErgebnis = palinI.istPalindrom( testString);
        laufZeit = System.nanoTime() - startZeit;
        System.out.println( "\t " + testString + " == " +
                            testErgebnis + " \tbt(" + laufZeit + ")"
                          );
        messReihe += "\n\t\t\t\t" + testString.length() + "," + laufZeit;
        stringLaengenZeile.append( ", " + testString.length() );
        zeitIterativZeile.append( ", " + laufZeit );
       }
      System.out.println( "\n\t" + messReihe ); 
      zuSchreiben.println( stringLaengenZeile.toString() );
      zuSchreiben.println( zeitIterativZeile.toString() );

      zuLesen.reset();
      messReihe = new String (" Berechnungszeiten = " );

      while((testString = zuLesen.readLine()) != null)
       {
        startZeit = System.nanoTime();
        testErgebnis = palinR.istPalindrom( testString);
        laufZeit = System.nanoTime() - startZeit;
        System.out.println( "\t " + testString + " == " + 
                            testErgebnis + " \tbt(" + laufZeit + ")"
                          );
        messReihe += "\n\t\t\t" + testString.length() + "," + laufZeit;
        zeitRekursivZeile.append( ", " + laufZeit );
       }
      System.out.println( "\n\t" + messReihe ); 
      zuSchreiben.println( zeitRekursivZeile.toString() );

      zuLesen.reset();
      messReihe = new String (" Berechnungszeiten = " );

      while((testString = zuLesen.readLine()) != null)
       {
        startZeit = System.nanoTime();
        testErgebnis = palinR.istPalindrom( testString);
        laufZeit = System.nanoTime() - startZeit;
        System.out.println( "\t " + testString + " == " + 
                            testErgebnis + " \tbt(" + laufZeit + ")"
                          );
        messReihe += "\n\t\t\t" + testString.length() + "," + laufZeit;
        zeitSonstwieZeile.append( ", " + laufZeit );
       }
      System.out.println( "\n\t" + messReihe ); 
      zuSchreiben.println( zeitSonstwieZeile.toString() );
        
      zuLesen.close();
      zuSchreiben.close();

      long verarbEnde = System.nanoTime() - verarbBeginn;

      System.out.println("\n\n\t Die Dateiverarbeitung dauerte : " + verarbEnde + " ns\n\n");
   }


    /**
     *  main
     */     
    public static void main( String[] args )
           throws Exception
    {
      final int ZWEI = 2;
      int returnCode = 0;


      if ( args.length < ZWEI )
        {
         System.out.println(
                "\n\n\t Diese Anwendung liefert einen Test-Rahmen fuer die " +
                "\n\t palindrom-Methoden in der MyUeb15Methods-Werkzeug-Klasse " +
                "\n\t Aufruf : java PalindromTester [-s STRING]" +
                "\n\t          oder " +
                "\n\t Aufruf : java PalindromTester [-d DATEIUNAME]" +
                "\n\n"
                );
         System.exit( 1 );
        }


      PalindromTester tester = new PalindromTester();

      try 
        {
           returnCode = tester.start(new String( args[0] ), new String( args[1] ) );
        }
      catch ( DateiExistiertNichtException ex )
           {
             System.err.println( ex  );
           }
      catch ( DateiNichtBearbeitbarException ex )
           {
             System.err.println( ex  );
           }
      catch ( PalindromException ex )
           {
             System.err.println( ex  );
           }
      catch ( Exception ex )
           {
             System.err.println( ex  );
           }

      System.exit( returnCode );
    }
}
