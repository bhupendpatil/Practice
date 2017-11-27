class ExceptionHandelingg {
	public static void main(String args[]) {
		try {
			int num1=30, num2=0;
         	int output=num1/num2;
         	System.out.println ("Result = "+output);
		}
		catch(ArithmeticException e) {
			System.out.println("Arithmetic Exception: You can't divide an integer by 0");
		}
	}
}