import java.io.*;
import java.util.Scanner;

/**
 *    ----> OueueTest.java    --> Realisiert ein einfaches Dialogprogramm
 *                                um die PersonenQueue-Klasse
 *                                zu testen.
 *
 * @version     1.0 2022-05-05
 * @author      Wolfgang Pauly
 *
 */


public class OueueTest
{
//------------------Konstanten----------------------------------
   private static final int QUEUE_MIT_INHALT_ERZEUGEN    =  1;
   private static final int QUEUE_INHALT_ANZEIGEN        = 10;
   private static final int QUEUE_ELEMENT_ANHAENGEN      = 11;
   private static final int QUEUE_ELEMENT_ENTFERNEN      = 12;
   private static final int QUEUE_INDEX_ELEMENT_ANZEIGEN = 13;
   private static final int QUEUE_ZEIGE_SMALLEST_VORNAME = 14;

   private static final int QUEUE_LEER = 30;
   private static final int QUEUE_VOLL = 31;

   private static final int ZEIGE_MOMENTANE_ANZAHL = 32;

   private static final int ENDE = 99;

   public static final int KEIN_OBJEKT_VORHANDEN = -1;


   public static final String[] NAME = { "Brach", "Leist", "Schneider", "Weber", "Adam", "Pauly" };
   public static final String[] VORNAME = { "Wolfgang", "Pia", "Maria", "Monika", "Nikolaus", "Johannes" };

   //--------- Eingabe Attribut --------------------------------
   private Scanner in;

   //---------------- attribute --------------------
   private  PersonQueue  pQueue;


 /**
  *    Der Konstruktor
  */
  public OueueTest()
         throws Exception
  {
    in = new Scanner( System.in );
    pQueue = new PersonQueue();
    System.out.println ("\n\tEin PersonQueue-Objekt wurde konstruiert !\n\n");
  }




 /**
  *    Die start-Methode
  *    
  */
  public void start()
  {
          int         wastun;
          int         index;
          Object      helfer;
               

 while ( (wastun = wasTun()) != ENDE )
   {
     try
       {
        switch ( wastun )
          {
           case QUEUE_MIT_INHALT_ERZEUGEN: 
	              for ( int lauf = 0; lauf < NAME.length; lauf ++ )
		         {
                           pQueue.addLast( new Person( NAME[lauf], VORNAME[lauf] ) );
			 }
                      break;
           case QUEUE_INHALT_ANZEIGEN : 
		      System.out.println( pQueue );  // Aufruf der neuen Methode toString() mit PersonIterator realisiert
                      break;
           case QUEUE_ELEMENT_ANHAENGEN : 
                      pQueue.addLast( leseElement() );
                      break;
           case QUEUE_ELEMENT_ENTFERNEN : 
                      helfer = pQueue.removeFirst();
                      System.out.println( "\t---> Das entfernte Queue-Element : " +
                                          helfer
                                        );
                      break;
           case QUEUE_INDEX_ELEMENT_ANZEIGEN : 
                      index = MyInputFunctions.readlnInt(in, "Geben eine Index ein, zu dem " + 
                                                             "das Queue-Element angezeigt werden soll : "
                                                        );
                      System.out.println( "\t---> Das " + index + "'te Queue-Element : " +
                                          pQueue.get( index )
                                        );
                      break;
	   case QUEUE_ZEIGE_SMALLEST_VORNAME :
	              System.out.println ( "\n\t der lexikalisch kleinste Vornamen in der Queue : " +
	                                   pQueue.smallest()
	                                 );  // Aufruf der neuen Methode smallest() mit PersonIterator realisiert
                      break;
           case QUEUE_LEER : 
                      System.out.println( "\n\t\tDie aktuelle Queue ist LEER !" +
                                          "\t-->\tDiese Aussage ist : " +
                                          pQueue.empty()
                                        );
                      break;
           case QUEUE_VOLL : 
                      System.out.println( "\n\t\tDie aktuelle Queue ist VOLL !" +
                                          "\t-->\tDiese Aussage ist : " +
                                          pQueue.full()
                                        );
                      break;
           case ZEIGE_MOMENTANE_ANZAHL : 
                      System.out.println( "\n\t Die aktuelle Queue-Element-Anzahl : " +
                                          pQueue.size()
                                        );
                      break;
           default  : 
                      System.out.println(  "\n Wohl vertippt !!!!! :-((  !!!!" );
                      break;
          }
       }

     catch ( PersonQueueException pqex )
       {
        System.out.println( "\n\nPersonQueueException :" +
                            "\n\nHier die Fehlermeldung : " + pqex +
                            "\n\nHier der Fehlerort : "
                          );
        pqex.printStackTrace();
       }
     catch ( ObjectQueueException oqex )
       {
        System.out.println( "\n\nObjectQueueException :" +
                            "\n\nHier die Fehlermeldung : " + oqex +
                            "\n\nHier der Fehlerort : "
                          );
        oqex.printStackTrace();
       }
     catch ( Exception e )
       {
        System.out.println( "\n\nFataler Fehler :" +
                            "\n\nHier die Fehlermeldung : " + e +
                            "\n\nHier der Fehlerort : "
                          );
        e.printStackTrace();
       }
   }
  }


  /**
   * leseObjekt -> Liest nach Auswahl des Benutzers entweder
   *               einen String, ein Projekt, ein Produkt oder eine Aufgabe
   *               ein und gibt eine Object-Referenz zurueck
   */
 private Person leseElement()
 {
    String name, vorname;
       
   name = MyInputFunctions.readlnString(in, "\n\tGeben Sie den Personen-Namen ein : ");
   vorname = MyInputFunctions.readlnString(in, "\n\tGeben Sie den Personen-Vornamen ein : ");
   return new Person( name, vorname );
 }


 


  /**
   * wasTun -> Zeigt die moeglichen Funktionen, die im HP
   *           aufgerufen werden koennen an und 
   *           liest Benutzerwunsch ein.
   */
  private int wasTun()
  {
   return ( MyInputFunctions.readlnInt(in, "\n\tWas wollen sie tun ????\n\n" +
                                           "\n\tQueue mit Startwerten füllen             -> " +
                                           QUEUE_MIT_INHALT_ERZEUGEN +
                                           "\n\tanzeigen des aktuellen Queue-Inhalts     -> " +
                                           QUEUE_INHALT_ANZEIGEN +
                                           "\n\tElement an Queue anhaengen               -> " +
                                           QUEUE_ELEMENT_ANHAENGEN +
                                           "\n\tElement von der Queue entfernen          -> " +
                                           QUEUE_ELEMENT_ENTFERNEN +
                                           "\n\tdas i'te Element der Queue anzeigen      -> " +
                                           QUEUE_INDEX_ELEMENT_ANZEIGEN +
                                           "\n\tdas Element mit dem lexikal. kleinsten Vornamen -> " +
                                           QUEUE_ZEIGE_SMALLEST_VORNAME +
                                           "\n\tIst die Queue LEER ?                     -> " +
                                           QUEUE_LEER +
                                           "\n\tIst die Queue VOLL ?                     -> " +
                                           QUEUE_VOLL +
                                           "\n\tanzeigen der aktuellen Element-Anzahl    -> " +
                                           ZEIGE_MOMENTANE_ANZAHL +
                                           "\n\tBearbeitung B E E N D E N                -> " +
                                           ENDE +
                                           "\n\n\tGib Aktion ein :"
                                      )
          );
  }


  /**
   *    Das Test-Programm
   *
   *    Erzeugt ein OueueTest-Objekt
   *    und
   *    ruft dessen Start-Methode auf
   */
   public static void main ( String[] args )
   {
     OueueTest test;


     try
       {
        test = new OueueTest();
        test.start();
       }
     catch ( Exception e )
       {
        System.out.println( "\n\nFataler Fehler :" +
                            "\n\nHier die Fehlermeldung : " + e +
                            "\n\nHier der Fehlerort : "
                          );
        e.printStackTrace();
        System.exit( 1 );
       }
     System.exit( 0 );
   }
}
