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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactsControllerIT {
    private static final Logger logger = LoggerFactory.getLogger(ContactsControllerTest.class);
    private static final String ALL_WORDS_THAT_BEGIN_WITH_LATTER_A = "^A.*$";
    private ContactsController contactsController;
    private String matches;

    @Autowired
    private ContactServiceImpl service;
    @Autowired
    private ContactRepository repository;

    @Before
    public void init(){
        contactsController = new ContactsController(service,repository);
        matches = "false";
    }

    @Test
    public void testServicegetFilteredContactsWithDefaultMatchesFalse() throws Exception {
        ResponseEntity responseEntity = contactsController.getFilteredContacts(ALL_WORDS_THAT_BEGIN_WITH_LATTER_A, this.matches);
        List<Contact> afterFilter = (List)responseEntity.getBody();
        logger.info("filtered contacts list: {}", afterFilter);

        //assertFalse(afterFilter.containsAll(excludedContacts));
        for(Contact contact:afterFilter){
            assertFalse(contact.getName().startsWith("A"));
        }
    }

    @Test
    public void testServicegetFilteredContactsReturnStatusOK() throws Exception {
        ResponseEntity responseEntity = contactsController.getFilteredContacts(ALL_WORDS_THAT_BEGIN_WITH_LATTER_A, this.matches);

        assertTrue(responseEntity.getStatusCode().equals(HttpStatus.OK));
    }
}