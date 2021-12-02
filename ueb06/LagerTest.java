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
    public static       Map<String, Object> ARTIKEL_EINS_KONSTANTS;
    public static final int                 ARTIKEL_EINS_NUMMER                =  1111;
    public static final String              ARTIKEL_EINS_ART                   = "Playstation";
    public static final int                 ARTIKEL_EINS_BESTAND               =  1;
    public static final double              ARTIKEL_EINS_PREIS                 =  10.0;
    
    
    public static final String              ARTIKEL_KONSTANTE_NUMMER           =  "NUMMER";
    public static final String              ARTIKEL_KONSTANTE_ART              =  "ART";
    public static final String              ARTIKEL_KONSTANTE_PREIS            =  "PREIS";
    public static final String              ARTIKEL_KONSTANTE_BESTAND          =  "BESTAND";

    Lager                                   lager;
    Artikel                                 artikelEins;


    @BeforeAll
    public static void setUpClass() {
        ARTIKEL_EINS_KONSTANTS = new HashMap<String, Object>()
        {{
            put(ARTIKEL_KONSTANTE_NUMMER, ARTIKEL_EINS_NUMMER);
            put(ARTIKEL_KONSTANTE_ART, ARTIKEL_EINS_ART);
            put(ARTIKEL_KONSTANTE_PREIS, ARTIKEL_EINS_PREIS);
            put(ARTIKEL_KONSTANTE_BESTAND, ARTIKEL_EINS_BESTAND);
        }};
    }



    @BeforeEach
    public void setUp() {
        this.lager = new Lager();
        this.artikelEins = new Artikel(
            (int)    ARTIKEL_EINS_KONSTANTS.get(ARTIKEL_KONSTANTE_NUMMER), 
            (String) ARTIKEL_EINS_KONSTANTS.get(ARTIKEL_KONSTANTE_ART), 
            (int)    ARTIKEL_EINS_KONSTANTS.get(ARTIKEL_KONSTANTE_BESTAND), 
            (double) ARTIKEL_EINS_KONSTANTS.get(ARTIKEL_KONSTANTE_PREIS)
        );
    }

    @Test
    public void neuesLagerHatNullArtikel()
    {
        int erwarteteArtikelanzahl = 0;

        int artikelAnzahl = this.lager.getArtikelAnzahl();

        assertEquals(erwarteteArtikelanzahl, artikelAnzahl);
    }

    @Test
    public void kannEinenArtikelAnlegen()
    {
        int erwarteteArtikelAnzahl = 1;

        this.lager.legeAnArtikel(this.artikelEins);

        int artikelAnzahl = this.lager.getArtikelAnzahl();
        assertEquals(erwarteteArtikelAnzahl, artikelAnzahl);

        Artikel artikel = this.lager.getArtikel(0);
        assertEquals(this.artikelEins, artikel);
    }

    @Test
    public void neuesLagerHatGenauZehnPlaetze()
    {

        HashMap[] artikeldateien = new HashMap[] {
            new HashMap<String, Object>()
            {{
                put(ARTIKEL_KONSTANTE_NUMMER, 1111);
                put(ARTIKEL_KONSTANTE_ART, "Computerspiel");
                put(ARTIKEL_KONSTANTE_BESTAND, 10);
                put(ARTIKEL_KONSTANTE_PREIS, 50.10);
            }}
        };

        for ( HashMap artikeldatei : artikeldateien) {

            int artikelnummer = (int) artikeldatei.get(ARTIKEL_KONSTANTE_NUMMER);
            String artikelart = (String) artikeldatei.get(ARTIKEL_KONSTANTE_ART);
            int artikelbestand = (int) artikeldatei.get(ARTIKEL_KONSTANTE_BESTAND);
            double artikelpreis = (double) artikeldatei.get(ARTIKEL_KONSTANTE_PREIS);

            Artikel artikel = new Artikel(artikelnummer, artikelart, artikelbestand, artikelpreis);

            this.lager.legeAnArtikel(artikel);
        }
    }


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
