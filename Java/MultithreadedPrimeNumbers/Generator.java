public class Generator extends Thread {
	int num;

	Generator(int num1){
		num=num1;
	}

	public void run(){
		int n,p;
		n=num;
		for(int i=2;i<n;i++){
			p=0;
			for(int j=2;j<i;j++){
				if(i%j==0)
					p=1;
			}
			if(p==0)
				System.out.println(i);
		}
	}
}