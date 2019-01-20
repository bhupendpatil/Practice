class DemoThread extends Thread {
	public void run(){
		System.out.println("Thread is running...");
	}

	public static void main(String[] args){
		DemoThread thread = new DemoThread();
		thread.start();
	}
}