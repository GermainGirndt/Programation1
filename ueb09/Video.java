
/**
 * Beschreiben Sie hier die Klasse Video.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Video extends Artikel
{
    String titel;
    int spieldauer;
    int jahr;
    
    Video(int artikelNr, int bestand, double preis, String titel, int spieldauer, int jahr){
        super(artikelNr, "Video", bestand, preis);
        
        Validierung.validiereTitel(titel);
        Validierung.validiereSpieldauer(spieldauer);
        Validierung.validiereJahr(jahr);
        
        this.titel       = titel;
        this.spieldauer = spieldauer;
        this.jahr       = jahr;
    }
    
    public String getTitel(){
        return titel;
    }
    
    public int getSpieldauer(){
        return spieldauer;
    }
    
    public int getJahr(){
        return jahr;
    }
}
