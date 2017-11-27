import java.util.*;

class FibonacciSeries {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("How many elements you want in Fibonacci Series? ");
		int b = sc.nextInt();

		int j = 0; int k = 1; int l=0;

		for(int i=0;i<b;i++){
			System.out.println(j+i);
			System.out.println(k+i);
		}
	}
}