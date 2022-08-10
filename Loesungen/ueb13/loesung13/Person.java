
/**
 * Die Klasse Person repraesentiert eine Person
 *                    mit Vorname und Nachname.
 *
 * @author Wolfgang Pauly
 * @version -1.0 beta 2022-04-11
 */
public class Person
{
    // Attribute (Instanzvariablen)
    private String vorname;
    private String nachname;

    /**
     * Konstruktor für Objekte der Klasse Person
     * 
     * @param initVorname Der Vorname der zu erzeugenden Person
     * @param initNachname Der Nachname der zu erzeugenden Person
     */
    public Person(String initVorname, String initNachname)
           throws PersonException
    {
      PersonException.nameKorrekt( initVorname );
      PersonException.nameKorrekt( initNachname );

      vorname  = initVorname;
      nachname = initNachname;
    }

    /**
    * Die getVorname-Methode
    * 
    */
    public String getVorname()
    {
        return vorname;
    }

    /**
    * Die getNachname-Methode
    * 
    */
    public String getNachname()
    {
        return nachname;
    }

    /**
    * Die equals-Methode
    * 
    * Compares this object to the specified object. 
    * The result is true if and only if the argument is not null and is an Person-object 
    * that contains the same values for vorname, nachname as this object
    */
    public boolean equals(Object vergleichsPerson)
    {
        return  ( vergleichsPerson != null ) &&
                ( vergleichsPerson instanceof Person) &&
                ((Person)vergleichsPerson).getVorname().equals(vorname) &&
                ((Person)vergleichsPerson).getNachname().equals(nachname);
    }


    /**
     * Die toString-Methode
     *
     */
    public String toString()
    {
        return vorname + " " + nachname + " ";
    }

}
