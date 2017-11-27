class Threadsss extends Thread {
	public void run(){
		System.out.println("Thread Name: "+Thread.currentThread().getName()+" and Priority: "+Thread.currentThread().getPriority());
	}
}

class ThreadPriority {
	public static void main(String[] args) {
		Threadsss t1 = new Threadsss();
		Threadsss t2 = new Threadsss();
		Threadsss t3 = new Threadsss();
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}
}