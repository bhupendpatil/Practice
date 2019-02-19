package mypackage;

import java.util.Date;
import javax.jws.WebService;

@WebService(endpointInterface = "mypackage.TimeServer")

public class TimeServerImpl implements TimeServer {
    public String getTimeAsString(){
        return new Date().toString();
    }
    public long getTimeAsElapsed() {
        return new Date().getTime();
    }
}
