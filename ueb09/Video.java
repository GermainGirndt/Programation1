
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

    private final static String ARTIKEL_ART = "Medien";
    
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
    public String getBeschreibung(){
        return this.titel;
    }
    
    public String getTitel(){
        return this.titel;
    }
    
    public int getSpieldauer(){
        return this.spieldauer;
    }
    
    public int getJahr(){
        return this.jahr;
    }
}
