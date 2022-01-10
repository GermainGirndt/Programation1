
/**
 * Beschreiben Sie hier die Klasse Video.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Video extends Artikel
{
    private String titel;
    private int spieldauer;
    private int jahr;
    
    public Video(int artikelNr, int bestand, double preis, String titel, int spieldauer, int jahr){
        super(artikelNr, "Medien", bestand, preis);
        
        Validierung.validiereTitel(titel);
        Validierung.validiereSpieldauer(spieldauer);
        Validierung.validiereJahr(jahr);
        
        this.titel       = titel;
        this.spieldauer = spieldauer;
        this.jahr       = jahr;
    }
    
    @Override
    public boolean equals(Object obj){
        boolean istgleich = false;
        
        if(obj instanceof Video){
            Video video = (Video)obj;
            if(    titel.equals(video.getTitel()) 
                && spieldauer   == video.getSpieldauer() 
                && jahr         == video.getJahr()
                && getPreis()   == video.getPreis()
                && getBestand() == video.getBestand()){
                    
                istgleich = true;    
            }
        }
        return istgleich;
    }
    
    @Override
    public String getBeschreibung(){
        return this.titel;
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
