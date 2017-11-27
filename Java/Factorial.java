import java.util.*;

class Factorial {
	public static void main(String args[]) {
		int f,a,i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Find Factorial");

		System.out.println("Enter the number: ");
		a = sc.nextInt();
		f = 1;
		for (i=a;i>=1;i--){
			f = f * i;
		}
		System.out.println("Factorial for '"+a+"' is '"+ f +"'");
	}
}