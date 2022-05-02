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
public class PalindromRekursiv2 implements Palindrom {
    private boolean istFile = false;
    private ArrayList<String> zeilen;
    private String filemode = "-f";
    private String wordmode = "-s";
    private BufferedReader reader;
    private String eingabe;

 
    public static void main(String[] args) {
        PalindromRekursiv2 instance = new PalindromRekursiv2() ;
        instance.start(args);
        
        boolean istFile = instance.getIstFile();
        ArrayList<String> zeilen = instance.getZeilen();
        
         if(istFile){
             if(zeilen.size() > 0){
             for(String z: zeilen){
                 System.out.println(z);
                 System.out.println(instance.istPalindrom(z));   
             }
         }
         }
         else{
             for(int i = 1; i < args.length ; i++){
                 System.out.println(args[i]);
                 System.out.println(instance.istPalindrom(args[i]));    
             }
         }
    }
    
    @Override
    public void start(String[] args) {
        if (args.length < 2){
            throw new PalindromError("Benutzung java PalindromRekursiv <-s|-f> <String|Dateiname>");            
        }  
        if (args[0].equals(this.filemode)) {
            this.istFile = true;
            this.zeilen = Einlesen.readLines(args[1]);
         } else if ((args[0].equals(this.wordmode))) {
            this.istFile = false;
         }
         else {
             throw new PalindromError("Benutzung java PalindromRekursiv <-s|-f> <String|Dateiname>");      
         }
        
    }

    /**
     * Konstruktor fuer Objekte der Klasse PalindromRekursiv
     * notwendig fuer die automatisiertenTests
     */
    public PalindromRekursiv2() {
        this.zeilen = new ArrayList<>(); 
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

    public boolean getIstFile(){
        return istFile;
    }
    
     public ArrayList<String> getZeilen(){
        return zeilen;
    }
    
    @Override 
    public String toString(){
            return "PalindromRekursiv";
    }
}
