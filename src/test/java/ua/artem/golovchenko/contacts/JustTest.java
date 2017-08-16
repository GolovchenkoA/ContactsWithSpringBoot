package ua.artem.golovchenko.contacts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import ua.artem.golovchenko.contacts.model.Contact;
import ua.artem.golovchenko.contacts.model.ContactImpl;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Artem on 16.08.2017.
 *
 * @author Artem Golovchenko
 */
public class JustTest {

    @Test
    public void testGetByRegexp() throws Exception {


/*        File currFile = new File(getClass().getClassLoader().getResource("db/data/contacts.json").getFile());
        ObjectMapper objectMapper = new ObjectMapper();
        Contact contact = objectMapper.readValue(currFile, ContactImpl.class);
        System.out.println(contact);
        */
        File currFile = new File(getClass().getClassLoader().getResource("db/data/contacts.json").getFile());
        ObjectMapper objectMapper = new ObjectMapper();
        List<Contact> contacts = objectMapper.readValue(currFile, new TypeReference<List<ContactImpl>>(){});
        System.out.println(contacts);

    }

    @Test
    public void lal(){
        List<Contact> contactsMustBe = DbUtilsForTest.getExpectedDbRows()
                .stream().filter(contact -> contact.getName().startsWith("A"))
                .collect(Collectors.toList());

        List<Contact> contactsMustBe2 = DbUtilsForTest.getExpectedDbRows()
        .stream().filter(contact -> !(contact.getName().startsWith("A")))
        .collect(Collectors.toList());


        System.out.println(contactsMustBe);
        System.out.println(contactsMustBe2);
    }
}
