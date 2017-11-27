class Nestt {
	static String nest1(){
		return "Nesting Done!";
	}

	static String nest2() {
		return nest1();
	}

	static String nest3() {
		return nest2();
	}
}

class NestingOfMethodss {
	public static void main(String args[]) {
		System.out.println(Nestt.nest3());
	}
}