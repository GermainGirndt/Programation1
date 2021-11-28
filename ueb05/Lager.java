
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
   
   public Lager(int lagerplatzanzahl) {
       this.artikelLager = new Artikel[lagerplatzanzahl];   
    }
    
    public Lager() {
        this(STANDARD_LAGER_GROESSE);
    }
    
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
    
    
    public void bucheZugang(int artikelNr, int zugang) {
        Artikel artikel = this.getArtikelNachNummer(artikelNr);
        artikel.bucheZugang(zugang);
    }
    
    public void bucheAbgang(int artikelNr, int abgang) {
        Artikel artikel = this.getArtikelNachNummer(artikelNr);
        artikel.bucheZugang(abgang);
    }
    
    public void aenderePreisEinesArtikels(int artikelNr, double prozent) {
        Artikel artikel = this.getArtikelNachNummer(artikelNr);
        artikel.aenderePreis(prozent);
    }
    
    public void aenderePreisAllerArtikel(double prozent) {
        
        if (this.checkeObLagerLeerIst()) {
            throw new IllegalArgumentException("Der Artikelpreis kann nicht verändert werden, wenn das Lager leer ist.");
        }

        for (int index = 0; index <= this.anzahlArtikel -1; index++) {
            Artikel artikel = this.artikelLager[index];

            artikel.aenderePreis(prozent);
        }   
    }
    
    
    private boolean checkeObNeuerArtikelAngelegtWerdenKann() {
        return this.anzahlArtikel + 1 <= this.artikelLager.length;

    }

    private boolean checkeObLagerLeerIst() {
        return this.anzahlArtikel == 0;
    }

    
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
    
    private Artikel getArtikelNachNummer(int artikelNr) {
        for (int index = 0; index <= this.anzahlArtikel -1; index++) {
            Artikel artikelZuChecken = this.artikelLager[index];

            if (artikelZuChecken.getArtikelNr() == artikelNr) {
                return artikelZuChecken;
            }
        }    
        
        throw new IllegalArgumentException("Artikel ist nicht im Lager.");
    }

    private boolean checkeObArtikelNummerImLagerIst(int artikelNr) {
        for (int index = 0; index <= this.anzahlArtikel -1; index++) {
            Artikel artikelZuChecken = this.artikelLager[index];

            if (artikelZuChecken.getArtikelNr() == artikelNr) {
                return true;
            }
        }    
        
        return false;
    }
 
 

    public Artikel getArtikel(int index) { 
        return this.artikelLager[index];
    }

   public String toString() {
       StringBuilder builder = new StringBuilder();
       
       builder.append("Lager enthält folgende Artikel: \n");
       for(Artikel artikel : this.artikelLager) {
           builder.append(artikel.toString() + "\n");
       }
       return builder.toString();
   }

   public int getArtikelAnzahl() {
       return this.anzahlArtikel;
   }
   
   public int getLagerGroesse() {
       return this.artikelLager.length;
   }

   //Nur fuer Testzwecke, denke dran das zu löschen
   public static void main(String[] strg) {
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
