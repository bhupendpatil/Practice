import javax.jws.*;

@WebService(serviceName="Palindrome")
public class Palindrome {
	@WebMethod(operationName="integerR")
	public void integerR(@WebParam(name="a") int a){
		String b = a.toString();
		String c = new StringBuffer(b).reverse().toString();
		int d = Integer.parseInt(c);

		if(a==d){
			return true;
		} else{
			return false;
		}
	}
}