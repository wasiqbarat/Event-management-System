package Classes;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private static Database database = null;
    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }


    private Database() {
        users = new ArrayList<>();
        defaultEvents = new ArrayList<>();
        admins = new ArrayList<>();
        events = new ArrayList<>();
        userArrayListHashMap = new HashMap<>();
    }

    private ArrayList<Admin> admins;
    private ArrayList<Event> defaultEvents;
    private ArrayList<User> users;
    private ArrayList<Event> events;
    private HashMap<User, ArrayList<Event>> userArrayListHashMap;
    private int numberOfAdmins;
    private int numberOfParticipants;
    private int numberOfUsers;

    public boolean log(Boolean auth) {
        return false;
    }

    public void AddEvent(String username, Event event) {
        User user = null;
        for (User user1: users) {
            if (user1.getUserName().equals(username)) {
                user = user1;
                break;
            }
        }

        if (user == null) {
            throw new RuntimeException("Invalid user. system not working correctly");
        }

        ArrayList<Event> userEvents;
        if (userArrayListHashMap.containsKey(user)) {
            userEvents = userArrayListHashMap.get(user);
        }else {
            userEvents = new ArrayList<>();
        }
        userEvents.add(event);

        System.out.println("Usernev");
        System.out.println(userEvents);
        userArrayListHashMap.put(user, userEvents);
        System.out.println("User:n");
        System.out.println(user);
    }

    public void SignUp(User user) {
        if (users.contains(user)) {
            throw new RuntimeException("User already exists");
        }

        users.add(user);
    }

    public boolean logIn(String username, String password) {
        for (User user : users) {
            String password1 = String.valueOf(user.getPassword());
            if (user.getUserName().equals(username) && password1.equals(password)) {
                return true;
            }
        }

        return false;
    }

    public void requestEventDetail(String userName) {
        ArrayList<Event> userEvents;
        User user = null;
        for (User user1: users) {
            if (user1.getUserName().equals(userName)) {
                user = user1;
                break;
            }
        }

        if (user == null) {
            throw new RuntimeException("Invalid user or events");
        }




        userEvents = userArrayListHashMap.get(user);

        System.out.println(userEvents);
    }

}
