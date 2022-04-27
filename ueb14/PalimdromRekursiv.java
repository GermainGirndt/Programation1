
/**
 * Beschreiben Sie hier die Klasse PalimdromRekursiv.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class PalimdromRekursiv implements Palimdrom
{
   
    
    
    /**
     * Konstruktor für Objekte der Klasse PalimdromRekursiv
     */
    public PalimdromRekursiv()
    {
       
    }

    @Override 
    public boolean istPalimdrom(String s){
        if(s.isEmpty()){
            return false;
        }
        
        s = s.toLowerCase();
        
        return pruefeRekursiv(s);
       
    }
    
    private boolean pruefeRekursiv(String s){
         String u;
        
        if(s.charAt(0) == s.charAt(s.length() -1)){
             if(s.length() <= 2){
                 return true;
             }
             
             u = s.substring(1, s.length() -1);
             return istPalimdrom(u);    
        }
        else{
            return false;
        }    
    }
}
