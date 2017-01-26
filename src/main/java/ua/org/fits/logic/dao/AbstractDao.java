package ua.org.fits.logic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.org.fits.logic.ReceiveEntities;

import java.sql.SQLException;
import java.util.List;

@Repository
public abstract class AbstractDao<T,K> {
    @Autowired
    ReceiveEntities<T,K> receiverEntities;

    public List<T> get(K val) throws SQLException {
        return receiverEntities.get(val);
    }

}
