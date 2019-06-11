// Generate DAG

#include <stdio.h>
#include<conio.h>
#include<string.h>

void main(){
	char node[10][10],optr[10],left[10][10],right[10][10],add[20][10];
	int flag,j,k,issame=0,lastentryempty=0,opt=0,n,i,isop;
	char op[]={'+','-','*','/'};
	char *nodeindex,*lhs,*rhs,*lnode,*rnode,*opindex,*opstr;
	int index;
	clrscr();
	printf("\n total no of 3 addresss statements:");
	scanf("%d",&n);
	printf("\n enter 3 address statements:");
	for(i=0;i<n;i++)
		scanf("%s",add[i]);
	for(i=0;i<n;i++){
		flag=1;
		nodeindex=strchr(add[i],'=');
		index=nodeindex-add[i];
		if(nodeindex){
			if((add[i][index-1]=='>')||(add[i][index-1]=='<'))
				flag=0;
			else
				flag=1;
		}
		if(flag==1){
			lhs=strtok(add[i],"=");
			rhs=strtok(NULL,add[i]);
			isop=0;
			for(k=0;k<strlen(rhs);k++){
				opindex=strchr(op,rhs[k]);
				if(opindex){
					if(lastentryempty==0){
						optr[i]=rhs[k];
						strcpy(node[i],lhs);
					} else {
						optr[i-1]=rhs[k];
						strcpy(node[i-1],lhs);
						// opt++;
					}
					isop=1;
				}
				if(isop==1)
					break;
				else
					isop=0;
			}
			if(isop==1){
				sprintf(opstr,"%c",rhs[k]);
				lnode=strtok(rhs,opstr);
				rnode=strtok(NULL,opstr);
				if(lastentryempty==0){
					strcpy(left[i],lnode);
					strcpy(right[i],rnode);
				} else {
					strcpy(left[i-1],lnode);
					strcpy(right[i-1],rnode);
				}
			} else {
				for(j=0;j<i;j++){
					if(strcmp(rhs,node[j])==0)
						issame=1;
					else
						issame=0;
					if(issame==1){
						strcat(node[j]," ");
						strcat(node[j],lhs);
						lastentryempty=1;
						if(lastentryempty==1)
							opt++;
					}
				}
			}
		}
	}

	printf("\n node\toptr\tleftchild\tright child\n");
	for(i=0;i<n-opt;i++)
		printf("\n %s\t%c\t\t%s\t\t%s",node[i],optr[i],left[i],right[i]);
	getch();
}