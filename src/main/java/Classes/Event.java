package Classes;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Event {
    private String name;
    private String address;
    private LocalDateTime dateAndTime;
    private int maxParticipants;
    private int minParticipants;
    private User organizer;
    private ArrayList<Participant> participants;

}
