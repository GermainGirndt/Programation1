/**
 *  GgtRekrusiv realisiert ...
 *  
 * @author Wolfgang Pauly 
 * @version Version -1.0 Beta, 2022-04-27
 */


public class GgtRekursiv
             extends GgT
{
    /**
     * Standard-Konstruktor
     */
    public GgtRekursiv()
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

      long erg;

      if ( b == 0 )
        {
          erg = a;
        }
      else
        {
          erg = berechneGgt( b, (a % b) );
        }
      return erg;
    }


    public  String toString()
    {
      return "GgtRekrusiv";
    }

}
