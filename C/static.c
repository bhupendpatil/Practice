#include <stdio.h>

void function() {
    int var = 5;
    static int static_var = 5;
    
    printf("\t[in function] var = %d\n", var);
    printf("\t[in function] static_var = %d\n", static_var);
    var++;
    static_var++;
}

int main() {
    int i;
    static int static_var = 133;
    
    for(i=0;i<5;i++){
        printf("[in main] static_var = %d\n", static_var);
        function();
    }
}

/*
Output:
[in main] static_var = 133
	[in function] var = 5
	[in function] static_var = 5
[in main] static_var = 133
	[in function] var = 5
	[in function] static_var = 6
[in main] static_var = 133
	[in function] var = 5
	[in function] static_var = 7
[in main] static_var = 133
	[in function] var = 5
	[in function] static_var = 8
[in main] static_var = 133
	[in function] var = 5
	[in function] static_var = 9
*/