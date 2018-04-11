import javax.jws.*;

@WebService(serviceName="Sum")
pubic class Sum{
	@WebMethod(operationName="Add")
	public int Add(@WebParam(name="a") int a){
		int b = 0;
		for(int i=0;i<=a;i++){
			b = 1 + b;
		}
		return b;
	}
}