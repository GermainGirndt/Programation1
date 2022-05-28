
/**
 * Beschreiben Sie hier die Klasse Functions.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Functions 
{
   public static MyFunction quadrat = (x) -> {return x*x;};
  
   public static MyFunction fact = (x) -> {
       int erg = 1;
       for(int i = 1; i<=x; i++)
            erg *= i;
       return erg;
   };
   
   
   public static class NestedFact implements MyFunction{
        @Override
        public int apply(int x){
        int erg = 1;
        for(int i = 1; i<=x; i++)
            erg *= i;
        return erg;
    }
   }
   
   public static void main(String[] args){
       //Anonyme Klassen
       MyFunction quadratAnonym = new MyFunction() {
            
            public int apply(int x) {
                return x*x;
            }
       };
       
       MyFunction factAnonym = new MyFunction() {
            
            public int apply(int x) {
                int erg = 1;
                for(int i = 1; i<=x; i++)
                    erg *= i;
                return erg;
            }
       };
       
       Functions f = new Functions();
       Fakultaet factTopLevel = new Fakultaet();
        Functions.NestedFact factNested = new  Functions.NestedFact();
       
       System.out.println("QuadratLamda");
       f.applyAndPrint(0,10, f.quadrat);
       System.out.println("QuadratAnonym");
       f.applyAndPrint(0,10, quadratAnonym);
       System.out.println("FakultaetLamda");
       f.applyAndPrint(0,10, f.fact);
       System.out.println("FakultaetAnonym");
       f.applyAndPrint(0,10, factAnonym);
       System.out.println("FakultaetTopLevel");
       f.applyAndPrint(0,10, factTopLevel);
       System.out.println("FakultaetStaticNested");
       f.applyAndPrint(0,10,factNested);
   }
    

   public void applyAndPrint(int i, int j, MyFunction f){
        if(j < i){
            throw new IllegalArgumentException("Die zweite Zahl muss groesser oder gleich der ersten Zahl sein.");
        }
        
        for(int k = i; k <= j ; k++){
            System.out.println(k + ": " + f.apply(k) + "\n");
        }
   }
    
    
}
