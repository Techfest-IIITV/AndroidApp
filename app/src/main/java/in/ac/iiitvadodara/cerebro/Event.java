package in.ac.iiitvadodara.cerebro;

/**
 * Created by harshendra on 28/2/18.
 */

public class Event {

    private int eventIconId;
    private int eventImageId;
    private String eventNotification;
    private String eventName;
    private String eventStartTime;
    private  String eventEndTime;
    private int eventTeamSize;
    private String eventPrice;
    private String eventDescription;
    private int eventId;
    private int eventParticipants;
    private String eventRules;


    public Event(int eventiconid, String eventname, String eventnotification){
        eventIconId = eventiconid;
        eventName = eventname;
        eventNotification = eventnotification;
    }

    public Event(int eventimageid,String eventdescription,  String eventendtime, int id, String eventname,
                 int participants, String price, String rules, String eventstarttime, int teamsize ){
        eventImageId = eventimageid;
        eventName = eventname;
        eventDescription = eventdescription;
        eventStartTime = eventstarttime;
        eventEndTime = eventendtime;
        eventId = id;
        eventParticipants = participants;
        eventPrice = price;
        eventRules = rules;
        eventTeamSize = teamsize;
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

    public int getEventImageId(){
        return eventImageId;
    }

    public String getEventDescription(){
        return eventDescription;
    }

    public String getEventEndTime(){
        return eventEndTime;
    }

    public String getEventStartTime(){
        return eventStartTime;
    }

    public  int getEventTeamSize(){
        return eventTeamSize;
    }

    public  int getEventParticipants(){
        return eventParticipants;
    }

    public String getEventPrice(){
        return eventPrice;
    }

    public String getEventRules(){
        return eventRules;
    }

    public int getEventId(){
        return eventId;
    }

    public void setEventIconId(int eventIconId) {
        this.eventIconId = eventIconId;
    }

    public void setEventImageId(int eventImageId) {
        this.eventImageId = eventImageId;
    }

    public void setEventNotification(String eventNotification) {
        this.eventNotification = eventNotification;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public void setEventTeamSize(int eventTeamSize) {
        this.eventTeamSize = eventTeamSize;
    }

    public void setEventPrice(String eventPrice) {
        this.eventPrice = eventPrice;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setEventParticipants(int eventParticipants) {
        this.eventParticipants = eventParticipants;
    }

    public void setEventRules(String eventRules) {
        this.eventRules = eventRules;
    }
}
