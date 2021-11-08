import java.util.regex.Pattern;

/**
* Die Klasse Artikel ist für eine einfache Bestandsprüfung
*
* @author Girndt & Krier
* @version 1.1
*/
public class Artikel
{
    private int     artikelNr;
    private String  art;
    private int     bestand;

    /**
    * Konstruktor für Artikel mit bekannten Bestand
    * @param artikelNr ist die ArtikelNr
    * @param art ist die Artikelart
    * @param bestand steht für den initalen Bestand
    */
    public Artikel(int artikelNr, String art, int bestand)
    {
        Validierung.validiereArtikelNr(artikelNr);
        Validierung.validiereArtikelArt(art);
        Validierung.validiereBestand(bestand);
        
        this.artikelNr  = artikelNr;
        this.art        = art;
        this.bestand    = bestand;
    }

    /**
    * Konstruktor für Artikel ohne Bestandsangabe
    * @param artikelNr ist die ArtikelNr
    * @param art ist die Artikelart
    */
    public Artikel(int artikelNr, String art)
    {
        this(artikelNr, art, 0);
    }

    /**
    * Die Methode bucht eine übergebene Menge dem Bestand hinzu
    * @param menge ist die Menge, die dazugebucht wird
    */
    public void bucheZugang(int menge)
    {
        Validierung.validiereMenge(menge);
        
        this.bestand += menge;
    }

    /**
    * Die Methode bucht eine übergebene Menge dem Bestand ab
    * @param menge ist die Menge, die abgebucht wird
    */
    public void bucheAbgang(int menge)
    {
        Validierung.validiereAbgangsMenge(this.bestand, menge);
        
        this.bestand -= menge;
    }

    /**
    * Die Methode gibt das Objekt aufbereitet als String zurueck
    * @return gibt die Attribute des Artikels als String zurueck
    */
    public String toString()
    {
        return  "ArtikeNr: "    + artikelNr     + "\n" +
                "Art: "         + art           + "\n" +
                "Bestand: "     + bestand;

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
    public int getBestand()
    {
        return this.bestand;
    }

    /**
    * Die Methode setzt die Artikelart neu
    * @param neue Artikelart
    */
    public void setArt(String art)
    {
        Validierung.validiereArtikelArt(art);
        
        this.art = art;
    }

}