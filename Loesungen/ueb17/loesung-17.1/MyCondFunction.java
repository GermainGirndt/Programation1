/*
 *
 *
 * Loesung  W.Pauly 
 *
 *
 */

import java.util.function.IntPredicate;

public interface MyCondFunction
       extends MyFunction
  {
   //
   //1.c:
   default public MyCondFunction  conditionateInput(IntPredicate ipre)
     {
       //return (int value) -> ipre.test(value) ? apply(value) : 0;   
       return ( int value ) -> {
                                  if ( ipre.test( value ) )
                                    {
                                      return apply(value);
                                    }
                                  else
                                    {
                                      return 0;
                                    }
     
                                };
     }
         
   default public MyCondFunction  conditionateOutput(IntPredicate ipre)
     {
       //return (int value) -> ipre.test(apply(value)) ?  apply(value) : 0;   
       return ( int value ) -> {
                                  if ( ipre.test( apply(value) ) )
                                    {
                                      return apply(value);
                                    }
                                  else
                                    {
                                      return 0;
                                    }
   
                                };
     }

  }
 
