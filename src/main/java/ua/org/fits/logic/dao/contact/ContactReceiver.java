package ua.org.fits.logic.dao.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.org.fits.entity.Contact;
import ua.org.fits.logic.ReceiveEntities;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContactReceiver implements ReceiveEntities<Contact, String> {

    @Autowired
    DataSource dataSource;

    public List<Contact> get(String val) throws SQLException {
        List<Contact> contacts = new ArrayList<>();
        Contact contact;

        Connection conn = dataSource.getConnection();

        Statement stmt = conn.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY, java.sql.ResultSet.CONCUR_READ_ONLY);
        stmt.setFetchSize(100); // set batch size

        ResultSet rs = stmt.executeQuery("SELECT * FROM contacts");

        while (rs.next())
        {
            if(!rs.getString(2).matches(val)) {
                contact = new Contact();
                contact.setName(rs.getString(2));
                contact.setId(rs.getInt(1));
                contacts.add(contact);
            }
        }

        rs.close();
        stmt.close();
        conn.close();

        return Optional.ofNullable(contacts).orElse(new ArrayList<>());
    }
}
