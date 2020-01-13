import java.util.*;

class AMS {
	public static void main(String args[]) {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter Stream of Data: ");
		String data = s.nextLine();
		
		System.out.println("Enter how many positions to check: ");
		int nPos = s.nextInt();
		int pos[]=new int[nPos];
		for(int i=0;i<nPos;i++) {
			System.out.print("Enter Position No "+(i+1)+": ");	
			pos[i] = s.nextInt();
		}

		float n = calculateAMS(data, nPos, pos);
		System.out.println("Estimated moment is "+n);
		
	} 

	public static float calculateAMS(String data, int n, int pos[]) {
		
		int values[]=new int[n];
		char str[] = data.toCharArray();
		int count=0;
		float estimate=0;
		for(int i=0;i<n;i++) {
			char element = str[pos[i]];
			for(int j=pos[i];j<str.length;j++) {
				if(element==str[j])
					count++;
			}				
			values[i]=count;
			count=0;
			estimate = estimate + (data.length() * (2 * values[i] - 1));	
		}
		
		return estimate/n;
		
	}
}

// Output
// abcbdacdabdcaab
// 3
// 3
// 8
// 13