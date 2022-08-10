import java.util.Scanner;

public class Gruesse {
    public static void main(String[] args) {
    	final int AKTUELLES_JAHR = 2021;
    	
        Scanner input = new Scanner(System.in);
        System.out.print("Ihr Vorname: ");
        String vorname = input.nextLine();
        System.out.print("Ihr Nachname: ");
        String nachname = input.nextLine();
        System.out.println("Ihr Geburtsjahr: ");
        int geburtsjahr = input.nextInt();
        int alter = AKTUELLES_JAHR - geburtsjahr;
        
        System.out.println("Sie heißen: " + nachname + ", " + vorname);
        System.out.println("Sie sind " + alter + " Jahre alt");
        
        input.close();
    }
}
