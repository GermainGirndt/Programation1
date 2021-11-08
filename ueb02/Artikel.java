
/**
* Die Klasse Artikel ist für eine einfache Bestandsprüfung
*
* @author Girndt & Krier
* @version 1.1
*/
public class Artikel
{
private int     artikelNr;
private String  art;
private int     bestand;

/**
* Konstruktor für Artikel mit bekannten Bestand
* @param artikelNr ist die ArtikelNr
* @param art ist die Artikelart
* @param bestand steht für den initalen Bestand
*/
public Artikel(int artikelNr, String art, int bestand)
{
    validiereArtikelNr(artikelNr);
    
    validiereArtikelArt(art);
    
    validiereBestand(bestand);
    
    this.artikelNr  = artikelNr;
    this.art        = art;
    this.bestand    = bestand;
}

/**
* Konstruktor für Artikel ohne Bestandsangabe
* @param artikelNr ist die ArtikelNr
* @param art ist die Artikelart
*/
public Artikel(int artikelNr, String art)
{
    this(artikelNr, art, 0);
}

/**
* Die Methode bucht eine übergebene Menge dem Bestand hinzu
* @param menge ist die Menge, die dazugebucht wird
*/
public void bucheZugang(int menge)
{
    validiereMenge(menge);
    
    bestand += menge;
}

/**
* Die Methode bucht eine übergebene Menge dem Bestand ab
* @param menge ist die Menge, die abgebucht wird
*/
public void bucheAbgang(int menge)
{
    validiereAbgangsMenge(menge);
    
    bestand -= menge;
}

/**
* Die Methode prüft ob die Menge fürs Buchen positiv ist, falls nicht gibt es eine Exception
* @param menge ist die Menge 
*/
public void validiereMenge(int menge){
    if(menge<0){
        throw new IllegalArgumentException("Die Menge muss positiv sein");
    }
}

/**
* Die Methode prüft ob die Menge positiv und kleiner als der Bestand ist, falls nicht gibt es eine Exception
* @param menge ist die Menge 
*/
public void validiereAbgangsMenge(int menge){
    validiereMenge(menge);
    
    if(bestand<menge){
        throw new IllegalArgumentException("Die abgebuchte Menge darf nicht groesser als der Bestand sein");
    }
}

/**
* Die Methode prüft ob die Artikelart nicht leer ist, falls doch gibt es eine Exception
* @param art ist die ArtikelArt
*/
public void validiereArtikelArt(String art){
    if(art.strip().isEmpty()){
        throw new IllegalArgumentException("Artikelart darf nicht leer sein");
    }
}

/**
* Die Methode prüft ob der Artikelnummer größer als 0 ist, falls nicht gibt es eine Exception
* @param artikelNr ist die Artikelnummer
*/
public void validiereArtikelNr(int artikelNr){
    if(artikelNr<=0){
        throw new IllegalArgumentException("Ungültige Artikelnummer");
    }
}

/**
* Die Methode prüft ob der Bestand größer als 0 ist, falls nicht gibt es eine Exception
* @param bestand ist der Bestand
*/
public void validiereBestand(int bestand){
    if(bestand<0){
        throw new IllegalArgumentException("Bestand darf nicht negativ sein");
    }
}

/**
* Die Methode gibt das Objekt aufbereitet als String zurueck
* @return gibt die Attribute des Artikels als String zurueck
*/
public String toString()
{
    return   "ArtikeNr: "+artikelNr
             +"\nArt: " + art
             + "\nBestand: "+bestand;

}

//Getter
/**
* Die Methode gibt die Artikelnummer zurueck
* @return die Artikelnummer
*/
public int getArtikelNr()
{
    return artikelNr;
}

/**
* Die Methode gibt die Artikelart zurueck
* @return die Artikelart
*/
public String getArt()
{
    return art;
}

/**
* Die Methode gibt den Bestand zurueck
* @return den Bestand
*/
public int getBestand()
{
    return bestand;
}

//Setter
/**
* Die Methode setzt die Artikelart neu
* @param neue Artikelart
*/
public void setArt(String art)
{
    validiereArtikelArt(art);
    
    this.art = art;
}

}