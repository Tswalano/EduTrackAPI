package za.co.edutrack.api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.edutrack.api.model.School;
import za.co.edutrack.api.model.Users;
import za.co.edutrack.api.repository.SchoolRepository;
import za.co.edutrack.api.repository.UsersRepository;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;
    private UsersRepository usersRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<School>> getSchools() {
        return new ResponseEntity<>(schoolRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<School> getSchool(@PathVariable long id) {
        School school = schoolRepository.findOne(id);

        if (school != null) {
            return new ResponseEntity<>(schoolRepository.findOne(id), HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addSchool(@RequestBody School school) {
        return new ResponseEntity<>(schoolRepository.save(school), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSchool(@PathVariable long id) {
        schoolRepository.delete(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/users", method = RequestMethod.GET)
    public ResponseEntity<Collection<School>> getSchoolUsers(@PathVariable long id) {
        School school = schoolRepository.findOne(id);

        if (school != null) {
            return new ResponseEntity(school.getUsers(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>((Collection<School>) null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<Users> getUsers() {
        return new ResponseEntity<Users>((Users) usersRepository.findAll(), HttpStatus.OK);
    }

}
