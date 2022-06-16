#include <stdio.h>

int main() {
    int i;
    
    char char_array[5] = {'a','b','c','d','e'};
    int int_array[5] = {1,2,3,4,5};
    
    char *char_pointer;
    int *int_pointer;
    
    char_pointer = int_array;
    int_pointer = char_array;
    
    for(i=0;i<5;i++){
        printf("[integer pointer] points to %p, which contains the char '%c'\n",int_pointer,*int_pointer);
        int_pointer++;
    }
    
    for(i=0;i<5;i++){
        printf("[char pointer] points to %p, which contains the integer %d\n",char_pointer,*char_pointer);
        char_pointer++;
    }
}

/*
Output:
[integer pointer] points to 0x7ffeac44d3b3, which contains the char 'a'
[integer pointer] points to 0x7ffeac44d3b7, which contains the char 'e'
[integer pointer] points to 0x7ffeac44d3bb, which contains the char ''
[integer pointer] points to 0x7ffeac44d3bf, which contains the char '$'
[integer pointer] points to 0x7ffeac44d3c3, which contains the char '
*/