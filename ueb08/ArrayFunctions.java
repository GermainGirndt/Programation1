/**
 * Eine Werkzeugklasse fuer Arrays
 * 
 * @author Girndt, Germain & Krier, Katharina  
 * @version 1.0
 */
public class ArrayFunctions {

    private static int MINDESTELEMENTENANZAHL = 1;
    private static String ERROR_UNGUELTIGE_ELEMENETENANZAHL = "Der Array muss mindestens 2 Elemente enthalten."; 

    public static Mittelwert berechneMittelwert(double[] messwerte) {

        if (messwerte.length <= MINDESTELEMENTENANZAHL) {
            throw new IllegalArgumentException(ERROR_UNGUELTIGE_ELEMENETENANZAHL);
        }

        double mittelwert = ArrayFunctions.extrahiereMittelwert(messwerte);
        double naechsterWert = ArrayFunctions.extrahiereNaechstenwert(messwerte, mittelwert);
        double entfernsterWert = ArrayFunctions.extrahiereEntfernstenWert(messwerte, mittelwert);
        
        Mittelwert mittelwertContainer = new Mittelwert(mittelwert, naechsterWert, entfernsterWert);

        return mittelwertContainer;

        
    }

    private static double extrahiereMittelwert(double[] array) {

        double mittelwert = 0;

        for (int index = 0; index < array.length; index++) {

            mittelwert += array[index] / array.length;
        }

        return mittelwert;
    }

    private static double extrahiereNaechstenwert(double[] array, double mittelwert) {

        double naechsterWert = array[0];
        double absoluteDifferenzZumMittelwert = Math.abs(mittelwert - array[0]);


        for (int index = 1; index < array.length; index++) {

            double absoluteDifferenz = Math.abs(mittelwert - array[index]);

            if (absoluteDifferenz < absoluteDifferenzZumMittelwert) {
                naechsterWert = array[index];
                absoluteDifferenzZumMittelwert = absoluteDifferenz;
            }
            
        }

        return naechsterWert;
    }

    private static double extrahiereEntfernstenWert(double[] array, double mittelwert) {
        double entfernsterWert = array[0];
        double absoluteDifferenzZumMittelwert = Math.abs(mittelwert - array[0]);


        for (int index = 1; index < array.length; index++) {

            double absoluteDifferenz = Math.abs(mittelwert - array[index]);

            if (absoluteDifferenz > absoluteDifferenzZumMittelwert) {
                entfernsterWert = array[index];
                absoluteDifferenzZumMittelwert = absoluteDifferenz;
            }
            
        }

        return entfernsterWert;
    }
}
