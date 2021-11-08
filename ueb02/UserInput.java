 

import java.util.Scanner;

public class UserInput {

    private Scanner input;
    
    public UserInput() {
        input = new Scanner(System.in);
    }

    public int getInt(String message) {
        System.out.print(message);
        int integer = input.nextInt();
        input.nextLine();
        return integer;
    }

    public void nextLine() {
        input.nextLine();
    }

    public String getString(String message) {
        System.out.print(message);
        String string = input.nextLine();
        return string;
    }

    public void next() {
        input.next();
    }
    
}
