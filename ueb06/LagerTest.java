import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse LagerTest.
 *
 * @author  Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class LagerTest
{       
    private Lager                                   lager;
    private ArtikelFactory                          artikelFactory;

    public static int                       INDEX_ARTIKEL_EINS = 0;

    @BeforeEach
    public void setUp() {
        this.lager = new Lager();
        this.artikelFactory = new ArtikelFactory();
    }

    @Test
    public void neues_lager_hat_null_Artikel()
    {
        int erwarteteArtikelanzahl = 0;

        int artikelAnzahl = this.lager.getArtikelAnzahl();

        assertEquals(erwarteteArtikelanzahl, artikelAnzahl);
    }

    @Test
    public void kann_einen_Artikel_anlegen()
    {
        int erwarteteArtikelAnzahl = 1;

        Artikel artikelEins = this.anlege_Artikel_eins_ins_Lager();
        Artikel angelegterArtikel = this.lager.getArtikel(INDEX_ARTIKEL_EINS);
        assertEquals(artikelEins, angelegterArtikel);
    }

    
    @Test
    public void die_Artikelanzahl_wird_um_eins_erhoert_bei_dem_Anlegen()
    {
        int erwarteteArtikelAnzahl = 1;
        
        anlege_Artikel_eins_ins_Lager();
        int artikelanzahl = this.lager.getArtikelAnzahl();

        assertEquals(erwarteteArtikelAnzahl, artikelanzahl);
    }
    
    private Artikel anlege_Artikel_eins_ins_Lager() {
        
        Artikel[] artikelArray = this.artikelFactory.getArtikel(1);
        if (true == true ) {
            throw new ArithmeticException("oben2");
        }
        Artikel artikelEins = artikelArray[INDEX_ARTIKEL_EINS];
        
        // if (artikelEins == null) {
        //     throw new ArithmeticException("hi");
        // }

        //System.out.print("hi");

        //this.lager.legeAnArtikel(artikelEins);

        return artikelEins;
    }

    // @Test
    // public void kann_zwei_Artikel_anlegen()
    // {
    //     int erwarteteArtikelAnzahl = 1;

    //     Artikel artikelEins = this.anlege_Artikel_eins_ins_Lager();
    //     Artikel angelegterArtikel = this.lager.getArtikel(INDEX_ARTIKEL_EINS);
    //     assertEquals(artikelEins, angelegterArtikel);
    // }




    @Test
    public void neues_lager_kann_zehn_Artikel_halten()
    {
        Artikel[] artikelArray = this.artikelFactory.getArtikel(10);

        for ( Artikel artikel : artikelArray) {
            this.lager.legeAnArtikel(artikel);
        }
    }

    @Test
    public void neues_lager_kann_nicht_elf_Artikel_halten()
    {
        Artikel[] artikelArray = this.artikelFactory.getArtikel(11);

        for ( Artikel artikel : artikelArray) {
            this.lager.legeAnArtikel(artikel);
        }
    }

////////////////////////
    @Test
    public void test_Lager_Konstruktor_Groesse_20()
    {
        int erwartetegr     = 20;
        Lager lager         = new Lager(20);
        int tatsaechlichegr = this.lager.getLagerGroesse();
        assertEquals(erwartetegr , tatsaechlichegr);
    }
    
    @Test
    public void test_Lager_Konstruktor_Groesse_Initial()
    {
        int erwartetegr     = 10;
        Lager lager         = new Lager();
        int tatsaechlichegr = this.lager.getLagerGroesse();
        assertEquals(erwartetegr , tatsaechlichegr);
    }
    
    //legeArtikelAn
    @Test
    public void test_Lager_LegeArtikelAn_noch_nicht_da()
    {
        Lager lager         = new Lager(20);
        Artikel artikel     = new Artikel(123, "test");
        this.lager.legeAnArtikel(artikel);
        assertEquals(artikel , this.lager.getArtikel(0));
    }
}
