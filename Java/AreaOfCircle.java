import java.util.*;

class AreaOfCircle
{
public static void main(String args[])
{
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter radius: ");
	double r = sc.nextDouble();
	System.out.println("Area of Circle is "+ (r*r*3.14) +" sq.units");
}
}
