
/**
 * Einfache Klasse fuer die Beschreibung von Projekten.
 * 
 * @author Folz, wpy erweitert 13.01.2013
 * @version 2013
 *
 * von wpy ergaenzt um weiteren Konstruktor
 */
public class Projekt extends Projektbestandteil {
    public static String MSG_STUNDENSATZ = "Stundensatz muss > 0.0 sein!";
    public static String MSG_TEIL = "Das hinzuzufuegende Objekt darf nicht leer sein!";
    
    
    public static double STANDARD_STUNDENSATZ = 100.00;
    private static int MAX_ANZ_TEILE = 6;
    
    
    private double stundensatz;
    private Projektbestandteil[] pteil;
    private int anzTeile;
    
    public Projekt(String name, String beschreibung) {
        super(name, beschreibung);
        this.stundensatz = STANDARD_STUNDENSATZ;
        pteil = new Projektbestandteil[MAX_ANZ_TEILE];
        anzTeile = 0;
    }

    public Projekt(String name, String beschreibung, double stundensatz) {
        super(name, beschreibung);
        assert stundensatz > 0.0 : MSG_STUNDENSATZ;
        this.stundensatz = stundensatz;
        pteil = new Projektbestandteil[MAX_ANZ_TEILE];
        anzTeile = 0;
    }
    
    public double getStundensatz() {
        return stundensatz;
    }
    
    public void setStundensatz( double stundensatz ) {
        assert stundensatz > 0.0 : MSG_STUNDENSATZ;
        this.stundensatz = stundensatz;
    }
    
    public void add(Projektbestandteil teil) {
        assert teil != null : MSG_TEIL;
        assert !isFull();
        pteil[anzTeile] = teil;
        teil.setProjekt(this); 
        anzTeile++;
    }
    
    public void delete(String name) {
           int lauf;
           
        for ( lauf = 0; (lauf < anzTeile) && !(pteil[lauf]).name.equals(name); lauf++ )
          {};
        
        if ( lauf == anzTeile )
          {
            throw new RuntimeException( name + " . ist kein Projektbestandteil !!!" );
          }
        else
          {
           for ( ; lauf < anzTeile - 1; lauf++ )
               {
                 pteil[lauf] = pteil[lauf + 1];
               };
             pteil[lauf] = null;
             anzTeile--;
          }
    }
    
    
    public boolean isFull() {
        return anzTeile == MAX_ANZ_TEILE;
    }
    
    /**
     * projektgesamtkosten ermitteln aus den Kosten der Teile
     *
     * @return die ermittelten Kosten
     */
    public double getKosten() {
        double gesamtKosten = 0.0;
        for (int i = 0; i < anzTeile; i++) {
            gesamtKosten += pteil[i].getKosten();
        }
        return gesamtKosten;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer("Projekt: " + super.toString() + '\n'); 
        for (int i = 0; i < anzTeile; i++) {
            sb.append(i).append(": ")
              .append(pteil[i]).append('\n');
        }
        sb.append("Projektgesamtkosten: " + this.getKosten());
        return sb.toString();
    }
}
