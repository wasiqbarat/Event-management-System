package Tests;

import Classes.LogIn;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class logInTest {
    LogIn logIn = null;

    @BeforeEach
    void setUp() {
        logIn = new LogIn();
    }

    @Test
    void logMethodShouldThrowExceptionWhenLoginCodeNotMatched() {
        logIn.setTemporaryCode(1111); // note that our default temporary login code for this system in 1234

        try {
            logIn.log();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testForInvalidUserName() {


    }

    @AfterEach
    void tearDown() {

    }

}