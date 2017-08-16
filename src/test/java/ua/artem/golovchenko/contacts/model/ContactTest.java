package ua.artem.golovchenko.contacts.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContactTest {
    private static Long id;
    private static String name;

    @Before
    public void init(){
        id = 1L;
        name = "name";
    }

    @Test
    public void testCreateContactWithParams1(){
        ContactImpl contactImpl = new ContactImpl(name);
        assertEquals(name, contactImpl.getName());
    }

    @Test
    public void testCreateContactWithParams2(){
        ContactImpl contactImpl = new ContactImpl(id,name);
        assertEquals(id, (Long) contactImpl.getId());
        assertEquals(name, contactImpl.getName());
    }

}