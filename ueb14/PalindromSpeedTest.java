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
            zeilen = Einlesen.readLines(args[2]);
        } else if ((args[1].equals(this.wordmode))) {
            this.istFile = false;
        }
        else {
            throw new PalindromError("Benutzung java PalindromSpeedTester <Logfile.txt> <-s|-f> <String|Dateiname>");      
        }
        
 
        ArrayList<Palindrom> pals = new ArrayList<>();
        pals.add(new PalindromRekursiv());
        pals.add(new PalindromIterativ());
            
        try {
                out = new PrintWriter(args[0]);
        } catch (FileNotFoundException e) {
                System.out.println("Unable to locate the fileName: " + e.getMessage());
        }

        for(Palindrom p : pals)
        {
                out.print(p.toString() + "\t\n" );    
                if(istFile){
                    for(String zeile : zeilen){
                        out.print(zeile + "\t");
                        long start = System.nanoTime();    
                        p.istPalindrom(zeile);
                        long end = System.nanoTime();
                        out.print(end-start + "\t\n");
                    }
                   
                }
                else{
                    for(int i = 2; i< args.length; i++)  {
                        out.print(args[i] + "\t");    
                        long start = System.nanoTime();    
                        p.istPalindrom(args[i]);
                        long end = System.nanoTime();
                        out.print(end-start + "\t\n");
                    }
                }
               
        }
        
         out.close();
            
            
    }

   
    
     
    
}
