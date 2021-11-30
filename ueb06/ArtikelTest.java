   
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
    
/**
* Die Test-Klasse ArtikelTest.
*
* @author  (Ihr Name)
* @version (eine Versionsnummer oder ein Datum)
*/
public class ArtikelTest
    {
        
        
    /**
    * Konstruktor fuer die Test-Klasse ArtikelTest
    */
    public ArtikelTest()
    {
    }
    
        /**
         *  Setzt das Testgerüst fuer den Test.
         *
         * Wird vor jeder Testfall-Methode aufgerufen.
         */
        @Before
    public void setUp()
    {
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @After
    public void tearDown()
    {
    }
    
    
    //KonstruktorTests
    @Test
    public void test_Artikel_Konstruktor_Artikelnr_1()
    {
        int erwarteteNr     = 1;
        Artikel artikel     = new Artikel(1, "Test");
        int tatsaechlicheNr = artikel.getArtikelNr();
        assertEquals(erwarteteNr , tatsaechlicheNr);
    }
    
    @Test
    public void test_Artikel_Konstruktor_Artikelnr_9999()
    {
        int erwarteteNr     = 9999;
        Artikel artikel     = new Artikel(9999, "Test");
        int tatsaechlicheNr = artikel.getArtikelNr();
        assertEquals(erwarteteNr , tatsaechlicheNr);
    }
    
    @Test
    public void test_Artikel_Konstruktor_Artikelnr_1234()
    {
        int erwarteteNr     = 1234;
        Artikel artikel     = new Artikel(1234, "Test");
        int tatsaechlicheNr = artikel.getArtikelNr();
        assertEquals(erwarteteNr , tatsaechlicheNr);
    }
    
    @Test
    public void test_Artikel_Konstruktor_Ohne_Bestand()
    {
        long erwarteterBestand     = 0;
        Artikel artikel            = new Artikel(1234, "Test");
        long tatsaechlicherBestand = artikel.getBestand();
        assertEquals(erwarteterBestand , tatsaechlicherBestand);
    }
    
    @Test
    public void test_Artikel_Konstruktor_Ohne_Preis()
    {
        double erwarteterPreis     = 0.0;
        Artikel artikel            = new Artikel(1234, "Test");
        double tatsaechlicherPreis = artikel.getPreis();
        assertEquals(erwarteterPreis , tatsaechlicherPreis , 2* Double.MIN_VALUE);
    }
    
    
    //MethodenTest
    @Test
    public void test_buche_Abgang_erwartet_10_uebergeben_10()
    {
        long erwarteterBestand      = 10;
        Artikel artikel             = new Artikel(1234, "Test", 20);
        artikel.bucheAbgang(10);
        long tatsaechlicherBestand  = artikel.getBestand();
        assertEquals(erwarteterBestand , tatsaechlicherBestand);
    }
    
    @Test
    public void test_buche_Zugang_erwartet_10_uebergeben_10()
    {
        long erwarteterBestand      = 10;
        Artikel artikel             = new Artikel(1234, "Test", 0);
        artikel.bucheZugang(10);
        long tatsaechlicherBestand  = artikel.getBestand();
        assertEquals(erwarteterBestand , tatsaechlicherBestand);
    }
    
    @Test
    public void test_buche_Zugang_erwartet_15_uebergeben_10()
    {
        long erwarteterBestand      = 15;
        Artikel artikel             = new Artikel(1234, "Test", 5);
        artikel.bucheZugang(10);
        long tatsaechlicherBestand  = artikel.getBestand();
        assertEquals(erwarteterBestand , tatsaechlicherBestand);
    }
}


