class Multi1 {
	public Multi1(){
		System.out.println("From default");
	}
	public Multi1(int i){
		System.out.println("1 value: "+i);
	}
	public Multi1(int j, int k){
		System.out.println("2 values: "+j+" "+k);
	}
}

class ConstructorOverloadingg {
	public static void main(String args[]) {
		Multi1 m1 = new Multi1();
		Multi1 m2 = new Multi1(2);
		Multi1 m3 = new Multi1(2,3);
	}
}