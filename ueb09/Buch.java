
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
    protected boolean hatDieSelbenAttributen(Object obj) {
        Buch buch = (Buch) obj;

        return super.hatDieSelbenAttributen(buch)      &&
               this.titel.equals(buch.getTitel())      &&
               this.autor.equals(buch.getAutor())      &&
               this.verlag.equals(buch.getVerlag());
    }
    
    @Override
    public String getBeschreibung(){
        return this.autor + ": " + this.titel;
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
