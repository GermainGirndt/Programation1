import java.lang.Math;

/**
 *  MyMathFunctions realisiert ausgewaehlte mathematische Funktionen
 *  im Stile der java.lang.math-Klasse
 *  
 *  Folgende Funktionen sind als Klassenmethoden realisiert :
 *  
 *                                          4     3     2  
 *      istSummeVonPotenzen(zahl) ? zahl = a  +  b  + c 
 *  
 *                                            n 
 *                                           ---        i
 *                                           \   (x - 1)
 *      berechneReihensumme    --> s = S(x)= /   -------
 *                                           ---     i
 *                                           i=1  i*x
 *  
 * 
 *      berechneGgt  --> ggT(a,0) = a
 *                       ggT(a,b) = ggT(b,a mod b )
 *
 * @author Wolfgang Pauly 
 * @version Version 1.0 Beta, 2022-04-27
 */



public class MathFunctions
{
    //Klassen-Konstanten
    private static final String KANN_KEINE_POTENZSUMME_SEIN =
                         "Die eingegebene Zahl ist < 3 kann keine Summen von a**4 + b**3 + c**2 sein !!";
         
    private static final String KEINE_GULETIGE_ITERATIONSANZAHL =
                          "Die eingegebene Zahl ist keine gueltige IteratorZahl denn <= 0 !!!";
    private static final String KEIN_GULETIGER_XWERT =
                          "Der eingegebene X-Wert darf nicht == = sein !!!";
         
    /**
     * Konstruktor, der die Erzeugung eines Objektes dieser Klasse verhindert, 
     * da sinnlos !!
     */
    private MathFunctions()
    {
    }
    

    /**
     *                          
     *                     4     3     2
     *     TRUE if zahl = a  +  b  +  c
     *   
     *                                4     3     2 
     * @param   zahl  die auf zahl = a  +  b  +  c  getestet werden soll
     * @return  TRUE zahl ist Summe, FALSE zahl ist keine Summe
     */
    public static boolean istSummeVonPotenzen( long zahl )
    {
     if ( zahl < 3  )
       {
         throw new RuntimeException ( KANN_KEINE_POTENZSUMME_SEIN );
       }


     long a,aPotenz,b,bPotenz, c, cqp, sum;
     boolean  fund = false;

     for ( a = 1; ( (a*a*a*a + 2 ) <= zahl) && !fund; a++ )
        {
          aPotenz = a*a*a*a;
          for ( b = 1; ( (aPotenz + b*b*b + 1) <= zahl) && !fund; b++ )
             {
               bPotenz = b*b*b;
           //                schoenere Loesung mit mehr Programmiererwissen
                                          cqp = zahl - aPotenz - b*b*b;
                                          c = Double.valueOf(Math.sqrt(cqp)).longValue();
                                          fund = ( cqp == c*c );

           // Loesung mit Programmier-Anfaengerwissen
               //for ( c = 1; ( (aPotenz + bPotenz + c*c) <= zahl) && !fund; c++ )
               // {
               //  sum = aPotenz + bPotenz + c*c;
               //  fund = ( zahl == sum );
               //  /*    
                   if ( fund )
                     {
                       System.err.println ( zahl + " = " + a + "**4 + " + b + "**3 + " + c + "**2");
                     }
                // */
                //}
             }
        }
     return fund; 
    }




    
    /**
     *  
     *                                            n 
     *                                           ---        i
     *                                           \   (x - 1)
     *      berechneReihensumme    --> t = S(x)= /   -------
     *                                           ---     i
     *                                           i=1  i*x
     *  
     * dieser Algorithmus ist umstaendlich 00 unnoetig kompliziert!!!
     *
     * @param  n   die Anzahl der Iterationsschritte
     * @param  x   die Zahl fuer die t(x) berechnet werden soll
     * @return     die berechnete Summe
     */
    public static double berechneReihensumme( long anzahl, double x )
    {
     if ( x == 0  )
       {
         throw new RuntimeException ( KEIN_GULETIGER_XWERT );
       }
     if ( anzahl <= 0  )
       {
         throw new RuntimeException ( KEINE_GULETIGE_ITERATIONSANZAHL );
       }
       
         int i;
         double summe, summand, zaehler, zaehlerFaktor, nenner, nennerFaktor;
 
     for ( zaehler = zaehlerFaktor = ( x-1 ), nenner = nennerFaktor = x, 
           summe = summand = ( zaehler / nenner ) , i = 2; 
           i <= anzahl;
           i++ )
        { 
          //  vvvvvvvvvvvvvvvvv zu Testzwecken - oder - debuggen benutzen vvvvvv
          System.err.print ( zaehler + " / " + nenner + " = " +  zaehler/nenner );
          System.err.println ( "    summe = " + summe );

          nennerFaktor *= x;
          nenner   = i * nennerFaktor;
          zaehler *= zaehlerFaktor;
          summand  = zaehler / nenner;
          summe   += summand;
        } 
     //  vvvvvvvvvvvvvvvvv zu Testzwecken - oder - debuggen benutzen vvvvvv
     System.err.print ( zaehler + " / " + nenner + " = " +  zaehler/nenner );
     System.err.println ( "   summe = " + summe );
     return summe; 
    }

    
    /**
     *  
     *                                            n 
     *                                           ---        i
     *                                           \   (x - 1)
     *      berechneReihensumme    --> t = S(x)= /   -------
     *                                           ---     i
     *                                           i=1  i*x
     *
     * einfacherer Algorithmus !!!!
     *  
     * @param  n   die Anzahl der Iterationsschritte
     * @param  x   die Zahl fuer die t(x) berechnet werden soll
     * @return     die berechnete Summe
     */
    public static double berechneReihensummeV2( long anzahl, double x )
    {
     if ( x == 0  )
       {
         throw new RuntimeException ( KEIN_GULETIGER_XWERT );
       }
     if ( anzahl <= 0  )
       {
         throw new RuntimeException ( KEINE_GULETIGE_ITERATIONSANZAHL );
       }
       
         int i;
         double faktor, multi, summe;
 
     for ( faktor = multi = summe = ( x-1 ) / x, i = 2; 
           i <= anzahl;
           i++ )
        { 
          faktor *= multi;
          summe  += faktor / i;
        } 
     return summe; 
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
    public static long berechneGgt( long a, long b )
    {

      if ( a <= 0 )
        {
         throw new IllegalArgumentException( "Die 1. Eingabezahl muss > 0 sein !!!" );
        }
         
      if ( b <= 0 )
        {
         throw new IllegalArgumentException( "Die 2. Eingabezahl muss > 0 sein !!!" );
        }

     return MathFunctions.berechneGgtRekursiv(a,b);
    }


    public static long berechneGgtRekursiv( long a, long b )
    {
      long erg;

      if ( b == 0 )
        {
          erg = a;
        }
      else
        {
          erg = berechneGgtRekursiv( b, (a % b) );
        }
      return erg;
    }
}
