import java.util.ArrayList;
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
   
   static public long berechneTeilersumme (long zahl){
       long teilersumme   = START_WERT_SUMME;
       long teiler        = KLEINSTER_TEILER;
       long spiegelteiler = zahl;
       long haelfteZahl;
       ArrayList<Long> vorgekommeneSpiegelteiler;
       if(zahl % 2 == 0){
           haelfteZahl = zahl / 2;    
           vorgekommeneSpiegelteiler = new ArrayList<Long>();
       }
       else{
           haelfteZahl = (zahl + 1) / 2;
           vorgekommeneSpiegelteiler = new ArrayList<Long>();
       }
       
      while(!pruefeObInLIiste(vorgekommeneSpiegelteiler , teiler)){
           if(zahl % teiler == 0){
               spiegelteiler   = zahl / teiler;
               teilersumme    += teiler;
               teilersumme    += spiegelteiler;
               vorgekommeneSpiegelteiler.add(spiegelteiler);
               
           }
           teiler++;
       }
       
       return teilersumme;
   }
   
   public static boolean pruefeObInLIiste(ArrayList<Long> liste , Long zahlZumPruefen ){
       boolean contains = liste.contains(zahlZumPruefen);
       return contains;
   }
}
