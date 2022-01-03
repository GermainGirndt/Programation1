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
    private static String REGEX_KLEINBUCHSTABE = "^[a-z]+$"; 
    private static String REGEX_GROSSBUCHSTABE = "^[A-Z]+$";
    
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
         
        int zähler = 0;
        
        for (String s : strings) {
            if (s.matches(REGEX_KLEINBUCHSTABE)){
                zähler++;
            } else if (s.matches(REGEX_GROSSBUCHSTABE)){
                zähler++;    
            }
        }
     return zähler;
    }  

}
