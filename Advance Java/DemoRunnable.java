class DemoRunnable implements Runnable {
	public void run(){
		System.out.println("Thread is running...");
	}

	public static void main(String[] args){
		DemoRunnable runn = new DemoRunnable();
		Thread thread = new Thread(runn);
		thread.start();
	}
}