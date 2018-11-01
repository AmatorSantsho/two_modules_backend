package by.learning.backend.services;

import by.learning.backend.dto.ContactTo;

import java.util.List;

public interface ProfileService {
    public List<ContactTo> findAll();

    public ContactTo save(ContactTo contactTo);

    public ContactTo getById(String id);

    public ContactTo update(String id, ContactTo contactTo);

    public void delete(String id);
}
