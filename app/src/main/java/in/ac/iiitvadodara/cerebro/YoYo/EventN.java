package in.ac.iiitvadodara.cerebro.YoYo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neelansh on 6/3/18.
 */

public class EventN {

    private ArrayList<ContactS> contact;
    private String description;
    private String endTime;
    private int id;
    private String img;
    private String name;
    private ArrayList<Participant> participants;
    private String prices;
    private ArrayList<String> rules;
    private String startTime;
    private int teamSize;
    private String venue;

    public ArrayList<ContactS> getContact() {
        return contact;
    }

    public void setContact(ArrayList<ContactS> contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Participant> participants) {
        this.participants = participants;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public ArrayList<String> getRules() {
        return rules;
    }

    public void setRules(ArrayList<String> rules) {
        this.rules = rules;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
