import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Die Klasse CDTest testet die CD-Klasse
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class CDTest {

    // Standardattribute
    private final String standardart = "Medien";

    // gueltige Argumente
    private final int artikelNr = 1000;
    private final int bestand = 0;
    private final double preis = 0.0;
    private final String interpret = "Linking Park";
    private final String titel = "Meteora";
    private final int anzahlTitel = 11;
   
    private CD gueltigesCD;

    @BeforeEach
    public void setUp() {
        this.gueltigesCD = new CD(this.artikelNr, this.bestand, this.preis, this.interpret, this.titel, this.anzahlTitel);
    }
    
    @Test
    public void kann_ein_gueltiges_CD_instanzieren() {

        assertEquals(this.gueltigesCD.getArt(), this.standardart);

        assertEquals(this.gueltigesCD.getArtikelNr(), this.artikelNr);
        assertEquals(this.gueltigesCD.getBestand(), this.bestand);
        assertEquals(this.gueltigesCD.getPreis(), this.preis);
        assertEquals(this.gueltigesCD.getInterpret(), this.interpret);
        assertEquals(this.gueltigesCD.getTitel(), this.titel);
        assertEquals(this.gueltigesCD.getAnzahlTitel(), this.anzahlTitel);
    }

    @Test
    public void ist_Eine_Unterklasse_Von_Artikel() {

        assert(Artikel.class.isInstance(this.gueltigesCD));
    }
   
    /**
     * 
     * Tests für Konstruktor-Validierung
     */

    @Test
    public void kann_nicht_instanzieren_mit_null_Interpret() {
        String interpret = null;

        assertThrows(IllegalArgumentException.class, () -> {  
            new CD(this.artikelNr, this.bestand, this.preis, interpret, this.titel, this.anzahlTitel);
        });    
    }

    @Test
    public void kann_nicht_instanzieren_mit_leerem_Interpret() {
        String leererInterpretEins = "";
        String leererInterpretZwei = " ";
        String leererInterpretDrei = "  ";

        assertThrows(IllegalArgumentException.class, () -> {  
            new CD(this.artikelNr, this.bestand, this.preis, leererInterpretEins, this.titel, this.anzahlTitel);
        });    
        assertThrows(IllegalArgumentException.class, () -> {  
            new CD(this.artikelNr, this.bestand, this.preis, leererInterpretZwei, this.titel, this.anzahlTitel);
        });    
        assertThrows(IllegalArgumentException.class, () -> {  
            new CD(this.artikelNr, this.bestand, this.preis, leererInterpretDrei, this.titel, this.anzahlTitel);
        });    
    }

    @Test
    public void kann_nicht_instanzieren_mit_null_Titel() {
        String titel = null;

        assertThrows(IllegalArgumentException.class, () -> {  
            new CD(this.artikelNr, this.bestand, this.preis, this.interpret, titel, this.anzahlTitel);
        });    
    }

    @Test
    public void kann_nicht_instanzieren_mit_leerem_Titel() {
        String leererTitelEins = "";
        String leererTitelZwei = " ";
        String leererTitelDrei = "  ";

        assertThrows(IllegalArgumentException.class, () -> {  
            new CD(this.artikelNr, this.bestand, this.preis, this.interpret, leererTitelEins, this.anzahlTitel);
        });    
        assertThrows(IllegalArgumentException.class, () -> {  
            new CD(this.artikelNr, this.bestand, this.preis, this.interpret, leererTitelZwei, this.anzahlTitel);
        });    
        assertThrows(IllegalArgumentException.class, () -> {  
            new CD(this.artikelNr, this.bestand, this.preis, this.interpret, leererTitelDrei, this.anzahlTitel);
        });    
    }

    @Test
    public void kann_nicht_instanzieren_mit_null_AnzahlTitel() {
        assertThrows(IllegalArgumentException.class, () -> {  
            new CD(this.artikelNr, this.bestand, this.preis, this.interpret, this.titel, 0);
        });       
    }

    /**
     * 
     * Tests für die .equals()-Methode
     */

    @Test
    public void equals_Methode_mit_demselben_Objekt_ergibt_true() {
        assert(this.gueltigesCD.equals(this.gueltigesCD));
    }

    @Test
    public void equals_Methode_mit_einem_gleichen_Objekt_ergibt_true() {
        CD gleichesCD = new CD(this.artikelNr, this.bestand, this.preis, this.interpret, this.titel, this.anzahlTitel);
        
        assert(this.gueltigesCD.equals(gleichesCD));
    }
    
    @Test
    public void equals_Methode_mit_einem_null_Objekt_ergibt_falsch() {
        assert(!this.gueltigesCD.equals(null));
    }
    
    @Test
    public void equals_Methode_mit_einer_unterschiedlichen_Artikelnummer_ergibt_falsch() {
        CD cdMitEinemAnderenArtikelNummer = new CD(2122, this.bestand, this.preis, this.interpret, this.titel, this.anzahlTitel);
        
        assert(!this.gueltigesCD.equals(cdMitEinemAnderenArtikelNummer));
    }

    @Test
    public void equals_Methode_mit_einem_unterschiedlichen_Bestand_ergibt_falsch() {
        CD cdMitEinemAnderenBestand = new CD(this.artikelNr, 99, this.preis, this.interpret, this.titel, this.anzahlTitel);
        
        assert(!this.gueltigesCD.equals(cdMitEinemAnderenBestand));
    }

    @Test
    public void equals_Methode_mit_einem_unterschiedlichen_Preis_ergibt_falsch() {
        CD cdMitEinemAnderenPreis = new CD(this.artikelNr, this.bestand, 42.42, this.interpret, this.titel, this.anzahlTitel);
        
        assert(!this.gueltigesCD.equals(cdMitEinemAnderenPreis));
    }

    @Test
    public void equals_Methode_mit_einem_unterschiedlichen_Interpret_ergibt_falsch() {
        CD cdMitEinemAnderenInterpret = new CD(this.artikelNr, this.bestand, this.preis, "Schiller", this.titel, this.anzahlTitel);
        
        assert(!this.gueltigesCD.equals(cdMitEinemAnderenInterpret));
    }

    @Test
    public void equals_Methode_mit_einem_unterschiedlichen_Titel_ergibt_falsch() {
        CD cdMitEinemAnderenTitel = new CD(this.artikelNr, this.bestand, this.preis, this.interpret, "Wer bin ich und wenn ja wie viele", this.anzahlTitel);
        
        assert(!this.gueltigesCD.equals(cdMitEinemAnderenTitel));
    }

    @Test
    public void equals_Methode_mit_einem_unterschiedlichen_AnzahlTitel_ergibt_falsch() {
        CD cdMitEinemAnderenAnzahlTitel = new CD(this.artikelNr, this.bestand, this.preis, this.interpret, this.titel, 5555);
        
        assert(!this.gueltigesCD.equals(cdMitEinemAnderenAnzahlTitel));
    }

    /**
    * 
    * Tests für die .hashCode()-Methode
    *
    */

    @Test
    public void hashCode_ist_gleich_fuer_dasselbe_Objekt() {

        int ersterHashcode = this.gueltigesCD.hashCode();

        int zweiterHashcode = this.gueltigesCD.hashCode();
        
        assert(ersterHashcode == zweiterHashcode);
    }
    
    @Test
    public void hashCodeVergleich_mit_einer_unterschiedlichen_Artikelnummer_ergibt_falsch() {
        CD cdMitEinemAnderenArtikelNummer = new CD(2122, this.bestand, this.preis, this.interpret, this.titel, this.anzahlTitel);
        
        int ersterHashcode = this.gueltigesCD.hashCode();

        int zweiterHashcode = cdMitEinemAnderenArtikelNummer.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }

    @Test
    public void hashCodeVergleich_mit_einem_unterschiedlichen_Bestand_ergibt_falsch() {
        CD cdMitEinemAnderenBestand = new CD(this.artikelNr, 99, this.preis, this.interpret, this.titel, this.anzahlTitel);
        
        int ersterHashcode = this.gueltigesCD.hashCode();

        int zweiterHashcode = cdMitEinemAnderenBestand.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }

    @Test
    public void hashCodeVergleich_mit_einem_unterschiedlichen_Preis_ergibt_falsch() {
        CD cdMitEinemAnderenPreis = new CD(this.artikelNr, this.bestand, 42.42, this.interpret, this.titel, this.anzahlTitel);
        
        int ersterHashcode = this.gueltigesCD.hashCode();

        int zweiterHashcode = cdMitEinemAnderenPreis.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }

    @Test
    public void hashCodeVergleich_mit_einem_unterschiedlichen_Interpret_ergibt_falsch() {
        CD cdMitEinemAnderenInterpret = new CD(this.artikelNr, this.bestand, this.preis, "Schiller", this.titel, this.anzahlTitel);
        
        int ersterHashcode = this.gueltigesCD.hashCode();

        int zweiterHashcode = cdMitEinemAnderenInterpret.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }

    @Test
    public void hashCodeVergleich_mit_einem_unterschiedlichen_Titel_ergibt_falsch() {
        CD cdMitEinemAnderenTitel = new CD(this.artikelNr, this.bestand, this.preis, this.interpret, "Wer bin ich und wenn ja wie viele", this.anzahlTitel);
        
        int ersterHashcode = this.gueltigesCD.hashCode();

        int zweiterHashcode = cdMitEinemAnderenTitel.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }

    @Test
    public void hashCodeVergleich_mit_einem_unterschiedlichen_AnzahlTitel_ergibt_falsch() {
        CD cdMitEinemAnderenAnzahlTitel = new CD(this.artikelNr, this.bestand, this.preis, this.interpret, this.titel, 100);
        
        int ersterHashcode = this.gueltigesCD.hashCode();

        int zweiterHashcode = cdMitEinemAnderenAnzahlTitel.hashCode();
        
        assert(ersterHashcode != zweiterHashcode);
    }
}
