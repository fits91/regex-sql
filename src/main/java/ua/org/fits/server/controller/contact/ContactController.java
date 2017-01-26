package ua.org.fits.server.controller.contact;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.org.fits.entity.Contact;
import ua.org.fits.server.controller.AbstractController;

@RestController
@RequestMapping("/contact")
public class ContactController extends AbstractController<Contact, String>{
}
