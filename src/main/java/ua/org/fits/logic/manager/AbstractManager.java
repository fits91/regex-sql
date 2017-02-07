package ua.org.fits.logic.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.org.fits.logic.dao.AbstractDao;

import java.sql.SQLException;
import java.util.List;

@Service
public abstract class AbstractManager<T,K> {

    @Autowired
    AbstractDao dao;

    public List<T> get(K val) throws SQLException {

        checkValIfNeed(val);

        List<T> entities = dao.get(val);
        entities = actionWithList(entities);

        return entities;
    }

    public abstract void checkValIfNeed(K val);
    public abstract List<T> actionWithList(List<T> entities);
}
