import java.util.List;
import java.util.LinkedList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.HashMap;
import java.util.Map;

/**
 * Beschreiben Sie hier die Klasse Reader.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Reader
{
     List<String> list;

    /**
     * Konstruktor für Objekte der Klasse Reader
     */
    public Reader()
    {
         list = new LinkedList<>(); 
    }
    
    
    public List<String> readTextFile(String file, String prefix, int minLength, int limit){
        File datei = new File(file);
        list.clear();
        try (BufferedReader bufferedReader  = new BufferedReader(new FileReader(datei))){
            String zeile = "";
            
            while ((zeile = bufferedReader.readLine()) != null) {
                String[] zeilesplit = zeile.trim().split(" ");  
                for(String wort : zeilesplit){
                    if(!wort.trim().isEmpty() && !list.contains(wort)){
                        list.add(wort.trim());    
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
       
        
        List<String> l = new LinkedList<>();
        
        list.stream().filter(s->s.length()>minLength)
        .filter(s -> s.startsWith(prefix))
        .sorted()
        .forEach(s -> {if(l.size()<limit){l.add(s);}});
        
        
        
        return l;
}

  public Map<Integer, String> readTextFileToMap(String file, String prefix, int minLength, int limit){
        File datei = new File(file);
        list.clear();
        try (BufferedReader bufferedReader  = new BufferedReader(new FileReader(datei))){
            String zeile = "";
            
            while ((zeile = bufferedReader.readLine()) != null) {
                String[] zeilesplit = zeile.trim().split(" ");  
                for(String wort : zeilesplit){
                    if(!wort.trim().isEmpty()  && !list.contains(wort)){
                        list.add(wort.trim());    
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
       
        
        HashMap<Integer, String> m = new HashMap<>();
        
        list.stream().filter(s->s.length()>minLength)
        .filter(s -> s.startsWith(prefix))
        .sorted()
        .forEach(s -> {if(m.size()<limit){m.put(m.size(), s);}});
        
        
        
        return m;
}
}
