/*
 *  Grundloesung von Prof. M. Esch
 *
 *
 * auto.c
 */



#include<stdio.h>
#include "auto.h"



Car createCar(char brand [], int maxSpeed, int doors, _Bool ABS, short PS, float capacity, char cylinder, char extras[])
{
	Engine e = {PS, capacity, cylinder};
	Car res = {"", maxSpeed, doors, ABS, e, { } };
	
	for(int i = 0; i<20; i++)
		res.brand[i] = brand[i];
	for(int i = 0; i<10; i++)
		for(int j = 0; j<100; j++)
			res.extras[i][j] = extras[i * 100 + j];
	return res;
}


int strcomp(char a[], char b[], int size)
{
	for(int i=0; i<size;i++)
	{
		if(a[i]<b[i])
			return -1;
		else if(b[i]<a[i])
			return 1;
	}
	return 0;
}

int calcValue(Car c)
{
	int value = 50;
	value *= c.maxSpeed;
	value *= c.doors;
	if(c.ABS)
		value += 5000;
		
	for(int i = 0; i < 10; i++)
		if(c.extras[i][0] != '\0')
			value += 3000;
	if(strcomp(c.brand, "Porsche", 20) == 0)
		value *= 2;
	return value;
}

void printCar(Car c)
{
	printf("Brand: %s\n", c.brand);
	printf("Max Speed: %d\n", c.maxSpeed);
	printf("Doors: %d\n", c.doors);
	if(c.ABS)
		printf("ABS\n");
	printf("PS: %d\n", c.engine.PS);
	printf("Capacity: %f\n", c.engine.capacity);
	printf("Cylinder: %d\n", c.engine.cylinder);
	
	printf("Extras\n");
	for(int i = 0; i < 10; i++)
		if(c.extras[i][0] != '\0')
			printf("\t%s\n", c.extras[i]);
}
