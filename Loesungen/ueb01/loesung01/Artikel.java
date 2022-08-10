


import java.io.*;
   
/**
 *    Die Klasse:  Artikel.java
 *    realisiert eine allgemeine Artikel-Klasse 
 *
 * @version    1.0 Beta 2021_10_28
 * @author    Wolfgang Pauly
 *
 */

public class Artikel
{
  //----------- Konstanten ----------------------
  private static final int    MIN_BESTAND = 0;

  //----------- Attribute---------------------
  private  int     artikelNr;
  private  String  art;
  private  int     bestand;

  

  /**
   *    Der (Voll-)Konstruktor mit 3 Parametern
   *    
   *    @param artikelNr    die Artikelnummer des neue Artikels 
   *    @param art          die Art des neue Artikels 
   *    @param bestand      der Lagerbestand des neue Artikels 
   */
  public Artikel (int artikelNr, String art, 
                  int bestand
                 )
  {
   this.artikelNr = artikelNr;
   this.art       = new String( art );
   this.bestand   = bestand;
  }

  
 /**
   *    Der (Teil-)Konstruktor mit 2 Parametern;
   *    der Artikelbestand wird auf den Standardwert 0 gesetzt.
   *    
   *    @param artikelNr    die Artikelnummer des neue Artikels 
   *    @param art          die Art des neue Artikels  
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
   *    @param art    neue Artikel-Art   
   */
  public void setArt ( String art )
  {
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
   *    @param  zugang  Artikel-Zugang 
   */
  public void bucheZugang ( int zugang )
  {
   bestand += zugang;
  }

  /**
   *    bucht Artikel-Abgaenge vom Lagerbestand
   *    
   *    @param  abgang  Artikel-Abgang  
   *                                    
   */
  public void bucheAbgang ( int abgang )
  {
   bestand -= abgang;
  }

 
  
  /**
   *    erzeugt einen Artikel-String
   *    
   *    @return    Stringrepraesentation des Objekt-Zustandes
   */
  public String toString ()
  {
   return  ( "  Artikel: "     + artikelNr +
             "  Bezeichnung: " + art +
             "  Bestand: "     + bestand 
           );
  }
}
