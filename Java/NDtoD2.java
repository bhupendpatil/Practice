// NDFA to DFA

import java.lang.*;	
import java.io.*;

class NDtoD2 {
	public static void main(String args[]){
		String state[]={"A","B","C","D"};	//states arr
		String val[]={"Q1","Q2","Q3","L"};	//values arr
		int i; 
		System.out.println("\n ");
		System.out.print("\tSTATES :\t");

		for(i=0;i<3;i++){
			System.out.print(state[i]+" ");	//printing states
		}
		System.out.println("\n");

		System.out.print("\tTRANSITION VALUE :\t");
		for(i=0;i<4;i++){
			System.out.print(val[i]  + " ");	//printing values
		}
		System.out.println(" ");

		String production[][]=new String[9][4];	//production arr
		production[0][0]=("A");
		production[0][1]=("Q1");
		production[0][2]=("A");
		production[1][0]=("A");
		production[1][1]=("Q3");
		production[1][2]=("B");
		production[2][0]=("B");
		production[2][1]=("Q1");
		production[2][2]=("C");
		production[3][0]=("B");
		production[3][1]=("Q2");
		production[3][2]=("B");
		production[4][0]=("B");
		production[4][1]=("Q2");
		production[4][2]=("A");
		production[5][0]=("C");
		production[5][1]=("Q1");
		production[5][2]=("D");
		production[6][0]=("D");
		production[6][1]=("Q3");
		production[6][2]=("C");
		production[7][0]=("A");
		production[7][1]=("L");
		production[7][2]=("C");
		production[8][0]=("B");
		production[8][1]=("L");
		production[8][2]=("D");

		System.out.println(" ");                       
		System.out.println("\tTRANSITION ARE:");
		System.out.println(" "); 
		int j;
		for(i=0;i<9;i++){
			System.out.print("\t    State  '"+production[i][0]+"'  with transition value'"+production[i][1]+"' goes to  "+production[i][2]);
			System.out.println(" ");
			System.out.println(" ");
		}
		System.out.println(" ");

		/* Transition Table */
		String TT[][]=new  String[5][5];
		TT[0][0]="";
		for(i=0;i<4;i++){
			TT[i+1][0]=state[i];	//for first row
		} 
		for(i=0;i<4;i++){
			TT[0][i+1]=val[i];     //for first column
		}
		int y;
		String t="",t1="";
		for(y=0;y<9;y++){	//production loop	
			for(i=0;i<4;i++){	//row loop
				if(production[y][0].equals(TT[i+1][0])){
					for(j=1;j<5;j++){	//column loop
						if(production[y][1].equals(TT[0][j])){
							t1=TT[i+1][j];
							if(t1==null){
								t=production[y][2];
								TT[i+1][j]=t;
							} else{
								t1=t1.concat(production[y][2]);
								TT[i+1][j]=t1;
								t1="";
							}
						}
					}
				}
			}
		}
		System.out.println(" ");
		System.out.println("\tTRANSITION TABLE  L  MOVES:");

		for(i=0;i<5;i++){
			System.out.print("\n\t\t");
			for(j=0;j<5;j++){
				if(TT[i][j]==null){
					System.out.print("-"+"     ");
				} else {
					System.out.print(TT[i][j]+"    ");
				}
			}
			System.out.println("");
		}
		System.out.println("\n");
		System.out.println("\tTRANSITION TABLE WITHOUT L MOVES:");
		for(i=0;i<5;i++){
			System.out.print("\n\t\t");
			for(j=0;j<4;j++){
				if(TT[i][j]==null){
					System.out.print("-"+"     ");
				} else {
					System.out.print(TT[i][j]+"    ");
				}
			}
			System.out.println("");
		}

		System.out.println("");
		//sub transition table
		String sub[][]=new String[10][10];	//copy first row
		sub[0][0]=("");
		sub[0][1]=TT[0][1];
		sub[0][2]=TT[0][2];
		sub[0][3]=TT[0][3];
		sub[0][4]=TT[0][4];
		sub[1][0]=TT[1][0];
		sub[1][1]=TT[1][1];
		sub[1][2]=TT[1][2];
		sub[1][3]=TT[1][3];
		sub[1][4]=TT[1][4];

		int kl,i1=1,j1,k1=1;

		String str1="",str2="",str4="",str5="",str6="",str7="",str8="";
		String copy[]=new String[12];	//new arr to store proccessed state
		copy[0]=("A");
		for(i=1;i<10;i++){
			loop1:for(j=1;j<4;j++){
				if(sub[i][j]==null){
					continue loop1;
				} else if(sub[i][j].equals(sub[i][0])) {
					continue loop1;
				} else {
					str1=sub[i][j];
					for(j1=0;j1<k1;j1++){
						if(str1.equals(copy[j1])){
							continue loop1;
						}
					}
					copy[k1]=str1;
					k1++;

					if(str1.length()>1){
						sub[i1+1][0]=str1;
						for( int k=1;k<5;k++){
							if(TT[k][0].equals(str1.substring(0,1))){
								str2=sub[i1+1][1];
								if(str2==null){
									str6=TT[k][1];
									sub[i1+1][1]=str6;
								}
								str4=sub[i1+1][2];
								if(str4==null){
									str7=TT[k][2];
									sub[i1+1][2]=str7;
								}
								str5=sub[i1+1][3];
								if(str5==null){
									str8=TT[k][3];
									sub[i1+1][3]=str8;
								}
							}
						}
						for( int k=1;k<5;k++){
							if(TT[k][0].equals(str1.substring(1,2))){
								str2=sub[i1+1][1];
								if(str2==null){
									str6=TT[k][1];
									sub[i1+1][1]=str6;
								} else {
									if(TT[k][1]==null){}	
									else {
										str6=str6.concat(TT[k][1]);
										str6="";
									}
								}
								str4=sub[i1+1][2];
								if(str4==null){
									str7=TT[k][2];
									sub[i1+1][2]=str7;
								} else {
									if(TT[k][2]==null){}
									else {
										str7=str7.concat(TT[k][2]);
										sub[i1+1][2]=str7;
										str7="";
									}
								}

								str5=sub[i1+1][3];
								if(str5==null){
									str8=TT[k][3];
									sub[i1+1][3]=str8;
								} else {
									if(TT[k][3]==null){}
									else{
										str8=str8.concat(TT[k][3]);
										sub[i1+1][3]=str8;
										str8="";
									}
								}
							}
						}
					} else {
						sub[i1+1][0]=str1;
						for( int k=1;k<5;k++){
							if(TT[k][0].equals(sub[i1+1][0])){
								sub[i1+1][1]=TT[k][1];
								sub[i1+1][2]=TT[k][2];
								sub[i1+1][3]=TT[k][3];
							}
						}
					}
					i1++;
				}
			}
		}
		System.out.println("");
		System.out.println("\tSUB TRANSITION TABLE  WITHOUT L MOVES:");
		System.out.println(" ");

		for(i=0;i<10;i++){
			System.out.print("\n\t\t");
			for(j=0;j<4;j++){
				if(sub[i][j]==null){
					System.out.print("-"+"     ");
				} else {
					System.out.print(sub[i][j]+"    ");
				}
			}
			System.out.println("");
		}

		System.out.println("\n");
		System.out.println("");
	}
}