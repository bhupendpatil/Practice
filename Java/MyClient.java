import java.io.*;
import java.net.*;

class MyClient{
	public static void main(String[] args){
		try{
			//create Socket
			Socket socket = new Socket("localhost",1233);

			//create data output stream
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());

			//write in output
			output.writeUTF("Hello World");

			//flush output
			output.flush();

			//close output
			output.close();

			//close socket
			socket.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}