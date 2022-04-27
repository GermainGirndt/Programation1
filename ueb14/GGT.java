
/**
 * Beschreiben Sie hier die Klasse GGT.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class GGT
{
   
    /**
     * Konstruktor für Objekte der Klasse GGT
     */
    public GGT()
    {
        
    }

    public int ggT(int a, int b){
        if(b==0){
            return a;
        }
        else{
            return ggT(b, a%b);
        }
    }
}
