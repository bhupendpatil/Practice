import javax.jws.*;

@WebService(serviceName="Reverse")
public class Reverse {
	@WebMethod(operationName="integerR")
	public int integerR(@WebParam(name="a") int a){
		String b = a.toString();
		String c = new StringBuffer(b).reverse().toString();
		int d = Integer.parseInt(c);
		return c;
	}
}