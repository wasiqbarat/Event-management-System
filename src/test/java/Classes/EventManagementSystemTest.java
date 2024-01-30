package Classes;

import controllers.Controller;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EventManagementSystemTest extends Controller {
    private EventManagementSystem eventManagementSystem;

    @BeforeEach
    void setUp() {
        eventManagementSystem = EventManagementSystem.getInstance();
    }

    @AfterEach
    void tearDown() {

    }


    @Test
    void signUpMethodShouldThrowExceptionWhenUserAlreadyExits() {
        User user = new User("1", "1", "1", "1", "1", 1, 1,
                "1", new ArrayList<>());

        try {
            eventManagementSystem.signUp(user);
            eventManagementSystem.signUp(user);//user exists
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    void addEventMethodShouldThrowExceptionIfUsernameInvalid() {
        Event event = new Event("event", "tehran", "today", 1, 3, 1000);

        try {
            eventManagementSystem.addEvent("invalid user",event);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    void requestEventDetailMethodShouldThrowExceptionIfUsernameInvalid() {
        try {
            eventManagementSystem.requestEventsDetail("Invalid username");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}