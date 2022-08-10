

import static org.junit.Assert.*;

import org.junit.Test;

public class ArtikelTest {
	// Test der korrekten Faelle.
	/**
	 * Testet den Konstruktor mit einer gueltigen Artikelnummer. Der Grenzwert 1000 sollte geprueft werden,
	 * also der erste korrekte Wert.
	 */
	@Test
	public void test_konstruktor_mit_artikelNummer_1000_sollte_artikelnummer_korrekt_setzen() {
		final int erwarteteArtikelnummer = 1000;
		Artikel underTest = new Artikel(erwarteteArtikelnummer, "Apfel", 100, 1500.0);
		assertEquals(erwarteteArtikelnummer, underTest.getArtikelNr());
	}
	
	/**
	 * Testet den Konstruktor mit einer gueltigen Artikelnummer. Der Grenzwert 9999 sollte geprueft werden,
	 * also der letzte korrekte Wert.
	 */
	@Test
	public void test_konstruktor_mit_artikelNummer_9999_sollte_artikelnummer_korrekt_setzen() {
		final int erwarteteArtikelnummer = 9999;
		Artikel underTest = new Artikel(erwarteteArtikelnummer, "Apfel", 100, 1500.0);
		assertEquals(erwarteteArtikelnummer, underTest.getArtikelNr());
	}
	
	/**
	 * Testet bucheAbgang mit einem Abgang von 1. Das ist der erste Wert, der funktionieren sollte.
	 */
	@Test
	public void test_bucheAbgang_mit_abgang_1_bestand_sollte_999_sein() {
		final int erwarteterBestand = 999;
		Artikel underTest = new Artikel(1000, "Apfel", 1000, 1500.0);
		underTest.bucheAbgang(1);
		assertEquals(erwarteterBestand, underTest.getBestand());
	}
	
	/**
	 * Testet bucheAbgang mit einem Zugang von 1. Das ist der erste Wert, der funktionieren sollte.
	 */
	@Test
	public void test_bucheZugang_mit_zugang_1_bestand_sollte_1001_sein() {
		final int erwarteterBestand = 1001;
		Artikel underTest = new Artikel(1000, "Apfel", 1000, 1500.0);
		underTest.bucheZugang(1);
		assertEquals(erwarteterBestand, underTest.getBestand());
	}
	
	
	// Test der Fehlerfaelle.
	/**
	 * Testet, ob eine Ausnahme geworfen wird, wenn die unterste ungueltige Artikelnummer, 999, uebergeben wird.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_konstruktor_mit_artikelnummer_999_exception_erwartet() {
		new Artikel(999, "Apfel", 1000, 1500.0);
	}
	
	/**
	 * Testet, ob eine Ausnahme geworfen wird, wenn die oberste ungueltige Artikelnummer, 10000, uebergeben wird.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_konstruktor_mit_artikelnummer_10000_exception_erwartet() {
		new Artikel(10000, "Apfel", 1000, 1500.0);
	}
	
	/**
	 * Testet, ob eine Ausnahme geworfen wird, der Konstruktor einen negativen Bestand erhaelt. Als Testwert sollte
	 * der erste ungueltige Bestand, also -1, verwendet werden.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_konstruktor_mit_bestand_minus_1_exception_erwartet() {
		new Artikel(1000, "Apfel", -1, 1500.0);
	}
	
	/**
	 * Testet, ob eine Ausnahme geworfen wird, wenn ein negativer Abgang gebucht wird. Hierbei wird der erste
	 * ungueltige Abgang genommen, also die erste negative Zahl -1.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_bucheAbgang_mit_abgang_minus_1_exception_erwartet() {
		Artikel underTest = new Artikel(1000, "Apfel", 1000, 1500.0);
		underTest.bucheAbgang(-1);
	}
	
	/**
	 * Testet, ob eine Ausnahme geworfen wird, wenn ein Abgang gebucht wird, bei dem der Bestand negativ wird. 
	 * Die Testdaten sind abhaengig von dem Bestand, mit dem die Studenten den Artikel initialisieren.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_bucheAbgang_bestand_wird_negativ_exception_erwartet() {
		Artikel underTest = new Artikel(1000, "Apfel", 1000, 1500.0);
		underTest.bucheAbgang(1001);
	}
}
