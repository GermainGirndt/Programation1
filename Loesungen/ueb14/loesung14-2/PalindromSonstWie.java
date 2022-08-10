/**
 *  PalindromSonstWie realisiert ...
 *  
 * 
 * @author Wolfgang Pauly 
 * @version Version -1.0 Beta, 2022-04-27
 */


public class PalindromSonstWie
             extends Palindrom
{
    /**
     * Standard-Konstruktor
     */
    public PalindromSonstWie()
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
      PalindromException.stringTest (zuTesten );
      String reverse = new String( new StringBuffer( zuTesten ).reverse() );
      return  ( zuTesten.equalsIgnoreCase( reverse ) );
    }


    public  String toString()
    {
      return "palindromSonstWie";
    }

}
