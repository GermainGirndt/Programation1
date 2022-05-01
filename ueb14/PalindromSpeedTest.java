import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse PalindromSpeedTest.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class PalindromSpeedTest
{
    private String filemode = "-f";
    private String wordmode = "-s";
    private boolean istFile;
    private ArrayList<String> zeilen;
    private PrintWriter out;
    
    public PalindromSpeedTest(){
        zeilen = new ArrayList<>();
       
    }
    
    public static void main(String[] args) throws Exception {
        PalindromSpeedTest tester = new PalindromSpeedTest();
        tester.start(args);
       
    }

    public void start(String[] args){
         if(args.length < 3){
            throw new PalindromError("Benutzung java PalindromSpeedTester <Logfile.txt> <-s|-f> <String|Dateiname>");            
        }  
        if (args[1].equals(this.filemode)) {
            this.istFile = true;
            this.readLines(args[2]);
        } else if ((args[1].equals(this.wordmode))) {
            this.istFile = false;
        }
        else {
            throw new PalindromError("Benutzung java PalindromSpeedTester <Logfile.txt> <-s|-f> <String|Dateiname>");      
        }
        
        
        try {
            out = new PrintWriter(args[0]);
        } catch (FileNotFoundException e) {
                System.out.println("Unable to locate the fileName: " + e.getMessage());
        }
        
        ArrayList<Palindrom> pals = new ArrayList<>();
        
        pals.add(new PalindromRekursiv());
        
        for(Palindrom p : pals)
        {
                out.print(p.toString() + ";");    
                if(istFile){
                    for(String zeile : zeilen){
                        out.print(zeile + ";");
                        long start = System.nanoTime();    
                        p.istPalindrom(zeile);
                        long end = System.nanoTime();
                        out.print(end-start + ";");
                    }
                   
                }
                else{
                    for(int i = 2; i< args.length; i++)  {
                        out.print(args[i] + ";");    
                        long start = System.nanoTime();    
                        p.istPalindrom(args[i]);
                        long end = System.nanoTime();
                        out.print(end-start + ";");
                    }
                }
                out.close();
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
