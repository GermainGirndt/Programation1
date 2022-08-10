


import java.io.*;
   
/**
 *    Die Klasse:  Artikel.java
 *    realisiert eine allgemeine Artikel-Klasse 
 *
 * @version    1.0 Beta 2021_11_04
 * @author    Wolfgang Pauly
 *
 */

public class Artikel
{

  //----------- MELDUNGS-Konstanten ----------------------
  private static final String  BESTANDS_MELDUNG =
          "Uebergebener Bestand ist ungueltig, da kleiner 0 !!!";

  private static final String  ART_MELDUNG =
          "Uebergebene Artikel-ART ist ungueltig, da ein" + 
          " LEER-String!";

  private static final String  ZUGANG_NEGATIV_MELDUNG =
          "Uebergebener Zugang ist ungueltig, da negativ (kleiner 0) !!!";

  private static final String  ABGANG_NEGATIV_MELDUNG =
          "Uebergebener Abgang ist ungueltig, da negativ (kleiner 0) !!!";

  private static final String  ABGANG_ZUGROSS_MELDUNG =
          "Uebergebener Abgang Uebersteigt Anzahl der vorraetigen Artikel !!!"; 
              


  //----------- Konstanten ----------------------
  private static final int    MIN_BESTAND = 0;
  private static final int    MIN_ZUGANG = 0;
  private static final int    MIN_ABGANG = 0;
  


  //----------- Attribute---------------------
  private  int     artikelNr;
  private  String  art;
  private  int     bestand;

  

  /**
   *    Der (Voll-)Konstruktor mit 3 Parametern
   *    
   *    @param artikelNr    die Artikelnummer des neue Artikels
   *    @param art          die Art des neue Artikels --> darf nicht LEER sein    
   *    @param bestand      der Lagerbestand des neue Artikels --> muss &gt= 0 sein   
   */
  public Artikel (int artikelNr, String art, 
                  int bestand
                 )
  {
    checkArgument( (art.trim().length() <= 0),
                   ART_MELDUNG
                 );
    checkArgument( (bestand < MIN_BESTAND), BESTANDS_MELDUNG );
      
    this.artikelNr   = artikelNr;
    this.art = new String( art.trim() );
    this.bestand     = bestand;
  }

  
 /**
   *    Der (Teil-)Konstruktor mit 2 Parametern;
   *    der Artikelbestand wird auf den Standardwert 0 gesetzt.
   *    
   *    @param artikelNr    die Artikelnummer des neue Artikels
   *    @param art          die Art des neue Artikels  --> darf nicht LEER sein      
   *  
   */
 public Artikel (int artikelNr, String art )
  {
    this( artikelNr, art, MIN_BESTAND );
  }

  
//------------------artikelNr-------------------------------

  /**
   *    gibt Artikel-Attribut : artikelNr zurueck
   *    
   *    @return    Artikel-Nummer
   */
  public int getArtikelNr ( )
  {
    return artikelNr;
  }


//------------------art-------------------------------

  /**
   *    gibt Artikel-Attribut : art zurueck
   *    
   *    @return    Artikel-Art
   */
  public String getArt ( )
  {
    return art;
  }


  /**
   *    setzt Artikel-Attribut :  art
   *    
   *    @param art    neue Art des Artikels   --> darf nicht LEER sein 
   */
  public void setArt ( String art )
  {
    checkArgument( (art.trim().length() <= 0),
                   ART_MELDUNG
                 );
            
    this.art = art.trim();
  }
  
  
//------------------bestand-------------------------------

  /**
   *    gibt Artikel-Attribut : Artikelbestand im Lager zurueck
   *    
   *    @return    Artikel-Bestand
   */
  public int getBestand ( )
  {
    return bestand;
  }
  
  


//------------------sonstige Methoden-------------------------------

  /**
   *    bucht Artikel-Zugaenge zum Lagerbestand
   *    
   *    @param  zugang  Artikel-Zugang --> darf nicht negativ sein 
   */
  public void bucheZugang ( int zugang )
  {
    checkArgument( (zugang < MIN_ZUGANG), ZUGANG_NEGATIV_MELDUNG );

    bestand += zugang;
  }

  /**
   *    bucht Artikel-Abgaenge vom Lagerbestand
   *    
   *    @param  abgang  Artikel-Abgang  --> darf nicht negativ sein
   *                                    --> muss  &lt aktuellem Bestand sein
   */
  public void bucheAbgang ( int abgang )
  {
    checkArgument( (abgang < MIN_ABGANG), ABGANG_NEGATIV_MELDUNG );
    checkArgument( (bestand - abgang <= MIN_BESTAND), ABGANG_ZUGROSS_MELDUNG );

    bestand -= abgang;
  }

 
  
  /**
   *    erzeugt einen Artikel-String
   *    
   */
  public String toString ()
  {
    return  ( "Artikel: "     + artikelNr +
              " Bezeichnung: " + art +
              " Bestand: "     + bestand 
            );
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
