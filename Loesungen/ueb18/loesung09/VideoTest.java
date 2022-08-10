

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VideoTest {

        private String korrekterVideoTitel, korrekteArtikelArt;
        private int korrekteVideoSpieldauer;
        private int korrektesVideoErscheinungsjahr;
        private String nullVideoTitel;
        private int nullVideoSpieldauer;
        private String leerVideoTitel;
        private int minMinusEinsErscheinungsjahr, maxPlusEinsErscheinungsjahr;

        private Video korrektesVideo;
        

        @Before
        public void setUp() {
                 korrekterVideoTitel = new String("Sprechen Sie Java?");
                 korrekteArtikelArt  = "Medien";
                 korrekteVideoSpieldauer = 130;
                 korrektesVideoErscheinungsjahr = 1989;
                 
                 nullVideoTitel = null;
                 nullVideoSpieldauer = 0;
                 
                 leerVideoTitel = "";
                 minMinusEinsErscheinungsjahr = 1899;
                 maxPlusEinsErscheinungsjahr = 2023;

                 korrektesVideo = new Video(1000,100,45.45,
                                     korrekterVideoTitel,korrekteVideoSpieldauer,korrektesVideoErscheinungsjahr);

        }
 
    // Test der korrekten Faelle .
 
    @Test
    public void test_konstruktor_mit_korrektem_wert_fuer_titel() {
        assertEquals(korrekterVideoTitel, korrektesVideo.getTitel());
    }
   
    @Test
    public void test_konstruktor_mit_korrektem_wert_fuer_spieldauer() {
        assertEquals(korrekteVideoSpieldauer, korrektesVideo.getSpieldauer(), 1.0e-03);
    }
  
    @Test
    public void test_konstruktor_mit_korrektem_wert_fuer_erscheinungsjahr() {
        assertEquals(korrektesVideoErscheinungsjahr, korrektesVideo.getJahr());
    }
  
    @Test
    public void test_konstruktor_mit_korrekten_werten_auf_korrekteArtikelArt() {
        assertEquals(korrekteArtikelArt, korrektesVideo.getArt());
    }
 
    
    // Test der Fehlerfaelle.
   
    public void test_konstruktor_mit_VideoTitel_null() {
        new Video(1000,100,45.45,
                 nullVideoTitel,korrekteVideoSpieldauer,korrektesVideoErscheinungsjahr);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_konstruktor_mit_VideoTitel_leer() {
        new Video(1000, 100,45.45,
                 leerVideoTitel,korrekteVideoSpieldauer,korrektesVideoErscheinungsjahr);
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void test_konstruktor_mit_VideoSpieldauer_null() {
        new Video(1000, 100, 45.45,
                 korrekterVideoTitel,nullVideoSpieldauer,korrektesVideoErscheinungsjahr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_konstruktor_mit_minMinusEinsErscheinungsjahr() {
        new Video(1000, 100, 45.45,
                 korrekterVideoTitel,korrekteVideoSpieldauer,minMinusEinsErscheinungsjahr);
    }
    

    @Test(expected = IllegalArgumentException.class)
    public void test_konstruktor_mit_maxPlusEinsErscheinungsjahr() {
        new Video(1000, 100, 45.45,
                 korrekterVideoTitel,korrekteVideoSpieldauer,maxPlusEinsErscheinungsjahr);
    }
    
}
