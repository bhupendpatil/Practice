import java.util.*;

class Reversalof2digits
{
public static void main(String args[])
{
	Scanner sc = new Scanner(System.in);

	System.out.print("Enter 2 digit number: ");
	int a = sc.nextInt();
	
	int b = a/10;
	int c = a-(b*10);
	System.out.println("Reverse of 2 digit numbers is "+((c*10)+b));
}
}
