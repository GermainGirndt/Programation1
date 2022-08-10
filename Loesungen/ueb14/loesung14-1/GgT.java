/**
 *  GgT realisiert ...
 *  
 * 
 * @author Wolfgang Pauly 
 * @version Version -1.0 Beta, 2022-04-27
 */

public abstract class GgT
{
    /**
     *  berechneGgt - sucht den groessten gemeinsamen Teiler 
     *                zweier natuerlicher Zahlen
     *                mit dem Algorithmus von Euklid
     *  
     * 
     * @param     a erste natuerliche Zahl
     * @param     b zweite natuerliche Zahl
     * @return    der groesste gemeinsame Teiler
     * 
     */
    public abstract long berechneGgt( long a, long b );


    public  String toString()
    {
      return "GgT";
    }

}
