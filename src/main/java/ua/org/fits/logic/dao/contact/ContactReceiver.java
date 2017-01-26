package ua.org.fits.logic.dao.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.org.fits.entity.Contact;
import ua.org.fits.logic.ReceiveEntities;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContactReceiver implements ReceiveEntities<Contact, String> {

    @Autowired
    DataSource dataSource;

    public List<Contact> get(String val) throws SQLException {

    Connection conn = dataSource.getConnection();
    PreparedStatement stmt = conn.prepareStatement("INSERT INTO contacts(id, name) VALUES (?, ?)");

        for(int i=0;i<1000000; i++) {
            stmt.setInt(1, i);
            stmt.setString(2, "name"+i);
            stmt.addBatch();
        }
        stmt.executeBatch();
        stmt.close();
        conn.close();
//
//    Statement stmt = conn.createStatement();
//    ResultSet rs = stmt.executeQuery("SELECT * FROM contacts");
//    while (rs.next())
//    {
//        System.out.print(rs.getInt(0));
//        System.out.print(rs.getString(2));
//    }
//
//    rs.close();
//    stmt.close();
//    conn.close();

        List<Contact> contacts = new ArrayList<Contact>();
//        for(int i=0;i<9000000;i++) {
//            Contact contact = new Contact();
//            contact.setId(i);
//            contact.setName("name " + i);
//            contacts.add(contact);
//        }

        return Optional.ofNullable(contacts).orElse(new ArrayList<>());
    }
}
