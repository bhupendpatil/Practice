class Addition1 {
	static int addd(int a, int b){
		return a+b;
	}

	static int addd(int a, int b, int c){
		return a+b+c;
	}
}

class MethodsOverloadingg {
	public static void main(String args[]) {
		System.out.println(Addition1.addd(2,3));
		System.out.println(Addition1.addd(2,2,4));
	}
}