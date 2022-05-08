
/**
 * Beschreiben Sie hier die Klasse PersonQueue.
 * 
 * @author Germain, Girndt; Krier, Katharina
 * @version 1.0
 * 
 */
public class PersonQueue extends AbstractQueue implements Queue {

    /**
    * Konstruktor PersonQueue
    * @param size die Groesse
    */
    public PersonQueue(int size) {
        super(Person.class, size);   
    }
    
    // Klasse geschrieben wegen der Aufgabestellung
    // Kann in der Zukunft durch "generics" in der Innere Iterator-Klasse von AbstractQueue ersetzt werden
    private class Iterator implements PersonenIterator {

        @Override
        public boolean hasNext() {
            return PersonQueue.this.getIterator().hasNext();
        }
        
        @Override
        public Person next() {
            return (Person) PersonQueue.this.getIterator().next();
        }
    }

    // Methode geschrieben wegen der Aufgabestellung
    // Kann geloescht werden
    @Override
    public void print() {
        Iterator i = new Iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    public String smallest() {

        Iterator iterator = new Iterator();

        if (!iterator.hasNext()) {
            throw new IllegalStateException("Es gibt keine Person in der Queue")
        }
        
        String smallest = iterator.next().getVorname();

        while (iterator.hasNext()) {

            String nextVorname = iterator.next().getVorname();
            smallest = this.gibZurueckKleinsterZeichenString(smallest, nextVorname);
        }

        return smallest;

    }

    private String gibZurueckKleinsterZeichenString(String vornameEins, String vornameZwei) {

        char[] vornameEinsChars = vornameEins.toLowerCase().toCharArray();

        char[] vornameZweiChars = vornameZwei.toLowerCase().toCharArray();

        String vornameMitKleinsterLaenge = vornameEinsChars.length < vornameZweiChars.length ?  vornameEins : vornameZwei;

        String kleinsterVorname = null;

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
