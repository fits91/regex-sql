package ua.org.fits.logic.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.org.fits.logic.dao.AbstractDao;

import java.util.List;

@Service
public abstract class AbstractManager<T,K> {

    @Autowired
    AbstractDao dao;

    public List<T> get(K val) {
        return dao.get(val);
    }
}
