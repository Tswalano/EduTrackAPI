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
import za.co.edutrack.api.repository.SchoolRepository;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

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

}
