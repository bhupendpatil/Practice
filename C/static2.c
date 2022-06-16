#include <stdio.h>

void function() {
    int var = 5;
    static int static_var = 5;
    
    printf("\t[in function] var @ %p = %d\n", &var, var);
    printf("\t[in function] static_var @ %p = %d\n", &static_var, static_var);
    var++;
    static_var++;
}

int main() {
    int i;
    static int static_var = 1337;
    
    for(i=0;i<5;i++){
        printf("[in main] static_var @ %p = %d\n", &static_var, static_var);
        function();
    }
}

/*
Output:
[in main] static_var @ 0x55a7b4bc1014 = 1337
	[in function] var @ 0x7ffea47f48b4 = 5
	[in function] static_var @ 0x55a7b4bc1010 = 5
[in main] static_var @ 0x55a7b4bc1014 = 1337
	[in function] var @ 0x7ffea47f48b4 = 5
	[in function] static_var @ 0x55a7b4bc1010 = 6
[in main] static_var @ 0x55a7b4bc1014 = 1337
	[in function] var @ 0x7ffea47f48b4 = 5
	[in function] static_var @ 0x55a7b4bc1010 = 7
[in main] static_var @ 0x55a7b4bc1014 = 1337
	[in function] var @ 0x7ffea47f48b4 = 5
[in function] static_var @ 0x55a7b4bc1010 = 8
[in main] static_var @ 0x55a7b4bc1014 = 1337
	[in function] var @ 0x7ffea47f48b4 = 5
	[in function] static_var @ 0x55a7b4bc1010 = 9
*/