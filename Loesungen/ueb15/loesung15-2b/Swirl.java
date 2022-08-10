import java.util.Random;

public class Swirl implements CrunchOperation
{
  public void crunch( float values[] ) 
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
}
