/**
 *  Palindrom realisiert ...
 *  
 * 
 * @author Wolfgang Pauly 
 * @version Version -1.0 Beta, 2022-04-27
 */

public abstract class Palindrom
{

   /**
     *  istPalindrom - testet ob der Uebergabestring ein Palindrom enthaelt
     *
     *
     * @param  zuTesten   der zu untersuchende String
     * @return            true ==  ist Palindrom, false == ist KEIN Palindrom
     */
    public abstract boolean istPalindrom( String zuTesten );


    public  String toString()
    {
      return "palindrom";
    }

}
