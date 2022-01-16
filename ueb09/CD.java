
/**
 * Die Klasse CD ist eine Spezialisierung von der Artikelklasse
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class CD extends Artikel
{
   private String interpret;
   private String titel;
   private int anzahlTitel;

   private final static String ARTIKEL_ART = "Medien";
   
   CD(int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel) {
       super(artikelNr, ARTIKEL_ART, bestand, preis);    
       
       Validierung.validiereInterpret(interpret);
       Validierung.validiereTitel(titel);
       Validierung.validiereAnzahlTitel(anzahlTitel);
       
       this.interpret   = interpret;
       this.titel       = titel;
       this.anzahlTitel = anzahlTitel;
   }
   
    @Override
    protected boolean hatDieSelbenAttributen(Object obj) {
        CD cd = (CD) obj;

        return super.hatDieSelbenAttributen(cd)          &&
               this.interpret.equals(cd.getInterpret())  &&
               this.titel.equals(cd.getTitel())          &&
               this.anzahlTitel  == cd.getAnzahlTitel();
    }

    @Override
    public int hashCode() {
        int baseHash = super.hashCode();

        int hashCode = Utils.generateHashCode(baseHash, this.interpret, this.titel, this.anzahlTitel);
        
        return hashCode;
    }

   @Override
   public String getBeschreibung(){
        return this.interpret + ": " + this.titel;
   } 
    
   public String getInterpret(){
       return this.interpret;    
   }
   
   public String getTitel(){
       return this.titel;    
   }
   
   public int getAnzahlTitel(){
       return this.anzahlTitel;
   }
}
