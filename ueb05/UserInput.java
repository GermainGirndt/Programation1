 

import java.util.Scanner;

/**
* Die Klasse UserInput ist eine abstrakte Klasse zur Steuerung des User Standard Inputs
*
* @author Girndt & Krier
* @version 1.2
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
    * Die Methode zeigt eine Message an und fragt erwartet einein Integerinput von dem Nutzer
    * Außerdem sorgt die Methode dafür, dass der Scanner nicht gesperrt bleibt, indem sie "input.nextLine()" aufruft.
    * @param message ist die anzuzeigende Nachricht 
    * @return ist die von Nutzer eingegebene Integer 
    */
    public int getInt(String message) {
        System.out.print(message);
        int integer = input.nextInt();
        input.nextLine();
        return integer;
    }

    
     public double getDouble(String message) {
        System.out.print(message);
        double doub = input.nextDouble();
        input.nextLine();
        return doub;
    }
    
    /**
    * Die Methode zeigt eine Message an und fragt erwartet einein Stringinput von dem Nutzer
    * Außerdem sorgt die Methode dafür, dass der Scanner nicht gesperrt bleibt, indem sie "input.nextLine()" aufruft.
    * @param message ist die anzuzeigende Nachricht 
    * @return ist die von Nutzer eingegebene String 
    */
    public String getString(String message) {
        System.out.print(message);
        String string = input.nextLine();
        return string;
    }

    /**
    * Standardisierte nextLine Methode.
    * Dient als Schnittstelle mit dem Scanner Objekt
    */
    public void nextLine() {
        input.nextLine();
    }

    /**
    * Standardisierte next Methode.
    * Dient als Schnittstelle mit dem Scanner Objekt
    */
    public void next() {
        input.next();
    }
    
}
