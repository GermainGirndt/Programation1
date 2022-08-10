import java.io.*;
import java.util.*;
    
/**
 *    Die Klasse:  Lager.java
 *    Realisiert eine allgemeine Lager-Klasse fuer
 *    Artikel.
 *
 * @version 2.01 Beta 2021_11_19
 * @author  Iris Ebner / Wolfgang Pauly
 *
 */

public class Lager
{
//------------------Konstanten----------------------------------
  
  public  static final int     STANDARD_GROESSE = 10;
  public  static final String  STANDARD_LAGER_ORT = 
                               " (Ort noch nicht bestimmt) ";
  
  private static final String  DIMENSION_UNGUELTIG =
          "Ein zu konstruierendes Lager muss mindestens 1 Artikel aufnehmen koennen !";
  private static final String  LAGERORT_UNGUELTIG =
          "Der Lagerort-String muss initialisiert und nicht Leer sein !";

  private static final String  LAGER_KOMPLETT_BESETZT =
          "Im Lager sind schon alle Artikel-Lager-Plaetze besetzt !";
  private static final String  ARTIKEL_NICHT_IN_LAGER =
          "Verlangter Buchungs-Artikel nicht in Lager !!!!";
  private static final String  ARTIKEL_SCHON_IN_LAGER =
          "Anzulegender Artikel schon in Lager !!!!";
  
  private static final String  INDEX_UNGUELTIG =
          "Der Index ist zu gross oder zu klein !!!!";          
  
//------------------Attribute----------------------------------
  
  private  Artikel[] lager;
  private  int       letzterBesetzterIndex;
  private  String    lagerOrt;

//------------------Konstruktoren-------------------------------


  /**
   *    Der Konstruktor zur Standard-Initialisierung 
   *    des Lagers
   *        
   */
  public Lager ()
  {
   this( STANDARD_GROESSE, STANDARD_LAGER_ORT );
  }



  /**
   *    Der Konstruktor zur Initialisierung 
   *    eines Lagers mit einer maximalen Anzahl von Artikel-Lagerplaetzen
   *        
   *    @param groesse  == Anzahl der maximal im Lager fuehrbaren Artikel
   */
  public Lager (int groesse)
  {
   this( groesse, STANDARD_LAGER_ORT );
  }


  /**
   *    Der Konstruktor zur Initialisierung 
   *    eines Lagers mit einem Lagerort und Standard-Artikel--Lagerplaetzen
   *        
   *    @param lagerOrt == Ort an dem das Lager existiert
   */
  public Lager (String lagerOrt)
  {
   this( STANDARD_GROESSE, lagerOrt );
  }


  /**
   *    Der Konstruktor zur Initialisierung 
   *    eines Lagers mit einer maximalen Anzahl von Artikel-Lagerplaetzen
   *        
   *    @param groesse  == Anzahl der maximal im Lager fuehrbaren Artikel
   *    @param lagerOrt == Ort an dem das Lager existiert
   */
  public Lager (int groesse, String lagerOrt)
  {
   checkArgument( (groesse <= 0), DIMENSION_UNGUELTIG );
   checkArgument( ( (lagerOrt == null) || (lagerOrt.trim().length() == 0)),
                  LAGERORT_UNGUELTIG 
            );

   this.lagerOrt = new String(lagerOrt); 

   lager = new Artikel[ groesse ];
   letzterBesetzterIndex = -1;

   for ( int lauf = 0; lauf < groesse; lauf++)
     {
      lager[lauf] = null;
     }
  }


//------------------ set-/get-lagerOrt---------------------------------

  /**
   *    gibt Lager-Attribut : lagerOrt zurueck
   *
   *    @return    lagerOrt
   */
  public String getLagerOrt ( )
  {
    return lagerOrt;
  }


  /**
   *    setzt Lager-Attribut :  lagerOrt
   *   
   *    @param lagerOrt     neuer Lager-Ort
   */
  public void setLagerOrt ( String lagerOrt )
  {
   checkArgument( ( (lagerOrt == null) || (lagerOrt.trim().length() == 0)), 
                  LAGERORT_UNGUELTIG
        );

   this.lagerOrt = lagerOrt.trim();
  }

//------------------Artikel anlegen  ---------------------------------


  /**
   *    anlegen eines neuen Artikels und ins Lager einordnen
   *    
   *    @param artikel  der anzulegende Artikel
   */
  public void legeAnArtikel ( Artikel artikel )
  {
    checkArgument( (sucheArtikel( artikel.getArtikelNr() ) != -1 ) ,
                   ARTIKEL_SCHON_IN_LAGER
         );
      
    checkArgument( ( letzterBesetzterIndex >=  lager.length  - 1 ),
                   LAGER_KOMPLETT_BESETZT 
         );

    lager[++letzterBesetzterIndex] = artikel;
  }


//------------------Artikel entfernen ----------------------------------

  /**
   *    entfernt den Artikel anhand seiner Artikel-Nummer aus dem Lager
   *    
   *    @param   artikelNr Nummer des zu loeschenden Artikels
   *             
   */
  public void entferneArtikel ( int artikelNr )
  {
    int fundstelle, schieber;

    //suche Artikel 
    fundstelle = sucheArtikel( artikelNr );

    checkArgument(  ( fundstelle == -1 ), ARTIKEL_NICHT_IN_LAGER );

    //loesche Artikel
    lager[fundstelle] = null;
    letzterBesetzterIndex--;

    //schiebe Lager zusammen
    for ( schieber = fundstelle; schieber <= letzterBesetzterIndex; schieber++ )
       {
        lager[schieber] = lager[schieber + 1];
       }

    if ( schieber + 1 < lager.length )
      {
       lager[schieber + 1] = null;
      }
  }



//------------------ zugang buchen  --------------------------------

  /**
   *    bucht einen Zugang von Artikeln zu dem durch die Artikel-Nummer 
   *    identifizierten Artikel.
   *    
   *    @param   artikelNr Artikel-Nummer, des zu buchenden Artikels
   *    @param zugang hinzukommende Artikel-Anzahl
   */
  public void bucheZugang ( int artikelNr, int zugang )
  {
    int artikelIndex = sucheArtikel( artikelNr );

    checkArgument(  ( artikelIndex == -1 ), ARTIKEL_NICHT_IN_LAGER );

    lager[artikelIndex].bucheZugang( zugang );
  }


//------------------- abgang buchen  --------------------------------

  /**
   *    bucht einen Abgang von Artikeln von dem durch die Artikel-Nummer 
   *    identifizierten Artikel.
   *    
   *    @param   artikelNr Artikel-Nummer, des zu buchenden Artikels
   *    @param abgang weggehende Artikel-Anzahl
   */
  public void bucheAbgang ( int artikelNr, int abgang )
  {
    int artikelIndex = sucheArtikel( artikelNr );

    checkArgument(  ( artikelIndex == -1 ), ARTIKEL_NICHT_IN_LAGER );

    lager[artikelIndex].bucheAbgang( abgang );
  }



  /**
   *    aenderePreisEinesArtikels - erhoeht, vermindert den Preis
   *                               eines anzugebenden Lagerartikels
   *    
   *    @param artikelNr Artikel-Nummer, des zu bearbeitenden Artikels
   *    @param prozent positive Prozentzahl == Preiserhoehung, negative = Preisverminderung
   */
  public void aenderePreisEinesArtikels ( int artikelNr, double prozent )
  {
    int artikelIndex = sucheArtikel( artikelNr );

    checkArgument(  ( artikelIndex == -1 ), ARTIKEL_NICHT_IN_LAGER );

    lager[artikelIndex].aenderePreis( prozent );
  }




  /**
   *    aenderePreisAllerArtikel - erhoeht, vermindert die Preise
   *                               aller Lagerartikel
   *
   *    @param  prozent - positive Prozentzahl == Preiserhoehung, negative = Preisverminderung 
   */
  public void aenderePreisAllerArtikel ( double prozent )
  {
    for ( int lauf = 0; lauf <= letzterBesetzterIndex; lauf++ )
       {
        lager[lauf].aenderePreis( prozent );
       }
  }
 
//------------------- hilfs-Methoden --------------------------------


  /**
   *    sucheArtikel - sucht im Lager Array
   *               nach dem Vorkommen eines Artikels anhand 
   *               der Artikel-Nummer
   *
   *    @param suchArtikelNr - die zu suchende Artikelnummer
   *    @return Index des gefundenen Artikels oder -1, falls der Artikel nicht
   *            im Lager enthalten ist.
   */
  public int sucheArtikel ( int suchArtikelNr )
  {
   int lauf, gefunden;
   
    for ( lauf = 0, gefunden = -1; 
          ( (lauf <= letzterBesetzterIndex) && (gefunden == -1) );
          lauf++ 
        )
       {
        if ( lager[lauf].getArtikelNr() == suchArtikelNr )
          {
            gefunden = lauf;
          }
       }
    return gefunden;
  }

  /**
   *    getArtikelAnzahl - liefert die Anzahl der Artikel im Lager Array
   *                                                
   *    @return Anzahl der momentan im Lager gefuehrten Artikel
   */
  public int getArtikelAnzahl ()
  {
    return letzterBesetzterIndex + 1;    
  }

  /**
   *    getLagerGroesse - liefert die Groesse des Lager Array
   *    Hilfsmethode fuer die Testklasse LagerTest
   *    @author  Iris Ebner
   *
   *    @return lager.length == Anzahl der maximal im Lager fuehrbaren Artikel
   */
  public int getLagerGroesse ()
  {
    return lager.length;    
  }

  /**
   *    getArtikel - liefert den Artikel aus dem Lager, der an der Stelle 
   *    Index gefuert wird
   *    Hilfsmethode fuer die Testklasse LagerTest
   *    @author  Iris Ebner
   *
   *    @param index - der Index des zurueckzugebenden Artikels
   *    @return der Artikel, der an der Stelle Index im Lager gefuehrt wird 
   */  
  public Artikel getArtikel (int index)
  {
      checkArgument( (index >= getLagerGroesse() || index < 0),
                     INDEX_UNGUELTIG 
           );

      return lager[index];
   }

//------------------ toString  --------------------------------------

  /**
   *    erzeugt einen String, der alle, fuer den Klassenbenutzer
   *    wichtigen, Lager-Merkmale enthaelt
   *    
   *    @return die String-Repraesentation des Lagers
   */
  public String toString ()
  {
    String lagerString = new String("Im Lager : " + lagerOrt +
                                    " sind von " + lager.length + 
                                    " Lagerplaetzen " + (letzterBesetzterIndex + 1) +
                                    " belegt, mit folgenden Artikeln : \n");
      
    for ( int lauf = 0; lauf <= letzterBesetzterIndex; lauf++ )
      {
        lagerString +=  "\n\t " + lauf + "\t-> " + lager[lauf];
      }
  
  
   return lagerString;
  }


 /**
  *    wirft bei Fehlersituation eine IllegalArgumentException
  *    
  *    
  *    @param  fehler  -> true  == Fehlersituation
  *                    -> false == KEINE Fehlersituation
  *    @param  meldung -> Fehlermeldungstext zur Fehlersituation
  */
  private void   checkArgument( boolean fehler, String meldung )
  {
   if ( fehler )
     {
      throw new IllegalArgumentException( meldung );
     }
  }

}

