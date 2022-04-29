
/**
 * Beschreiben Sie hier die Klasse GGT.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class GGTRechner {

    private int a;
    private int b;

  
   
    /**
     * Konstruktor für Objekte der Klasse GGT
     */
    private GGTRechner(String[] args) {

        instace.validiereHatGenauZweiArgumente(args);
        
        this.a = parseInt(args[0], "a");
        this.b = parseInt(args[1], "b");

    }

    public static void main(String[] args) {

        GGTRechner instace = new GGTRechner(args);

        return berechneGgT(instance.getA(), instance.getB());
    }

    public static int berechneGgT(int a, int b){

        if (a <= 0 || b <= 0) {
            throw new GGTError("A und B muessen natuerliche Zahlen sein");
        }

        return rekursiverEuklidischerAlgoritmus(a, b);
    }

    private rekursiverEuklidischerAlgoritmus(int a, int b) {

        if (b == 0) {
            return a;
        }

        return rekursiverEuklidischerAlgoritmus(b, a % b);
    }

    private void validiereHatGenauZweiArgumente(String[] string) {

        if (args.length != 2) {
            throw new GGTError("GGT Rechner muss genau 2 Zahlen als Argument erhalten");
        }

    }

    private int parseInt(String arg, String zahlName) {
        try {
            return Integer.parseInt(arg);

        } catch(NumberFormatException e) {
            throw GGTError(String.format("Die Zahl %s kann nicht in int umgewandelt werden", zahlName));
        }
    }

    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }
}
