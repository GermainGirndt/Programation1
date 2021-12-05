import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    public static int                               ARTIKEL_EINS_NUMMER = 1;
    public static int                               ARTIKEL_ZWEI_NUMMER = 2;
    public static int                               ARTIKEL_DREI_NUMMER = 3;

    @BeforeEach
    public void setUp() {
        this.lager = new Lager();
        this.artikelFactory = new ArtikelFactory();
    }

    /**
     * Startattribute
     */

    @Test
    public void neues_lager_hat_null_Artikel() {
        int erwarteteArtikelanzahl = 0;

        int artikelAnzahl = this.lager.getArtikelAnzahl();

        assertEquals(erwarteteArtikelanzahl, artikelAnzahl);
    }

    /**
     * Artikel anlegen
     */
    
    @Test
    public void kann_einen_Artikel_anlegen() {
        int erwarteteArtikelAnzahl = 1;
        
        Artikel artikelEins = this.anlege_einen_Artikel_ins_Lager(ARTIKEL_EINS_NUMMER);
        Artikel angelegterArtikel = this.lager.getArtikel(this.getIndexFromArtikel(ARTIKEL_EINS_NUMMER));
        assertEquals(artikelEins, angelegterArtikel);
    }

    @Test
    public void darf_Nullpointerreferenz_als_Artikel_nicht_anlegen() {
        
        assertThrows(
            IllegalArgumentException.class,
            () -> this.lager.legeAnArtikel(null),
            "Expected doThing() to throw, but it didn't"
            );
            
        }
        
        @Test
    public void die_Artikelanzahl_wird_um_eins_erhoert_bei_dem_Anlegen() {
        int erwarteteArtikelAnzahl = 1;
        
        Artikel artikelEins = this.anlege_einen_Artikel_ins_Lager(ARTIKEL_EINS_NUMMER);
        int artikelanzahl = this.lager.getArtikelAnzahl();
        assertEquals(erwarteteArtikelAnzahl, artikelanzahl);
        
    }
    
    /**
     * mehrfache Artikel anlegen
     */

    @Test
    public void kann_zwei_Artikel_anlegen() {
        int erwarteteArtikelAnzahl = 2;

        Artikel[] artikel = this.anlege_viele_Artikel_ins_Lager(erwarteteArtikelAnzahl);

        for (int index = 0; index < erwarteteArtikelAnzahl; index++) {
            Artikel angelegterArtikel = this.lager.getArtikel(index);
            assertEquals(artikel[index], angelegterArtikel);
        }
    }
    
    @Test
    public void darf_nicht_denselben_Artikel_zweimal_anlegen() {
        Artikel artikelEins = this.anlege_einen_Artikel_ins_Lager(ARTIKEL_EINS_NUMMER);

        assertThrows(
            IllegalArgumentException.class,
            () -> this.lager.legeAnArtikel(artikelEins),
            "Expected doThing() to throw, but it didn't"
            );
    }
    
    @Test
    public void darf_nicht_einen_anderen_Artikel_anlegen_mit_derselben_Artikelnummer() {
        Artikel artikelEins = this.anlege_einen_Artikel_ins_Lager(ARTIKEL_EINS_NUMMER);
        
        Artikel artikelMitDerselbenNummer = new Artikel(artikelEins.getArtikelNr(), "andere Artikel");

        assertThrows(
            IllegalArgumentException.class,
            () -> this.lager.legeAnArtikel(artikelMitDerselbenNummer),
            "Expected doThing() to throw, but it didn't"
        );
    }
    
    
    /**
     * Lagergroesse
     */

    @Test
    public void lager_Konstruktor_Startgroesse_muss_10_sein() {
        int erwarteteGroesse     = 10;
        int tatsaechlicheGroesse = this.lager.getLagerGroesse();
        assertEquals(erwarteteGroesse , tatsaechlicheGroesse);
    }

    @Test
    public void neues_lager_kann_zehn_Artikel_aufnehmen() {
        int zehnArtikel = 10;

        this.anlege_viele_Artikel_ins_Lager(zehnArtikel);
    }

    @Test
    public void neues_lager_kann_nicht_elf_Artikel_halten() {
        int elfArtikel = 11;

        assertThrows(
            IllegalArgumentException.class,
            () -> anlege_viele_Artikel_ins_Lager(elfArtikel),
            "Expected doThing() to throw, but it didn't"
        );
    }

    @Test
    public void benutzerdefinierte_Lager_Konstruktor_Groesse_5_muss_funtionieren() {
        int erwarteteGroesse = 5;

        this.lager = new Lager(erwarteteGroesse);
        int tatsaechlicheGroesse = this.lager.getLagerGroesse();

        assertEquals(erwarteteGroesse , tatsaechlicheGroesse);
    }

    @Test
    public void benutzerdefinierte_Lager_mit_Groesse_5_muss_5_artikel_aufnehmen_koennnen() {
        int lagergroesse      = 5;
        int artikelZumAnlegen = 5;

        this.lager = new Lager(lagergroesse);
        anlege_viele_Artikel_ins_Lager(artikelZumAnlegen);
    }

    @Test
    public void benutzerdefinierte_Lager_mit_Groesse_5_darf_6_artikel__nicht_aufnehmen() {
        int lagergroesse      = 5;
        int artikelZumAnlegen = 6;
        
        this.lager = new Lager(lagergroesse);

        assertThrows(
            IllegalArgumentException.class,
            () -> anlege_viele_Artikel_ins_Lager(artikelZumAnlegen),
            "Expected doThing() to throw, but it didn't"
        );
    }

    @Test
    public void benutzerdefinierte_Lagergroesse_darf_nicht_null_sein() {
        int ungueltigeLagergroesse = 0;

        assertThrows(
            IllegalArgumentException.class,
            () -> new Lager(ungueltigeLagergroesse),
            "Expected doThing() to throw, but it didn't"
        );

    }

    @Test
    public void benutzerdefinierte_Lagergroesse_darf_nicht_minus_eins_sein() {
        int ungueltigeLagergroesse = -1;

        assertThrows(
            IllegalArgumentException.class,
            () -> new Lager(ungueltigeLagergroesse),
            "Expected doThing() to throw, but it didn't"
        );
    }

    /**
     * Artikel entfernen
     */

    @Test
    public void kann_einen_Artikel_entfernen() {
        Artikel artikel = this.anlege_einen_Artikel_ins_Lager(ARTIKEL_EINS_NUMMER);

        this.lager.entferneArtikel(artikel.getArtikelNr());

        assertThrows(
            Error.class,
            () -> this.lager.getArtikel(this.getIndexFromArtikel(ARTIKEL_EINS_NUMMER)),
            "Expected doThing() to throw, but it didn't"
        );
    }

    @Test
    public void Artikelanzahl_1_wird_bei_entfernung_um_eins_reduziert() {
        int erwarteteArtikelanzahl = 0;

        Artikel artikel = this.anlege_einen_Artikel_ins_Lager(ARTIKEL_EINS_NUMMER);
        this.lager.entferneArtikel(artikel.getArtikelNr());

        int eigentlicheArtikelanzahl = this.lager.getArtikelAnzahl();

        assertEquals(erwarteteArtikelanzahl, eigentlicheArtikelanzahl);
    }

    @Test
    public void kann_zwei_Artikel_entfernen() {
        int zweiArtikel = 2;
        Artikel[] artikelArray = this.anlege_viele_Artikel_ins_Lager(zweiArtikel);

        for ( Artikel artikel : artikelArray) {
            this.lager.entferneArtikel(artikel.getArtikelNr());
        }

        assertThrows(
            Error.class,
            () -> this.lager.getArtikel(this.getIndexFromArtikel(ARTIKEL_EINS_NUMMER)),
            "Expected doThing() to throw, but it didn't"
        );

        assertThrows(
            Error.class,
            () -> this.lager.getArtikel(this.getIndexFromArtikel(ARTIKEL_ZWEI_NUMMER)),
            "Expected doThing() to throw, but it didn't"
        );
    }

    @Test
    public void Artikelanzahl_2_wird_bei_entfernung_des_ersten_artikels_um_eins_reduziert() {
        int erwarteteArtikelanzahl = 1;
        int zweiArtikel = 2;

        Artikel[] artikelArray = this.anlege_viele_Artikel_ins_Lager(zweiArtikel);
        this.lager.entferneArtikel(artikelArray[this.getIndexFromArtikel(ARTIKEL_EINS_NUMMER)].getArtikelNr());
        int eigentlicheArtikelanzahl = this.lager.getArtikelAnzahl();

        assertEquals(erwarteteArtikelanzahl, eigentlicheArtikelanzahl);
    }

    @Test
    public void Artikelanzahl_2_wird_bei_entfernung_des_zweiten_artikels_um_eins_reduziert() {
        int erwarteteArtikelanzahl = 1;
        int zweiArtikel = 2;

        Artikel[] artikelArray = this.anlege_viele_Artikel_ins_Lager(zweiArtikel);
        this.lager.entferneArtikel(artikelArray[this.getIndexFromArtikel(ARTIKEL_ZWEI_NUMMER)].getArtikelNr());
        int eigentlicheArtikelanzahl = this.lager.getArtikelAnzahl();

        assertEquals(erwarteteArtikelanzahl, eigentlicheArtikelanzahl);
    }


    @Test
    public void Artikelanzahl_2_wird_bei_entfernung_beider_artikel_um_zwei_reduziert() {
        int erwarteteArtikelanzahl = 0;

        int zweiArtikel = 2;
        Artikel[] artikelArray = this.anlege_viele_Artikel_ins_Lager(zweiArtikel);

        for ( Artikel artikel : artikelArray) {
            this.lager.entferneArtikel(artikel.getArtikelNr());
        }

        int eigentlicheArtikelanzahl = this.lager.getArtikelAnzahl();

        assertEquals(erwarteteArtikelanzahl, eigentlicheArtikelanzahl);
    }

    @Test
    public void zweiter_und_dritter_Artikel_im_Lager_werden_verschoben_bei_Entfernung_des_ersten_Artikels() {
        int dreiArtikel = 3;

        Artikel[] artikelArray = this.anlege_viele_Artikel_ins_Lager(dreiArtikel);

        this.lager.entferneArtikel(artikelArray[this.getIndexFromArtikel(ARTIKEL_EINS_NUMMER)].getArtikelNr());

        Artikel artikelAnDerErstenStelle = this.lager.getArtikel(this.getIndexFromArtikel(ARTIKEL_EINS_NUMMER));
        Artikel artikelAnDerZweitenStelle = this.lager.getArtikel(this.getIndexFromArtikel(ARTIKEL_ZWEI_NUMMER));

        assertEquals(artikelArray[this.getIndexFromArtikel(ARTIKEL_ZWEI_NUMMER)], artikelAnDerErstenStelle);
        assertEquals(artikelArray[this.getIndexFromArtikel(ARTIKEL_DREI_NUMMER)], artikelAnDerZweitenStelle);

        assertThrows(
            Error.class,
            () -> this.lager.getArtikel(this.getIndexFromArtikel(ARTIKEL_DREI_NUMMER)),
            "Expected doThing() to throw, but it didn't"
        );
    }


    /**
     * Zugang und Abgang
     */

    @Test
    public void kann_Zugang_100_neuer_Stuecke_zu_Artikel_Eins_buchen() {
        int zugegangeneMenge = 100;

        Artikel artikel = this.anlege_einen_Artikel_ins_Lager(ARTIKEL_EINS_NUMMER);
        long startbestand = artikel.getBestand();

        this.lager.bucheZugang(artikel.getArtikelNr(), zugegangeneMenge);

        assertEquals(startbestand + zugegangeneMenge, artikel.getBestand());
    }

    @Test
    public void kann_Abgang_100_neuer_Stuecke_zu_Artikel_Eins_buchen() {
        int abgegangeneMenge = 100;

        Artikel artikel = this.anlege_einen_Artikel_ins_Lager(ARTIKEL_EINS_NUMMER);
        long startbestand = artikel.getBestand();

        this.lager.bucheAbgang(artikel.getArtikelNr(), abgegangeneMenge);

        assertEquals(startbestand - abgegangeneMenge, artikel.getBestand());
    }

    
    /**
     * Preis aendern
     */

    @Test
    public void kann_Preis_des_ersten_Artikels_um_100_prozent_erhoeen() {
        double hundert_prozent_inkrement = 100.00;

        Artikel artikel = this.anlege_einen_Artikel_ins_Lager(ARTIKEL_EINS_NUMMER);
        double startpreis = artikel.getPreis();

        this.lager.aenderePreisEinesArtikels(artikel.getArtikelNr(), hundert_prozent_inkrement);

        assertEquals(startpreis * 2, artikel.getPreis());
    }

    @Test
    public void kann_Preis_des_ersten_Artikels_um_50_prozent_erhoeen() {
        double hundert_prozent_inkrement = 50.00;

        Artikel artikel = this.anlege_einen_Artikel_ins_Lager(ARTIKEL_EINS_NUMMER);
        double startpreis = artikel.getPreis();

        this.lager.aenderePreisEinesArtikels(artikel.getArtikelNr(), hundert_prozent_inkrement);

        assertEquals(startpreis * 1.5, artikel.getPreis());
    }

    @Test
    public void Aenderung_um_0_prozent_hat_keine_Auswirkung_auf_den_Preis() {
        double null_prozent_aenderung = 0.00;

        Artikel artikel = this.anlege_einen_Artikel_ins_Lager(ARTIKEL_EINS_NUMMER);
        double startpreis = artikel.getPreis();
        
        this.lager.aenderePreisEinesArtikels(artikel.getArtikelNr(), null_prozent_aenderung);
        
        assertEquals(startpreis, artikel.getPreis());
    }
    
    @Test
    public void kann_Preis_des_ersten_Artikels_um_50_prozent_verringern() {
        double hundert_prozent_inkrement = -50.00;
        
        Artikel artikel = this.anlege_einen_Artikel_ins_Lager(ARTIKEL_EINS_NUMMER);
        double startpreis = artikel.getPreis();

        this.lager.aenderePreisEinesArtikels(artikel.getArtikelNr(), hundert_prozent_inkrement);

        assertEquals(startpreis / 2, artikel.getPreis());
    }

    @Test
    public void kann_Preis_des_ersten_Artikels_um_100_prozent_verringern() {
        double hundert_prozent_dekrement = -100.00;

        Artikel artikel = this.anlege_einen_Artikel_ins_Lager(ARTIKEL_EINS_NUMMER);

        this.lager.aenderePreisEinesArtikels(artikel.getArtikelNr(), hundert_prozent_dekrement);

        assertEquals(0, artikel.getPreis());
    }

    @Test
    public void darf_Preis_des_ersten_Artikels_nicht_um_hundert_comma_null_eins_prozent_verringern() {
        double hundert_eins_prozent_dekrement = -100.01;

        Artikel artikel = this.anlege_einen_Artikel_ins_Lager(ARTIKEL_EINS_NUMMER);

        assertThrows(
            IllegalArgumentException.class,
            () -> this.lager.aenderePreisEinesArtikels(artikel.getArtikelNr(), hundert_eins_prozent_dekrement),
            "Expected doThing() to throw, but it didn't"
        );
    }

    /**
    * Hilfmethoden
    */

    private Artikel anlege_einen_Artikel_ins_Lager(int artikelNummer) {
        Artikel artikel = this.artikelFactory.getEinenArtikel(artikelNummer);
        
        this.lager.legeAnArtikel(artikel);
        
        return artikel;
    }

    private Artikel[] anlege_viele_Artikel_ins_Lager(int artikelanzahl) {
        
        Artikel[] artikel = this.artikelFactory.getVieleArtikel(artikelanzahl);
        
        for (int index = 0; index < artikelanzahl; index++) {
            this.lager.legeAnArtikel(artikel[index]);
        }

        return artikel;
    }

    private int getIndexFromArtikel(int artikelNummer) {
        return artikelNummer - 1;
    }
    
}
