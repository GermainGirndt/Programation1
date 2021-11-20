import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

/**
 * Tests fuer Methode berechneFakultaet von der Klasse MathFunctions
 *
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class TestBerechneReihensumme{    

    @Test
    void TestEineSummeMitEinerhalben() { 
        double erwartetesErgebnis = -1.0;

        int anzahl = 1;
        double x = 0.5;
        
        assertEquals(erwartetesErgebnis, MathFunctions.berechneReihensumme(anzahl, x));
    }

    @Test
    void TestZweiSummenMitEinerhalben() { 
        double erwartetesErgebnis = -0.5;

        int anzahl = 2;
        double x = 0.5;
        
        assertEquals(erwartetesErgebnis, MathFunctions.berechneReihensumme(anzahl, x));
    }

    @Test
    void TestEineSummeMitMinusEinerhalben() { 
        double erwartetesErgebnis = 3;

        int anzahl = 1;
        double x = -0.5;
        
        assertEquals(erwartetesErgebnis, MathFunctions.berechneReihensumme(anzahl, x));
    }

    @Test
    void TestZweiSummenMitMinusEinerhalben() { 
        double erwartetesErgebnis = 3.0 + 9.0/2.0;

        int anzahl = 2;
        double x = -0.5;
        
        assertEquals(erwartetesErgebnis, MathFunctions.berechneReihensumme(anzahl, x));
    }

    @Test
    void TestEineSummeMitEinemViertel() { 
        double erwartetesErgebnis = -3;

        int anzahl = 1;
        double x = 0.25;
        
        assertEquals(erwartetesErgebnis, MathFunctions.berechneReihensumme(anzahl, x));
    }

    @Test
    void TestEineSummeMitEins() { 
        double erwartetesErgebnis = 0.0;

        int anzahl = 1;
        double x = 1.0;
        
        assertEquals(erwartetesErgebnis, MathFunctions.berechneReihensumme(anzahl, x));
    }

    @Test
    void TestEineSummeMitZwei() { 
        double erwartetesErgebnis = 1.0 / 2.0;

        int anzahl = 1;
        double x = 2.0;
        
        assertEquals(erwartetesErgebnis, MathFunctions.berechneReihensumme(anzahl, x));
    }


    @Test
    void TestEineSummeMitDrei() { 
        double erwartetesErgebnis = 2.0 / 3.0;

        int anzahl = 1;
        double x = 3.0;
        
        assertEquals(erwartetesErgebnis, MathFunctions.berechneReihensumme(anzahl, x));
    }

    @Test
    void TestEineSummeMitZehn() { 
        double erwartetesErgebnis = 9.0 / 10.0;

        int anzahl = 1;
        double x = 10.0;
        
        assertEquals(erwartetesErgebnis, MathFunctions.berechneReihensumme(anzahl, x));
    }

    @Test
    void TestEineSummeMitMinusEins() { 
        double erwartetesErgebnis = 2.0;

        int anzahl = 1;
        double x = -1.0;
        
        assertEquals(erwartetesErgebnis, MathFunctions.berechneReihensumme(anzahl, x));
    }

    @Test
    void TestEineSummeMitMinusFuenf() { 
        double erwartetesErgebnis = 6.0 / 5.0;

        int anzahl = 1;
        double x = -5.0;
        
        assertEquals(erwartetesErgebnis, MathFunctions.berechneReihensumme(anzahl, x));
    }

    @Test
    void TestZweiSummenMitEins() { 
        double erwartetesErgebnis = 0.0;

        int anzahl = 2;
        double x = 1.0;
        
        assertEquals(erwartetesErgebnis, MathFunctions.berechneReihensumme(anzahl, x));
    }

    @Test
    void TestZweiSummenMitZwei() { 
        double erwartetesErgebnis = 5.0 / 8.0;

        int anzahl = 2;
        double x = 2.0;
        
        assertEquals(erwartetesErgebnis, MathFunctions.berechneReihensumme(anzahl, x));
    }

    @Test
    void TestDreiSummenMitDrei() { 
        double erwartetesErgebnis = 2.0/3.0 + 2.0/9.0 + 8.0/81.0;

        int anzahl = 3;
        double x = 3.0;
        
        assertEquals(erwartetesErgebnis, MathFunctions.berechneReihensumme(anzahl, x));
    }

    @Test
    void TestWirftFehlerBeiUngültigerAnzahlNull() { 

        int ungueltigerAnzahl = 0; // Ausgabe zu groß

        assertThrows(
            IllegalArgumentException.class,
            () -> MathFunctions.berechneReihensumme(ungueltigerAnzahl, 1),
           "Expected doThing() to throw, but it didn't"
        );
    }

    @Test
    void TestWirftFehlerBeiUngültigerAnzahlMinusEins() { 

        int ungueltigerAnzahl = -1; // Ausgabe zu groß

        assertThrows(
            IllegalArgumentException.class,
            () -> MathFunctions.berechneReihensumme(ungueltigerAnzahl, 1),
           "Expected doThing() to throw, but it didn't"
        );
    }

    void TestWirftFehlerBeiUngültigemXNull() { 

        int ungueltigesX = 0; // Ausgabe zu groß

        assertThrows(
            IllegalArgumentException.class,
            () -> MathFunctions.berechneReihensumme(1, ungueltigesX),
           "Expected doThing() to throw, but it didn't"
        );
    }

    @Test
    public void a()
    {
    }
}


