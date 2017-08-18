package ua.artem.golovchenko.contacts.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Artem on 18.08.2017.
 *
 * @author Artem Golovchenko
 */
@Component
public class DataManager {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static ContactRepository repository;

    @Autowired
    public DataManager(ContactRepository repository) {
        logger.debug("Class constructor call");
        this.repository = repository;
    }


    public static ContactRepository getRepository() {
        return repository;
    }
}
