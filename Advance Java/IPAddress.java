import java.net.*;

public class IPAddress {
    public static void main(String args[]){
        try{
           InetAddress addr = InetAddress.getByName("sBhupends-PC"); //Enter your computers name :]
           System.out.println(addr);
        }
        catch(UnknownHostException e){
            System.out.println(e);
            System.out.println("Could not find the site");
        }
    }
}
