import com.api.Repository.User.UserValidation;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;
import java.util.Random;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserValidationTests {
    static String randomUsername;
    static String randomPassword;


    @BeforeClass
    public static void init() {
        randomUsername = (new Random()).nextInt() + "-dummy" + (new Random()).nextInt();
        randomPassword = String.valueOf((new Random()).nextInt() + (new Random()).nextInt());
    }

    @Test
    public void nonexistentUser() {
        try {
            Assert.assertFalse(UserValidation.userExists(randomUsername + 'd'));
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createUser() {

        try {
            UserValidation.createAccount(randomUsername, randomPassword);
            Assert.assertTrue(UserValidation.userExists(randomUsername));
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void existentUser() {
        try {
            Assert.assertTrue(UserValidation.userExists(randomUsername));
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginCorrectPassword() {
        try {
            Assert.assertTrue(UserValidation.validateAccountCredentials(randomUsername, randomPassword));
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginIncorrectPassword() {
        try {
            Assert.assertFalse(UserValidation.validateAccountCredentials(randomUsername, randomPassword + "0"));
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
