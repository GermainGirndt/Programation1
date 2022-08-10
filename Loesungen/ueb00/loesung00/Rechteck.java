import java.util.Scanner;

public class Rechteck {
    public static void main(String[] args) {
    	int seiteA = 0;
        int seiteB = 0;
        
        Scanner input = new Scanner(System.in);
        System.out.print("Laenge der Seite A: ");
        seiteA = input.nextInt();
        System.out.print("Laenge der Seite B: ");
        seiteB = input.nextInt();
        
        int flaecheninhalt = seiteA * seiteB;
        int umfang = 2 * seiteA + 2 * seiteB;
        
        System.out.println("Das Rechteck hat die folgenden Seiten:");
        System.out.println("A = " + seiteA + " cm ");
        System.out.println("B = " + seiteB + " cm ");
        System.out.println("Flaecheninhalt A = " + flaecheninhalt + " cm^2");
        System.out.println("Umfang U = " + umfang + " cm");
        
        input.close();
    }
}