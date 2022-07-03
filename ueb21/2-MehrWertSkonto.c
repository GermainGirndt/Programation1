// Befehl:
// gcc 2-MehrWertSkonto.c -o 2-MehrWertSkonto && ./2-MehrWertSkonto

#include <stdio.h>
int main (void){
    float steuerSatz = 0.2;
    float skontoSatz = 0.02;
    float nettoPreis;
    float steuerBetrag;
    float bruttoPreis;
    float skontoBetrag;
    float rechnungsBetrag;

    printf("Geben Sie den Nettopreis ein: ");
    scanf("%f", &nettoPreis);

    steuerBetrag = nettoPreis * steuerSatz;
    bruttoPreis = nettoPreis + steuerBetrag;
    skontoBetrag = bruttoPreis * skontoSatz;
    rechnungsBetrag = bruttoPreis - skontoBetrag;

    printf("Nettopreis\t\tEuro %7.2f\n", nettoPreis);

    printf("+ 20%% MwSt\t\tEuro %7.2f\n", steuerBetrag);
    printf("=====================================\n");
    printf("Bruttopreis\t\tEuro %7.2f\n", bruttoPreis);
    printf("- 2%% Skonto\t\tEuro %7.2f\n", skontoBetrag);
    printf("=====================================\n");
    printf("Rechnungsbetrag\t\tEuro %7.2f\n", rechnungsBetrag);
}
