package by.learning.backend.controllers;

import by.learning.backend.dto.ContactTo;
import by.learning.backend.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProfilesController {
    @Autowired
    private ProfileService service;

    @RequestMapping(method = RequestMethod.GET, value = "/contacts")
    public List<ContactTo> contacts() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/contacts")
    public ContactTo save(@RequestBody ContactTo contactTo) {
        return service.save(contactTo);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/contacts/{id}")
    public ContactTo show(@PathVariable String id) {
        return service.getById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/contacts/{id}")
    public ContactTo update(@PathVariable String id, @RequestBody ContactTo contactTo) {
        return service.update(id, contactTo);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/contacts/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }


}
