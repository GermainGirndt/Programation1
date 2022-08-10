import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;
import java.util.GregorianCalendar;
import java.time.LocalDateTime;


public class Consumer 
{
    private TreeMap<Integer, LinkedList<Long>> counter;
    private long                               baseMillis;

 
    public Consumer()
    {
        this.counter = new TreeMap<>();
        baseMillis   = System.currentTimeMillis();
    }
    

    public void consume( int i )
    {
        int  result ;
        long timestamp;

        result    = crossTotal( i );
        timestamp = System.currentTimeMillis() - baseMillis;
   
        System.out.println( "I consumed "                      + i + 
                            " and calculated the cross total " + result +
                            ".  I recorded the timestamp: "    + timestamp );

        if ( counter.get(result) == null )
        {
            LinkedList<Long> l = new LinkedList<>();

            l.add( timestamp );
            counter.put( result, l );
        }
        else
            counter.get( result ).add( timestamp );
    }
    


    public int crossTotal( int i )  
    {
        int result = 0;
   
        while (0 != i )
        {
            result += i % 10;            // add last digit to result
            i      /= 10;                // remove last digit 
        }
        return result;
    }
    
   
    public int numberOfDifferentResults()
    {
        return this.counter.keySet().size();
    }
    
   
    public int numberOfOccurrences( int i )
    {
       if ( this.counter.containsKey( i ) )

           return this.counter.get( i ).size();

       return 0;
    }
    
   
    public Set<Integer> getCrossTotalsAscending()
    {
        return this.counter.keySet();
    }
    
   
    public Set<Integer> getCrossTotalsDescending()
    {
        return this.counter.descendingKeySet();
    }
    
   
    public Deque<Long> getTimestampsForResult( int i )
    {
        return this.counter.get( i );
    }
    
   
    public long getBaseMillis()
    {
        return this.baseMillis;
    }

}
