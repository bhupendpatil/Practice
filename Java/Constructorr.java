class Sub1 {
	Sub1(){
		System.out.println("Sub1 created");
	}
}

class Sub2 {
	Sub2(){
		System.out.println("Sub2 created");
	}
}

class Constructorr {
	public static void main(String args[]) {
		Sub1 s1 = new Sub1();
		Sub2 s2 = new Sub2();
	}
}