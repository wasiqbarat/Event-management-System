package Classes;

public class Admin extends Person{
    private int password;
    private int username;

    public Admin(String firstName, String lastName, String email, String phoneNumber, String address) {
        super(firstName, lastName, email, phoneNumber, address);
    }
}
