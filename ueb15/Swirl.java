import java.util.Random;

/**
 * Beschreiben Sie hier die Klasse Swirl.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Swirl implements CrunchOperation 
{
 
 
    /**
     * Konstruktor für Objekte der Klasse Swirl
     */
    public Swirl()
    {
        
    }

    public void crunch(float[] values){
        Random r = new Random();
        int index1;
        int index2;
        float temp;
        for(int i = 0; i < values.length; i++){
            index1  = r.nextInt(values.length);   
            index2 = r.nextInt(values.length);
            temp = values[index1];
            values[index1] = values[index2];
            values[index2] = temp;
        }
      
    }
}
