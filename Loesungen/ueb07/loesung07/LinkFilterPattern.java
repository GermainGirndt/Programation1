import java.io.*;
import java.util.Scanner;

/**
* Die Klasse:  LinkFilterPattern.java
* Realisiert einen HTML-Dateien-Filter, der unter den
* Randbedingungen : - ein Hyperlink steht immer in einer Zeile
* ....<a href=.....> .......</a>
*     |            |        |
* LINK-BEGINN      -MITTE   -ENDE
* - Alle HTML-Tags bestehen nur aus GROSSBUCHSTABEN
* eine Liste aller URL's und deren Beschreibung liefert.
*
* @version 1.0 Beta 2021
* @author  Wolfgang Pauly
*/

public class LinkFilterPattern
{
    //------------------Konstanten----------------------------------
    private static final String LINK_ENDE           = "</a>";
    private static final String LINK_BEGINN         = ".*<a href=";
    private static final String LINK_MITTE          = ">";
    private static final String ZEILEN_BESCHREIBUNG = "^.*<a href=.*>.*</a>.*$";

   //--------- Eingabe Attribut --------------------------------
     private Scanner in;


   //------------------Konstruktoren-------------------------------
    /**
      * Standard-Konstruktor 
      */
     public LinkFilterPattern()
     {
       in = new Scanner( System.in );                                                            
     }



    /** run --> enthaelt die Pro-Logik des Filters
     */
    public void run()
    {
        String eineZeile, urlString, titelString;
        int zeilenAnzahl = 0, linkAnzahl = 0;

        System.out.println("\n\n");

        while( (eineZeile = MyInputFunctions.readlnString(in)) != null )
          {
	    zeilenAnzahl++;
            if ( eineZeile.matches( ZEILEN_BESCHREIBUNG ) )
               {
	         linkAnzahl++;
                 // werfe alles hinter LINK_ENDE == "</A>" weg
                 eineZeile = (eineZeile.split( LINK_ENDE ))[0];
                 // werfe alles vor    LINK_BEGINN == "<A HREF=" weg
                 eineZeile = (eineZeile.split( LINK_BEGINN ))[1];
                 // speichere alles bis LINK_MITTE == ">" als URL
                 urlString = (eineZeile.split( LINK_MITTE, 2 ))[0];
                 // speichere alles nach LINK_MITTE == ">" als TITEL
                 titelString = (eineZeile.split( LINK_MITTE, 2 ))[1];
                
		 System.out.println(String.format("%-40s %s, \tAnzahl Zeichen: %3d",titelString+":", urlString, urlString.length(    )));
               }
          }
	  System.out.println(String.format("\n%d Links wurden in %d Zeilen gefunden.\n\n",linkAnzahl,zeilenAnzahl));
    }

    /** main
     */
    public static void main(String[] args)
    {
        LinkFilterPattern linkFilterPattern = new LinkFilterPattern();
        linkFilterPattern.run();
    }
}
