package ua.artem.golovchenko.contacts.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ContactImplTest {
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

    @Test
    public void testEqualsAndHashCodeSucccess(){
        Contact contact1 = new ContactImpl(1L,"name1");
        Contact contact2 = new ContactImpl(1L,"name1");

        assertTrue(contact1.equals(contact2));
        assertTrue(contact1.hashCode() == contact2.hashCode());
    }

    @Test
    public void testNotEqualsIfContactNull(){
        Contact contact1 = new ContactImpl(1L,"name1");
        Contact obj = null;

        assertFalse(contact1.equals(obj));
    }

    @Test
    public void testNotEqualsIfDifferentIDs(){
        Contact contact1 = new ContactImpl(1L,"name1");
        Contact contact2 = new ContactImpl(2L,"name1");

        assertFalse(contact2.equals(contact1));
    }

    @Test
    public void testNotEqualsIfDifferentNames(){
        Contact contact1 = new ContactImpl(1L,"name1");
        Contact contact2 = new ContactImpl(1L,"name2");

        assertFalse(contact2.equals(contact1));
    }

    @Test
    public void testNotEqualsIfCompareWithNullObject(){
        Contact contact1 = new ContactImpl(1L,"name1");
        assertFalse(contact1.equals(null));
    }


}