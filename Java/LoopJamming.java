// Loop Jamming

public class LoopJamming {
	public static void main(String[] args){
		int[] array1 = { 10, 20, 30 };
		int[] array2 = { 20, 10, 30 };
		int[] array3 = { 40, 40, 10 };
		long t1 = System.currentTimeMillis();
	
		// Version 1: loop over each array separately
		for (int i = 0; i < 10000000; i++){
			int sum = 0;
			for (int x = 0; x < array1.length; x++){
				sum += array1[x];
			}
			for (int x = 0; x < array2.length; x++){
				sum += array2[x];
			}
			for (int x = 0; x < array3.length; x++){
				sum += array3[x];
			}
			if (sum != 210){
				System.out.println(false);
			}
		}
		long t2 = System.currentTimeMillis();

		// Version 2: jam loops together.
		for (int i = 0; i < 10000000; i++){
			int sum = 0;
			for (int x = 0; x < array1.length; x++){
				sum += array1[x];
				sum += array2[x];
				sum += array3[x];
			}
			if (sum != 210){
				System.out.println(false);
			}
		}
		long t3 = System.currentTimeMillis();

		// ... Times.
		System.out.println("Before loop jamming---->"+(t2 - t1));
		System.out.println("After loop jamming---->"+ (t3 - t2));
	}
}