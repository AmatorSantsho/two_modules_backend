package by.learning.backend.services;

import by.learning.backend.dto.ContactTo;
import by.learning.backend.models.Contact;
import by.learning.backend.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ContactRepository repository;

    @Override
    public List<ContactTo> findAll() {
        List<ContactTo> contacts = repository.findAll().stream().map(ContactTo::new).collect(Collectors.toList());
        return contacts;
    }

    @Override
    public ContactTo save(ContactTo contactTo) {
        Contact contact = repository.save(
                new Contact(contactTo.getName()
                        , contactTo.getAddress()
                        , contactTo.getCity()
                        , contactTo.getPhone()
                        , contactTo.getEmail()
                        , contactTo.getPassword()));
        return new ContactTo(contact);
    }

    @Override
    public ContactTo getById(String id) {

        Optional<Contact> contact = repository.findById(id);
        return contact.map(ContactTo::new).orElse(null);
    }

    @Override
    public ContactTo update(String id, ContactTo contactTo) {
        Optional<Contact> optcontact = repository.findById(id);
        Contact c = optcontact.get();
        if (contactTo.getName() != null)
            c.setName(contactTo.getName());
        if (contactTo.getAddress() != null)
            c.setAddress(contactTo.getAddress());
        if (contactTo.getCity() != null)
            c.setCity(contactTo.getCity());
        if (contactTo.getPhone() != null)
            c.setPhone(contactTo.getPhone());
        if (contactTo.getEmail() != null)
            c.setEmail(contactTo.getEmail());
        if (contactTo.getPassword() !=null)
            c.setPassword(contactTo.getPassword());
        repository.save(c);
        return new ContactTo(c);
    }

    @Override
    public void delete(String id) {
        Optional<Contact> optcontact = repository.findById(id);
        Contact contact = optcontact.get();
        repository.delete(contact);
    }
}
