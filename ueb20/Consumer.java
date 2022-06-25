
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Beschreiben Sie hier die Klasse Consumer.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Consumer
{
    Queue<Quersumme> queue;
    
    /**
     * Konstruktor für Objekte der Klasse Consumer
     */
    public Consumer()
    {
        queue =  new LinkedList<>();   
    }

    public void consume(Integer i){
        Quersumme quersumme = new Quersumme();
        quersumme.setNumber(i);
        int anzahlBerechnungen = 0;
        int summe = 0;
        while(i > 0){
            quersumme.put(anzahlBerechnungen, System.currentTimeMillis());
            summe = summe + (i%10);
            i = i / 10;
            anzahlBerechnungen++;
        }
        quersumme.setSum(summe);
        queue.add(quersumme);
    }
    
    public int numberOfDifferentResults(){
        Set<Integer> set = new HashSet<>();   
        for(Quersumme q : queue){
            set.add(q.getSum());          
        }
        return set.size();
    }
    
    public int numberOfOccurrences(Integer i){
        int occurences = 0;
        for(Quersumme q : queue){
            if(q.getSum() == i ){
                occurences++;    
            }
        }    
        return occurences;
    }
    
    public Collection<Integer> getCrossTotalsAscending(){
        TreeSet<Integer> set = new TreeSet<>();    
        for(Quersumme q : queue){
                set.add(q.getSum());  
            }
        //System.out.println(set);
        return set;
        }    
        
    public Collection<Integer> getCrossTotalsDescending(){
        TreeSet<Integer> set = new TreeSet<>();    
        for(Quersumme q : queue){
                set.add(q.getSum());  
            }
        TreeSet<Integer> descendingSet = (TreeSet<Integer>)set.descendingSet();
        //System.out.println(descendingSet);
        return descendingSet;
        }  
        
    public Collection<Quersumme> getTimestampsForResult(Integer i){
        Queue<Quersumme> queueTimestamps =  new LinkedList<>(); ;
        for(Quersumme q : queue){
            if(q.getSum() == i ){
                queueTimestamps.add(q);
                System.out.println(q);
            }
        }   
        
        return queueTimestamps;
    }
    
}
