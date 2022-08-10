import java.io.*;
import java.util.Scanner;

/**
 *   --> MDVL.java --> Realisiert ein einfaches Dialogprogramm,
 *                     um die doppelt verkettete Liste zu testen.
 *
 * @version     1.0
 * @author      Achim Pick
 */


public class MDVL
{
  //----------------- Konstanten ---------------------------------

  private static final int  INHALT_ANZEIGEN               = 11;
  private static final int  INHALT_ANZEIGEN_MIT_ITERATOR  = 12;
  private static final int  INHALT_ANZEIGEN_MIT_LIST_ITER = 13;
  private static final int  INDEX_ELEMENT_ANZEIGEN        = 14;
  private static final int  ELEMENT_SUCHEN                = 15;
  private static final int  INDEX_ELEMENT_SUCHEN          = 16;
  private static final int  ELEMENT_ANHAENGEN             = 21;
  private static final int  INDEX_ELEMENT_EINFUEGEN       = 22;
  private static final int  COLLECTION_ELEMENT_EINFUEGEN  = 23;
  private static final int  ELEMENT_ENTFERNEN             = 31;
  private static final int  INDEX_ELEMENT_ENTFERNEN       = 32;
  private static final int  ALLES_ENTFERNEN               = 33;
  private static final int  INDEX_ELEMENT_ERSETZEN        = 41;
  private static final int  LISTE_ALS_ARRAY               = 51;
  private static final int  LISTE_ALS_ARRAY_X             = 52;
  private static final int  FRAGE_LEER                    = 81;
  private static final int  FRAGE_ANZAHL                  = 82;
  private static final int  FRAGE_HASHCODE                = 83;
  private static final int  ENDE                          = 99;

  private static final int  STRING                        =  0;
  private static final int  PERSON                        =  2;

  private static final char STRING_MDVL                   = 's';
  private static final char PERSON_MDVL                   = 'p';

  public  static final int  KEIN_OBJEKT_VORHANDEN         = -1;

  //--------- Eingabe Attribut -----------------------------------

  private Scanner in;

  //---------------- Attribute -----------------------------------

  private  DoppeltVerketteteListe  eineListe;


  /**   Der Konstruktor  */

  public MDVL( char wahl )
         throws Exception
  {

    if ( wahl == STRING_MDVL )
    {
       eineListe = new DoppeltVerketteteListe<String> ();

       eineListe.add( "1aaaa" );
       eineListe.add( "2bbbb" );
       eineListe.add( "3cccc" );
       eineListe.add( "1AAAA" );
       eineListe.add( "2BBBB" );
       eineListe.add( "3CCCC" );

       System.out.println ("\n\tEin StringListe-Objekt wurde konstruiert !\n\t und teilweise gefuellt !!\n");
    }
    else
    {
       if ( wahl == PERSON_MDVL )
       {
          eineListe = new DoppeltVerketteteListe<Person> ();

          eineListe.add( new Person("Pauly", "Wolfgang" ) );
          eineListe.add( new Person("Pick", "Achim" ) );
          eineListe.add( new Person("Meyer", "Margit" ) );
          eineListe.add( new Person("Olbertz", "Christopher" ) );
          eineListe.add( new Person("Miede", "Andre" ) );
          eineListe.add( new Person("Messner", "Michael" ) );

          System.out.println ("\n\tEin PersonListe-Objekt wurde konstruiert !\n\t und teilweise gefuellt !!\n\n");
       }
       else
       {
          throw new Exception( "\n\nMan kann nur Objekt-("   + STRING_MDVL +
                               ") oder Projektbestandteil-(" + PERSON_MDVL +
                               ") -Listen erzeugen !!!"                       );
       }
    }
    in = new Scanner( System.in );
  }


 /**   Die start-Methode   */

  public void start()
  {
    int                    wastun;
    int                    index;
    String                 element;
    String[]               eleArr;
    DoppeltVerketteteListe<String>  eineCollection;

    while ( (wastun = wasTun()) != ENDE )
    {
      try
      {
        switch ( wastun )
        {
           case INHALT_ANZEIGEN : 
                      System.out.println();
                      System.out.println( "Die Liste  v = vorwaerts, ^ rueckwaerts  ________\n");
                      System.out.print  ( eineListe ); 
                      System.out.println( "_________________________________________________");
                      break;

           case INHALT_ANZEIGEN_MIT_ITERATOR : 
                      System.out.println();
                      System.out.println( "Die Liste _______________________________________\n");
                      System.out.print  ( eineListe.toStringIterator() ); 
                      System.out.println( "_________________________________________________");
                      break;

           case INHALT_ANZEIGEN_MIT_LIST_ITER : 
                      System.out.println();
                      System.out.println( "Die Liste _______________________________________\n");
                      System.out.print  ( eineListe.toStringListIterator() ); 
                      System.out.println( "_________________________________________________");
                      break;

           case INDEX_ELEMENT_ANZEIGEN : 
                      index = MyInputFunctions.readlnInt( in,
                                "Gib einen Index ein, dessen Element angezeigt werden soll: " );
                      System.out.println( "\n--> " + index + "'tes Element: " + eineListe.get( index ) );
                      break;

           case ELEMENT_SUCHEN : 
                      element = leseString();
                      String antwortSuche = eineListe.contains( element ) ? " " : " nicht " ;
                      System.out.println( "\n--> Element >" + element + "< ist" + antwortSuche + "enthalten !!!" );
                      break;

           case INDEX_ELEMENT_SUCHEN : 
                      element = leseString();
                      System.out.print( "\n--> Element >" + element + "< " );
                      index = eineListe.indexOf( element ) ;
                      if ( index == -1 )
                          System.out.println( "ist nicht enthalten !!!" );
                      else
                          System.out.println( "hat den Index " + index + " !!!" );
                      break;

           case ELEMENT_ANHAENGEN : 
                      eineListe.add( leseString() );
                      break;

           case INDEX_ELEMENT_EINFUEGEN : 
                      index = MyInputFunctions.readlnInt( in,
                                "Gib einen Index ein, an dessen Stelle das Element eingefuegt werden soll: " );
                      eineListe.add( index, leseString() );
                      break;

           case COLLECTION_ELEMENT_EINFUEGEN : 
                      eineCollection = new DoppeltVerketteteListe<String> ();
                      eineCollection.add( "Eins" );
                      eineCollection.add( "zwei" );
                      eineCollection.add( "Drei" );
                      eineCollection.add( "Vier" );
                      eineListe.addAll( eineCollection );
                      eineCollection = new DoppeltVerketteteListe<String> ();
                      break;

           case INDEX_ELEMENT_ERSETZEN : 
                      index = MyInputFunctions.readlnInt( in,
                                "Gib einen Index ein, an dessen Stelle das Element ersetzt werden soll: " );
                      eineListe.set( index, leseString() );
                      break;

           case ELEMENT_ENTFERNEN : 
                      element = leseString();
                      String antwort = eineListe.remove( element ) ? " " : " nicht " ;
                      System.out.println( "\n--> Element >" + element + "< ist" + antwort + "geloescht !!!" );
                      break;

           case INDEX_ELEMENT_ENTFERNEN : 
                      index = MyInputFunctions.readlnInt( in,
                                "Gib einen Index ein, dessen Element entfernt werden soll: " );
                      System.out.println( "\n--> Entferntes Element: " + eineListe.remove( index ) );
                      break;

           case ALLES_ENTFERNEN : 
                      eineListe.clear();
                      System.out.println( "\n--> Liste vollstaendig geloescht !" );
                      break;

           case LISTE_ALS_ARRAY : 
                      eleArr = new String[ 2 ];
                      eineListe.toArray( eleArr );
                      System.out.println( "--> Liste als Array" );
                      for ( index = 0 ;  index < eleArr.length ;  index ++ )
                          System.out.println( "  [" + index + "]  " + eleArr[index] );
                      break;

           case LISTE_ALS_ARRAY_X : 
                      eleArr = new String[ 0 ];
                      eineListe.toArray( eleArr );
                      System.out.println( "--> Liste als Array" );
                      for ( index = 0 ;  index < eleArr.length ;  index ++ )
                          System.out.println( "  [" + index + "]  " + eleArr[index] );
                      break;

           case FRAGE_LEER : 
                      String antwortLeer = eineListe.isEmpty() ? "Ja" : "Nein" ;
                      System.out.println( "\nIst die aktuelle Liste LEER ?" + "\t" + antwortLeer );
                      break;

           case FRAGE_ANZAHL : 
                      System.out.println( "\nAktuelle Anzahl an Elementen der Liste: " + eineListe.size() );
                      break;

           case FRAGE_HASHCODE : 
                      System.out.println( "\nAktueller Hash-Code der Liste: " + eineListe.hashCode() );
                      break;

           default  : 
                      System.out.println(  "\n  Wohl vertippt !!! :-((  !!!" );
                      break;
        }
      }
      catch ( UnsupportedOperationException uoe )
      {
        System.out.println( "\n " + uoe );
      }
      catch ( RuntimeException re )
      {
        System.out.println( "\n\nRuntimeException:" +
                            "\n  Hier die Fehlermeldung: " + re +
                            "\n  Hier der Fehlerort: "            );
        System.out.print  ( "    " );
        re.printStackTrace();
        System.out.println();
      }
      catch ( Exception e )
      {
        System.out.println( "\n\nFataler Fehler:" +
                            "\n  Hier die Fehlermeldung: " + e +
                            "\n  Hier der Fehlerort: "            );
        System.out.print  ( "    " );
        e.printStackTrace ();
        System.out.println();
      }
    }
  }



  /**   leseElementArt -> Gibt Menue zur Elementart-Wahl aus und liefert die Art zurueck.
   *
   *    @return  Art des Listen-Elements
   */

  private int leseElementArt()
  {
    int was = -1;

    // wir fragen was soll erzeugt werden ???
    while ( (was < STRING) | (was > PERSON) )
   
       was = MyInputFunctions.readlnInt( in, "Welche ElementArt wollen Sie aufnehmen ???\n" +
                                            "\teinen String (" + STRING + ")\n" +
                                            "\teine  Person (" + PERSON + ")\n" +
                                            "waehle: "                                        );

    return  was;
  }


  /**   leseString -> Liest nach Auswahl des Benutzers einen String und gibt eine Referenz zurueck
   *
   *    @return  Referenz auf eingegebenen String
   */
  private String leseString()
  {
    return new String( MyInputFunctions.readlnString( in, "\n\tGeben Sie einen String ein: " ) );
  }


  /**   leseObjekt -> Liest nach Auswahl des Benutzers entweder einen String
   *                  oder eine Person ein und gibt eine Object-Referenz zurueck
   *
   *    @return  Referenz auf eingegebenes Object
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
      neuesObjekt = new String( MyInputFunctions.readlnString( in, "\n\tGeben Sie einen String ein: " ) );
    }
    else
    {    
      name    = MyInputFunctions.readlnString(in, "\n\tGeben Sie den Namen ein:    " );
      vorname = MyInputFunctions.readlnString(in, "\n\tGeben Sie den Vornamen ein: " );
   
      neuesObjekt = new Person( name, vorname );
    }    
    return neuesObjekt;
  }


  /**   wasTun -> Zeigt die moeglichen Funktionen, die im HP aufgerufen werden koennen,
   *              an und liest Benutzerwunsch ein.
   *
   *    @return  Benutzerwunsch
   */
  private int wasTun()
  {
   return ( MyInputFunctions.readlnInt( in,
     "\n\tInhalt anzeigen                       -> " + INHALT_ANZEIGEN +
     "\n\tInhalt anzeigen mit Iterator          -> " + INHALT_ANZEIGEN_MIT_ITERATOR +
     "\n\tInhalt anzeigen mit ListIterator      -> " + INHALT_ANZEIGEN_MIT_LIST_ITER +
     "\n\tElement an i'ter Stelle anzeigen      -> " + INDEX_ELEMENT_ANZEIGEN +
     "\n\tElement suchen                        -> " + ELEMENT_SUCHEN +
     "\n\tStelle des Elements suchen            -> " + INDEX_ELEMENT_SUCHEN +
     "\n\tElement an Liste anhaengen            -> " + ELEMENT_ANHAENGEN +
     "\n\tElement an i'ter Stelle einfuegen     -> " + INDEX_ELEMENT_EINFUEGEN +
     "\n\tCollection von Elementen anhaengen    -> " + COLLECTION_ELEMENT_EINFUEGEN +
     "\n\tElement aus Liste entfernen           -> " + ELEMENT_ENTFERNEN +
     "\n\tElement an i'ter Stelle entfernen     -> " + INDEX_ELEMENT_ENTFERNEN +
     "\n\tListe vollstaendig leeren             -> " + ALLES_ENTFERNEN +
     "\n\tElement an i'ter Stelle ersetzen      -> " + INDEX_ELEMENT_ERSETZEN +
     "\n\tListe als Array ausgeben              -> " + LISTE_ALS_ARRAY +
     "\n\tListe als Array ausgeben Test         -> " + LISTE_ALS_ARRAY_X +
     "\n\tIst die Liste LEER ?                  -> " + FRAGE_LEER +
     "\n\tAnzeigen der aktuellen Element-Anzahl -> " + FRAGE_ANZAHL +
     "\n\tAnzeigen des Hash-Codes               -> " + FRAGE_HASHCODE +
     "\n\tBearbeitung B E E N D E N             -> " + ENDE +
     "\n" +
     "\n\t\t\t\t      gib ein => "
   ) );
  }


  /**   Das Test-Programm
   *
   *    erzeugt ein MDVL-Objekt
   *  und
   *    ruft dessen Start-Methode auf
   */
  public static void main ( String[] args )
  {
    MDVL test;

    try
    {
      test = new MDVL( MyInputFunctions.readlnChar( new Scanner( System.in ), 
                                                    "Waehle Array-Art : \n" +
                                                    "\tStringListe == " + STRING_MDVL +
                                                    "\n" +
                                                    "\tPersonListe == " + PERSON_MDVL + 
                                                    "\n"  +
                                                    "\t gib : "
                                                  )                           
		     );

      test.start();
    }
    catch ( Exception e )
    {
      System.out.println( "\n\nFataler Fehler:" +
                          "\n  Hier die Fehlermeldung: " + e +
                          "\n  Hier der Fehlerort: "           );
      System.out.print  ( "    " );
      e.printStackTrace ();
      System.out.println();
      System.exit       ( 1 );
    }
    System.exit( 0 );
  }
}
