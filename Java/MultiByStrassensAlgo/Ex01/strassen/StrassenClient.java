package Ex01.strassen;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

class StrassenClient {
	public static void main(String argv[ ]) throws Exception {
		long start,finish, difference;
		if (argv.length < 1) {
			System.out.println("Usage: java StrassenClient \"N,matrix elements separated by ,\"");
			System.exit(1);
		}
		String strMsg = argv[0];
		URL url = new URL("http://localhost:9876/strassen?wsdl");
		// Qualified name of the service:
		// 1st arg is the service URI
		// 2nd is the service name published in the WSDL
		QName qname = new QName("http://strassen.Ex01/", "StrassenServerImplService");
		Service service = Service.create(url, qname);
		// Extract the endpoint interface, the service "port".
		StrassenServer eif = service.getPort(StrassenServer.class);
		start=System.currentTimeMillis();
		String sreq=eif.StrassenMessage(strMsg);
		finish=System.currentTimeMillis();
		sreq=sreq+",";
		int idx = sreq.indexOf(",");
		int N = Integer.parseInt(sreq.substring(0,idx));
		int t=0;
		int[][] C = new int[N][N];
		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++){
				int from = sreq.indexOf(',',t);
				int to = sreq.indexOf(',', from+1);
				C[i][j] = Integer.parseInt(sreq.substring(from+1,to));
				t=to;
			}
		}
		System.out.println("\nMatrix Multiplication is ...\n");
		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++)
				System.out.print(C[i][j] + " ");
			System.out.println();
		}
		difference=finish-start;
		System.out.println("Time required for matrix multiplication (Using Strassen algorithm) :");
		System.out.println(difference + " milli seconds");
	}
}