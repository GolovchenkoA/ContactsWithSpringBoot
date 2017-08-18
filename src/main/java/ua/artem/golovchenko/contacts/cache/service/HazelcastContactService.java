package ua.artem.golovchenko.contacts.cache.service;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.artem.golovchenko.contacts.model.Contact;
import ua.artem.golovchenko.contacts.service.ContactService;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * Contact Service with Cache client
 * Client settings file : src/main/java/resources/hazelcast-client.xml
 *
 * @see 'https://blog.hazelcast.com/spring-boot/'
 *
 * Created by Artem on 17.08.2017.
 * @author Artem Golovchenko
 */
@Service
@Qualifier("cache")
public class HazelcastContactService implements ContactService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private IMap<Long,Contact> contactIMap;

    public HazelcastContactService() {
/*        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress("127.0.0.1");*/
        HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient();
        /*contactIMap = hazelcastInstance.getMap("contacts");*/
        contactIMap = hazelcastInstance.getMap("contacts");
        logger.debug("Class constructor: cache: {}", hazelcastInstance.toString());
    }

    @Override
    public List<Contact> findAll() {
        return contactIMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<Contact> getByRegexp(String regexp, Boolean match) {

        logger.debug("Method call getByRegexp({},{})", regexp, match);
        Pattern pattern = Pattern.compile(regexp);
        List<Contact> all = this.contactIMap.values().stream().collect(Collectors.toList());
        List<Contact> result = new LinkedList<>();
        logger.debug("getByRegexp() All contacts: {}", all);

        if(match == true){
            result =  matcher(all,pattern);
            logger.debug("getByRegexp() Filtered contacts: {}", result);
        } else if (match == false) {
            List<Contact> matching = matcher(all, pattern);
            all.removeAll(matching);
            result = all;
        }
        return result;
    }

    private List<Contact> matcher(List<Contact> all, Pattern pattern) {
        return all.stream().filter(row -> pattern.matcher(row.getName()).matches()).collect(Collectors.toList());
    }
}
