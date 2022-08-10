
/**
 * Die Klasse ReservierungsTester realisiert
 +            eine minimale TestKlasse fuer ein Reservierungs-System
 *
 * @author Wolfgang Pauly
 * @version -1.0 beta 2022-04-11
 */




public class ReservierungsTester
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int x;

    /**
     * Konstruktor für Objekte der Klasse ReservierungsTester
     */
    public ReservierungsTester()
    {
    }

   /**
    * run --> veranlasst einen einfachen Testlauf
    *         fuer das Reservierungs-system
    *
    */
   public void run()
          throws UhrzeitException, RaumException, PersonException, MitarbeiterException
   {

     Mitarbeiter m1 = new Mitarbeiter ( "Max", "Mustermann", "max@htwsaar.de" );
     Mitarbeiter m2 = new Mitarbeiter ( "John", "Doe", "john@htwsaar.de" );

     Raum r1 = new Raum( 18, 0, 1);
     Raum r2 = new Raum(  2, 1, 9);
     Raum r3 = new Raum(  2, 1, 10);


     m1.reserviere(r1, new Uhrzeit(12, 30), new Uhrzeit(14, 30), "VOOP");
     m1.reserviere(r2, new Uhrzeit(14, 30), new Uhrzeit(16, 30), "WebTech");
     m2.reserviere(r2, new Uhrzeit(12, 30), new Uhrzeit(13, 30), "Prog II");
     m2.reserviere(r3, new Uhrzeit( 9, 30), new Uhrzeit(11, 30), "ITM");


     System.out.println(r1);
     System.out.println(r2);
     System.out.println(r3);

   }


   /**
    *  main
    */
   public static void main( String[] args )
   {
    ReservierungsTester tester = new ReservierungsTester();
    try {
          tester.run();
        }
    catch ( Exception ex )
        {
         System.err.println("Folgende Ausnahme ist aufgetreten : \n\t" +
                            ex + "\n\n"
                           );
        }
   }

}
