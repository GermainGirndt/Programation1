/*
 * str.c
 *
 *  Created on: 06.01.2018
 *      Author: regina
 */
#include <stdio.h>
#include <stdlib.h>
#include "str.h"

int my_strcmp(char* string1, char* string2) {
	int i = 0;
	do {
		char char1 = string1[i];
		char char2 = string2[i];
		if (char1 == '\0' && char2 == '\0')
			return 0;
		if (char1 == '\0')
			return -1;
		if (char2 == '\0')
			return 1;
		if (char1 > char2)
			return 1;
		if (char1 < char2)
			return -1;
		i++;
	} while (TRUE);
	return 0;
}

int my_strspn(char* string1, char* string2){
	int count = 0;
	while (*string1) {
		if( *string1 == *string2 ){
			count++;
		}else{
			return count;
		}
		string1++;
		string2++;
	}
	return count;
}

int my_strlen(char* string) {
	for (int i = 0; TRUE; i++) {
		if (string[i] == '\0')
			return i;
	}
	return 0;
}

int firstIndexOf(char* string, char c) {
	for (int i = 0; string[i] != '\0'; i++) {
		if (string[i] == c)
			return i;
	}
	return -1;
}

int lastIndexOf(char* string, char c) {
	int lastIndex = -1;
	for (int i = 0; string[i] != '\0'; i++) {
		if (string[i] == c)
			lastIndex = i;
	}
	return lastIndex;
}

void replace(char* string, char old, char new) {
	while (*string) {
		if (*string == old)
			*string = new;
		string++;
	}
}

void toUpperCase(char* string) {
	while (*string) {
		if (*string >= 'a' && *string <= 'z') {
			*string = (*string) - 32;
		}
		string++;
	}
}

void swap(char* string1, char* string2) {
	while (*string1) {
		char tempChar = *string1;
		*string1 = *string2;
		*string2 = tempChar;
		string1++;
		string2++;
	}
}
