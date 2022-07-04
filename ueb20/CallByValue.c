#include <stdio.h>
void change(int number) {    
    printf("Vorm Addieren in der Funktion: number=%d \n",number);    
    number = number+100;    
    printf("Nach dem Addieren in der Funktion: number=%d \n", number);    
}    

void swap(int a, int b){
    printf("Vorm Vertauschen in der Funktion: a=%d, b=%d \n", a, b);
    int tmp=a;
    a=b;
    b=tmp;
    printf("Nach dem Vertauschen in der Funktion: a=%d, b=%d \n", a, b);
}

int main(void){
    int x=100;    
    printf("Vor der Funktion Change x=%d \n", x);    
    change(x); 
    printf("Nach der Funktion Change x=%d \n", x);    
    printf("\n");

    int y=20;
    int z=50;
    printf("Vor der Funktion Swap y=%d, z=%d \n", y, z);    
    swap(y, z); 
    printf("Nach der Funktion Swap y=%d, z=%d \n", y, z);    

    return 0;
}