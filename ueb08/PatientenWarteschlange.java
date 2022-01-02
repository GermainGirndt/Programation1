
/**
 * Beschreiben Sie hier die Klasse PatientenWarteschlange.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class PatientenWarteschlange
{
    private Patient[] warteschlange;
    private static final int ERSTERPLATZ = 0;
    private static final String NUMMER        = "Nummer:";
    private static final String VORNAME       = "Vorname:";
    private static final String NACHNAME      = "Nachname:";
    
    /**
     * Konstruktor für Objekte der Klasse PatientenWarteschlange
     */
    public PatientenWarteschlange(int groesse)
    {
        Validierung.validiereGroesse(groesse);
        this.warteschlange = new Patient[groesse];
    }

    public void neuerPatient(int nummer, String vorname, String nachname){
        if(!istWarteschlangeVoll()){
             Patient patient = new Patient(nummer, vorname, nachname);  
             for(int i = 0; i < warteschlange.length; i++){
                 if(warteschlange[i] == null){
                     warteschlange[i] = patient;
                     break;
                 }
             }
        }
        else{
            throw new IllegalArgumentException("Die Warteschlange ist voll!");
        }
    }
    
    public Patient entfernePatient(int nummer){
        int stellplatz            =  ERSTERPLATZ;
        Patient entfernterPatient = new Patient();
        Patient temp              = new Patient();   
        boolean gefunden          = false;
        
        for(int i = 0; i < warteschlange.length; i++){
            if(warteschlange[i].getNummer() == nummer){
                stellplatz        = i;
                entfernterPatient = warteschlange[i];
                gefunden          = true;
                break;
            }
        }
        if(gefunden){
            for(int j = stellplatz ; j < warteschlange.length; j++ ){
                if(j + 1 < warteschlange.length && warteschlange[j] != null){
                    warteschlange[j] = warteschlange[j+1];     
                }     
            }    
            return entfernterPatient;
        }
        else{
            throw new IllegalArgumentException("Diese Nummer ist nicht in der Warteschlange");
        }
    }
    
    public Patient derNaechsteBitte(){
        if(!istWarteschlangeLeer()){
             
             return  entfernePatient(warteschlange[0].getNummer());   
        }
        else{
            throw new IllegalArgumentException("Die Warteschlange ist voll!");
        }
    }
    
    private boolean istWarteschlangeVoll(){
        boolean voll = true;
        for(int i = 0; i < warteschlange.length; i++){
            if(warteschlange[i] == null){
                voll = false;
            }
        }
        
        return voll;
    }
    
    private boolean istWarteschlangeLeer(){
        boolean leer = true;
        for(int i = 0; i < warteschlange.length; i++){
            if(warteschlange[i] != null){
                leer = false;
                break;
            }
        }
        
        return leer;    
    }
    
    public String toString(){
        String ausgabe =  "\n" + NUMMER + "\t" + VORNAME + "\t" + NACHNAME + "\n" ;
        for(int i = 0; i < warteschlange.length; i++){
            if(warteschlange[i] != null){
                 ausgabe += warteschlange[i].getNummer() + "\t" + warteschlange[i].getVorname() + "\t\t" + warteschlange[i].getNachname() + "\n";    
            }
            else{
                break;
            }
        }
        return "\nIn der Warteschlange:" + ausgabe + "\n";
    }
}
