 

import java.util.Random;

public class NumberCruncherTopLevel 
  {
     private float[] values;
 

  //------------------------------------------------------
    public NumberCruncherTopLevel(float[] initValues)
      {
        values = new float[initValues.length];
  
        for ( int i=0; i < values.length; i++)
          {
            values[i]= initValues[i];
          }
      }
  
    public NumberCruncherTopLevel( int size)
      {
       values = new float[size];
       Random ran = new Random();

       for ( int i=0; i < values.length; i++)
         {
           values[i]= ran.nextFloat();
         }
      }
  
      
    public NumberCruncherTopLevel( int size, int max)
      {
       values = new float[size];

       for ( int i=0; i < values.length; i++)
         {
           values[i]= i + max;
         }
      }



    public void crunch(String[] operations)
      {

       CrunchOperation sum = new Sum();
       CrunchOperation swirl = new Swirl();
       CrunchOperation divide = new Divide();
       CrunchOperation substract = new Subtract();
       CrunchOperation average = new Average();

       for ( int i = 0; i < operations.length; i++)
         {
           switch ( operations[i] )
             {
              case "sum":
                           sum.crunch( values );
                           break;
              case "swirl":
                           swirl.crunch( values );
                           break;
              case "divide":
                           divide.crunch( values );
                           break;
              case "subtract":
                           substract.crunch( values );
                           break;
              case "average":
                           average.crunch( values );
                           break;
              default:     
                           break;
             }
         }
      }


    public float[] getNumbers()
      {
        return values; 
      }


    public String toString()
      {
        String dasArray = new String("\n\n der Array-Inhalt : ");
        for ( int i=0; i < values.length; i++)
          {
            dasArray+= " " + values[i] ;
          }
        return dasArray; 
      }
}
