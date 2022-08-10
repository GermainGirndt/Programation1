
public class Subtract implements CrunchOperation
{
  public void crunch( float values[] ) 
    {
      for ( int i=1; i < values.length; i++)
        {
          values[i] = values[i-1] - values[i];
        }
    }   
}
