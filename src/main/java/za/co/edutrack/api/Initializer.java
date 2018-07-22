package za.co.edutrack.api;

import za.co.edutrack.api.model.School;
import za.co.edutrack.api.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import za.co.edutrack.api.model.Subject;
import za.co.edutrack.api.repository.StudentRepository;

import java.util.Calendar;

@Component
public class Initializer implements CommandLineRunner{

    private StudentRepository studentRepository;

    @Autowired
    public Initializer(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        Calendar john_dob = Calendar.getInstance();
        john_dob.set(1995, Calendar.SEPTEMBER, 10);
        Calendar jane_dob = Calendar.getInstance();
        john_dob.set(1996, Calendar.MAY, 5);

        Student john = new Student("Glen", "Mogane", "Male", "moganegb@gmail.com",
                "Tswalano", "admin",0617262421L, john_dob.getTime());
        Student jane = new Student("Jane", "Doe", "Female", "jane@gmail.com",
                "Jane", "janeadmin",0617262421L, jane_dob.getTime());

        School john_school1 = new School("L.M Kganane Sec. School", "Grade 10", 2011);
        School john_school2 = new School("L.M Kganane Sec. School", "Grade 11", 2012);
        School john_school3 = new School("L.M Kganane Sec. School", "Grade 12", 2013);

        School jane_school1 = new School("High Eagle Secondary School", "Grade 11", 2013);
        School jane_school2 = new School("High Eagle Secondary School", "Grade 12", 2014);

        Subject subject11 = new Subject("Home Language", "Term 1", 74);
        Subject subject12 = new Subject("English", "Term 1", 66);
        Subject subject13 = new Subject("Mathematics", "Term 1", 65);
        Subject subject14 = new Subject("Physical Sciences", "Term 1", 78);
        Subject subject15 = new Subject("Life Sciences", "Term 1", 87);

        Subject subject21 = new Subject("Home Language", "Term 1", 75);
        Subject subject22 = new Subject("English", "Term 1", 66);
        Subject subject23 = new Subject("Mathematics", "Term 1", 78);
        Subject subject24 = new Subject("Physical Sciences", "Term 1", 58);
        Subject subject25 = new Subject("Life Sciences", "Term 1", 60);

        Subject subject1 = new Subject("Home Language", "Term 1", 88);
        Subject subject2 = new Subject("English", "Term 1", 78);
        Subject subject3 = new Subject("Mathematics", "Term 1", 69);
        Subject subject4 = new Subject("Physical Sciences", "Term 1", 76);
        Subject subject5 = new Subject("Life Sciences", "Term 1", 67);

        john_school1.addSubject(subject11);
        john_school1.addSubject(subject12);
        john_school1.addSubject(subject13);
        john_school1.addSubject(subject14);
        john_school1.addSubject(subject15);

        john_school2.addSubject(subject21);
        john_school2.addSubject(subject22);
        john_school2.addSubject(subject23);
        john_school2.addSubject(subject24);
        john_school2.addSubject(subject25);

        john_school3.addSubject(subject1);
        john_school3.addSubject(subject2);
        john_school3.addSubject(subject3);
        john_school3.addSubject(subject4);
        john_school3.addSubject(subject5);

        john.addSchool(john_school1);
        john.addSchool(john_school2);
        john.addSchool(john_school3);

        jane.addSchool(jane_school1);
        jane.addSchool(jane_school2);

        this.studentRepository.save(john);
        this.studentRepository.save(jane);

    }
}
