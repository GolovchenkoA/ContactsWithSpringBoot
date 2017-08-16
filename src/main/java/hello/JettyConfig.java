package hello;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by Artem on 15.08.2017.
 *
 * @author Artem Golovchenko
 */


@Component
public class JettyConfig extends ResourceConfig  {

    public JettyConfig() {
        register(ContactsController.class);
    }

}
