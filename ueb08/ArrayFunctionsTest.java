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
    //berechne Mittelwert
    @Test
    public void  berechneMittelwert3Positive(){
        Mittelwert erwarteterMittelwert = new Mittelwert(3.0, 3.0, 1.0);
        
        double[] messwerte ={1.0 , 3.0 , 5.0};
        Mittelwert tatsachlicherMittelwert = ArrayFunctions.berechneMittelwert(messwerte);
        
        assertEqualsMittelwert(erwarteterMittelwert , tatsachlicherMittelwert);
    }
    
    @Test
    public void  berechneMittelwert3Negative(){
        Mittelwert erwarteterMittelwert = new Mittelwert(-3.0, -3.0, -1.0);
        
        double[] messwerte ={-1.0 , -3.0 , -5.0};
        Mittelwert tatsachlicherMittelwert = ArrayFunctions.berechneMittelwert(messwerte);
        
        assertEqualsMittelwert(erwarteterMittelwert , tatsachlicherMittelwert);
    }
    
    @Test
    public void  berechneMittelwert2Negative2Positive(){
        Mittelwert erwarteterMittelwert = new Mittelwert(1.375, 5.0, 6.5);
        
        double[] messwerte ={-3.0, -3.0, 5.0, 6.5};
        Mittelwert tatsachlicherMittelwert = ArrayFunctions.berechneMittelwert(messwerte);
        
        assertEqualsMittelwert(erwarteterMittelwert , tatsachlicherMittelwert);
    }
    
    
    @Test
    public void  berechneMittelwertNur0Komma0(){
        Mittelwert erwarteterMittelwert = new Mittelwert(0.0, 0.0, 0.0);
        
        double[] messwerte ={0.0};
        Mittelwert tatsachlicherMittelwert = ArrayFunctions.berechneMittelwert(messwerte);
        
        assertEqualsMittelwert(erwarteterMittelwert , tatsachlicherMittelwert);
    }
    
   @Test
    public void  berechneMittelwertLeer(){
        Mittelwert erwarteterMittelwert = new Mittelwert(0.0, 0.0, 0.0);
        
        double[] messwerte ={};
        assertThrows(IllegalArgumentException.class, () -> { ArrayFunctions.berechneMittelwert(messwerte);});
    }
    
    //strings auswerten
    @Test
    public void stringsAuswertenNurGrossGeschrieben()
    {
        int erwarteteRueckgabe       = 3;
        String[] stringZumAuswerten  = {"HTW", "SAAR", "RINDVIEH"};
        
        int tatsaechlicheRueckgabe = ArrayFunctions.stringsAuswerten(stringZumAuswerten);
        assertEquals(erwarteteRueckgabe , tatsaechlicheRueckgabe);
    }
    
    @Test
    public void stringsAuswertenNurKleinGeschrieben()
    {
        int erwarteteRueckgabe       = 2;
        String[] stringZumAuswerten  = {"htw", "stein", };
        
        int tatsaechlicheRueckgabe = ArrayFunctions.stringsAuswerten(stringZumAuswerten);
        assertEquals(erwarteteRueckgabe , tatsaechlicheRueckgabe);
    }
    
    @Test
    public void stringsAuswerten1Klein2Gross()
    {
        int erwarteteRueckgabe       = 3;
        String[] stringZumAuswerten  = {"htw", "HTW", "STEIN" };
        
        int tatsaechlicheRueckgabe = ArrayFunctions.stringsAuswerten(stringZumAuswerten);
        assertEquals(erwarteteRueckgabe , tatsaechlicheRueckgabe);
    }
    
    @Test
    public void stringsAuswerten2Gross1Klein()
    {
        int erwarteteRueckgabe       = 3;
        String[] stringZumAuswerten  = {"UNI", "HTW", "klein" };
        
        int tatsaechlicheRueckgabe = ArrayFunctions.stringsAuswerten(stringZumAuswerten);
        assertEquals(erwarteteRueckgabe , tatsaechlicheRueckgabe);
    }
    
    @Test
    public void stringsAuswerten2Gemischt1Klein()
    {
        int erwarteteRueckgabe       = 1;
        String[] stringZumAuswerten  = {"UNi", "SAARbruecken", "klein" };
        
        int tatsaechlicheRueckgabe = ArrayFunctions.stringsAuswerten(stringZumAuswerten);
        assertEquals(erwarteteRueckgabe , tatsaechlicheRueckgabe);
    }
    
    @Test
    public void stringsAuswerten1Gemischt1Gross()
    {
        int erwarteteRueckgabe       = 1;
        String[] stringZumAuswerten  = {"UNi", "HTW" };
        
        int tatsaechlicheRueckgabe = ArrayFunctions.stringsAuswerten(stringZumAuswerten);
        assertEquals(erwarteteRueckgabe , tatsaechlicheRueckgabe);
    }
    
    @Test
    public void stringsAuswerten2Klein1Gemischt()
    {
        int erwarteteRueckgabe       = 2;
        String[] stringZumAuswerten  = {"uni", "gross", "klEin" };
        
        int tatsaechlicheRueckgabe = ArrayFunctions.stringsAuswerten(stringZumAuswerten);
        assertEquals(erwarteteRueckgabe , tatsaechlicheRueckgabe);
    }

    @Test
    public void stringsAuswerten3Gross2Gemischt()
    {
        int erwarteteRueckgabe       = 3;
        String[] stringZumAuswerten  = {"UNI", "SAAR", "HTW" , "Nichts" , "KlEIN"};
        
        int tatsaechlicheRueckgabe = ArrayFunctions.stringsAuswerten(stringZumAuswerten);
        assertEquals(erwarteteRueckgabe , tatsaechlicheRueckgabe);
    }
    
    @Test
    public void stringsAuswerten1Gross2Gemischt1Klein()
    {
        int erwarteteRueckgabe       = 2;
        String[] stringZumAuswerten  = {"HTW", "UNi", "SAARbruecken", "klein" };
        
        int tatsaechlicheRueckgabe = ArrayFunctions.stringsAuswerten(stringZumAuswerten);
        assertEquals(erwarteteRueckgabe , tatsaechlicheRueckgabe);
    }
    
    @Test
    public void stringsAuswerten4Gemischtn()
    {
        int erwarteteRueckgabe       = 0;
        String[] stringZumAuswerten  = {"Uni", "Htw", "kLEin", "gROSS" };
        
        int tatsaechlicheRueckgabe = ArrayFunctions.stringsAuswerten(stringZumAuswerten);
        assertEquals(erwarteteRueckgabe , tatsaechlicheRueckgabe);
    }
    
    @Test
    public void stringsAuswerten2Leer()
    {
        int erwarteteRueckgabe       = 0;
        String[] stringZumAuswerten  = {"", " "};
        
        int tatsaechlicheRueckgabe = ArrayFunctions.stringsAuswerten(stringZumAuswerten);
        assertEquals(erwarteteRueckgabe , tatsaechlicheRueckgabe);
    }
    
    @Test
    public void stringsAuswerten2Leer1Klein()
    {
        int erwarteteRueckgabe       = 1;
        String[] stringZumAuswerten  = {" ", "  ", "klein" };
        
        int tatsaechlicheRueckgabe = ArrayFunctions.stringsAuswerten(stringZumAuswerten);
        assertEquals(erwarteteRueckgabe , tatsaechlicheRueckgabe);
    }
    
    @Test
    public void stringsAuswerten1Gross2Leer1Klein()
    {
        int erwarteteRueckgabe       = 2;
        String[] stringZumAuswerten  = {"HTW", " ", "  ", "klein" };
        
        int tatsaechlicheRueckgabe = ArrayFunctions.stringsAuswerten(stringZumAuswerten);
        assertEquals(erwarteteRueckgabe , tatsaechlicheRueckgabe);
    }
    
    private void assertEqualsMittelwert(Mittelwert erwarteterMittelwert , Mittelwert tatsachlicherMittelwert){
        assertEquals(erwarteterMittelwert.getMittelwert() , tatsachlicherMittelwert.getMittelwert(), 2* Double.MIN_VALUE);
        assertEquals(erwarteterMittelwert.getNahesterwert() , tatsachlicherMittelwert.getNahesterwert(), 2* Double.MIN_VALUE);
        assertEquals(erwarteterMittelwert.getEntferntesterwert() , tatsachlicherMittelwert.getEntferntesterwert(), 2* Double.MIN_VALUE);
          
    }
}
