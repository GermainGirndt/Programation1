/*
 * str.h
 *
 *  Created on: 06.01.2018
 *      Author: regina
 */

#ifndef STR_H_
#define STR_H_

#define FALSE 0
#define TRUE 1

int my_strcmp(char string1[], char string2[]);

int my_strspn(char string1[], char string2[]);

int my_strlen(char string[]);

int firstIndexOf(char string[], char c);

int lastIndexOf(char string[], char c);

void replace(char string[], char old, char new);

void toUpperCase(char string[]);

void swap(char string1[], char string2[]);

#endif /* STR_H_ */
