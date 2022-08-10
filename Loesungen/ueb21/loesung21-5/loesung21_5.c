/*
 * Loesung  von W. Pauly 2022      ueb21-5
 */



#include <stdio.h>

// Funktionsprototypen
int cbvTest(int val);

/*  Programm zum Testen, dass Funktionsuebergabe-Parameter
 *  Wert-Parameter sind 
 *  also call-by-value - Paramener
 *
 */	
int main(void)
{
     int input = 1000,
         output;


  printf("\nVor  Funktionsaufruf --> Ubergabe-Parameter input = %d\n\n", input);
  output = cbvTest(input);
  printf("\nNach Funktionsaufruf --> Ubergabe-Parameter input = %d, Rueckgabe-Wert = %d\n\n",
         input, output
	);

  return 0;
}




int cbvTest(int val){
   printf("\tIn Funktion Ubergabe-Parameter vor  Zuweisung = %d\n", val );
   val = 9999;
   printf("\tIn Funktion Ubergabe-Parameter nach Zuweisung = %d\n", val );
   return val;	
}
