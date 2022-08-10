/**
 *  PalindromRekrusiv realisiert ...
 *  
 * @author Wolfgang Pauly 
 * @version Version -1.0 Beta, 2022-04-27
 */

public class PalindromRekursiv
             extends Palindrom
{
  /**
     * Standard-Konstruktor
     */
    public PalindromRekursiv()
    {
    }

    /**
     *  istPalindrom - testet ob der Uebergabestring ein Palindrom enthaelt
     *
     *
     * @param  zuTesten   der zu untersuchende String
     * @return            true ==  ist Palindrom, false == ist KEIN Palindrom
     */
    public  boolean istPalindrom( String zuTesten )
    {
     PalindromException.stringTest( zuTesten);

     if ( zuTesten.length() == 0 || zuTesten.length() == 1)
       {
        return true;
       }

     if ( zuTesten.charAt(0) == zuTesten.charAt( zuTesten.length() - 1 ) )
       {
        return istPalindrom( zuTesten.substring(1, zuTesten.length() - 1 ) );
       }

      return false;
    }



    public  String toString()
    {
      return "PalindromRekrusiv";
    }

}
