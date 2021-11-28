
/**
 * Beschreiben Sie hier die Klasse Lager.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Lager
{
   private Artikel[] lager;
   int anzahlArtikel = 0;
   
   public Lager(int lagerplatzanzahl){
       lager = new Artikel[lagerplatzanzahl];   
   }
   
   public Lager(){
       this(10);
   }
   
   public void legeAnArtikel(Artikel artikel){
       lager[anzahlArtikel] = artikel;    
       if(anzahlArtikel + 1 < lager.length){
           anzahlArtikel++;   
       }
       
   }
   
   public void entferneArtikel(int artikelNr){
       boolean gefunden = false;
       int index        = 0;
       while(!gefunden){
           if(lager[index] != null && lager[index].getArtikelNr() == artikelNr){
               lager    = loescheArtikel(lager, index);   
               anzahlArtikel--;
               gefunden = true;
           }
           index++;
       }    
   }
   
   private Artikel[] loescheArtikel(Artikel[] lager, int Index){
       Artikel[] kopie = new Artikel[lager.length];
       for(int i = 0; i < Index; i++){
           kopie[i] = lager[i];
       }
       if(Index != lager.length){
           for(int j = Index + 1; j < lager.length; j++ ){
               kopie[j-1] = lager[j];
           }
       }
       return kopie;    
   }
   
   public void bucheZugang(int artikelNr, int zugang){
       boolean gefunden = false;
       int index        = 0;
       while(!gefunden){
           if(lager[index] != null && lager[index].getArtikelNr() == artikelNr){
               lager[index].bucheZugang(zugang); 
               gefunden = true;
           }
           index++;
       }      
   }
   
   public void bucheAbgang(int artikelNr, int abgang){
       boolean gefunden = false;
       int index        = 0;
       while(!gefunden){
           if(lager[index] != null && lager[index].getArtikelNr() == artikelNr){
               lager[index].bucheAbgang(abgang); 
               gefunden = true;
           }
           index++;
       }         
   }
   
   public void aenderePreisEinesArtikels(int artikelNr, double prozent){
    boolean gefunden = false;
       int index        = 0;
       while(!gefunden){
           if(lager[index] != null && lager[index].getArtikelNr() == artikelNr){
               lager[index].aenderePreis(prozent); 
               gefunden = true;
           }
           index++;
       }        
   }
   
   public void aenderePreisAllerArtikel(double prozent){
       for(Artikel artikel : lager){
           if(artikel != null){
               artikel.aenderePreis(prozent);
           }
       }
   }
   
   public Artikel getArtikel(int index){
       return lager[index];
   }
   
   public String toString(){
       String rueckgabe = "";
       for(Artikel artikel : lager){
           if(artikel != null){
               rueckgabe += artikel.toString() + "\n";
           }
       }
       return rueckgabe;
   }
   public int getArtikelAnzahl(){
       return anzahlArtikel;
   }
   
   public int getLagerGroesse(){
       return lager.length;
   }
}
