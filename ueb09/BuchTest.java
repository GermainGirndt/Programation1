import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Die Klasse BuchTest testet die Buch-Klasse
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class BuchTest {

    // Standardattribute
    private final String standardart = "Medien";

    // gueltige Argumente
    private final int artikelNr = 1000;
    private final int bestand = 0;
    private final double preis = 0.0;
    private final String autor = "Goethe";
    private final String titel = "Faust";
    private final String verlag = "Reclam";
   
    private Buch gueltigesBuch;

    @BeforeEach
    public void setUp() {
        this.gueltigesBuch = new Buch(this.artikelNr, this.bestand, this.preis, this.autor, this.titel, this.verlag);
    }
    
    @Test
    public void kann_ein_gueltiges_Buch_instanzieren() {

        assertEquals(this.gueltigesBuch.getArt(), this.standardart);

        assertEquals(this.gueltigesBuch.getArtikelNr(), this.artikelNr);
        assertEquals(this.gueltigesBuch.getBestand(), this.bestand);
        assertEquals(this.gueltigesBuch.getPreis(), this.preis);
        assertEquals(this.gueltigesBuch.getAutor(), this.autor);
        assertEquals(this.gueltigesBuch.getTitel(), this.titel);
        assertEquals(this.gueltigesBuch.getVerlag(), this.verlag);
    }

    @Test
    public void ist_Eine_Unterklasse_Von_Artikel() {

        assert(Artikel.class.isInstance(this.gueltigesBuch));
    }
   
    /**
     * 
     * Tests für Konstruktor-Validierung
     */

    @Test
    public void kann_nicht_instanzieren_mit_null_Autor() {
        String autor = null;

        assertThrows(IllegalArgumentException.class, () -> {  
            new Buch(this.artikelNr, this.bestand, this.preis, autor, this.titel, this.verlag);
        });    
    }

    @Test
    public void kann_nicht_instanzieren_mit_leerem_Autor() {
        String leererAutorEins = "";
        String leererAutorZwei = " ";
        String leererAutorDrei = "  ";

        assertThrows(IllegalArgumentException.class, () -> {  
            new Buch(this.artikelNr, this.bestand, this.preis, leererAutorEins, this.titel, this.verlag);
        });    
        assertThrows(IllegalArgumentException.class, () -> {  
            new Buch(this.artikelNr, this.bestand, this.preis, leererAutorZwei, this.titel, this.verlag);
        });    
        assertThrows(IllegalArgumentException.class, () -> {  
            new Buch(this.artikelNr, this.bestand, this.preis, leererAutorDrei, this.titel, this.verlag);
        });    
    }

    @Test
    public void kann_nicht_instanzieren_mit_null_Titel() {
        String titel = null;

        assertThrows(IllegalArgumentException.class, () -> {  
            new Buch(this.artikelNr, this.bestand, this.preis, this.autor, titel, this.verlag);
        });    
    }

    @Test
    public void kann_nicht_instanzieren_mit_leerem_Titel() {
        String leererTitelEins = "";
        String leererTitelZwei = " ";
        String leererTitelDrei = "  ";

        assertThrows(IllegalArgumentException.class, () -> {  
            new Buch(this.artikelNr, this.bestand, this.preis, this.autor, leererTitelEins, this.verlag);
        });    
        assertThrows(IllegalArgumentException.class, () -> {  
            new Buch(this.artikelNr, this.bestand, this.preis, this.autor, leererTitelZwei, this.verlag);
        });    
        assertThrows(IllegalArgumentException.class, () -> {  
            new Buch(this.artikelNr, this.bestand, this.preis, this.autor, leererTitelDrei, this.verlag);
        });    
    }

    @Test
    public void kann_nicht_instanzieren_mit_null_Verlag() {
        String verlag = null;

        assertThrows(IllegalArgumentException.class, () -> {  
            new Buch(this.artikelNr, this.bestand, this.preis, this.autor, this.titel, verlag);
        });    
    }

    @Test
    public void kann_nicht_instanzieren_mit_leerem_Verlag() {
        String leererVerlagEins = "";
        String leererVerlagZwei = " ";
        String leererVerlagDrei = "  ";

        assertThrows(IllegalArgumentException.class, () -> {  
            new Buch(this.artikelNr, this.bestand, this.preis, this.autor, this.titel, leererVerlagEins);
        });    
        assertThrows(IllegalArgumentException.class, () -> {  
            new Buch(this.artikelNr, this.bestand, this.preis, this.autor, this.titel, leererVerlagZwei);
        });    
        assertThrows(IllegalArgumentException.class, () -> {  
            new Buch(this.artikelNr, this.bestand, this.preis, this.autor, this.titel, leererVerlagDrei);
        });    
    }

    /**
     * 
     * Tests für die .equals()-Methode
     */

    @Test
    public void equals_Methode_mit_demselben_Objekt_ergibt_true() {
        assert(this.gueltigesBuch.equals(this.gueltigesBuch));
    }

    @Test
    public void equals_Methode_mit_einem_gleichen_Objekt_ergibt_true() {
        Buch gleichesBuch = new Buch(this.artikelNr, this.bestand, this.preis, this.autor, this.titel, this.verlag);
        
        assert(this.gueltigesBuch.equals(gleichesBuch));
    }
    
    @Test
    public void equals_Methode_mit_einem_null_Objekt_ergibt_falsch() {
        assert(!this.gueltigesBuch.equals(null));
    }
    
    @Test
    public void equals_Methode_mit_einer_unterschiedlichen_Artikelnummer_ergibt_falsch() {
        Buch buchMitEinemAnderenArtikelNummer = new Buch(2122, this.bestand, this.preis, this.autor, this.titel, this.verlag);
        
        assert(!this.gueltigesBuch.equals(buchMitEinemAnderenArtikelNummer));
    }

    @Test
    public void equals_Methode_mit_einem_unterschiedlichen_Bestand_ergibt_falsch() {
        Buch buchMitEinemAnderenBestand = new Buch(this.artikelNr, 99, this.preis, this.autor, this.titel, this.verlag);
        
        assert(!this.gueltigesBuch.equals(buchMitEinemAnderenBestand));
    }

    @Test
    public void equals_Methode_mit_einem_unterschiedlichen_Preis_ergibt_falsch() {
        Buch buchMitEinemAnderenPreis = new Buch(this.artikelNr, this.bestand, 42.42, this.autor, this.titel, this.verlag);
        
        assert(!this.gueltigesBuch.equals(buchMitEinemAnderenPreis));
    }

    @Test
    public void equals_Methode_mit_einem_unterschiedlichen_Autor_ergibt_falsch() {
        Buch buchMitEinemAnderenAutor = new Buch(this.artikelNr, this.bestand, this.preis, "Schiller", this.titel, this.verlag);
        
        assert(!this.gueltigesBuch.equals(buchMitEinemAnderenAutor));
    }

    @Test
    public void equals_Methode_mit_einem_unterschiedlichen_Titel_ergibt_falsch() {
        Buch buchMitEinemAnderenTitel = new Buch(this.artikelNr, this.bestand, this.preis, this.autor, "Wer bin ich und wenn ja wie viele", this.verlag);
        
        assert(!this.gueltigesBuch.equals(buchMitEinemAnderenTitel));
    }

    @Test
    public void equals_Methode_mit_einem_unterschiedlichen_Verlag_ergibt_falsch() {
        Buch buchMitEinemAnderenVerlag = new Buch(this.artikelNr, this.bestand, this.preis, this.autor, this.titel, "JurisPodium");
        
        assert(!this.gueltigesBuch.equals(buchMitEinemAnderenVerlag));
    }

    /**
    * 
    * Tests für die .hashCode()-Methode
    *
    */

    @Test
    public void hashCode_ist_gleich_fuer_dasselbe_Objekt() {

        int ersterHashcode = this.gueltigesBuch.hashCode();

        int zweiterHashcode = this.gueltigesBuch.hashCode();
        
        assert(ersterHashcode == zweiterHashcode);
    }
    
    @Test
    public void hashCodeVergleich_mit_einer_unterschiedlichen_Artikelnummer_ergibt_falsch() {
        Buch buchMitEinemAnderenArtikelNummer = new Buch(2122, this.bestand, this.preis, this.autor, this.titel, this.verlag);
        
        int ersterHashcode = this.gueltigesBuch.hashCode();

        int zweiterHashcode = buchMitEinemAnderenArtikelNummer.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }

    @Test
    public void hashCodeVergleich_mit_einem_unterschiedlichen_Bestand_ergibt_falsch() {
        Buch buchMitEinemAnderenBestand = new Buch(this.artikelNr, 99, this.preis, this.autor, this.titel, this.verlag);
        
        int ersterHashcode = this.gueltigesBuch.hashCode();

        int zweiterHashcode = buchMitEinemAnderenBestand.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }

    @Test
    public void hashCodeVergleich_mit_einem_unterschiedlichen_Preis_ergibt_falsch() {
        Buch buchMitEinemAnderenPreis = new Buch(this.artikelNr, this.bestand, 42.42, this.autor, this.titel, this.verlag);
        
        int ersterHashcode = this.gueltigesBuch.hashCode();

        int zweiterHashcode = buchMitEinemAnderenPreis.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }

    @Test
    public void hashCodeVergleich_mit_einem_unterschiedlichen_Autor_ergibt_falsch() {
        Buch buchMitEinemAnderenAutor = new Buch(this.artikelNr, this.bestand, this.preis, "Schiller", this.titel, this.verlag);
        
        int ersterHashcode = this.gueltigesBuch.hashCode();

        int zweiterHashcode = buchMitEinemAnderenAutor.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }

    @Test
    public void hashCodeVergleich_mit_einem_unterschiedlichen_Titel_ergibt_falsch() {
        Buch buchMitEinemAnderenTitel = new Buch(this.artikelNr, this.bestand, this.preis, this.autor, "Wer bin ich und wenn ja wie viele", this.verlag);
        
        int ersterHashcode = this.gueltigesBuch.hashCode();

        int zweiterHashcode = buchMitEinemAnderenTitel.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }

    @Test
    public void hashCodeVergleich_mit_einem_unterschiedlichen_Verlag_ergibt_falsch() {
        Buch buchMitEinemAnderenVerlag = new Buch(this.artikelNr, this.bestand, this.preis, this.autor, this.titel, "JurisPodium");
        
        int ersterHashcode = this.gueltigesBuch.hashCode();

        int zweiterHashcode = buchMitEinemAnderenVerlag.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }
}
