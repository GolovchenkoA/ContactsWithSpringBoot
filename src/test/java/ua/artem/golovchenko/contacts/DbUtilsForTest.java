package ua.artem.golovchenko.contacts;

import ua.artem.golovchenko.contacts.model.Contact;
import ua.artem.golovchenko.contacts.model.ContactImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Данные для unit-тестов (без использования БД)
 *
 *
 * Created by Artem on 16.08.2017.
 * @author Artem Golovchenko
 */
public class DbUtilsForTest {

    private DbUtilsForTest(){}

    public static List<Contact> getExpectedDbRows(){
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new ContactImpl(1L, "Artem"));
        contacts.add(new ContactImpl(2L, "Oleg"));
        contacts.add(new ContactImpl(3L, "Olya"));
        contacts.add(new ContactImpl(4L, "Petya"));

        return contacts;
    }
}
