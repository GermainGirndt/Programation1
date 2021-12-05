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

    
    //KonstruktorTests 
    
    //Korrekte Fälle 
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
    
    //Fehlerfälle
    @Test (expected = IllegalArgumentException.class)
    public void test_Artikel_Konstruktor_ArtikelNr_99999()
    {
        Artikel artikel            = new Artikel(99999, "Test");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_Artikel_Konstruktor_ArtikelNr_negative_3()
    {
        Artikel artikel            = new Artikel(-3, "Test");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_Artikel_Konstruktor_ArtikelNr_0()
    {
        Artikel artikel            = new Artikel(0, "Test");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_Artikel_Konstruktor_Bestand_minus_1()
    {
        Artikel artikel            = new Artikel(0, "Test", -1);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_Artikel_Konstruktor_preis_minus_1_komma_5()
    {
        Artikel artikel            = new Artikel(0, "Test", 0, -1.5);
    }
    
    //MethodenTest
    
    //Korrekte Fälle
    //abgang
    @Test
    public void test_buche_Abgang_erwartet_10_uebergeben_10()
    {
        long erwarteterBestand      = 10;
        Artikel artikel             = new Artikel(1234, "Test", 20);
        artikel.bucheAbgang(10);
        long tatsaechlicherBestand  = artikel.getBestand();
        assertEquals(erwarteterBestand , tatsaechlicherBestand);
    }
    
    //zugang
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
    
    //Fehlerfälle
    //zugang
    @Test (expected = IllegalArgumentException.class)
     public void test_buche_Zugang_uebergeben_minus_5()
    {
        Artikel artikel             = new Artikel(1234, "Test", 5);
        artikel.bucheZugang(-5);
       
    }
    
    //abgang
     @Test (expected = IllegalArgumentException.class)
     public void test_buche_Abgang_uebergeben_10_bestand_5()
    {
        Artikel artikel             = new Artikel(1234, "Test", 5);
        artikel.bucheAbgang(10);
       
    }
}

