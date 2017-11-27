import java.util.*;

class CirclePerimeter {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Find Perimeter of Circle");
		System.out.print("Enter radius: ");
		double r = sc.nextDouble();
		System.out.println("Perimeter of Circle is "+(2*3.14*r));
	}
}