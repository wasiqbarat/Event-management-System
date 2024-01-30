package Classes;

public class LogIn {
    private String password;
    private String username;
    private int temporaryCode;//Bad design... (temporary code should be in signup). Lack of time for making it correct
    private Database database;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTemporaryCode() {
        return temporaryCode;
    }

    public void setTemporaryCode(int temporaryCode) {
        this.temporaryCode = temporaryCode;
    }

    public boolean log() {
        database = Database.getInstance();
        if (!(temporaryCode == 1234)) {
            throw new RuntimeException("Invalid code");
        }

        return database.logIn(username, password);
    }
}
