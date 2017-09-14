package ua.artem.golovchenko.contacts.web.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.artem.golovchenko.contacts.dao.ContactRepository;
import ua.artem.golovchenko.contacts.model.Contact;
import ua.artem.golovchenko.contacts.service.ContactService;

import java.util.List;

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
    private final ContactRepository contactRepository;

    @Autowired
    public ContactsController(@Autowired ContactService contactService,@Autowired ContactRepository contactRepository) {
        this.contactService = contactService;
        this.contactRepository = contactRepository;
    }

    @RequestMapping(value = "contacts",
            method = RequestMethod.GET)
    public ResponseEntity getFilteredContacts(@RequestParam(value="nameFilter") String filter ){

        logger.debug("Method call getContacts with param : {}", filter );

        try{
            List<Contact> contacts = contactService.getByRegexp(filter, false);
            logger.debug("return HttpStatus.OK");
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            logger.info("Invalid regexp: {}", filter );
            logger.info("Return HttpStatus.BAD_REQUEST");
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            logger.info("Return HttpStatus.INTERNAL_SERVER_ERROR");
            logger.info("Request error. StackTrase: {}", e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
