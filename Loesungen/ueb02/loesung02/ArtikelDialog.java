import java.util.Scanner;
    
/**
 *    Die Klasse:  ArtikelDialog.java
 *    Realisiert eine allgemeine Dialog-Klasse fuer
 *    die Artikel-Klasse
 *
 * @version     1.0 Beta 2021_11_04
 * @author  Wolfgang Pauly
 *
 */

public class ArtikelDialog
{
//------------------Konstanten----------------------------------
   private static final int ERZEUGE                   = 10;                        
   private static final int LOESCHE                   = 11;
   private static final int BUCHE_ZUGANG              = 12;
   private static final int BUCHE_ABGANG              = 13;
   
   private static final int ENDE                      = 99;
   
   
   private static final String ARTIKEL_SCHON_VORHANDEN =
            "Es wurde schon ein Artikel angelegt, vor Neuanlage" +
            " bitte den alten Artikel Loeschen !!!";
    
   private static final String KEIN_ARTIKEL_VORHANDEN =
            "Es wurde noch kein Artikel angelegt, " +
            "deshalb ist ein Bearbeiten sinnlos !!!";


   private static final int BESTAND_INIT = -99;
   
//------------------Attribute-----------------------------------
  private Artikel einArtikel;

//----- Eingabe-Attribute-----------------------------------
  private Scanner     in;
  
//------------------Konstruktoren-------------------------------
  /**
    * Standard-Konstruktor fuer ArtikelDialog
    */
   public ArtikelDialog()
   {
     einArtikel = null;

     // Initialisierung der Ein-/Ausgabe
     in = new Scanner( System.in );
   }

   /**
    * start --> laesst die benutzergesteuerte Bedienung 
    *           des Artikel-Test's ablaufen
    * 
    */
   public void start()
   {
         int   auswahl = 0;
     
     while ( auswahl != ENDE )
     {
      try
        {
         auswahl = auswahlFunktion();   
         System.out.println ("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv" );
         switch (auswahl)
           {
            case ERZEUGE :
                 erzeugeArtikel();
                 break;
            case LOESCHE :
                 loescheArtikel();
                 break;
            case BUCHE_ZUGANG :
                 einArtikel.bucheZugang( erfrageZugang() );
                 break;
            case BUCHE_ABGANG :
                 einArtikel.bucheAbgang( erfrageAbgang() );
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
      catch ( java.util.InputMismatchException ex )
        {  
         System.err.println("Folgende Ausnahme ist aufgetreten : \n\t" +
                            ex + "\n\n" +
			    "Geben Sie bitte eine Zahl ein !!!!\n\n"
                           );
         in.nextLine();
        }  
      catch ( IllegalArgumentException ex )
        {  
         System.err.println("Folgende Anwendungs-Ausnahme ist aufgetreten : \n\t" +
                            ex + "\n\n"
                           );
        }   
      catch ( RuntimeException ex )
        {  
         System.err.println("Folgende Anwendungs-Ausnahme ist aufgetreten : \n\t" +
                            ex + "\n\n"
                           );
        } 
        
      if ( einArtikel != null )
        {
         System.out.println("---------------------------------------------------" +
                            "\nDer aktuelle Zustand des Artikels : \n " +
                            einArtikel + "\n"
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
          int auswahl;
          
      System.out.println (
             "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" + 
             "\nErzeuge Artikel           gib ---> " + 
             ERZEUGE +                           
             "\nLoesche  Artikel          gib ---> " + 
             LOESCHE +
             "\nBuche Zugang beim Artikel gib ---> " + 
             BUCHE_ZUGANG +
             "\nBuche Abgang beim Artikel gib ---> " + 
             BUCHE_ABGANG +  
             "\n-------------------------------------" +
             "\nBeende Dialog             gib ---> " + 
             ENDE 
            );
       return readlnInt( "\n\t\t\t  gib --->" );
   }
   
   
   /**
    *  Erfragt vom Benutzer die Daten fuer einen Artikel
    *  und veranlasst das einArtikel einenArtikel zu erzeigen
    *  
    *  @param artikelKennzeichen Kennzeichen des zu behandelnten 
    *         Artikel-Artikels
    */
   private void erzeugeArtikel()
   {
       if ( einArtikel != null )
         {
           throw new RuntimeException( ARTIKEL_SCHON_VORHANDEN );
         }
        
       int    artikelNr, 
              artikelBestand = BESTAND_INIT;
       String artikelArt, helfer;
       char   bestandEingabe = 'x';
       
      artikelNr =  readlnInt("\n\tGeben Sie die Artikel-Nummer ein : ");
      
      System.out.print("\n\tGeben Sie die Artikel-Art ein : ");
      artikelArt = in.nextLine(); 

       
      while ( (bestandEingabe != 'j') && (bestandEingabe != 'n' ) )
        {
         System.out.print("\n\tWollen Sie einen Bestand eingeben  ? (j/n) : ");
         helfer = in.nextLine();
         if ( helfer.trim().length() == 1 )
           {
             bestandEingabe = helfer.toCharArray()[0];
           }
        }

      if ( bestandEingabe == 'j' )
        {
         artikelBestand = readlnInt("\n\tGeben Sie den Artikel-Bestand ein : ");
        }
      
    //vvvvvvvvvvvvvvv moegliche Verbesserung des Programmes vvvvvvvv
    //try
    //  {
          if ( artikelBestand == BESTAND_INIT )
            {
              einArtikel = new Artikel( artikelNr, artikelArt );
            }
          else
            {
              einArtikel = new Artikel( artikelNr, artikelArt,
                                        artikelBestand 
                                      );
            }
    //  }
    //catch ( IllegalArgumentException ex )
    //  {  
    //   System.err.println("Folgende Anwendungs-Ausnahme ist aufgetreten : \n\t" +
    //                      ex + "\n\n" +
    //                      "Es wurde kein Artikel erzeugt !!!!!\n\n"
    //                     );
    //   System.out.println("\n\t!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n" +
    //                      "\t!!!!  Es wurde kein Artikel erzeugt  !!!!!\n" +
    //                      "\t!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
    //                     );                  
    //  } 
   }  
   
   
   /**
    *  Loescht eine vorher erzeugten Artikel
    *  
    *  
    */
   private void loescheArtikel()
   {
     if ( einArtikel == null )
       {
         throw new RuntimeException( KEIN_ARTIKEL_VORHANDEN );
       };
         
     einArtikel = null;
   }   
   
   
   /**
    *  Erfragt vom Benutzer den Artikelzugang fuer einen Artikel
    *  
    *  @return die Zugangs-Zahl
    */
   private int erfrageZugang()
   {
     if ( einArtikel == null )
       {
         throw new RuntimeException( KEIN_ARTIKEL_VORHANDEN );
       };
        
     return readlnInt( "\n\tGeben Sie die Artikel-Zugangszahl ein : " );
   }
   
   
   /**
    *  Erfragt vom Benutzer den Artikelabgang fuer einen Artikel
    *  
    *  @return die Abgangs-Zahl
    */
   private int erfrageAbgang()
   {
     if ( einArtikel == null )
       {
         throw new RuntimeException( KEIN_ARTIKEL_VORHANDEN );
       };
 
     return readlnInt( "\n\tGeben Sie die Artikel-Abgangszahl ein : " );
   }   

   
   /**
    * gibt eine Eingabeaufforderungs-Text aus und
    * liest aus einer Eingabezeile genau die erste Integerzahl
    * und ueberliest den Rest der Zeile
    *  
    *  @param  Eingabeaufforderung Der Eingabe-Aufforderungs-Text
    *  @return die Eingabe-Zahl
    */
   private int readlnInt(String Eingabeaufforderung)
   {
     System.out.print( Eingabeaufforderung );
     int zahl = in.nextInt();
     in.nextLine();
     return zahl;
   } 
   
   /**
    *  main
    */	 
   public static void main( String[] args )
   {
     ArtikelDialog dialog = new ArtikelDialog();

     dialog.start();
   }
}
