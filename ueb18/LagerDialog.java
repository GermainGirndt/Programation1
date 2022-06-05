import java.util.InputMismatchException;

/**
 * Die Klasse ArtikelDialog ist eine Dialogklasse zum Testen der Klasse Artikel
 * 
 * @author Girndt & Krier 
 * @version 1.0
 */
public class LagerDialog
{
    private              Lager          lager;
    private              UserInput      userInput;
    private              int            funktion;
    private              int            artikelfunktion;
    
    private static final int            FUNKTION_NICHT_DEFINIERT                =  -1;
    private static final int            FUNKTION_ENDE                           =  0;
    private static final int            LAGER_ERSTELLEN                         =  1;
    private static final int            LAGER_ERSTELLEN_INITIAL                 =  2;
    private static final int            ARTIKEL_ANLEGEN                         =  3;
    private static final int            ARTIKEL_ENTFERNEN                       =  4;
    private static final int            FUNKTION_ZUBUCHEN                       =  5;
    private static final int            FUNKTION_ABBUCHEN                       =  6;
    private static final int            FUNKTION_PREIS_AENDERN_EINZELN          =  7;
    private static final int            FUNKTION_PREIS_AENDERN_ALLE             =  8;
    private static final int            LAGER_AUSGEBEN                          =  9;
    private static final int            LAGER_GROESSE_AUSGEBEN                  =  10;
    private static final int            ARTIKEL_ANZAHL_AUSGEBEN                 =  11;
    private static final int            LAGERPLATZ_ANSCHAUEN                    =  12;
    private static final int            ARTIKELSTANDORT_BEKOMMEN                =  13;
    private static final int            BESTANDSLISTE_AUSGEBEN                  =  14;
        
    private static final int            EINFACHER_ARTIKEL                       =  1;
    private static final int            ARTIKEL_VIDEO_ANLEGEN                   =  2;
    private static final int            ARTIKEL_CD_ANLEGEN                      =  3;
    private static final int            ARTIKEL_BUCH_ANLEGEN                    =  4;
    
    
    private static final String         LAGER_NULL                              = "Der Befehl setzt voraus, dass ein Lager angelegt ist!";
    private static final String         LAGER_EXISTIERT                         = "Ein Lager existiert schon!";
    private static final String         ARTIKELNUMMER_FRAGE                     = "Zu welcher Artikelnummer? ";
    private static final String         PROZENTANTEIL_FRAGE                     = "Um wie viel Prozent handelt es sich? ";
    private static final String         LAGER_VOLL                              = "Der Artikel passt nicht im Lager. Entferne einen Artikel, um einen neuen anzulegen.";
    private static final String         ARTIKEL_NICHT_DA                        = "Es gibt diesen Artikel nicht im Lager. ";
    private static final String         PREISAENDERUNG_ALLE_ERFOLGREICH         = "Alle Preise sind geändert worden! ";
    private static final String         PREISAENDERUNG_EIN_ERFOLGREICH          = "Der Preis des Artikels wurde geändert! ";
    private static final String         ABGANG_ERFOLGREICH                      = "Abgang wurde gebucht. ";
    private static final String         ZUGANG_ERFOLGREICH                      = "Zugang wurde gebucht. ";
    private static final String         ARTIKEL_ENTFERNT_FRAGE                  = "Geben Sie die Artikelnummer des zu entfernenden Artikels ein: ";
    private static final String         ARTIKEL_ENTFERNT                        = "Artikel wurde entfernt. ";
    private static final String         LAGERPLATZ_FRAGE                        = "Welcher Lagerplatz? ";
    private static final String         ABGANG_FRAGE                            = "Welche Menge soll abgebucht werden? ";
    private static final String         ZUGANG_FRAGE                            = "Welche Menge soll zugebucht werden? ";
    private static final String         ARTIKELNR_FRAGE                         = "Artikelnummer?: ";
    private static final String         AUTOR_FRAGE                             = "Autor?: ";
    private static final String         TITEL_FRAGE                             = "Titel?: ";
    private static final String         LAENGE_FRAGE                            = "Laenge?: ";
    private static final String         BESTAND_FRAGE                           = "Bestand?: ";
    private static final String         PREIS_FRAGE                             = "Preis?: ";
    private static final String         VERLAG_FRAGE                            = "Verlag?: ";
    private static final String         JAHR_FRAGE                              = "Erscheinungsjahr?: ";
    private static final String         INTERPRET_FRAGE                         = "Interpret?: ";
    private static final String         ANZAHL_TITEL_FRAGE                      = "Anzahl der Titel?: ";
    private static final String         VIDEO_ERFOLGREICH                       = "Video wurde angelegt. ";
    private static final String         CD_ERFOLGREICH                          = "CD wurde angelegt. ";
    private static final String         BUCH_ERFOLGREICH                        = "Buch wurde angelegt. ";
    private static final String         ARTIKEL_ERFOLGREICH                     = "Artikel wurde angelegt. ";
    private static final String         ART_FRAGE                               = "Art des Artikels?: ";
    private static final String         ARTIKEL_BEREITS_DA                      = "Die eingegebene Artikelnummer ist bereits im Lager!";
    private static final String         NICHT_GUELTIG                           = "Keine gueltige Eingabe. ";
    private static final String         LAGER_ERFOLGREICH                       = "Lager wurde erstellt. ";
    private static final String         LAGER_FRAGE                             = "Lagergroesse? ";
    private static final String         PROGRAMM_ENDE                           = "Das Programm ist zu Ende. ";
    private static final String         FUNKTION                                = "Ausgewaehlte Funktion: ";
    
    /**
    * Konstruktor
    */
    public LagerDialog() {
        userInput = new UserInput();
    }
    
    public static void main(String[] args) {
        LagerDialog lagerDialog = new LagerDialog();
        lagerDialog.start();  
    }

    /**
    * Hauptschleife der Lagerdialog Klasse
    */
    public void start() {
        this.lager           = null;
        this.funktion        = FUNKTION_NICHT_DEFINIERT;
        
        while(this.funktion != FUNKTION_ENDE) {
            try {
                einlesenFunktion();
                ausfuehrenFunktion();
                
            } catch (IllegalArgumentException error) {
                System.err.println(error);

            } catch (InputMismatchException error) {
                System.err.println(error);
                userInput.next();

            } catch (Exception error) {
                System.err.println(error);
                error.printStackTrace(System.out); 

            }
        }
    }
    
    /**
    * Diese Funktion liest ein welche Funktion ausgefuehrt werden soll
    * @return funktion die ausgewaehlt wurde
    */
    public void einlesenFunktion() {
        
        System.out.print(
            "\n\n" +
            LAGER_ERSTELLEN                 + ": Lager erstellen mit bestimmter Groesse;\n"      +
            LAGER_ERSTELLEN_INITIAL         + ": Lager erstellen mit Initialgroesse 10;\n"       +
            ARTIKEL_ANLEGEN                 + ": Artikel im Lager anlegen;\n"                    + 
            ARTIKEL_ENTFERNEN               + ": Artikel aus dem Lager entfernen;\n"             + 
            FUNKTION_ZUBUCHEN               + ": Menge zum Bestand eines Artikels dazubuchen;\n" +
            FUNKTION_ABBUCHEN               + ": Menge vom Bestand eines Artikels abbuchen;\n"   + 
            FUNKTION_PREIS_AENDERN_EINZELN  + ": Preis eines Artikels aendern;\n"                +
            FUNKTION_PREIS_AENDERN_ALLE     + ": Preis aller Artikel aendern;\n"                 + 
            LAGER_AUSGEBEN                  + ": Lager ausgeben;\n"                              +
            LAGER_GROESSE_AUSGEBEN          + ": Lagergroesse ausgeben;\n"                       +
            ARTIKEL_ANZAHL_AUSGEBEN         + ": Artikelanzahl im Lager ausgeben;\n"             +
            LAGERPLATZ_ANSCHAUEN            + ": Lagerplatz anschauen;\n"                        +
            ARTIKELSTANDORT_BEKOMMEN        + ": Artikelstandort bekommen;\n"                    +
            BESTANDSLISTE_AUSGEBEN          + ": Bestandsliste ausgeben;\n"                      +
            FUNKTION_ENDE                   + ": beenden -> \n\n"   
        );
        
        this.funktion = userInput.getInt(FUNKTION);
        System.out.println();
    }
    
    /**
    * Diese Funktion fuehrt je nach Parameter die dazugehoerige Funktion aus
    * @param funktion die ausgefuehrt werden soll
    */
    public void ausfuehrenFunktion() {

        switch(this.funktion) {
            case LAGER_ERSTELLEN:
                lagerErstellen();
                break;
            case LAGER_ERSTELLEN_INITIAL:
                this.lager = new Lager();
                System.out.println(LAGER_ERFOLGREICH);
                break;
            case ARTIKEL_ANLEGEN:
                artikelAnlegen();
                break;
            case ARTIKEL_ENTFERNEN: 
                artikelEntfernen();
                break;
            case FUNKTION_ZUBUCHEN:      
                bestandZubuchen();
                break;
            case FUNKTION_ABBUCHEN:
                bestandAbbuchen();
                break;
            case FUNKTION_PREIS_AENDERN_EINZELN:
                einzelnpreisAendern();
                break;
            case FUNKTION_PREIS_AENDERN_ALLE:  
                allePreiseAendern();
                break;
            case LAGER_AUSGEBEN:
                lagerAusgeben();
                break;
            case LAGER_GROESSE_AUSGEBEN:
                System.out.println("Lagergroesse: " + lager.getLagerGroesse());
                break;
            case ARTIKEL_ANZAHL_AUSGEBEN:
                System.out.println("Artikelanzahl: " + lager.getArtikelAnzahl());
                break;
            case LAGERPLATZ_ANSCHAUEN:
                lagerPlatzAnschauen();
                break;
            case ARTIKELSTANDORT_BEKOMMEN:
                arikelstandortBekommen();
                break;
            case BESTANDSLISTE_AUSGEBEN:
                ausgebenBestandsListe();
                break;
            case FUNKTION_ENDE:  
                System.out.println(PROGRAMM_ENDE);
                break;
            default:
                System.out.println( NICHT_GUELTIG);
                break;
        }
    }
    
    /**
    * Gibt die Bestandsliste auf der Konsole aus
    */
    public void  ausgebenBestandsListe() {
        if (this.lager == null) throw new IllegalArgumentException(LAGER_NULL);
        System.out.println(lager.ausgebenBestandsListe());
    }
    
    /**
    * Diese Funktion fragt nach einer Lagergroesse und erzeugt dann ein Lager
    */
    public void lagerErstellen() {
        if (this.lager != null) throw new IllegalArgumentException(LAGER_EXISTIERT);    
        
        int lagergroesse = this.userInput.getInt(LAGER_FRAGE);
        
        this.lager = new Lager(lagergroesse);
        System.out.println(LAGER_ERFOLGREICH);
    }
    
    /**
    * Diese Funktion liest ein welche Art von Artikel angelegt werden soll
    */
    public void  leseArtikelGruppeEin() {
         System.out.print(
            "\n\n" +
            EINFACHER_ARTIKEL              + ": einfacher Artikel anlegen;\n"         +
            ARTIKEL_VIDEO_ANLEGEN          + ": Video anlegen;\n"                     +
            ARTIKEL_CD_ANLEGEN             + ": CD anlegen;\n"                        +
            ARTIKEL_BUCH_ANLEGEN           + ": Buch anlegen;\n"                      +
            FUNKTION_ENDE                  + ": beenden -> \n\n"   
        );
        
        this.artikelfunktion = userInput.getInt(FUNKTION);  
    }
    
    
    /**
    * Diese Funktion erfragt je nach ausgewählter Artikelart die nötigen Information und legt dann einen
    * Artikel dieser Art an
    */
    public void artikelfunktionAusfuehren() {
        int artikelNr     = 0;
        int bestand       = 0;
       
        double preis      = 0.0;
        
        if (this.artikelfunktion <= ARTIKEL_BUCH_ANLEGEN && this.artikelfunktion > FUNKTION_ENDE) {
            artikelNr     = this.userInput.getInt(ARTIKELNR_FRAGE);
            Validierung.validiereArtikelNr(artikelNr);
        
            if (lager.getArtikelNachNummer(artikelNr) != -1) {
                throw new IllegalArgumentException(ARTIKEL_BEREITS_DA );
            }
            
            bestand    = this.userInput.getInt(BESTAND_FRAGE);
            Validierung.validiereBestand(bestand);
            preis      = this.userInput.getDouble(PREIS_FRAGE);
            Validierung.validierePreis(preis);
        }
        

        switch(this.artikelfunktion) {
            case ARTIKEL_VIDEO_ANLEGEN:
                 String titelvideo = this.userInput.getString(TITEL_FRAGE);
                 Validierung.validiereTitel(titelvideo);
                 int laenge        = this.userInput.getInt(LAENGE_FRAGE);
                 Validierung.validiereSpieldauer(laenge);
                 int jahr          = this.userInput.getInt(JAHR_FRAGE);
                 Validierung.validiereJahr(jahr);
                 Video video        = new Video(artikelNr, bestand, preis, titelvideo, laenge, jahr);
                 lager.legeAnArtikel(video);
                 System.out.println(VIDEO_ERFOLGREICH);
                 break;
                 
            case  ARTIKEL_CD_ANLEGEN:
                  String interpret   = this.userInput.getString(INTERPRET_FRAGE);
                  Validierung.validiereInterpret(interpret);
                  String titelcd     = this.userInput.getString(TITEL_FRAGE);
                  Validierung.validiereTitel(titelcd);
                  int anzahlTitel    = this.userInput.getInt(ANZAHL_TITEL_FRAGE);
                  Validierung.validiereAnzahlTitel(anzahlTitel);
                  CD cd    = new CD(artikelNr, bestand, preis, interpret, titelcd, anzahlTitel);
                  lager.legeAnArtikel(cd);
                  System.out.println(CD_ERFOLGREICH);
                  break;
                  
            case  ARTIKEL_BUCH_ANLEGEN:
                  String autor       = this.userInput.getString(AUTOR_FRAGE);
                  Validierung.validiereAutor(autor);
                  String titelbuch   = this.userInput.getString(TITEL_FRAGE);
                  Validierung.validiereTitel(titelbuch);
                  String verlag      = this.userInput.getString(VERLAG_FRAGE);
                  Validierung.validiereVerlag(verlag);
                  Buch buch          = new Buch(artikelNr, bestand, preis, autor, titelbuch, verlag);
                  lager.legeAnArtikel(buch);
                  System.out.println(BUCH_ERFOLGREICH);
                  break;
                  
            case EINFACHER_ARTIKEL:
                  String art= this.userInput.getString(ART_FRAGE);
                  Validierung.validiereArtikelArt(art);
                  Artikel artikel   = new Artikel(artikelNr, art,bestand, preis);
                  lager.legeAnArtikel(artikel);
                  System.out.println(ARTIKEL_ERFOLGREICH);
                break;
                
            case FUNKTION_ENDE:
                break;
                
            default:
                System.out.println( NICHT_GUELTIG);
                break;
                
        }
        
    }
    
    /**
    * Diese Funktion ist eine Unterdialogschleife es wird so lange gefragt welche Artikelart angelegt werden soll
    * bis der Nutzer 0 eingibt
    */
    public void artikelAnlegen() {
        if (this.lager == null) throw new IllegalArgumentException(LAGER_NULL);
        if ( lager.getArtikelAnzahl() >= lager.getLagerGroesse()) throw new IllegalArgumentException(LAGER_VOLL);
        
        this.artikelfunktion        = FUNKTION_NICHT_DEFINIERT;
        
        while(this.artikelfunktion != FUNKTION_ENDE) {
            try {
                leseArtikelGruppeEin();
                artikelfunktionAusfuehren();
                
            } catch (IllegalArgumentException error) {
                System.err.println(error);

            } catch (InputMismatchException error) {
                System.err.println(error);
                userInput.next();

            } catch (Exception error) {
                System.err.println(error);
                error.printStackTrace(System.out); 

            }
        }
       
    }
 

    /**
    * Diese Funktion fragt nach dem zu entfernenden Artikel und entfernt diesen dann
    */
    public void artikelEntfernen() {
        if (this.lager == null) throw new IllegalArgumentException(LAGER_NULL);
         
        int artikelNr = this.userInput.getInt(ARTIKEL_ENTFERNT_FRAGE);
        Validierung.validiereArtikelNr(artikelNr);
        
        this.lager.entferneArtikel(artikelNr);
        
        System.out.println(ARTIKEL_ENTFERNT);
    }


    public void bestandZubuchen() {

        if (this.lager == null) throw new IllegalArgumentException(LAGER_NULL);
        
        int artikelNr = this.userInput.getInt(ARTIKELNUMMER_FRAGE);
        Validierung.validiereArtikelNr(artikelNr);
        
        int zugang = this.userInput.getInt(ZUGANG_FRAGE);
        Validierung.validiereMengeanderung(zugang);
        
        this.lager.bucheZugang(artikelNr, zugang);

        System.out.println(ZUGANG_ERFOLGREICH );
    }
    
    public void bestandAbbuchen() {
        if (this.lager == null) throw new IllegalArgumentException(LAGER_NULL);
        
        int artikelNr = this.userInput.getInt(ARTIKELNUMMER_FRAGE);
        Validierung.validiereArtikelNr(artikelNr);
        
        int abgang = this.userInput.getInt(ABGANG_FRAGE);
        Validierung.validiereMengeanderung(abgang);
        
        this.lager.bucheAbgang(artikelNr, abgang);
        System.out.println(ABGANG_ERFOLGREICH );
    }
    
    public void einzelnpreisAendern() {
        if (this.lager == null) throw new IllegalArgumentException(LAGER_NULL);
        
        int artikelNr = this.userInput.getInt(ARTIKELNUMMER_FRAGE);
        Validierung.validiereArtikelNr(artikelNr);
        
        int prozent = this.userInput.getInt(PROZENTANTEIL_FRAGE);
        Validierung.validierePreisaenderung(prozent);
        
        this.lager.aenderePreisEinesArtikels(artikelNr, prozent);
        
        System.out.println(PREISAENDERUNG_EIN_ERFOLGREICH);
    }
    
    public void allePreiseAendern() {
        if (this.lager == null) throw new IllegalArgumentException(LAGER_NULL);

        int prozent = this.userInput.getInt( PROZENTANTEIL_FRAGE);
        Validierung.validierePreisaenderung(prozent);

        this.lager.aenderePreisAllerArtikel(prozent);
        
        System.out.println(PREISAENDERUNG_ALLE_ERFOLGREICH );
    }
  
    public void lagerAusgeben() {
        if (this.lager == null) throw new IllegalArgumentException(LAGER_NULL);

        System.out.println(lager.toString());
    }
    
    public void lagerPlatzAnschauen() {
        if (this.lager == null) throw new IllegalArgumentException(LAGER_NULL);
        
        int lagerplatz = this.userInput.getInt( LAGERPLATZ_FRAGE);
        
        if (lager.getArtikel(lagerplatz)==null) {
            System.out.println("leer");
        }
        else{
            System.out.println(lager.getArtikel(lagerplatz).toString()) ;
        }
    }
    
    public void arikelstandortBekommen() {
        if (this.lager == null) throw new IllegalArgumentException(LAGER_NULL);
        
        int artikelNr = this.userInput.getInt(ARTIKELNUMMER_FRAGE);
        Validierung.validiereArtikelNr(artikelNr);
        
        int platz = lager.getArtikelNachNummer(artikelNr);       
        
        if (platz == -1) {
            System.out.println(ARTIKEL_NICHT_DA);
        }
        else{
            System.out.println("Der Artikel ist am Lagerplatz: " + platz);
        }
    }
}
