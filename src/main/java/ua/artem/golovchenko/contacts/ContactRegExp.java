package ua.artem.golovchenko.contacts;

import java.util.List;

/**
 * Created by Artem on 16.08.2017.
 *
 * @author Artem Golovchenko
 */
public interface ContactRegExp<T> {
    List<T> getByRegexp(String regexp, Boolean match);
}
