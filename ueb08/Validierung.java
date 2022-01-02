
public class Validierung {
    private static final int KLEINSTE_NUMMER      = 1;
    private static final int GROESSTE_NUMMER      = 9999;

    /**
    * Der Konstruktor wurde als "private" geklariert, sodass
    * die Klasse nicht instantiiert werden kann.
    */
    private Validierung() {}
    
 
    public static void validiereName(String name){
        if (name == null) {
            throw new IllegalArgumentException("Name darf nicht null sein");
        }

        if (name.strip().isEmpty()) {
            throw new IllegalArgumentException("Name darf nicht leer sein");
        }

    }
   
    
    public static void validiereGroesse(int groesse) {
        if (groesse < KLEINSTE_NUMMER) {
            throw new IllegalArgumentException("Die Warteschlange darf nicht 0 oder kleiner sein.");
        }
    }

    
    
    public static void validiereNummer(int nummer) {
        if (nummer < KLEINSTE_NUMMER ||nummer > GROESSTE_NUMMER) {
            throw new IllegalArgumentException("Ungueltige Nummer. Die Nummer muss zwischen 1 und 9999 sein.");
        }
    }

}
