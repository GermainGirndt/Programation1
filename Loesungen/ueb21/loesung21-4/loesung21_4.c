/*
 * Grundloesung von Prof. M. Esch Aufgabe ueb21-4
 * bearbeitet von W. Pauly
 */


#include <stdio.h>
#include <limits.h>

/* anzeigen der Maximal- und Minimal-Werte von char, short, int
 *
 */
int main( void )
{
     char c = 0;
     while(++c > 0);
     printf("signed char min = %d (%d)\n", c, SCHAR_MIN);
     printf("signed char max = %d (%d)\n", --c, SCHAR_MAX);
  
     short s = 0;
     while(++s > 0);
     printf("signed short min = %d (%d)\n", s, SHRT_MIN);
     printf("signed short max = %d (%d)\n", --s, SHRT_MAX);
         
     int i = 0;
     while(++i > 0);
     printf("signed int min = %d (%d)\n", i, INT_MIN);
     printf("signed int max = %d (%d)\n", --i, INT_MAX);

     unsigned char uc = 0;
     printf("unsigned char max = %d (%d)\n", --uc, UCHAR_MAX);

     unsigned short us = 0;
     printf("unsigned short max = %d (%d)\n", --us, USHRT_MAX);
  
     unsigned int ui = 0;
     printf("unsigned int max = %u (%u)\n", --ui, UINT_MAX);

     return 0;
}
