// Generate DAG

import java.io.*;
import java.util.*;

class DAG{
	public static void main(String args[])throws IOException{
		String str="";
		int i,j,k;
		String st[];
		String quad[][]=new String[10][10];
		String label[]=new String[10];
		String op[]=new String[10];
		String arg1[]=new String[10];
		String arg2[]=new String[10];

		int c;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("How many statements you want to enter?");
		c=Integer.parseInt(br.readLine());
		st=new String[c];
		System.out.println("Enter the statements:");
		for(i=0;i<st.length;i++){
			str=br.readLine();
			st[i]=""+str;
		}
		System.out.println("Entered statements are as follows:");
		for(i=0;i<st.length;i++){
			System.out.println(st[i]);
		}
		for(i=0;i<c;i++){
			int eq=st[i].indexOf("=");
			quad[i][0]=st[i].substring(0,eq);
			quad[i][1]=st[i].substring(eq+1);
		}
		for(j=0;j<c;j++){
			label[j]=quad[j][0];
			for(i=0;i<quad[j][1].length();i++){
				if(quad[j][1].charAt(0)=='-'){
					op[j]="Umin";
					arg1[j]=quad[j][1].substring(1,quad[j][1].length());
					arg2[j]="-";
					break;
				}
				if(quad[j][1].charAt(i)=='+'||quad[j][1].charAt(i)=='-'||quad[j][1].charAt(i)=='*'){
					arg1[j]=quad[j][1].substring(0,i);
					op[j]=""+quad[j][1].charAt(i);
					arg2[j]=quad[j][1].substring(i+1,quad[j][1].length());
					break;
				} else {
					op[j]="=";
					arg1[j]=quad[j][1].substring(0,quad[j][1].length());
					arg2[j]="-";
				}
			}
		}
		for(j=1;j<c;j++){
			for(i=0;i<j;i++){
				if((op[j].equals(op[i]))&&(arg1[j].equals(arg1[i]))&&(arg2[j].equals(arg2[i]))){
					label[i]=label[i]+","+label[j];
					op[j]="";
					arg1[j]="";
					arg2[j]="";
					label[j]="";
				}
			}
		}
		System.out.println("Operators for above statements are as follows:");
		for(i=1;i<6;i++){
			System.out.print("t"+i+" ");
		}
		System.out.print("c"+" "+"b");
		System.out.println("\nThe operands for above statements are as follows:");
		System.out.print(""+op[0]+" "+op[1]+" "+op[4]+" "+op[5]);
		System.out.println("\nOutput of DAG:");
		System.out.println("  "+"Lable"+"\t"+"Operator"+"\t"+"Argument1"+"\t"+"Argument2");
		for(i=0;i<c;i++){
			System.out.println("  "+label[i]+"\t  "+op[i]+"\t\t"+arg1[i]+"\t\t  "+arg2[i]);
		}
		System.out.println("Root Node is :"+label[5]);
	}
}