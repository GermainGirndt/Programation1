/*
     RechnungsStellung_Einfach.c ----> Bsp-Loesung ueb21 Aufgabe 2

*/



#include <stdio.h>


/*
 *  main-Funktion == Hauptprogramm der Uebung
 *
 */ 
int  main (void)
{
       const double MWST = 0.2, SKONTO = 0.02;
       double nettoPreis, mwst, bruttoPreis, skonto, rechnungsBetrag;

  printf( "\n\nGeben Sie den Nettopreis der Rechung ein : " );
  scanf( "%lf", &nettoPreis );

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
