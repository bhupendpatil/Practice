#include <stdio.h>

int global_var;
int global_initialized_var = 5;

void function() {
    int stack_var;
    printf("the function's stack_var is at address 0x%08x\n", &stack_var);
}

int main() {
    int stack_var;
    static int static_initialized_var = 5;
    static int static_var;
    int *heap_var_ptr;
    heap_var_ptr = (int *) malloc(4);
    
    // data segment.
    printf("global_initialized_var is at address 0x%08x\n", &global_initialized_var);
    printf("static_initialized_var is at address 0x%08x\n\n", &static_initialized_var);
    
    // bss segment.
    printf("static_var is at address 0x%08x\n", &static_var);
    printf("global_var is at address 0x%08x\n\n", &global_var);
    
    // heap segment.
    printf("heap_var is at address 0x%08x\n\n", heap_var_ptr);
    
    // stack segment.
    printf("stack_var is at address 0x%08x\n", &stack_var);
    function();
}

/*
Output:
global_initialized_var is at address 0x3f697010
static_initialized_var is at address 0x3f697014

static_var is at address 0x3f69701c
global_var is at address 0x3f697020

heap_var is at address 0x3f7842a0

stack_var is at address 0x424c3c9c
the function's stack_var is at address 0x424c3c74
*/