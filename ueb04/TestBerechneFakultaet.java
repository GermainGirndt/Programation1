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
public class TestBerechneFakultaet
{    
    @Test
    void TestBerechneMoeglicheFakultaetenFuerLong() { 

        Map<Integer, Long> resultsMap = new HashMap<Integer, Long>()
        {{
            // put(zahlZurFakultaetsberechnung, erwartetesErgebnis)
            put(0, 1L);
            put(1, 1L);
            put(2, 2L);
            put(3, 6L);
            put(4, 24L);
            put(5, 120L);
            put(10, 3628800L);
            put(15, 1307674368000L);
            put(16, 20922789888000L);
            put(16, 20922789888000L);
            put(17, 355687428096000L);
            put(18, 6402373705728000L);
            put(19, 121645100408832000L);
            put(20, 2432902008176640000L);
        }};

        for (var entry : resultsMap.entrySet()) {
            int zahlZurFakultaetsberechnung = entry.getKey();
            long erwartetesErgebnis = entry.getValue();
            assertEquals(erwartetesErgebnis , MathFunctions.berechneFakultaet(zahlZurFakultaetsberechnung));
        }
    }

    @Test
    void TestWirftFehlerBeiNegativenWerten() { 

        int ungueltigerWert = -1;

        assertThrows(
            IllegalArgumentException.class,
            () -> MathFunctions.berechneFakultaet(ungueltigerWert),
           "Expected doThing() to throw, but it didn't"
        );
    }

    @Test
    public void a()
    {
    }
}


