package za.co.edutrack.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import za.co.edutrack.api.model.Student;
import za.co.edutrack.api.repository.StudentRepository;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Student>> getStudents() {
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        Student student = studentRepository.findOne(id);

        if (student != null) {
            return new ResponseEntity<>(studentRepository.findOne(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>((Student) null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
        studentRepository.delete(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/school", method = RequestMethod.GET)
    public ResponseEntity<Collection<Student>> getStudentSchool(@PathVariable long id) {
        Student student = studentRepository.findOne(id);

        if (student != null) {
            return new ResponseEntity(student.getSchool(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>((Collection<Student>) null, HttpStatus.NOT_FOUND);
        }
    }

}
