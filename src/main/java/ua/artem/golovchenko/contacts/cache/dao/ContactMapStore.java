package ua.artem.golovchenko.contacts.cache.dao;

import com.hazelcast.core.MapStore;
import ua.artem.golovchenko.contacts.model.Contact;

/**
 * Created by Artem on 18.08.2017.
 *
 * @author Artem Golovchenko
 */
public interface ContactMapStore extends MapStore<Long,Contact> {
}
