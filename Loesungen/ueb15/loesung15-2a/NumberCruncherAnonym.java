/**
 *    ----> NumberCruncherAnonym.java
 *
 * @author      Markus Esch
 * @author      Wolfgang Pauly (erweitert/angepasst)
 *
 */

 

import java.util.Random;

public class NumberCruncherAnonym 
  {
    private float[] values;
 


  //------------------------------------------------------
    interface CrunchOperation
       {
          public void crunch();
       }
 


  //------------------------------------------------------
    public NumberCruncherAnonym(float[] initValues)
      {
       values = new float[initValues.length];

       for ( int i=0; i < values.length; i++)
         {
           values[i]= initValues[i];
         }
      }
  
  //------------------------------------------------------
    public NumberCruncherAnonym(int size)
      {
       values = new float[size];
       Random ran = new Random();

       for ( int i=0; i < values.length; i++)
         {
           values[i]= ran.nextFloat();
         }
      }
  

    public NumberCruncherAnonym(int size, int max)
      {
       values = new float[size];

       for ( int i=0; i < values.length; i++)
         {
           values[i]= i + max;
         }
      }




  //------------------------------------------------------
    public void crunch(String[] operations)
      {

       //----- anonymous Class realisiert CrunchOperation -------------
       CrunchOperation sum 
         = new CrunchOperation()
                    {
                      public void crunch() 
                        {
                          for ( int i=1; i < values.length; i++)
                            {
                              values[i] = values[i-1] + values[i];
                            }
                        }   
                    };



       //----- anonymous Class realisiert CrunchOperation -------------
       CrunchOperation swirl 
         = new CrunchOperation()
                    {
                      public void crunch() 
                        {
                          Random ran = new Random();
                          float helfer;
                          int index1, index2;
                          
                          for ( int i=1; i < values.length; i++)
                             {
                                index1 = ran.nextInt(values.length);
                                index2 = ran.nextInt(values.length);
                             
                                helfer  = values[index1];
                                values[index1] = values[index2];
                                values[index2] = helfer;
                             }
                        }
                    };



       //----- anonymous Class realisiert CrunchOperation -------------
       CrunchOperation divide 
         = new CrunchOperation() 
                    {
                      item[] items;

                      public void crunch() 
                        {
                          items = new item[values.length];

                          for ( int i=0; i < values.length; i++ )
                            {
                             items[i] = new item(i, values[i]);
                            }

                          sort();

                          for ( int i=0; i < values.length / 2; i++)
                            {
                             values[items[i].index] = values[items[i].index] / 
                                                      values[items[items.length-1-i].index];
                            }
                        }

                      private void sort()
                        {
                          for ( int i=items.length; i > 0; i-- )
                            {
                             for ( int j=0; j < items.length-1; j++ )
                               {
                                if ( compare( items[j], items[j+1] ) > 0 )
                                  {
                                   swap(j, j+1);
                                  } 
                               } 
                            }
                        }
   
                      private void swap(int i, int j)
                        {
                         item tmp = items[i];
                         items[i] = items[j];
                         items[j] = tmp;  
                        }
   
                      private float compare(item i, item j)
                        {
                         return j.value - i.value;
                        }
   
                      class item
                        {
                         int index;
                         float value;

                         private item(int i, float value) 
                           {
                            this.index = i;
                            this.value = value;
                           }
                        }
                    };


       //----- anonymous Class realisiert CrunchOperation -------------
       CrunchOperation substract 
         = new CrunchOperation()
                    {
                      public void crunch() 
                        {
                          for ( int i=1; i < values.length; i++)
                            {
                              values[i] = values[i-1] - values[i];
                            }
                        }   
                    };






       //----- anonymous Class realisiert CrunchOperation -------------
       CrunchOperation average 
         = new CrunchOperation()
                    {
                      public void crunch() 
                        {
                          float summe = 0;
                          
                          for ( int i=0; i < values.length; i++)
                            {
                              summe += values[i];
                            }
                          values[indexMaxWert()] = summe / values.length;
                        }   
                    };






       for ( int i = 0; i < operations.length; i++)
         {
           switch ( operations[i] )
             {
              case "sum":
                           sum.crunch();
                           break;
              case "swirl":
                           swirl.crunch();
                           break;
              case "divide":
                           divide.crunch();
                           break;
              case "subtract":
                           substract.crunch();
                           break;
              case "average":
                           average.crunch();
                           break;
              default:     
                           break;
             }
         }
      }




  //------------------------------------------------------
    private int indexMaxWert()
      {
          int indexMax = 0;
          float maxWert = values[indexMax];
          for ( int i=1; i < values.length; i++)
            {
              if ( values[i] > maxWert )
                {
                  maxWert = values[i];
                  indexMax = i;
                }
            }
          return indexMax;
      }
      



  //------------------------------------------------------
    private int indexMinWert()
      {
          int indexMin = 0;
          float minWert = values[indexMin];
          for ( int i=1; i < values.length; i++)
            {
              if ( values[i] < minWert )
                {
                  minWert = values[i];
                  indexMin = i;
                }
            }
          return indexMin;
      }


  //------------------------------------------------------


    public float[] getNumbers()
      {
        return values;
      }


  //------------------------------------------------------
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
