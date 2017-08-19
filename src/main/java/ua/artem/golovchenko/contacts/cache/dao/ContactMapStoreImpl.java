package ua.artem.golovchenko.contacts.cache.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.artem.golovchenko.contacts.dao.ContactRepository;
import ua.artem.golovchenko.contacts.dao.DataManager;
import ua.artem.golovchenko.contacts.model.Contact;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Artem on 17.08.2017.
 *
 * @author Artem Golovchenko
 */

public class ContactMapStoreImpl implements ContactMapStore {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private ContactRepository repository;

    public ContactMapStoreImpl() {
        logger.debug("Class constructor call");
        repository = DataManager.getRepository();
        logger.debug("Class constructor call. repository: {}", repository);
    }


    @Override
    public void store(Long aLong, Contact contact) {

    }

    @Override
    public void storeAll(Map<Long, Contact> map) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void deleteAll(Collection<Long> collection) {

    }

    @Override
    public Contact load(Long aLong) {
        return null;
    }

    @Override
    public Map<Long, Contact> loadAll(Collection<Long> collection) {
        return repository.findAll().stream().collect(Collectors.toMap(Contact::getId, c -> c));
    }

    @Override
    public Iterable<Long> loadAllKeys() {
        //logger.info("Iterable<Long> loadAllKeys(). getRepository(): {}", );
        logger.debug("Iterable<Long> loadAllKeys(). repository: {}", repository);
        return this.repository.findAll().stream().map(c -> c.getId()).collect(Collectors.toList());
    }

    public List<Contact> findAll() {return this.repository.findAll();}


}
