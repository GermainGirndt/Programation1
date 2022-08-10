#include<stdio.h>

int  multiply(int * a, int * b){
int z3 = (*a) * (*b);
return z3;
}

void add(int * a, int * b, int * c){
    int z = (*a) + (*b);
    *c = z;
}

int check(char s[], int length){

    for(int i = 0; i< length; i++){
        if(s[i] != s[length - i-1]){
            //printf("%c.%c\n", s[i], s[length-i-1]);
            return 0;   
        }
    }
    return 1;
}

int main(){
   /* int z1 = 42;
    int z2 = 2;
    int *a = & z1;
    int *b = & z2 ;
    int *c;

    add(a, b, c);
    printf("%d \n", *c);*/
    
    char text[100];
    for(int i = 0; i<100; i++){
        text[i] = '0';

    }
    scanf("%s", &text);
    int length = 0;
    for(int i = 0; i<100; i++){
        if(text[i] != '0'){
            length++;
        }

    }
    length--;
    
    int erg = check(text, length);
    printf("%d \n", length);
    printf("%d", erg);

}