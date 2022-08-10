import java.io.*;
import java.util.Scanner;
    
/**
 *    Die Klasse:  LagerDialog.java
 *    Realisiert eine allgemeine Test-Klasse fuer
 *    die Lager-Klasse
 *
 * @version 3.0 Beta 10.01.2022
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
   private static final int  ENDE                           = 10;



   private final String  FALSCHE_MENUPUNKT_AUSWAHL = "Ungueltige Menue-Auswahl !!!!";


   private enum auswahl { ARTIKEL, CD, VIDEO, BUCH };

   private StringBuffer auswahlString;
 

//--------- Eingabe Attribut --------------------------------
   private Scanner in;


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
         double prozent;
         
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
         System.err.println("Folgende Ausnahme ist aufgetreten : \n\t" +
                            iaex.toString() + "\n\n"
                           );
         iaex.printStackTrace();
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
           throws Exception
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
                     MyInputFunctions.readlnString(in, "\n\tGeben Sie den Cd-Interpreten  ein : ");
                  titel =
                     MyInputFunctions.readlnString(in, "\n\tGeben Sie den Cd-Titel ein : ");
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
    *  main
    */     
   public static void main( String[] args )
   {
    LagerDialog tester = new LagerDialog();
    tester.run();
   }
}
