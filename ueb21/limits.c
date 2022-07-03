#include <stdio.h>
#include <limits.h>
int main(void){
    unsigned cha ruch = 0; 
    unsigned short ush = 0;
    unsigned int ui = 0;
    char ch = 0;
    short sh = 0;
    int i = 0;

    while(ch >= 0){
        ch = ch + 1;
    }
    ch = ch - 1;
    printf("Signed Char MinimalWert  %d limits.h: %d \n", ch, CHAR_MAX );
    ch = ch + 1;
    printf("Signed Char MaximalWert berechnet: %d  limits.h: %d \n", ch , CHAR_MIN );
    printf("Unsigned Char MinimalWert  %u limits.h %u \n", uch, 0 );
    uch = uch - 1;
    printf("Unsigned Char MaximalWert %u limits.h %u \n", uch, UCHAR_MAX );
    while(sh >= 0){
        sh = sh + 1;
    }
    sh = sh - 1;
    printf("Signed Short MinimalWert  %d limits.h: %d \n", sh, SHRT_MAX );
    sh = sh + 1;
    printf("Signed Short MaximalWert %d limits.h: %d \n", sh, SHRT_MIN );
    printf("Unsigned Short MinimalWert %u  limits.h: %u \n", ush, 0);
    ush = ush - 1;
    printf("printfUnsigned Short MaximalWert %u limits.h: %u \n", ush, USHRT_MAX);
    while(i>= 0){
        i = i + 1;
    }
    i = i - 1;
    printf("Signed Int MinimalWert  %d limits.h: %d \n", i, INT_MAX );
    i = i + 1;
    printf("Signed Int MaximalWert %d limits.h: %d \n", i, INT_MIN );
    printf("Unsigned Int MinimalWert  %u limits.h %u\n", ui , 0 );
    ui = ui - 1;
    printf("Unsigned Int MaximalWert %u limits.h %u \n\n\n", ui, UINT_MAX );

return 0;

}