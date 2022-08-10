
public class Average implements CrunchOperation
{
  public void crunch( float values[] ) 
    {
    float summe = 0;

      for ( int i=0; i < values.length; i++)
        {
          summe += values[i];
        }
      values[indexMaxWert(values)] = summe / values.length;
    }

  public int indexMaxWert(float values[])
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


}
