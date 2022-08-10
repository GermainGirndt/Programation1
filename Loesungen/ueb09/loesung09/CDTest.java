

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CDTest {

        private String korrekterCDTitel, korrekterCDInterpret, korrekteArtikelArt;
        int korrekteCDAnzahlTitel;
        private String nullCDTitel, nullCDInterpret;
        private int nullCDAnzahlTitel;
        private String leerCDTitel, leerCDInterpret;

        private CD korrekteCD;
        

        @Before
        public void setUp() {
                 korrekterCDInterpret = new String("Mössenböck");
                 korrekterCDTitel = new String("Sprechen Sie Java?");
                 korrekteCDAnzahlTitel = 22;
         korrekteArtikelArt  = "Medien";
                 
                 nullCDInterpret = null;
                 nullCDTitel = null;
                 nullCDAnzahlTitel = 0;
                 
                 leerCDInterpret = "    ";
                 leerCDTitel = "";

                 korrekteCD = new CD(1000,100,15.00,
                                     korrekterCDInterpret,korrekterCDTitel,korrekteCDAnzahlTitel);

        }
 
    // Test der korrekten Faelle .
 
    @Test
    public void test_konstruktor_mit_korrektem_wert_fuer_interpret() {
        assertEquals(korrekterCDInterpret, korrekteCD.getInterpret());
    }
   
    @Test
    public void test_konstruktor_mit_korrektem_wert_fuer_titel() {
        assertEquals(korrekterCDTitel, korrekteCD.getTitel());
    }
  
    @Test
    public void test_konstruktor_mit_korrektem_wert_fuer_anzahltitel() {
        assertEquals(korrekteCDAnzahlTitel, korrekteCD.getAnzahlTitel());
    }
 
  
    @Test
    public void test_konstruktor_mit_korrekten_werten_auf_korrekteArtikelArt() {
        assertEquals(korrekteArtikelArt, korrekteCD.getArt());
    }
    
    // Test der Fehlerfaelle.
   
    
    @Test(expected = IllegalArgumentException.class)
    public void test_konstruktor_mit_CDInterpret_null() {
        new CD(1000, 100, 15.00,
                 korrekterCDTitel,nullCDInterpret,korrekteCDAnzahlTitel);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_konstruktor_mit_CDInterpret_leer() {
        new CD(1000, 100, 15.00,
                 korrekterCDTitel,leerCDInterpret,korrekteCDAnzahlTitel);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_konstruktor_mit_CDTitel_null() {
        new CD(1000,100,15.00,
                 nullCDTitel,korrekterCDInterpret,korrekteCDAnzahlTitel);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_konstruktor_mit_CDTitel_leer() {
        new CD(1000, 100,15.00,
                 leerCDTitel,korrekterCDInterpret,korrekteCDAnzahlTitel);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_konstruktor_mit_CDAnzahlTitel_null() {
        new CD(1000, 100, 15.00,
                 korrekterCDTitel,korrekterCDInterpret,nullCDAnzahlTitel);
    }
    
}
