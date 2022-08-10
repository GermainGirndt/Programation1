/**
 *    <H1> Das Interface:  <B>Queue.java</B></H1>
 *    ist eine sehr einfache SchnittstellenBeschreibung fuer eine Queue-Klasse
 *
 * @version    1.0 Beta 2022_01_18  
 * @author    Wolfgang Pauly
 *
 */

public interface Queue
{

  /**
   *    addLast -> haengt Object an Queue an
   *
   *    Vorbedingung !full()
   *
   *    @param o   das aufzunehmende Object
   */
  public void addLast ( Object o );

  /**
   *    removeFirst -> entfernt ein Object von der Spitze der
   *    Queue und gibt dieses zurueck.  
   *
   *    Vorbedingung !empty()
   */
  public Object removeFirst();

  /**
   *    get -> gebe das i'te E$lement zurück
   *
   *    Vorbedingung !empty()
   *    
   *    @return das i'te Element
   */
  public Object get(int i);

  /**
   *    empty -> ist Queue LEER ???
   *
   *    @return    true wenn Queue LEER, sonst false
   */
  public boolean empty();

  /**
   *    full -> ist Queue VOLL ???
   *
   *    @return    true wenn Queue VOLL, sonst false
   */
  public boolean full();

  /**
   *    size -> Anzahl der Elemente in Queue
   *
   *    @return    Anzahl der Elemente
   */
  public int size();
}
