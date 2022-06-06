
/**
 * Die Klasse Video ist eine Spezialisierung von der Artikelklasse
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class Video extends Artikel
{
    private String titel;
    private int spieldauer;
    private int jahr;

    private final static String ARTIKEL_ART = "Video";
    
    
    /**
    * Konstruktor fuer Video mit Angaben
    * @param artikelNr ist die ArtikelNr die zwischen 1 und 9999 liegen muss
    * @param bestand steht fuer den Bestand der nicht negativ sein muss
    * @param preis steht fuer den Preis der nicht negativ sein muss
    * @param titel ist der Videotitel, er darf nicht leer sein
    * @param spieldauer ist die Laenge des Videos, sie muss groesser als 0 sein
    * @param jahr ist das Erscheinungsjahr, es muss zwischen 1900 und 2022 liegen
    */
    public Video(int artikelNr, int bestand, double preis, String titel, int spieldauer, int jahr) {
        super(artikelNr, ARTIKEL_ART, bestand, preis);
        
        Validierung.validiereTitel(titel);
        Validierung.validiereSpieldauer(spieldauer);
        Validierung.validiereJahr(jahr);
        
        this.titel       =  titel;
        this.spieldauer  =  spieldauer;
        this.jahr        =  jahr;
    }
    
    
    @Override
    protected boolean hatDieSelbenAttributen(Object obj) {
        Video video = (Video) obj;

        return super.hatDieSelbenAttributen(video)          &&
               this.titel.equals(video.getTitel())          &&
               this.spieldauer   == video.getSpieldauer()   &&
               this.jahr         == video.getJahr();
    }

    @Override
    public int hashCode() {
        int baseHash = super.hashCode();

        int hashCode = Utils.generateHashCodeMitBaseHash(baseHash, this.titel, this.spieldauer, this.jahr);
        
        return hashCode;
    }
    
    /**
    * Die Methode gibt das Objekt aufbereitet als String zurueck
    * @return gibt die Attribute des Artikels als String zurueck
    */
    @Override
    public String toString()
    {
        return  ArtikelKonstanten.NUMMER_VARIABLE       + ": "     +   this.getArtikelNr()     + "\n" +
                ArtikelKonstanten.ART                   + ": "     +   this.getArt()           + "\n" +
                ArtikelKonstanten.BESTAND               + ": "     +   this.getBestand()       + "\n" +
                ArtikelKonstanten.PREIS                 + ": "     +   this.getPreis()         + "\n" +
                ArtikelKonstanten.TITEL_VARIABLE        + ": "     +   this.titel              + "\n" +
                ArtikelKonstanten.SPIELDAUER_VARIABLE   + ": "     +   this.spieldauer         + "\n" +
                ArtikelKonstanten.JAHR_VARIABLE         + ": "     +   this.jahr;
    }
    
    @Override
    public String getBeschreibung() {
        return this.titel;
    }
    
    public String getTitel() {
        return this.titel;
    }
    
    public int getSpieldauer() {
        return this.spieldauer;
    }
    
    public int getJahr() {
        return this.jahr;
    }
}
