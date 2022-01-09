
/**
 * Beschreiben Sie hier die Klasse Buch.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Buch extends Artikel
{
    private String titel;
    private String autor;
    private String verlag;
    
    public Buch(int artikelNr, int bestand, double preis, String titel, String autor, String verlag){
        super(artikelNr, "Medien" , bestand, preis);
        
        Validierung.validiereTitel(titel);
        Validierung.validiereAutor(autor);
        Validierung.validiereVerlag(verlag);
        
        this.titel  = titel;
        this.autor  = autor;
        this.verlag = verlag;
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
