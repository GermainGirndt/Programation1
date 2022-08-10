

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse ArrayFunctionsTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class ArrayFunctionsTest
{

    private static final double messwertTab[][] =
                   { 
                     { -0.1, 0.2, -0.3, 0.27, -0.2, 0.11,  0.31,   0.91,  0.5,  0.7,  0.8,  0.4 },       // 0,3 0,31 0,91
                     { -0.1, 0.2, -0.3, 0.29, -0.2, 0.11,  13.0,  2.0,  4.0,  3.0,  6.0,  2.0,  100.0 }, // 10 13 100
                     { -0.1, 0.2, -0.3, 0.29, -0.2, 0.11, -13.0, -2.0, -4.0, -3.0, -6.0, -2.0, -100.0 }  // -10 -13 -100
                   };  
                   
    private static final String stringTab[][] = 
                   {
                     { "hallo", "abxyz", "HTW", "jooojo", "GI!" }, // 4
                     { "hallo", "abxyz", "HTW", "joooj4", "GiS" }, // 3
                     { "hallo", "abxyz", "HTw", "jooo$o", "G7S" }, // 2
                     { "Hallo", "ABxyz", "HTw ", "joo jo", "gis"}, // 1
                     { "Hallo", "12 xyz", "H T W ", "!\247$", " GIS" } // 0
                   };
    
    /**
     * Prueft 1. Messwert-Zeile
     */
    @Test
    public void test_berechneMittelwert_Ergebnis_mittelwert_sollte_03_sein() 
    {
      final double erwarteterMittelwert = 0.3; 
      Mittelwert ergebnis = ArrayFunctions.berechneMittelwert(messwertTab[0]);
      assertEquals(erwarteterMittelwert, ergebnis.getMittelwert());
    }

    @Test
    public void test_berechneMittelwert_Ergebnis_naechsterwert_sollte_031_sein() 
    {
      final double erwarteterNaechsterWert = 0.31; 
      Mittelwert ergebnis = ArrayFunctions.berechneMittelwert(messwertTab[0]);
      assertEquals(erwarteterNaechsterWert, ergebnis.getNaechsterWert());
    }

    @Test
    public void test_berechneMittelwert_Ergebnis_entferntesterwert_sollte_091_sein() 
    {
      final double erwarteterEntferntesterWert = 0.91; 
      Mittelwert ergebnis = ArrayFunctions.berechneMittelwert(messwertTab[0]);
      assertEquals(erwarteterEntferntesterWert, ergebnis.getEntferntesterWert());
    }
                   
    /**
     * Prueft 2. Messwert-Zeile
     */
    @Test
    public void test_berechneMittelwert_Ergebnis_mittelwert_sollte_10_sein() 
    {
      final double erwarteterMittelwert = 10; 
      Mittelwert ergebnis = ArrayFunctions.berechneMittelwert(messwertTab[1]);
      assertEquals(erwarteterMittelwert, ergebnis.getMittelwert());
    }

    @Test
    public void test_berechneMittelwert_Ergebnis_naechsterwert_sollte_13_sein() 
    {
      final double erwarteterNaechsterWert = 13; 
      Mittelwert ergebnis = ArrayFunctions.berechneMittelwert(messwertTab[1]);
      assertEquals(erwarteterNaechsterWert, ergebnis.getNaechsterWert());
    }

    @Test
    public void test_berechneMittelwert_Ergebnis_entferntesterwert_sollte_100_sein() 
    {
      final double erwarteterEntferntesterWert = 100; 
      Mittelwert ergebnis = ArrayFunctions.berechneMittelwert(messwertTab[1]);
      assertEquals(erwarteterEntferntesterWert, ergebnis.getEntferntesterWert());
    }
    
    
    /**
     * Prueft 2. Messwert-Zeile
     */
    @Test
    public void test_berechneMittelwert_Ergebnis_mittelwert_sollte_minus10_sein() 
    {
      final double erwarteterMittelwert = -10; 
      Mittelwert ergebnis = ArrayFunctions.berechneMittelwert(messwertTab[2]);
      assertEquals(erwarteterMittelwert, ergebnis.getMittelwert());
    }

    @Test
    public void test_berechneMittelwert_Ergebnis_naechsterwert_sollte_minus13_sein() 
    {
      final double erwarteterNaechsterWert = -13; 
      Mittelwert ergebnis = ArrayFunctions.berechneMittelwert(messwertTab[2]);
      assertEquals(erwarteterNaechsterWert, ergebnis.getNaechsterWert());
    }

    @Test
    public void test_berechneMittelwert_Ergebnis_entferntesterwert_sollte_minus100_sein() 
    {
      final double erwarteterEntferntesterWert = -100; 
      Mittelwert ergebnis = ArrayFunctions.berechneMittelwert(messwertTab[2]);
      assertEquals(erwarteterEntferntesterWert, ergebnis.getEntferntesterWert());
    }
    
    
    /**
     * Prueft 1. String-Zeile
     */
    @Test
    public void test_stringAuswerten_Ergebnis_sollte_4_sein() 
    {
      final int erwartetesErgebnis = 4; 
      assertEquals(erwartetesErgebnis, ArrayFunctions.stringsAuswerten(stringTab[0]));
    }
    
    /**
     * Prueft 2. String-Zeile
     */
    @Test
    public void test_stringAuswerten_Ergebnis_sollte_3_sein() 
    {
      final int erwartetesErgebnis = 3; 
      assertEquals(erwartetesErgebnis, ArrayFunctions.stringsAuswerten(stringTab[1]));
    }
    
    /**
     * Prueft 3. String-Zeile
     */
    @Test
    public void test_stringAuswerten_Ergebnis_sollte_2_sein() 
    {
      final int erwartetesErgebnis = 2; 
      assertEquals(erwartetesErgebnis, ArrayFunctions.stringsAuswerten(stringTab[2]));
    }
    
    /**
     * Prueft 4. String-Zeile
     */
    @Test
    public void test_stringAuswerten_Ergebnis_sollte_1_sein() 
    {
      final int erwartetesErgebnis = 1; 
      assertEquals(erwartetesErgebnis, ArrayFunctions.stringsAuswerten(stringTab[3]));
    }
    
    /**
     * Prueft 5. String-Zeile
     */
    @Test
    public void test_stringAuswerten_Ergebnis_sollte_0_sein() 
    {
      final int erwartetesErgebnis = 0; 
      assertEquals(erwartetesErgebnis, ArrayFunctions.stringsAuswerten(stringTab[4]));
    }
}
