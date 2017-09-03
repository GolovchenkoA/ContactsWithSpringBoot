package ua.artem.golovchenko.contacts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Artem on 30.08.2017.
 *
 * @author Artem Golovchenko
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationIT {
    
    @Test
    public void test(){
        assertEquals(1, 1);
    }

}
