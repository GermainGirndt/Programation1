import java.io.*;


/**
 *    Die Klasse:  Video.java
 *    Realisiert eine Video-Klasse
 *
 * @version    2.0 Beta 10.01.2022
 * @author    Wolfgang Pauly
 *
 */

public class Video
       extends Artikel      
{
//------------------Konstanten----------------------------------
  private static final String BEZEICHNUNG  = "Medien";

  public static final int MIN_ERSCHEINUNGSJAHR = 1900;
  public static final int MAX_ERSCHEINUNGSJAHR = 2022;

  private static final String  TITEL_MELDUNG = 
          "Uebergebener Titel ist ungueltig, da ein LEER-String !";
  private static final String  SPIELDAUER_MELDUNG = 
          "Uebergebene Spieldauer ist ungueltig, da kleiner 0 !";
  private static final String  ERSCHEINUNGSJAHR_MELDUNG = 
          "Uebergebenes Erscheinungsjahr liegt nicht zwischen " +
           MIN_ERSCHEINUNGSJAHR + " und " + MAX_ERSCHEINUNGSJAHR +
          " !!!";
  
//------------------Attribute----------------------------------
  
  private  String  titel;
  private  int  spieldauer;
  private  int     jahr;

//------------------Konstruktoren-------------------------------


  /**
   *    Der Konstruktor zur Voll-Initialisierung
   *
   *    @param artikelNr initial Video-Artikelnummer
   *    @param bestand initial Video-Bestand
   *    @param preis initial Video-Preis
   *    @param titel initial Video-Titel
   *    @param spieldauer initial Video-Spieldauer
   *    @param jahr initial Video-Erscheinungsjahr
   */
  public Video ( int artikelNr, int bestand, double preis, 
                 String titel, int spieldauer, int jahr
             )
  {
   super( artikelNr, BEZEICHNUNG, bestand, preis 
        );
   setVideoAttributes( titel, spieldauer, jahr );
  }  


  /**
   *    die Hilfs-Methode zu Konstruktion von Video-Objekten
   *
   *    @param titel initial Video-Titel
   *    @param spieldauer initial Video-Spieldauer
   *    @param jahr initial Video-Erscheinungsjahr
   */
  private void setVideoAttributes ( String titel, int spieldauer,
                                    int jahr 
                                )
  {
   setTitel( titel );
   setSpieldauer( spieldauer );
   setJahr( jahr );
  }  
  

//------------------titel-------------------------------

  /**
   *    gibt Video-Attribut : titel zurueck
   *    
   *    @return    Video-Titel
   */
  public String getTitel ( )
  {
    return titel;
  }


  /**
   *    setzt Video-Attribut :  titel
   *    
   *    @param titel     neuer Titel
   */
  public void setTitel ( String titel )
  {
   checkArgument( ( (titel == null) || (titel.trim().length() <= 0) ), 
                  TITEL_MELDUNG  
                );
   this.titel = titel.trim();
  }


//------------------spieldauer-------------------------------

  /**
   *    gibt Video-Attribut : spieldauer zurueck
   *    
   *    @return    Video-Spieldauer
   */
  public int getSpieldauer ( )
  {
    return spieldauer;
  }


  /**
   *    setzt Video-Attribut :  spieldauer
   *    
   *    @param spieldauer     neue Spieldauer
   */
  public void setSpieldauer ( int spieldauer )
  {
   checkArgument( ( spieldauer <= 0 ), 
                  SPIELDAUER_MELDUNG  
                );
   this.spieldauer = spieldauer;
  }


//------------------jahr-------------------------------

  /**
   *    gibt Video-Attribut : jahr zurueck
   *    
   *    @return    das Erscheinungsjahr des Videos
   */
  public int getJahr ( )
  {
    return jahr;
  }


  /**
   *    setzt Video-Attribut :  jahr
   *    
   *    @param jahr     das neue Erscheinungsjahr
   */
  public void setJahr ( int jahr )
  {
   checkArgument( ( (jahr < MIN_ERSCHEINUNGSJAHR) ||
                    (jahr > MAX_ERSCHEINUNGSJAHR)
                  ), 
                  ERSCHEINUNGSJAHR_MELDUNG  
                );
   this.jahr = jahr;
  }
  
  
 

//------------------sonstiges-------------------------------

  /**
   *    erzeugt einen Beschreibungs-String, der eine Kurzbeschreibung
   *    der Video zurueckliefert
   *    
   *    @return eine Kurzbeschreibung von Video
   */
  @Override
  public String getBeschreibung ()
  {
   return String.format( " %20s", titel );
  }


  /**
   *    erzeugt einen String, der alle, fuer den Klassenbenutzer
   *    wichtigen, Video-Merkmale enthaelt
   *    
   *    @return die String-Repraesentation von Video
   */
  @Override
  public String toString ()
  {
   return String.format( "%s ---> %20s %6d %5d ",
                              super.toString(), titel, spieldauer, jahr
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
   int result = super.hashCode();
   
   result = prime * result + spieldauer;
   result = prime * result + jahr;
   result = prime * result + ((titel == null) ? 0 : titel.hashCode());
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
   if (!super.equals(obj))
       return false;
   if (getClass() != obj.getClass())
       return false;

   Video other = (Video) obj;
   if (spieldauer != other.spieldauer)
       return false;
   if (jahr != other.jahr)
       return false;
   if (titel == null) 
   {
    if (other.titel != null)
        return false;
   } else if (!titel.equals(other.titel))
              return false;
   return true;
  }

}
