
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
    public boolean equals(Object obj){
        if(!(obj instanceof Buch)){
            return false;
        }

        Buch buch = (Buch) obj;
        return this.hatDieSelbenAttributen(buch);
    }

    private boolean hatDieSelbenAttributen(Buch buch) {
        return this.titel.equals(buch.getTitel())      &&
               this.autor.equals(buch.getAutor())      &&
               this.verlag.equals(buch.getVerlag())    &&
               this.getPreis()   == buch.getPreis()    &&
               this.getBestand() == buch.getBestand();
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

    public String getTitel(){
        return titel;
    }
    
    public String getAutor(){
        return autor;
    }
    
    public String getVerlag(){
        return verlag;
    }
}
