package ua.org.fits.server.controller.contact;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.org.fits.entity.Contact;
import ua.org.fits.server.controller.AbstractController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController extends AbstractController<Contact, String>{
    @Override
    public List<Contact> get(@RequestParam(name = "nameFilter") String val) throws SQLException {
        return super.get(val);
    }
}
