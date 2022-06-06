import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Beschreiben Sie hier die Klasse Lager.
 * 
 * @author Girndt, Germain & Krier, Katharina  
 * @version 1.0
 */

 public class Lager {

   private Artikel[] artikelLager;
   private int anzahlArtikel                            = 0;
   private final static int STANDARD_LAGER_GROESSE      = 10;
   private final static double STARTSUMME               = 0.0;
   private final static double HUNDERT                  = 100.0;
   private final static int GRENZETABSBESTAND           = 999999;
   private final static int OBEREGRENZEBESCHREIBUNG     = 23;
   private final static int MITTLEREGRENZEBESCHREIBUNG  = 16;
   private final static int UNTEREGRENZEBESCHREIBUNG    = 7;
   private final static double GRENZETABSPREIS          = 9999999.00;
   
   /**
   * Konstruktor fuer Lager mit Angabe ueber die Lagerplatzanzahl
   * @param lagerplatzanzahl ist die Anzahl an verfuegbaren Plätze im Lager
   */
   public Lager(int lagerplatzanzahl) {
       Validierung.validiereLagergroesse(lagerplatzanzahl);
       this.artikelLager = new Artikel[lagerplatzanzahl];   
    }
    
    /**
    * Konstruktor fuer Lager ohne Angabe ueber die Lagerplatzanzahl
    */
    public Lager() {
        this(STANDARD_LAGER_GROESSE);
    }


    // Aufgabe A
    public Artikel[] getSorted( BiPredicate<Artikel, Artikel> sortierkriterium ) {

        Artikel[] sortiertesArray = this.getSorted(this.artikelLager, sortierkriterium);

        return sortiertesArray;
    }

    // Für Aufgabe 1.c
    public Artikel[] sortAll(BiPredicate<Artikel, Artikel>... sortierkriteria ) {
        Artikel[] artikelLager = this.artikelLager;
        for (BiPredicate<Artikel, Artikel> sortierkriterium : sortierkriteria) {
            artikelLager = this.getSorted(artikelLager, sortierkriterium);
        }
        return artikelLager;
    }


    // Aufgabe B
    public Artikel[] applyToArticles( UnaryOperator<Artikel> operation ) {

        Artikel[] artikel = this.applyToArticles(this.artikelLager, operation);

        return artikel;

    }
    
    // Aufgabe D
    public Artikel[] filter( Predicate<Artikel> filterkriterium ) {


        Artikel[] gefiltetesArtikellager = this.filter(this.artikelLager, filterkriterium);
        
        return gefiltetesArtikellager;
    }

    // Aufgabe E
    public Artikel[] applyToSomeArticles( UnaryOperator<Artikel> operation, Predicate<Artikel> operationkriterium ) {

        Artikel[] zielartikel = this.filter(operationkriterium);
        Artikel[] bearbeiteteArtikel = this.applyToArticles(zielartikel, operation);

        return bearbeiteteArtikel;
    }

    // Aufgabe F
    public Artikel[] getArticles( BiPredicate<Artikel, Artikel> sortierkriterium, Predicate<Artikel> suchkriterium ) {

        Artikel[] gefilterteArtikel = this.filter(suchkriterium);
        Artikel[] sortierteArtikel = this.getSorted(gefilterteArtikel, sortierkriterium);

        return sortierteArtikel;
    }

    // Aufgabe G
    // To do: Ersetzten Predicate<Artikel>[] durch Parameterliste
    public Artikel[] filterAll(Predicate<Artikel>... suchkriteria ) {
        Artikel[] artikelLager = this.artikelLager;
        for (Predicate<Artikel> suchkriterium : suchkriteria) {
            artikelLager = this.filter(artikelLager, suchkriterium);
        }
        return artikelLager;

    }
    
    // Hilfsmethode
    private Artikel[] filter( Artikel[] artikel, Predicate<Artikel> filterkriterium ) {

        int zaehler = 0;
        List<Integer> indexList = new LinkedList<>();
    
        for (int i = 0; i < anzahlArtikel; i++ ) {
            if (filterkriterium.test(artikel[i])) {
                zaehler++;
                indexList.add(i);
            }
        }
        
        Artikel[] gefiltetesArtikellager = new Artikel[zaehler];
        
        int listZaehler = 0;
        
        for (int index : indexList) {
            gefiltetesArtikellager[listZaehler++] = artikel[index];
        }
        
        return gefiltetesArtikellager;
    }

    // Hilfsmethode
    private Artikel[] applyToArticles( Artikel[] artikel, UnaryOperator<Artikel> operation ) {

        for (int i = 0; i < artikel.length; i++ ) {
            operation.apply(artikel[i]);
        }

        return artikel;
    }

    // Hilfsmethode
    private Artikel[] getSorted( Artikel[] artikel, BiPredicate<Artikel, Artikel> sortierkriterium ) {

        Artikel[] array = Arrays.copyOf(artikel, artikel.length);
        
        for (int i=0; i < array.length; i++) {
            for (int j=1; j < anzahlArtikel; j++) {
                if (sortierkriterium.test(array[j-1], array[j])) {
                    Artikel temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }
    
        
    /**
    * Legt einen Artikel in den Lager an
    * @param artikel der im Lager angelegt werden soll
    */
    public void legeAnArtikel(Artikel artikel) {
        if (!this.istLagerVoll()) {
           throw new IllegalArgumentException(LagerKonstanten.ERROR_LAGER_IST_VOLL);
        }

        if (artikel == null) {
            throw new IllegalArgumentException(LagerKonstanten.ERROR_NULL_ARTIKEL);
        }
        
        if (this.getArtikelNachNummer(artikel.getArtikelNr()) != -1) {
            throw new IllegalArgumentException(LagerKonstanten.ERROR_WIEDERHOLTE_ARTIKELNUMMER);
        }
        
        this.artikelLager[anzahlArtikel] = artikel;
        this.anzahlArtikel++;
        
    }
    
    /**
    * Entfernt einen Artikel ueber seine Nummer
    * @param artikelNr von dem zu entfernenden Artikel
    */
    public void entferneArtikel(int artikelNr) {
        if (this.lagerLeer()) {
            throw new IllegalArgumentException(LagerKonstanten.ERROR_LAGER_IST_LEER);
        }

        int index = this.getArtikelNachNummer(artikelNr);

        if (index == -1) {
            throw new IllegalArgumentException(LagerKonstanten.ERROR_ZU_ENTFERNENDER_ARTIKEL_NICHT_IM_LAGER);
        }

        loescheArtikelNachIndex(index);
    }
    
    /**
    * Die Methode bucht eine uebergebene Menge dem Bestand von einem Artikel im Lager hinzu
    * @param zugang ist die Menge neuer Artikel, die dazugebucht wird
    */
    public void bucheZugang(int artikelNr, int zugang) {
        Artikel artikel = artikelLager[this.getArtikelNachNummer(artikelNr)];
        if (artikel != null) {
            artikel.bucheZugang(zugang);   
        }
    }
    
    /**
    * Die Methode bucht eine uebergebene Menge dem Bestand von einem Artikel im Lager ab
    * @param abgang ist die Menge vom Artikel, die abgebucht wird
    */
    public void bucheAbgang(int artikelNr, int abgang) {
        Artikel artikel = artikelLager[this.getArtikelNachNummer(artikelNr)];
        if (artikel != null) {
            artikel.bucheAbgang(abgang);    
        }
    }
    
    /**
    * Die Methode aendert den Preis eines Artikels im Lager
    * @param artikelNr ist die Nummer vom Artikel, dessen Preis zu ändern ist
    * @param prozent ist der Prozentsatz von der Änderung
    */
    public void aenderePreisEinesArtikels(int artikelNr, double prozent) {
        Artikel artikel = artikelLager[this.getArtikelNachNummer(artikelNr)];
        if (artikel != null) {
            artikel.aenderePreis(prozent);  
        }
    }

    /**
    * Die Methode aendert den Preis aller Artikel
    * @param prozent ist der Prozentsatz von der Änderung
    */
    public void aenderePreisAllerArtikel(double prozent) {
        
        if (this.lagerLeer()) {
            throw new IllegalArgumentException(LagerKonstanten.ERROR_LAGER_IST_LEER);
        }

        for (int index = 0; index <= this.anzahlArtikel -1; index++) {
            Artikel artikel = this.artikelLager[index];
            
            if (artikel != null) {
                artikel.aenderePreis(prozent);  
            }
        }   
    }
    
    /**
    * Die Methode checkt, ob ein neuer Artikel angelegt werden kann
    * dh. ob das Lager ueber genuegenden Platz verfuegt
    * @return true, wenn ja; false, wenn nein
    */
    private boolean istLagerVoll() {
        return this.anzahlArtikel + 1 <= this.artikelLager.length;
        
    }
    
    /**
     * Die Methode checkt, ob das Lager leer ist
     * dh. kein Artikel da ist
     * @return true, wenn ja; false, wenn nein
    */
    private boolean lagerLeer() {
        return this.anzahlArtikel == 0;
    }

    /**
    * Die Methode setzt die gewuenschte Indexstelle als Null
    * und verschiebt jeden Wert danach eine Stelle nach hinten, 
    * sodass es keine Luecke im Array gibt
    * @param indexZuLoeschen ist der Arrayindex, der entfernt werden soll
    */
    private void loescheArtikelNachIndex(int indexZuLoeschen) {
        
        if (this.anzahlArtikel - 1 < indexZuLoeschen) {
            throw new IllegalArgumentException("Der gewählte Index uebertrifft die Anzahl an Artikeln.");
        }
        if (indexZuLoeschen < 0) {
            throw new IllegalArgumentException("Der gewählte Index muss positiv sein.");
        }
        
        int indexLeztenArtikels = this.anzahlArtikel -1;
        for (int indexZuVerschieben = indexZuLoeschen; indexZuVerschieben < indexLeztenArtikels; indexZuVerschieben++) {            
            artikelLager[indexZuVerschieben] = artikelLager[indexZuVerschieben + 1];
        }
        artikelLager[indexLeztenArtikels] = null;
        this.anzahlArtikel--;
    }


    /**
    * Die Methode gibt den Index der gewunschten Artikelnummer zurueck 
    * @param artikelNr ist die Artikelnummer vom gewuenschten Artikel
    * @return der Index des Artikels, -1 falls dieser Artikel nicht im Lager ist
    */    
    public int getArtikelNachNummer(int artikelNr) {
        for (int index = 0; index <= this.anzahlArtikel -1; index++) {
            Artikel artikelZuChecken = this.artikelLager[index];

            if (artikelZuChecken.getArtikelNr() == artikelNr) {
                return index;
            }
        }    
        
        return -1;
    }


    
    /**
    * Die Methode gibt den Artikel im gewuenschten Index zurueck 
    * @param index ist der Index vom gewuenschten Artikel
    * @return der gewuenschte Artikel
    */    
    public Artikel getArtikel(int index) { 

        if (index > this.anzahlArtikel -1) {
            throw new Error("Es gibt keinen Artikel im gewählten Index.");
        }
        if (index <0) {
            throw new Error("Bitte positiven Index angeben.");
        }

        return this.artikelLager[index];
    }


    /**
    * Die Methode gibt das Objekt aufbereitet als String zurueck
    * @return gibt die Attribute des Artikels als String zurueck
    */
    public String toString() {

        if (lagerLeer()) {
            return "Das Lager ist leer.";
        }
 
        StringBuilder builder = new StringBuilder("Lager enthält folgende Artikel: \n");
        
 
        for (int index = 0; index <= this.anzahlArtikel -1; index++) {
         Artikel artikel = artikelLager[index];
         String artikelBeschreibung = artikel.toString() + "\n\n";
         builder.append(artikelBeschreibung);
        }    
 
        return builder.toString();
   }

    /**
    * Die Methode gibt die Anzahl an Artikel im Lager zurueck 
    * @return die Anzahl an Artikel im Lager
    */ 
    public int getArtikelAnzahl() {
      return this.anzahlArtikel;
    }
    
    /**
    * Die Methode gibt die Gesamtanzahl an verfuegbaren Platzen im Lager zurueck 
    * @return die Gesamtanzahl an verfuegbaren Platzen im Lager
    */ 
    public int getLagerGroesse() {
        return this.artikelLager.length;
    }
    
    /**
    * Die Methode gibt die Bestandsliste als String zurueck und rechnet den Wert aller Artikel aus
    * und gibt am Schluss noch den Gesamtwert des Lagers an
    * @return die Bestandsliste als String
    */
    public String ausgebenBestandsListe() {
        double gesamt = STARTSUMME;
        String ausgabe = LagerKonstanten.KOPFZEILE+ LagerKonstanten.TRENNSTRICH;
        for(Artikel artikel: artikelLager) {
            if (artikel != null) {
                double gesamtartikel = artikel.getPreis() * artikel.getBestand();
                gesamtartikel        = Math.round(gesamtartikel*HUNDERT)/ HUNDERT;
                gesamt += gesamtartikel;
                
                ausgabe += artikel.getArtikelNr() + "\t" + artikel.getBeschreibung();  
                ausgabe += gibTabsNachBeschreibung(artikel.getBeschreibung());
                
                ausgabe += artikel.getPreis();
                ausgabe += gibTabsNachPreis(artikel.getPreis());
                
                ausgabe += artikel.getBestand();
                ausgabe += gibTabsNachBestand(artikel.getBestand());
                
                ausgabe += gesamtartikel + "\n";
                     
            }
            else{
                break;
            }
        }
        gesamt   = Math.round(gesamt * HUNDERT)/ HUNDERT;
        ausgabe += LagerKonstanten.TRENNSTRICH;
        ausgabe += LagerKonstanten.GESAMT      + gesamt; 
        return ausgabe;
    }
    
    /**
    * Die Methode gibt die richtige Anzahl an Tabs zurueck je nachdem wie gross der Bestand ist
    * damit die Ausgabe schoen aussieht und alles richtig untereinander steht
    * @return die Tabs
    */
    private String gibTabsNachBestand(long bestand) {
        String ausgabe = "";
        
        if (bestand > GRENZETABSBESTAND) {
            ausgabe += "\t";    
        }
        else{
            ausgabe += "\t\t";
        }
        
        return ausgabe;
    }
    
    /**
    * Die Methode gibt die richtige Anzahl an Tabs zurueck je nachdem wie gross der Preis ist
    * damit die Ausgabe schoen aussieht und alles richtig untereinander steht
    * @return die Tabs
    */
    private String gibTabsNachPreis(double preis) {
        String ausgabe = "";
        double centbetrag = Math.round(preis * HUNDERT);
        
        if (centbetrag > GRENZETABSPREIS) {
            ausgabe += "\t";    
        }
        else{
            ausgabe += "\t\t";
        }
        
        return ausgabe;
    }
    
    /**
    * Die Methode gibt die richtige Anzahl an Tabs zurueck je nachdem wie lang die Beschreibung ist
    * damit die Ausgabe schoen aussieht und alles richtig untereinander steht
    * @return die Tabs
    */
    private String gibTabsNachBeschreibung(String s) {
        String ausgabe = "";
        if (s.length() > OBEREGRENZEBESCHREIBUNG) {
            ausgabe += "\t";
        }
        else if (s.length() <= OBEREGRENZEBESCHREIBUNG && s.length() > MITTLEREGRENZEBESCHREIBUNG) {
            ausgabe += "\t\t";
        }
        else if (s.length() <= MITTLEREGRENZEBESCHREIBUNG && s.length() > UNTEREGRENZEBESCHREIBUNG) {
            ausgabe +=  "\t\t\t";    
        }
        else{
            ausgabe +=  "\t\t\t\t";
        }
        return ausgabe;
    }
    
}
