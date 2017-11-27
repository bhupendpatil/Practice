import java.util.*;

class AreaOfRectangle{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Find area of Rectangle");
		
		System.out.print("Enter Width: ");
		int w = sc.nextInt();

		System.out.print("Enter Length: ");
		int l = sc.nextInt();

		System.out.println("'"+(w*l)+ " sq.unit' is area of Rectangle. If width is '"+w+"' and length is '"+l+"'.");

	}
}