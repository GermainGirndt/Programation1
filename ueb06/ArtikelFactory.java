import java.util.HashMap;
import java.util.Map;

public class ArtikelFactory {

    public static       Map<String, Object> ARTIKEL_EINS_WERTE;
    public static       Map<String, Object> ARTIKEL_ZWEI_WERTE;
    public static       Map<String, Object> ARTIKEL_DREI_WERTE;
    public static       Map<String, Object> ARTIKEL_VIER_WERTE;
    public static       Map<String, Object> ARTIKEL_FUENF_WERTE;
    public static       Map<String, Object> ARTIKEL_SECHS_WERTE;
    public static       Map<String, Object> ARTIKEL_SIEBEN_WERTE;
    public static       Map<String, Object> ARTIKEL_ACHT_WERTE;
    public static       Map<String, Object> ARTIKEL_NEUN_WERTE;
    public static       Map<String, Object> ARTIKEL_ZEHN_WERTE;
    
    public void ArtikelFactory() {
        this.instanziereArtikelwerte();
    }
    
    public Artikel[] getArtikel (int artikelAnzahl) {
        
        Validierung.checkeObNatuerlicheZahl(artikelAnzahl);
        this.instanziereArtikelwerte(); // warum brauche ich das hier? habe ich die Methode vorher nicht aufgerufen?

        Artikel[] artikel = new Artikel[artikelAnzahl];
        
        for (int zaehler = 0; zaehler < artikelAnzahl; zaehler++) {
            System.out.println("antes");
            
            System.out.println("Tudo:");
            System.out.println(ARTIKEL_EINS_WERTE);
            System.out.println("Constante:");
            System.out.println(ArtikelKonstanten.NUMMER);
            System.out.println("Imprimindo valor:");
            System.out.println(ARTIKEL_EINS_WERTE.get(ArtikelKonstanten.NUMMER));

            int artikelnummer = (int) ARTIKEL_EINS_WERTE.get(ArtikelKonstanten.NUMMER);
            System.out.println("passou");

            String artikelart = (String) ARTIKEL_EINS_WERTE.get(ArtikelKonstanten.ART);
            int bestand = (int) ARTIKEL_EINS_WERTE.get(ArtikelKonstanten.BESTAND);
            double artikelpreis = (double) ARTIKEL_EINS_WERTE.get(ArtikelKonstanten.PREIS);


            artikel[zaehler] = new Artikel(artikelnummer, artikelart, bestand, artikelpreis);
        }

        return artikel;

    }

    private void instanziereArtikelwerte() {
        ARTIKEL_EINS_WERTE = new HashMap<String, Object>()
        {{
            put(ArtikelKonstanten.NUMMER, (int) 1111);
            put(ArtikelKonstanten.ART, (String) "Playstation");
            put(ArtikelKonstanten.BESTAND, (int) 5);
            put(ArtikelKonstanten.PREIS, (double) 750.00);
        }};

        ARTIKEL_ZWEI_WERTE = new HashMap<String, Object>()
        {{
            put(ArtikelKonstanten.NUMMER, (int) 1234);
            put(ArtikelKonstanten.ART, (String) "Nintendo Wii");
            put(ArtikelKonstanten.BESTAND, (int) 10);
            put(ArtikelKonstanten.PREIS, (double) 500.00);
        }};
        
        ARTIKEL_DREI_WERTE = new HashMap<String, Object>()
        {{
            put(ArtikelKonstanten.NUMMER, (int) 9999);
            put(ArtikelKonstanten.ART, (String) "X-Box");
            put(ArtikelKonstanten.BESTAND, (int) 0);
            put(ArtikelKonstanten.PREIS, (double) 600.00);
        }};

        ARTIKEL_VIER_WERTE = new HashMap<String, Object>()
        {{
            put(ArtikelKonstanten.NUMMER, (int) 9998);
            put(ArtikelKonstanten.ART, (String) "iPhone 12");
            put(ArtikelKonstanten.BESTAND, (int) 5);
            put(ArtikelKonstanten.PREIS, (double) 1000.00);
        }};


        ARTIKEL_FUENF_WERTE = new HashMap<String, Object>()
        {{
            put(ArtikelKonstanten.NUMMER, (int) 4567);
            put(ArtikelKonstanten.ART, (String) "Redmi Note 7");
            put(ArtikelKonstanten.BESTAND, (int) 50);
            put(ArtikelKonstanten.PREIS, (double) 300.25);
        }};


        ARTIKEL_SECHS_WERTE = new HashMap<String, Object>()
        {{
            put(ArtikelKonstanten.NUMMER, (int) 7946);
            put(ArtikelKonstanten.ART, (String) "Audi");
            put(ArtikelKonstanten.BESTAND, (int) 1);
            put(ArtikelKonstanten.PREIS, (double) 25000.00);
        }};



        ARTIKEL_SIEBEN_WERTE = new HashMap<String, Object>()
        {{
            put(ArtikelKonstanten.NUMMER, (int) 1000);
            put(ArtikelKonstanten.ART, (String) "Tesla");
            put(ArtikelKonstanten.BESTAND, (int) 1);
            put(ArtikelKonstanten.PREIS, (double) 99999.99);
        }};



        ARTIKEL_ACHT_WERTE = new HashMap<String, Object>()
        {{
            put(ArtikelKonstanten.NUMMER, (int) 9979);
            put(ArtikelKonstanten.ART, (String) "Raumschiff");
            put(ArtikelKonstanten.PREIS, (double) 1250015498.3674);
            put(ArtikelKonstanten.BESTAND, (int) 0);
        }};



        ARTIKEL_NEUN_WERTE = new HashMap<String, Object>()
        {{
            put(ArtikelKonstanten.NUMMER, (int) 7698);
            put(ArtikelKonstanten.ART, (String) "Kaugummi");
            put(ArtikelKonstanten.PREIS, (double) 0.01);
            put(ArtikelKonstanten.BESTAND, (int) 999999);
        }};



        ARTIKEL_ZEHN_WERTE = new HashMap<String, Object>()
        {{
            put(ArtikelKonstanten.NUMMER, (int) 4000);
            put(ArtikelKonstanten.ART, (String) "Hantel");
            put(ArtikelKonstanten.PREIS, (double) 20.99);
            put(ArtikelKonstanten.BESTAND, (int) 42);
        }};
    }
}
