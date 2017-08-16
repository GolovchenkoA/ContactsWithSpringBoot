package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Artem on 15.08.2017.
 *
 * @author Artem Golovchenko
 */
@RestController
@RequestMapping("/contacts")
public class ContactsController {
    private static final Logger logger = LoggerFactory.getLogger(ContactsController.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    ContactsController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping(value = "/filter",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus getContactWithFilter(@RequestParam(value="nameFilter") String filter){

        logger.info("Method call getContacts with param : {}", filter);
        //return new ResponseEntity<Collection<Contact>>(contacts, HttpStatus.OK);
        jdbcTemplate.query(
                "SELECT id, name FROM contacts WHERE name = ?", new Object[] { filter },
                (rs, rowNum) -> new Contact(rs.getLong("id"), rs.getString("name"))
        ).forEach(customer -> logger.info(customer.toString()));
        return HttpStatus.OK;
    }

/*    @RequestMapping(value = "/hello/contactsAll",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Contact>> getContacts(){
        Collection<Contact> contacts = service.getAll();
        return new ResponseEntity<Collection<Contact>>(contacts, HttpStatus.OK);
    }*/
}
