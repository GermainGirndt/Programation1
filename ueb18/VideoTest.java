import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Die Klasse VideoTest testet die Video-Klasse
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class VideoTest {

    // Standardattribute
    private final String standardart = "Medien";

    // gueltige Argumente
    private final int artikelNr = 1000;
    private final int bestand = 0;
    private final double preis = 0.0;
    private final String titel = "Meteora";
    private final int spieldauer = 10;
    private final int jahr = 1900;
    private final int alternativesJahr = 2022;
   
    private Video gueltigesVideo;
    private Video alternativesgueltigesVideo;

    @BeforeEach
    public void setUp() {
        this.gueltigesVideo = new Video(this.artikelNr, this.bestand, this.preis, this.titel, this.spieldauer, this.jahr);
        this.alternativesgueltigesVideo = new Video(this.artikelNr, this.bestand, this.preis, this.titel, this.spieldauer, this.alternativesJahr);
    }
    
    @Test
    public void kann_ein_gueltiges_Video_instanzieren() {

        assertEquals(this.gueltigesVideo.getArt(), this.standardart);

        assertEquals(this.gueltigesVideo.getArtikelNr(), this.artikelNr);
        assertEquals(this.gueltigesVideo.getBestand(), this.bestand);
        assertEquals(this.gueltigesVideo.getPreis(), this.preis);
        assertEquals(this.gueltigesVideo.getSpieldauer(), this.spieldauer);
        assertEquals(this.gueltigesVideo.getTitel(), this.titel);
        assertEquals(this.gueltigesVideo.getJahr(), this.jahr);
    }

    @Test
    public void kann_ein_gueltiges_Video_instanzieren_mit_anderer_Jahresgrenze() {

        assertEquals(this.alternativesgueltigesVideo.getArt(), this.standardart);

        assertEquals(this.alternativesgueltigesVideo.getArtikelNr(), this.artikelNr);
        assertEquals(this.alternativesgueltigesVideo.getBestand(), this.bestand);
        assertEquals(this.alternativesgueltigesVideo.getPreis(), this.preis);
        assertEquals(this.alternativesgueltigesVideo.getSpieldauer(), this.spieldauer);
        assertEquals(this.alternativesgueltigesVideo.getTitel(), this.titel);
        assertEquals(this.alternativesgueltigesVideo.getJahr(), this.jahr);
    }

    @Test
    public void ist_Eine_Unterklasse_Von_Artikel() {

        assert(Artikel.class.isInstance(this.gueltigesVideo));
    }
   
    /**
     * 
     * Tests für Konstruktor-Validierung
     */

    @Test
    public void kann_nicht_instanzieren_mit_null_Spieldauer() {
        int spieldauer = 0;

        assertThrows(IllegalArgumentException.class, () -> {  
            new Video(this.artikelNr, this.bestand, this.preis, this.titel, 0, this.jahr);
        });    
    }

    @Test
    public void kann_nicht_instanzieren_mit_null_Titel() {
        String titel = null;

        assertThrows(IllegalArgumentException.class, () -> {  
            new Video(this.artikelNr, this.bestand, this.preis, titel, this.spieldauer, this.jahr);
        });    
    }

    @Test
    public void kann_nicht_instanzieren_mit_leerem_Titel() {
        String leererTitelEins = "";
        String leererTitelZwei = " ";
        String leererTitelDrei = "  ";

        assertThrows(IllegalArgumentException.class, () -> {  
            new Video(this.artikelNr, this.bestand, this.preis, leererTitelEins, this.spieldauer, this.jahr);
        });    
        assertThrows(IllegalArgumentException.class, () -> {  
            new Video(this.artikelNr, this.bestand, this.preis, leererTitelZwei, this.spieldauer, this.jahr);
        });    
        assertThrows(IllegalArgumentException.class, () -> {  
            new Video(this.artikelNr, this.bestand, this.preis, leererTitelDrei, this.spieldauer, this.jahr);
        });    
    }

    @Test
    public void kann_nicht_instanzieren_mit_null_Jahr() {
        assertThrows(IllegalArgumentException.class, () -> {  
            new Video(this.artikelNr, this.bestand, this.preis, this.titel, this.spieldauer, 0);
        });       
    }

    @Test
    public void kann_nicht_instanzieren_mit_1899_Jahr() {
        assertThrows(IllegalArgumentException.class, () -> {  
            new Video(this.artikelNr, this.bestand, this.preis, this.titel, this.spieldauer, 1899);
        });       
    }

    @Test
    public void kann_nicht_instanzieren_mit_2023_Jahr() {
        assertThrows(IllegalArgumentException.class, () -> {  
            new Video(this.artikelNr, this.bestand, this.preis, this.titel, this.spieldauer, 2023);
        });       
    }

    /**
     * 
     * Tests für die .equals()-Methode
     */

    @Test
    public void equals_Methode_mit_demselben_Objekt_ergibt_true() {
        assert(this.gueltigesVideo.equals(this.gueltigesVideo));
    }

    @Test
    public void equals_Methode_mit_einem_gleichen_Objekt_ergibt_true() {
        Video gleichesVideo = new Video(this.artikelNr, this.bestand, this.preis, this.titel, this.spieldauer, this.jahr);
        
        assert(this.gueltigesVideo.equals(gleichesVideo));
    }
    
    @Test
    public void equals_Methode_mit_einem_null_Objekt_ergibt_falsch() {
        assert(!this.gueltigesVideo.equals(null));
    }
    
    @Test
    public void equals_Methode_mit_einer_unterschiedlichen_Artikelnummer_ergibt_falsch() {
        Video videoMitEinemAnderenArtikelNummer = new Video(2122, this.bestand, this.preis, this.titel, this.spieldauer, this.jahr);
        
        assert(!this.gueltigesVideo.equals(videoMitEinemAnderenArtikelNummer));
    }

    @Test
    public void equals_Methode_mit_einem_unterschiedlichen_Bestand_ergibt_falsch() {
        Video videoMitEinemAnderenBestand = new Video(this.artikelNr, 99, this.preis, this.titel, this.spieldauer, this.jahr);
        
        assert(!this.gueltigesVideo.equals(videoMitEinemAnderenBestand));
    }

    @Test
    public void equals_Methode_mit_einem_unterschiedlichen_Preis_ergibt_falsch() {
        Video videoMitEinemAnderenPreis = new Video(this.artikelNr, this.bestand, 42.42, this.titel, this.spieldauer, this.jahr);
        
        assert(!this.gueltigesVideo.equals(videoMitEinemAnderenPreis));
    }

    @Test
    public void equals_Methode_mit_einem_unterschiedlichen_Spieldauer_ergibt_falsch() {
        Video videoMitEinemAnderenSpieldauer = new Video(this.artikelNr, this.bestand, this.preis, this.titel, 4646, this.jahr);
        
        assert(!this.gueltigesVideo.equals(videoMitEinemAnderenSpieldauer));
    }

    @Test
    public void equals_Methode_mit_einem_unterschiedlichen_Titel_ergibt_falsch() {
        Video videoMitEinemAnderenTitel = new Video(this.artikelNr, this.bestand, this.preis, "Wer bin ich und wenn ja wie viele", this.spieldauer, this.jahr);
        
        assert(!this.gueltigesVideo.equals(videoMitEinemAnderenTitel));
    }

    @Test
    public void equals_Methode_mit_einem_unterschiedlichen_Jahr_ergibt_falsch() {
        Video videoMitEinemAnderenJahr = new Video(this.artikelNr, this.bestand, this.preis, this.titel, this.spieldauer, 2002);
        
        assert(!this.gueltigesVideo.equals(videoMitEinemAnderenJahr));
    }

    /**
    * 
    * Tests für die .hashCode()-Methode
    *
    */

    @Test
    public void hashCode_ist_gleich_fuer_dasselbe_Objekt() {

        int ersterHashcode = this.gueltigesVideo.hashCode();

        int zweiterHashcode = this.gueltigesVideo.hashCode();
        
        assert(ersterHashcode == zweiterHashcode);
    }
    
    @Test
    public void hashCodeVergleich_mit_einer_unterschiedlichen_Artikelnummer_ergibt_falsch() {
        Video videoMitEinemAnderenArtikelNummer = new Video(2122, this.bestand, this.preis, this.titel, this.spieldauer, this.jahr);
        
        int ersterHashcode = this.gueltigesVideo.hashCode();

        int zweiterHashcode = videoMitEinemAnderenArtikelNummer.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }

    @Test
    public void hashCodeVergleich_mit_einem_unterschiedlichen_Bestand_ergibt_falsch() {
        Video videoMitEinemAnderenBestand = new Video(this.artikelNr, 99, this.preis, this.titel, this.spieldauer, this.jahr);
        
        int ersterHashcode = this.gueltigesVideo.hashCode();

        int zweiterHashcode = videoMitEinemAnderenBestand.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }

    @Test
    public void hashCodeVergleich_mit_einem_unterschiedlichen_Preis_ergibt_falsch() {
        Video videoMitEinemAnderenPreis = new Video(this.artikelNr, this.bestand, 42.42, this.titel, this.spieldauer, this.jahr);
        
        int ersterHashcode = this.gueltigesVideo.hashCode();

        int zweiterHashcode = videoMitEinemAnderenPreis.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }

    @Test
    public void hashCodeVergleich_mit_einem_unterschiedlichen_Spieldauer_ergibt_falsch() {
        Video videoMitEinemAnderenSpieldauer = new Video(this.artikelNr, this.bestand, this.preis, this.titel, 4687, this.jahr);
        
        int ersterHashcode = this.gueltigesVideo.hashCode();

        int zweiterHashcode = videoMitEinemAnderenSpieldauer.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }

    @Test
    public void hashCodeVergleich_mit_einem_unterschiedlichen_Titel_ergibt_falsch() {
        Video videoMitEinemAnderenTitel = new Video(this.artikelNr, this.bestand, this.preis, "Wer bin ich und wenn ja wie viele", this.spieldauer, this.jahr);
        
        int ersterHashcode = this.gueltigesVideo.hashCode();

        int zweiterHashcode = videoMitEinemAnderenTitel.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }

    @Test
    public void hashCodeVergleich_mit_einem_unterschiedlichen_Jahr_ergibt_falsch() {
        Video videoMitEinemAnderenJahr = new Video(this.artikelNr, this.bestand, this.preis, this.titel, this.spieldauer, 2001);
        
        int ersterHashcode = this.gueltigesVideo.hashCode();

        int zweiterHashcode = videoMitEinemAnderenJahr.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }
}
