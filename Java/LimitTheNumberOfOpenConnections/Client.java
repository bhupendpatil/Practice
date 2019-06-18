import java.net.*;
import java.io.*;

class Client {

    public static void main(String args[]) {
        try {
            Socket s = new Socket("localhost", 4040);

            InputStream in = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
 
            OutputStream out = s.getOutputStream();
            PrintWriter pw = new PrintWriter(out, true);

            InputStreamReader isr1 = new InputStreamReader(System.in);
            BufferedReader br1 = new BufferedReader(isr1);

              while (true) {
                    System.out.println("CAndroid/CIOS/CQuit");
                    String line = br1.readLine();
                    
                    if(line.equalsIgnoreCase("CAndroid")){
                        System.out.println("Sejal");
                    } else if(line.equalsIgnoreCase("CIOS")){
                        System.out.println("Anam");
                    } else if(line.equalsIgnoreCase("CQuit")){
                        System.out.println("Let's Go Home");
                        System.exit(0);
                    }
               }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
