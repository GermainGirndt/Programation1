import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LagerTest {
    private static final double EPSILON = 10E-9;
    private Lager lagerMitArtikel;
    private Lager vollesLager;
    
    @Before
    public void setUp() {
        lagerMitArtikel = new Lager(10);
        lagerMitArtikel.legeAnArtikel(new Artikel(1111, "Apfel", 100, 55.55));
        lagerMitArtikel.legeAnArtikel(new Artikel(2222, "Birne", 50, 100.0));
        lagerMitArtikel.legeAnArtikel(new Artikel(3333, "Melone", 66, 66.66));
        
        vollesLager = new Lager(2);
        vollesLager.legeAnArtikel(new Artikel(1111, "Apfel", 100, 77.77));
        vollesLager.legeAnArtikel(new Artikel(2222, "Birne", 50, 100.0));
    }

    // Korrekte Faelle
    /**
     * Testet, ob ein Lager mit einer Lagergroesse von 1 korrekt erstellt wird. Dabei sollte
     * die Lagergroesse nach der Erzeugung 1 sein. Als Testwert wird die erste gueltige 
     * Lagergroesse verwendet.
     */
    @Test
    public void test_konstruktor_mit_groesse_1_sollte_lagergroesse_korrekt_setzen() {
        final int erwarteteGroesse = 1;
        Lager underTest = new Lager(1);
        assertEquals(erwarteteGroesse, underTest.getLagerGroesse());
    }
    
    /**
     * Testet, ob ein Lager mit einer Lagergroesse von 10 korrekt erstellt wird. Dabei sollte
     * die Lagergroesse nach der Erzeugung 10 sein. Der tatsaechliche Wert bei den Studenten
     * haengt natuerlich von deren Standardgroesse ab.  
     */
    @Test
    public void test_standardkonstruktor_lagergroesse_sollte_10_sein() {
        final int erwarteteGroesse = 10;
        Lager underTest = new Lager();
        assertEquals(erwarteteGroesse, underTest.getLagerGroesse());
    }
    
    /**
     * Testet, ob ein Artikel korrekt angelegt wird. Eigentlich muesste noch geprueft werden, ob
     * der Artikel an die richtige Stelle gelegt wurde und ob der richtige Artikel hineingelegt
     * wurde. Aber im Moment reicht es, wenn geprueft wird, ob der Anzahl der Artikel erhoeht wurde.
     */
    @Test
    public void test_legeArtikelAn_anzahlArtikel_sollte_4_sein() {
        final int erwarteteArtikelAnzahl = 4;
        lagerMitArtikel.legeAnArtikel(new Artikel(4444, "Kirsche", 22, 22.22));
        assertEquals(erwarteteArtikelAnzahl, lagerMitArtikel.getArtikelAnzahl());
    }
    
    /**
     * Testet, ob ein Artikel aus dem Lager entfernt wird. Eigentlich muesste geprueft werden, ob
     * der Artikel tatsaechlich entfernt wurde und ob es keine Luecken gibt. Aber im Moment reicht es, 
     * wenn geprueft wird, ob der Anzahl der Artikel verringert wurde.
     */
    @Test
    public void test_entferneArtikel_anzahlArtikel_sollte_2_sein() {
        final int erwarteteArtikelAnzahl = 2;
        lagerMitArtikel.entferneArtikel(2222);
        assertEquals(erwarteteArtikelAnzahl, lagerMitArtikel.getArtikelAnzahl());
    }
    
    /**
     * Prueft, ob der Zugang 1 zu dem Artikel mit der Nummer 2222 zugebucht wurde. Der Artikel
     * wurde mit einem Bestand von 50 initialisiert. Das koennen bei den Studenten natuerlich
     * andere Werte sein.
     */
    @Test
    public void test_bucheZugang_mit_artikel_2222_und_zugang_1_bestand_sollte_51_sein() {
        final int erwarteterBestand = 51;
        lagerMitArtikel.bucheZugang(2222, 1);
        assertEquals(erwarteterBestand, lagerMitArtikel.getArtikel(1).getBestand());
    }
    
    /**
     * Prueft, ob der Abgang 1 von dem Artikel mit der Nummer 2222 abgebucht wurde. Der Artikel
     * wurde mit einem Bestand von 50 initialisiert. Das koennen bei den Studenten natuerlich
     * andere Werte sein.
     */
    @Test
    public void test_bucheAbgang_mit_artikel_2222_und_abgang_1_bestand_sollte_49_sein() {
        final int erwarteterBestand = 49;
        lagerMitArtikel.bucheAbgang(2222, 1);
        assertEquals(erwarteterBestand, lagerMitArtikel.getArtikel(1).getBestand());
    }
    
    /**
     * Prueft, ob eine Preisaenderung um 50 % bei dem Artikel mit der Nummer 2222 korrekt durchgefuehrt
     * wird. Das koennen bei den Studenten natuerlich andere Werte sein.
     */
    @Test
    public void test_aenderePreis_mit_artikel_2222_und_50_prozent_preis_sollte_150_sein() {
        final double erwarteterPreis = 150.0;
        lagerMitArtikel.aenderePreisEinesArtikels(2222, 50.0);
        assertEquals(erwarteterPreis, lagerMitArtikel.getArtikel(1).getPreis(), EPSILON);
    }
    
    /**
     * Prueft, ob eine Preisaenderung um -50 % bei dem Artikel mit der Nummer 2222 korrekt durchgefuehrt
     * wird. Das koennen bei den Studenten natuerlich andere Werte sein.
     */
    @Test
    public void test_aenderePreis_mit_artikel_2222_und_minus_50_prozent_preis_sollte_75_sein() {
        final double erwarteterPreis = 50.0;
        lagerMitArtikel.aenderePreisEinesArtikels(2222, -50.0);
        assertEquals(erwarteterPreis, lagerMitArtikel.getArtikel(1).getPreis(), EPSILON);
    }
    
    // Fehlerfaelle
    /**
     * Prueft, ob ein Lager mit ungueltiger Groese nicht angelegt wird. Hier sollte der Testwert 0 
     * verwendet werden.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_konstruktor_mit_lagergroesse_0_exception_erwartet() {
        new Lager(0);
    }
    
    /**
     * Prueft, ob eine Ausnahme geworfen wird, wenn ein Artikel angelegt wird, der bereits im
     * Lager existiert. Die konkreten Werte sind natuerlich abhaengig von den tatsaechlich 
     * von den Studenten verwendeten Werten.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_legeArtikelAn_artikel_existiert_bereits_exception_erwartet() {
        lagerMitArtikel.legeAnArtikel(new Artikel(2222, "Birne", 50, 100.0));
    }
    
    /**
     * Prueft, ob eine Ausnahme geworfen wird, wenn ein Artikel in ein volles Lager gelegt wird.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_legeArtikelAn_lager_ist_voll_exception_erwartet() {
        vollesLager.legeAnArtikel(new Artikel(3333, "Melone", 33, 33.33));
    }
    
    /**
     * Aendert den Preis eines Artikels mit -101 Prozent, so dass der Preis negativ wird. Hier sollte auch
     * als Testwert -101 verwendet werden, also die Grenze. 
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_aenderePreisEinesArtikels_preis_wird_negativ_exception_erwartet() {
        lagerMitArtikel.aenderePreisEinesArtikels(2222, -101.0);
    }
}
