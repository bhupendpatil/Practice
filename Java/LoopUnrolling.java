// Loop Unrolling

public class LoopUnrolling {
	public static void main(String[] args){
		int[] array1 = new int[5];
		long t1 = System.currentTimeMillis();
		// Version 1: assign elements in a loop.
		for (int i = 0; i < 10000000; i++){
			for (int x = 0; x < array1.length; x++){
				array1[x] = x;
			}
		}

		long t2 = System.currentTimeMillis();
		// Version 2: unroll the loop and use a list of statements.
		for (int i = 0; i < 10000000; i++){
			array1[0] = 0;
			array1[1] = 1;
			array1[2] = 2;
			array1[3] = 3;
			array1[4] = 4;
		}

		long t3 = System.currentTimeMillis();
		// ... Times.
		System.out.println("Time taken by processor before loop unrolling:-->  "+ (t2 - t1));
		System.out.println("Time taken by processor after loop unrolling:-->  "+ (t3 - t2));
	}
}