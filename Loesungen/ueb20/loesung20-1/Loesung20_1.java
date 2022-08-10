import java.util.Queue;
import java.util.Deque;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.Iterator;


public class Loesung20_1  
{
   private static final String AUFRUF
                          = "Aufruf:  java Loesung20_1 { 'fifo' | 'prio' }" ;
   private static final String VERSUCH
                          = "Versuchen Sie es noch einmal !!!" ;


   private Queue<Integer> tasks;
   private Producer       p;
   private Consumer       c;
   private Random         ran;



   public Loesung20_1( String wahl )
   {
     if ( wahl.equals( "fifo" ) )

        tasks = new ArrayDeque<Integer>();
     else 
     {
     if ( wahl.equals( "prio" ) )

        tasks = new PriorityQueue<Integer>();
     else
     {
        System.out.println( AUFRUF + "\n" + VERSUCH );
        System.exit( 1 );
     } };
  
     p   = new Producer();
     c   = new Consumer();
     ran = new Random();
   }
  
 
   public void start()
   {
      Set<Integer> results ;


      System.out.println( "------Start Producing and Consuming------" );

      //for ( int i = 0 ;  i < 10000 ;  i++ )
      for ( int i = 0 ;  i < 100 ;  i++ )
      {
         if ( ran.nextInt( 2 ) > 0 )               
            tasks.add( Integer.valueOf( p.produce() ));     // produce
         else
         {
            try
            {
               c.consume( tasks.remove() );             // consume
            }
            catch( NoSuchElementException e )
            { }
         }
      }

      System.out.println( "------Done------" );
      System.out.println( "Here is the result:" );
    

    
      System.out.println( "Used Basetime in Millis: " + c.getBaseMillis() );
    


      System.out.println( "Number of items that have not yet been consumed: "
                          + tasks.size() );



      System.out.println( "The following items have not been consumed: " );
    
      for ( Integer i : tasks )

         System.out.print( i + ", " );
      

      System.out.println( "\n\n" + c.numberOfDifferentResults() +
                          " different cross totals have been calculated" );
      


      System.out.println( "\nThe following cross totals have been calculated " +
                          "(ascending order):" );
    
      results = c.getCrossTotalsAscending();

      for( Integer i : results )

         System.out.print( i + ", " );


    
      System.out.println( "\n\nThe following cross totals have been calculated " +
                          "(descending order):" );
    
      results = c.getCrossTotalsDescending();

      for( Integer i : results )

         System.out.print( i + ", " );



      System.out.println( "\n\nTimestamps per result " +
                          "(ascending timestamp order):\n" );

      for ( Integer i : results )
      {
         Deque<Long>    d    = c.getTimestampsForResult( i );
         Iterator<Long> iter = d.iterator();
    
         System.out.print( i + " ==>> " );

         while ( iter.hasNext() )

            System.out.print( iter.next() + ", " );

         System.out.println( "\n" );
      }
      


      System.out.println( "Timestamps per result " +
                          "(descending timestamp order):\n" );

      for ( Integer i : results  )
      {
         Deque<Long>    d    = c.getTimestampsForResult( i );
         Iterator<Long> iter = d.descendingIterator();
    
         System.out.print( i + " ==>> " );

         while ( iter.hasNext() )

            System.out.print( iter.next() + ", " );

         System.out.println( "\n" );
      }
   }
  
  
  
   public static void main( String[] args ) throws InterruptedException
   {
     if ( args.length == 0 )
     {
        System.out.println( AUFRUF + "\n" + VERSUCH );
        System.exit( 1 );
     }
     else
     {
        Loesung20_1 loesung = new Loesung20_1( args[0] );
        loesung.start();
     }
     System.exit( 0 );
   }
}
