import java.net.*;
import java.io.*;
import java.util.*;

public class Server{
	  public static void main(String[] args){
	  	try{
	  		String Quote =null;
	  		Calendar c = Calendar.getInstance();
	  		Date date = new Date();
	  		c.setTime(date);
	  		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
	  		switch(dayOfWeek){
    			case 1:
    				Quote="ITS SUNDAY";
    				break;
    			case 2:
    				Quote="ITS MONDAY";
    				break;
    			case 3: 
    				Quote="ITS TUESDAY";
	    			break;
	    		case 4:
	    			Quote="ITS WEDNESDAY";
	    			break;
	    		case 5:
	    			Quote="ITS THURSDAY";
	    			break;
	    		case 6:
	    			Quote="ITS FRIDAY";
	    			break;
	    		case 7:
	    			Quote="ITS SATURDAY";
	    			break;
	    		default:
	    			Quote="NO WEEK DAY";
	    			break;
			}

			ServerSocket sock = new ServerSocket(6017);
			while(true){
      			Socket client = sock.accept();
      			PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
      			pout.println("Quote of the day service");
      			if(Quote.length() <=512)
      				pout.println(Quote);
      			else
      				pout.println("More than 512 characters");
      			client.close();
			}
    	}
    	catch (IOException ioe){
        	System.err.println(ioe);
    	}
  	}
}