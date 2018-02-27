package in.ac.iiitvadodara.cerebro.DashBoard;

/**
 * Created by harshendra on 28/2/18.
 */

public class Dashboard {

    private int eventIconId;
    private String eventName;
    private String eventNotification;

    public Dashboard(int eventiconid, String eventname, String eventnotification){
        eventIconId = eventiconid;
        eventName = eventname;
        eventNotification = eventnotification;
    }

    public int getEventIconId(){
        return eventIconId;
    }

    public String getEventName(){
        return eventName;
    }

    public String getEventNotification() {
        return eventNotification;
    }
}
