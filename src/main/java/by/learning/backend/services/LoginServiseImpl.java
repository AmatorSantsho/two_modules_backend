package by.learning.backend.services;

import by.learning.backend.dto.ContactTo;
import by.learning.backend.models.Contact;
import by.learning.backend.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiseImpl implements LoginService {
    @Autowired
    private ContactRepository repository;
    @Override
    public ContactTo findByNameAndPassword(String name, String password){
        Contact contact=repository.findByNameAndPassword(name,password);
        if (contact!=null)
            return new ContactTo(contact);
        else
            return new ContactTo("Unauth","","","","Unauth","");
    }
}
