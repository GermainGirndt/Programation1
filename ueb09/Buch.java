
/**
 * Die Klasse Buch ist eine Spezialisierung von der Artikelklasse
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class Buch extends Artikel
{
    private String titel;
    private String autor;
    private String verlag;

    private final static String ARTIKEL_ART = "Medien";
    
    /**
    * Konstruktor fuer Buch mit Angaben
    * @param artikelNr ist die ArtikelNr die zwischen 1 und 9999 liegen muss
    * @param bestand steht fuer den Bestand der nicht negativ sein muss
    * @param preis steht fuer den Preis der nicht negativ sein muss
    * @param autor ist der Autor des Buchs, darf nicht leer sein
    * @param titel ist der Titel des Buchs, er darf nicht leer sein
    * @param verlag ist der Verlag des Buchs, darf nicht leer sein
    */
    public Buch(int artikelNr, int bestand, double preis, String autor, String titel, String verlag) {
        super(artikelNr, ARTIKEL_ART, bestand, preis);
        
        Validierung.validiereAutor(autor);
        Validierung.validiereTitel(titel);
        Validierung.validiereVerlag(verlag);
        
        this.autor  = autor;
        this.titel  = titel;
        this.verlag = verlag;
    }
    
    @Override
    protected boolean hatDieSelbenAttributen(Object obj) {
        Buch buch = (Buch) obj;

        return super.hatDieSelbenAttributen(buch)      &&
               this.titel.equals(buch.getTitel())      &&
               this.autor.equals(buch.getAutor())      &&
               this.verlag.equals(buch.getVerlag());
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
                ArtikelKonstanten.AUTOR_VARIABLE        + ": "     +   this.autor              + "\n" +
                ArtikelKonstanten.VERLAG_VARIABLE       + ": "     +   this.verlag;
    }
    
    @Override
    public String getBeschreibung(){
        return this.autor + ": " + this.titel;
    }

    @Override
    public int hashCode() {
        int baseHash = super.hashCode();

        int hashCode = Utils.generateHashCodeMitBaseHash(baseHash, this.titel, this.autor, this.verlag);
        
        return hashCode;
    }

    public String getTitel(){
        return this.titel;
    }
    
    public String getAutor(){
        return this.autor;
    }
    
    public String getVerlag(){
        return this.verlag;
    }
}
