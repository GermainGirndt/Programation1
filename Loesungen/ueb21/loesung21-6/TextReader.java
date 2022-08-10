 

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextReader {

    public static void main(String[] args) 
    {
        try {
            System.out.println(new TextReader().readTextFile("", "a", 2, 10));
            System.out.println(new TextReader().readTextFileToMap("", "a", 2, 10));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    public List<String> readTextFile(String file, String prefix, int minLength, int limit) throws IOException
    {
        if(file == "")
            file = "rfc791.txt";

        FileReader fr = new FileReader( file);
        
        
        BufferedReader br = new BufferedReader(fr);
        String line;
        List<String> words = new LinkedList<String>(); //Sollte eine LinkedList sein, um die FIFO-Ordnung zu bewahren. 
        
        while((line = br.readLine()) != null)               
            for (String a : line.split(" ")) 
                    words.add(a);
        
        List<String> result = words.stream()
                .filter(s -> s.length() > minLength)
                .filter(s->s.startsWith(prefix))
            .filter(s -> s.matches("[a-zA-Z]*"))
                .distinct()
                .limit(limit)
                .sorted((a,b) -> a.compareToIgnoreCase(b))
                .collect(Collectors.toList());
        System.out.println(result);
        return result;
    }
    public Map<Integer, List<String>> readTextFileToMap(String file, String prefix, int minLength, int limit) throws IOException
    {
        if(file == "")
            file = "rfc791.txt";

        FileReader fr = new FileReader(file);
        
        
        BufferedReader br = new BufferedReader(fr);
        String line;
        List<String> words = new LinkedList<String>(); //Sollte eine LinkedList sein, um die FIFO-Ordnung zu bewahren. 
        
        while((line = br.readLine()) != null)               
            for (String a : line.split(" ")) 
                    words.add(a);
        
        Map<Integer, List<String>> result = words.stream()
                .filter(s -> s.length() > minLength)
                .filter(s->s.startsWith(prefix))
            .filter(s -> s.matches("[a-zA-Z]*"))
                .distinct()
                .limit(limit)
                .sorted((a,b) -> a.compareToIgnoreCase(b))
                .collect(Collectors.groupingBy(String::length));
        return result;
    }
}
