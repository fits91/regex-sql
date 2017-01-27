package ua.org.fits.logic.manager.contact;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ua.org.fits.entity.Contact;
import ua.org.fits.logic.manager.AbstractManager;

import java.util.regex.Pattern;

@Service
public class ContactManager extends AbstractManager<Contact, String>{
    @Override
    public void checkVal(String val) {

        if(isEmptyParam(val)) {
            throw new IllegalArgumentException("request param is missed or empty");
        }

        Pattern.compile(val);
    }

    public boolean isEmptyParam(String val) {
        return StringUtils.isEmpty(val);
    }
}
