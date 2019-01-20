import javax.jws.*;

@WebService(serviceName="Factorial")
public class Factorial {
	@WebMethod(oprationName="Factt"))
	public int factorial1(@WebParam(name="num") int num){
		int i,j,fact,sum=0;
		for(i=1;i<=num;i++){
			fact=1;
			for(j=1;j<=1;j++)
				fact=fact*j;
			sum=sum+fact;

		return sum;
		}
	}
}