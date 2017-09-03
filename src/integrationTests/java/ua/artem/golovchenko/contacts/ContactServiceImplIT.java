package ua.artem.golovchenko.contacts;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.artem.golovchenko.contacts.dao.ContactRepository;
import ua.artem.golovchenko.contacts.service.ContactService;
import ua.artem.golovchenko.contacts.service.ContactServiceImpl;

import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;

/**
 * Created by Artem on 03.09.2017.
 *
 * @author Artem Golovchenko
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactServiceImplIT {

    //@Autowired
    private ContactService service;

    @Mock
    private ContactRepository repository;

    @Before
    public void init(){
        service = new ContactServiceImpl(repository);
    }

    @Ignore
    @Test
    public void testServiceFindAllMustOnlyOnceCallRepositoryFindAll() throws Exception {
        service.findAll();
        service.findAll();

        verify(repository, atMost(1)).findAll();
    }
}
