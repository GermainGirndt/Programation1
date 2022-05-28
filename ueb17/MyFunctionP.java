import java.util.function.Predicate;
/**
 * Tragen Sie hier eine Beschreibung des Interface MyFunctionP ein.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

public interface MyFunctionP
{
    public int apply(int i);
    
    public static MyFunctionP conditionateInput(Predicate p, MyFunctionP f){
        MyFunctionP a = (x) -> p.test(x) ? f.apply(x) : 0;    
        return a;
    }
    
    public static MyFunctionP conditionateOutput(Predicate p, MyFunctionP f){
        MyFunctionP a = (x) -> p.test(f.apply(x)) ? f.apply(x) : 0;    
        return a;
    }
}
