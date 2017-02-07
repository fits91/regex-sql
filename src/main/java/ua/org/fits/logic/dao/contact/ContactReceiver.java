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

@Repository
public class ContactReceiver implements ReceiveEntities<Contact, String> {

    @Autowired
    DataSource dataSource;

    public List<Contact> get(String val) throws SQLException {
        List<Contact> contacts = new ArrayList<>();
        Contact contact;

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();

            stmt = conn.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY, java.sql.ResultSet.CONCUR_READ_ONLY);
            stmt.setFetchSize(100); // set batch size

            rs = stmt.executeQuery("SELECT * FROM contacts");

            while (rs.next())
            {
                contact = new Contact();
                contact.setName(rs.getString(2));
                contact.setId(rs.getInt(1));
                contacts.add(contact);
            }

        } finally {
            rs.close();
            stmt.close();
            conn.close();
        }


        return contacts;
    }
}
