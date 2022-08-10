
/**
 * Allgemeine Oberklasse Projektbestandteil.
 * 
 * @author Folz
 * @version 2013
 *
 * von wpy um getBeschreibung ergaenzt
 */
public abstract class Projektbestandteil {
    public static String MSG_NAME = "Name darf nicht leer sein!";
    public static String MSG_PROJEKT = "Aufgabe muss einem Projekt zugeordnet sein!";
    protected String name;
    protected String beschreibung;
    protected Projekt projekt = null; // Uebergeordnetes Projekt
    
    public Projektbestandteil(String name, String beschreibung) {
        assert name != null && !name.isEmpty() : MSG_NAME;
        this.name = name;
        this.beschreibung = beschreibung;
    }
    
    public String getName() {
        return name;
    }
    
    public String getBeschreibung() {
        return beschreibung;
    }
    public void setProjekt(Projekt projekt) {
        assert projekt != null : MSG_PROJEKT;
        this.projekt = projekt;
    }    
    
    public String toString() {
        return String.format("%-10s\t%-20s", name, beschreibung);
    }
    
    public abstract double getKosten();

}
