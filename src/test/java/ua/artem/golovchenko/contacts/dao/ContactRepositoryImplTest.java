package ua.artem.golovchenko.contacts.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.artem.golovchenko.contacts.DbUtilsForTest;
import ua.artem.golovchenko.contacts.model.Contact;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactRepositoryImplTest {


    @Autowired
    private ContactRepository repository;
    private List<Contact> expectedContacts;

    @Before
    public void init(){
        expectedContacts = DbUtilsForTest.getExpectedDbRows();
    }


    @Test
    public void testFindAll() throws Exception {
        List<Contact> actualContacts = repository.findAll();
        assertEquals(expectedContacts.size(), actualContacts.size());

        assertEquals(expectedContacts.get(1), actualContacts.get(1));
        int i = 0;
        for(Object row: actualContacts){
            System.out.println(expectedContacts.get(i) +" " + row);
            assertEquals(expectedContacts.get(i++), row);
        }
    }
}