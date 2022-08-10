/*
 *  Grundloesung von Prof. M. Esch
 *
 *
 *  autoTypen.h
 */



typedef struct{
	short PS;
	float capacity;
	char cylinder;
} Engine;

typedef struct {
	char brand[20];
	int maxSpeed;
	int doors;
	_Bool ABS;
	Engine engine;
	char extras[10][100];
} Car;

