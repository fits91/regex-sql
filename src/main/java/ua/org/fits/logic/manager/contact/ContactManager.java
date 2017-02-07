package ua.org.fits.logic.manager.contact;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ua.org.fits.entity.Contact;
import ua.org.fits.logic.manager.AbstractManager;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ContactManager extends AbstractManager<Contact, String>{

    /**
     * regex was sent in query
     */
    private String regex;

    /**
     * check if is val regex
     * init {@link ContactManager#regex} by val
     * @param val input regex
     */
    @Override
    public void checkValIfNeed(String val) {

        if(isEmptyParam(val)) {
            throw new IllegalArgumentException("request param is missed or empty");
        }

        Pattern.compile(val);
        regex = val;
    }

    /**
     *
     * @param entities contacts from db
     * @return filtered entities by {@link Contact#ifNameMatchWithRegex} method
     */
    @Override
    public List<Contact> actionWithList(List<Contact> entities) {
        return entities.stream()
               .filter(contact -> !contact.ifNameMatchWithRegex(regex))
               .collect(Collectors.toList());
    }

    public boolean isEmptyParam(String val) {
        return StringUtils.isEmpty(val);
    }
}
