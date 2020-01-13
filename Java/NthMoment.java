import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

class NthMoment {
	public static void main(String args[]) {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter Stream of Data: ");
		String data = s.nextLine();
		
		System.out.println("Enter which moment to calculate: ");
		int moment = s.nextInt();
	
		System.out.println("Entered data is:"+data+" and moment:"+moment);	

		int n = calculateMoment(data, moment);
		System.out.println("Calculated moment is "+n);
		
	}

	public static int calculateMoment(String data, int moment) {
		char str[] = data.toCharArray();
		Arrays.sort(str);		
		
		ArrayList<BigInteger> datacounts = new ArrayList<BigInteger>();
	
		int finalMoment=0,count=1;
		for(int i=1;i<str.length;i++) {
			if(str[i]==str[i-1]) {
				count++;
			}
			else {
				datacounts.add(new BigInteger(""+count));
				count=1;
			}
		}

		datacounts.add(new BigInteger(""+count));

		for(int i = 0;i<datacounts.size();i++) {
			finalMoment = finalMoment + datacounts.get(i).pow(moment).intValue();	
		}
		return finalMoment;
	
	} 
}

// Output
// abcbdacdabdcaab
// 0