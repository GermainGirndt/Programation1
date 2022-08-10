/**
 *
 * Beispielloesung fuer die 8. Programmieruebung, so wie
 * sie in der Klausur als Loesung akzeptiert wuerde
 *
 * die Javadoc-Kommentare koennten weggelassen werden  !!!
 */


/**
 * Realisierung einer einfachen Patientenwarteschlange
 * @author folz, von pauly erweitert
 *
 */

public class PatientenWarteschlange 
{
    private static final String MSG_SIZE = "Die Groesse muss > 0 sein!";
    private static final String MSG_QUEUE_FULL = "Warteschlange voll!";
    private static final String MSG_EXISTS = "Patient bereits vorhanden";
    private static final String MSG_NOT_EXISTS = "Patient nicht vorhanden";
    private static final String MSG_QUEUE_EMPTY = "Warteschlange leer!";

    private Patient[] ptab;
    private int anzahlPatienten;
   
    /**
     * Konstruiere PW mit einer Maximalzahl
     * 
     * @param n maximale Anzahl an Patienten
     */
    public PatientenWarteschlange(int n) 
    {
        check (n <= 0, MSG_SIZE);

        ptab = new Patient[n];
        anzahlPatienten = 0;
    }
    
    /**
     * Pruefen, ob PW leer ist
     * @return true, falls keine Patienten in der PW
     */
    public boolean empty() 
    {
        return anzahlPatienten == 0;
    }

    /**
     * Pruefen, ob PW noch Patienten aufnehmen kann
     * @return treu, wenn das interne Array voll ist.
     */
    public boolean full() 
    {
        return anzahlPatienten == ptab.length;
    }
    
    /**
     * Neuen Patienten in die Warteschlange aufnehmen
     * 
     * @param pnr Patientennummer
     * @param vorName Patienten-Vor.Name
     * @param famName Patienten-Familien-Name
     */
    public void neuerPatient(int pnr, String vorName, String famName) 
    {
        check (full(), MSG_QUEUE_FULL);

        // pruefen, ob bereits vorhanden
        check (pos(pnr) >= 0, MSG_EXISTS);
        ptab[anzahlPatienten++] = new Patient(pnr, vorName, famName);
    }
    
    /**
     * Erstes Element aus der PW holen 
     * Vorbedingung: !empty()
     * @return erster Patient in der PW
     */
    public Patient derNaechsteBitte()  
    {
        check(empty(), MSG_QUEUE_EMPTY);

        Patient p = ptab[0];
        // Array shiften
        loesche(0);
        return p;
    }

    /**
     * Patienten mit bestimmter Nummer suchen
     * @param pnr Patientennr
     * @return Index, falls gefunden, -1 sonst
     */
    private int pos(int pnr ) 
    {
        for (int i = 0; i < anzahlPatienten; ++i)
           {
            if (ptab[i].getPnr() == pnr)
                return i;
           }
        return -1;
    }
    
    /**
     * suchen in Warteschlange und ggf loeschen
     * falls nicht vorhanden Meldung ausgeben.
     * @param Patientennr
     */ 
    public Patient entfernePatient(int pnr) 
    {
        int index = pos(pnr);
        Patient entfernterPatient;
    
        check (index < 0, MSG_NOT_EXISTS);

        entfernterPatient = ptab[index];
        loesche(index);
        return entfernterPatient;
    }
    
    /**
     * Loesche einen Eintrag aus der PW
     * @param index zu loeschender Index
     */
    private void loesche(int index) 
    {
        for (int i = index; i < anzahlPatienten - 1; ++i)
           {
            ptab[i] = ptab[i+1];
           }
        ptab[anzahlPatienten-1] = null;
        --anzahlPatienten;       
    }
    
    public String toString() 
    {
        StringBuilder sb = new StringBuilder("\nWarteliste");
        sb.append("\nPnr     Name\n");
        // sequentiell ausgeben der Patienten
        for (int i = 0; i < anzahlPatienten; ++i) 
           {
            sb.append(ptab[i]).append('\n');
           }
        return sb.toString();
    }

    private void check (boolean bedingung, String msg) 
    {
        if (bedingung)
          {
           throw new RuntimeException(msg);
          }
    }

}
