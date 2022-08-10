import java.io.*;
import java.util.Scanner;

/**
 *    ----> QueueDialog.java    --> Realisiert ein einfaches Dialogprogramm
 *                                um die StringQueue- bze PersonenQueue-Klasse
 *                                zu testen.
 *
 * @version     1.0 2022_01_18
 * @author      Wolfgang Pauly
 *
 */


public class QueueDialog
{
//------------------Konstanten----------------------------------
   private static final int QUEUE_INHALT_ANZEIGEN       = 10;
   private static final int QUEUE_ELEMENT_ANHAENGEN      = 11;
   private static final int QUEUE_ELEMENT_ENTFERNEN      = 12;
   private static final int QUEUE_INDEX_ELEMENT_ANZEIGEN = 13;

   private static final int STRING = 0;
   private static final int PERSON = 2;

   private static final int QUEUE_LEER = 30;
   private static final int QUEUE_VOLL = 31;

   private static final int ZEIGE_MOMENTANE_ANZAHL = 32;

   private static final int ENDE = 99;


   private static final char STRING_QUEUE    = 's';
   private static final char PERSON_QUEUE    = 'p';

   public static final int KEIN_OBJEKT_VORHANDEN = -1;


   //--------- Eingabe Attribut --------------------------------
   private Scanner in;

   //---------------- attribute --------------------
   private  Queue  eineQueue;


 /**
  *    Der Konstruktor
  */
  public QueueDialog( char wahl )
         throws Exception
  {
    if ( wahl == STRING_QUEUE )
      {
       eineQueue = new StringQueue (5);
       System.out.println ("\n\tEin StringQueue-Objekt wurde konstruiert !\n\n");
      }
    else
      {
       if ( wahl == PERSON_QUEUE )
         {
          eineQueue = new PersonQueue(5);
          System.out.println ("\n\tEin PersonQueue-Objekt wurde konstruiert !\n\n");
         }
       else
         {
          throw new Exception( "\n\nMan kann nur Objekt-(" + STRING_QUEUE +
                               ") oder Projektbestandteil-(" + PERSON_QUEUE +
                               ") -Arrays erzeugen !!!!!"
                             );
         }
      }

    in = new Scanner( System.in );
  }



 /**
  *    Die start-Methode
  *    
  */
  public void start()
  {
          int         wasTun;
          int         index;
          Object      helfer;
               

 while ( (wasTun = wasTun()) != ENDE )
   {
     try
       {
        switch ( wasTun )
          {
           case QUEUE_INHALT_ANZEIGEN : 
	              print( eineQueue );
                      break;
           case QUEUE_ELEMENT_ANHAENGEN : 
                      eineQueue.addLast( leseElement() );
                      break;
           case QUEUE_ELEMENT_ENTFERNEN : 
                      helfer = eineQueue.removeFirst();
                      System.out.println( "\t---> Das entfernte Queue-Element : " +
                                          helfer
                                        );
                      break;
           case QUEUE_INDEX_ELEMENT_ANZEIGEN : 
                      index = MyInputFunctions.readlnInt(in, "Geben eine Index ein, zu dem " + 
                                                             "das Queue-Element angezeigt werden soll : "
                                                        );
                      System.out.println( "\t---> Das " + index + "'te Queue-Element : " +
                                          eineQueue.get( index )
                                        );
                      break;
           case QUEUE_LEER : 
                      System.out.println( "\n\t\tDie aktuelle Queue ist LEER !" +
                                          "\t-->\tDiese Aussage ist : " +
                                          eineQueue.empty()
                                        );
                      break;
           case QUEUE_VOLL : 
                      System.out.println( "\n\t\tDie aktuelle Queue ist VOLL !" +
                                          "\t-->\tDiese Aussage ist : " +
                                          eineQueue.full()
                                        );
                      break;
           case ZEIGE_MOMENTANE_ANZAHL : 
                      System.out.println( "\n\t Die aktuelle Queue-Element-Anzahl : " +
                                          eineQueue.size()
                                        );
                      break;
           default  : 
                      System.out.println(  "\n Wohl vertippt !!!!! :-((  !!!!" );
                      break;
          }
       }
     catch ( RuntimeException re )
       {
        System.out.println( "\n\nRuntimeException :" +
                            "\n\nHier die Fehlermeldung : " + re +
                            "\n\nHier der Fehlerort : "
                          );
        re.printStackTrace();
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
   * leseElementArt -> Gibt Menue zur Elementart-Wahl aus und
   *                  liefert dieses zurueck.
   */
  private int leseElementArt()
  {
   int was = -1;

   // wir fragen was soll erzeugt werden ???
   while ( (was < STRING) | (was > PERSON) )
     {
       was = MyInputFunctions.readlnInt(in, "Welcher ElementArt wollen Sie aufnehmen ???\n" +
                                            "\tein  String  (" + STRING + ")\n" +
                                            "\teine Person  (" + PERSON + ")\n" +
                                            "waehle : "
                                       );
     }

   return  was;
  }


  /**
   * leseObjekt -> Liest nach Auswahl des Benutzers entweder 
   *               einen String, ein Projekt, ein Produkt oder eine Aufgabe
   *               ein und gibt eine Object-Referenz zurueck
   */
  private Object leseElement()
  {
    int was;
    
    // das neue Objekt
    Object neuesObjekt = null;

    String name, vorname;
    
   was = leseElementArt();

   if ( was == STRING )
     {
      neuesObjekt =  new String(  MyInputFunctions.readlnString(in, "\n\tGeben Sie " +
                                                                    "einen String " +
                                                                    " ein : "
                                                               )
                               );
     }
   else
     {    
      name = MyInputFunctions.readlnString(in, "\n\tGeben Sie den Personen-Namen ein : ");
      vorname = MyInputFunctions.readlnString(in, "\n\tGeben Sie den Personen-Vornamen ein : ");
   
      neuesObjekt =  new Person( name, vorname );
     }    
   return neuesObjekt;
  }


  /**
   * wasTun -> Zeigt die moeglichen Funktionen, die im HP
   *           aufgerufen werden koennen an und 
   *           liest Benutzerwunsch ein.
   */
  private int wasTun()
  {
   return ( MyInputFunctions.readlnInt(in, "\n\tWas wollen sie tun ????\n\n" +
                                           "\n\tanzeigen des aktuellen Queue-Inhalts  -> " +
                                           QUEUE_INHALT_ANZEIGEN +
                                           "\n\tElement an Queue anhaengen            -> " +
                                           QUEUE_ELEMENT_ANHAENGEN +
                                           "\n\tElement von der Queue entfernen       -> " +
                                           QUEUE_ELEMENT_ENTFERNEN +
                                           "\n\tdas i'te Element der Queue anzeigen   -> " +
                                           QUEUE_INDEX_ELEMENT_ANZEIGEN +
                                           "\n\tIst die Queue LEER ?                  -> " +
                                           QUEUE_LEER +
                                           "\n\tIst die Queue VOLL ?                  -> " +
                                           QUEUE_VOLL +
                                           "\n\tanzeigen der aktuellen Element-Anzahl -> " +
                                           ZEIGE_MOMENTANE_ANZAHL +
                                           "\n\tBearbeitung B E E N D E N             -> " +
                                           ENDE +
                                           "\n\n\tGib Aktion ein :"
                                      )
          );
  }



   /** die Methode print
    *     
    */
   public void print( Queue q) 
   {
     System.out.println( "Die Queue : " );
     System.out.println( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");

     for ( int index = 0; index < q.size(); index++)
        {
           System.out.print(q.get(index) + " - ");
        }

     System.out.println( "\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
   }

  /**
   *    Das Test-Programm
   *
   *    Erzeugt ein QueueDialog-Objekt
   *    und
   *    ruft dessen Start-Methode auf
   */
   public static void main ( String[] args )
   {
     QueueDialog test;


     try
       {
        test = new QueueDialog( MyInputFunctions.readlnChar(new Scanner( System.in ), 
                                                              "Waehle Array-Art : \n" +
                                                              "\tStringQueue  == " + STRING_QUEUE +
                                                              "\n" +
                                                              "\tPersonQueue == " + PERSON_QUEUE + 
                                                              "\n"  +
                                                              "\t gib : "
                                                         )
                            );
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
