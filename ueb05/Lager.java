
/**
 * Beschreiben Sie hier die Klasse Lager.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Lager
{
   private Artikel[] lager;
   
   public Lager(int lagerplatzanzahl){
       lager = new Artikel[lagerplatzanzahl];   
   }
   
   public Lager(){
       this(10);
   }
   
   public void legeAnArtikel(Artikel artikel){
       
   }
}
