import java.util.function.IntPredicate;
import java.util.function.Predicate;
/**
 * Beschreiben Sie hier die Klasse Function.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class Function {

   private static IntPredicate odd = new IntPredicate() {
        public boolean test(int number) {
            return (number % 2) == 0 ;
        }
    };

   private static IntPredicate even = number -> (number % 2) == 1;

   private static MyFunction quadrat = (x) -> {return x*x;};

   private static MyFunction quadratVonGeradeZahlen = (x) -> {
       if (Function.odd.test(x)) {
           return Function.quadrat.apply(x);
       }

       return -1;
   };
  
   private static MyFunction fact = (x) -> {
       int erg = 1;
       for(int i = 1; i<=x; i++)
            erg *= i;
       return erg;
   };

   private static MyFunction factVonUngerade = (x) -> {

       if (Function.even.test(x)) {
           return Function.fact.apply(x);
       }
       return 0;
   };
   
   private static MyFunction potenz = (x) -> {return (int)Math.pow(x, x+1);};
   
   private static MyFunction fib = (x) ->{
        int fibonacci1 = 0;
        int fibonacci2 = 1;
        int fibonacci  = 1;

        for (int i = 0; i < x; i++) {
        fibonacci = fibonacci1 + fibonacci2;
        fibonacci1 = fibonacci2;
        fibonacci2 = fibonacci;
        }
        return fibonacci;
       };
   
   private static class NestedFact implements MyFunction{
        @Override
        public int apply(int x) {
        int erg = 1;
        for(int i = 1; i<=x; i++)
            erg *= i;
        return erg;
    }
   }
   
   public static void main(String[] args) {
       // anonyme Klassen
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
       
       MyFunction potenzAnonym = new MyFunction() {
            public int apply(int x) {
                return (int)Math.pow(x, x+1);    
            }
       };
       
       MyFunction fibAnonym = new MyFunction() {
           public int apply(int x) {
                int fibonacci1 = 0;
                int fibonacci2 = 1;
                int fibonacci  = 1;

                for(int i = 0; i < x; i++) {
                    fibonacci = fibonacci1 + fibonacci2;
                    fibonacci1 = fibonacci2;
                    fibonacci2 = fibonacci;
                    }
                return fibonacci;
           }
       };
       
       Function f = new Function();
       Fakultaet factTopLevel = new Fakultaet();
       Function.NestedFact factNested = new  Function.NestedFact();
       
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
       for(int i=0; i<10;i++) {
           
           System.out.println(i + ": " + functionP.conditionateInput(GreaterThan5).apply(i));
       }
       System.out.println("conditionateOutput");
       for(int i=0; i<10;i++) {
           
           System.out.println(i + ": " + functionP.conditionateOutput(GreaterThan5).apply(i));
       }

       // Aufgabe e
       System.out.println("Quadrat von geraden Zahlen:");
       f.applyAndPrint(1,10, f.quadratVonGeradeZahlen);

       // Aufgabe f
       System.out.println("Fakultaet von ungeraden Zahlen:");
       f.applyAndPrint(1,10, f.factVonUngerade);
   }
    

   public void applyAndPrint(int i, int j, MyFunction f) {

        if (i < 1 || j < 1) {
            throw new IllegalArgumentException("Nur naturiche Zahlen werden unterstuetzt");
        }

        if(j < i) {
            throw new IllegalArgumentException("Die zweite Zahl muss groesser oder gleich der ersten Zahl sein.");
        }
        
        for (int k = i; k <= j ; k++) {
            System.out.println(k + ": " + f.apply(k) + "\n");
        }
   }
}
