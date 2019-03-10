import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Socket socket;
 
    public static void main(String[] args){
        try{
            int port = 6102;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port 6102");

            while(true){
                socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String msg = br.readLine();
                System.out.println("Message received from client is "+msg);

                String returnMessage="";
                try{
                    int d=0;int v=0;
                    for(int i=0;i<msg.length();++i){
                        char k=msg.charAt(i);

                        if(k>='0' && k<='9')
                            d++;
                        else
                            if(k =='a' || k=='e' || k=='i'|| k=='o' || k=='u')
                                v++;
                    }
                    String ans="No.of characters = "+ msg.length() +"; No. of vovels = "+v+"; No.of digits= "+d;
                    returnMessage = String.valueOf(ans) + "\n";
                } catch(Exception e) {}

                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println("Message sent to the client is "+returnMessage);
                bw.flush();
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch(Exception e){}
        }
    }
}