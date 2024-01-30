package Classes;

public class SignUp {
    private Database database;
    private User user;

    public SignUp(User user) {
        database = Database.getInstance();
        this.user = user;
    }


    public void SignUp() {
        database.SignUp(user);
    }


}
