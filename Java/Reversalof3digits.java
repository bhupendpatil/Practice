import java.util.*;

class Reversalof3digits
{
public static void main(String args[])
{
	Scanner sc = new Scanner(System.in);	

	int a,b,c,d,e;
	System.out.print("Enter 3 digit number: "); //234
	a = sc.nextInt();
	b = a/10; //23
	c = a/100; //2
	d = b%10; //3
	e = a%10; //4
	System.out.println("Reverse of "+a+" is "+((e*100)+(d*10)+c));
}
}
