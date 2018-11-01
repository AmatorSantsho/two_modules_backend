package by.learning.backend.services;

import by.learning.backend.dto.ContactTo;

public interface LoginService {
    public ContactTo findByNameAndPassword(String name, String password);
}
