import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;
/**
 * Überprüft mittels Rekursion, ob zwei Wörter Palindrome sind.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class PalindromRekursiv implements Palindrom {
    private String textDateiRegex = "([a-zA-Z0-9\\s_\\.\\-\\(\\):])+(.txt)";
    private boolean istFile;
    ArrayList<String> zeilen;
    private String filemode = "-f";
    private String wordmode = "-s";


    public static void main(String[] args) {
        PalindromRekursiv instance = new PalindromRekursiv();
        instance.start(args);
           
    
        
        
    }
    
    public void start(String[] args) {
        if (args.length < 2){
            throw new PalindromError("Benutzung java PalindromRekursiv <-s|-f> <String|Dateiname>");            
        }   
        if (args[0].equals(this.filemode)) {
           this.istFile = true;
           this.readLines(args[1]);
        } else if ((args[0].equals(this.wordmode))) {
           this.istFile = false;
        }
        else{
            throw new PalindromError("Benutzung java PalindromRekursiv <-s|-f> <String|Dateiname>");      
        }
        if(this.istFile){
            if(this.zeilen.size() > 0){
            for(String z: this.zeilen){
                System.out.println(z);
                System.out.println(this.istPalindrom(z));   
            }
        }
        }
        else{
        for(int i = 1; i < args.length ; i++){
            System.out.println(args[i]);
            System.out.println(this.istPalindrom(args[i]));    
        }
        }
    }
    
    
    /**
     * Konstruktor für Objekte der Klasse PalindromRekursiv
     */
    public PalindromRekursiv() {
         this.zeilen = new ArrayList<>(); 
    }


    @Override 
    public boolean istPalindrom(String string) {
        if (string == null){
            throw new IllegalArgumentException("Nichts wurde übergeben");
        }
        if (string.trim().isEmpty()){
            return false;
        }

        return this.pruefePalindrom(string);
    }

   

    private boolean pruefePalindrom(String string) {

        return pruefeRekursiv(string);

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
    
    private void validiereFile(File file){
     

        if (!file.isFile()) {
            throw new IllegalArgumentException(file.getName());
        }

        if (!file.canRead()) {
            throw new  IllegalArgumentException(file.getName());
        }

        if (!file.exists()) {
            throw new IllegalArgumentException(file.getName());
        }    
    }
    
    private void readLines(String s){
        File file         = new File(s);
        String zeile;
        validiereFile(file);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while((zeile = reader.readLine()) != null)
            {
                
                 this.zeilen.add(zeile);
               
            }
             
            reader.close();
          
            } catch (Exception error) {
            throw new PalindromError("Dateilesung hat fehlgeschlagen");
            }    
    }

}
