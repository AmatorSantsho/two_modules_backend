package by.learning.backend.controllers;

import by.learning.backend.dto.ContactTo;
import by.learning.backend.dto.Login;
import by.learning.backend.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    private LoginService service;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ContactTo login(@RequestBody Login login) {
        return service.findByNameAndPassword(login.getName(), login.getPassword());
    }
}
