import java.util.function.Predicate;
/**
 * Beschreiben Sie hier die Klasse Functions.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Functions {
   public static MyFunction quadrat = (x) -> {return x*x;};

   public static MyFunction quadratVonGeradeZahlen = (x) -> {
       if (ParityChecker.odd.test(x)) {
           return Functions.quadrat.apply(x);
       }

       return -1;
   };
  
   public static MyFunction fact = (x) -> {
       int erg = 1;
       for(int i = 1; i<=x; i++)
            erg *= i;
       return erg;
   };

   public static MyFunction factVonUngerade = (x) -> {

       if (ParityChecker.even.test(x)) {
           return Functions.fact.apply(x);
       }
       return 0;
   };
   
   public static MyFunction potenz = (x) -> {return (int)Math.pow(x, x+1);};
   
   public static MyFunction fib = (x) ->{
        int fibonacci1 = 0;
        int fibonacci2 = 1;
        int fibonacci  = 1;

        for (int i = 0; i < x; i++){
        fibonacci = fibonacci1 + fibonacci2;
        fibonacci1 = fibonacci2;
        fibonacci2 = fibonacci;
        }
        return fibonacci;
       };
   
   public static class NestedFact implements MyFunction{
        @Override
        public int apply(int x){
        return applyStatic(x);
       }
       
        public static int applyStatic(int x){
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
       
       MyFunction potenzAnonym = new MyFunction(){
            public int apply(int x){
                return (int)Math.pow(x, x+1);    
            }
       };
       
       MyFunction fibAnonym = new MyFunction(){
           public int apply(int x){
                int fibonacci1 = 0;
                int fibonacci2 = 1;
                int fibonacci  = 1;

                for(int i = 0; i < x; i++){
                    fibonacci = fibonacci1 + fibonacci2;
                    fibonacci1 = fibonacci2;
                    fibonacci2 = fibonacci;
                    }
                return fibonacci;
           }
       };
       
       Functions f = new Functions();
       Fakultaet factTopLevel = new Fakultaet();
       Functions.NestedFact factNested = new  Functions.NestedFact();
       
       System.out.println("QuadratLamda");
       f.applyAndPrint(1,10, f.quadrat);
       System.out.println("QuadratAnonym");
       f.applyAndPrint(1,10, quadratAnonym);
       System.out.println("FakultaetLamda");
       f.applyAndPrint(1,10, f.fact);
       System.out.println("FakultaetAnonym");
       f.applyAndPrint(1,10, factAnonym);
       System.out.println("FakultaetTopLevel");
       f.applyAndPrint(1,10, factTopLevel);
       System.out.println("FakultaetStaticNested");
       f.applyAndPrint(1,10,factNested);
       System.out.println("PotenzLamda");
       f.applyAndPrint(1,10, f.potenz);
       System.out.println("PotenzAnonym");
       f.applyAndPrint(1,10, potenzAnonym);
       System.out.println("FibonacciLamda");
       f.applyAndPrint(1,10, f.fib);
       System.out.println("FibonacciAnonym");
       f.applyAndPrint(1,10, fibAnonym);
       
       //nur zum schnell testen
       Predicate<Integer> GreaterThan5 =  x -> x > 5;
       MyFunctionP functionP = (x) -> {return x*x;};
       System.out.println("conditionateInput");
       for(int i=0; i<10;i++){
           
           System.out.println(i + ": " + functionP.conditionateInput(GreaterThan5).apply(i));
       }
       System.out.println("conditionateOutput");
       for(int i=0; i<10;i++){
           
           System.out.println(i + ": " + functionP.conditionateOutput(GreaterThan5).apply(i));
       }

       // Aufgabe e
       System.out.println("Quadrat von geraden Zahlen:");
       f.applyAndPrint(1,10, f.quadratVonGeradeZahlen);

       // Aufgabe f
       System.out.println("Fakultaet von ungeraden Zahlen:");
       f.applyAndPrint(1,10, f.factVonUngerade);
       
       //ueb 18
       System.out.println("FakultaetObjektMethodenReferenz:");
       f.applyAndPrint(1,10, factTopLevel::apply);
       System.out.println("FakultaetStatischeMethodenReferenz:");
       f.applyAndPrint(1,10, NestedFact::applyStatic);
   }
    

   public void applyAndPrint(int i, int j, MyFunction f) {

        if (i < 1 || j < 1) {
            throw new IllegalArgumentException("Nur naturiche Zahlen werden unterstuetzt");
        }

        if(j < i){
            throw new IllegalArgumentException("Die zweite Zahl muss groesser oder gleich der ersten Zahl sein.");
        }
        
        for(int k = i; k <= j ; k++){
            System.out.println(k + ": " + f.apply(k) + "\n");
        }
   }
}
