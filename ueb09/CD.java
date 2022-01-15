
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
    public boolean equals(Object obj){
        
        if(!(obj instanceof CD)) {
            return false;
        }

        CD cd = (CD) obj;

        return this.hatDieSelbenAttributen(cd);
    }

    private boolean hatDieSelbenAttributen(CD cd) {
        return this.interpret.equals(cd.getInterpret())  &&
               this.titel.equals(cd.getTitel())          &&
               this.anzahlTitel  == cd.getAnzahlTitel()  &&
               this.getPreis()        == cd.getPreis()        &&
               this.getBestand()      == cd.getBestand();
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
