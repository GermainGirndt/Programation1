/*
 *
 *
 * Loesung  W.Pauly 
 *
 *
 */


//
//
//
//17-1.b: Fakultaet als Top-Level-Klasse
// so realisiert:
//                 public class FakultaetTopLevel implements MyFunction
//                 {
//                    public int apply(int x)
//                  ....
//
// nun OHNE implements und Methoden-Name apply möglich !!!!!!!!
// applyAndPrint-Aufruf mit einer Objekt-Methoden-Referenz möglich
//
public class FakultaetTopLevel 
  {
    public int berechne(int x)
      {
        int erg = 1;

        for ( int i = 2; i<=x; i++ )
          {
            erg *= i;
          }

        return erg;
      }
  }

