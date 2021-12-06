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
    private Artikel artikel;
    private int[] testArtikelNr = {1 , 9999, 1234, 397, 9863};
    //KonstruktorTests    
    //Korrekte Fälle 
    @Test
    public void test_Artikel_Konstruktor_gueltige_Artikelnr_sonst_0()
    {
        for (int gueltigeArtikelnr : testArtikelNr){
            test_gueltige_ArtikelNr_sonst_0(gueltigeArtikelnr);
        }
    }
    
    @Test
    public void test_Artikel_Konstruktor_gueltige_ArtikelNr_Mit_Preis_3_komma_5_ohne_Bestand()
    {
        for (int gueltigeArtikelnr : testArtikelNr){
            test_gueltige_ArtikelNr_Mit_Preis_3_komma_5_ohne_Bestand(gueltigeArtikelnr );
        }
    }
    
    @Test
    public void test_Artikel_Konstruktor_gueltige_ArtikelNr_mit_Bestand_40_ohne_Preis()
    {
        for (int gueltigeArtikelnr : testArtikelNr){
            test_gueltige_ArtikelNr_mit_Bestand_40_ohne_Preis(gueltigeArtikelnr );
        }
        
    }
    
     @Test
    public void test_Artikel_Konstruktor_gueltige_ArtikelNr_mit_Bestand_40_mit_Preis_3_komma_0()
    {
        
     for (int gueltigeArtikelnr  : testArtikelNr){
         test_gueltige_ArtikelNr_mit_Bestand_40_mit_Preis_3_komma_0(gueltigeArtikelnr );
     }

    }
    
    private void test_gueltige_ArtikelNr_sonst_0(int artikelNr){
        int erwarteteNr      = artikelNr;   
        
        artikel              = new Artikel(artikelNr, "Test");
        
        assertEquals(erwarteteNr , artikel.getArtikelNr());
        ueberpruefeObPreisUndBestand0(artikel.getBestand(),artikel.getPreis());
    }
    
    private void test_gueltige_ArtikelNr_Mit_Preis_3_komma_5_ohne_Bestand(int artikelNr){
        double erwarteterPreis     = 3.5;
        int   erwarteteNr          = artikelNr;   
        
        artikel                    = new Artikel(artikelNr, "Test", 0, 3.5);
        
        assertEquals(erwarteteNr , artikel.getArtikelNr());
        assertEquals(erwarteterPreis , artikel.getPreis(), 2* Double.MIN_VALUE);
        ueberpruefeObBestand0(artikel.getBestand());
    }

    private void test_gueltige_ArtikelNr_mit_Bestand_40_ohne_Preis(int artikelNr){
        long erwarteterBestand     = 40;
        int   erwarteteNr          = artikelNr;   
        
        artikel                    = new Artikel(artikelNr, "Test", 40, 0);
        
        assertEquals(erwarteteNr , artikel.getArtikelNr());
        assertEquals(erwarteterBestand , artikel.getBestand());
        ueberpruefeObPreis0Komma0(artikel.getPreis());
    }
    
    private void test_gueltige_ArtikelNr_mit_Bestand_40_mit_Preis_3_komma_0(int artikelNr){
        long erwarteterBestand     = 40;
        double erwarteterPreis     = 3.0;
        int   erwarteteNr          = artikelNr;   
        
        artikel                    = new Artikel(artikelNr, "Test", 40, 3.0);
        
        assertEquals(erwarteteNr , artikel.getArtikelNr());
        assertEquals(erwarteterBestand , artikel.getBestand());
        assertEquals(erwarteterPreis , artikel.getPreis(), 2* Double.MIN_VALUE);
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
    @Test
    public void test_buche_Zugang_10_zu_bestand_0_erwartet_10()
    {
        long erwarteterBestand      = 10;
        Artikel artikel             = new Artikel(1234, "Test", 0);
        artikel.bucheZugang(10);
        long tatsaechlicherBestand  = artikel.getBestand();
        assertEquals(erwarteterBestand , tatsaechlicherBestand);
    }
    
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


