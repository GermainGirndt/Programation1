// Befehl:
// gcc 3-IterativFibonacci.c -o 3-IterativFibonacci && ./3-IterativFibonacci

#include <stdio.h>

signed int getAnzahlAnIteraktionen(void) {
    int anzahlAnIteraktionen;
    printf("Geben Sie die Anzahl an Iteraktionen (Nachkommastellen werden nicht beruecksichtigt): ");
    scanf("%i", &anzahlAnIteraktionen);

    while (anzahlAnIteraktionen < 0 || anzahlAnIteraktionen > 151) {
        // Ueberlauf nach 151
        printf("Fehler! Die Zahl muss zwischen 0 und 151 sein.\n");
        printf("Geben Sie die Anzahl an Iteraktionen (Nachkommastellen werden nicht beruecksichtigt): ");
        scanf("%i", &anzahlAnIteraktionen);
    }  
    
    return anzahlAnIteraktionen;

}

long main (void){
    signed long long int fibonacciPrev = 0;
    signed long long int fibonacciNext = 1;
    signed long long int fibonacciZahl;
    signed int anzahlAnIteraktionen = getAnzahlAnIteraktionen();

    if (anzahlAnIteraktionen == 0) {
        printf("Fibonacci-Zahl: %lli\n", fibonacciPrev);
        return 1;
    }

    if (anzahlAnIteraktionen == 1) {
        printf("Fibonacci-Zahl: %lli\n", fibonacciNext);
        return 1;
    }

    for (long i = 2; i <= anzahlAnIteraktionen; i++) {
        fibonacciZahl = fibonacciPrev + fibonacciNext;
        fibonacciPrev = fibonacciNext;
        fibonacciNext = fibonacciZahl;
    }

    printf("Fibonacci-Zahl: %lli\n", fibonacciZahl);

}