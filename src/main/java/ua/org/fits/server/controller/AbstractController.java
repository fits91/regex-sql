package ua.org.fits.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.org.fits.logic.manager.AbstractManager;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractController<T,K> {
    @Autowired
    public AbstractManager<T,K> manager;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<T> get(K val) throws SQLException {
        return manager.get(val);
    }
}
