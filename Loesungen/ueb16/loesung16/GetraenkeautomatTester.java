/**
 * Klasse GetraenkeautomatTester
 *
 * @author W. Pauly
 * @version -1.0 Beta
 */
 


public class GetraenkeautomatTester
{
    public void run() 
    {

        // so sollen die Getraenke erzeugt werden
	// fuer den Getraenkeautomat fuer AlkoholfreieGetraenke 
	// 
        Wasser trinkWasser1 = new Wasser("Stadtwerke", "Wasserhahn");
        Wasser trinkWasser2 = new Wasser("Coca-Cola", "BonAqua");
        Wasser mineralWasser1 = new Wasser("N\u00fcrgurg-Quelle", "Dreis");
        Wasser mineralWasser2 = new Wasser("Gerolstein-Quelle", "Gerolstein");
        SoftDrink softDrink1 = new SoftDrink("Coca-Cola", 40.0f);
        SoftDrink softDrink2 = new SoftDrink("Fanta", 35.0f);

	// und NICHT so 
        // AlkoholfreiesGetraenk trinkWasser1 = new Wasser("Stadtwerke", "Wasserhahn");
    
        Bier bier = new Bier(4.8f, "Karlsberg");
        Rotwein merlot = new Rotwein(13.8f, "Rothschild");

        Flasche<Wasser> flasche1 = new Flasche<>();
        flasche1.fuellen(trinkWasser1);
        Flasche<Wasser> flasche2 = new Flasche<>();
        flasche2.fuellen(trinkWasser2);
        Flasche<Wasser> flasche3 = new Flasche<>();
        flasche3.fuellen(mineralWasser1);
        Flasche<Wasser> flasche4 = new Flasche<>();
        flasche4.fuellen(mineralWasser2);
        Flasche<SoftDrink> flasche5 = new Flasche<>();
        flasche5.fuellen(softDrink1);
        Flasche<SoftDrink> flasche6 = new Flasche<>();
        flasche6.fuellen(softDrink2);


        Flasche<Bier> alkFlasche1 = new Flasche<>();
        alkFlasche1.fuellen(bier);
        Flasche<Rotwein> alkFlasche2 = new Flasche<>();
        alkFlasche2.fuellen(merlot);

        Flasche<AlkoholfreiesGetraenk> leereFlasche = new Flasche<>();

        System.out.println("\n\n");

        Getraenkeautomat<AlkoholfreiesGetraenk> alkFrei = new Getraenkeautomat<>(5);
        alkFrei.flascheEinlegen(flasche1);
        System.out.println("\tEingelegt: " + flasche1);
        alkFrei.flascheEinlegen(flasche2);
        System.out.println("\tEingelegt: " + flasche2);
        alkFrei.flascheEinlegen(flasche3);
        System.out.println("\tEingelegt: " + flasche3);
        alkFrei.flascheEinlegen(flasche4);
        System.out.println("\tEingelegt: " + flasche4);
        alkFrei.flascheEinlegen(flasche5);
        System.out.println("\tEingelegt: " + flasche5);
        System.out.println("\nDer Fuellstand des Getraenkeautomaten --> alkFrei : " + alkFrei + "\n\n");


        try 
    {
            alkFrei.flascheEinlegen(flasche6);
        }
        catch (Exception ex) 
    {
            System.err.println("\n\tFolgende Ausnahme ist aufgetreten : \n\t" +
                           ex + "\n\n"
                  );
        }
        System.out.println("Diese Flasche kann NICHT eingelegt werden : " + flasche6);
        System.out.println("\nDer Fuellstand des Getraenkeautomaten --> alkFrei : " + alkFrei + "\n\n");


        System.out.println("Ausgegebene Flasche : " +  alkFrei.flascheAusgeben() );
        System.out.println("\nDer Fuellstand des Getraenkeautomaten --> alkFrei : " + alkFrei + "\n\n");
        System.out.println("Ausgegebene Flasche : " +  alkFrei.flascheAusgeben() );
        System.out.println("\nDer Fuellstand des Getraenkeautomaten --> alkFrei : " + alkFrei + "\n\n");
        System.out.println("Ausgegebene Flasche : " +  alkFrei.flascheAusgeben() );
        System.out.println("\nDer Fuellstand des Getraenkeautomaten --> alkFrei : " + alkFrei + "\n\n");
        System.out.println("Ausgegebene Flasche : " +  alkFrei.flascheAusgeben() );
        System.out.println("\nDer Fuellstand des Getraenkeautomaten --> alkFrei : " + alkFrei + "\n\n");
        System.out.println("Ausgegebene Flasche : " +  alkFrei.flascheAusgeben() );
        System.out.println("\nDer Fuellstand des Getraenkeautomaten --> alkFrei : " + alkFrei + "\n\n");



        try 
    {
            System.out.println("Ausgegebene Flasche : " +  alkFrei.flascheAusgeben() );
        }
        catch (Exception ex) 
    {
            System.err.println("\n\tFolgende Ausnahme ist aufgetreten : \n\t" +
                           ex + "\n\n"
                  );
        }
        System.out.println("\nDer Fuellstand des Getraenkeautomaten --> alkFrei : " + alkFrei + "\n\n");

        /* das folgende akzeptiert der Compiler NICHT 
     * 
     * alkFrei.flascheEinlegen(bier);
     * alkFrei.flascheEinlegen(merlot);
     *
     */


        try 
    {
            System.out.println("\tVersuch eine leere Flasche einzulegen: " + leereFlasche);
            alkFrei.flascheEinlegen(leereFlasche);
        }
        catch (Exception ex) 
    {
            System.err.println("\n\tFolgende Ausnahme ist aufgetreten : \n\t" +
                           ex + "\n\n"
                  );
        }



        System.out.println("\nDer Fuellstand des Getraenkeautomaten --> alkFrei : " + alkFrei + "\n\n");
        System.out.println("\tE N D E !!!!!");
    }


    
    public static void main(String[] array) 
    {
        GetraenkeautomatTester tester = new GetraenkeautomatTester();
        try 
    {
            tester.run();
        }
        catch (Exception ex) 
    {
            System.err.println("\n\tFolgende Ausnahme ist aufgetreten : \n\t" +
                           ex + "\n\n"
                  );
        }
    }
}
