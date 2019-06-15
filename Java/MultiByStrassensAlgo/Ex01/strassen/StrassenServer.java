package Ex01.strassen;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)

public interface StrassenServer {
	@WebMethod
	String StrassenMessage(String strMsg);
}