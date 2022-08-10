#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
  int i, j, lines;

  printf("Enter number of lines: ");
  scanf("%d", &lines);

  /* Lösung mit for-Schleifen */
  
   for(i = 0; i < lines; i++) { /* für jede Zeile */
    for(j = 0; j < lines; j++) { /* für jede Spalte */
      if(j == i || j == lines-i-1) { /* Test ob auf der Diagonalen */
        printf("*");
      } else {
        printf("-");
      }
    }
    printf("\n");
  }

  printf("\n");

  /* Lösung mit while-Schleifen */
  i = 0;
  while(i < lines) {
    j = 0;
    while(j < lines) {
      if(j == i || j == lines-i-1) {
        printf("*");
      } else {
        printf("-");
      }
      j++;
    }
    printf("\n");
    i++;
  }

  printf("\n");

  /* Lösung mit nur einer while-Schleifen */
  i = 0;
  j = 0;
  while(i < lines) {
    if(j == i || j == lines-i-1) {
      printf("*");
    } else {
      printf("-");
    }
    if(++j == lines) {
      j = 0;
      i++;
      printf("\n");
    }
  }

  return 0;
}
