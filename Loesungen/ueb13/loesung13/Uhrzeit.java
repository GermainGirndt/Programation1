
/**
 * Die Klasse Uhrzeit repraesentiert eine Uhrzeit
 *                    mit Stunden und Minuten.
 * 
 * @author Wolfgang Pauly
 * @version -1.0 beta 2022-04-11
 */

public class Uhrzeit
{

    // Attribute (Instanzvariablen)
    private int stunde;
    private int minute;

    /**
     * Konstruktor für Objekte der Klasse Uhrzeit
     * 
     * @param initStunde Stunden-Angabe : werte 0 bis 23
     * @param initMinute Minuten-Angabe : werte 0 bis 59
     */
    public Uhrzeit(int initStunde, int initMinute)
           throws UhrzeitException
    {
      UhrzeitException.stundeKorrekt( initStunde );
      UhrzeitException.minuteKorrekt( initMinute );
      
      stunde = initStunde;
      minute = initMinute;
    }

    /**
     * Die getStunde-Methode
     * 
     */
    public int getStunde()
    {
        return stunde;
    }

    /**
     * Die getMinute-Methode
     * 
     */
    public int getMinute()
    {
        return minute;
    }

    /**
     * Die equals-Methode
     * 
     * Compares this object to the specified object. 
     * The result is true if and only if the argument is not null and is an Uhrzeit-object 
     * that contains the same values for stunde, minute as this object
     */
    public boolean equals(Object vergleichsUhrzeit)
    {
        return  ( vergleichsUhrzeit != null ) && 
                ( vergleichsUhrzeit instanceof Uhrzeit) &&
                ( ( (Uhrzeit)vergleichsUhrzeit).getStunde() == stunde ) &&
                ( ( (Uhrzeit)vergleichsUhrzeit).getMinute() == minute);
    }

    /**
     * Die toString-Methode
     * 
     */
    public String toString()
    {
        return stunde + ":" + minute + " Uhr";
    }
}
