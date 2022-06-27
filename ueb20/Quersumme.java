import java.util.Map;
import java.util.HashMap;

/**
 * Beschreiben Sie hier die Klasse Quersumme.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Quersumme
{
    Map<Integer, Long> map;
    Integer sum = 0;
    Integer number = 0;
    
    /**
     * Konstruktor für Objekte der Klasse Quersumme
     */
    public Quersumme()
    {
        map = new HashMap<>();   
    }

    public void setSum(Integer i){
        if(i < 0){
            throw new IllegalArgumentException("Quersumme darf nicht negativ sein");
        }
        this.sum = i;    
    }
    
    public void setNumber(Integer i){
        if(i < 0){
            throw new IllegalArgumentException("Zahl darf nicht negativ sein");
        }
        this.number = i;    
    }
    
    public void put(Integer i, Long time){
        if(i < 0){
            throw new IllegalArgumentException("Anzahl der Rechenschritte darf nicht negativ sein");
        }
        if(time < 0){
            throw new IllegalArgumentException("Zeit darf nicht negativ sein");
        }
        
        map.put(i,time); 
    }
    
    public Integer getSum(){
        return this.sum;
    }
    
    public Integer getNumber(){
        return this.number;
    }
    
    @Override
    public String toString(){
        String s ="Quersumme von: " + getNumber() + "\nErgebnis: " + getSum() + "\nZeitstempel: \n";
        s += this.map;
        return s;
    }
}
