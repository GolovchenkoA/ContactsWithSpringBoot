package ua.artem.golovchenko.contacts.web.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.artem.golovchenko.contacts.DbUtilsForTest;
import ua.artem.golovchenko.contacts.dao.ContactRepository;
import ua.artem.golovchenko.contacts.model.Contact;
import ua.artem.golovchenko.contacts.model.ContactImpl;
import ua.artem.golovchenko.contacts.service.ContactServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactsControllerTest {
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
    public void testServiceFindAllMustReturnContactsAsRepositoryFindAll() throws Exception {
        given(this.repository.findAll()).willReturn(DbUtilsForTest.getExpectedDbRows());
        List<Contact> excludedContacts = Arrays.asList(new ContactImpl(1L, "Artem"));

        List<Contact> afterFilter = (List)contactsController.getFilteredContacts(ALL_WORDS_THAT_BEGIN_WITH_LATTER_A, "false");
        assertFalse(afterFilter.containsAll(excludedContacts));
    }

}