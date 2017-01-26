package ua.org.fits.logic.dao.contact;

import org.springframework.stereotype.Repository;
import ua.org.fits.entity.Contact;
import ua.org.fits.logic.ReceiveEntities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContactReceiver implements ReceiveEntities<Contact, String> {
    public List<Contact> get(String val) {
        List<Contact> contacts = new ArrayList<Contact>();
        for(int i=0;i<9000000;i++) {
            Contact contact = new Contact();
            contact.setId(i);
            contact.setName("name " + i);
            contacts.add(contact);
        }

        return Optional.ofNullable(contacts).orElse(new ArrayList<>());
    }
}
