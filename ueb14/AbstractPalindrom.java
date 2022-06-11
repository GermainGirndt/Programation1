import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
/**
 * Abstrakte Klasse für Palindrome-Überprüft
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */

public abstract class AbstractPalindrom implements Palindrom {

    private String[] eingabe;

    private final static int EINZEL_STRING_ARGUMENT_EINGABE_INDEX = 0;

    @Override 
    public abstract boolean istPalindrom(String string);

    public boolean[] pruefePalindromeInStrings(String[] string) {
        
        boolean[] ergebnisse = new boolean[string.length];

        for (int i = 0; i < string.length; i++) {
            ergebnisse[i] = this.istPalindrom(string[i]);
        }

        return ergebnisse;
    }

    @Override 
    public String toString() {
        return "AbstractPalindrom";
    }


}