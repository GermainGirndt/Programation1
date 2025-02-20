/**
 *   Einfache Bestimmung der Lines Of Code von Java-Source-Dateien 
 * 
 *   @author W. Pauly
 *   @version 2022
 */

import java.io.*;

public class LOCAuswertung  
{
    private String[] dateiListe;  // Stringliste der Uebergabeparameter == Datei-Liste
    private int anzDateien;       // Anzahl-Dateien-Zaehler
    private int anzZeilenGesamt;  // Gesamt-LOC-Zaehler

    /**  Auswertung fuer eine Liste von Dateien konstruieren
     *
     *   @param dateiListe hier wird args uebergeben
     */
    public LOCAuswertung( String[] dateiListe ) 
    {
        // Keine Ueberpruefung auf null erforderlich, da schon von main getestet !!!
        this.dateiListe = dateiListe;
	anzDateien      = anzZeilenGesamt = 0;
    }

    /**  Eigentliches Anstarten des Ablaufs:
     *     in einer Hauptschleife werden die Dateien durchlaufen.
     */
    public void start() 
    {
        System.out.println( "Auswertung Lines Of Code (LOC)" );

        try 
        {
            for ( int i = 0; i < dateiListe.length; i++ ) 
            {
                try 
                {
                    bearbeiteDatei( dateiListe[i] );
                } 
                catch ( DateiKeineNormaleDateiException denEX )
                {
                    System.out.println( denEX );
                } 
                catch ( DateiNichtLesbarException dnlEX )
                {
                    System.out.println( dnlEX );
                } 

                // Abfangen noetig, da evtl. auftretende Datei-Lese-Fehler
                // eine IOException ausloesen und damit der Programmlauf
                // beendet wuerde
                catch ( IOException ioEX )
                {
                    System.out.println( ioEX );
                } 
            }
        } 
        finally 
        {
            System.out.println( "\nGesamt:\n" + anzDateien +" Dateien\t"  
                              + anzZeilenGesamt + " LOC" );
        }
    }


    /**  Eigentliche Dateizeilenanalyse
     *
     *   @param dateiName Pfad-Name der zu analysierenden Datei
     */
    private void bearbeiteDatei( String dateiName ) 
            throws IOException
    {
        File           datei;
        BufferedReader dateiLeser;
        
        int            anzZeilen = 0;
        String         zeile;

        datei = new File( dateiName ); 

        DateiKeineNormaleDateiException.istNormaleDatei( datei );
        DateiNichtLesbarException.istLesbar( datei );

        ++anzDateien;

        try 
        {
            dateiLeser = new BufferedReader( new FileReader(datei) );

            while ( ( zeile = dateiLeser.readLine() ) != null )
            {
                if  ( ( zeile.trim().length() > 0 ) && !isComment( zeile ) )

                    anzZeilen++;
            } 
            dateiLeser.close();
        } 
        finally 
        {
            System.out.println( dateiName+ ":\t" + anzZeilen + " LOC" );
            anzZeilenGesamt += anzZeilen;
        }
    }


    /**  Pruefen, ob eine Zeile eine Kommentarzeile ist
     *   
     *   @param zeile die zu untersuchende Zeile
     *
     *   @return true falls Kommentarzeile, false sonst
     */
    private boolean isComment( String zeile ) 
    {
        return ( zeile.trim().startsWith( "//" ) );
    }


    /**  selbstredend die main-Methode der Anwendung
     */
    static public void main( String[] args ) 
    {
        // Kommandozeilen-Parameter-Ueberpruefung

        if ( args.length == 0 ) 
        {
            System.err.println( "Gebrauch: LOCAuswertung Datei1 Datei2 ..." );

            // dieser Programmrueckgabewert ist in Shell mit echo $? abfragbar 
            // und sagt aus: Programm mit falscher Parameterzahl aufgerufen
            System.exit(1);
        }

        try 
        {
            LOCAuswertung locAuswertung = new LOCAuswertung( args );
            locAuswertung.start();
            //dieser Programmrueckgabewert ist in Shell mit echo $? abfragbar
            // und sagt aus: Programm fehlerfrei abgelaufen
            System.exit(0);
        } 

        catch ( Exception e ) 
        {
            System.out.println( "Ausnahme: " + e.getClass().getName() );
            e.printStackTrace();
            //dieser Programmrueckgabewert ist in Shell mit echo $? abfragbar
            // und sagt aus: Programm unvorhergesehener Exception beendet
            System.exit(2);
        }
    }
}
