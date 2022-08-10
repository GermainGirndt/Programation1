/**
 *  PalindromIterativ realisiert ...
 *  
 * 
 * @author Wolfgang Pauly 
 * @version Version -1.0 Beta, 2022-04-27
 */


public class PalindromIterativ
             extends Palindrom
{
    /**
     * Standard-Konstruktor
     */
    public PalindromIterativ()
    {
    }

    /**
     *  istPalindrom - testet ob der Uebergabestring ein Palindrom enthaelt
     *
     *
     * @param  zuTesten   der zu untersuchende String
     * @return            true ==  ist Palindrom, false == ist KEIN Palindrom
     */
    public boolean istPalindrom( String zuTesten )
    {
      PalindromException.stringTest( zuTesten);

      boolean palindrom = false, ende = false;
      int     zuTestenLaenge = zuTesten.length(),
              iterationsGrenze;

      if ( zuTesten.length() == 0 || zuTesten.length() == 1)
            return true;

      if ( zuTestenLaenge % 2 == 0 )
        {
         iterationsGrenze = ( zuTestenLaenge / 2 ) - 1;
        }
      else
        {
         iterationsGrenze = ( ( zuTestenLaenge - 1 ) / 2 ) - 1;
        }

      for (int i = 0; (i <= iterationsGrenze) && !ende; i++)
        {
          if (zuTesten.charAt(i) != zuTesten.charAt(zuTestenLaenge - i -1 ))
            {
              ende = true;
              palindrom = false;
            }
          else
            {
              palindrom = true;
            }
        }

      return palindrom;
    }


    public  String toString()
    {
      return "palindromIterativ";
    }

}
