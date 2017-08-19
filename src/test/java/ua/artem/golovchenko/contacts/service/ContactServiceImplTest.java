package ua.artem.golovchenko.contacts.service;

/*@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration( classes=Application.class)*/

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContactRegExpTest.class,
        ContactServiceMainTest.class

})

public class ContactServiceImplTest {

}