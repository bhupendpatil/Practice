import java.util.*;

class ReversalOfAnyNumber {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Reverse any Number");
		System.out.print("Enter Number: ");
		int num=sc.nextInt();
		int a = num;
		int rev=0;
		while(num>0)
		{

			int r=num%10;
			rev=rev*10+r;
			num=num/10;
		}
		System.out.println("Reversal form of '"+a+"' is '"+rev+"'");
	}
}