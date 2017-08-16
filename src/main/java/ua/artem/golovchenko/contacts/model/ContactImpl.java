package ua.artem.golovchenko.contacts.model;

/**
 * Created by Artem on 15.08.2017.
 *
 * @author Artem Golovchenko
 */
public class ContactImpl implements Contact {
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
        return "Contact {" +
                "id:" + id + '\'' +
                "name='" + name + '\'' +
                '}';
    }

}
