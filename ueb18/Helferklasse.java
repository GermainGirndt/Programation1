
/**
 * Beschreiben Sie hier die Klasse Helferklasse.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Helferklasse
{
   public static boolean compareStrings(String s1, String s2) {

        int comparedResult = s1.compareTo(s2);

        if (comparedResult > 0) {
            return false;
        } else {
            return true;
        }

    }
}
