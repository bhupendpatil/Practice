import java.net.*;
import java.io.*;

class Server {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(4040, 50);
            Socket[] client = new Socket[10];

            for (int i = 0; i < client.length; i++) {
                client[i] = new Socket("localhost", 4040);
                client[i] = ss.accept();
                System.out.printf("Client %2d: " + client[i] + "%n", i);

                InputStream in = client[i].getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(isr);

                OutputStream out = client[i].getOutputStream();
                PrintWriter pw = new PrintWriter(out, true);

                InputStreamReader isr1 = new InputStreamReader(System.in);
                BufferedReader br1 = new BufferedReader(isr1);

                while (true) {
                    System.out.println("SAndroid/SIOS/SQuit");
                    String line = br1.readLine();
                    
                    if(line.equalsIgnoreCase("SAndroid")){
                        System.out.println("Sejal");
                    } else if(line.equalsIgnoreCase("SIOS")){
                        System.out.println("Anam");
                    } else if(line.equalsIgnoreCase("SQuit")){
                        System.out.println("Let's Go Home");
                        client[i].close();
                        System.exit(0);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
