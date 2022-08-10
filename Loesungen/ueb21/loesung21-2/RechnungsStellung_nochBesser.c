/*
     RechnungsStellung_nochBesser.c ----> Bsp-Loesung ueb21 Aufgabe 2

*/



#include <stdio.h>

#define EINGABEZEILEN_MAX_LAENGE  100


/*
 *  main-Funktion == Hauptprogramm der Uebung
 *
 */ 
int  main (void)
{
       const double MWST = 0.2, SKONTO = 0.02;

       double nettoPreis, mwst, bruttoPreis, skonto, rechnungsBetrag;
       char eingabeZeile[EINGABEZEILEN_MAX_LAENGE];

       int scanfErg;  
  
  do {   
      printf( "\n\nGeben Sie den Nettopreis der Rechung ein : " );
      fgets( eingabeZeile, EINGABEZEILEN_MAX_LAENGE, stdin );
      scanfErg = sscanf( eingabeZeile,"%lf", &nettoPreis );    
     }
  while ( ! scanfErg );

  mwst = nettoPreis * MWST;
  bruttoPreis = nettoPreis + mwst;
  skonto = bruttoPreis * SKONTO;
  rechnungsBetrag = bruttoPreis - skonto;

  printf( "\n\tNettopreis\t\tEuro  %7.2f", nettoPreis );
  printf( "\n\t+ 20%% MwSt\t\tEuro  %7.2f", mwst );
  printf( "\n\t=======================================" );
  printf( "\n\tBruttopreis\t\tEuro  %7.2f", bruttoPreis );
  printf( "\n\t- 2%% Skonto\t\tEuro  %7.2f", skonto );
  printf( "\n\t=======================================" );
  printf( "\n\tRechnungsbetrag\t\tEuro  %7.2f\n\n", rechnungsBetrag );

  return 0;
 }
