package ua.artem.golovchenko.contacts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication//(excludeName = {"org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration"})
@EnableCaching
//@ImportResource({"classpath:/context-tx.xml"})
//@ComponentScan("ua.artem.golovchenko")
//@EnableAutoConfiguration(exclude = {EmbeddedServletContainerAutoConfiguration.class, WebMvcAutoConfiguration.class})
public class Application  {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }
}