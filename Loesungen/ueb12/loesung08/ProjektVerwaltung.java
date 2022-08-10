import java.io.*;
import de.htw.saarland.stl.*;
    
/**
 *    Die Klasse:  ProjektVerwaltung.java
 *    Realisiert eine allgemeine Projektverwaltungs-Klasse
 *
 * @version 3.0 Beta 09.01.2013
 * @author  Wolfgang Pauly
 *
 */

public class ProjektVerwaltung
{



//------------------KONSTANTEN----------------------------------

   private final String  FALSCHE_MENUPUNKT_AUSWAHL = "Ungueltige Menue-Auswahl !!!!";

//------------------Verwaltungs-Attribute-----------------------
    
   private enum menuePunkte { 
                             ERZEUGE_PROJEKT,
                             LOESE_PROJEKT_AUF,
                             NEHME_AUFGABE_IN_PROJEKT_AUF,
                             NEHME_PRODUKT_IN_PROJEKT_AUF,
                             NEHME_TEILPROJEKT_IN_PROJEKT_AUF,
                             ENTFERNE_PROJEKTTEIL,
                             BERECHNE_PROJEKT_KOSTEN,
                             ENDE
                           };

   private String[] menueTexte = {
                    "\n\tErzeuge Projekt                   gib ---> ",
                    "\n\tLoese Projekt auf                 gib ---> ",
                    "\n\tNehme Aufgabe in Projekt auf      gib ---> ",
                    "\n\tNehme Produkt in Projekt auf      gib ---> ",
                    "\n\tNehme Teilprojekt in Projekt auf  gib ---> ",
                    "\n\tEntferne Projekt-Teil             gib ---> ",
                    "\n\tBerechne Projektkosten            gib ---> ",
                    "\n\tBeende Projektbearbeitung         gib ---> "
                   };

   private String menue;

//------------------Attribute-----------------------------------

  private Projekt aktuellesProjekt;

//------------------Konstruktoren-------------------------------
  /**
    * Standard-Konstruktor fuer ProjektVerwaltung
    */
   public ProjektVerwaltung()
   {
    aktuellesProjekt = null;

    //Der MenuDialog-String wird nun aufgebaut
    StringBuffer anzeige = new StringBuffer();
    for ( menuePunkte m : menuePunkte.values() )
       {
         anzeige.append( menueTexte[m.ordinal()]).append( m.ordinal() );
       }
    menue = anzeige.toString();
   }



//------------------ run         -------------------------------
   /**
    * run --> laesst die benutzergesteuerte Bedienung 
    *         der Projektverwaltung ablaufen
    * 
    */
   public void run()
   {
     String projektName, projektBeschreibung,
            aufgabenName, produktName, name;

     int    projektStundensatz;


         menuePunkte auswahl;

     auswahl = menuePunkte.values()[0];

     while ( auswahl != menuePunkte.values()[menuePunkte.values().length - 1] )
     {
      try
        {
         auswahl = auswahlFunktion();
         switch (auswahl)
           {
            case ERZEUGE_PROJEKT :
                 existiertProjekt( false );
                 projektName = Stdin.readlnString("Geben sie den Projektnamen ein : ");
                 projektBeschreibung = Stdin.readlnString("Geben eine Projektbeschreibung ein : ");
                 projektStundensatz = Stdin.readlnInt("Geben sie den Projekt-Stundensatz an : ");
                 aktuellesProjekt = new Projekt(projektName, projektBeschreibung, projektStundensatz);
                 break; 

            case LOESE_PROJEKT_AUF :
                 existiertProjekt( true );
                 aktuellesProjekt = null;
                 break; 

            case NEHME_AUFGABE_IN_PROJEKT_AUF :
                 existiertProjekt( true );
                 erzeugeAufgabe();
                 break;

            case NEHME_PRODUKT_IN_PROJEKT_AUF :
                 existiertProjekt( true );
                 erzeugeProdukt();
                 break;

            case NEHME_TEILPROJEKT_IN_PROJEKT_AUF :
                 existiertProjekt( true );
                 erzeugeTeilprojekt();
                 break;

            case ENTFERNE_PROJEKTTEIL :
                 existiertProjekt( true );
                 name = Stdin.readlnString("Geben sie den Namen des zu " + 
                                           "loeschenden Projekt-Teiles  ein : "
                                           );
                 aktuellesProjekt.delete( name );
                 break;

            case BERECHNE_PROJEKT_KOSTEN :
                 existiertProjekt( true );
                 System.out.println("Die Projekkosten betragen : " +
                                     aktuellesProjekt.getKosten() +
                                     "\n\n"
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
      catch ( NumberFormatException nfex )
        {  
         System.err.println("Folgende Ausnahme ist aufgetreten : \n\t" +
                            nfex + "\n\n"
                           );
        } 
      catch ( RuntimeException rex )
        {
         System.err.println("Folgende Ausnahme ist aufgetreten : \n\t" +
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
      catch (AssertionError ae )
        {
         System.err.println("Folgende Assertion ist aufgetreten : \n\t" +
                            ae + "\n\n"
                           );
         ae.printStackTrace();
        }         
     if ( aktuellesProjekt != null )
        {
          System.out.println("\nDas aktuelle Projekt : \n " +
                             aktuellesProjekt + "\n\n"
                            );
        }
     }
    }
   
   


   /**
    *  Erfragt vom Benutzer die als naechstes auszufuehrende Aktion
    *  
    *  @return das Aktionskennzeichen
    */
    private menuePunkte auswahlFunktion()
    {
      int auswahl;
    
      System.out.println ( menue );
      auswahl =  Stdin.readlnInt("\t\t\t\twas --->");
     
      if (auswahl >= 0 && auswahl < menuePunkte.values().length )
        {
         return menuePunkte.values()[auswahl];
        }
      else
        {
         throw new RuntimeException( FALSCHE_MENUPUNKT_AUSWAHL );
        }
   }



   /**
    *  Ueberprueft ob schon ein Firmenlager vorhanden ist,
    * 
    *  @param bedingung == false -- bei Vorhandensein des Lagers wird eine
    *                               Runtime-Exception geworfen
    *                   == true  -- bei NICHT-Vorhandensein des Lagers wird eine
    *                               Runtime-Exception geworfen
    */
    private void existiertProjekt( boolean bedingung )
    {
        if ( bedingung )
          {
           if ( aktuellesProjekt == null )
             {
              throw new RuntimeException( " Projekt existiert noch nicht !!!! " +
                                          "-- zuerst Projekt anlegen "
                                        );
             };
          }
        else
         {
          if ( aktuellesProjekt != null )
            {
             throw new RuntimeException( " Projekt existiert schon !!!  " +
                                          "-- zuerst Projekt aufloesen "
                                       );
            }
         }
  
    }
 
   

   /**
    *  Erfragt vom Benutzer die Daten fuer eine Aufgabe
    *  und fuegt sie dem Projekt hinzu
    * 
    */
   private void erzeugeAufgabe()
           throws Exception
   {
       //Attribute einer Aufgabe
       String aufgabenName, aufgabenBeschreibung;
       int aufgabenAufwand;

       aufgabenName = Stdin.readlnString("Geben sie den Aufgabennamen ein : ");
       aufgabenBeschreibung = Stdin.readlnString("Geben eine Aufgabenbeschreibung ein : ");
       aufgabenAufwand = Stdin.readlnInt("Geben sie den Stunden-Aufwand an : ");

       aktuellesProjekt.add( new Aufgabe( aufgabenName,
                                          aufgabenBeschreibung,
                                          aufgabenAufwand
                                        )
                                     );
   } 
   
   /**
    *  Erfragt vom Benutzer die Daten fuer ein Produkt
    *  und fuegt es dem Projekt hinzu
    * 
    */
   private void erzeugeProdukt()
           throws Exception
   {
       //Attribute eines Produktes
       String produktName, produktBeschreibung;
       double produktKosten;

       produktName = Stdin.readlnString("Geben sie den Produktnamen ein : ");
       produktBeschreibung = Stdin.readlnString("Geben eine Produktbeschreibung ein : ");
       produktKosten = Stdin.readlnInt("Geben sie die Produktkosten an : ");

       aktuellesProjekt.add( new Produkt( produktName,
                                          produktBeschreibung,
                                          produktKosten
                                        )
                                     );
   } 
   
   
   /**
    *  Erfragt vom Benutzer die Daten fuer ein Teilprojekt
    *  und fuegt es dem Projekt hinzu
    * 
    */
   private void erzeugeTeilprojekt()
           throws Exception
   {
       //Attribute eines Projektes
       String teilprojektName, teilprojektBeschreibung;
       double teilprojektStundensatz;

       Projekt teilProjekt;

       teilprojektName = Stdin.readlnString("Geben sie den Projektnamen ein : ");
       teilprojektBeschreibung = Stdin.readlnString("Geben eine Projektbeschreibung ein : ");
       teilprojektStundensatz = Stdin.readlnInt("Geben sie den Projekt-Stundensatz an : ");

       aktuellesProjekt.add( teilProjekt = new Projekt( teilprojektName, 
                                                        teilprojektBeschreibung, 
                                                        teilprojektStundensatz
                                                      )
                            );

      teilProjekt.add( new Aufgabe( "Datensammlung", "Projektdaten sammeln", 200 ) ); 
      teilProjekt.add( new Aufgabe( "Datenauswertung", "Projektdaten auswerten", 400 ) ); 
      teilProjekt.add( new Produkt( "Prototyp 1", "ERSTER Prototyp", 4000 ) ); 
      teilProjekt.add( new Produkt( "Prototyp 2", "ZWEITER Prototyp", 8000 ) ); 
   } 


   /**
    *  main
    */     
   public static void main( String[] args )
   {
    ProjektVerwaltung verwaltung = new ProjektVerwaltung();
    verwaltung.run();
   }
}
