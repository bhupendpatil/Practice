class Inh1 {
	int a = 2;
}

class Inh2 extends Inh1{
	int b = 3;
	int c = 4;
}

class Inh3 extends Inh2{
	int d = 5;
	int e = 6;
}

class MultiInheritance{
	public static void main(String args[]) {
		Inh3 s1 = new Inh3();
		System.out.println(s1.a+" "+s1.b+" "+s1.c+" "+s1.d+" "+s1.e);
	}
}