
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