package hello;

/**
 * Created by Artem on 15.08.2017.
 *
 * @author Artem Golovchenko
 */
public class Contact {
    private long id;
    private String name;

    public Contact(long id, String name) {
        this.id = id;
        this.name = name;

    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, Name='%s']",
                id, name);
    }
}
