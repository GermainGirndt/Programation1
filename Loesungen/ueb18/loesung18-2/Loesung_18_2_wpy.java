/*
 *
 *
 * Loesung  W.Pauly 
 *
 *
 */


public class Loesung_18_2_wpy 
  {

   //  
   //
   //17_1.a:
   public void applyAndPrint(MyFunction myFunction, int i, int j)
     {
      for ( int lauf = i; lauf <= j; lauf++ )
        {
         System.out.println( lauf + " -> " + myFunction.apply(lauf) );
        }
     }
 
   //
   //17_1.b-ii: Fakultaet als Nested-Static-Klasse
   //
   // dort so realisiert:
   //                 public static class NestedFakultaet implements MyFunction
   //                 {
   //                    public int apply(int x)
   //                  ....
   //
   // nun OHNE implements und Methoden-Name apply möglich !!!!!!!!
   // applyAndPrint-Aufruf mit einer statischen Methoden-Referenz möglich
   //
   public static class NestedFakultaet
     {
      public static int rechne(int x)
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
       // 18_2.a
       // x! als  top level class FakultaetTopLevel


       FakultaetTopLevel fakTopL = new FakultaetTopLevel();

       System.out.println( "\n xFakult - FakultaetTopLevel - Klasse");
       System.out.println( "\n als Lambda-Ausdruck 2");

       applyAndPrint(x -> fakTopL.berechne(x), 1, 10);
       
       
       System.out.println( "\n xFakult - FakultaetTopLevel - Klasse");
       System.out.println( "\n Objekt-MethodenReferenz");
      
       applyAndPrint(fakTopL::berechne, 1, 10);
               
          

       //
       //
       // 18_2.b
       // x! als  static nested class NestedFakultaet

       System.out.println( "\n xFakult - Static Nested - Klasse");
       System.out.println( "\n als Lambda-Ausdruck");

       applyAndPrint(x -> NestedFakultaet.rechne(x), 1, 10);


       System.out.println( "\n xFakult - Static Nested - Klasse");
       System.out.println( "\n statische MethodenReferenz");

       applyAndPrint(NestedFakultaet::rechne, 1, 10);
              
     }
         
     
   public static void main(String[] args)
     {
       Loesung_18_2_wpy test = new Loesung_18_2_wpy();
       test.run();
    }
    
  }
