package Classes;

import java.util.ArrayList;

public class User extends Person {
    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", password=" + password +
                ", userName='" + userName + '\'' +
                ", events=" + events +
                '}';
    }

    private int ID;
    private int password;
    private String userName;
    private ArrayList<Event> events;

    public User(String firstName, String lastName, String email, String phoneNumber, String address,
                int ID, int password, String userName, ArrayList<Event> events) {


        super(firstName, lastName, email, phoneNumber, address);
        this.ID = ID;
        this.password = password;
        this.userName = userName;
        this.events = events;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}
