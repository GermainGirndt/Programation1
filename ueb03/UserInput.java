
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

    /**
    * Bedient den StandardInput/Output, um eine Eingabe (Integer) von dem Benutzer zu fordern
    * @param message die angezeigt werden soll
    */
    public int getInt(String message) {
        System.out.print(message);
        int integer = input.nextInt();
        input.nextLine();
        return integer;
    }
    
    /**
    * Bedient den StandardInput/Output, um eine Eingabe (Long) von dem Benutzer zu fordern
    * @param message die angezeigt werden soll
    */
    public  long getLong(String message) {
        System.out.print(message);
        long longnumber = input.nextLong();
        input.nextLine();
        return longnumber;
    }

    /**
    * Bedient den StandardInput/Output, um eine Eingabe (Double) von dem Benutzer zu fordern
    * @param message die angezeigt werden soll
    */
    public  double getDouble(String message) {
        System.out.print(message);
        double doublenumber = input.nextDouble();
        input.nextLine();
        return doublenumber;
    }


    /**
    * Bedient den StandardInput/Output, um eine Eingabe (String) von dem Benutzer zu fordern
    * @param message die angezeigt werden soll
    */
    public String getString(String message) {
        System.out.print(message);
        String string = input.nextLine();
        return string;
    }

    /**
    * Ruft die next methode von dem Input auf.
    */
    public void next() {
        input.next();
    }

    /**
    * Ruft die nextLine methode von dem Input auf.
    */
    public void nextLine() {
        input.nextLine();
    }
}