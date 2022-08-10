

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BuchTest {

        private String korrekterBuchTitel, korrekterBuchAutor, korrekterBuchVerlag, korrekteArtikelArt;
        private String nullBuchTitel, nullBuchAutor, nullBuchVerlag;
        private String leerBuchTitel, leerBuchAutor, leerBuchVerlag;

        private Buch korrektesBuch;
        

        @Before
        public void setUp() {
                 korrekterBuchTitel = "Sprechen Sie Java?";
                 korrekterBuchAutor = "Mössenböck";
                 korrekterBuchVerlag = "dpunkt.verlag";
		 korrekteArtikelArt  = "Medien";
                 
                 nullBuchTitel = null;
                 nullBuchAutor = null;
                 nullBuchVerlag = null;
                 
                 leerBuchTitel = "";
                 leerBuchAutor = "    ";
                 leerBuchVerlag = "";

                korrektesBuch = new Buch(1000,100,15.00,
                                         korrekterBuchTitel,korrekterBuchAutor,korrekterBuchVerlag);

        }
 
    // Test der korrekten Faelle .
   
    @Test
    public void test_konstruktor_mit_korrektem_wert_fuer_titel() {
        assertEquals(korrekterBuchTitel, korrektesBuch.getTitel());
    }
    
 
    @Test
    public void test_konstruktor_mit_korrektem_wert_fuer_autor() {
        assertEquals(korrekterBuchAutor, korrektesBuch.getAutor());
    }
    
  
    @Test
    public void test_konstruktor_mit_korrektem_wert_fuer_verlag() {
        assertEquals(korrekterBuchVerlag, korrektesBuch.getVerlag());
    }
  
    @Test
    public void test_konstruktor_mit_korrekten_werten_auf_korrekteArtikelArt() {
        assertEquals(korrekteArtikelArt, korrektesBuch.getArt());
    }
 
    
    // Test der Fehlerfaelle.
   

    @Test(expected = IllegalArgumentException.class)
    public void test_konstruktor_mit_BuchTitel_null() {
        new Buch(1000,100,15.00,
                 nullBuchTitel,korrekterBuchAutor,korrekterBuchVerlag);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_konstruktor_mit_BuchTitel_leer() {
        new Buch(1000, 100,15.00,
                 leerBuchTitel,korrekterBuchAutor,korrekterBuchVerlag);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_konstruktor_mit_BuchAutor_null() {
        new Buch(1000, 100, 15.00,
                 korrekterBuchTitel,nullBuchAutor,korrekterBuchVerlag);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_konstruktor_mit_BuchAutor_leer() {
        new Buch(1000, 100, 15.00,
                 korrekterBuchTitel,leerBuchAutor,korrekterBuchVerlag);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_konstruktor_mit_BuchVerlag_null() {
        new Buch(1000, 100, 15.00,
                 korrekterBuchTitel,korrekterBuchAutor,nullBuchVerlag);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_konstruktor_mit_BuchVerlag_leer() {
        new Buch(1000, 100, 15.00,
                korrekterBuchTitel,korrekterBuchAutor,leerBuchVerlag);
    }
 
}
