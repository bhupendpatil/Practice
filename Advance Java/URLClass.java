import java.net.*;

class URLClass{
	public static void main(String[] args){
		try{

			URL url = new URL("https://bhupend.github.io");

			System.out.println("Protocol: " + url.getProtocol());
			System.out.println("Host: " + url.getHost());
			System.out.println("File: " + url.getFile());
			System.out.println("Port: " + url.getPort());

		} catch(Exception e){
			System.out.println(e);
		}
	}
}