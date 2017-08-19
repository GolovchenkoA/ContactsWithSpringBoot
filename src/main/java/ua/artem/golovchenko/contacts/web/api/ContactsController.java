package ua.artem.golovchenko.contacts.web.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.artem.golovchenko.contacts.dao.ContactRepository;
import ua.artem.golovchenko.contacts.model.Contact;
import ua.artem.golovchenko.contacts.service.ContactService;

/**
 * Created by Artem on 15.08.2017.
 *
 * @author Artem Golovchenko
 */
@RestController
@RequestMapping("/hello")
public class ContactsController {
    private static final Logger logger = LoggerFactory.getLogger(ContactsController.class);
    private final ContactService contactService;
    private final ContactService contactServiceCache;
    private final ContactRepository contactRepository;

    @Autowired
    ContactsController(@Autowired @Qualifier("jdbc") ContactService contactService,
                       @Autowired @Qualifier("cache")ContactService contactServiceCache,
                       @Autowired ContactRepository contactRepository) {
        this.contactService = contactService;
        this.contactServiceCache = contactServiceCache;
        this.contactRepository = contactRepository;
    }

    @RequestMapping(value = "contacts",
            method = RequestMethod.GET)
    public Iterable<Contact> getContactWithFilter(@RequestParam(value="nameFilter") String filter){
        logger.debug("Method call getContacts with param : {}", filter);
        return contactService.getByRegexp(filter, false);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Contact> findAll(){
        logger.debug("Method call findAll()");
        System.out.println(contactService.findAll());
        return contactService.findAll();
    }

    @RequestMapping(value = "contacts/cache",method = RequestMethod.GET)
    public Iterable<Contact> findAllWithCache(){
        logger.debug("Method call findAllWithCache()");
        return contactRepository.findAll();
    }

    // Original with Service
/*    @RequestMapping(value = "contacts/cache",method = RequestMethod.GET)
    public Iterable<Contact> findAllWithCache(){
        logger.debug("Method call findAllWithCache()");
        return contactServiceCache.findAll();
    }*/

/*
    @RequestMapping(value = "contacts/cache",method = RequestMethod.GET)
    public Iterable<Contact> getContactWithReverseFilterWithCache(@RequestParam(value="nameFilter") String filter){
        logger.debug("Method call getContactWithFilterWithCache()");
        return contactServiceCache.getByRegexp(filter,false);
    }
*/



}
