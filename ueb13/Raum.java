
/**
 * Der Raum wird in der Reservierung benutzt
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
    
    private static final int GEB_MIN       = 1;
    private static final int RAUM_MIN      = 1;
    private static final int ARRAY_GROESSE = 20;
    private static final int MAXANZAHL_AN_RESERVIERUNGEN = 9999999;
    
    private static final String FEHLER_GEB          = "Die Gebaeudenummer muss positiv sein";
    private static final String FEHLER_RAUM         = "Die Raumnummer muss positiv sein";
    private static final String FEHLER_RESERVIERUNG = "Die Reservierung ist null";
    private static final String FEHLER_RAUM_VOLL    = "Der Raum ist voll.";
    
    /**
     * Konstruktor für Objekte der Klasse Raum
     * @param geb ist die Gebaeudenummer, sie muss positiv sein
     * @param etage ist die Etage, sie kann auch negativ wegen dem Keller sein
     * @param raum ist die Raumnummer, sie muss positiv sein
     */
    public Raum(int geb, int etage, int raum)
    {
       if (geb < GEB_MIN) {
           throw new IllegalArgumentException(FEHLER_GEB);
       }
       if (raum < RAUM_MIN) {
            
       }
       this.geb   = geb;
       this.etage = etage;
       this.raum  = raum;
       
       this.reservierungen = new Reservierung[ARRAY_GROESSE];
    }

    /**
     * addReservierung fuegt eine Reservierung in das Reservierungenarray des Raumes ein
     * falls das limit erreicht ist wird die groesse des Arrays verdoppelt
     * @param reservierung ist die Reservierung, die hinzugefuegt wird
     */
    public void addReservierung(Reservierung reservierung) {
        if (reservierung == null) {
            throw new IllegalArgumentException(FEHLER_RESERVIERUNG);   
        }
        
        if (this.anzahlReservierungen == MAXANZAHL_AN_RESERVIERUNGEN) {
            throw new IllegalArgumentException(FEHLER_RAUM_VOLL);   
        }

        if (this.anzahlReservierungen == this.reservierungen.length) {
            this.verdoppleArrayGroesse();
        }

        this.reservierungen[anzahlReservierungen] = reservierung;
        this.anzahlReservierungen++;
        
    }

    private void verdoppleArrayGroesse() {

        Reservierung[] erweitertesArray = new Reservierung[reservierungen.length * 2];
           
        for (int index = 0; index < this.reservierungen.length; index++ ) {
             erweitertesArray[index] = this.reservierungen[index];
        }

        this.reservierungen = erweitertesArray;
    }
    
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        
        stringBuffer.append("Raum " + this.geb + "-" + this.etage + "." + this.raum);
        
        for(int i = 0; i < anzahlReservierungen; i++) {
            stringBuffer.append("\n" + reservierungen[i].toString());    
        }

        return stringBuffer.toString();
    }
}
