/*
 *  Grundloesung von Prof. M. Esch
 *
 *   auto.h
 */



#include<stdio.h>
#include "autoTypen.h"



Car createCar(char brand [], int maxSpeed, int doors, _Bool ABS, short PS, float capacity, char cylinder, char extras[]);
int strcomp(char a[], char b[], int size);
int calcValue(Car c);
void printCar(Car c);
