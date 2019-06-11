// Generate SPM

#include<stdio.h>
#include<conio.h>
#include<alloc.h>
#include<string.h>

void main() {
	char **at,sort[100],ch,ntt[100],**less1,**great2,**equal1,**parse;
	int i,j,n,q,s,a,u,m,l,p=0,c,k=0,y,z=0,d,mx,my;
	int **first,**equal,**last,**trans,**lastp,**firstp,**firsts,**less,**great,**great1;
	clrscr();
	printf("\n How Many Production You Want:");
	scanf("%d",&n);
	at=(char **)malloc(n*sizeof(int *));

	for(i=0;i<n;i++){
		at[i]=(char *)malloc(2*n);
	}
	printf("Enter a production:");
	for(i=0;i<n;i++){
		scanf("%s",&at[i][0]);
	}
	for(i=0;i<n;i++){
		c=strlen(at[i]);
		for(j=0;j<c;j++){
			sort[p]=at[i][j];
			p++;
			q=p;
		}
	}

	for(p=0;p<q;p++){
		for(s=p+1;s<q;s++){
			if(sort[p]>=sort[s]){
				u=sort[p];
				sort[p]=sort[s];
				sort[s]=u;
			}
		}
	}

	for(p=0;p<q;p++){
		ch=sort[p];
		if(ch!=sort[p+1]){
			if(ch!='='){
				sort[k]=ch;
				ntt[z]=sort[k];
				//printf("%c",ntt[z]);
				k++;
				z++;
			}
		}
		d=z;
	}

	printf("\nTotal no of non terminal& terminal:");
	for(i=0;i<d;i++){
		printf("%c",ntt[i]);
	}
	getch();
	first=(int **)malloc(d*sizeof(int *));
	for(i=0;i<d;i++){
		first[i]=(int *)malloc(2*d);
	}
	firstp=(int **)malloc(d*sizeof(int *));
	for(i=0;i<d;i++){
		firstp[i]=(int *)malloc(2*d);
	}
	firsts=(int **)malloc(d*sizeof(int *));
	for(i=0;i<d;i++){
		firsts[i]=(int *)malloc(2*d);
	}
	less=(int **)malloc(d*sizeof(int *));
	for(i=0;i<d;i++){
		less[i]=(int *)malloc(2*d);
	}
	great=(int **)malloc(d*sizeof(int *));
	for(i=0;i<d;i++){
		great[i]=(int *)malloc(2*d);
	}
	great1=(int **)malloc(d*sizeof(int *));
	for(i=0;i<d;i++){
		great1[i]=(int *)malloc(2*d);
	}
	printf("\n");

	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			first[i][j]=0;
			trans[i][j]=0;
			firstp[i][j]=0;
			firsts[i][j]=0;
			less[i][j]=0;
			great[i][j]=0;
			great1[i][j]=0;
		}
	}

	for(i=0;i<n;i++){
		ch=at[i][0];
		for(m=0;m<d;m++){
			if(ch==ntt[m]){
				mx=m;
			}
		}
		ch=at[i][2];
		for(a=0;a<d;a++){
			if(ch==ntt[a]){
				my=a;
			}
		}
		first[mx][my]=1;
	}

	clrscr();
	printf("\n\n\n\t\t\tFIRST MATRIX:\n\n");
	printf("\n\t\t\t");
	for(j=0;j<d;j++)
		printf("%2c",ntt[j]);
	printf("\n");
	for(i=0;i<d;i++){
		printf("\n\t\t\t%c",ntt[i]);
		for(j=0;j<d;j++){
			printf("%2d",first[i][j]);
		}
		printf("\n");
	}
	getch();
	//for first plus
	i=0;
	while(i<d){
		for(j=0;j<d;j++){
			if(first[j][i]==1){
				for(k=0;k<d;k++){
					first[j][k]=(first[j][k] || first[i][k]);
					firstp[j][k]=first[j][k];
					firsts[j][k]=firstp[j][k];
				}
			}
		}
		i++;
	}
	clrscr();

	printf("\n\n\n\t\t\tFIRST PLUS MATRIX:\n\n");
	printf("\n\t\t\t");
	for(j=0;j<d;j++)
		printf("%2c",ntt[j]);
	printf("\n");
	for(i=0;i<d;i++){
		printf("\n\t\t\t%c",ntt[i]);
		for(j=0;j<d;j++){
			printf("%2d",firstp[i][j]);
		}
		printf("\n");
	}
	getch();

	// for first *
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			if(i==j){
				first[i][j]=1;
				firsts[i][j]=first[i][j];
			}
		}
	}

	clrscr();
	printf("\n\n\n\t\t\tFIRST STAR MATRIX:\n\n");
	printf("\n\t\t\t");
	for(j=0;j<d;j++)
		printf("%2c",ntt[j]);
	printf("\n");
	for(i=0;i<d;i++){
		printf("\n\t\t\t%c",ntt[i]);
		for(j=0;j<d;j++){
			printf("%2d",firsts[i][j]);
		}
		printf("\n");
	}

	getch();

	//for equal matrix
	equal=(int **)malloc(d*sizeof(int *));
	for(i=0;i<d;i++){
		equal[i]=(int *)malloc(2*d);
	}
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			equal[i][j]=0;
		}
	}
	for(i=0;i<n;i++){
		c=strlen(at[i]);
		if(c>3){
			for(j=2;j<c-1;j++){
				ch=at[i][j];
				for(m=0;m<d;m++){
					if(ch==ntt[m]){
						mx=m;
					}
				}
				ch=at[i][j+1];
				for(a=0;a<d;a++){
					if(ch==ntt[a]){
						my=a;
					}
				}
				equal[mx][my]=1;
			}
		}
	}
	equal1=(char **)malloc(d*sizeof(int *));
	for(i=0;i<d;i++){
		equal1[i]=(char *)malloc(2*d);
	}
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			equal1[i][j]='0';
		}
	}
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			if(equal[i][j]>0){
				equal1[i][j]='=';
			}
		}
	}

	clrscr();
	printf("\n\n\n\t\t\tEQUAL MATRIX:\n\n");
	printf("\n\t\t\t");
	for(j=0;j<d;j++)
		printf("%2c",ntt[j]);
	printf("\n");
	for(i=0;i<d;i++){
		printf("\n\t\t\t%c",ntt[i]);
		for(j=0;j<d;j++){
			printf("%2c",equal1[i][j]);
		}
		printf("\n");
	}

	getch();

	// For Last
	last=(int **)malloc(d*sizeof(int *));
	for(i=0;i<d;i++){
		last[i]=(int *)malloc(2*d);
	}
	printf("\n");
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			last[i][j]=0;
		}
	}
	for(i=0;i<n;i++){
		c=strlen(at[i]);
		ch=at[i][0];
		for(m=0;m<d;m++){
			if(ch==ntt[m]){
				mx=m;
			}
		}
		ch=at[i][c-1];
		for(a=0;a<d;a++){
			if(ch==ntt[a]){
				my=a;
			}
		}
		last[mx][my]=1;
	}

	clrscr();
	printf("\n\n\n\t\t\tLAST MATRIX:\n\n");
	printf("\n\t\t\t");
	for(j=0;j<d;j++)
		printf("%2c",ntt[j]);
	printf("\n");
	for(i=0;i<d;i++){
		printf("\n\t\t\t%c",ntt[i]);
		for(j=0;j<d;j++){
			printf("%2d",last[i][j]);
		}
		printf("\n");
	}
	getch();

	//for Last plus
	lastp=(int **)malloc(d*sizeof(int *));

	for(i=0;i<d;i++){
		lastp[i]=(int *)malloc(2*d);
	}
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			lastp[i][j]=0;
		}
	}
	
	i=0;
	while(i<d){
		for(j=0;j<d;j++){
			if(last[j][i]==1){
				for(k=0;k<d;k++){
					last[j][k]=(last[j][k] || last[i][k]);
					lastp[j][k]=last[j][k];
				}
			}
		}
		i++;
	}

	clrscr();
	printf("\n\n\n\t\t\tLAST PLUS MATRIX:\n\n");
	printf("\n\t\t\t");
	for(j=0;j<d;j++)
		printf("%2c",ntt[j]);
	printf("\n");
	for(i=0;i<d;i++){
		printf("\n\t\t\t%c",ntt[i]);
		for(j=0;j<d;j++){
			printf("%2d",lastp[i][j]);
		}
		printf("\n");
	}
	getch();

	// for last *
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			if(i==j){
				last[i][j]=1;
			}
		}
	}

	clrscr();
	printf("\n\n\n\t\t\tLAST STAR MATRIX:\n\n");
	printf("\n\t\t\t");
	for(j=0;j<d;j++)
		printf("%2c",ntt[j]);
	printf("\n");
	for(i=0;i<d;i++){
		printf("\n\t\t\t%c",ntt[i]);
		for(j=0;j<d;j++){
			printf("%2d",last[i][j]);
		}
		printf("\n");
	}
	getch();
   
   // for Last Transposition
	trans=(int **)malloc(d*sizeof(int *));
	for(i=0;i<d;i++){
		trans[i]=(int *)malloc(2*d);
	}
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			trans[i][j]=0;
		}
	}
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			trans[j][i]=lastp[i][j];
		}
	}

	clrscr();
	printf("\n\n\n\t\t\tTRANSPOSION OF LAST PLUS MATRIX:\n\n");
	printf("\n\t\t\t");
	for(j=0;j<d;j++)
		printf("%2c",ntt[j]);
	printf("\n");
	for(i=0;i<d;i++){
		printf("\n\t\t\t%c",ntt[i]);
		for(j=0;j<d;j++){
			printf("%2d",trans[i][j]);
		}
		printf("\n");
	}
	getch();

	// FOR LESS THAN
	less1=(char **)malloc(d*sizeof(int *));
	for(i=0;i<d;i++){
		less1[i]=(char *)malloc(2*d);
	}
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			less1[i][j]='0';
		}
	}
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			less[i][j]=0;
			for(k=0;k<d;k++){
				less[i][j]+=equal[i][k]*firstp[k][j];
			}
		}
	}
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			if(less[i][j]>0){
				less1[i][j]='<';
			}
		}
	}

	clrscr();
	printf("\n\n\n\t\t\tLESS THAN MATRIX:\n\n");
	printf("\n\t\t\t");
	for(j=0;j<d;j++)
		printf("%2c",ntt[j]);
	printf("\n");
	for(i=0;i<d;i++){
		printf("\n\t\t\t%c",ntt[i]);
		for(j=0;j<d;j++){
			printf("%2c",less1[i][j]);
		}
		printf("\n");
	}
	getch();

	//FOR GREATER
	great2=(char **)malloc(d*sizeof(int *));
	for(i=0;i<d;i++){
		great2[i]=(char *)malloc(2*d);
	}
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			great2[i][j]='0';
		}
	}
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			great[i][j]=0;
			for(k=0;k<d;k++){
				great[i][j]+=trans[i][k]*equal[k][j];
			}
		}
	}
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
		//great1[i][j]=0;
			for(k=0;k<d;k++){
				great1[i][j]+=great[i][k]*firsts[k][j];
			}
		}
	}
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			if(great1[i][j]>0){
				great2[i][j]='>';
			}
		}
	}

	clrscr();
	printf("\n\n\n\t\t\tGREATER THAN MATRIX:\n\n");
	printf("\n\t\t\t");
	for(j=0;j<d;j++)
		printf("%2c",ntt[j]);
	printf("\n");
	for(i=0;i<d;i++){
		printf("\n\t\t\t%c",ntt[i]);
		for(j=0;j<d;j++){
			printf("%2c",great2[i][j]);
		}
		printf("\n");
	}
	getch();

	//For Super Impose
	clrscr();
	parse=(char **)malloc(d*sizeof(int *));
	for(i=0;i<d;i++){
		parse[i]=(char *)malloc(2*d);
	}
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			parse[i][j]='0';
		}
	}
	for(i=0;i<d;i++){
		for(j=0;j<d;j++){
			if(less1[i][j]=='<'){
				parse[i][j]='<';
			}
			if(great2[i][j]=='>'){
				parse[i][j]='>';
			}
			if(equal1[i][j]=='='){
				parse[i][j]='=';
			}
		}
	}
	clrscr();
	printf("\n\n\n\t\t\tSIMPLE PRECEDENCE MATRIX:\n\n");
	printf("\n\t\t\t");
	for(j=0;j<d;j++)
		printf("%2c",ntt[j]);
	printf("\n");
	for(i=0;i<d;i++){
		printf("\n\t\t\t%c",ntt[i]);
		for(j=0;j<d;j++){
			printf("%2c",parse[i][j]);
		}
		printf("\n");
	}
	getch();
}