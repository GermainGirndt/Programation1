
/**
 * Beschreiben Sie hier die Klasse Raum.
 * 
 * @author Girndt & Krier
 * @version 1.0
 */
public class Raum
{
    private int geb;
    private int etage;
    private int raum;
    private int anzahlReservierungen = 0;
    private Reservierung[] reservierungen;
    
    private static int GEB_MIN       = 1;
    private static int RAUM_MIN      = 1;
    private static int ARRAY_GROESSE = 20;
    
    private static String FEHLER_GEB          = "Die Gebaeudenummer muss positiv sein";
    private static String FEHLER_RAUM         = "Die Raumnummer muss positiv sein";
    private static String FEHLER_RESERVIERUNG = "Die Reservierung ist null";
    
    /**
     * Konstruktor für Objekte der Klasse Raum
     * @param geb ist die Gebaeudenummer, sie muss positiv sein
     * @param etage ist die Etage, sie kann auch negativ wegen dem Keller sein
     * @param raum ist die Raumnummer, sie muss positiv sein
     */
    public Raum(int geb, int etage, int raum)
    {
       if(geb < GEB_MIN){
           throw new IllegalArgumentException(FEHLER_GEB);
       }
       if(raum < RAUM_MIN){
            
       }
       this.geb   = geb;
       this.etage = etage;
       this.raum  = raum;
       
       reservierungen = new Reservierung[ARRAY_GROESSE];
    }

    /**
     * addReservierung fuegt eine Reservierung in das Reservierungenarray des Raumes ein
     * falls das limit erreicht ist wird die groesse des Arrays verdoppelt
     * @param reservierung ist die Reservierung, die hinzugefuegt wird
     */
    public void addReservierung(Reservierung reservierung){
        if(reservierung == null){
            throw new IllegalArgumentException(FEHLER_RESERVIERUNG);   
        }
        
        reservierungen[anzahlReservierungen] = reservierung;
        anzahlReservierungen++;
        
        if(anzahlReservierungen >= reservierungen.length){
           Reservierung[] temp = new Reservierung[reservierungen.length * 2];
           System.arraycopy(reservierungen, 0, temp, 0, reservierungen.length);
           reservierungen = temp;
        }
    }
    
    @Override
    public String toString(){
        String ausgabe = "Raum " + geb + "-" + etage + "." + raum + "\n";
        for(int i = 0; i < anzahlReservierungen; i++){
            ausgabe += reservierungen[i].toString() + "\n";    
        }
        return ausgabe;
    }
}
