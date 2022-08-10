/*
 *
 *
 * Loesung  W.Pauly 
 *
 *
 */


public class Loesung_17_1_ab_wpy 
  {

   //  
   //
   //1.a:
   public void applyAndPrint(MyFunction myFunction, int i, int j)
     {
      for ( int lauf = i; lauf <= j; lauf++ )
        {
         System.out.println( lauf + " -> " + myFunction.apply(lauf) );
        }
     }
 
   //
   //1.b-ii: Fakultaet als Nested-Static-Klasse
   //
   public static class NestedFakultaet implements MyFunction
     {
      public int apply(int x)
        {
          int erg = 1;
                
          for ( int i = 2; i<=x; i++ )
            {
             erg *= i;
            }
          return erg;
        }
     }
  

    public void run ()
      {

       //
       //
       //1.b-i:
       //
       // x*x als anonyme Klasse
       MyFunction xQuadratAnon = new MyFunction(){
                    public int apply( int x  )
                       {
                         return x * x;
                       }
       };
       System.out.println( "\n xQuadrat - anonyme Klasse");
       applyAndPrint( xQuadratAnon, 1, 10 );


       // x*x als Lambda-Ausdruck
       //
       // Lambda-Ausdruck ausfuehrlichst
       //                      vvvvvvv Interface-Methoden-Parameter
       //                      |||||||    vvvvvvvvvvvvvvvv Interface-Methoden-Rumpf
       //                      |||||||    ||||||||||||||||
       MyFunction x0_Quadrat = (int x) -> { return x*x; };

       //
       // Lambda-Ausdruck ausfuehrlich
       //                      v Interface-Methoden-Parameter
       //                      |    vvvvvvvvvvvvvvvv Interface-Methoden-Rumpf
       //                      |    ||||||||||||||||
       MyFunction x1_Quadrat = x -> { return x*x; };

       //
       // Lambda-Ausdruck Endform
       //                    v Interface-Methoden-Parameter
       //                    |    vvv Interface-Methoden-Rumpf
       //                    |    |||
       MyFunction xQuadrat = x -> x*x;

       System.out.println( "\n xQuadrat - Lambda-Ausdruck benamst ");
       applyAndPrint( xQuadrat, 1, 10 );

       //
       // Lambda-Ausdruck direkt im Methoden-Aufruf 
       System.out.println( "\n xQuadrat - Lambda-Ausdruck direkt ");
       applyAndPrint( x -> x*x, 1, 10 );


       //
       //
       // 1.b-ii
       // x! als anonyme Klasse
       MyFunction xFakultAnon = new MyFunction(){
                     public int apply( int x  )
                       {
                         int erg = 1;
                
                         for ( int i = 2; i<=x; i++ )
                           {
                            erg *= i;
                           }
                         return erg;
                       }
       };

       System.out.println( "\n xFakult - anonyme Klasse");
       applyAndPrint( xFakultAnon, 1, 10 );
       
       //
       //
       // 1.b-ii
       // x! als Lambda-Ausdruck
       MyFunction xFakult = x -> 
                                {
                                 int erg = 1;
                        
                                 for ( int i = 2; i<=x; i++ )
                                   {
                                    erg *= i;
                                   }
                                 return erg;
                                };

       System.out.println( "\n xFakult - Lambda-Ausdruck");
       applyAndPrint( xFakult, 1, 10 );

       //
       //
       // 1.b-ii
       // x! als Nested Klasse
       MyFunction xFakultNestedFakultaet  = new NestedFakultaet();
       System.out.println( "\n xFakult - Nested-Klasse");
       applyAndPrint( xFakultNestedFakultaet, 1, 10 );
         
       //
       //
       // 1.b-ii
       // x! als TopLevel-Klasse 
       MyFunction xFakultTopLevel  = new FakultaetTopLevel();
       System.out.println( "\n xFakult - TopLevel-Klasse");
       applyAndPrint( xFakultTopLevel, 1, 10 );      

       //
       //
       // 1.b-iii
       // x^(x+1) als anonyme Klasse
       MyFunction xHochxPlus1Anon = new MyFunction(){
                     public int apply( int x  )
                       {
                        int erg = x;
 
                        for ( int i = 2; i<=x+1; i++ )
                          {
                           erg *= x;
                          }
                        return erg;
                       } 
       };
       System.out.println( "\n xHochxPlus1 - anonyme Klasse"); 
       applyAndPrint( xHochxPlus1Anon, 1, 10 );

       //
       //
       // 1.b-iii
       // x^(x+1) als Lambda-Ausdruck
       MyFunction xHochxPlus1 = x -> 
                                     {
                                      int erg = x;
                             
                                      for ( int i = 2; i<=x+1; i++ )
                                        {
                                         erg *= x;
                                        }
                                      return erg;
                                     };

       System.out.println( "\n xHochxPlus1 - Lambda-Ausdruck"); 
       applyAndPrint( xHochxPlus1, 1, 10 );

        

       //
       //
       // 1.b-iv
       // fibonacci-Folge als anonyme Klasse
       MyFunction xFibonacAnon = new MyFunction(){
                     public int apply( int x  )
                       {
                        int fibN = 1;
                               int fibN1 = 1;
                               int fibN2 = 1;
                     
                               for (int i=3; i <= x; i++)
                                 {
                                  fibN = fibN1 + fibN2;
                                  fibN2 = fibN1;
                                  fibN1 = fibN;
                                 }
                               return fibN;
                              };
  
       };

      System.out.println( "\n xFibonac - anonyme Klasse");
      applyAndPrint( xFibonacAnon, 1, 10 );
 


       //
       //
       // 1.b-iv
       // fibonacci-Folge als Lambda-Ausdruck
       MyFunction xFibonac = x -> 
                                  {
                                   int fibN = 1; 
                                   int fibN1 = 1;
                                   int fibN2 = 1; 
                                 
                                   for (int i=3; i <= x; i++) 
                                     {
                                      fibN = fibN1 + fibN2;
                                      fibN2 = fibN1;
                                      fibN1 = fibN;
                                     }
                                   return fibN;
                                  };

       System.out.println( "\n xFibonac - Lambda-Ausdruck");
       applyAndPrint( xFibonac, 1, 10 );
       
     }
 
         
     
   public static void main(String[] args)
     {
       Loesung_17_1_ab_wpy test = new Loesung_17_1_ab_wpy();
       test.run();
    }
    
  }
