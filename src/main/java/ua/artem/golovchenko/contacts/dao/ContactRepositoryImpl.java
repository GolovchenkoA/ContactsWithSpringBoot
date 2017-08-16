package ua.artem.golovchenko.contacts.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.artem.golovchenko.contacts.model.Contact;
import ua.artem.golovchenko.contacts.model.ContactImpl;

import java.util.List;

/**
 * Created by Artem on 16.08.2017.
 *
 * @author Artem Golovchenko
 */

@Component
public class ContactRepositoryImpl implements ContactRepository {
    private static final Logger logger = LoggerFactory.getLogger(ContactRepositoryImpl.class);
    private static final String FIND_ALL_CONTACTS = "SELECT id, name FROM contacts;";
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    ContactRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

/*    @Override
    public List<Contact> getByRegexp(String regexp, Boolean match) {


        jdbcTemplate.query(
                "SELECT id, name FROM contacts WHERE name = ?", new Object[] { regexp },
                (rs, rowNum) -> new ContactImpl((long)rs.getLong("id"), rs.getString("name"))
        ).forEach(customer -> logger.info(customer.toString()));

        logger.info("Call method findAll() Result: {}", contacts);

        return null;
    }*/

    @Override
    public List<Contact> findAll() {
        List<Contact> contacts  = jdbcTemplate.query(FIND_ALL_CONTACTS,
                new BeanPropertyRowMapper(ContactImpl.class));

        logger.info("Call method findAll() Result: {}", contacts);
        return contacts;
    }
}
