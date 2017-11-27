import java.util.*;

class SaralPyramid {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("How much stars you want in last line? ");
		int a = sc.nextInt();

		String b = "*";

		for(int i=0;i<a;i++){
			System.out.println(b);
			b = b + " *";
		}
	}
}