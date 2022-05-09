
/**
 * Beschreiben Sie hier die Klasse PersonQueue.
 * 
 * @author Germain, Girndt; Krier, Katharina
 * @version 1.0
 * 
 */
public class PersonQueue extends AbstractQueue<Person> implements Queue<Person> {

    /**
    * Konstruktor PersonQueue
    * @param size die Groesse
    */
    public PersonQueue(int size) {
        super(Person.class, size);   
    }

    
    public String smallest() {

        Iterator<Person> iterator = PersonQueue.this.getIterator();

        if (!iterator.hasNext()) {
            throw new IllegalStateException("Es gibt keine Person in der Queue");
        }
        
        String smallest = iterator.next().getVorname();

        while (iterator.hasNext()) {

            String nextVorname = iterator.next().getVorname();
            smallest = this.gibZurueckKleinsterZeichenString(smallest, nextVorname);
        }

        return smallest;

    }

    private String gibZurueckKleinsterZeichenString(String vornameEins, String vornameZwei) {

        String kleinsterVorname = null;

        char[] vornameEinsChars = vornameEins.toLowerCase().toCharArray();
        char[] vornameZweiChars = vornameZwei.toLowerCase().toCharArray();

        String vornameMitKleinsterLaenge = vornameEinsChars.length < vornameZweiChars.length ?  vornameEins : vornameZwei;

        boolean unterschiedGefunden = false;
        for (int i = 0; i < vornameMitKleinsterLaenge.length(); i++) {

            if (vornameEinsChars[i] == vornameZweiChars[i]) {
                continue;
            }

            if (vornameEinsChars[i] < vornameZweiChars[i]) {
                unterschiedGefunden = true;
                kleinsterVorname = vornameEins;
                break;
            } else {
                unterschiedGefunden = true;
                kleinsterVorname = vornameZwei;
                break;
            }
        }

        if (unterschiedGefunden == false) {
            kleinsterVorname = vornameMitKleinsterLaenge;
        }

        return kleinsterVorname;

    }
}
