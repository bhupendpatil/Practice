#include <stdio.h>
#include <stdlib.h>

void usage(char *program_name) {
    printf("Usage: %s <message> <# of times to repeat>\n",program_name);
    exit(1);
}

int main(int argc, char *argv[]) {
    int i, count;
    
    if(argc < 3)
        usage(argv[0]);
    
    count = atoi(argv[2]);
    printf("Repeating %d times..\n", count);
    
    for(i=0;i<count;i++)
        printf("%3d - %s\n",i,argv[1]);
}

/*
Output:
gcc -o convert convert.c
./convert 'Bhupend Patil' 8
Repeating 5 times..
  0 - Bhupend Patil
  1 - Bhupend Patil
  2 - Bhupend Patil
  3 - Bhupend Patil
  4 - Bhupend Patil
  5 - Bhupend Patil
  6 - Bhupend Patil
  7 - Bhupend Patil
*/