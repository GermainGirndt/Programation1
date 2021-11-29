import java.lang.StringBuilder;

/**
 * Beschreiben Sie hier die Klasse Lager.
 * 
 * @author Girndt, Germain & Krier, Katharina  
 * @version 1.0
 */
public class Lager
{
   private Artikel[] artikelLager;
   private int anzahlArtikel                            = 0;
   private final static int STANDARD_LAGER_GROESSE      = 10;
   
   /**
   * Konstruktor für Lager mit Angabe über die Lagerplatzanzahl
   * @param lagerplatzanzahl ist die Anzahl an verfügbaren Plätze im Lager
   */
   public Lager(int lagerplatzanzahl) {
       Validierung.validiereLagergroesse(lagerplatzanzahl);
       this.artikelLager = new Artikel[lagerplatzanzahl];   
    }
    
    /**
    * Konstruktor für Lager ohne Angabe über die Lagerplatzanzahl
    */
    public Lager() {
        this(STANDARD_LAGER_GROESSE);
    }
    
        
    /**
    * Legt einen Artikel in den Lager an
    * @param artikel der im Lager angelegt werden soll
    */
    public void legeAnArtikel(Artikel artikel) {
       if (!this.checkeObNeuerArtikelAngelegtWerdenKann()) {
           throw new IllegalArgumentException("Der Artikel passt nicht im Lager. Entferne einen Artikel, um einen neuen anzulegen.");
        }

        if (this.checkeObArtikelNummerImLagerIst(artikel.getArtikelNr())) {
            throw new IllegalArgumentException("Die eingegebene Artikelnummer ist bereits im Lager!");
        }

        this.artikelLager[anzahlArtikel] = artikel;
        this.anzahlArtikel++;
        
    }
    
    /**
    * Entfernt einen Artikel über seine Nummer
    * @param artikelNr von dem zu entfernenden Artikel
    */
    public void entferneArtikel(int artikelNr) {
        if (this.checkeObLagerLeerIst()) {
            throw new IllegalArgumentException("Lager ist leer!");
        }
        
        for (int index = 0; index <= this.anzahlArtikel -1; index++) {
            Artikel artikelZuChecken = this.artikelLager[index];
            
            if (artikelZuChecken.getArtikelNr() == artikelNr) {
                loescheArtikelNachIndex(index);
                return;
            }
        }    
        
        throw new IllegalArgumentException("Nur Artikel im Lager können entfernt werden.");
    }
    
    /**
    * Die Methode bucht eine übergebene Menge dem Bestand von einem Artikel im Lager hinzu
    * @param zugang ist die Menge neuer Artikel, die dazugebucht wird
    */
    public void bucheZugang(int artikelNr, int zugang) {
        Artikel artikel = this.getArtikelNachNummer(artikelNr);
        artikel.bucheZugang(zugang);
    }
    
    /**
    * Die Methode bucht eine übergebene Menge dem Bestand von einem Artikel im Lager ab
    * @param abgang ist die Menge vom Artikel, die abgebucht wird
    */
    public void bucheAbgang(int artikelNr, int abgang) {
        Artikel artikel = this.getArtikelNachNummer(artikelNr);
        artikel.bucheZugang(abgang);
    }
    
    /**
    * Die Methode aendert den Preis eines Artikels im Lager
    * @param artikelNr ist die Nummer vom Artikel, dessen Preis zu ändern ist
    * @param prozent ist der Prozentsatz von der Änderung
    */
    public void aenderePreisEinesArtikels(int artikelNr, double prozent) {
        Artikel artikel = this.getArtikelNachNummer(artikelNr);
        artikel.aenderePreis(prozent);
    }

    /**
    * Die Methode aendert den Preis aller Artikel
    * @param prozent ist der Prozentsatz von der Änderung
    */
    public void aenderePreisAllerArtikel(double prozent) {
        
        if (this.checkeObLagerLeerIst()) {
            throw new IllegalArgumentException("Der Artikelpreis kann nicht verändert werden, wenn das Lager leer ist.");
        }

        for (int index = 0; index <= this.anzahlArtikel -1; index++) {
            Artikel artikel = this.artikelLager[index];

            artikel.aenderePreis(prozent);
        }   
    }
    
    /**
    * Die Methode checkt, ob ein neuer Artikel angelegt werden kann
    * dh. ob das Lager ueber genuegenden Platz verfuegt
    * @return true, wenn ja; false, wenn nein
    */
    private boolean checkeObNeuerArtikelAngelegtWerdenKann() {
        return this.anzahlArtikel + 1 <= this.artikelLager.length;
        
    }
    
    /**
     * Die Methode checkt, ob das Lager leer ist
     * dh. kein Artikel da ist
     * @return true, wenn ja; false, wenn nein
    */
    private boolean checkeObLagerLeerIst() {
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
            throw new IllegalArgumentException("Der gewählte Index übertrifft die Anzahl an Artikeln.");
        }

        artikelLager[indexZuLoeschen] = null;
        
        for (int indexZuVerschieben = indexZuLoeschen + 1; indexZuVerschieben <= this.anzahlArtikel - 1; indexZuVerschieben++) {
            if (artikelLager[indexZuVerschieben] == null) {
                break;
            }

            int letzterIndex = indexZuVerschieben -1;
            
            artikelLager[letzterIndex] = artikelLager[indexZuVerschieben];
            artikelLager[indexZuVerschieben] = null;
        }
        
        this.anzahlArtikel--;
    }


    /**
    * Die Methode gibt den Artikel mit der gewunschten Artikelnummer zurueck 
    * @param artikelNr ist die Artikelnummer vom gewuenschten Artikel
    * @return der gewuenschte Artikel
    */    
    private Artikel getArtikelNachNummer(int artikelNr) {
        for (int index = 0; index <= this.anzahlArtikel -1; index++) {
            Artikel artikelZuChecken = this.artikelLager[index];

            if (artikelZuChecken.getArtikelNr() == artikelNr) {
                return artikelZuChecken;
            }
        }    
        
        throw new IllegalArgumentException("Artikel ist nicht im Lager.");
    }

    /**
     * Die Methode checkt, ob es einen Artikel mit der eingegebenen Artikelnummer im Lager gibt
     * @param artikelNr ist die Artikelnummer vom gewuenschten Artikel
    * @return true wenn ja, false wenn nein
    */  
    private boolean checkeObArtikelNummerImLagerIst(int artikelNr) {
        for (int index = 0; index <= this.anzahlArtikel -1; index++) {
            Artikel artikelZuChecken = this.artikelLager[index];
            
            if (artikelZuChecken.getArtikelNr() == artikelNr) {
                return true;
            }
        }    
        
        return false;
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

        return this.artikelLager[index];
    }


   /**
   * Die Methode gibt das Objekt aufbereitet als String zurueck
   * @return gibt die Attribute des Artikels als String zurueck
   */
   public String toString() {

       if (checkeObLagerLeerIst()) {
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
}
