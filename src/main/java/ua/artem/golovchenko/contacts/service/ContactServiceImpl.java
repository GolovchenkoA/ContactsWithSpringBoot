package ua.artem.golovchenko.contacts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import ua.artem.golovchenko.contacts.dao.ContactRepository;
import ua.artem.golovchenko.contacts.model.Contact;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Artem on 16.08.2017.
 *
 * @author Artem Golovchenko
 */
@org.springframework.stereotype.Service
public class ContactServiceImpl implements ContactService {
    private static final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);
    private ContactRepository repository;


    @Autowired
    public ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
        logger.info("CLASS CONSTRUCTOR: repository: {}", repository);
    }

    @Override
    @Cacheable("getByRegexp")
    public List<Contact> getByRegexp(String regexp, Boolean match) {
        logger.debug("Method call getByRegexp({},{})", regexp, match);
        Pattern pattern = Pattern.compile(regexp);
        List<Contact> all = this.findAll();
        List<Contact> result = new LinkedList<>();
        System.out.println("getByRegexp() All contacts: " + all);

        if(match == true){
            result =  matcher(all,pattern);
            System.out.println("getByRegexp() Filtered contacts: " + result);
        } else if (match == false) {
            List<Contact> matching = matcher(all, pattern);
            all.removeAll(matching);
            result = all;
        }
        return result;
    }

    @Override
    public List<Contact> findAll() {
        logger.debug("Method call findAll()");
        return repository.findAll();
    }

    private List<Contact> matcher(List<Contact> all, Pattern pattern) {
        return all.stream().filter(row -> pattern.matcher(row.getName()).matches()).collect(Collectors.toList());
    }
}
