import java.io.*;
import java.net.*;

class MyServer{
	public static void main(String[] args){
		try{
			//create serversocket
			ServerSocket serversocket = new ServerSocket(1233);

			//establish a connection
			Socket socket = serversocket.accept();

			//create data input stream
			DataInputStream input = new DataInputStream(socket.getInputStream());

			//read from the stream
			String st = (String)input.readUTF();

			//output
			System.out.println("Message: "+st);

			//close
			serversocket.close();

		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}