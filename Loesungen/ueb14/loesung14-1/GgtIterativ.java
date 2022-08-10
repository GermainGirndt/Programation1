/**
 *  GgtIterativ realisiert ...
 *  
 * @author Wolfgang Pauly 
 * @version Version -1.0 Beta, 2022-04-27
 */


public class GgtIterativ
             extends GgT
{

    /**
     * Standard-Konstruktor
     */
    public GgtIterativ()
    {
    }


    /**
     *  berechne - sucht den groessten gemeinsamen Teiler 
     *             zweier natuerlicher Zahlen
     *             mit dem Algorithmus von Euklid
     *  
     * 
     * @param     a erste natuerliche Zahl
     * @param     b zweite natuerliche Zahl
     * @return    der groesste gemeinsame Teiler
     * 
     */
    public long berechneGgt( long a, long b )
    {
     GgTException.zahlKorrekt( a );
     GgTException.zahlKorrekt( b );

     if ( a == 0 )
       return b;

     while (b != 0)
       {
         if (a > b)
           {
            a = a - b;
           }
         else
           {
            b = b - a;
           }
       }
     return a;
    }


    public  String toString()
    {
      return "GgtIterativ";
    }

}
