package ua.artem.golovchenko.contacts.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Artem on 17.08.2017.
 *
 * @author Artem Golovchenko
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactRegExpTest {
    //private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String ALL_WORDS_THAT_BEGIN_WITH_LATTER_A = "^A.*$";
    private static final String ALL_WORDS_THAT_NOT_CONTAINS_LATTERS_aei = "^.*[aei].*$";
    private static final String CONTACTS_REGEXP = "db/data/contacts.json";

    @Autowired
    private ContactServiceImpl service;
    @Mock
    private ContactRepository repository;
    private List<Contact> contactList;
    private List<Contact> contactsList;

    @Before
    public void init(){
        contactList = DbUtilsForTest.getExpectedDbRows();
    }

    @Test
    public void testGetByRegexpWhenRegexpReturnContactsThatMatchBeginnigA() throws Exception {
        when(this.repository.findAll()).thenReturn(getContactsListForRegExpTest());
        ContactService service = new ContactServiceImpl(repository);
        List<Contact> filterdContacts = service.getByRegexp(ALL_WORDS_THAT_BEGIN_WITH_LATTER_A,true);

        List<Contact> contactsMustBe = service.findAll()
                .stream().filter(contact -> contact.getName().startsWith("A"))
                .collect(Collectors.toList());

        assertEquals(contactsMustBe, filterdContacts);
    }


    @Test
    public void testGetByRegexpWhenRegexpReturnContactsThatNotMatchBeginnigA() throws Exception {
        when(this.repository.findAll()).thenReturn(getContactsListForRegExpTest());
        ContactService service = new ContactServiceImpl(repository);
        List<Contact> filterdContacts = service.getByRegexp(ALL_WORDS_THAT_BEGIN_WITH_LATTER_A,false);

        List<Contact> contactsMustBe = service.findAll()
                .stream().filter(contact -> !(contact.getName().startsWith("A")))
                .collect(Collectors.toList());

        assertEquals(contactsMustBe, filterdContacts);
    }


    @Test
    public void testGetByRegexpWhenRegexpReturnContactsThatContainLattersAei() throws Exception {
        when(this.repository.findAll()).thenReturn(getContactsListForRegExpTest());
        ContactService service = new ContactServiceImpl(repository);
        List<Contact> filterdContacts = service.getByRegexp(ALL_WORDS_THAT_NOT_CONTAINS_LATTERS_aei,true);

        List<Contact> contactsMustBe = service.findAll()
                .stream().filter(contact -> contact.getName().contains("a")
                        || contact.getName().contains("e")
                        || contact.getName().contains("i"))
                .collect(Collectors.toList());

        assertEquals(contactsMustBe, filterdContacts);
    }

    @Test
    public void testGetByRegexpWhenRegexpReturnContactsThatNotContainLattersAei() throws Exception {
        when(this.repository.findAll()).thenReturn(getContactsListForRegExpTest());
        ContactService service = new ContactServiceImpl(repository);
        List<Contact> filterdContacts = service.getByRegexp(ALL_WORDS_THAT_NOT_CONTAINS_LATTERS_aei,false);

        List<Contact> contactsMustBe = service.findAll()
                .stream().filter(contact -> !(contact.getName().contains("a")
                        || contact.getName().contains("e")
                        || contact.getName().contains("i")))
                .collect(Collectors.toList());

        assertEquals(contactsMustBe, filterdContacts);
    }



    // ***********ADDITIONAL METHODS FOR INTERNAL USAGE************************

    /**
     *
     * @return List Returns the list of contacts that is stored in the file. Used to test regular expressions
     * @throws IOException
     */
    private List<Contact> getContactsListForRegExpTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File currFile = new File(getClass().getClassLoader().getResource(CONTACTS_REGEXP).getFile());
        List<Contact> contacts = objectMapper.readValue(currFile, new TypeReference<List<ContactImpl>>(){});
        return contacts;
    }
}
