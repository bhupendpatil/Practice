#include <stdio.h>

int main() {
    int i;
    
    char char_array[5] = {'a','b','c','d','e'};
    int int_array[5] = {1,2,3,4,5};
    
    char *char_pointer;
    int *int_pointer;
    
    char_pointer = (char *) int_array;
    int_pointer = (int *) char_array;
    
    for(i=0;i<5;i++){
        printf("[integer pointer] points to %p, which contains the char '%c'\n",int_pointer,*int_pointer);
        int_pointer = (int *) ((char *) int_pointer + 1);
    }
    
    for(i=0;i<5;i++){
        printf("[char pointer] points to %p, which contains the integer %d\n",char_pointer,*char_pointer);
        char_pointer = (char *) ((int *) char_pointer + 1);
    }
}

/*
Output:
[integer pointer] points to 0x7ffea0c152a3, which contains the char 'a'
[integer pointer] points to 0x7ffea0c152a4, which contains the char 'b'
[integer pointer] points to 0x7ffea0c152a5, which contains the char 'c'
[integer pointer] points to 0x7ffea0c152a6, which contains the char 'd'
[integer pointer] points to 0x7ffea0c152a7, which contains the char 'e'
[char pointer] points to 0x7ffea0c15280, which contains the integer 1
[char pointer] points to 0x7ffea0c15284, which contains the integer 2
[char pointer] points to 0x7ffea0c15288, which contains the integer 3
[char pointer] points to 0x7ffea0c1528c, which contains the integer 4
[char pointer] points to 0x7ffea0c15290, which contains the integer 5
*/