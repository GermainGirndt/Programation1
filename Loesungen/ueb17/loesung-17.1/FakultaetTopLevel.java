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
//1.b: Fakultaet als Top-Level-Klasse
//
public class FakultaetTopLevel implements MyFunction
  {
    public int apply(int x)
      {
        int erg = 1;

        for ( int i = 2; i<=x; i++ )
          {
            erg *= i;
          }

        return erg;
      }
  }

