/**
 * Eine Werkzeugklasse fuer Arrays
 * 
 * @author Girndt, Germain & Krier, Katharina  
 * @version 1.0
 */
public class ArrayFunctions {
    
    private static int ANZAHLLINKSANFANGS                   = 0;
    private static int MINDESTELEMENTENANZAHL               = 1;
    private static String ERROR_UNGUELTIGE_ELEMENETENANZAHL = "Der Array muss mindestens 1 Elemente enthalten."; 
    
    /**
    * Berechnet Angaben zum Mittewert für einen beliebigen double-Array mit mindestens 1 Element
    * 
    * @param messwerte eine double-Array
    * @return ein Mittelwert-Container Objekt, mit den Attributen "mittelwert", "nahesterWert" und "entfernsterWert" 
    */
    public static Mittelwert berechneMittelwert(double[] messwerte) {

        if (messwerte.length < MINDESTELEMENTENANZAHL) {
            throw new IllegalArgumentException(ERROR_UNGUELTIGE_ELEMENETENANZAHL);
        }

        double mittelwert      = ArrayFunctions.extrahiereMittelwert(messwerte);
        double naechsterWert   = ArrayFunctions.extrahiereNaechstenwert(messwerte, mittelwert);
        double entfernsterWert = ArrayFunctions.extrahiereEntfernstenWert(messwerte, mittelwert);
        
        Mittelwert mittelwertContainer = new Mittelwert(mittelwert, naechsterWert, entfernsterWert);

        return mittelwertContainer;

        
    }

    /**
    * Extrahiert den Mittelwert von einem double-Array
    * Um double-Overflows durch die Berechnung zu vermeiden, werden die Werte vor der Summe durch die Elementenanzahl geteilt
    * Was als Nebenwirkung Ungenauigkeiten bei dem Ergebnis hervorrufen kann.
    * 
    * @param array dessen Mittelwert zu berechnen ist
    */
    private static double extrahiereMittelwert(double[] array) {

        double mittelwert = 0;

        for (int index = 0; index < array.length; index++) {

            mittelwert += array[index] / array.length;
        }

        return mittelwert;
    }

    /**
    * Extrahiert den Wert in einem double-Array, der einem anderen Wert am nächsten liegt
    * 
    * @param array der double-Array mit den zu vergleichenden Elementen
    * @param wert der Basiswert für die Rechnung
    */
    private static double extrahiereNaechstenwert(double[] array, double wert) {

        double naechsterWert = array[0];
        double absoluteDifferenzZumWert = Math.abs(wert - array[0]);


        for (int index = 1; index < array.length; index++) {

            double absoluteDifferenz = Math.abs(wert - array[index]);

            if (absoluteDifferenz < absoluteDifferenzZumWert) {
                naechsterWert = array[index];
                absoluteDifferenzZumWert = absoluteDifferenz;
            }
            
        }

        return naechsterWert;
    }

    /**
    * Extrahiert den Wert in einem double-Array, der einem anderen Wert am fernsten liegt
    * 
    * @param array der double-Array mit den zu vergleichenden Elementen
    * @param wert der Basiswert für die Rechnung
    */
    private static double extrahiereEntfernstenWert(double[] array, double wert) {
        double entfernsterWert = array[0];
        double absoluteDifferenzZumWert = Math.abs(wert - array[0]);


        for (int index = 1; index < array.length; index++) {

            double absoluteDifferenz = Math.abs(wert - array[index]);

            if (absoluteDifferenz > absoluteDifferenzZumWert) {
                entfernsterWert = array[index];
                absoluteDifferenzZumWert = absoluteDifferenz;
            }
            
        }

        return entfernsterWert;
    }
    
    /**
    * Wertet aus wie viele Strings nur aus grossen oder kleinen Buchstaben besteht
    * 
    * @param strings ein Array von Strings
    * @return die Anzahl der Strings die nur aus grossen oder kleinen Buchstaben bestehen
    */
     public static int stringsAuswerten(String[] strings){
         
     int anzahl             = ANZAHLLINKSANFANGS;
     boolean istKlein;
     boolean trifftnichtzu ; 
     
     
     for (String s : strings) {
      s              = s.trim();
      trifftnichtzu  = false;    
      istKlein       = false;
         if (!pruefeobLeer(s)){      
             for (int i = 0; i < s.length(); i++) {
                 if (i == 0){
                     istKlein = pruefeobKlein(s.charAt(i));    
                 } else{
                     if (istKlein){
                         if(!pruefeobKlein(s.charAt(i))) {
                              trifftnichtzu = true;
                         }     
                     } else{
                         if (pruefeobKlein(s.charAt(i))) {
                             trifftnichtzu  = true;
                         } 
                     }
                 }
            }
         }
         else{
            trifftnichtzu = true;
         }
         if (!trifftnichtzu ){
            anzahl++;    
         }
      }
     return anzahl;
    }
    
    /**
    * Prueft ob ein String leer ist
    * 
    * @param s der zu pruefende String
    * @return true wenn er leer ist, false falls nicht
    */
    private static boolean pruefeobLeer(String s){
         return s.isEmpty();
     }
     
    /**
    * Prueft ob ein Buchstabe klein ist
    * 
    * @param c der zu pruefende Buchstabe
    * @return true wenn er klein ist, falls er gross ist
    */
    private static boolean pruefeobKlein(Character c){
        if (Character.isUpperCase(c)){
                return false;
         }   
         else{
                return true;
         }    
     }
}
