
/**
 *  ArrayFunctions realisiert Methoden, die mit Arrays arbeiten
 *  
 *  Folgende Methoden sind realisiert :
 *  
 *      auswertMesswerte
 *      sucheAnzahlNurBuchstabenStrings
 * 
 * @author Wolfgang Pauly 
 * @version Version -1.0 Beta, 2021
 */

public class ArrayFunctions 
{
    /**
     * Konstruktor, der die Erzeugung eines Objektes dieser Klasse verhindert, 
     * da sinnlos !!
     */
    private ArrayFunctions()
    {
    }


    /**
     *  berechneMittelwert - analysiert ein zu uebergebendes Messwertarray
     *                     sucht arithmetischen Mittelwert, den am naechsten
     *                     und dem am weitesten vom Mittelwert entfernten Messwert
     *  
     * 
     * @param  messwerte   das zu analysierende Messwertarray
     * @return             ein Mittelwertobjekt mit dem Mittelwert, dem dazu nächsten und entferntesten Wert
     * 
     */
    public static Mittelwert berechneMittelwert(double messwerte[] )
    {
        int i;
        double mittel, min, max;

        mittel = 0.0;
        for (i = 0; i < messwerte.length; i++)
           {
            mittel += messwerte[i];
           }

        mittel /= messwerte.length;
        min = messwerte[0];
        max = messwerte[0];
        for (i = 1; i < messwerte.length; i++)
           {
            if ( Math.abs(mittel - messwerte[i]) < Math.abs(mittel - min) )
              {
                 min = messwerte[i];
              }

            if ( Math.abs(mittel - messwerte[i]) > (Math.abs(mittel - max)) )
              {
                max = messwerte[i];
              }
           }
       return new Mittelwert( mittel, min, max );
}
    
    


    /**
     *  stringsAuswerten
     *  
     * 
     * @param  eingabeStringFeld das zu untersuchende Stringfeld
     * @return                   die Anzahl der NurBuchstabenStrings im uebergebene StringFeld
     */
    public static int stringsAuswerten( String[] strings )
    {
     int anzahl = 0;
     for (String s : strings) 
        {
         if ( s.matches( "[a-z]+" ) || s.matches( "[A-Z]+" )  )
           {
            anzahl++;
           }
         //System.out.println( s + "Anzahl = " + anzahl );
        }
      return anzahl;
    } 
    
} 
