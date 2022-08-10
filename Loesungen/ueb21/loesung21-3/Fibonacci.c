/**
 *    Fibonacci-Zahlen-Berechnung ---> Loesung Uebung21 Aufgabe 3
 *
 */



#include <stdio.h>

#define EINGABEZEILEN_MAX_LAENGE  100


/**Funktions-Prototyp-Deklarationen
 */
double leseIntegerZahl( const char* );
void   fibo( int grenze );



/**
 *  main-Funktion == Hauptprogramm der Uebung
 *
 */ 
int  main (void)
{
    int anzahlFiboZahlen;
 
    printf( "\n\n dieses Programm berechnet die ersten n Fibonacci-Zahlen !\n");
    anzahlFiboZahlen = leseIntegerZahl( "\t Gebe n ein : ");

    fibo(anzahlFiboZahlen);

  return 0;
 }





/**
 *  fibo - berechnte die ersten n Fibonacci-Zahlen und gibt sie aus
 *
 * @param  anzahl   Anzahl der zu berechnenden Fibonacci-Zahlen
 */
void fibo( int anzahl  )
  {
     long fibN, fibN1 = 1, fibN2 = 1;

   if ( anzahl > 0 )
     {
       printf( "\n %5ld, %5ld", fibN1, fibN2 );
       for (int i=3; i <= anzahl; i++)
         {
           fibN = fibN1 + fibN2;
           fibN2 = fibN1;
           fibN1 = fibN;
           printf( ", %5ld", fibN );
         }
       printf( "\n\n" );
     }
    else 
     {
       printf( "\n Anzahl der zu berechnenden Fibonacci-Zahlen muss > 0 sein !!!\n" );
     }
}



/**
 *  leseIntegerZahl - liest moeglichst fehlerfrei eine IntegerZahl
 *
 * @param  aufforderung   der Eingabeaufforderungs-String
 * @return                die Integerzahl
 */
double leseIntegerZahl( const char *aufforderung )
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
