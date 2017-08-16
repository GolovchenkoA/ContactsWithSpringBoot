package ua.artem.golovchenko.contacts.utils;

import org.springframework.jdbc.core.RowMapper;
import ua.artem.golovchenko.contacts.model.Contact;
import ua.artem.golovchenko.contacts.model.ContactImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Artem on 16.08.2017.
 *
 * @author Artem Golovchenko
 */
public class ContactRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact Contact = new ContactImpl();
        Contact.setId((long)rs.getInt("id"));
        Contact.setName(rs.getString("name"));
        return Contact;
    }
}
