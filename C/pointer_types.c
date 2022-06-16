#include <stdio.h>

int main() {
    int i;
    
    char char_array[5] = {'a','b','c','d','e'};
    int int_array[5] = {1,2,3,4,5};
    
    char *char_pointer;
    int *int_pointer;
    
    char_pointer = char_array;
    int_pointer = int_array;
    
    for(i=0;i<5;i++){
        printf("[integer pointer] points to %p, which contains the integer %d\n",int_pointer,*int_pointer);
        int_pointer++;
    }
    
    for(i=0;i<5;i++){
        printf("[char pointer] points to %p, which contains the char '%c'\n",char_pointer,*char_pointer);
        char_pointer++;
    }
}

/*
Output
[integer pointer] points to 0x7ffe453ec320, which contains the integer 1
[integer pointer] points to 0x7ffe453ec324, which contains the integer 2
[integer pointer] points to 0x7ffe453ec328, which contains the integer 3
[integer pointer] points to 0x7ffe453ec32c, which contains the integer 4
[integer pointer] points to 0x7ffe453ec330, which contains the integer 5
[char pointer] points to 0x7ffe453ec343, which contains the char 'a'
[char pointer] points to 0x7ffe453ec344, which contains the char 'b'
[char pointer] points to 0x7ffe453ec345, which contains the char 'c'
[char pointer] points to 0x7ffe453ec346, which contains the char 'd'
[char pointer] points to 0x7ffe453ec347, which contains the char 'e'
*/