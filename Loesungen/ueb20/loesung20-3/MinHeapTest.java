import java.io.*;
import java.util.*;


/**
 *    ----> MinHeapTest.java    --> Realisiert ein einfaches Dialogprogramm
 *                                  um die MinHeap-Klasse
 *                                  zu testen.
 *
 * @version     1.0 06.06.2022
 * @author      Wolfgang Pauly
 *
 */


 
public class MinHeapTest
{
//------------------Konstanten----------------------------------
   private static final int MINHEAP_ERZEUGEN               = 10;
   private static final int MINHEAP_INHALT_ANZEIGEN        = 11;
   private static final int MINHEAP_ELEMENT_OFFER          = 12;
   private static final int MINHEAP_ELEMENT_POLL           = 13;
   private static final int MINHEAP_ELEMENT_PEEK           = 14;
   private static final int MINHEAP_SIZE                   = 20;
   private static final int MINHEAP_ISEMPTY                = 21;
   private static final int MINHEAP_CLEAR                  = 22;
   private static final int ENDE                           = 99;

   public static final int KEIN_OBJEKT_VORHANDEN = -1;


   public static final int HEAP_SIZE = 15;

   //--------- Eingabe Attribut --------------------------------
   private Scanner in;


   //---------------- attribute --------------------
   private  MinHeap<Integer>  meinHeap;

 /**
  *    Der Konstruktor
  */
  public MinHeapTest()
         throws Exception
  {
   in = new Scanner( System.in );
   meinHeap = new MinHeap<Integer>(Integer.class, HEAP_SIZE );

   System.out.println ("\n\tEin MinHeap<Integer> Objekt mit der Kapazitaet 15 wurde konstruiert !\n\n");
  }



 /**
  *    Die start-Methode
  *    
  */
  public void start()
  {
          int         wastun;
          int         index;
               

 while ( (wastun = wasTun()) != ENDE )
   {
     Random zufall = new Random();
     int eineZahl, anzahl; 
     Integer rZahl;
     LinkedList<Integer> lInteger;

     try
       {
        switch ( wastun )
          {
           case MINHEAP_ERZEUGEN :
                       for ( int i=0; i < HEAP_SIZE -5 ; i++)
                          {
                            meinHeap.offer( Integer.valueOf( zufall.nextInt(100) ) );
                          }
                       break;
           case MINHEAP_INHALT_ANZEIGEN :              
                       System.out.println( meinHeap );
                       System.out.println( meinHeap.toStringIter() );
                       break;
           case MINHEAP_ELEMENT_OFFER :
                       eineZahl = MyInputFunctions.readlnInt(in, 
                                                       "Bitte eine Integerzahl eingeben : ");
                       if ( meinHeap.offer( Integer.valueOf( eineZahl ) ) )
                         {
                          System.out.println( "\n\t die Zahl : " + eineZahl + 
                                              " wurde im MinHeap aufgenommen "
                                            );
                         }
                       else
                         {
                          System.out.println( "\n\t die Zahl : " + eineZahl + 
                                              " konnte in den MinHeap NICHT aufgenommen werden"
                                            );
                         }
                       break;
           case MINHEAP_ELEMENT_POLL :
                       rZahl = meinHeap.poll();
                       
                       System.out.println( "\n\t die Zahl : " + rZahl + 
                                           " wurde vom MinHeap genommen "
                                         );
                       break;
           case MINHEAP_ELEMENT_PEEK :
                       System.out.println( "\n\t die Zahl : " + meinHeap.peek() +
                                           " steht an der Spitze des MinHeaps "
                                         ); 
                       break;
           case MINHEAP_SIZE :
                       System.out.println( "\n\t der MinHeap enthaelt " +
                                           + meinHeap.size() + " Elemente "
                                         );
                       break;
           case MINHEAP_ISEMPTY :
                       System.out.println( "\n\t der MinHeap ist LEER --> " +
                                           meinHeap.isEmpty()
                                         );
                       
                       break;
           case MINHEAP_CLEAR :
                       meinHeap.clear();
                       System.out.println( "\n\t der MinHeap wurde geloescht !!!"); 
                       break;
           case ENDE :
                       System.out.println( "\n\t TEST BEENDET !!!!");
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
   * wasTun -> Zeigt die moeglichen Funktionen, die im HP
   *           aufgerufen werden koennen an und 
   *           liest Benutzerwunsch ein.
   */
  private int wasTun()
  {
   return ( MyInputFunctions.readlnInt(in, 
                  "\n\tWas wollen sie tun ????\n\n" +
                  "\n\tMinHeap mit Integer-Zufallswerten erzeugen -> " +
                  MINHEAP_ERZEUGEN           +
                  "\n\tMinHeap Inhalt Anzeigen                    -> " +
                  MINHEAP_INHALT_ANZEIGEN    +
                  "\n\t Ein Element in MinHeap aufnehmen          -> " +
                  MINHEAP_ELEMENT_OFFER      +
                  "\n\t Hoechstes Element von MinHeap nehmen      -> " +
                  MINHEAP_ELEMENT_POLL     +
                  "\n\t Hoechstes Element in MinHeap zeigen       -> " +
                  MINHEAP_ELEMENT_PEEK       +
                  "\n\t Anzahl der Elemente im MinHeap            -> " +
                  MINHEAP_SIZE               +
                  "\n\t ist MinHeap L E E R ?                     -> " +
                  MINHEAP_ISEMPTY            +
                  "\n\t MinHeap L O E S C H E N                   -> " +
                  MINHEAP_CLEAR              +
                  "\n\t Test-Programm B E E N D E N               -> " +
                  ENDE                       +
                  "\n\n\tGib Aktion ein :"
                  )
          );
  }
 

  /**
   *    Das Test-Programm
   *
   *    Erzeugt ein MinHeapTest-Objekt
   *    und
   *    ruft dessen Start-Methode auf
   */
   public static void main ( String[] args )
   {
     MinHeapTest test;
     try
       {
        test = new MinHeapTest();
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
