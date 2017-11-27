import java.util.*;

class CalculateSimpleInterest
{
public static void main(String args[])
{
	Scanner sc = new Scanner(System.in);
	
	System.out.print("Enter Principle: ");	
	int p = sc.nextInt();

	System.out.print("Enter Number: ");
	int n = sc.nextInt();

	System.out.print("Enter Rate: ");
	int r = sc.nextInt();
	
	float pnr = p*n*r;
	System.out.println("Simple Interest is "+pnr/100);
}
}
