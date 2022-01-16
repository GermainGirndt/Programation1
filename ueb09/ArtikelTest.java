import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
* Die Test-Klasse ArtikelTest.
*
 * @author  Girndt, Germain; Krier, Katharina
 * @version 1.0
*/
public class ArtikelTest
{
    // todo:
    // Test schreiben für
    //      mindestartikelnummer = 1000;
    //      buchenzugang = 0;
    //      buchenzugang = 1;
    // Testnamen standardizieren
    // Funktion {} standardizieren

    private Artikel artikel;
    private int[] testArtikelNr = {1000 , 9999, 1001, 3970, 9998};
    private String[] testArt    = {"Samsung Galaxy 7", "Kuhfutter", "4711", "Handyhuelle blau", "Test"};
    
    //KonstruktorTests    
    //Korrekte Fälle 
    /**
    * Korrekter Konstruktor Test gueltige Artikelnummer und Art
    * sonst Initialwerte
    */
    @Test
    public void test_Artikel_Konstruktor_gueltige_Artikelnr_sonst_0()
    {
        for (int gueltigeArtikelnr : testArtikelNr){
            for(String art : testArt){
                test_gueltige_ArtikelNr_sonst_0(gueltigeArtikelnr, art); 
            }
        }
    }
    
    /**
    * Korrekter Konstruktor Test gueltige Artikelnummer und Art und Preis
    * sonst Initialbestand
    */
    @Test
    public void test_Artikel_Konstruktor_gueltige_ArtikelNr_Mit_Preis_3_komma_5_ohne_Bestand()
    {
        for (int gueltigeArtikelnr : testArtikelNr){
            for(String art : testArt){
                 test_gueltige_ArtikelNr_Mit_Preis_3_komma_5_ohne_Bestand(gueltigeArtikelnr, art);
            }
           
        }
    }
    
    /**
    * Korrekter Konstruktor Test gueltige Artikelnummer und Art und Bestand
    * sonst Initialpreis
    */
    @Test
    public void test_Artikel_Konstruktor_gueltige_ArtikelNr_mit_Bestand_40_ohne_Preis()
    {
        for (int gueltigeArtikelnr : testArtikelNr){
            for (String art : testArt){
                 test_gueltige_ArtikelNr_mit_Bestand_40_ohne_Preis(gueltigeArtikelnr , art);
            }
            
        }
        
    }
    
    /**
    * Korrekter Konstruktor Test gueltige Artikelnummer und Art 
    * und Bestand und Preis
    */
     @Test
    public void test_Artikel_Konstruktor_gueltige_ArtikelNr_mit_Bestand_40_mit_Preis_3_komma_0()
    {
        
     for (int gueltigeArtikelnr  : testArtikelNr){
         for(String art : testArt){
             test_gueltige_ArtikelNr_mit_Bestand_40_mit_Preis_3_komma_0(gueltigeArtikelnr , art);
         }
     }

    }
    
    private void test_gueltige_ArtikelNr_sonst_0(int artikelNr, String art){
        int erwarteteNr      = artikelNr;   
        String erwarteteArt  = art;
        
        artikel              = new Artikel(artikelNr, art);
        
        assertEquals(erwarteteNr , artikel.getArtikelNr());
        ueberpruefeObPreisUndBestand0(artikel.getBestand(),artikel.getPreis());
        assertEquals(erwarteteArt, art);
        
    }
    
    private void test_gueltige_ArtikelNr_Mit_Preis_3_komma_5_ohne_Bestand(int artikelNr, String art){
        double erwarteterPreis     = 3.5;
        int   erwarteteNr          = artikelNr;  
        String erwarteteArt        = art;
        
        artikel                    = new Artikel(artikelNr, art, 0, 3.5);
        
        assertEquals(erwarteteNr , artikel.getArtikelNr());
        assertEquals(erwarteterPreis , artikel.getPreis(), 2* Double.MIN_VALUE);
        ueberpruefeObBestand0(artikel.getBestand());
        assertEquals(erwarteteArt, art);
    }

    private void test_gueltige_ArtikelNr_mit_Bestand_40_ohne_Preis(int artikelNr, String art){
        long erwarteterBestand     = 40;
        int   erwarteteNr          = artikelNr;   
        String erwarteteArt        = art;
        
        artikel                    = new Artikel(artikelNr, art, 40, 0);
        
        assertEquals(erwarteteNr , artikel.getArtikelNr());
        assertEquals(erwarteterBestand , artikel.getBestand());
        ueberpruefeObPreis0Komma0(artikel.getPreis());
        assertEquals(erwarteteArt, art);
    }
    
    private void test_gueltige_ArtikelNr_mit_Bestand_40_mit_Preis_3_komma_0(int artikelNr, String art){
        long erwarteterBestand     = 40;
        double erwarteterPreis     = 3.0;
        int   erwarteteNr          = artikelNr;  
        String erwarteteArt        = art;
        
        artikel                    = new Artikel(artikelNr, art, 40, 3.0);
        
        assertEquals(erwarteteNr , artikel.getArtikelNr());
        assertEquals(erwarteterBestand , artikel.getBestand());
        assertEquals(erwarteterPreis , artikel.getPreis(), 2* Double.MIN_VALUE);
        assertEquals(erwarteteArt, art);
    }
 
    //Fehlerfälle
    @Test 
    public void test_ArtikelNr_darf_nicht_fuenfstellig_sein_Artikel_Konstruktor_ArtikelNr_99999()
    {
        assertThrows(IllegalArgumentException.class, () -> {  new Artikel(99999, "Test");}); 
    }
    
    @Test 
    public void test_Art_darf_keine_besonderen_charaktere_enthalten_Artikel_Konstruktor_Artikelart_dollar()
    {
        assertThrows(IllegalArgumentException.class, () -> {  new Artikel(1234, "$");}); 
    }
    
    @Test 
    public void test_Art_darf_nicht_null_sein_Artikel_Konstruktor_Artikelart_null()
    {
        assertThrows(IllegalArgumentException.class, () -> {  new Artikel(1234, null);}); 
    }
    
    @Test 
    public void test_ArtikelNr_darf_nicht_negativ_sein_Artikel_Konstruktor_ArtikelNr_negative_3()
    {
        assertThrows(IllegalArgumentException.class, () -> { new Artikel(-3, "Test");}); 
    }
    
    @Test
    public void test_ArtikelNr_darf_nicht_0_sein_Artikel_Konstruktor_ArtikelNr_0()
    {
        assertThrows(IllegalArgumentException.class, () -> { new Artikel(0, "Test");}); 
    }
    
    @Test
    public void test_Bestand_darf_nicht_negativ_sein_Artikel_Konstruktor_Bestand_minus_1()
    {
        assertThrows(IllegalArgumentException.class, () -> { new Artikel(1, "Test", -1);}); 
    }
    
    @Test 
    public void test_Preis_darf_nicht_negativ_sein_Artikel_Konstruktor_preis_minus_1_komma_5()
    {
        assertThrows(IllegalArgumentException.class, () -> { new Artikel(1, "Test", 0, -1.5);}); 
    }
    
    //MethodenTest
    //Korrekte Fälle
    //Abgang
    
    /**
    * Korrekter bucheAbgang Test 
    * abgebucht wird 10 vom Bestand 20
    */
    @Test
    public void test_buche_Abgang_10_von_bestand_20_erwartet_10()
    {
        long erwarteterBestand      = 10;
        Artikel artikel             = new Artikel(1234, "Test", 20);
        artikel.bucheAbgang(10);
        long tatsaechlicherBestand  = artikel.getBestand();
        assertEquals(erwarteterBestand , tatsaechlicherBestand);
    }
    
    //zugang
    /**
    * Korrekter bucheZugang Test 
    * bucht 10 zum Bestand 0
    */
    @Test
    public void test_buche_Zugang_10_zu_bestand_0_erwartet_10()
    {
        long erwarteterBestand      = 10;
        Artikel artikel             = new Artikel(1234, "Test", 0);
        artikel.bucheZugang(10);
        long tatsaechlicherBestand  = artikel.getBestand();
        assertEquals(erwarteterBestand , tatsaechlicherBestand);
    }
    
    /**
    * Korrekter bucheZugang Test 
    * bucht 10 zum Bestand 5
    */
    @Test
    public void test_buche_Zugang_10_zu_bestand_5_erwartet_15()
    {
        long erwarteterBestand      = 15;
        Artikel artikel             = new Artikel(1234, "Test", 5);
        artikel.bucheZugang(10);
        long tatsaechlicherBestand  = artikel.getBestand();
        assertEquals(erwarteterBestand , tatsaechlicherBestand);
    }
    
    //Fehlerfälle
    //zugang
    @Test 
    public void test_keine_negative_uebergabe_buche_Zugang_uebergeben_minus_5()
    {
        Artikel artikel             = new Artikel(1234, "Test", 5);
        assertThrows(IllegalArgumentException.class, () -> {artikel.bucheZugang(-5);});
    }
    
    //abgang
    @Test 
    public void test_bestand_darf_nicht_negativ_werden_buche_Abgang_10_von_bestand_5()
    {
        Artikel artikel             = new Artikel(1234, "Test", 5);
        assertThrows(IllegalArgumentException.class, () -> {artikel.bucheAbgang(10);});
    }
    
    @Test 
    public void test_keine_negative_uebergabe_buche_Abgang_uebergeben_minus_5()
    {
        Artikel artikel             = new Artikel(1234, "Test", 5);
        assertThrows(IllegalArgumentException.class, () -> {artikel.bucheAbgang(-5);});
    }

    
    private void ueberpruefeObBestand0(long bestand){
        assertEquals(0 , bestand);    
    }
    
    
    private void ueberpruefeObPreis0Komma0(double preis){
       assertEquals(0.0 , preis , 2* Double.MIN_VALUE);  
    }
    
    private void ueberpruefeObPreisUndBestand0(long bestand, double preis){
       ueberpruefeObBestand0(bestand);
       ueberpruefeObPreis0Komma0(preis);
    }
    
}


