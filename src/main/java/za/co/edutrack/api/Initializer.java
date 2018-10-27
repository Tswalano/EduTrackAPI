package za.co.edutrack.api;

import org.apache.catalina.User;
import za.co.edutrack.api.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
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
        jane_dob.set(1996, Calendar.MAY, 5);

        Student john = new Student("David", "Van Jake", "Male", 9309106101083L,
                "david001@gmail.com", "admin123",0617262421, john_dob.getTime());
        Student jane = new Student("Phill", "Doeres", "Male", 97870265858574L,
                "jane@gmail.com", "admin123",0617262421, jane_dob.getTime());

        School school1 = new School("Uptown High School", 0151234567, "Townhall City", "123 Street Name", "Nelspruit","Mpumalanga",
                1273,"Enhlanzeni District");
        School school2 = new School("Highland Secondary School", 0131234567, "Daveyton", "321 Street Name", "Benoni","Johannesburg",
                1273,"Eastern District");

        Grades grades1 = new Grades("GR11",12,2013);
        Grades grades2 = new Grades("GR12",12,2016);

        Subject subject11 = new Subject("Home Language", "HL", 1, 74);
        Subject subject12 = new Subject("First Additional English", "FAL",1, 66);
        Subject subject13 = new Subject("Mathematics", "MATH",1, 65);
        Subject subject14 = new Subject("Physical Sciences", "PSC",1, 78);
        Subject subject15 = new Subject("Life Sciences", "LFC",1, 87);

        Subject subject111 = new Subject("isiZulu", "HL", 1, 74);
        Subject subject121 = new Subject("First Additional English", "FAL",1, 75);
        Subject subject131 = new Subject("Mathematics", "MATH",1, 87);
        Subject subject141 = new Subject("Physical Sciences", "PSC",1, 78);
        Subject subject151 = new Subject("Geography", "GEO",1, 42);

        grades1.addSubject(subject11);
        grades1.addSubject(subject12);
        grades1.addSubject(subject13);
        grades1.addSubject(subject14);
        grades1.addSubject(subject15);

        grades2.addSubject(subject111);
        grades2.addSubject(subject121);
        grades2.addSubject(subject131);
        grades2.addSubject(subject141);
        grades2.addSubject(subject151);

        school1.addGrades(grades1);
        school2.addGrades(grades2);

        john.addSchool(school1);
        jane.addSchool(school2);

        this.studentRepository.save(john);
        this.studentRepository.save(jane);

    }
}
