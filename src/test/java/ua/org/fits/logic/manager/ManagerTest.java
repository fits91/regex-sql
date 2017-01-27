package ua.org.fits.logic.manager;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.org.fits.entity.Contact;
import ua.org.fits.logic.manager.contact.ContactManager;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
//@ContextConfiguration(classes = {TestConfig.class})

public class ManagerTest {
    @Autowired
    ContactManager manager;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void findContactTest() throws SQLException {
        List<Contact> contacts = manager.get("^.*[1-5]+$");
        assertEquals(1, contacts.size());
    }

    @Test
    public void IllegalArgumentExceptionTest() throws SQLException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("request param is missed or empty");
        manager.get("");
    }

    @Test
    public void PatternSyntaxExceptionTest() throws SQLException {
        thrown.expect(PatternSyntaxException.class);
        manager.get("{{{");
    }
}
