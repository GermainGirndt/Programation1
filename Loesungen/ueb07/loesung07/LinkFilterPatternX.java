import java.io.*;
import java.util.Scanner;

/**
* Die Klasse:  LinkFilterPatternX.java
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

public class LinkFilterPatternX
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
     public LinkFilterPatternX()
     {
       in = new Scanner( System.in );                                                            
     }

    /** run --> enthaelt die Pro-Logik des Filters
     */
    public void run()
    {
        String eineZeile;
	int zeilenAnzahl = 0, linkAnzahl = 0;

	System.out.println("\n\n");

        while( (eineZeile = MyInputFunctions.readlnString(in)) != null )
          {
	    zeilenAnzahl++;
            if ( eineZeile.matches( ZEILEN_BESCHREIBUNG ) )
               {
	         linkAnzahl++;
                 // werfe alles hinter LINK_ENDE und vor LINK_BEGINN weg
                 eineZeile = (((eineZeile.split( LINK_ENDE ))[0]).split( LINK_BEGINN ))[1];
		 System.out.println(String.format("%-40s %s, \tAnzahl Zeichen: %3d",
		                                  (eineZeile.split( LINK_MITTE,2))[0]+":", 
						  (eineZeile.split( LINK_MITTE,2))[1], 
						  (eineZeile.split( LINK_MITTE,2))[1].length()
						 )
				   );
               }
          }
	  System.out.println(String.format("\n%d Links wurden in %d Zeilen gefunden.\n\n",
	                                   linkAnzahl,zeilenAnzahl
					  )
		            );
    }

    /** main
     */
    public static void main(String[] args)
    {
        LinkFilterPatternX linkFilterPatternX = new LinkFilterPatternX();
        linkFilterPatternX.run();
    }
}
