import java.lang.Math;
/**
 * Beschreiben Sie hier die Klasse MathFunctions.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class MathFunctions
{
   private static final long KLEINSTER_TEILER = 1;
   private static final long START_WERT_SUMME = 0;
   
   private static final int  OHNEREST         = 0;
   private static final int  END_WERT_ISBN    = 0;
   private static final int  SQUARE           = 2;
   private static final int  START_WERT_ISBN  = 9;
   private static final int  BASIS            = 10; //Besserer Name überlegen
   private static final int  END_MODULO_ISBN  = 11;
   
   private static final double INITIALWERT    = 0;
   
   static public long berechneTeilersumme (long zahl){
       long teilersumme   = START_WERT_SUMME;
      
       for(long teiler = KLEINSTER_TEILER; teiler <= zahl ;teiler++)
           if(zahl % teiler == OHNEREST){
               teilersumme    += teiler;       
           }
       return teilersumme;
   }

   static String berechneChecksummeIsbn(long isbn){
       long pruefziffer = START_WERT_SUMME;
       for(int i = START_WERT_ISBN; i > END_WERT_ISBN; i--)
       {
           pruefziffer = pruefziffer + i * (isbn % BASIS);  
           isbn         = isbn / BASIS;
       }
       pruefziffer = pruefziffer % END_MODULO_ISBN;
       return "" +pruefziffer;
   }
   
   static String berechneNullstellen (double p, double q){
       double x1               = INITIALWERT;
       double x2               = INITIALWERT;
       double halbesP          = p/2;
       double halbesPimQuadrat = Math.pow(halbesP , SQUARE);
       
       if(halbesPimQuadrat < 0){
           return "Komplexe Nullstellen";
       }
       else if(halbesPimQuadrat == 0){
           x1 = -1 * halbesP;
           return "Doppelte Nullstelle: " + x1;
       }
       else{
           x1 = -1 * halbesP + Math.sqrt(halbesPimQuadrat - q);
           x2 = -1 * halbesP - Math.sqrt(halbesPimQuadrat - q);
           return "Zwei Nullstellen: " + x1 + "|" + x2;
       }
  
   }
}
