import javax.jws.*;

@WebService(serviceName="StringLength")
public class StringLength {
	@WebMethod(operationName="length")
	public int length(@WebParam(name="a") String a){
		int b = a.length();
		return b;
	}
}