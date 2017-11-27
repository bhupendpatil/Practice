class MT1 extends Thread {
	public void run(){
		System.out.println("Thread is running");
	}
}

class MultiThreadingg {
	public static void main(String args[]) {
		MT1 a = new MT1();
		a.start();
	}
}