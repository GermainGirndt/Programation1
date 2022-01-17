/**
* Die Klasse Artikel ist fuer eine einfache Bestandspruefung
*
* @author Girndt & Krier
* @version 1.2
*/
public class Artikel
{
    private              int        artikelNr;
    private              String     art;
    private              long       bestand;
    private              double     preis;
    
    private static final int        MINIMUM_BESTAND = 0;
    private static final double     INITIAL_PREIS   = 0.0;

    /**
    * Konstruktor fuer Artikel mit Angaben
    * @param artikelNr ist die ArtikelNr die zwischen 1 und 9999 liegen muss
    * @param art ist die Artikelart die nur Buchstaben und Zahlen enthalten darf
    * @param bestand steht fuer den Bestand der nicht negativ sein muss
    * @param preis steht fuer den Preis der nicht negativ sein muss
    */
    public Artikel(int artikelNr, String art, int bestand, double preis)
    {
        Validierung.validiereArtikelNr(artikelNr);
        Validierung.validiereArtikelArt(art);
        Validierung.validiereBestand(bestand);
        Validierung.validierePreis(preis);
        
        this.artikelNr  = artikelNr;
        this.art        = art;
        this.bestand    = bestand;
        this.preis      = preis;
    }
    
    /**
    * Konstruktor fuer Artikel ohne Preis- und Bestandsangabe
    * @param artikelNr ist die ArtikelNr die zwischen 1 und 9999 liegen muss
    * @param art ist die Artikelart die nur Buchstaben und Zahlen enthalten darf
    * @param preis steht fuer den initalen Preis
    */
    public Artikel(int artikelNr, String art, double preis)
    {
         this(artikelNr, art, MINIMUM_BESTAND, INITIAL_PREIS);

    }
    
    /**
    * Konstruktor fuer Artikel ohne Preisangabe
    * @param artikelNr ist die ArtikelNr die zwischen 1 und 9999 liegen muss
    * @param art ist die Artikelart die nur Buchstaben und Zahlen enthalten darf
    * @param bestand steht fuer den Bestand
    */
    public Artikel(int artikelNr, String art, int bestand)
    {
        this(artikelNr, art, bestand, INITIAL_PREIS);
    }

    /**
    * Konstruktor fuer Artikel ohne Bestandsangabe
    * @param artikelNr ist die ArtikelNr die zwischen 1 und 9999 liegen muss
    * @param art ist die Artikelart die nur Buchstaben und Zahlen enthalten darf
    */
    public Artikel(int artikelNr, String art)
    {
        this(artikelNr, art, MINIMUM_BESTAND, INITIAL_PREIS);
    }

    /**
    * Die Methode bucht eine uebergebene Menge dem Bestand hinzu
    * @param mengeArtikelzugang ist die positive Menge neuer Artikel, die dazugebucht wird
    */
    public void bucheZugang(int mengeArtikelzugang)
    {
        Validierung.validiereZugangsmenge(this.bestand, mengeArtikelzugang);
        
        this.bestand += mengeArtikelzugang;
    }
    
    /**
    * Die Methode bucht eine uebergebene Menge dem Bestand ab
    * @param menge ist die positive Menge, die abgebucht wird
    */
    public void bucheAbgang(int menge) {
        Validierung.validiereAbgangsmenge(this.bestand, menge);
        
        this.bestand -= menge;
    }
    
    /**
     * Die Methode aendert den Preis eines Artikels
    * @param prozent ist der Prozensatz an Preisabweichung
    */
    public void aenderePreis(double prozent)
    {
        Validierung.validierePreisaenderung(prozent);
        
        double preisfaktor = berechnePreisfaktor(prozent);
        
        this.preis *= preisfaktor;
    }
    
    /**
    * Die Methode berechnet die Preisabweichung des Artikelpreises
    * @param prozent ist der Prozensatz an Preisabweichung
    */
    private double berechnePreisfaktor(double prozent) {
        return (prozent + 100.0) / 100.0;
    }

    /**
    * Die Methode gibt das Objekt aufbereitet als String zurueck
    * @return gibt die Attribute des Artikels als String zurueck
    */
    public String toString()
    {
        return  ArtikelKonstanten.NUMMER_VARIABLE + ": "    +    this.artikelNr     + "\n" +
                ArtikelKonstanten.ART             + ": "     +   this.art           + "\n" +
                ArtikelKonstanten.BESTAND         + ": "     +   this.bestand       + "\n" +
                ArtikelKonstanten.PREIS           + ": "     +   this.preis;
    }

    public String getBeschreibung(){
        return this.art;
    }
    
    /**
    * Die Methode gibt die Artikelnummer zurueck
    * @return die Artikelnummer
    */
    public int getArtikelNr()
    {
        return this.artikelNr;
    }
    
    /**
    * Die Methode gibt die Artikelart zurueck
    * @return die Artikelart
    */
    public String getArt()
    {
        return this.art;
    }

    /**
    * Die Methode gibt den Bestand zurueck
    * @return den Bestand
    */
    public long getBestand()
    {
        return this.bestand;
    }

    /**
    * Die Methode gibt den Preis zurueck
    * @return den Preis
    */
    public double getPreis()
    {
        return this.preis;
    }

    /**
    * Die Methode setzt die Artikelart neu
    * @param neue Artikelart die nur Buchstaben und Zahlen und Leerzeichen enthalten darf
    */
    public void setArt(String art)
    {
        Validierung.validiereArtikelArt(art);
        
        this.art = art;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        
        return this.hatDieSelbenAttributen(obj);
    }

    protected boolean hatDieSelbenAttributen(Object obj) {
        Artikel artikel = (Artikel) obj;

        return this.art.equals(artikel.getArt())            &&
               this.artikelNr == artikel.getArtikelNr()     &&
               this.bestand   == artikel.getBestand()       &&
               this.preis     == artikel.getPreis();
    }

    @Override
    public int hashCode() {
        int hashCode = Utils.generateHashCode(this.art, this.artikelNr, this.bestand, this.preis);
        return hashCode;
    }
}