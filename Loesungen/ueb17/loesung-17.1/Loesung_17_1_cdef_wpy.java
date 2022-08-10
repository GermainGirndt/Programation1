/*
 *
 *
 * Loesung  W.Pauly 
 *
 *
 */

import java.util.function.IntPredicate;

public class Loesung_17_1_cdef_wpy  
  {
 

   //
   //1.a:
   public void applyAndPrint(MyFunction  iFunc, int i, int j)
     {
      for ( int lauf = i; lauf <= j; lauf++ )
        {
         System.out.println( lauf + " -> " + iFunc.apply(lauf) );
        }
     }



   public void run()
     {

       //
       //1.b:
       // x*x als Lambda-Ausdruck
       MyCondFunction  xQuadrat = x -> x*x;



       // x! als Lambda-Ausdruck
       MyCondFunction  xFakult = x -> 
                                     {
                                      int erg = 1;
                             
                                      for ( int i = 2; i<=x; i++ )
                                        {
                                         erg *= i;
                                        }
                                      return erg;
                                     };


       //
       //1.d:  
       IntPredicate even = x -> x % 2 == 0;
   
       IntPredicate odd = new IntPredicate() {
          public boolean test(int wert) 
                {
                 return wert % 2 == 1;
                }
       };
    
       //
       //1.e
       System.out.println( "\n xQuadrat-Aufruf --> wenn INPUT-Zahlen gerade");
       applyAndPrint( xQuadrat.conditionateInput(even), 1, 10 );
       
       //
       //1.e
       System.out.println( "\n xQuadrat-Aufruf --> wenn INPUT-Zahlen UNgerade");
       applyAndPrint( xQuadrat.conditionateInput(odd), 1, 10 );
       
       //
       //1.e
       System.out.println( "\n xQuadrat-Aufruf --> wenn OUTPUT-Zahlen gerade");
       applyAndPrint( xQuadrat.conditionateOutput(even), 1, 10 );
       
       //
       //1.e
       System.out.println( "\n xQuadrat-Aufruf --> wenn OUTPUT-Zahlen UNgerade");
       applyAndPrint( xQuadrat.conditionateOutput(odd), 1, 10 );
       
       //
       //1.f
       System.out.println( "\n xFakult-Aufruf --> wenn INPUT-Zahlen gerade");
       applyAndPrint( xFakult.conditionateInput(even), 1, 10 );
       
       //
       //1.f
       System.out.println( "\n xFakult-Aufruf --> wenn INPUT-Zahlen UNgerade");
       applyAndPrint( xFakult.conditionateInput(odd), 1, 10 );
       
       //
       //1.f
       System.out.println( "\n xFakult-Aufruf --> wenn OUTPUT-Zahlen gerade");
       applyAndPrint( xFakult.conditionateOutput(even), 1, 10 );
       
       //
       //1.f
       System.out.println( "\n xFakult-Aufruf --> wenn OUTPUT-Zahlen UNgerade");
       applyAndPrint( xFakult.conditionateOutput(odd), 1, 10 );
     }
 

   public static void main(String[] args)
     {
       Loesung_17_1_cdef_wpy test = new Loesung_17_1_cdef_wpy();
       test.run();
     }
}
