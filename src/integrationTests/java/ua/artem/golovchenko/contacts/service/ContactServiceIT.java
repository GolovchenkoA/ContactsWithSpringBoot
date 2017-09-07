package ua.artem.golovchenko.contacts.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.artem.golovchenko.contacts.dao.ContactRepository;

import static org.junit.Assert.assertEquals;

/**
 * Created by Artem on 17.08.2017.
 *
 * @author Artem Golovchenko
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactServiceIT {

    @Autowired
    private ContactServiceImpl service;
    @Autowired
    private ContactRepository repository;

    @Test
    public void testServiceFindAllMustReturnContactsAsRepositoryFindAll() throws Exception {
        assertEquals(repository.findAll(),service.findAll());
    }
}
