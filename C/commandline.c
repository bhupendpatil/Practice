#include <stdio.h>

int main(int arg_count, char *arg_list[]) {
    int i;
    printf("There were %d arguments provided:\n",arg_count);
    for(i=0;i<arg_count;i++){
        printf("argument #%d\t-\t%s\n",i,arg_list[i]);
    }
}

/*
Output:
gcc -o commandline commandline.c
./commandline
./commandline This is Bhupend
argument #0 - ./commandline
argument #1 - This
argument #2 - is
argument #3 - Bhupend
*/