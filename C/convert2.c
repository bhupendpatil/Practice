#include <stdio.h>

void usage(char *program_name) {
    printf("Usage: %s <message> <# of times to repeat>\n",program_name);
    exit(1);
}

int main(int argc, char *argv[]) {
    int i, count;
    
    count = atoi(argv[2]);
    printf("Repeating %d times..\n", count);
    
    for(i=0;i<count;i++)
        printf("%3d - %s\n",i,argv[1]);
}

/*
Output:
gcc -o convert2 convert2.c
./convert test
Segmentation fault (core dumped)

gcc -g -o convert2 convert2.c
gdb -q ./convert2

run test
where
break main
run test
cont
x/3xw 0xbffff894
x/s 0xbffff9b3
x/s 0xbffff9ce
x/s 0x00000000
quit
y
*/