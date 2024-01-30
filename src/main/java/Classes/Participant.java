package Classes;

import java.util.ArrayList;

public class Participant extends User{


    public Participant(String firstName, String lastName, String email, String phoneNumber, String address, int ID, int password, String userName, ArrayList<Event> events) {
        super(firstName, lastName, email, phoneNumber, address, ID, password, userName, events);
    }
}
