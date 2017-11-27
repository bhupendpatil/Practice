import java.util.*;

class EvenOddNumber {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("To find if number is even or odd");
		System.out.print("Enter number: ");
		int a = sc.nextInt();
		if (a%2==0){
			System.out.println("Number '"+ a + "' is Even");
		} else {
			System.out.println("Number '"+ a + "' is Odd");
		}
	}
}