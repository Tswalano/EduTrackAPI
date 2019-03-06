package za.co.edutrack.api;

import org.mindrot.jbcrypt.BCrypt;
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
        Student jane = new Student("Jane", "Doeres", "Female", 97870265858574L,
                "jane@gmail.com", "admin123",0617262421, jane_dob.getTime());

        School school1 = new School("Uptown High School", 0151234567, "Townhall City", "123 Street Name", "Nelspruit","Mpumalanga",
                1273,"Enhlanzeni District");
        School school2 = new School("Highland Secondary School", 0131234567, "Daveyton", "321 Street Name", "Benoni","Johannesburg",
                1273,"Eastern District");

        // Hash a password for the first time
        String hashedPassword = BCrypt.hashpw("Admin123", BCrypt.gensalt());
        Users user = new Users("Admin","Admin","admin@admin.com",hashedPassword);

        Grades grades1 = new Grades("GR11",12,2013);
        Grades grades2 = new Grades("GR12",12,2016);

        Subject subject11 = new Subject("isiZulu", "HL", 1, 14);
        Subject subject12 = new Subject("English", "FAL",1, 66);
        Subject subject13 = new Subject("Mathematics", "MATH",1, 65);
        Subject subject14 = new Subject("Physical Sciences", "PSC",1, 78);
        Subject subject15 = new Subject("Life Sciences", "LFC",1, 87);
        Subject subject16 = new Subject("Life Orientation", "LO",1, 89);

        Subject subject111 = new Subject("Sepedi", "HL", 1, 74);
        Subject subject121 = new Subject("English", "FAL",1, 75);
        Subject subject131 = new Subject("Mathematics", "MATH",1, 87);
        Subject subject141 = new Subject("Physical Sciences", "PSC",1, 78);
        Subject subject151 = new Subject("Geography", "GEO",1, 42);
        Subject subject161 = new Subject("Life Orientation", "LO",1, 87);

        grades1.addSubject(subject11);
        grades1.addSubject(subject12);
        grades1.addSubject(subject13);
        grades1.addSubject(subject14);
        grades1.addSubject(subject15);
        grades1.addSubject(subject16);

        grades2.addSubject(subject111);
        grades2.addSubject(subject121);
        grades2.addSubject(subject131);
        grades2.addSubject(subject141);
        grades2.addSubject(subject151);
        grades2.addSubject(subject161);

        john.addGrades(grades1);
        jane.addGrades(grades2);

        school1.addStudent(john);
        school2.addStudent(jane);
        school1.addUsers(user);

        this.studentRepository.save(john);
        this.studentRepository.save(jane);

    }
}
