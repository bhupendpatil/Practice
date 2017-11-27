import java.util.*;

class UltaPyramid {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("How much stars you want in first line? ");
		int a = sc.nextInt();


		for(int i=0;i<a;i++){
			for(int j=1;j<=a-i;j++){
				System.out.print("* ");
			}
			System.out.println();
	 	}
	}
}