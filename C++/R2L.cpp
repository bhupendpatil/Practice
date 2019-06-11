#include<stdio.h>
#include<conio.h>

void main(){
	char rhs[4][2]={"b","bU","cR","c"},lhs[4]={'R','S','U','U'},temp;
	int i,j;
	clrscr();

	printf("Initial Productions are:-");
	for (i=0;i<4;i++){
		printf("%c--->%c%c \n",lhs[i],rhs[i][0],rhs[i][1]);
	}

	printf("Production after Grammar");
	for(i=0;i<4;i++){
		if(rhs[i][0]>=97 &&rhs[i][0]<=122){
			temp=rhs[i][0];
			rhs[i][0]=rhs[i][1];
			rhs[i][1]=temp;
		}
	}

	for(i=0;i<4;i++){
		if(rhs[i][0]==0)
			printf("%c--->S%c \n",lhs[i],rhs[i][1]);
		else
			printf("%c--->%c%c\n",lhs[i],rhs[i][0],rhs[i][1]);
	}

	getch();
}