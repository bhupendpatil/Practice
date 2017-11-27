import java.util.*;

class AverageElement{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter how many elements you want in String? ");
		int b = sc.nextInt();

		float a[] = new float[b];

		float d = 0;

		for(int i=0;i<b;i++){
			System.out.print("Enter value "+(i+1)+" :");
			a[i]= sc.nextFloat();

			d = d + a[i];
		}

		System.out.println("Average is "+(d/b));


	}
}