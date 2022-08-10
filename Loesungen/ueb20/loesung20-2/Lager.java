import java.io.*;
import java.util.*;
    
//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
// neu in ueb18
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    
/**
 *    Die Klasse:  Lager.java
 *    Realisiert eine allgemeine Lager-Klasse fuer
 *    Artikel.
 *
 * @version 2.01 Beta 10.01.2022 erweitert 02.06.2022 + 21.06.2022
 * @author  Wolfgang Pauly
 *
 */

public class Lager
{
//------------------Konstanten----------------------------------
  
  public  static final int     STANDARD_GROESSE = 10;
  public  static final String  STANDARD_LAGER_ORT = 
                               " (Ort noch nicht bestimmt) ";
  
  private static final String  DIMENSION_UNGUELTIG =
          "Ein zu konstruierendes Lager muss mindestens 1 Artikel aufnehmen koennen !";
  private static final String  LAGERORT_UNGUELTIG =
          "Der Lagerort-String muss initialisiert und nicht Leer sein !";

  private static final String  ARTIKEL_NICHT_IN_LAGER =
          "Verlangter Buchungs-Artikel nicht in Lager !!!!";
  private static final String  ARTIKEL_SCHON_IN_LAGER =
          "Anzulegender Artikel schon in Lager !!!!";
  
  private static final String  INDEX_UNGUELTIG =
          "Der Index ist zu gross oder zu klein !!!!";          
  
//------------------Attribute----------------------------------
  
  private  Map<Integer, Artikel> lager;                //NEU
  private  int                   initialCapacity;      //NEU
  private  String    lagerOrt;

//------------------Konstruktoren-------------------------------


  /**
   *    Der Konstruktor zur Standard-Initialisierung 
   *    des Lagers
   *        
   */
  public Lager ()
  {
   this( STANDARD_GROESSE, STANDARD_LAGER_ORT );
  }



  /**
   *    Der Konstruktor zur Initialisierung 
   *    eines Lagers mit einer maximalen Anzahl von Artikel-Lagerplaetzen
   *        
   *    @param groesse  == Anzahl der maximal im Lager fuehrbaren Artikel
   */
  public Lager (int groesse)
  {
   this( groesse, STANDARD_LAGER_ORT );
  }


  /**
   *    Der Konstruktor zur Initialisierung 
   *    eines Lagers mit einem Lagerort und Standard-Artikel--Lagerplaetzen
   *        
   *    @param lagerOrt == Ort an dem das Lager existiert
   */
  public Lager (String lagerOrt)
  {
   this( STANDARD_GROESSE, lagerOrt );
  }


  /**
   *    Der Konstruktor zur Initialisierung 
   *    eines Lagers mit einer maximalen Anzahl von Artikel-Lagerplaetzen
   *        
   *    @param groesse  == Anzahl der maximal im Lager fuehrbaren Artikel
   *    @param lagerOrt == Ort an dem das Lager existiert
   */
  public Lager (int groesse, String lagerOrt)
  {
   checkArgument( (groesse <= 0), DIMENSION_UNGUELTIG );
   checkArgument( ( (lagerOrt == null) || (lagerOrt.trim().length() == 0)),
                  LAGERORT_UNGUELTIG 
            );

   this.lagerOrt = new String(lagerOrt); 

   lager           = new LinkedHashMap<Integer, Artikel>( groesse );  //NEU
   initialCapacity = groesse;                                         //NEU
  }


//------------------ set-/get-lagerOrt---------------------------------

  /**
   *    gibt Lager-Attribut : lagerOrt zurueck
   *
   *    @return    lagerOrt
   */
  public String getLagerOrt ( )
  {
    return lagerOrt;
  }


  /**
   *    setzt Lager-Attribut :  lagerOrt
   *   
   *    @param lagerOrt     neuer Lager-Ort
   */
  public void setLagerOrt ( String lagerOrt )
  {
   checkArgument( ( (lagerOrt == null) || (lagerOrt.trim().length() == 0)), 
                  LAGERORT_UNGUELTIG
        );

   this.lagerOrt = lagerOrt.trim();
  }

//------------------Artikel anlegen  ---------------------------------


  /**
   *    anlegen eines neuen Artikels und ins Lager einordnen
   *    
   *    @param artikel  der anzulegende Artikel
   */
  public void legeAnArtikel ( Artikel artikel )
  {
    checkArgument( lager.containsKey( artikel.getArtikelNr() ) ,
                   ARTIKEL_SCHON_IN_LAGER
                 );                                                   //NEU
    lager.put( artikel.getArtikelNr(), artikel );                     //NEU
  }


//------------------Artikel entfernen ----------------------------------

  /**
   *    entfernt den Artikel anhand seiner Artikel-Nummer aus dem Lager
   *    
   *    @param   artikelNr Nummer des zu loeschenden Artikels
   *             
   */
  public void entferneArtikel ( int artikelNr )
  {
     lager.remove( artikelNr );                                       //NEU
  }



//------------------ zugang buchen  --------------------------------

  /**
   *    bucht einen Zugang von Artikeln zu dem durch die Artikel-Nummer 
   *    identifizierten Artikel.
   *    
   *    @param   artikelNr Artikel-Nummer, des zu buchenden Artikels
   *    @param zugang hinzukommende Artikel-Anzahl
   */
  public void bucheZugang ( int artikelNr, int zugang )
  {
    checkArgument(  ! lager.containsKey( artikelNr ),
                    ARTIKEL_NICHT_IN_LAGER );                         //NEU
                      
    lager.get( artikelNr ).bucheZugang( zugang );                     //NEU
  }


//------------------- abgang buchen  --------------------------------

  /**
   *    bucht einen Abgang von Artikeln von dem durch die Artikel-Nummer 
   *    identifizierten Artikel.
   *    
   *    @param   artikelNr Artikel-Nummer, des zu buchenden Artikels
   *    @param abgang weggehende Artikel-Anzahl
   */
  public void bucheAbgang ( int artikelNr, int abgang )
  {
    checkArgument(  ! lager.containsKey( artikelNr ),
                    ARTIKEL_NICHT_IN_LAGER );                        //NEU
                        
    lager.get( artikelNr ).bucheAbgang( abgang );                    //NEU
  }



  /**
   *    aenderePreisEinesArtikels - erhoeht, vermindert den Preis
   *                               eines anzugebenden Lagerartikels
   *    
   *    @param artikelNr Artikel-Nummer, des zu bearbeitenden Artikels
   *    @param prozent positive Prozentzahl == Preiserhoehung, negative = Preisverminderung
   */
  public void aenderePreisEinesArtikels ( int artikelNr, double prozent )
  {
    checkArgument(  ! lager.containsKey( artikelNr ),
                    ARTIKEL_NICHT_IN_LAGER );                        //NEU
                        
    lager.get( artikelNr ).aenderePreis( prozent );                  //NEU
  }




  /**
   *    aenderePreisAllerArtikel - erhoeht, vermindert die Preise
   *                               aller Lagerartikel
   *
   *    @param  prozent - positive Prozentzahl == Preiserhoehung, negative = Preisverminderung 
   */
  public void aenderePreisAllerArtikel ( double prozent )
  {
    lager.forEach((nr, a) -> a.aenderePreis( prozent ));             //NEU
  }
 
//------------------- hilfs-Methoden --------------------------------

  /**
   *    getArtikelAnzahl - liefert die Anzahl der Artikel im Lager Array
   *    
   *
   *    @return Anzahl der momentan im Lager gefuehrten Artikel
   */
  public int getArtikelAnzahl ()
  {
    return  lager.size();                                            //NEU
  }
  
  /**
   *    getArtikel - liefert den Artikel aus dem Lager, der an der Stelle 
   *    Index gefuert wird
   *    Hilfsmethode fuer die Testklasse LagerTest
   *    @author  Iris Ebner
   *
   *    @param index - der Index des zurueckzugebenden Artikels
   *    @return der Artikel, der an der Stelle Index im Lager gefuehrt wird 
   */  
  public Artikel getArtikel (int index)
  {
     checkArgument( (index >= lager.size() || index < 0),
                    INDEX_UNGUELTIG
                  );                                                 //NEU
 
     Artikel[] artikelArray = lager.values().toArray(new Artikel[lager.size()]); //NEU
 
    return artikelArray[index];
   }


//------------------ ausgebenBestandsListe --------------------------

  /**
   *    erzeugt einen String, der eine Bestandsliste repraesentiert
   *
   *    @return die String-Repraesentation der Lager-Bestandsliste
   */
  public String ausgebenBestandsListe ()
  {

    double zeilenWert, gesamtWert = 0;

    StringBuilder bestandsListe = new StringBuilder();
    Formatter formatierer = new Formatter( bestandsListe, Locale.GERMAN );

    formatierer.format( "\n-----B e s t a n d s L i s t e --------" +
                        "-----------------------------------------" +
                        "-------------------" +
                        "\n\nLagerort : %20s \n\n %6s   %-45s %10s %10s %10s" +
                        "\n--------------------------------------" +
                        "-----------------------------------------" +
                        "-------------------",
                        lagerOrt, "ArtNr", "Beschreibung", "Preis",
                        "Bestand", "Gesamt"
                       );

    Iterator<Artikel> iter = lager.values().iterator();              //NEU
    Artikel next;                                                    //NEU
      
    while ( iter.hasNext() )                                         //NEU
         {
          next = iter.next();                                        //NEU
          zeilenWert = next.getPreis() * next.getBestand();          //NEU
          gesamtWert += zeilenWert;                                  //NEU
        
          formatierer.format( "\n %6d   %45s %10.2f %10d %10.2f ",
                              next.getArtikelNr(),                   //NEU
                              next.getBeschreibung(),                //NEU
                              next.getPreis(),                       //NEU
                              next.getBestand(),                     //NEU
                              zeilenWert
                            );
          // hier waere es evtl sinnvoll in den Klassen Artikel, Cd, Dvd und Buch
          // eine Methode getBestandsZeile() zu programmieren, falls man auf 
          // diese Klassen "quellcode-maessig" zugreifen kann. 
         } 

    formatierer.format( "\n--------------------------------------" +
                        "-----------------------------------------" +
                        "-------------------"
                       );
    formatierer.format( "\n Gesamtwert:                     " +
                        "                                   " +
                        "%20.2f", gesamtWert
                       );

   return bestandsListe.toString();
  }




//------------------ toString  --------------------------------------

  /**
   *    erzeugt einen String, der alle, fuer den Klassenbenutzer
   *    wichtigen, Lager-Merkmale enthaelt
   *   
   *    @return die String-Repraesentation des Lagers
   */
  public String toString ()
  {
    StringBuffer lagerString =                                              //NEU
       new StringBuffer( String.format(                                     //NEU
                           "\n\nIm Lager >%s< sind von urspruenglich %d " + //NEU
                           "Lagerplaetzen %d ",                             //NEU
                           lagerOrt, initialCapacity, lager.size()          //NEU
                       )              );                                    //NEU
        
    lagerString.append( "mit folgenden Artikeln belegt: \n");
 
    Iterator<Artikel> iter = lager.values().iterator();                      //NEU
    int i=0;                                                                 //NEU
 
    while ( iter.hasNext() )                                                 //NEU
      {
        i++;                                                                 //NEU
        lagerString.append( String.format( "\n    %3d\t-> %s", i, iter.next()) );   //NEU
      }
 
   return lagerString.toString();
  }


 /**
  *    wirft bei Fehlersituation eine RuntimeException
  *    
  *    
  *    @param  fehler  -> true  == Fehlersituation
  *                    -> false == KEINE Fehlersituation
  *    @param  meldung -> Fehlermeldungstext zur Fehlersituation
  */
  private void   checkArgument( boolean fehler, String meldung )
  {
   if ( fehler )
     {
      throw new RuntimeException( meldung );
     }
  }




 //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
 // neue Funktionen ueb18
 //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv


  //------------------ getSorted  --------------------------------------
  /**
   * Gibt die Artikel im Lager als sortiertes Array zurück. 
   * Das Sortierkriterium wird als Parameter an die Methode übergeben.
   * 
   * @param sortKrit - ein Prädikat-Objekt, welches das Sortierkriterium implementiert  
   * @return ein sortiertes Array der Artikel im Lager 
   */
  public Artikel[] getSorted(BiPredicate<Artikel, Artikel> sortKrit)
    {
     Artikel[] result = lager.values().toArray(new Artikel[lager.size()]); //NEU

     sort(sortKrit, result);

     return result;
    }
  
  /**
   * Hilfsmethode zum Sortieren eines übergebenen Arrays
   * 
   * @param sortKrit - ein Prädikat-Objekt, welches das Sortierkriterium implementiert
   * @param a - das zu sortierende Array
   */
  private void sort(BiPredicate<Artikel, Artikel> sortKrit, Artikel[] a)
    {
      //Zum Sortieren wird der Bubblesort-Algorithmus verwendet. 
      //Dies ist nicht sehr effizient, jedoch einfach zu implementieren: 
      for (int i=a.length; i>0; i--)
         {
          for (int j=0; j<a.length-1; j++)
         {
              if (sortKrit.test(a[j],a[j+1]))
            {
                 swap(j, j+1, a);
                } 
             }
         }
    }
  
  //------------------ swap  --------------------------------------
  /**
   * Hilfsmethode zum Sortieren eines Arrays. Die Methode vertauscht 
   * die beiden Elemente mit den Indizes i und j eines übergebenen Arrays. 
   * 
   * @param i - Index des ersten Elements
   * @param j - Index des zweiten Elements
   * @param a - Array für die Vertauschung 
   */
  private void swap(int i, int j, Artikel[] a)
    {
      Artikel tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;        
    }
  
  //------------------ getSorted  --------------------------------------
  /**
   * Alternative Implementierung der getSorted Methode, 
   * unter Nutzung der sort Methode des List-Interfaces.
   * @param comp - ein Comparator-Objekt zum Vergleich zweier Artikel
   * @return eine sortierte Liste der Artikel im Lager
   */
  public List<Artikel> getSorted(Comparator<Artikel> comp)
    {
      List<Artikel> result = Arrays.asList(lager.values().toArray(new Artikel[lager.size()])); //NEU

      result.sort(comp);

      return result;
    }
  
  
  //------------------ applyToArticles  --------------------------------------
  /**
   * wendet eine übergebene Operation auf alle Artikel im Lager an 
   * 
   * @param consum - ein Consumer der die auf die Artikel anzuwendende Operation implementiert
   */
  public void applyToArticles(Consumer<Artikel> consum)
    {
       Artikel einArtikel;
     
       for (Map.Entry<Integer, Artikel> entry : lager.entrySet())         //NEU
         {
           einArtikel = entry.getValue();                                 //NEU
           consum.accept(einArtikel);                                     //NEU
         }
    }

  
  
  //------------------ filter  --------------------------------------
  /**
   * Filtert die Artikel im Lager nach einem an die Methode übergebenen Filterkriterium. 
   * 
   * @param filterKrit - ein Prädikat-Objekt, welches das Filterkriterium implementiert
   * @return eine Liste alle Artikel im Lager, die das Filterkriterium erfüllen. 
   */
  public List<Artikel> filter(Predicate<Artikel> filterKrit)
    {
       Artikel einArtikel;
     
       List<Artikel> geFiltert = new ArrayList<Artikel>();
     
       for (Map.Entry<Integer, Artikel> entry : lager.entrySet())         //NEU
         {
           einArtikel = entry.getValue();                                 //NEU
           if (filterKrit.test(einArtikel))
             {
               geFiltert.add(einArtikel);
             }
         }
       return geFiltert;
    }


  //------------------ applyToSomeArticles  --------------------------------------
  /**
   * wendet eine übergebene Operation auf alle Artikel, welche ein Filterkriterium erfüllen an
   *
   * @param f - ein Prädikat-Objekt, welches das Filterkriterium implementiert
   * @param c - ein Consumer der die auf die Artikel anzuwendende Operation implementiert
   */
  public void applyToSomeArticles(Predicate<Artikel> f, Consumer<Artikel> c)
    {
       Artikel einArtikel;
     
       for (Map.Entry<Integer, Artikel> entry : lager.entrySet())         //NEU
         {
           einArtikel = entry.getValue();                                 //NEU
           if (f.test(einArtikel))
             {
               c.accept(einArtikel);
             }
         }
    }

  //------------------ getArticles  --------------------------------------
  /**
   * liefert eine sortierte Liste der Artikel, die ein gegebenes Filterkriterium erfüllen
   *
   * @param f - ein Prädikat-Objekt, welches das Filterkriterium implementiert
   * @param c - ein Prädikat-Objekt, welches das Sortierkriterium implementiert
   * @return eine sortierte Liste der gefilterten Artikel
   */
  public Artikel[] getArticles(Predicate<Artikel> f, BiPredicate<Artikel, Artikel> c)
    {
      List<Artikel> filtered = filter(f);

      Artikel[] result = filtered.toArray(new Artikel[filtered.size()]);

      sort(c, result);

      return result;
    }

  //------------------ filterAll  --------------------------------------
  /**
   * Filtert die Artikel im Lager nach den an die Methode übergebenen Filterkriterien. 
   * 
   * @param fKriterien - Prädikat-Objekte, welche die Filterkriterien implementieren
   * @return eine Liste alle Artikel im Lager, die alle Filterkriterien erfüllen. 
   */
  public Artikel[]  filterAll(Predicate<Artikel>... fKriterien)
    {
      List<Artikel> zuFiltern = Arrays.asList(lager.values().toArray(new Artikel[lager.size()]));    //NEU
      ArrayList<Artikel> geFiltert = new ArrayList<Artikel>();

      for (int k = 0; k < fKriterien.length; k++)
         {
          for ( Artikel a : zuFiltern )
             {
               if ( fKriterien[k].test(a) )
             {
                   geFiltert.add(a);
             }
             }

          zuFiltern = new ArrayList<Artikel>(geFiltert);

          if ( k < fKriterien.length -1 )
            {
              geFiltert = new ArrayList<Artikel>();
            }
         }
      return geFiltert.toArray(new Artikel[geFiltert.size()]); 
    }

 //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 // neue Funktionen ueb18
 //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
}

