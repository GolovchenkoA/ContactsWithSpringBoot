package ua.artem.golovchenko.contacts.web.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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


    @Autowired
    ContactsController(ContactService contactService) {
        this.contactService = contactService;
    }


    @RequestMapping(value = "contacts",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus getContactWithFilter(@RequestParam(value="nameFilter") String filter){

        logger.info("Method call getContacts with param : {}", filter);
        //return new ResponseEntity<Collection<Contact>>(contacts, HttpStatus.OK);
        //contactService.getByRegexp(filter,false);
        System.out.println(contactService.findAll());
        return HttpStatus.OK;
    }

        @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus findAll(){

        logger.info("Method call findAll()");
        //return new ResponseEntity<Collection<Contact>>(contacts, HttpStatus.OK);
        //contactService.getByRegexp(filter,false);
        System.out.println(contactService.findAll());
        return HttpStatus.OK;
    }



/*    @RequestMapping(value = "/hello/contactsAll",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Contact>> getContacts(){
        Collection<Contact> contacts = service.getAll();
        return new ResponseEntity<Collection<Contact>>(contacts, HttpStatus.OK);
    }*/
}
