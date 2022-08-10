/*
 * Loesung von W. Pauly 07.07.2022
 */


#include <stdio.h>
#define EINGABEZEILEN_MAX_LAENGE  100

// Funktionsprototypen
int leseIntegerZahl( const char* );
void druckeKreuz(int dim);

/*  Programm zum Testen, dass Funktionsuebergabe-Parameter
 *  Wert-Parameter sind 
 *  also call-by-value - Paramener
 *
 */	
int main(void)
{
     int dim = 7;

  do
   {
    dim = leseIntegerZahl("Gebe ungerade Zahl ein :  ");
   }
  while ( (dim % 2) == 0 );

  druckeKreuz( dim );

  return 0;
}


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



void druckeKreuz(int dim)
{
     int zeile, spalte;

   for ( zeile = 1; zeile <= dim; zeile++ )
     {
       for ( spalte = 1; spalte <= dim; spalte ++ )
         {
          if ( ( spalte == zeile ) || 
               ( spalte == (dim + 1 - zeile))
             )
            {
             printf("*");
            }
          else
            {
             printf("-");
            }
         }
       printf("\n");
     }
}
