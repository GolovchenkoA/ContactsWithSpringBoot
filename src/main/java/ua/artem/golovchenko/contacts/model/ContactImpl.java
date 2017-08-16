package ua.artem.golovchenko.contacts.model;

import java.io.Serializable;

/**
 * Created by Artem on 15.08.2017.
 *
 * @author Artem Golovchenko
 */
public class ContactImpl implements Contact,Serializable {
    private Long id;
    private String name;

    public ContactImpl(){}

    public ContactImpl(String name) {
        this.name = name;
    }

    public ContactImpl(Long id, String name) {
        this.id = id; this.name = name;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {return id;}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id: " + id + " name: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactImpl contact = (ContactImpl) o;

        if (id != null ? !id.equals(contact.id) : contact.id != null) return false;
        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
