import java.util.Random;


public class Producer
{
    private Random zufall;


    public Producer()
    {
       this.zufall = new Random();
    }


    public int produce()
    {
       int product = zufall.nextInt( 1001 );

       System.out.println( "I produced " + product );

       return product;
    }

}
