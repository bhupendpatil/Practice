import java.net.*;
import java.io.*;

public class ConnectionThread implements Runnable {
	private Socket socket;
	private HashMap nameDatabase;
	private InputStream is;
	private OutputStream os;
	private PrintWrite toClient;
	private BufferReader fromClient;

	static final String CLIENT_QUITTING = "Exit";
	static final String USER_NOT_FOUND = "User not known";

	public ConnectionThread(Socket socket, HashMap nameDatabase){
		socker = socket;
		nameDatabase = nameDatabase;

		public void run(){
			try{
				openStream();
				processClientRequest();

				closeStream();
				socket.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
}

public class ThreadNameServer {
	private HashMap nameDatabase;
	private Thread connection;

	static final int PORT_NUMBER = 3000;

	public ThreadNameServer(){
		System.out.println("Name server starting up");
		nameDatabase = seUpNameDatabase();
	}

	private HashMap<String,String> setUpNameDatabase(){
		HashMap<String,String> db = new HashMap<String,String>;

		db.put("ABC","CBA","abc@gmail.com");
		db.put("DEF","FED","def@gmail.com");

		return db;
	}

	public void run(){
		try{
			SocketServer ss = new SocketServer(PORT_NUMBER);

			while(true){
				Socket socket = ss.accept();
				connection = new Thread(new ConnectionThread(socket,nameDatabase));
				connection.start();
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}

class ServingMultipleClients{
	public static void main(String[] args) {
		ThreadNameServer server1 = mew ThreadNameServer();
		server1.run();
	}
}