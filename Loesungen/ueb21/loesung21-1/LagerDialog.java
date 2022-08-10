import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Random;

//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
// neu in ueb18
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

/**
 *    Die Klasse:  LagerDialog.java
 *    Realisiert eine allgemeine Test-Klasse fuer
 *    die Lager-Klasse
 *
 * @version 3.0 Beta 10.01.2022 erweitert 02.06.2022
 * @author  Wolfgang Pauly
 *
 */

public class LagerDialog
{

//------------------KONSTANTEN----------------------------------
   private static final int  ERZEUGE_STANDARD_LAGER         =  0;
   private static final int  ERZEUGE_LAGER                  =  1;
   private static final int  LOESE_LAGER_AUF                =  2;
   private static final int  NEHME_ARTIKEL_IN_LAGER_AUF     =  3;
   private static final int  ENTFERNE_ARTIKEL_AUS_LAGER     =  4;
   private static final int  BUCHE_ZUGANG_BEI_LAGER_ARTIKEL =  5;
   private static final int  BUCHE_ABGANG_BEI_LAGER_ARTIKEL =  6;
   private static final int  PREISAENDERUNG                 =  7;
   private static final int  ZEIGE_BESTANDS_LISTE           =  8;
   private static final int  ZEIGE_LAGER                    =  9;

   private static final int  ERSTELLE_TEST_LAGER            = 50;
   private static final int  TEST_AUFGABE18_c_i             = 51;
   private static final int  TEST_AUFGABE18_c_ii            = 52;
   private static final int  TEST_AUFGABE18_c_iii           = 53;
   private static final int  TEST_AUFGABE18_c_iv            = 54;
   private static final int  TEST_AUFGABE18_h_i             = 55;
   private static final int  TEST_AUFGABE18_h_ii            = 56;
   private static final int  TEST_AUFGABE18_h_iii           = 57;
   private static final int  TEST_AUFGABE18_h_iv            = 58;
   private static final int  TEST_AUFGABE18_h_v             = 59;
   private static final int  TEST_AUFGABE18_h_vi            = 60;

   private static final int  ENDE                           = 99;



   private final String  FALSCHE_MENUPUNKT_AUSWAHL = "Ungueltige Menue-Auswahl !!!!";


   private enum auswahl { ARTIKEL, CD, VIDEO, BUCH };

   private StringBuffer auswahlString;
 

//--------- Eingabe Attribut --------------------------------
   private Scanner in;
   private Ueb18Fassade fassade;


//------------------Attribute-----------------------------------

  private Lager firmenLager;

//------------------Konstruktoren-------------------------------
  /**
    * Standard-Konstruktor fuer LagerDialog
    */
   public LagerDialog()
   {
    firmenLager = null;
    in = new Scanner( System.in );
    fassade = new Ueb18Fassade();

    auswahlString = new StringBuffer ("\n\nWelcher ArtikelArt wollen Sie aufnehmen ???\n\t");
    for (auswahl a : auswahl.values()) 
       {
        auswahlString.append(a).append("\tdann gib ---> ")
                     .append(a.ordinal()).append("\n\t");
       }
    auswahlString.append("waehle : ");
   }


//
//
//------------------ run         -------------------------------
   /**
    * run --> laesst die benutzergesteuerte Bedienung 
    *         des Lager-Test's ablaufen
    * 
    */
   public void run()
   {
         int auswahl, artikelNr;
     
         String lagerOrt;
         int    lagerGroesse;
     double prozent, minPreis, maxPreis;
     Artikel[] ergebnisListe;
         String gesuchterAutor; 
     auswahl = 0;
     
     while ( auswahl != ENDE )
     {
      try
        {
         auswahl = auswahlFunktion();
         switch (auswahl)
           {
            case ERZEUGE_STANDARD_LAGER :
                 existiertFirmenLager( false );
                 lagerOrt = MyInputFunctions.readlnString(in, "Geben sie den Ort des Lagers ein : ");
                 firmenLager = new Lager(lagerOrt);
                 break; 

            case ERZEUGE_LAGER :
                 existiertFirmenLager( false );
                 lagerOrt = MyInputFunctions.readlnString(in, "Geben sie den Ort des Lagers ein : ");
                 lagerGroesse = MyInputFunctions.readlnInt(in, "Geben sie die Groesse des Lagers an : ");
                 firmenLager = new Lager(lagerGroesse, lagerOrt);
                 break; 

            case LOESE_LAGER_AUF :
                 existiertFirmenLager( true );
                 firmenLager = null;
                 break; 

            case NEHME_ARTIKEL_IN_LAGER_AUF :
                 existiertFirmenLager( true );
                 erzeugeLagerPosition();
                 break;

            case ENTFERNE_ARTIKEL_AUS_LAGER :
                 existiertFirmenLager( true );
                 artikelNr =  MyInputFunctions.readlnInt(in, "\n\tGeben Sie die Artikel-Nummer " +
                                              " des zu entfernenden Artikels ein : "
                                             );
                 firmenLager.entferneArtikel( artikelNr);
                 break;

            case BUCHE_ZUGANG_BEI_LAGER_ARTIKEL :
                 existiertFirmenLager( true );
                 artikelNr =  MyInputFunctions.readlnInt(in, "\n\tGeben Sie die Artikel-Nummer " +
                                              " des zu buchenden Artikels ein : "
                                             );
                 firmenLager.bucheZugang( artikelNr, erfrageZugang() );
                 break;

            case BUCHE_ABGANG_BEI_LAGER_ARTIKEL :
                 existiertFirmenLager( true );
                 artikelNr =  MyInputFunctions.readlnInt(in, "\n\tGeben Sie die Artikel-Nummer " +
                                              " des zu buchenden Artikels ein : "
                                             );
                 firmenLager.bucheAbgang( artikelNr, erfrageAbgang() );
                 break;

            case PREISAENDERUNG :
                 existiertFirmenLager( true );
                 prozent =  MyInputFunctions.readlnDouble(in, "\n\tGeben Sie Prozentzahl " +
                                               "\n\t\t --> positive Zahl == Preiserhoehung," +
                                               "\n\t\t --> negative Zahl == Preisverminderung" +
                                               "\n\t ein : "
                                              );
                 firmenLager.aenderePreisAllerArtikel( prozent );
                 break;

            case ZEIGE_BESTANDS_LISTE :
                 existiertFirmenLager( true );
                 System.out.println( firmenLager.ausgebenBestandsListe() );
                 break;
                 
            case ZEIGE_LAGER :
                 existiertFirmenLager( true );
                 System.out.println( firmenLager );
                 break;
                 
            case ERSTELLE_TEST_LAGER:
                 erstelleTestLager();
                 break;
            
            case TEST_AUFGABE18_c_i:
                 existiertFirmenLager( true );
                 ergebnisListe = fassade.aufgabe_c_i( firmenLager );
             for(int i = 0; i < ergebnisListe.length; i++)
              System.out.println( ergebnisListe[i] );
                 break;
           
            case TEST_AUFGABE18_c_ii:
                 existiertFirmenLager( true );
                 fassade.aufgabe_c_ii( firmenLager );
                 break;
             
            case TEST_AUFGABE18_c_iii:
                 existiertFirmenLager( true );
                 fassade.aufgabe_c_iii( firmenLager );
                 break;
             
            case TEST_AUFGABE18_c_iv:
                 existiertFirmenLager( true );
                 fassade.aufgabe_c_iv( firmenLager );
                 break;
             
            case TEST_AUFGABE18_h_i:
                 existiertFirmenLager( true );
                 fassade.aufgabe_h_i( firmenLager );
                 break;

            case TEST_AUFGABE18_h_ii:
                 existiertFirmenLager( true );
                 fassade.aufgabe_h_ii( firmenLager );
                 break;

            case TEST_AUFGABE18_h_iii:
                 existiertFirmenLager( true );
                 gesuchterAutor = MyInputFunctions.readlnString(
                                         in, "\n\tGeben Sie den gesuchten Autor ein : "
                                  );
                 fassade.aufgabe_h_iii( firmenLager, gesuchterAutor );
                 break;

            case TEST_AUFGABE18_h_iv:
                 existiertFirmenLager( true );
                 fassade.aufgabe_h_iv( firmenLager );
                 break;

            case TEST_AUFGABE18_h_v:
                 existiertFirmenLager( true );
                 ergebnisListe = fassade.aufgabe_h_v( firmenLager );

                 System.out.println("\n\n Zeige alle Buecher sortiert nach Autor an :\n");
             for(int i = 0; i < ergebnisListe.length; i++)
              System.out.println( ergebnisListe[i] );
                 break;

            case TEST_AUFGABE18_h_vi:
                 existiertFirmenLager( true );
                 gesuchterAutor = MyInputFunctions.readlnString(
                                         in, "\n\tGeben Sie den Autor ein : "
                                  );
                 minPreis =  MyInputFunctions.readlnDouble(in, "\n\tGeben Sie den Minimal-Preis ein : ");
                 maxPreis =  MyInputFunctions.readlnDouble(in, "\n\tGeben Sie den Maximalen-Preis ein : ");
                 ergebnisListe = fassade.aufgabe_h_vi( firmenLager, gesuchterAutor, minPreis, maxPreis );
                 System.out.println("\n\n Filterergebniss für : ist Buch von " + gesuchterAutor +
                                    " Preis > " + minPreis + " und < " + maxPreis + " \n");
             for(int i = 0; i < ergebnisListe.length; i++)
              System.out.println( ergebnisListe[i] );
                 break;

            case ENDE :
                 System.out.println("\n\nWeiterhin viel Spass bei der Arbeit !!!\n\n");
                 break;

            default :
                 System.out.println("\n\n Falsche Auswahl-Eingabe !!!\n");
                 break;
           }
        }
      catch ( NumberFormatException nfex )
        {  
         System.err.println("Folgende Ausnahme ist aufgetreten : \n\t" +
                            nfex + "\n\n"
                           );
        } 
      catch ( IllegalArgumentException iaex )
        {
         System.err.println("Folgende ARTIKEL-Ausnahme ist aufgetreten : \n\t" +
                            iaex.toString() + "\n\n"
                           );
         iaex.printStackTrace();
        } 
      catch ( RuntimeException rex )
        {
         System.err.println("Folgende LAGER-Ausnahme ist aufgetreten : \n\t" +
                            rex.toString() + "\n\n"
                           );
         rex.printStackTrace();
        } 
       catch ( Exception ex )
         {
          System.err.println("Folgende Ausnahme ist aufgetreten : \n\t" +
                             ex + "\n\n"
                            );
          ex.printStackTrace();
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
             "\nErzeuge STANDARD-Lager              gib ---> " +
             ERZEUGE_STANDARD_LAGER +
             "\nErzeuge Lager                       gib ---> " +
             ERZEUGE_LAGER +
             "\nLoese Lager auf                     gib ---> " +
             LOESE_LAGER_AUF +
             "\n------------------------------------------------------" +
             "\nErzeuge  Artikel                    gib ---> " +
             NEHME_ARTIKEL_IN_LAGER_AUF +
             "\nLoesche  Artikel                    gib ---> " +
             ENTFERNE_ARTIKEL_AUS_LAGER +
             "\nBuche Zugang bei einem  Artikel     gib ---> " +
             BUCHE_ZUGANG_BEI_LAGER_ARTIKEL +
             "\nBuche Abgang bei einem  Artikel     gib ---> " +
             BUCHE_ABGANG_BEI_LAGER_ARTIKEL +
             "\n------------------------------------------------------" +
             "\nAendere Preise fuer alle Artikel    gib ---> " +
             PREISAENDERUNG +
             "\n------------------------------------------------------" +
             "\nZeige Bestandsliste des Lagers an   gib ---> " +
             ZEIGE_BESTANDS_LISTE +
             "\nZeige Lager an                      gib ---> " +
             ZEIGE_LAGER +
             "\n------------------------------------------------------" +
             "\n" +
             "\n----------Tests für Aufgabe 18.2 c -------------------" +
             "\nErstelle Test-Lager                 gib ---> " +
             ERSTELLE_TEST_LAGER +                     
             "\nTest Aufgabe 18.2 c i               gib ---> " +
             TEST_AUFGABE18_c_i +         
             "\nTest Aufgabe 18.2 c ii              gib ---> " +
             TEST_AUFGABE18_c_ii +     
             "\nTest Aufgabe 18.2 c iii             gib ---> " +
             TEST_AUFGABE18_c_iii +     
             "\nTest Aufgabe 18.2 c iv              gib ---> " +
             TEST_AUFGABE18_c_iv +     
             "\n" +
             "\n----------Tests für Aufgabe 18.2 h -------------------" +
             "\nTest Aufgabe 18.2 h i               gib ---> " +
             TEST_AUFGABE18_h_i +
             "\nTest Aufgabe 18.2 h ii              gib ---> " +
             TEST_AUFGABE18_h_ii +
             "\nTest Aufgabe 18.2 h iii             gib ---> " +
             TEST_AUFGABE18_h_iii +
             "\nTest Aufgabe 18.2 h iv              gib ---> " +
             TEST_AUFGABE18_h_iv +
             "\nTest Aufgabe 18.2 h v               gib ---> " +
             TEST_AUFGABE18_h_v +
             "\nTest Aufgabe 18.2 h vi              gib ---> " +
             TEST_AUFGABE18_h_vi +
             "\n" +

             "\n------------------------------------------------------" +
             "\nBeende Test                         gib ---> " +
             ENDE
            );
       return MyInputFunctions.readlnInt(in, "\t\t\t\tgib --->");
   }


   /**
    *  Ueberprueft ob schon ein Firmenlager vorhanden ist,
    * 
    *  @param bedingung == false -- bei Vorhandensein des Lagers wird eine
    *                               Runtime-Exception geworfen
    *                   == true  -- bei NICHT-Vorhandensein des Lagers wird eine
    *                               Runtime-Exception geworfen
    */
    private void existiertFirmenLager( boolean bedingung )
    {
        if ( bedingung )
          {
           if ( firmenLager == null )
             {
              throw new RuntimeException( " Firmenlager existiert noch nicht !!!! -- zuerst Lager anlegen ");
             };
          }
        else
         {
          if ( firmenLager != null )
            {
             throw new RuntimeException( " Firmenlager existiert schon !!!  -- zuerst Lager aufloesen ");
            }
         }
  
    }
 

   
   /**
    *  Erfragt vom Benutzer die Daten fuer einen Artikel
    *  und veranlasst das Lager den erzeugen Artikel
    *  aufzunehmen
    * 
    */
   private void erzeugeLagerPosition()
   {
       auswahl was = null;
       int wasEingabe = -10;

       //Attribute eines Artikels
       int    artikelNr, artikelBestand, artikelMindestBestand;
       double artikelPreis;
       String artikelArt;

       //Zusatz-Attribute einer CD
       String interpret, titel;
       int    anzahlMusikTitel;

       //Zusatz-Attribute eines Videos
       int  spieldauer;
       int    erscheinungsjahr;

       //Zusatz-Attribute eines Buches
       String autor, verlag;



      // wir fragen was soll erzeugt werden ???-1
      while ( (wasEingabe < 0) || (wasEingabe > auswahl.values().length) )
        {
          wasEingabe = MyInputFunctions.readlnInt(in,  auswahlString.toString() );
          if (wasEingabe >= 0 && wasEingabe < auswahl.values().length)
            {
             was = auswahl.values()[wasEingabe];
            }
        }
      


      // wir lesen die allgemeinen Artikel-Daten
      artikelNr =
             MyInputFunctions.readlnInt(in, "\n\tGeben Sie die Artikel-Nummer ein : ");
      artikelBestand =
             MyInputFunctions.readlnInt(in, "\n\tGeben Sie den Artikel-Bestand ein : ");
      artikelPreis =
             MyInputFunctions.readlnDouble(in, "\n\tGeben Sie den Artikel-Preis ein : ");


      switch ( was )
        {
         case ARTIKEL :
                  artikelArt =
                         MyInputFunctions.readlnString(in, "\n\tGeben Sie die Art des Artikels ein : ");
                  firmenLager.legeAnArtikel( new Artikel( artikelNr, artikelArt,
                                                          artikelBestand,
                                                          artikelPreis
                                           )
                                     );
                  break;
         case CD :
                  interpret =
                     MyInputFunctions.readlnString(in, "\n\tGeben Sie den CD-Interpreten  ein : ");
                  titel =
                     MyInputFunctions.readlnString(in, "\n\tGeben Sie den CD-Titel ein : ");
                  anzahlMusikTitel =
                     MyInputFunctions.readlnInt(in, "\n\tGeben Sie die MusikTitel-Anzahl ein : ");


                  firmenLager.legeAnArtikel( new CD( artikelNr, 
                                                     artikelBestand,
                                                     artikelPreis, interpret,
                                                     titel, anzahlMusikTitel
                                             )
                                     );
                  break;
         case VIDEO :
                  titel =
                     MyInputFunctions.readlnString(in, "\n\tGeben Sie den Video-Titel ein : ");
                  spieldauer =
                     MyInputFunctions.readlnInt(in, "\n\tGeben Sie die Video-Spieldauer ein : ");
                  erscheinungsjahr =
                     MyInputFunctions.readlnInt(in, "\n\tGeben Sie das Video-Erscheinugnsjahr ein : ");

                  firmenLager.legeAnArtikel( new Video( artikelNr, 
                                                        artikelBestand,
                                                        artikelPreis, titel,
                                                        spieldauer, erscheinungsjahr
                                             )
                                    );
                  break;
         case BUCH :
                  autor =
                     MyInputFunctions.readlnString(in, "\n\tGeben Sie den Buch-Autor  ein : ");
                  titel =
                     MyInputFunctions.readlnString(in, "\n\tGeben Sie den Buch-Titel ein : ");
                  verlag =
                     MyInputFunctions.readlnString(in, "\n\tGeben Sie den Buch-Verlag ein : ");
                  firmenLager.legeAnArtikel( new Buch( artikelNr,
                                                       artikelBestand,
                                                       artikelPreis, autor,
                                                       titel, verlag
                                              )
                                    );
                  break;
        }
   } 
   


   /**
    *  Erfragt vom Benutzer den Lagerzugang fuer einen Artikel
    *  
    *  @return die Zugangs-Zahl
    */
   private int erfrageZugang()
   {
    return MyInputFunctions.readlnInt(in, "\n\tGeben Sie die Artikel-Zugangszahl ein : ");
   }
   
   
   /**
    *  Erfragt vom Benutzer den Lagerabgang fuer einen Artikel
    *  
    *  @return die Abgangs-Zahl
    */
   private int erfrageAbgang()
   {
    return MyInputFunctions.readlnInt(in, "\n\tGeben Sie die Artikel-Abgangszahl ein : ");
   }   
   
   
  /**
   * erstellt ein neues, zufällig befülltes Lager
   */
  private void erstelleTestLager()
  {
      Random ran = new Random();
      int anzahlBuecher = ran.nextInt(10) + 3;
      int anzahlVideos = ran.nextInt(10) + 3;
      int anzahlCDs = ran.nextInt(10) + 3;
      int lagerGroesse = 5 + anzahlBuecher + anzahlCDs + anzahlVideos;

      firmenLager = new Lager(lagerGroesse, "Saarbruecken");
      
      firmenLager.legeAnArtikel(new Buch(ran.nextInt(9000)+1000, 
                                   ran.nextInt(5), 12.99 , "Goethe", "titel"+ran.nextInt(100), 
                       "verlag"+ran.nextInt(100)
                      ));

      firmenLager.legeAnArtikel(new Buch(ran.nextInt(9000)+1000, 
                                   ran.nextInt(5), 25.99 , "Goethe", "titel"+ran.nextInt(100), 
                       "verlag"+ran.nextInt(100)
                      ));

      firmenLager.legeAnArtikel(new Buch(ran.nextInt(9000)+1000, 
                                   ran.nextInt(5), 55.99 , "Goethe", "titel"+ran.nextInt(100), 
                       "verlag"+ran.nextInt(100)
                      ));

      firmenLager.legeAnArtikel(new Buch(ran.nextInt(9000)+1000, 
                                   ran.nextInt(5), 77.99 , "Goethe", "titel"+ran.nextInt(100), 
                       "verlag"+ran.nextInt(100)
                      ));

      firmenLager.legeAnArtikel(new Buch(ran.nextInt(9000)+1000, 
                                   ran.nextInt(5), 99.99, "Goethe", "titel"+ran.nextInt(100), 
                       "verlag"+ran.nextInt(100)
                      ));  

      for(int i=0; i<anzahlVideos; i++)
         {
          firmenLager.legeAnArtikel(new Video(ran.nextInt(9000)+1000, 
                                        ran.nextInt(100), Math.abs(ran.nextDouble()) * 100, "titel"+ran.nextInt(100),
                            ran.nextInt(240), 2000
                           ));
         }

      for(int i=0; i<anzahlCDs; i++)
         {
          firmenLager.legeAnArtikel(new CD(ran.nextInt(9000)+1000, 
                                     ran.nextInt(50), Math.abs(ran.nextDouble()) * 100, "interpret"+ran.nextInt(100),
                         "titel"+ran.nextInt(100), ran.nextInt(19)+1 
                        ));     
         }

      for(int i=0; i<anzahlBuecher; i++)
         {
          firmenLager.legeAnArtikel(new Buch(ran.nextInt(9000)+1000, 
                                       ran.nextInt(5), Math.abs(ran.nextDouble()) * 100, "autor"+ran.nextInt(100),
                           "titel"+ran.nextInt(100), "verlag"+ran.nextInt(100)
                          ));
         }
  }

   
   /**
    *  main
    */     
   public static void main( String[] args )
   {
    LagerDialog tester = new LagerDialog();
    tester.run();
   }
}
