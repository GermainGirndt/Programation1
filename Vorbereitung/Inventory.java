import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Beschreiben Sie hier die Klasse Inventory.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Inventory<P, B, W>
{
    private Set<P> pocket;
    private List<B> backpack;
    private Map<String,W> weapons;
    
    /**
     * Konstruktor für Objekte der Klasse Inventory
     */
    public Inventory()
    {
        pocket = new HashSet<P>();  
        backpack = new LinkedList<B>();
        weapons = new HashMap<String, W>();
    }
    
    public void addWeapon(String name, W weapon){
        weapons.put(name, weapon);    
    }
    
    public void addWeapons(List<String> names, List<? extends W> weapons){
        
        for(int i = 0; i < names.size(); i++){
            weapons.put(names.get(i), weapons.get(i));  
        }
    }
    
    public void addPocketItem(P item){
        pocket.add(item);
    }
    
    public void addPocketItems(List<? extends P> items){
        for(P i : items){
            pocket.add(i);    
        }
    }
    
    public void addToBackpack(B item){
        backpack.add(item);
    }
    
    public void addAllToBackpack(List< ? extends B> items){
 
        items.stream().foreach(item -> {backpack.add(item);});
      
        
    }
    
    public B takeOutOfBackpack(){
        return backpack.get(backpack.size());
        
    }

    public long countItemsInBackpack(Predicate<? super B> p){
        return backpack.stream().filter(p).count();    
    }
    
    public void sortBackpack(Comparator<? super B> c){
        backpack = backpack.stream().sorted(c).collect(Collectors.toList());    
    }
}
