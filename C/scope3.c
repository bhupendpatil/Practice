#include <stdio.h>

int j = 42;

void func3() {
    int i = 11, j = 999;
    printf("\t\t\t[in func3] i @ 0x%08x = %d\n", &i, i);
    printf("\t\t\t[in func3] j @ 0x%08x = %d\n", &j, j);
}

void func2() {
    int i = 7;
    printf("\t\t[in func2] i @ 0x%08x = %d\n", &i, i);
    printf("\t\t[in func2] j @ 0x%08x = %d\n", &j, j);
    printf("\t\t[in func2] setting j = 1337\n");
    j = 1337;
    func3();
    printf("\t\t[back in func2] i @ 0x%08x = %d\n", &i, i);
    printf("\t\t[back in func2] j @ 0x%08x = %d\n", &j, j);
}

void func1() {
    int i = 5;
    printf("\t[in func1] i @ 0x%08x = %d\n", &i, i);
    printf("\t[in func1] j @ 0x%08x = %d\n", &j, j);
    func2();
    printf("\t[back in func1] i @ 0x%08x = %d\n", &i, i);
    printf("\t[back in func1] j @ 0x%08x = %d\n", &j, j);
}

int main() {
    int i = 3;
    printf("[in main] i @ 0x%08x = %d\n", &i, i);
    printf("[in main] j @ 0x%08x = %d\n", &j, j);
    func1();
    printf("[back in main] i @ 0x%08x = %d\n", &i, i);
    printf("[back in main] j @ 0x%08x = %d\n", &j, j);
}

/*
Output:
[in main] i @ 0x888d1c04 = 3
[in main] j @ 0x805bb010 = 42
	[in func1] i @ 0x888d1be4 = 5
	[in func1] j @ 0x805bb010 = 42
		[in func2] i @ 0x888d1bc4 = 7
		[in func2] j @ 0x805bb010 = 42
		[in func2] setting j = 1337
			[in func3] i @ 0x888d1ba0 = 11
			[in func3] j @ 0x888d1ba4 = 999
		[back in func2] i @ 0x888d1bc4 = 7
		[back in func2] j @ 0x805bb010 = 1337
	[back in func1] i @ 0x888d1be4 = 5
	[back in func1] j @ 0x805bb010 = 1337
[back in main] i @ 0x888d1c04 = 3
[back in main] j @ 0x805bb010 = 1337

gcc -g -o scope3 scope3.c
gdb -q ./scope3
list 1
break 7
run
bt
bt full
*/