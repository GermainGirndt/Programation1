



import java.io.*;
   
/**
 *    Die Klasse:  Mittelwert.java
 *    realisiert eine allgemeine Artikel-Klasse 
 *
 * @version    1.0 Beta 2021_10_28
 * @author    Wolfgang Pauly
 *
 */

public class Mittelwert 
{

  //----------- Attribute---------------------
  private  double mittelwert;
  private  double naechsterWert;
  private  double entferntesterWert;

  

  /**
   *    Der (Voll-)Konstruktor mit 3 Parametern
   *    
   *    @param mittelwert        Mittelwert der Messwerte
   *    @param naechsterWert     Wert der am naechsten am Mittelwert liegt
   *    @param entferntesterWert  Wert der am weitesten vom Mittelwert entfernt liegt
   */
  public Mittelwert (double mittelwert, double naechsterWert,
                     double entferntesterWert
                    )
  {
   this.mittelwert        = mittelwert;
   this.naechsterWert     = naechsterWert;
   this.entferntesterWert = entferntesterWert;
  }

  /**
   *    gibt Mittelwert zurück
   *    
   *    @return    mittelwert
   */
  public double getMittelwert ( )
  {
    return mittelwert;
  }

  /**
   *    gibt den Wert der am naechsten am Mittelwert liegt zurück
   *    
   *    @return    naechsterWert
   */
  public double getNaechsterWert ( )
  {
    return naechsterWert;
  }

  /**
   *    gibt den  Wert der am weitesten vom Mittelwert entfernt liegt zurück
   *    
   *    @return    entferntesterWert
   */
  public double getEntferntesterWert ( )
  {
    return entferntesterWert;
  }


  /**
   *    erzeugt einen Mittelwert-String
   *    
   *    @return    Stringrepraesentation des Objekt-Zustandes
   */
  public String toString ()
  {
   return  ( "  Mittelwert: "     + mittelwert +
             "  Naechster Wert: " + naechsterWert +
             "  Entferntester Wert: "     + entferntesterWert 
           );
  }
}
