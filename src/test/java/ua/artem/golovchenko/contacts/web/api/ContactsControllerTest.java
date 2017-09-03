package ua.artem.golovchenko.contacts.web.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ua.artem.golovchenko.contacts.DbUtilsForTest;
import ua.artem.golovchenko.contacts.dao.ContactRepository;
import ua.artem.golovchenko.contacts.model.Contact;
import ua.artem.golovchenko.contacts.model.ContactImpl;
import ua.artem.golovchenko.contacts.service.ContactServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactsControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(ContactsControllerTest.class);
    private static final String ALL_WORDS_THAT_BEGIN_WITH_LATTER_A = "^A.*$";
    private ContactsController contactsController;

    @Autowired
    private ContactServiceImpl service;
    @Mock
    private ContactRepository repository;

    @Before
    public void init(){
        contactsController = new ContactsController(service,repository);
    }

    @Test
    public void testServicegetFilteredContactsWithDefaultMatchesFalse() throws Exception {
        given(this.repository.findAll()).willReturn(DbUtilsForTest.getExpectedDbRows());
        List<Contact> excludedContacts = Arrays.asList(new ContactImpl(1L, "Artem"));
        String matches = "false";

        ResponseEntity responseEntity = contactsController.getFilteredContacts(ALL_WORDS_THAT_BEGIN_WITH_LATTER_A, matches);
        List<Contact> afterFilter = (List)responseEntity.getBody();
        logger.info("filtered contacts list: {}", afterFilter);

        assertTrue(responseEntity.getStatusCode().equals(HttpStatus.OK));
        assertFalse(afterFilter.containsAll(excludedContacts));
    }
}