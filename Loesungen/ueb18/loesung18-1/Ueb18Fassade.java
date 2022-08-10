import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * <p>Diese Klasse ist eine Fassade, hinter der Sie Ihre Loesung verstecken. Der Test ruft nur die hier definierten
 * Schnittstellenmethoden auf. Loeschen Sie bitte keine Methoden. Wenn Sie eine Methode nicht implementieren
 * moechten, lassen Sie bitte die leere Implementierung stehen. Innerhalb der Methoden und in allen anderen Klassen,
 * die Sie noch benoetigen, haben Sie alle Freiheiten.</p>
 * 
 * <p>Wenn Sie Ihre Loesung mit JUnit testen moechten, testen Sie diese Schnittstellenmethoden.</p>
 * @author christopher
 *
 */
public class Ueb18Fassade {
    /**
     * Loest die Aufgabe (c) i.
     * <br />
     * Sortierung nach den folgenden Kriterien:
     * <ol>
     *     <li>Unterkategorie (alphabetisch)</li>
     *     <li>Bestand</li>
     *     <li>Preis</li>
     * </ol>
     * @param lager Das Lager mit der unsortierten Artikelliste.
     * @return Die sortierte Artikelliste.
     */
    public Artikel[] aufgabe_c_i(Lager lager) 
        {
       BiPredicate<Artikel, Artikel> sortierkriterium = (Artikel a, Artikel b) ->
       {
           //Sortierkriterium 1:
           BiFunction<Artikel, Artikel, Integer> kriterium1 = (Artikel x, Artikel y) -> 
           {
               if (x instanceof Buch) 
               {
                   if(y instanceof Buch)
                       return 0;
                   else return -1;
               }
               else if(x instanceof CD)
               {
                   if(y instanceof CD)
                       return 0;
                   else if(y instanceof Buch)
                       return 1;
                   else
                       return -1;
               }
               else if(x instanceof Video)
               {
                   if(y instanceof Video)
                       return 0;
                   else return 1;
               }
               return 0;
           };
           
           //Alternative für Sortierkriterium 1:
           BiFunction<Artikel, Artikel, Integer> kriterium1alt = (Artikel x, Artikel y) -> 
           {
               //alphabetische Sortierung nach Klassennamen
               return x.getClass().getName().compareTo(y.getClass().getName());
           };
           
           //Sortierkriterium 2:
           BiFunction<Artikel, Artikel, Integer> kriterium2 = (Artikel x, Artikel y) -> 
           {
               return x.getBestand() - y.getBestand();
           };
           
           //Sortierkriterium 3:
           BiFunction<Artikel, Artikel, Integer> kriterium3 = (Artikel x, Artikel y) -> 
           {
               if(x.getPreis()-y.getPreis() > 0)
                   return 1;
               else if (x.getPreis()-y.getPreis() < 0)
                   return -1;
               else 
                   return 0;
           };

           int k1 = kriterium1.apply(a, b);
           if(k1 != 0)
               return k1 > 0 ? true : false;
           else
           {
               int k2 = kriterium2.apply(a, b);
               if(k2 != 0)
                   return k2 > 0 ? true : false;
               else{
                   int k3 = kriterium3.apply(a, b);
                   return k3 >= 0 ? true : false;
               }
           }
       };
       return lager.getSorted(sortierkriterium);
    }

    /**
     * Loest die Aufgabe (c) ii.
     * <br />
     * Der Preis aller Artikel wird um 10% reduziert.
     * @param lager Das Lager mit den Artikeln, deren Preise geaendert werden sollen.
     */
    public void aufgabe_c_ii(Lager lager) 
        {
       lager.applyToArticles(a -> a.aenderePreis(-10));
    }

    /**
     * Loest die Aufgabe (c) iii.
     * <br />
     * An alle Artikelbezeichnungen wird das Suffix (Sonderangebot) angehaengt.
     * @param lager Das Lager mit den Artikeln, deren Art-Bezeichnungen geaendert werden sollen.
     */    
    public void aufgabe_c_iii(Lager lager) 
        {
       lager.applyToArticles(a -> a.setArt(a.getArt()+" Sonderangebot"));
    }

    /**
     * Loest die Aufgabe (c) iv.
     * <br />
     * Die beiden Operatoren aus den Aufgabenteilen ii und iii werden konkateniert, d.h. alle Preise werden
     * um 10 % reduziert und alle Art-Bezeichnungen werden um das Suffix (Sonderangebot) erweitert.
     * @param lager Das Lager mit den Artikeln, deren Preise und Art-Bezeichnungen geaendert werden sollen.
     */
    public void aufgabe_c_iv(Lager lager) 
        {
       Consumer<Artikel> minus10Prozent =  a -> a.aenderePreis(-10);
       Consumer<Artikel> sonderangebot =  a -> a.setArt(a.getArt()+" Sonderangebot");
       lager.applyToArticles(minus10Prozent.andThen(sonderangebot));
    }

    /**
     * Loest die Aufgabe (h) i.
     * <br />
     * Der Preis aller CD wird um 10 % erhoeht.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     */
    public void aufgabe_h_i(Lager lager) 
        {
           lager.applyToSomeArticles(
                 a -> a instanceof CD, 
                 a -> a.aenderePreis(10)
           );
    }

    /**
     * Loest die Aufgabe (h) ii.
     * <br />
     * Der Preis aller Artikel, von denen der Bestand hoechstes zwei ist, wird um 5 % reduziert.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     */
    public void aufgabe_h_ii(Lager lager) 
        {
           lager.applyToSomeArticles(
                 a -> a.getBestand() <= 2, 
                 a -> a.aenderePreis(-5)
           );
    }

    /**
     * Loest die Aufgabe (h) iii.
     * <br />
     * Der Preis der Buecher eines bestimmten Autors wird um 5 % reduziert.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     * @param gesuchterAutor Der Autor, dessen Buecher guenstiger werden sollen.
     */
    public void aufgabe_h_iii(Lager lager, String gesuchterAutor) 
        {
           Predicate<Artikel> filterAuthor = 
                                    a -> {
                                            if (a instanceof Buch)
                                              {
                                               if( ((Buch) a).getAutor().equals(gesuchterAutor) )
                                                  return true;
                                              }
                                            return false;
                                         };

           lager.applyToSomeArticles(
                            filterAuthor, 
                            a -> a.aenderePreis(-5)
           );
    }

    /**
     * Loest die Aufgabe (h) iv.
     * <br />
     * Der Preis aller CD wird um 10 % erhoeht und der Preis aller Artikel, von denen der Bestand hoechstes zwei ist, wird um 5 % reduziert.
     * @param lager Das Lager mit den Artikeln. Die Aenderungen werden direkt in diesem Objekt vorgenommen.
     */
    public void aufgabe_h_iv(Lager lager) 
        {
           lager.applyToArticles(
                            a -> {
                                   if ( a instanceof CD)
                                     {
                                       a.aenderePreis(10);
                                     }

                                   if ( a.getBestand() <= 2 )
                                     {
                                       a.aenderePreis(-5);
                                     }
                                 }
           );

         //18_h_iv Alternative
         /*
           Consumer<Artikel> l1 = a -> {
                                         if (a.instanceof CD)
                                           {
                                             a.aenderePreis(10);
                                           }
                                       };
           Consumer<Artikel> l2 = a -> {
                                         if (filterAuthor.test(a))
                                           {
                                             a.aenderePreis(-5);
                                           }
                                       };

           lager.applyToArticles(l1.andThen(l2));
         */
    }

    /**
     * Loest die Aufgabe (h) v.
     * <br />
     * @param lager Das Lager mit den Artikeln. 
     * @return Eine Liste mit allen Buechern, sortiert nach den Namen der Autoren. 
     */
    public Artikel[] aufgabe_h_v(Lager lager) 
        {
           Artikel[] result = 
                     lager.getArticles(
                           a      -> a instanceof Buch,
                           (a, b) -> ((Buch)a).getAutor().compareTo(((Buch)b).getAutor()) >= 0 ? true: false
                     );
           return result;
    }

    /**
     * Loest die Aufgabe (h) vi.
     * <br />
     * @param lager Das Lager, dessen Artikel gefiltert werden sollen.
     * @param gesuchterAutor Der Autor, nach dem gefiltert werden soll.
     * @param minPreis Der kleinste Preis, den die zu filternden Buecher haben sollen.
     * @param maxPreis Der hoechste Preis, den die zu filternden Buecher haben sollen.
     * @return Alle Buecher vom Autor autor und mit einem Preis, der zwischen minPreis und maxPreis liegt.
     */
    public Artikel[] aufgabe_h_vi(Lager lager, String gesuchterAutor, double minPreis, double maxPreis) 
        {
           Predicate<Artikel> filterBuch   = a -> a instanceof Buch;
           Predicate<Artikel> filterAutor = a -> ((Buch) a).getAutor().equals(gesuchterAutor);
           Predicate<Artikel> filterPreis  = a -> ( (((Buch) a).getPreis() > minPreis) && (((Buch) a).getPreis() < maxPreis ) );
           
           Artikel[] result = lager.filterAll( filterBuch, filterAutor, filterPreis );
           return result;
    }
}
