import java.io.*;
import java.util.Scanner;

/**
* Die Klasse:  LinkFilter.java
* Realisiert einen HTML-Dateien-Filter, der unter den
* Randbedingungen : - ein Hyperlink steht immer in einer Zeile
* ....<A .....> .......</A>
* - Alle HTML-Tags bestehen nur aus GROSSBUCHSTABEN
* eine Liste aller URL's und deren Beschreibung liefert.
*
* @version 1.0 Beta 2021
* @author  Wolfgang Pauly
*/

public class LinkFilter
{
    //------------------Konstanten----------------------------------
    private static final String LINK_BEGINN = "<a href=";
    private static final String GROESSER = ">";
    private static final String LINK_ENDE = "</a>";
    private static final String ZEILEN_BESCHREIBUNG = "^.*<a href=.*>.*</a>.*$";

   //--------- Eingabe Attribut --------------------------------
     private Scanner in;


   //------------------Konstruktoren-------------------------------
    /**
      * Standard-Konstruktor
      */
     public LinkFilter()
     {
       in = new Scanner( System.in );
     }


    /** run --> enthaelt die Pro-Logik des Filters
     */
    public void run()
    {
        String eineZeile, urlString, titelString;
        int hrefIndex, urlBeginn, urlEnde, titelBeginn, titelEnde,
	    zeilenAnzahl = 0, 
	    linkAnzahl = 0;

        System.out.println("\n\n");

        while( (eineZeile = MyInputFunctions.readlnString(in)) != null )
        {
	  zeilenAnzahl++;
          if ( eineZeile.matches( ZEILEN_BESCHREIBUNG ) )
          {
	    linkAnzahl++;
            if((hrefIndex = eineZeile.indexOf(LINK_BEGINN)) != -1)
            {
                urlBeginn = hrefIndex + 9;
                urlEnde = eineZeile.indexOf(GROESSER, urlBeginn) - 1;
                urlString = eineZeile.substring(urlBeginn, urlEnde);
                urlString = urlString.trim();

                titelBeginn = urlEnde + 2;
                titelEnde = eineZeile.indexOf(LINK_ENDE, titelBeginn);
                titelString = eineZeile.substring(titelBeginn, titelEnde);
                titelString = titelString.trim();

                System.out.println(String.format("%-40s %s, \tAnzahl Zeichen: %3d",titelString+":", urlString, urlString.length()));
            }
          }
        }
        System.out.println(String.format("\n%d Links wurden in %d Zeilen gefunden.\n\n",linkAnzahl,zeilenAnzahl));
    }

    /** main
     */
    public static void main(String[] args)
    {
        LinkFilter linkFilter = new LinkFilter();
        linkFilter.run();
    }
}
