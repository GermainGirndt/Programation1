import java.io.*;
import java.util.Scanner;
    
/**
 *    Die Klasse:  LagerDialog.java
 *    Realisiert eine allgemeine Test-Klasse fuer
 *    die Lager-Klasse
 *
 * @version 2.0 Beta 2021_11_19
 * @author  Iris Ebner / Wolfgang Pauly
 *
 */

public class LagerDialog
{
//------------------Konstanten----------------------------------
   private static final int ERZEUGE_STANDARD_LAGER         = 10;
   private static final int ERZEUGE_LAGER                  = 11;
   private static final int LOESE_LAGER_AUF                = 12;

   private static final int NEHME_ARTIKEL_IN_LAGER_AUF     = 20;
   private static final int ENTFERNE_ARTIKEL_AUS_LAGER     = 21;
   private static final int BUCHE_ZUGANG_BEI_LAGER_ARTIKEL = 22;
   private static final int BUCHE_ABGANG_BEI_LAGER_ARTIKEL = 23;
   private static final int ZEIGE_EIN_LAGER_ARTIKEL        = 24;
   private static final int WIEVIELE_ARTIKEL_IN_LAGER      = 25;
   private static final int ZEIGE_LAGER_KAPAZITAET         = 26;

   private static final int PREISAENDERUNG_EIN_ARTIKEL     = 31;
   private static final int PREISAENDERUNG_ALLE_ARTIKEL    = 32;

   private static final int ENDE                           = 99;

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
   }



//------------------ run         -------------------------------
   /**
    * run --> laesst die benutzergesteuerte Bedienung 
    *         des Lager-Dialogs ablaufen
    * 
    */
   public void run()
   {
         int   auswahl, artikelNr, index;
     
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
                 nehmeArtikelInLagerAuf();
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

            case ZEIGE_EIN_LAGER_ARTIKEL :
                 existiertFirmenLager( true );
                 index =  MyInputFunctions.readlnInt(in, "\n\tGeben Sie den Artikel-Index " +
                                                    " des zu gesuchten Artikels ein : "
                                             );
                 firmenLager.getArtikel( index );
             break;
            case WIEVIELE_ARTIKEL_IN_LAGER :
                 existiertFirmenLager( true );
             System.out.println ("\n Momentan befinden sich : " + 
                             firmenLager.getArtikelAnzahl() +
                     " verschiedene Artikel auf Lager\n"
                    );
             break;
            case ZEIGE_LAGER_KAPAZITAET :
                 existiertFirmenLager( true );
             System.out.println ("\n Das Lager kann maximal " + 
                             firmenLager.getLagerGroesse() +
                     " == " +
                     Lager.STANDARD_GROESSE + 
                     " verschiedene Artikel aufnehmen.\n"
                    );
             break;

            case PREISAENDERUNG_EIN_ARTIKEL :
                 existiertFirmenLager( true );
                 artikelNr =  MyInputFunctions.readlnInt(in, "\n\tGeben Sie die Artikel-Nummer " +
                                              " des Artikels ein, dessen Preis geaendert werden soll : "
                                             );
                 prozent =  MyInputFunctions.readlnDouble(in, "\n\tGeben Sie Prozentzahl " +
                                               "\n\t\t --> positive Zahl == Preiserhoehung," +
                                               "\n\t\t --> negative Zahl == Preisverminderung" +
                                               "\n\t ein : "
                                              );
                 firmenLager.aenderePreisEinesArtikels( artikelNr, prozent );
                 break;

            case PREISAENDERUNG_ALLE_ARTIKEL :
                 existiertFirmenLager( true );
                 prozent =  MyInputFunctions.readlnDouble(in, "\n\tGeben Sie Prozentzahl " +
                                               "\n\t\t --> positive Zahl == Preiserhoehung," +
                                               "\n\t\t --> negative Zahl == Preisverminderung" +
                                               "\n\t ein : "
                                              );
                 firmenLager.aenderePreisAllerArtikel( prozent );
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
      catch ( IllegalArgumentException rex )
        {
         System.err.println("Artikel-/Lager-Exception gefangen !!!\n" +
                        "Folgende Ausnahme ist aufgetreten : \n\t" +
                            rex + "\n\n"
                           );
        } 
      catch ( Exception ex )
        {
         System.err.println("Folgende Ausnahme ist aufgetreten : \n\t" +
                            ex + "\n\n"
                           );
        } 
        
      if ( firmenLager != null )
        {
          System.out.println("\nDer aktuelle Lager-Bestand : \n " +
                             firmenLager + "\n\n"
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
             "\nZeige Artikel via INDEX             gib ---> " +
             ZEIGE_EIN_LAGER_ARTIKEL +
             "\nZeige Anzahl der Artikel im Lager   gib ---> " +
             WIEVIELE_ARTIKEL_IN_LAGER +
             "\nZeige die Artikel-Lager-Kapazitaet  gib ---> " +
             ZEIGE_LAGER_KAPAZITAET +
             "\n------------------------------------------------------" +
             "\nAendere Preise fuer einen Artikel   gib ---> " +
             PREISAENDERUNG_EIN_ARTIKEL +
             "\nAendere Preise fuer alle Artikel    gib ---> " +
             PREISAENDERUNG_ALLE_ARTIKEL +
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
             }
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
    *  @param aktuellesLager -- das momentan zu bearbeitende Lager
    *         Lager-Artikels
    */
   private void nehmeArtikelInLagerAuf()
   {

       //Attribute eines Artikels
       int    artikelNr, artikelBestand;
       double artikelPreis;
       String artikelArt;

      // wir lesen die allgemeinen Artikel-Daten
      artikelNr =
             MyInputFunctions.readlnInt(in, "\n\tGeben Sie die Artikel-Nummer ein : ");
      artikelArt =
             MyInputFunctions.readlnString(in, "\n\tGeben Sie die Artikel-Art ein : ");
      artikelBestand =
             MyInputFunctions.readlnInt(in, "\n\tGeben Sie den Artikel-Bestand ein : ");
      artikelPreis =
             MyInputFunctions.readlnDouble(in, "\n\tGeben Sie den Artikel-Preis ein : ");

      try 
        {
         firmenLager.legeAnArtikel ( new Artikel( artikelNr, artikelArt,
                                                  artikelBestand, artikelPreis
                                                )
                             );
        }
      catch ( IllegalArgumentException rex )
        {
         System.err.println("Artikel-Exception gefangen !!!\n" +
                        "Artikel-Objekt-Konstruktion nicht gelungen : \n\t" +
                            rex + "\n\n" +
                            " Es wurde KEIN Artikel erzeugt und in Lager aufgenommen !!!!\n\n"
                           );
        } 
      catch ( RuntimeException rex )
        {
         System.err.println("Lager-Exception gefangen !!!\n" +
                        "Folgende Ausnahme ist aufgetreten : \n\t" +
                            rex + "\n\n" +
                            " Es wurde KEIN Artikel erzeugt und in Lager aufgenommen !!!!\n\n"
                           );
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
    LagerDialog dialog = new LagerDialog();
    dialog.run();
   }
}
