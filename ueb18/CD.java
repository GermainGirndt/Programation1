
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

   private final static String ARTIKEL_ART = "CD";
   
   
    /**
    * Konstruktor fuer CD mit Angaben
    * @param artikelNr ist die ArtikelNr die zwischen 1 und 9999 liegen muss
    * @param bestand steht fuer den Bestand der nicht negativ sein muss
    * @param preis steht fuer den Preis der nicht negativ sein muss
    * @param interpret ist der Interpret, darf nicht leer sein
    * @param titel ist der Titel der CD, er darf nicht leer sein
    * @param anzahlTitel ist die Anzahl der Titel auf der CD, muss groesser als 0 sein 
    */
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

        int hashCode = Utils.generateHashCodeMitBaseHash(baseHash, this.interpret, this.titel, this.anzahlTitel);
        
        return hashCode;
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
                ArtikelKonstanten.INTERPRET_VARIABLE    + ": "     +   this.interpret          + "\n" +
                ArtikelKonstanten.ANZAHLTITEL_VARIABLE  + ": "     +   this.anzahlTitel;
    }
     
    
   @Override
   public String getBeschreibung() {
        return this.interpret + ": " + this.titel;
   } 
    
   public String getInterpret() {
       return this.interpret;    
   }
   
   public String getTitel() {
       return this.titel;    
   }
   
   public int getAnzahlTitel() {
       return this.anzahlTitel;
   }
}
