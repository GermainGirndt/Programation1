import java.io.*;
   
/**
 *    Die Klasse:  Artikel.java
 *    realisiert eine allgemeine Artikel-Klasse 
 *
 * @version    1.0 Beta 10.01.2022
 * @author    Wolfgang Pauly
 *
 */

public class Artikel
{

  //----------- Konstanten ----------------------
  private static final int    MIN_BESTAND = 0;
  private static final int    MIN_ZUGANG = 0;
  private static final int    MIN_ABGANG = 0;
  private static final int    MIN_ARTIKEL_NUMMER = 1000;
  private static final int    MAX_ARTIKEL_NUMMER = 9999;
  private static final double MIN_PREIS   = 0.0;
  private static final double MIN_PROZENT = -100.0;


  
  //----------- MELDUNGS-Konstanten ----------------------
  private static final String  ARTIKEL_NUMMER_MELDUNG =
          "Uebergebene Artikelnummer ist ungueltig, " + 
          "da kleiner 1000 oder mehr als 4-Stellig";

  private static final String  BESTANDS_MELDUNG =
          "Uebergebener Bestand ist ungueltig, da kleiner 0 !!!";

  private static final String  ART_MELDUNG =
          "Uebergebene Artikel-ART ist ungueltig, da ein" + 
          " LEER-String o. null-Referenz!";

  private static final String  ZUGANG_NEGATIV_MELDUNG =
          "Uebergebener Zugang ist ungueltig, da negativ (kleiner 0) !!!";

  private static final String  ABGANG_NEGATIV_MELDUNG =
          "Uebergebener Abgang ist ungueltig, da negativ (kleiner 0) !!!";

  private static final String  ABGANG_ZUGROSS_MELDUNG =
          "Uebergebener Abgang Uebersteigt Anzahl der vorraetigen Artikel !!!"; 
              
  private static final String  PROZENT_MELDUNG =
          "Die uebergebene Prozentzahl muss > " + MIN_PROZENT + " sein !!!"; 

  private static final String  PREIS_MELDUNG =
          "Der angegebene Artikelpreis muss >= " + MIN_PREIS + " sein !!!"; 




  //----------- Attribute---------------------
  private  int     artikelNr;
  private  String  art;
  private  int     bestand;
  private  double  preis;
      
  

  /**
   *    Der (Voll-)Konstruktor mit 4 Parametern
   *    
   *    @param artikelNr    die Artikelnummer des neue Artikels -->  es gilt : 1000 &lt= Nummer &lt= 9999
   *    @param art          die Art des neue Artikels --> darf nicht LEER sein    
   *    @param bestand      der Lagerbestand des neue Artikels --> muss &gt= 0 sein   
   *    @param preis        der Preis des neuen Artikels --> muss &gt= 0 sein 
   */
  public Artikel (int artikelNr, String art, 
                  int bestand, double preis
                 )
  {
    checkArgument( ((artikelNr < MIN_ARTIKEL_NUMMER) || (artikelNr > MAX_ARTIKEL_NUMMER)), ARTIKEL_NUMMER_MELDUNG );
    checkArgument( ((art == null) || (art.trim().length() <= 0)),
                   ART_MELDUNG
                 );
    checkArgument( (bestand < MIN_BESTAND), BESTANDS_MELDUNG );
    checkArgument( (preis < MIN_PREIS), PREIS_MELDUNG );
      
    this.artikelNr   = artikelNr;
    this.art         = new String( art.trim() );
    this.bestand     = bestand;
    this.preis       = preis;
  }

  
 /**
   *    Der (Teil-)Konstruktor mit 2 Parametern;
   *    der Artikelbestand wird auf den Standardwert 0 gesetzt.
   *    
   *    @param artikelNr    die Artikelnummer des neue Artikels -->  es gilt : 1000 &lt= Nummer &lt= 9999
   *    @param art          die Art des neue Artikels  --> darf nicht LEER sein      
   *  
   */
 public Artikel (int artikelNr, String art )
  {
    this( artikelNr, art, MIN_BESTAND );
  }

  
  /**
   *    Der (Teil-)Konstruktor mit 3 Parametern
   *    
   *    @param artikelNr    die Artikelnummer des neue Artikels -->  es gilt : 1000 &lt= Nummer &lt= 9999
   *    @param art          die Art des neue Artikels --> darf nicht LEER sein    
   *    @param bestand      der Lagerbestand des neue Artikels --> muss &gt= 0 sein   
   */
 public Artikel (int artikelNr, String art, int bestand )
  {
    this( artikelNr, art, bestand, MIN_PREIS );
  }

  /**
   *    Der (Teil-)Konstruktor mit 3 Parametern
   *    
   *    @param artikelNr    die Artikelnummer des neue Artikels -->  es gilt : 1000 &lt= Nummer &lt= 9999
   *    @param art          die Art des neue Artikels --> darf nicht LEER sein    
   *    @param preis        der Preis des neuen Artikels --> muss &gt= 0 sein 
   */
 public Artikel (int artikelNr, String art, double preis )
  {
    this( artikelNr, art, MIN_BESTAND, preis );
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
    checkArgument( ((art == null) || (art.trim().length() <= 0)),
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
  
  

//
//------------------preis-----------------------------------
  /**
   *    gibt Artikel-Attribut : preis zurueck
   *    
   *    @return    Artikel-Preis
   */
  public double getPreis ( )
  {
    return preis;
  }

  /**
   *    setzt Artikel-Attribut :  preis
   *    
   *    @param preis    neuer preis   --> muss >= 0.0 sein !!!
   */
  public void setPreis ( double neuerPreis )
  {
   checkArgument( ( neuerPreis   < MIN_PREIS ), PREIS_MELDUNG );

   preis = neuerPreis;
  }


 
  /**
   *    aenderePreis aendert Artikelpreis
   *    
   *    @param  prozent - positive Prozentzahl == Preiserhoehung, negative = Preisverminderung
   */
  public void aenderePreis ( double prozent )
  {
   checkArgument( ( prozent < MIN_PROZENT ), PROZENT_MELDUNG );
  
   preis += preis * prozent/100.0;
  }
 

//------------------getBeschreibung---------------------------------

 /**
   *    erzeugt einen Beschreibungs-String, der eine Kurzbeschreibung
   *    des Artikels beinhaltet
   *
   *    @return eine Kurzbeschreibung des Artikels
   *    
   */
  public String getBeschreibung ()
  {
   return String.format( "  %20s", art );
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
    checkArgument( (bestand - abgang < MIN_BESTAND), ABGANG_ZUGROSS_MELDUNG );

    bestand -= abgang;
  }

 
  
  /**
   *    erzeugt einen Artikel-String
   *    
   */
  public String toString ()
  {
   return  String.format( " %4d  %20s %6d %8.2f",
                         artikelNr, art, bestand, preis
           );
  }


  /**
  * Die hashCode-Methode
  *
  * liefert eine eindeutigen Hash-Code zum Objekt ....
  */
  @Override
  public int hashCode() 
  {
   final int prime = 31;
   int result = 1;
   
   result = prime * result + artikelNr;
   result = prime * result + ((art == null) ? 0 : art.hashCode());
   return result;
  }

  /**
  * Die equals-Methode
  *
  * Compares this object to the specified object.
  * The result is true if and only if the argument is not null and is an Person-object
  * that contains the same values for vorname, nachname as this object
  */
  @Override
  public boolean equals(Object obj) 
  {
   if (this == obj)
       return true;
   if (obj == null)
       return false;
   if (getClass() != obj.getClass())
       return false;
  
   Artikel other = (Artikel) obj;
  
   if (artikelNr != other.artikelNr)
        return false;
   if (art == null) 
   {
    if (other.art != null)
        return false;
   } else if (!art.equals(other.art))
              return false;
   return true;
  }
  
  
  /**
   *    wirft bei Fehlersituation eine IllegalArgumentException
   *    
   *    
   *    @param  fehler  -> true  == Fehlersituation
   *                    -> false == KEINE Fehlersituation
   *    @param  meldung -> Fehlermeldungstext zur Fehlersituation
   */
  protected void   checkArgument( boolean fehler, String meldung )
  {
    if ( fehler )
      {
       throw new IllegalArgumentException( meldung );
      }
  }
}
