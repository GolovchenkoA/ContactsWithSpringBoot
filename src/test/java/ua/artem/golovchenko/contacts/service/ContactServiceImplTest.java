package ua.artem.golovchenko.contacts.service;

/*@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration( classes=Application.class)*/

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContactRegExpTest.class,
        ContactServiceMainTest.class

})

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class ContactServiceImplTest {
/*    //private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String ALL_WORDS_THAT_BEGIN_WITH_LATTER_A = "^A.*$";
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
    public void testGetByRegexpWhenRegexpReturnContactsThatMatch() throws Exception {
        when(this.repository.findAll()).thenReturn(getContactsListForRegExpTest());
        ContactService service = new ContactServiceImpl(repository);
        List<Contact> filterdContacts = service.getByRegexp(ALL_WORDS_THAT_BEGIN_WITH_LATTER_A,true);
        List<Contact> contactsMustBe = contactsBeginWithLatterA();
        assertEquals(contactsMustBe, filterdContacts);
    }

    @Test
    public void testServiceFindAllMustReturnContactsAsRepositoryFindAll() throws Exception {
        given(this.repository.findAll()).willReturn(DbUtilsForTest.getExpectedDbRows());
        assertEquals(repository.findAll(),service.findAll());
    }

    @Ignore
    @Test
    public void testFindAllWithoutMock() throws Exception {

        List<Contact> actualContacts = service.findAll();
        assertEquals(contactList.size(), actualContacts.size());

        //assertEquals(Arrays.asList(expectedContacts), Arrays.asList(contactsInDB));
        assertEquals(contactList.get(1), actualContacts.get(1));
        int i = 0;
        for(Object row: actualContacts){
            System.out.println(contactList.get(i) +" " + (Contact)row);
            assertEquals(contactList.get(i++), (ContactImpl)row);
        }


    }


    // ***********ADDITIONAL METHODS FOR INTERNAL USAGE************************
    private List<Contact> getContactsListForRegExpTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File currFile = new File(getClass().getClassLoader().getResource(CONTACTS_REGEXP).getFile());
        List<Contact> contacts = objectMapper.readValue(currFile, new TypeReference<List<ContactImpl>>(){});
        return contacts;
    }

    private List<Contact> contactsBeginWithLatterA() {
        return new ArrayList<>(Arrays.asList(new ContactImpl(1L, "Artem"), new ContactImpl(5L, "Anton")));
    }*/
}