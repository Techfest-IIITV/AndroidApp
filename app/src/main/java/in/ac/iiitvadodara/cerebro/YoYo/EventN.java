package in.ac.iiitvadodara.cerebro.YoYo;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by neelansh on 6/3/18.
 */

public class EventN implements Parcelable{

    private ArrayList<HashMap<String, String>> contact;
    private String description;
    private String endTime;
    private int id;
    private int type;
    private String img;
    private String name;
    private HashMap<String, HashMap<String, String>> participants;
    private String prices;
    private ArrayList<String> rules;
    private String startTime;
    private int teamSize;
    private String venue;


    protected EventN(Parcel in) {
        description = in.readString();
        endTime = in.readString();
        id = in.readInt();
        type = in.readInt();
        img = in.readString();
        name = in.readString();
        prices = in.readString();
        rules = in.createStringArrayList();
        startTime = in.readString();
        teamSize = in.readInt();
        venue = in.readString();
        ArrayList<String> contactNumber = in.createStringArrayList();
        ArrayList<String> contactName = in.createStringArrayList();
    }

    public EventN() {
    }

    public static final Creator<EventN> CREATOR = new Creator<EventN>() {
        @Override
        public EventN createFromParcel(Parcel in) {
            return new EventN(in);
        }

        @Override
        public EventN[] newArray(int size) {
            return new EventN[size];
        }
    };

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<HashMap<String, String>> getContact() {
        return contact;
    }

    public void setContact(ArrayList<HashMap<String, String>> contact) {
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

    public HashMap<String, HashMap<String, String>> getParticipants() {
        return participants;
    }

    public void setParticipants(HashMap<String, HashMap<String, String>> participants) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(endTime);
        dest.writeInt(id);
        dest.writeInt(type);
        dest.writeString(img);
        dest.writeString(name);
        dest.writeString(prices);
        dest.writeStringList(rules);
        dest.writeString(startTime);
        dest.writeInt(teamSize);
        dest.writeString(venue);

        ArrayList<String> contactNumber = new ArrayList<>();
        ArrayList<String> contactName = new ArrayList<>();

        for(HashMap<String, String> i : contact){
            contactName.add(i.get("name"));
            contactNumber.add(i.get("number"));
        }
        dest.writeStringList(contactName);
        dest.writeStringList(contactNumber);
    }
}
