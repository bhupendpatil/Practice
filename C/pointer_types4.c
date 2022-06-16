#include <stdio.h>

int main() {
    int i;
    
    char char_array[5] = {'a','b','c','d','e'};
    int int_array[5] = {1,2,3,4,5};
    
    void *void_pointer;
    
    void_pointer = (void *) char_array;
    
    for(i=0;i<5;i++){
        printf("[char pointer] points to %p, which contains the char '%c'\n",void_pointer,*((char *) void_pointer));
        void_pointer = (void *) ((char *) void_pointer + 1);
    }
    
    void_pointer = (void *) int_array;
    
    for(i=0;i<5;i++){
        printf("[integer pointer] points to %p, which contains the integer %d\n",void_pointer,*((char *) void_pointer));
        void_pointer = (char *) ((int *) void_pointer + 1);
    }
}

/*
Output:
[char pointer] points to 0x7ffe817b0143, which contains the char 'a'
[char pointer] points to 0x7ffe817b0144, which contains the char 'b'
[char pointer] points to 0x7ffe817b0145, which contains the char 'c'
[char pointer] points to 0x7ffe817b0146, which contains the char 'd'
[char pointer] points to 0x7ffe817b0147, which contains the char 'e'
[integer pointer] points to 0x7ffe817b0120, which contains the integer 1
[integer pointer] points to 0x7ffe817b0124, which contains the integer 2
[integer pointer] points to 0x7ffe817b0128, which contains the integer 3
[integer pointer] points to 0x7ffe817b012c, which contains the integer 4
[integer pointer] points to 0x7ffe817b0130, which contains the integer 5
*/