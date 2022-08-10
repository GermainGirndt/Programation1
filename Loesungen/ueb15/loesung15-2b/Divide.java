
public class Divide implements CrunchOperation
{
  item[] items;

  public void crunch( float values[] )
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
}

