import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;
/**
 * ÃœberprÃ¼ft mittels Rekursion, ob zwei WÃ¶rter Palindrome sind.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class PalindromRekursiv implements Palindrom {

    private BufferedReader reader;

    /**
     * Konstruktor fuer Objekte der Klasse PalindromRekursiv
     * notwendig fuer die automatisiertenTests
     */
    public PalindromRekursiv() {
       
    }

    @Override 
    public boolean istPalindrom(String string) {
         return  this.pruefeRekursiv(string);
    }

    private boolean pruefeRekursiv(String string){

        string = string.toLowerCase();

        String u;
        
        if (string.charAt(0) == string.charAt(string.length() -1)){
             if (string.length() <= 2){
                 return true;
             }
             u = string.substring(1, string.length() -1);
             return pruefeRekursiv(u);    
        }
        else {
            return false;
        }    
    }


    @Override 
    public String toString(){
            return "PalindromRekursiv";
    }
}
