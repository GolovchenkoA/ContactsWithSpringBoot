package ua.artem.golovchenko.contacts.model;

import org.springframework.cache.annotation.Cacheable;

/**
 * Created by Artem on 16.08.2017.
 *
 * @author Artem Golovchenko
 */
public interface Contact {

    @Cacheable("id")
    public Long getId();

    public void setId(Long id);

    @Cacheable("city")
    public String getName();

    public void setName(String name);
}
