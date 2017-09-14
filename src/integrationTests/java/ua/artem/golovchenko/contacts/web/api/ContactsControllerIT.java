package ua.artem.golovchenko.contacts.web.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ua.artem.golovchenko.contacts.dao.ContactRepository;
import ua.artem.golovchenko.contacts.model.Contact;
import ua.artem.golovchenko.contacts.service.ContactServiceImpl;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactsControllerIT {
    private static final Logger logger = LoggerFactory.getLogger(ContactsControllerIT.class);
    private static final String ALL_WORDS_THAT_BEGIN_WITH_LATTER_A = "^A.*$";
    private static final String BAD_REGEXP = "/\\";
    private ContactsController contactsController;

    @Autowired
    private ContactServiceImpl service;
    @Autowired
    private ContactRepository repository;

    @Before
    public void init(){
        contactsController = new ContactsController(service,repository);
    }

    @Test
    public void testServicegetFilteredContactsWithDefaultMatchesFalse() throws Exception {
        ResponseEntity responseEntity = contactsController.getFilteredContacts(ALL_WORDS_THAT_BEGIN_WITH_LATTER_A);
        List<Contact> afterFilter = (List)responseEntity.getBody();
        logger.info("filtered contacts list: {}", afterFilter);

        for(Contact contact:afterFilter){
            assertFalse(contact.getName().startsWith("A"));
        }
    }

    @Test
    public void testServicegetFilteredContactsReturnStatusOK() throws Exception {
        ResponseEntity responseEntity = contactsController.getFilteredContacts(ALL_WORDS_THAT_BEGIN_WITH_LATTER_A);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testServicegetFilteredContactsReturnInvalidRequest() throws Exception {
        ResponseEntity responseEntity = contactsController.getFilteredContacts(BAD_REGEXP);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }


}