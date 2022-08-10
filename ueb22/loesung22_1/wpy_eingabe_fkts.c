#include <stdio.h>
#include "wpy_eingabe_fkts.h"

#define EINGABEZEILEN_MAX_LAENGE  100


/*
 *  leseIntegerZahl - liest moeglichst fehlerfrei eine IntegerZahl
 *
 * @param  aufforderung   der Eingabeaufforderungs-String
 * @return                die Integerzahl
 */
int leseIntegerZahl( const char *aufforderung )
{
       char eingabeZeile[EINGABEZEILEN_MAX_LAENGE];
       int sscanfErg;
       int einInteger;

  do {
      printf( "\n\n%s", aufforderung );
      fgets( eingabeZeile, EINGABEZEILEN_MAX_LAENGE, stdin );
      sscanfErg = sscanf( eingabeZeile,"%d", &einInteger );
     }
  while ( ! sscanfErg );

  return einInteger;
}




/*
 *  leseDoubleZahl - liest moeglichst fehlerfrei eine DoubleZahl
 *
 * @param  aufforderung   der Eingabeaufforderungs-String
 * @return                die Doublezahl
 */
double leseDoubleZahl( const char *aufforderung )
{
       char eingabeZeile[EINGABEZEILEN_MAX_LAENGE];
       int sscanfErg;
       double eineDouble;

  do {
      printf( "\n\n%s", aufforderung );
      fgets( eingabeZeile, EINGABEZEILEN_MAX_LAENGE, stdin );
      sscanfErg = sscanf( eingabeZeile,"%lf", &eineDouble );
     }
  while ( ! sscanfErg );

  return eineDouble;
}

