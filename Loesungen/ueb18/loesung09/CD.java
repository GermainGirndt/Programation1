import java.io.*;
    
/**
 *    Die Klasse:  CD.java
 *    Realisiert eine CD-Klasse
 *
 * @version    2.0 Beta 10.01.2022
 * @author    Wolfgang Pauly
 *
 */

public class CD
       extends Artikel      
{
//------------------Konstanten----------------------------------

  private static final String BEZEICHNUNG  = "Medien";

  private static final String  INTERPRET_MELDUNG = 
          "Uebergebener Interpret ist ungueltig, da ein LEER-String !";
  private static final String  TITEL_MELDUNG = 
          "Uebergebener Titel ist ungueltig, da ein LEER-String !";
  private static final String  ANZAHLMUSIKTITEL_MELDUNG = 
          "Uebergebene Musiktitel-Anzahl ist ungueltig, da kleiner  0 !!!";
  
//------------------Attribute----------------------------------
  
  private  String  interpret;
  private  String  titel;
  private  int     anzahlTitel;



//------------------Konstruktoren-------------------------------


  /**
   *    Der Konstruktor zur Voll-Initialisierung
   *
   *    @param artikelNr initial CD-Artikelnummer
   *    @param bestand initial CD-Bestand
   *    @param preis initial CD-Preis
   *    @param interpret initial CD-Interpret
   *    @param titel initial CD-Titel
   *    @param anzahlMusiktitel initial CD-Musiktitel-Anzahl
   */
  public CD ( int artikelNr, int bestand, double preis, 
              String interpret, String titel, int anzahlTitel
            )
  {
   super( artikelNr, BEZEICHNUNG, bestand, preis 
        );
   setCDAttributes( interpret, titel, anzahlTitel );
  }  



  /**
   *    die Hilfs-Methode zu Konstruktion von CD-Objekten
   *
   *    @param interpret initial CD-Interpret
   *    @param titel initial CD-Titel
   *    @param anzahlMusiktitel initial CD-Musiktitel-Anzahl
   */
  private void setCDAttributes ( String interpret, String titel, 
                                 int anzahlMusiktitel 
                               )
  {
   setInterpret( interpret );
   setTitel( titel );
   setAnzahlTitel( anzahlMusiktitel );
  }  
  

//------------------interpret-------------------------------

  /**
   *    gibt CD-Attribut : interpret zurueck
   *    
   *    @return    CD-Interpret
   */
  public String getInterpret ( )
  {
    return interpret;
  }


  /**
   *    setzt CD-Attribut :  interpret
   *    
   *    @param interpret     neuer Interpret
   */
  public void setInterpret ( String interpret )
  {
   checkArgument( ( (interpret == null) || (interpret.trim().length() <= 0) ), 
                  INTERPRET_MELDUNG  
                );
   this.interpret = interpret.trim();
  }



//------------------titel-------------------------------

  /**
   *    gibt CD-Attribut : titel zurueck
   *    
   *    @return    CD-Titel
   */
  public String getTitel ( )
  {
    return titel;
  }


  /**
   *    setzt CD-Attribut :  titel
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


//------------------anzahlTitel-------------------------------

  /**
   *    gibt CD-Attribut : anzahlTitel zurueck
   *    
   *    @return    Anzahl der Musiktitel auf der CD
   */
  public int getAnzahlTitel ( )
  {
    return anzahlTitel;
  }


  /**
   *    setzt CD-Attribut :  anzahlTitel
   *    
   *    @param anzahlTitel     die neue Anzahl der Musiktitel
   */
  public void setAnzahlTitel ( int anzahlTitel )
  {
   checkArgument( ( anzahlTitel <= 0 ), 
                  ANZAHLMUSIKTITEL_MELDUNG  
                );
   this.anzahlTitel = anzahlTitel;
  }
  
  



 

//------------------sonstiges-------------------------------

  /**
   *    erzeugt einen Beschreibungs-String, der eine Kurzbeschreibung
   *    der CD zurueckliefert
   *    
   *    @return eine Kurzbeschreibung der CD
   */
  @Override
  public String getBeschreibung ()
  {
   return String.format( "%20s: %20s", interpret, titel );
  }


  /**
   *    erzeugt einen String, der alle, fuer den Klassenbenutzer
   *    wichtigen, CD-Merkmale enthaelt
   *    
   *    @return die String-Repraesentation der CD
   */
  @Override
  public String toString ()
  {
   return String.format( "%s ---> %12s %20s %5s ",
                              super.toString(), interpret, titel, anzahlTitel
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
   
   result = prime * result + anzahlTitel;
   result = prime * result + ((interpret == null) ? 0 : interpret.hashCode());
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

   CD other = (CD) obj;

   if (anzahlTitel != other.anzahlTitel)
       return false;
   if (interpret == null) 
   {
    if (other.interpret != null)
        return false;
   } else if (!interpret.equals(other.interpret))
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
