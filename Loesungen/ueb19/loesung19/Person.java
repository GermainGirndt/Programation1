// Java-Beispiele
// Prof. Dr. H. G. Folz
// 
// Erweitert W. Pauly 
// 

 


public class Person
{

  private String name;
  private String vorname;


  public Person() {}

  public Person( String name, String vorname) {
  // hier fehlt die Parameter-Ueberpruefung !!!!!!!!
      this.name    = name;
      this.vorname = vorname;
  }

  public void ausgeben() {
      System.out.print( this.toString() );
  }

  public void setName(String n) {
  // hier fehlt die Parameter-Ueberpruefung !!!!!!!!
      name = n;
  }

  public void setVorname(String vn) {
  // hier fehlt die Parameter-Ueberpruefung !!!!!!!!
      vorname = vn;
  }

  public String getName() {
      return name;
  }

  public String getVorname() {
      return vorname;
  }
  
  public String toString() {
      return  String.format( " %15s, %15s ", name, vorname) ;
  }
}
