#include <stdio.h>

int main() {
    int a,b;
    float c,d;
    a = 13;
    b = 5;
    
    c = a/b;
    d = (float) a / (float) b;
    printf("[integers]\t a = %d\t b = %d\n",a,b);
    printf("[float]\t c = %f\t d = %f\n",c,d);
}

/*
Output
[integers]	 a = 13	 b = 5
[float]	 c = 2.000000	 d = 2.600000
*/