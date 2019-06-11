// Loop Splitting

#include<iostream.h>
#include<conio.h>
#include<time.h>


void main(){
	int a[10000],i;
	i=1;
	clock_tstarttime=clock();
	while (i<=10000){
		a[i]=0;
		i=i+1;
	}

	cout<<double(clock()-starttime) / (double) CLOCKS_PER_SEC<< "seconds"<<"\n";
	getch();
}