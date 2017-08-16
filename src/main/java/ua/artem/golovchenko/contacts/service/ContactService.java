package ua.artem.golovchenko.contacts.service;

import ua.artem.golovchenko.contacts.ContactCRUD;
import ua.artem.golovchenko.contacts.ContactRegExp;
import ua.artem.golovchenko.contacts.model.Contact;

/**
 * Created by Artem on 16.08.2017.
 *
 * @author Artem Golovchenko
 */
public interface ContactService extends ContactCRUD<Contact>,ContactRegExp<Contact> {
}
