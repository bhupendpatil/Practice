#include<stdio.h>
#include<conio.h>

void main(){
  char init[3],term[3],final[3],terminal[3]={'a','*','b'},non_term[3]={'S','U','R'},temp,temp1,temp2;
  int i,index,j;
  clrscr();
  for(i=0;i<3;i++){
    printf("Enter the values for initial symbols\t");
    scanf("%s",&init[i]);

    if(init[i]==non_term[0]||init[i]==non_term[1]||init[i]==non_term[2]){}
    else{
      printf("Enter the values for initial symbols again\t");
      scanf("%s",&init[i]);
    }

    printf("Enter the values for terminal symbols\t");
    scanf("%s",&term[i]);
    if(term[i]==terminal[0]||term[i]==terminal[1]||term[i]==terminal[2]){}
    else{
      printf("Enter the values for terminal symbols again\t");
      scanf("%s",&term[i]);
    }
    
    printf("Enter the values for final symbols\t");
    scanf("%s",&final[i]);
    if(final[i]==non_term[0]||final[i]==non_term[1]||final[i]==non_term[2]){}
    else{
      printf("Enter the values for final symbols again\t");
      printf("\n");
      scanf("%s",&final[i]);
    }
    printf("\n");
  }

  for(i=0;i<3;i++){
    if(term[i]=='*'){
      index=i;
      temp=final[i];
    }
  }

  for(i=0;i<3;i++){
    if(init[i]==temp){
      temp1=term[i];
      temp2=final[i];
    }
  }

  term[index]=temp1;
  final[index]=temp2;

  printf("Terminal Symbols after conversion \n");

  for(j=0;j<3;j++){
    if(term[j]==term[j+1]){}
      else
        printf("%c \n",term[j]);
  }

  printf("\n Non terminal Symbols after conversion \n");
  for(i=0;i<3;i++){
    printf("%c \n",init[i]);
  }
  getch();
}