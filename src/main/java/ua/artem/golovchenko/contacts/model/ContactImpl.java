package ua.artem.golovchenko.contacts.model;

/**
 * Created by Artem on 15.08.2017.
 *
 * @author Artem Golovchenko
 */
public class ContactImpl implements Contact {
    private long id;
    private String name;

    public ContactImpl(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ContactImpl(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, Name='%s']",
                id, name);
    }
}
