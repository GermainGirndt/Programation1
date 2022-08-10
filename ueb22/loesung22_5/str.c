/*
 * str.c
 *
 *  Created on: 06.01.2018
 *      Author: regina
 */
#include <stdio.h>
#include <stdlib.h>
#include "str.h"

int my_strcmp(char string1[], char string2[]) {
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

int my_strspn(char string1[], char string2[]){
	int count = 0;
	while (string1[count]) {
		if( string1[count] == string2[count] ){
			count++;
		}else{
			return count;
		}
		count++;
	}
	return count;
}

int my_strlen(char string[]) {
	int i = 0;
	for (i = 0; string[i] != '\0'; i++) {
	}
	return i;
}

int firstIndexOf(char string[], char c) {
	for (int i = 0; string[i] != '\0'; i++) {
		if (string[i] == c)
			return i;
	}
	return -1;
}

int lastIndexOf(char string[], char c) {
	int lastIndex = -1;
	for (int i = 0; string[i] != '\0'; i++) {
		if (string[i] == c)
			lastIndex = i;
	}
	return lastIndex;
}

void replace(char string[], char old, char new) {
	for (int i = 0; string[i] != '\0'; i++) {
		if (string[i] == old)
			string[i] = new;
	}
}

void toUpperCase(char string[]) {
	for (int i = 0; string[i] != '\0'; i++) {
		if (string[i] >= 'a' && string[i] <= 'z') {
			string[i] = string[i] - 32;
		}
	}
}

void swap(char string1[], char string2[]) {
	for (int i = 0; string1[i]; i++) {
		char tempChar = string1[i];
		string1[i] = string2[i];
		string2[i] = tempChar;
	}
}
