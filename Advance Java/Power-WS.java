import javax.jws.*;

@WebService(serviceName="Power")
public class Power{
	@WebMethod(operationName="powering")
	public int powering(@WebParam(name="m") int m,@WebParam(name="n") int n){
		int ans = m**n;
		return ans;
	}
}