import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressUsingLH {
    public static void main(String args[]){
        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("Address of local host is: "+addr);
        } catch(UnknownHostException e){
            System.out.println(e);
            System.out.println("Could not find the address for this computer");
        }
    }
}
