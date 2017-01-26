package ua.org.fits.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.org.fits.logic.dao.AbstractDao;

import java.util.List;

public abstract class AbstractController<T,K> {
    @Autowired
    AbstractDao<T,K> dao;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    List<T> get(@RequestParam(name = "nameFilter", required = false) K val) {
        return dao.get(val);
    }
}
