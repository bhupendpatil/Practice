#include <stdio.h>

int main() {
    int i;
    
    char char_array[5] = {'a','b','c','d','e'};
    int int_array[5] = {1,2,3,4,5};
    
    unsigned int hacky_nonpointer;
    
    hacky_nonpointer = (unsigned int) char_array;
    
    for(i=0;i<5;i++){
        printf("[hacky_nonpointer] points to %p, which contains the char '%c'\n",hacky_nonpointer,*((char *) hacky_nonpointer));
        hacky_nonpointer = hacky_nonpointer + sizeof(char);
    }
    
    hacky_nonpointer = (unsigned int) int_array;
    
    for(i=0;i<5;i++){
        printf("[hacky_nonpointer] points to %p, which contains the integer %d\n",hacky_nonpointer,*((int *) hacky_nonpointer));
        hacky_nonpointer = hacky_nonpointer + sizeof(int);
    }
}

/*
Output:
[hacky_nonpointer] points to 0xbffff810, which contains the char 'a'
[hacky_nonpointer] points to 0xbffff811, which contains the char 'b'
[hacky_nonpointer] points to 0xbffff812, which contains the char 'c'
[hacky_nonpointer] points to 0xbffff813, which contains the char 'd'
[hacky_nonpointer] points to 0xbffff814, which contains the char 'e'
[hacky_nonpointer] points to 0xbffff7f0, which contains the integer 1
[hacky_nonpointer] points to 0xbffff7f4, which contains the integer 2
[hacky_nonpointer] points to 0xbffff7f8, which contains the integer 3
[hacky_nonpointer] points to 0xbffff7fc, which contains the integer 4
[hacky_nonpointer] points to 0xbffff800, which contains the integer
*/