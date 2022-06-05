import java.util.function.IntPredicate;

public class ParityChecker {

    public static IntPredicate odd = new IntPredicate() {
        public boolean test(int number) {
            return (number % 2) == 0 ;
        }
    };

    public static IntPredicate even = number -> (number % 2) == 1;
    
}
