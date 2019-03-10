import java.util.Scanner;

public class Prime {
	public static void main(String args[]){
		int num;
		Scanner s= new Scanner(System.in);
		System.out.print("Enter upto which number prime numbers are needed: ");
		num=s.nextInt();

		Generator pt= new Generator(num);
		pt.start();
	}
}
