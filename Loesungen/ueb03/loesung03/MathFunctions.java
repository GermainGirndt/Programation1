
/**
 *  MathFunctions realisiert ausgewaehlte mathematische Funktionen
 *  im Stile der java.lang.math-Klasse
 *  
 *  Folgende Funktionen sind als Klassenmethoden realisiert :
 *  
 *      berechneTeilersumme
 *      berechneTeilersummenString
 *      loeseQuadratischeGleichung mit und ohne uebergebenes Epsilon
 * 
 * @author Wolfgang Pauly 
 * @version Version -1.0 Beta, 2021.11.08
 */
public class MathFunctions
{
    //Klassen-Konstanten
    public static final double EPSILON = 1.0E-08;
    private static final String NEGATIVE_ZAHL = 
                         "Die angegebene Zahl ist < 0 !!!";
                         
                         
    /**
     * Konstruktor, der die Erzeugung eines Objektes dieser Klasse verhindert, 
     * da sinnlos !!
     */
    private MathFunctions()
    {
    }


    /**
     *  berechneTeilersummenString - berechnet die Teilersumme
     *  einer uebergebenene Ganzzahl
     * 
     * @param  zahl   die ganze Zahl zu der die Teilersumme berechnet werden soll
     * @return        die Teilersumme mit ihren Faktoren als String
     */
    public static String berechneTeilersummeString( long zahl )
    {
         if ( zahl < 0  ) 
           {
             throw new IllegalArgumentException ( NEGATIVE_ZAHL);
           }
         
         long teilerSumme, lauf;
         String teilerSummeString = new String();

     for ( lauf = 1, teilerSumme = 0; lauf <= zahl/2; lauf++)
        {
         if ( (zahl % lauf) == 0 )
           {
             if ( teilerSumme != 0 )
               {
                 teilerSummeString +=  " + ";
               }
            teilerSummeString += lauf;
            teilerSumme += lauf;
           }
        } 
      teilerSummeString += " + " + zahl + " = ";
      teilerSumme += zahl;
      return ( teilerSummeString += teilerSumme ); 
    }
    
    

     /**
     *  berechneTeilersummenSchnellerString - berechnet die Teilersumme
     *  einer uebergebenene Ganzzahl
     * 
     * @param  zahl   die ganze Zahl zu der die Teilersumme berechnet werden soll
     * @return        die Teilersumme mit ihren Faktoren als String
     */
    public static String berechneTeilersummeSchnellerString( long zahl )
    {
         if ( zahl < 0  ) 
           {
             throw new IllegalArgumentException ( NEGATIVE_ZAHL);
           }
         
         long teilerSumme, lauf;
         String teilerSummeString = new String();

      //for ( lauf = 1, teilerSumme = 0; lauf <= Math.sqrt(zahl); lauf++)
      // vvvvv das ist schoener vvvvvvvvvvv
      for ( lauf = 1, teilerSumme = 0; lauf * lauf < zahl ; lauf++)     
        {
         if ( (zahl % lauf) == 0 )
           {
             if ( teilerSumme != 0 )
               {
                 teilerSummeString +=  " + ";
               }
             teilerSummeString += lauf + " + " + zahl / lauf;
             teilerSumme += lauf + zahl / lauf;
           }
        } 
        
        if ( lauf * lauf == zahl )
          {
           teilerSummeString += " + " + lauf;
           teilerSumme += lauf;
          }
      return ( teilerSummeString += " = " + teilerSumme ); 
    } 
    
    
    

    /**
     *  berechneTeilersumme - berechnet die Teilersumme
     *  einer uebergebenene Ganzzahl
     *
     * @param  zahl   die ganze Zahl zu der die Teilersumme berechnet werden soll
     * @return        die Teilersumme als Ganzzahl
     */
    public static long berechneTeilersumme( long zahl )
    {
         if ( zahl < 0  ) 
           {
             throw new IllegalArgumentException ( NEGATIVE_ZAHL);
           }
         
         long teilerSumme, lauf;

      for ( lauf = 1, teilerSumme = 0; lauf <= zahl/2; lauf++)
        {
         if ( (zahl % lauf) == 0 )
           {
            teilerSumme += lauf;
           }
        } 
      return ( teilerSumme + zahl ); 
    }
    
    

    /**
     *  berechneTeilersummeWSchneller - berechnet die Teilersumme
     *  einer uebergebenene Ganzzahl
     *
     * @param  zahl   die ganze Zahl zu der die Teilersumme berechnet werden soll
     * @return        die Teilersumme als Ganzzahl
     */
    public static long berechneTeilersummeSchneller( long zahl )
    {
         if ( zahl < 0  ) 
           {
             throw new IllegalArgumentException ( NEGATIVE_ZAHL);
           }
         
         long teilerSumme, lauf;

     // for ( lauf = 1, teilerSumme = 0; lauf <= Math.sqrt(zahl); lauf++)
     // vvv das ist schoener vvvv
      for ( lauf = 1, teilerSumme = 0; lauf * lauf < zahl ; lauf++)
        {
         if ( (zahl % lauf) == 0 )
           {
             teilerSumme += lauf + zahl / lauf;
           }
        } 
        
      if ( lauf * lauf == zahl )
        {
         teilerSumme += lauf;
        }
      return ( teilerSumme ); 
    }
 
 

   /**
    *    pruefzifferISBN10 - berechnet aus einer zu uebergebenden 9-stelligen
    *                        ISBN-Nummer die Pruefzahl == 10'te Stelle der kompletten ISBN-Nummer
    *                         
    *    @param     isbn   9-stelligen ISBN-Nummer zur Berechnung der Pruefzahl == 10'te Stelle
    *                      der kompletten ISBN-Nummer
    *    
    *    @return     die 10'te Stelle der eingegebenen 9-stelligen ISBN-NUmmer 1..9 oder X
    */
 
   public static String berechneChecksummeIsbn(long isbn) 
   {
       final long ISBN_MIN = 100000000L;
       final long ISBN_MAX = 999999999L;
	
       if ( (isbn < ISBN_MIN) || (isbn > ISBN_MAX) )
         {
          throw new IllegalArgumentException("Falsche ISBN uebergeben!");
         }
   
       long summe = 0L;
       int i = 9;
   
       while(isbn > 0) 
         {
          summe += (isbn % 10) * i;
          isbn /= 10;
          i--;
         }
   
       if (summe % 11 == 10)
         {
          return "X";
         }
       else
         {
          return "" + summe % 11;
         }
    }

    /**
     *    berechneNullstellen   --> Berechnet die Loesungen fuer beliebige  
     *                              quadratische Gleichungen der Form 
     *
     *                                     x*x + px  + q = 0
     *
     *                                     nach der bekannten Formel :
     *
     *                                                            **2
     *                                         -p              (p)        
     *                                x    = ------ +/- sqrt ( (-)      -q )       
     *                                 1,2      2              (2)
     *                                 
     *   mit einem Epsilon von : 1.0E-08 fuer die berechnete Null
     *   
     *   @param p die Zahl die mit x multipliziert wird
     *   @param q die Zahl ohne x
     *   @return das Ergebnis als in Stringrepraesentation
     *
     */
    public static String  berechneNullstellen ( double p, double q ) 
    {
        return berechneNullstellen( p, q, EPSILON );
    }
    
    

    /**
     *    berechneNullstellen   --> Berechnet die Loesungen fuer beliebige  
     *                              quadratische Gleichungen der Form 
     *
     *                                     x*x + px  + q = 0
     *
     *                                     nach der bekannten Formel :
     *
     *                                                            **2
     *                                         -p              (p)        
     *                                x    = ------ +/- sqrt ( (-)      -q )       
     *                                 1,2      2              (2)
     *                                 
     *   mit einem zu Uebergebenden epsilon fuer die berechnete Null
     *     
     *   @param p die Zahl die mit x multipliziert wird
     *   @param q die Zahl ohne x
     *   @return das Ergebnis als in Stringrepraesentation
     *
     */
    public static String  berechneNullstellen ( double p, double q, double epsilon ) 
    {
        double d, pHalbe, x, x1, x2; // Loesungen
               
        String loesung = new String();

       pHalbe = (p/2.0);
       d = pHalbe * pHalbe -q;

       if ( d >= epsilon )
           {
            x1 = -pHalbe + Math.sqrt ( d );
            x2 = -pHalbe - Math.sqrt ( d );
            loesung +=  "Zwei Nullstellen: " + x1 + " | " + x2 ;
           }
         else
           {
            if ( d <= -epsilon )
              {
               loesung += "Komplexe Nullstellen";
              }
            else
              {
               x = -pHalbe;
               loesung += "Doppelte Nullstelle : " + x;
              }
           } 
       return loesung;    
    }    
}
