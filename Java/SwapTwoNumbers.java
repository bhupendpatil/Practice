import java.util.*;

class SwapTwoNumbers
{
public static void main(String args[])
{
	Scanner sc = new Scanner(System.in);

	System.out.print("Enter 1st value: ");	
	int a = sc.nextInt();

	System.out.print("Enter 2nd value: ");
	int b = sc.nextInt();

	System.out.println("Before Swaping value of a = "+a+" and value of b = "+b);	
	a = a + b;
	b = a - b;
 	a = a - b;
	System.out.println("After Swaping value of a = "+a+" and value of b = "+b);
}
}
