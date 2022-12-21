/* 
Write a program to print the below texts using printf function

David says, " Programming is fun !"
**Conditions apply, "Offers valid until tomorrow"
C:\My computer\My folder
D:/My documents/My file
\ \ \ \ Today is holiday \ \ \ \
This is a triple quoted string """ This month has 30 days """
*/

#include <stdio.h>

int main(){
    printf(" David says, \" Programming is fun !\"\n");
    printf(" **Conditions apply, \"Offers valid until tomorrow\"\n");
    printf(" C:\\My computer\\My folder\n");
    printf(" D:/My documents/My file\n");
    printf(" \\ \\ \\ \\ Today is holiday \\ \\ \\ \\\n");
    printf(" This is a triple quoted string \"\"\" This month has 30 days \"\"\"");

    return 0;
}

/*
Output:
David says, " Programming is fun !"
**Conditions apply, "Offers valid until tomorrow"
C:\My computer\My folder
D:/My documents/My file
\ \ \ \ Today is holiday \ \ \ \
This is a triple quoted string """ This month has 30 days """
*/