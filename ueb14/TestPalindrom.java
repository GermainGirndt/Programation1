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
            "a a",
            "aa aa"
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
            "bdA",
            "irgendetwas",
            "a a  a"
        };

        return falschePalindrome;
    }

    public static String[] fehlpalindromeProvider() { 

        String[] fehlpalindrome = 
        {
            "",
            "  "
        };

        return fehlpalindrome;
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

        for ( Palindrom konkretesPalindrom : this.palindrome ) {
            assertEquals(true, konkretesPalindrom.istPalindrom(wort), String.format("%s muss ein Palindrom sein (Typ: %s)", wort, konkretesPalindrom.getClass().getName()));
        }
    }
    
    @ParameterizedTest
    @MethodSource(value =  "falschePalindromeProvider")
    void testFalschePalindromeParameterized(String wort) {
        for ( Palindrom konkretesPalindrom : this.palindrome ) {
            assertEquals(false, konkretesPalindrom.istPalindrom(wort), String.format("%s muss kein Palindrom sein (Typ: %s)", wort, konkretesPalindrom.getClass().getName()));
        }
    }

    @ParameterizedTest
    @MethodSource(value =  "fehlpalindromeProvider")
    void testFehlpalindromeParameterized(String wort) {
        for ( Palindrom konkretesPalindrom : this.palindrome ) {
            
            assertThrows(
                PalindromError.class,
                () -> konkretesPalindrom.istPalindrom(wort),
               "Expected istPalindrom() to throw, but it didn't"
            );

        }
    }



    @Test
    public void a()
    {
    }
}


