/*
 *  Grundloesung von Prof. M. Esch
 *
 *
 */



#include<stdio.h>
#include "auto.h"

int main(void)
{
	char extras [10][100] = { "Klimaanlage", "Ledersitze", "Allradantrieb" } ;
  	Car c = createCar("Porsche", 300, 3, 1, 250, 3.3, 6, extras[0]);
        printf("\nMerkmale des Autos : \n");
  	printCar(c);
  	printf("\nvalue: %d\n", calcValue(c));
  	
	
	//Aufgabe 4:
	printf("\n\n Speicherbelegung \n\n size of car c: %lu\n", sizeof(c));
	printf("c.brand addr: %p, offset: %d, size: %lu\n", 
                (void *)&c.brand, (int)&c.brand-(int)&c, sizeof(c.brand)
              );
	printf("c.maxSpeed addr: %p, offset: %d, size: %lu\n", 
                (void *)&c.maxSpeed, (int)&c.maxSpeed-(int)&c, sizeof(c.maxSpeed)
              );
	printf("c.doors addr: %p, offset: %d, size: %lu\n", 
                (void *)&c.doors, (int)&c.doors-(int)&c, sizeof(c.doors)
              );
	printf("c.ABS addr: %p, offset: %d, size: %lu\n", 
                (void *)&c.ABS, (int)&c.ABS-(int)&c, sizeof(c.ABS)
              );
	printf("c.engine addr: %p, offset: %d, size: %lu\n", 
                (void *)&c.engine, (int)&c.engine-(int)&c, sizeof(c.engine)
              );
	printf("c.extras addr: %p, offset: %d, size: %lu\n\n", 
                (void *)&c.extras, (int)&c.extras-(int)&c, sizeof(c.extras)
              );
	
	printf("c.engine.PS addr: %p, offset: %d, size: %lu\n", 
                (void *)&c.engine.PS, (int)&c.engine.PS-(int)&c, sizeof(c.engine.PS)
              );
	printf("c.engine.capacity addr: %p, offset: %d, size: %lu\n", 
                (void *)&c.engine.capacity, (int)&c.engine.capacity-(int)&c, sizeof(c.engine.capacity)
              );
	printf("c.engine.cylinder addr: %p, offset: %d, size: %lu\n", 
                (void *)&c.engine.cylinder, (int)&c.engine.cylinder-(int)&c, sizeof(c.engine.cylinder)
              );
	printf("\n\n");
	
	return 0; 
}
