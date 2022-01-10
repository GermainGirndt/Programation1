
/**
 * Beschreiben Sie hier die Klasse CD.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class CD extends Artikel
{
   String interpret;
   String titel;
   int anzahlTitel;
   
   CD(int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel){
       super(artikelNr, "Medien", bestand, preis);    
       
       Validierung.validiereInterpret(interpret);
       Validierung.validiereTitel(titel);
       Validierung.validiereAnzahlTitel(anzahlTitel);
       
       this.interpret   = interpret;
       this.titel       = titel;
       this.anzahlTitel = anzahlTitel;
   }
   
   @Override
    public boolean equals(Object obj){
        boolean istgleich = false;
        
        if(obj instanceof CD){
            CD cd= (CD)obj;
            if(    interpret.equals(cd.getInterpret()) 
                && titel.equals(cd.getTitel())
                && anzahlTitel  == cd.getAnzahlTitel()
                && getPreis()   == cd.getPreis()
                && getBestand() == cd.getBestand()){
                    
                istgleich = true;    
            }
        }
        return istgleich;
    }
   
   public String getInterpret(){
       return interpret;    
   }
   
   public String getTitel(){
       return titel;    
   }
   
   public int getAnzahlTitel(){
       return anzahlTitel;
   }
}
