/*
 ============================================================================
 Name        : str_test.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include "str.h"

int main(void) {
	char* string1 = "string3x";
	char* string2 = "string3";
	int result = my_strcmp(string1, string2);
	printf("Ergebnis strcmp von %s und %s: %d \n", string1, string2, result );

	string1 = "stri";
	string2 = "string3";
	result = my_strcmp(string1, string2 );
	printf("Ergebnis strcmp von %s und %s: %d \n", string1, string2, result );

	string1 = "string";
	string2 = "string";
	result = my_strcmp(string1, string2);
	printf("Ergebnis strcmp von %s und %s: %d \n", string1, string2, result );

	string1 = "string1";
	string2 = "string2";
	result = my_strcmp(string1, string2);
	printf("Ergebnis strcmp von %s und %s: %d \n", string1, string2, result );

	string1 = "string2";
	string2 = "string1";
	result = my_strcmp(string1, string2 );
	printf("Ergebnis strcmp von %s und %s: %d \n", string1, string2, result );

	string1 = "string1";
	string2 = "string2";
	result = my_strspn(string1, string2 );
	printf("Ergebnis strspn von %s und %s: %d \n", string1, string2, result );

	string1 = "string1";
	string2 = "str";
	result = my_strspn(string1, string2 );
	printf("Ergebnis strspn von %s und %s: %d \n", string1, string2, result );


	char* string = "string";
	result = my_strlen(string);
	printf("Ergebnis strlen von %s: %d \n", string, result );

	string = "";
	result = my_strlen(string);
	printf("Ergebnis strlen von %s: %d \n", string, result );

	string = "0123456789";
	result = firstIndexOf(string, '5');
	printf("Ergebnis firstIndexOf von 5 in %s: %d\n", string, result );

	string = "0123401234";
	result = lastIndexOf(string, '4');
	printf("Ergebnis lastIndexOf von 4 in %s: %d\n\n", string, result );

	char string5[] = "11113333";
	printf("Vor  replace  %s \n", string5);
	replace(string5, '1', '2');
	printf("Nach replace 1 durch 2 %s \n\n", string5);

	char toUpper[6] = "Hallo";
	printf("Vor  toUpperCase %s\n", toUpper);
	toUpperCase(toUpper);
	printf("Nach toUpperCase %s\n\n", toUpper);

	char string6[] = "string1";
	char string7[] = "string2";
	printf("Vor  swap %s %s\n", string6, string7);
	swap(string6, string7);
	printf("Nach swap %s %s\n\n", string6, string7);

	return 0;
}
