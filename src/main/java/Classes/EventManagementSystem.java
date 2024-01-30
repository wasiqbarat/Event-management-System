package Classes;

public class EventManagementSystem {
    private static EventManagementSystem eventManagementSystem = null;

    public static EventManagementSystem getInstance() {
        if (eventManagementSystem == null) {
            eventManagementSystem = new EventManagementSystem();
        }
        return eventManagementSystem;
    }

    private EventManagementSystem() {
        name = "Easy Event Management System";
        database = Database.getInstance();
    }


    private String name;
    private Database database;


    public void signUp(User user) {
        SignUp signUp = new SignUp(user);
        signUp.SignUp();
    }

    public int getNumberOfUsers() {

        return 0;
    }


    public boolean logIn(String usernameString, String passwordString, int i) {
        LogIn logIn = new LogIn();
        logIn.setUsername(usernameString);
        logIn.setPassword(passwordString);
        logIn.setTemporaryCode(i);

        return logIn.log();
    }

    public void addEvent(String username, Event event) {
        database.AddEvent(username, event);
    }


    public void requestEventsDetail(String currentUserName) {
        database.requestEventDetail(currentUserName);
    }
}
