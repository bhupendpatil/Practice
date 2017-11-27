class Asach {
	synchronized void printing(int n){
		for(int i=1;i<=5;i++){
			System.out.println(n*i);
			try {
				Thread.sleep(400);
			} catch(Exception e){
				System.out.println(e);
			}
		}
	}
}

class Thread1 extends Thread {
	Asach asa;
	Thread1(Asach asa) {
		this.asa = asa;
	}
	public void run(){
		asa.printing(5);
	}
}

class Thread2 extends Thread {
	Asach asa;
	Thread2(Asach asa){
		this.asa = asa;
	}
	public void run(){
		asa.printing(100);
	}
}

class SynchronizedMethod {
	public static void main(String[] args){
		Asach asa = new Asach();
		Thread1 t1 = new Thread1(asa);
		Thread2 t2 = new Thread2(asa);
		t1.start();
		t2.start();
	}
}