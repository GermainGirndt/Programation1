import java.util.ArrayList;

import javax.management.RuntimeErrorException;

/**
 * Beschreiben Sie hier die Klasse Flasche.
 * 
 * @author Girndt, Germain; Krier, Katharina 
 * @version 1.0
 */
public class GetraenkeAutomat<T extends Getraenk>
{
    private ArrayList<Flasche<T>> flaschenLager;
    private int kapazitaet;
    private final int ERSTE_FLASCHE_INDEX = 0;

    

    public GetraenkeAutomat(int kapazitaet) {
        if (kapazitaet <= 0) {
            throw new IllegalArgumentException("Kapazitaet muss groesser null sein.");
        }
        flaschenLager = new ArrayList<Flasche<T>>();
        this.kapazitaet = kapazitaet;
    }

    public void flascheEinlegen(Flasche<T> flasche) {
        if (!flasche.isVoll()) {
            throw new IllegalArgumentException("Flasche konnte nicht eingelegt werden. Das Getraenkeautomat nimmt nur volle Flasche auf");
        }
        if (this.istVoll()) {
            throw new IllegalArgumentException("Flasche konnte nicht eingelegt werden. Das Getraenkeautomat ist schon voll.");
        }
        
        this.flaschenLager.add(flasche);
    }
    
    public Flasche<T> flascheAusgeben() {
        if (this.istLeer()) {
            throw new IllegalArgumentException("Flasche konnte nicht ausgegeben werden. Das Getraenkeautomat ist leer!");

        }
        return this.flaschenLager.remove(ERSTE_FLASCHE_INDEX);
    }

    private boolean istLeer() {
        if(flaschenLager != null && flaschenLager.size() > 0) {
            return false;
        }
        else{
            return true;
        }
        
    }

    private boolean istVoll() {
        return this.kapazitaet == this.flaschenLager.size();
    }

    @Override 
    public String toString() {

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("Getraenke Automat: \n");
        for (Flasche<T> flasche : flaschenLager) {
            stringBuffer.append(flasche.toString() + "\n");
        }

        return stringBuffer.toString();
    }
}
