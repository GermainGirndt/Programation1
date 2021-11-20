import java.lang.Math;
/**
 * Die Klasse MathFunctions enthaelt verschiedene Methoden zu Teilersummenberechnung, 
 * ISBN-Pruefsummenberechnung und zur berechnung von Nullstellen einer quadratischen Funktion
 * 
 * @author Girndt & Krier
 * @version 1.0
 */
public class MathFunctions
{
   private static final long KLEINSTER_TEILER                            = 1;
   private static final long START_WERT_SUMME                            = 0;
   
   private static final int  OHNEREST                                    = 0;
   private static final int  SQUARE                                      = 2;

   private static final int  ISBN_START_STELLE                           = 9;
   private static final int  ISBN_END_STELLE_WERT                        = 0;
   
   
   private static final int  ISBN_SPEZIELLE_CHECKSUMME                   = 10;
   private static final String  ISBN_ZEICHEN_FUER_SPEZIELLE_CHECKSUMME   = "X";

   private static final int  BASIS                                       = 10; 
   private static final int  END_MODULO_ISBN                             = 11;
   
   private static final double INITIALWERT                               = 0;
   
   private static final int OBERE_GRENZE_LONG                            = 20;

   /**
    * Verhindert die Instanzialisierung von der Klasse
    * Wir brauchen keine Instanzen, denn wir haben nur statische bzw. Klassenmethoden
    */
   private MathFunctions () {}


   /**
   * Die Methode berechnet die Teilersumme einer natuerlichen Zahl
   * @param  zahl die Zahl dessen Teilersumme berechnet wird
   * @return teilersumme ist die Teilersumme der Zahl
   */
  public static long berechneTeilersumme (long zahl){
       long teilersumme   = START_WERT_SUMME;
       long spiegelteiler;
       Validierung.validiereZahlTeilersumme(zahl);
       for(long teiler = KLEINSTER_TEILER; teiler <= Math.sqrt(zahl) ;teiler++)
           if(zahl % teiler == OHNEREST){
               spiegelteiler   = zahl / teiler;
               teilersumme    += teiler;    
               teilersumme    += spiegelteiler;
           }

       return teilersumme;
   }

   /**
   * Die Methode berechnet die Checksumme einer ISBN
   * @param isbn ist die 9-stellige ISBN deren Checksumme berechnet werden soll
   * @return checksumme ist das Ergebnis der Checksumme
   * 
   * Nicht belegte Stellen werden als null interpretiert (zB. 1 = 000000001) 
   */
   public static String berechneChecksummeIsbn(long isbn){
       long checksumme = START_WERT_SUMME;
       Validierung.validiereIsbn(isbn);

       for(int i = ISBN_START_STELLE; i > ISBN_END_STELLE_WERT; i--) {
           checksumme +=  i * (isbn % BASIS);  
           isbn         /=  BASIS;
       }
       checksumme = checksumme % END_MODULO_ISBN;

       if (checksumme == ISBN_SPEZIELLE_CHECKSUMME) {
           return ISBN_ZEICHEN_FUER_SPEZIELLE_CHECKSUMME;
       }

       return String.valueOf(checksumme);
   }
   
   /**
   * Die Methode berechnet Nullstellen einer quadratischen Funktion in der Form 
   * 
   * @param p ist die Summe zweier Nullstellen (zB. in dem Term a^2 + p * x + q)
   * @param q in das Produkt zweier Nullstellen (zB. in dem Term a^2 + p * x + q)
   * @return Die Art der Nullstellen und die Werte der Nullstellen
   */
   public static String berechneNullstellen (double p, double q){
       double x1               = INITIALWERT;
       double x2               = INITIALWERT;
       double halbesP          = p/2;
       double halbesPimQuadrat = Math.pow(halbesP , SQUARE);
      
       if(halbesPimQuadrat - q < 2 * Double.MIN_VALUE && halbesPimQuadrat - q > - 2 * Double.MIN_VALUE){
           x1 = -1 * halbesP;
           return "Doppelte Nullstelle: " + x1;
       }
       else if(halbesPimQuadrat - q < 2 * Double.MIN_VALUE){
           return "Komplexe Nullstellen";
       }
       else {
           x1 = -1 * halbesP + Math.sqrt(halbesPimQuadrat - q);
           x2 = -1 * halbesP - Math.sqrt(halbesPimQuadrat - q);
           return "Zwei Nullstellen: " + x1 + "|" + x2;
       }
  
   }

   /**
    * Die Methode berechneFakultaet(int zahl) berechnet von einer natuerlichen Zahl die Fakultaet.
    * Die Fakultaet ist definiert als:
    * zahl! = 1 * 2 * 3 * . . . * zahl
   * 
   * @param zahl ist die Zahl, deren Fakultaet zu berechnen ist
   * @return Die ausgerechnete Fakultaet
   */
  public static long berechneFakultaet(int zahl){

    Validierung.validiereZahlZurFakultaetberechnung(zahl, OBERE_GRENZE_LONG);

    long fakultaet = 1;
    for (long naechsteFakultaet = (long) zahl; naechsteFakultaet >= 2; naechsteFakultaet--) {
        fakultaet *= naechsteFakultaet;
    }

    return fakultaet;
  }
  
  /**
  * Die Methode berechneReihensumme(int anzahl, double x)
  * berechnet die Reihensumme nach der Funktion
  *  Sn(anzahl, x) = Σ von i=1 bis n = anzahl von ((x - 1)^i)/i*x^i
  * 
  * @param anzahl ist die Anzahl an Reihensummen
  * @param x ist der Wert von "x" in der Funktion
  * @return Die ausgerechnete Reihensumme
  */
  public static double berechneReihensumme(int anzahl, double x){
   double ergebnis = 0.0;
   
   for (int summenindex = 1; summenindex <= anzahl; summenindex++) {
        double teilergebnis = berechneTeilsumme(summenindex, x);

        ergebnis += teilergebnis;
   }
   
   return ergebnis;
}

  /**
  * Die Methode berechneTeilsumme(int anzahl, double x)
  * berechnet die Teilsumme einer Reihensumme nach der Funktion
  *  f(i, x) = ((x - 1)^i)/i*x^i
  * 
  * @param i ist die i an Reihensummen
  * @param x ist der Wert von "x" in der Funktion
  * @return Die ausgerechnete Reihensumme
  */
private static double berechneTeilsumme(int i, double x) {
    double dividend = Math.pow((x - 1), i);
    double divisor = i * Math.pow(x, i);

    // Validierung.validiereNichtNull(divisor);
    
    double ergebnis = dividend / divisor; 
    
    System.out.println("Dividend: " + dividend);
    System.out.println("Divisor: " + divisor);
    System.out.println("Ergebnis: " + ergebnis);

    return ergebnis;
    
    

    
  }
}
