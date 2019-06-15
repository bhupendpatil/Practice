package Ex01.strassen;

import javax.xml.ws.Endpoint;

public class StrassenServerPublisher {
	public static void main(String[ ] args) {
	// 1st argument is the publicaNon URL
	// 2nd argument is an SIB instance
		Endpoint.publish("http://localhost:9876/strassen", new StrassenServerImpl());
	}
}