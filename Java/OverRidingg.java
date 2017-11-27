class Aaa1 {
	void run(){
		System.out.println("Vehicle is running");
	}
}

class Bbb1 extends Aaa1 {
	void run(){
			System.out.println("Bike is running safely");
	}
}

class OverRidingg {
	public static void main(String args[]) {
		Bbb1 b = new Bbb1();
		b.run();
	}
}