import javax.jws.*;

@WebService(serviceName="Factorial1")
public class Factorial1 {
	@WebMethod(oprationName="Factt"))
	public int factorial1(@WebParam(name="num") int num){
		int i,f=1;
            
        for(i=1;i<=num;i++){
           f = f*i;
		}
		return f;
	}
}