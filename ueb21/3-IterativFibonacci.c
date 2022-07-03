// Befehl:
// gcc 3-IterativFibonacci.c -o 3-IterativFibonacci && ./3-IterativFibonacci

#include <stdio.h>

int getAnzahlAnIteraktionen(void) {
    int anzahlAnIteraktionen;
    printf("Geben Sie die Anzahl an Iteraktionen (Nachkommastellen werden nicht beruecksichtigt): ");
    scanf("%i", &anzahlAnIteraktionen);

    while (anzahlAnIteraktionen < 0) {
        printf("Fehler! Die Zahl muss groesser gleich null sein.\n");
        printf("Geben Sie die Anzahl an Iteraktionen (Nachkommastellen werden nicht beruecksichtigt): ");
        scanf("%i", &anzahlAnIteraktionen);
    }  
    
    return anzahlAnIteraktionen;

}


int main (void){
    int fibonacciPrev = 0;
    int fibonacciNext = 1;
    int fibonacciZahl;
    int anzahlAnIteraktionen = getAnzahlAnIteraktionen();

    if (anzahlAnIteraktionen == 0) {
        printf("Fibonacci-Zahl: %i\n", fibonacciPrev);
        return 1;
    }

    if (anzahlAnIteraktionen == 1) {
        printf("Fibonacci-Zahl: %i\n", fibonacciNext);
        return 1;
    }

    for (int i = 2; i <= anzahlAnIteraktionen; i++) {
        fibonacciZahl = fibonacciPrev + fibonacciNext;
        fibonacciPrev = fibonacciNext;
        fibonacciNext = fibonacciZahl;
    }

    printf("Fibonacci-Zahl: %i\n", fibonacciZahl);

}