
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
       Artikel[] kopieLager = new Artikel[lager.length];
       for(int i = 0; i < lager.length; i++){
           if(lager[i] != null && lager[i].getArtikelNr() == artikelNr){
               lager = loescheArtikel(lager, i);   
               anzahlArtikel--;
               i--;
           }
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
   
   public Artikel getArtikel(int index){
       return lager[index];
   }
   
   public String toString(){
       String rueckgabe = "";
       for(Artikel artikel : lager){
           rueckgabe += artikel.toString() + "\n";
       }
       return rueckgabe;
   }
   public int getArtikelAnzahl(){
       return anzahlArtikel;
   }
   
   public int getLagerGroesse(){
       return lager.length;
   }
   //Nur fuer Testzwecke, denke dran das zu löschen
   public static void main(String[] strg){
       Artikel a = new Artikel(1 , "kuh");
       Artikel b = new Artikel(2 , "Pferd");
       Lager   lager = new Lager();
       lager.legeAnArtikel(a);
       lager.legeAnArtikel(a);
       lager.legeAnArtikel(b);
       lager.legeAnArtikel(a);
       lager.legeAnArtikel(b);
       lager.entferneArtikel(2);
   }
}
