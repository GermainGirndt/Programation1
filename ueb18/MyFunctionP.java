import java.util.function.Predicate;
/**
 * Tragen Sie hier eine Beschreibung des Interface MyFunctionP ein.
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */

public interface MyFunctionP extends MyFunction
{
  
    
    default MyFunctionP conditionateInput(Predicate p) {
        MyFunctionP a = (x) -> p.test(x) ? apply(x) : 0;    
        return a;
    }
    
    default MyFunctionP conditionateOutput(Predicate p) {
        MyFunctionP a = (x) -> p.test(apply(x)) ? apply(x) : 0;    
        return a;
    }
}
