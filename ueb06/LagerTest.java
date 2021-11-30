

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse LagerTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class LagerTest
{
    //KonstruktorTests 
    
    //Korrekte Fälle 
    @Test
    public void test_Lager_Konstruktor_Groesse_20()
    {
        int erwartetegr     = 20;
        Lager lager         = new Lager(20);
        int tatsaechlichegr = lager.getLagerGroesse();
        assertEquals(erwartetegr , tatsaechlichegr);
    }
    
    @Test
    public void test_Lager_Konstruktor_Groesse_Initial()
    {
        int erwartetegr     = 10;
        Lager lager         = new Lager();
        int tatsaechlichegr = lager.getLagerGroesse();
        assertEquals(erwartetegr , tatsaechlichegr);
    }
    
    //legeArtikelAn
    @Test
    public void test_Lager_LegeArtikelAn_noch_nicht_da()
    {
        Lager lager         = new Lager(20);
        Artikel artikel     = new Artikel(123, "test");
        lager.legeAnArtikel(artikel);
        assertEquals(artikel , lager.getArtikel(0));
    }
}
