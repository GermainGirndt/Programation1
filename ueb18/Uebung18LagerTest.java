import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;
import java.util.function.Predicate;
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
        Video video1  = new Video(3333, 2, 15.99, "Star Trek der Film", 98, 1980);
        Video video2  = new Video(2353, 2, 19.99, "Kuhfilm", 120, 2000);
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
                       
        System.out.println("Lager initial");
        System.out.println(lager);
        
        
       Predicate p = a ->
        {
            if(a instanceof Buch){
                Buch b = (Buch)a;
                return b.getAutor().equals("H.P. Lovecraft");
            
            }
            else{
                return false;    
            }
                
        }; 

        //muss man da auf die 0 achten?
        Artikel[] sorted = lager.filterAll(p, a -> a.getPreis() >= 3 , a -> a.getPreis() <= 20);
        
        
        
        for(int i=0; i<sorted.length; i++){
         System.out.println(sorted[i]);   
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
