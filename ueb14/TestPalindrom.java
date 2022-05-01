import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests fuer Palindrom
 *
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class TestPalindrom {
    
    Palindrom[] palindrome;

    public static String[] palindromeProvider() { 

        String[] palindrome = 
        {
            "a",
            "aa",
            "aaa",
            "A",
            "AA",
            "AAA",
            "AaA",
            "aAa",
            "Otto",
            "Otto",
            "Reittier",
            "Rentner",
        };

        return palindrome;
    }

    public static String[] falschePalindromeProvider() { 

        String[] falschePalindrome = 
        {
            "ab",
            "abb",
            "aab",
            "aab",
            "Wuhu",
            "AWW",
            "bdA"
        };

        return falschePalindrome;
    }

    @BeforeEach 
    public void init() {
        PalindromIterativ palindromIterativ = new PalindromIterativ();
        PalindromRekursiv palindromRekursiv = new PalindromRekursiv();


        this.palindrome = new Palindrom[] {
            palindromIterativ,
            palindromRekursiv
        };
    }
    
    @ParameterizedTest
    @MethodSource(value =  "palindromeProvider")
    void testPalindromeParameterized(String wort) {

        for ( Palindrom palindromIdentifier : this.palindrome ) {
            assertEquals(true, palindromIdentifier.istPalindrom(wort), String.format("%s muss ein Palindrom sein (Typ: %s)", wort, palindromIdentifier.getClass().getName()));
        }
    }
    
    @ParameterizedTest
    @MethodSource(value =  "falschePalindromeProvider")
    void testFalschePalindromeParameterized(String wort) {
        for ( Palindrom palindromIdentifier : this.palindrome ) {
            assertEquals(false, palindromIdentifier.istPalindrom(wort), String.format("%s muss kein Palindrom sein (Typ: %s)", wort, palindromIdentifier.getClass().getName()));
        }
    }



    @Test
    public void a()
    {
    }
}


