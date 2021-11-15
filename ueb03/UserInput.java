
import java.util.Scanner;

/**
 * Die Klasse UserInput enthaelt Methoden zum Einlesen von Zahlen und Zeichenketten
 * 
 * @author Girndt & Krier
 * @version 1.0
 */

public class UserInput {

    private Scanner input;
    
    /**
    * Konstruktor
    */
    public UserInput() {
        input = new Scanner(System.in);
    }

    public int getInt(String message) {
        System.out.print(message);
        int integer = input.nextInt();
        input.nextLine();
        return integer;
    }
    
    public  long getLong(String message) {
        System.out.print(message);
        long longnumber = input.nextLong();
        input.nextLine();
        return longnumber;
    }

    public  double getDouble(String message) {
        System.out.print(message);
        double doublenumber = input.nextDouble();
        input.nextLine();
        return doublenumber;
    }


    public String getString(String message) {
        System.out.print(message);
        String string = input.nextLine();
        return string;
    }

    public void next() {
        input.next();
    }
    
    public void nextLine() {
        input.nextLine();
    }
}