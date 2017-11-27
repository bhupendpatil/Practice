import java.util.*;

class RectanglePerimeter{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Find Preimeter of Rectangle");
		
		System.out.print("Enter Width: ");
		int w = sc.nextInt();

		System.out.print("Enter Length: ");
		int l = sc.nextInt();

		System.out.println("'"+(2*(w+l))+ "' is perimeter of Rectangle. If width is '"+w+"' and length is '"+l+"'.");

	}
}