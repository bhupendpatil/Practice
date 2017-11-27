class Inhert1 {
	int a = 2;
}

class Inhert2 extends Inhert1{
	int b = 3;
	int c = 4;
}

class SingleInheritance{
	public static void main(String args[]) {
		Inhert2 s1 = new Inhert2();
		System.out.println(s1.a+" "+s1.b+" "+s1.c);
	}
}