import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
/**
 * Beschreiben Sie hier die Klasse PalimdromRekursiv.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class PalimdromRekursiv implements Palimdrom
{
    private String textDateiRegex = "([a-zA-Z0-9\\s_\\.\\-\\(\\):])+(.txt)";
    private BufferedReader reader;
    public static void main(String[] args) {
        if(args.length != 1){
            System.err.println("Benutzung java PalimdromRekursiv <String|Dateiname>");
        }
        else{
            PalimdromRekursiv instance = new  PalimdromRekursiv();
            System.out.println(instance.istPalimdrom(args[0]));
        }
    }
    
    
    /**
     * Konstruktor für Objekte der Klasse PalimdromRekursiv
     */
    public PalimdromRekursiv()
    {
       
    }

    @Override 
    public boolean istPalimdrom(String s){
        if(s == null){
            throw new IllegalArgumentException("keine Datei übergeben");
        }
        if(s.isEmpty()){
            return false;
        }
        if(s.matches(textDateiRegex)){
            File file         = new File(s);
            if (!file.isFile()) {
                throw new IllegalArgumentException(file.getName());
            }
            if (!file.canRead()) {
                throw new  IllegalArgumentException(file.getName());
            }
            if (!file.exists()) {
                throw new IllegalArgumentException(file.getName());
            }
             try (BufferedReader reader = new BufferedReader(new FileReader(s))) {
                this.reader = reader;
                
                String zeile = this.reader.readLine();
  
                zeile = zeile.trim();
                zeile = zeile.toLowerCase();
                
                reader.close();
                return pruefeRekursiv(zeile);

            } catch (Exception error) {
                throw new IllegalArgumentException("");   
            }        
        }
        else{
            s = s.toLowerCase();
        
            return pruefeRekursiv(s);
        }
    }
    
    private boolean pruefeRekursiv(String s){

        String u;
        
        if(s.charAt(0) == s.charAt(s.length() -1)){
             if(s.length() <= 2){
                 return true;
             }
             u = s.substring(1, s.length() -1);
             return pruefeRekursiv(u);    
        }
        else{
            return false;
        }    
    }
    
}
