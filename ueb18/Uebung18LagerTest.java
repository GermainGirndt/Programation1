import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;
/**
 * Beschreiben Sie hier die Klasse Uebung18LagerTest.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Uebung18LagerTest
{
    public static void main(String[] strg){
        Lager lager = new Lager();
        
        Artikel buch1 = new Buch(1234, 10, 9.99, "H.P. Lovecraft", "Cthulhus Ruf", "IrgendeinVerlag");
        Artikel buch2 = new Buch(1233, 5, 8.99, "Algernon Blackwood", "Gruselige Geschichten", "IrgendeinAndererVerlag");
        Video video1  = new Video(3333, 15, 15.99, "Star Trek der Film", 98, 1980);
        Video video2  = new Video(2353, 13, 19.99, "Kuhfilm", 120, 2000);
        CD cd1        = new CD(4321, 3 ,7.99, "Pinguine", "Quack", 12);
        CD cd2        = new CD(7351, 9 ,6.99, "Rinder", "Muh", 20);
        
        lager.legeAnArtikel(buch1);
        lager.legeAnArtikel(video1);
        lager.legeAnArtikel(cd1);
        lager.legeAnArtikel(buch2);
        lager.legeAnArtikel(video2);
        lager.legeAnArtikel(cd2);
        
        System.out.println(lager);
        
        BiPredicate<Artikel, Artikel> unterkategorieAbsteigendSortieren = 
        (artikel1, artikel2) -> {return compareStrings(artikel1.getArt(), artikel2.getArt());};
        
        BiPredicate<Artikel, Artikel> unterkategorieAufsteigendSortieren = 
        (artikel1, artikel2) -> {return !compareStrings(artikel1.getArt(), artikel2.getArt());};
        
        BiPredicate<Artikel, Artikel> bestandAbsteigendSortieren = 
        (artikel1, artikel2) -> {return artikel1.getBestand() < artikel2.getBestand();};
        
        BiPredicate<Artikel, Artikel> bestandAufsteigendSortieren = 
        (artikel1, artikel2) -> {return artikel1.getBestand() > artikel2.getBestand();};
        
        BiPredicate<Artikel, Artikel> preisAbsteigendSortieren = 
        (artikel1, artikel2) -> {return artikel1.getPreis() < artikel2.getPreis();};
        
        BiPredicate<Artikel, Artikel> preisAufsteigendSortieren = 
        (artikel1, artikel2) -> {return artikel1.getPreis() > artikel2.getPreis();};
        
        UnaryOperator<Artikel> preis10ProzentReduzieren = 
        (artikel) -> { artikel.aenderePreis(10); return artikel;};
        
        UnaryOperator<Artikel> sonderangebotArtSetzen = 
        (artikel) -> {String art = artikel.getArt(); 
                        artikel.setArt(art + " Sonderangebot");
                        return artikel;};
                                
        Artikel[] sorted = lager.getSorted(bestandAbsteigendSortieren);
        
        System.out.println("Nach Bestand absteigend sortiert: ");
        for(int i = 0; i < lager.getArtikelAnzahl(); i++){
             System.out.println(sorted[i] + "\n");    
        }
        
        sorted = lager.getSorted(preisAufsteigendSortieren);
        System.out.println("Nach Preis aufsteigend sortiert: ");
        for(int i = 0; i < lager.getArtikelAnzahl(); i++){
             System.out.println(sorted[i] + "\n");    
        }
        
        sorted = lager.getSorted(preisAbsteigendSortieren);
        System.out.println("Nach Preis absteigend sortiert: ");
        for(int i = 0; i < lager.getArtikelAnzahl(); i++){
             System.out.println(sorted[i] + "\n");    
        }

        sorted =  lager.getSorted(preisAufsteigendSortieren);
        System.out.println("Nach Preis aufsteigend sortiert: ");
        for(int i = 0; i < lager.getArtikelAnzahl(); i++){
             System.out.println(sorted[i] + "\n");    
        }
        
        sorted =  lager.getSorted( unterkategorieAbsteigendSortieren);
        System.out.println("Nach Unterkategorie absteigend sortiert: ");
        for(int i = 0; i < lager.getArtikelAnzahl(); i++){
             System.out.println(sorted[i] + "\n");    
        }
        
        sorted =  lager.getSorted( unterkategorieAufsteigendSortieren);
        System.out.println("Nach Unterkategorie aufsteigend sortiert: ");
        for(int i = 0; i < lager.getArtikelAnzahl(); i++){
             System.out.println(sorted[i] + "\n");    
        }
        
        Artikel[] modifiziert = lager.applyToArticles(preis10ProzentReduzieren);
        System.out.println("Preis um 10% reduziert: ");
        for(int i = 0; i < lager.getArtikelAnzahl(); i++){
             System.out.println(modifiziert[i] + "\n");    
        }
        
        modifiziert  = lager.applyToArticles(sonderangebotArtSetzen);
        System.out.println("Sonderangebot Art: ");
        for(int i = 0; i < lager.getArtikelAnzahl(); i++){
             System.out.println(modifiziert[i] + "\n");    
        }
        
    }
    
    
    public static boolean compareStrings(String s1, String s2) {

        int comparedResult = s1.compareTo(s2);

        if (comparedResult > 0) {
            return false;
        } else {
            return true;
        }

    }
}
